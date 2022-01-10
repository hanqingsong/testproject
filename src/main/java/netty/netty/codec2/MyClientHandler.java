package netty.netty.codec2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import netty.netty.codec.StudentPOJO;

import java.util.Random;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/11/3
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 随机发送一个对象Student 或者 Worker到服务器
        int random = new Random().nextInt(3);
        MyStudentPOJO.MyMessage myMessage = null;
        if (0 == random) {
            // student
            myMessage = MyStudentPOJO.MyMessage.newBuilder()
                    .setDataType(MyStudentPOJO.MyMessage.DataType.StudentType)
                    .setStudent(MyStudentPOJO.Student.newBuilder().setId(33).setName("令狐冲").build())
                    .build();
        } else {
            // worker
            myMessage = MyStudentPOJO.MyMessage.newBuilder()
                    .setDataType(MyStudentPOJO.MyMessage.DataType.workerType)
                    .setWorker(MyStudentPOJO.Worker.newBuilder().setAge(23).setName("老李").build())
                    .build();
        }


        ctx.channel().writeAndFlush(myMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("收到服务端" + ctx.channel().remoteAddress() + "的消息：" + byteBuf.toString(CharsetUtil.UTF_8));
    }
}
