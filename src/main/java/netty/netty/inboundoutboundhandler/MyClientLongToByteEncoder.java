package netty.netty.inboundoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/10
 */
public class MyClientLongToByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Long aLong, ByteBuf out) throws Exception {
        System.out.println("MyLongToByteEncoder encode被调用");
        System.out.println("msg:" + aLong);

        out.writeLong(aLong);
    }
}
