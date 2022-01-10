package netty.netty.codec2;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import netty.netty.codec.StudentPOJO;

/**
 * 自定义的Handler需要继承Netty规定好的HandlerAdapter
 * 才能被Netty框架所关联，有点类似SpringMVC的适配器模式
 *
 * @author hanqingsong
 * @version 1.0
 * @date 2021/11/3
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MyStudentPOJO.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyStudentPOJO.MyMessage myMessage) throws Exception {

        if (myMessage.getDataType() == MyStudentPOJO.MyMessage.DataType.StudentType) {
            MyStudentPOJO.Student student = myMessage.getStudent();
            System.out.println("客户端发送的数据：学生 id=" + student.getId() + " name:" + student.getName());

        }else if(myMessage.getDataType() == MyStudentPOJO.MyMessage.DataType.workerType) {
            MyStudentPOJO.Worker worker = myMessage.getWorker();
            System.out.println("客户端发送的数据：工人 age=" + worker.getAge() + " name:" + worker.getName());

        }else {
            System.out.println("客户端发送的数据类型不对");

        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //发送消息给客户端
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端已收到消息，并给你发送一个问号?", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //发生异常，关闭通道
        ctx.close();
    }
}