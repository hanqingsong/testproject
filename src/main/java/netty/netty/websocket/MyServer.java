package netty.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import netty.netty.heartbeat.MyServerHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/9
 */
public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        //创建两个线程组 boosGroup、workerGroup
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            // 基于http协议，使用http的编码解码器
                            pipeline.addLast(new HttpServerCodec());
                            // 以块方式些，添加ChunkedWriteHandler处理器
                            pipeline.addLast(new ChunkedWriteHandler());
                            /*
                             * http数据传输过程中是分段的，HttpObjectAggregator就是可以将多个段聚合起来
                             * 浏览器发送大量数据时，会分段发送
                             */
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            /*
                             * 1.对应websocket，它的数据是以帧frame的形式发送
                             * 2. WebSocketFrame下面有六个子类
                             * 3.浏览器发送请求是，ws://localhost:7000/xxxx
                             * 4.WebSocketServerProtocolHandler核心功能将http协议升级为ws协议，保持长连接
                             * 5.是通过一个状态码 101
                             */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));
                            // 自定义handler，处理业务逻辑
                            pipeline.addLast(new MyTextWebSocketFrameHandler());
                        }
                    });

            System.out.println("server 服务端启动完毕");
            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
