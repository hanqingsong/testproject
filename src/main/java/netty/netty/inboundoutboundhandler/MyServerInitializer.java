package netty.netty.inboundoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/10
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        // 入站handler 进行解码 MyByteToLongDecoder
        pipeline.addLast(new MyServerByteToLongDecoder());

        // 出站 handler 进行编码
        pipeline.addLast(new MyClientLongToByteEncoder());

        pipeline.addLast(new MyServerHandler());


    }
}
