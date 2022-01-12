package netty.netty.inboundoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/10
 */
public class MyServerByteToLongDecoder2 extends ReplayingDecoder<Void> {
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
        System.out.println("MyServerByteToLongDecoder2 decode");
//        // long 为8个字节，8个字节才能读取为一个long
//        if (in.readableBytes() >= 8) {
//            out.add(in.readLong());
//        }
        // 在ReplayingDecoder不需啊哟判断数据是否足够读取，内部会进行判断处理
        out.add(in.readLong());
    }
}
