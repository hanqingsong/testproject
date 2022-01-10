package netty.netty.inboundoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/10
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        // 出站 进行编码
        pipeline.addLast(new MyClientLongToByteEncoder());

        // 入站 解码器
        pipeline.addLast(new MyServerByteToLongDecoder());

        pipeline.addLast(new MyClientHandler());

    }
}
