package netty.nio.nioserverclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO非阻塞网络编程 服务端
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/3
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        // 创建serverSocketChannel ->serverSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 得到一个selector对象
        Selector selector = Selector.open();
        // 绑定端口，在服务器端监听
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(6666));
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 把serverSocketChannel注册到selector，关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 循环等待客户端连接
        while (true) {
            // 等待一秒
            if (selector.select(1000) == 0) {
                // 没有事件发生
                System.out.println("服务器等待了1秒，没有连接");
                continue;
            }
            // 如果返回数量>0，获取相关的 selectedKeys集合，获取到了关注的事件集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 遍历selectionKeys
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                // 根据key对应的通道发生的事件做相应的处理
                if (selectionKey.isAcceptable()) { // OP_ACCEPT
                    // 得到socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成一个socketChannel"+socketChannel.hashCode());
                    // 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    // 将socketChannel注册到selector上，关注事件OP_READ，
                    // 同时给SocketChannel关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(10));
                }

                if (selectionKey.isReadable()) {// OP_READ
                    // 获取到socketChannel
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    // 获取到channel关联的Buffer
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    int read = socketChannel.read(byteBuffer);
                    System.out.println("read=" + read);
                    // 避免客户端关闭，服务端循环输出内容
                    if (read == -1) {
                        socketChannel.close();
                        break;
                    }
                    if (read == 0) {
                        break;
                    }
                    System.out.println("from客户端 "+new String(byteBuffer.array()));
                }
                // 手动从集合中移除当前selectionKey，防止重复操作
                keyIterator.remove();
            }
        }
    }
}
