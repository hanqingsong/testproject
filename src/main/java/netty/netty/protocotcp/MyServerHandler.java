package netty.netty.protocotcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/10
 */
public class MyServerHandler  extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol msg) throws Exception {

        int len = msg.getLen();
        byte[] content = msg.getContent();



        System.out.println("服务器接收数据：len=" + len);
        System.out.println("服务器接收数据：msg=" + new String(content, CharsetUtil.UTF_8));

        System.out.println("服务器接收消息数量：" + (++this.count));

//        //回送数据给客户端
        String responseContent = UUID.randomUUID().toString();
        byte[] bytes = responseContent.getBytes(StandardCharsets.UTF_8);
        // 构建协议包
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(bytes.length);
        messageProtocol.setContent(bytes);
        channelHandlerContext.writeAndFlush(messageProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
