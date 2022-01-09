package netty.nio.nioserverclient;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * NIO非阻塞网络编程 客户端
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/3
 */
public class NIOClient {
    public static void main(String[] args) throws Exception {
        // 得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置非阻塞
        socketChannel.configureBlocking(false);
        // 提供服务器端口和ip
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        // 连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞");
            }
        }
        // 连接成功，发送数据
        String str = "Hello ...";
        // Wraps a byte array into a buffer.
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));

        // 发送数据
        socketChannel.write(byteBuffer);
        // 代码停止在这里
        System.in.read();
    }
}
