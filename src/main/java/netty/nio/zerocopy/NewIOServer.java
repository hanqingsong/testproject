package netty.nio.zerocopy;

import java.io.DataInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/3
 */
public class NewIOServer {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(7000));

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();

            int readCount = 0;
            while (!(readCount == -1)) {
                try {
                    readCount = socketChannel.read(byteBuffer);

                } catch (Exception e) {
                    // e.printStackTrace();
                    break;
                }

                byteBuffer.rewind();
            }
        }


    }
}
