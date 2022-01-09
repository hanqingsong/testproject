package netty.nio.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * java IO 客户端
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/3
 */
public class NewIOClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 7000));

        String fileName = "./file01.txt";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();
        // linux下一个 transfer to方法可以完成传输
        // windows下一次调用transferto只能发送8M
        // transferTo底层使用零拷贝
        long transferTo = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送总字节数：" + transferTo + ",耗时：" + (System.currentTimeMillis() - startTime));

        fileChannel.close();

    }
}
