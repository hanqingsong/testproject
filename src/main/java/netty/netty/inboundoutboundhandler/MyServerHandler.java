package netty.netty.inboundoutboundhandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/10
 */
public class MyServerHandler  extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long aLong) throws Exception {
        System.out.println("从客户端" + channelHandlerContext.channel().remoteAddress() + "读取到long：" + aLong);
        // 给客户端发送long
        channelHandlerContext.writeAndFlush(4322L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
