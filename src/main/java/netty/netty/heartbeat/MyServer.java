package netty.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

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
                            // netty 提供的处理空闲状态的处理器
                            // long readerIdleTime, 表示多长时间没有读，就会发送一个心跳检测包，检查是否还是连接的状态
                            // long writerIdleTime, 表示多长时间没有写，就会发送一个心跳检测包，检查是否还是连接的状态
                            // long allIdleTime，表示多长时间没有读写，就会发送一个心跳检测包，检查是否还是连接的状态
                            // idle触发后，会传递给下一个handler去处理，会触发下一个handler的userEventTrigger方法去处理
                            pipeline.addLast(new IdleStateHandler(3, 5, 7, TimeUnit.SECONDS));
                            // 加入一个对空闲检测的handler（自定义）
                            pipeline.addLast(new MyServerHandler());

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
