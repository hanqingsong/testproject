package netty.netty.inboundoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/10
 */
public class MyServerByteToLongDecoder extends ByteToMessageDecoder {
    /**
     *
     *
     * @param channelHandlerContext channelHandlerContext 上下文
     * @param in byteBuf byteBuf 入站的ByteBuf
     * @param  out list list 将解码后的数据传给下一个handler
     * @return void
     * @author hanqingsong
     * @date 2022/1/10
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyServerByteToLongDecoder decode");
        // long 为8个字节，8个字节才能读取为一个long
        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }
    }
}
