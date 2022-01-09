package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/10/18
 */
public class BioServerSocket {
    public static void main(String[] args) throws IOException {
        //创建一个ServerSocket，并指定一个端口号8098
        ServerSocket serverSocket = new ServerSocket(8998);
        System.out.println("服务器启动成功");
        //判断ServerSocket是不是已经关闭了
        while (!serverSocket.isClosed()) {
            //获取客户端的连接
            //accept会阻塞，直到有新的连接过来
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接：" + socket.toString());
            //读取客户端发来的数据
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String readMsg;
            while ((readMsg = reader.readLine()) != null) {
                //读取到数据，就退出循环
                if (readMsg.length() > 0) {
                    break;
                }
            }
            System.out.println("有数据发过来了，来自：" + socket.toString());
            System.out.println("收到客户端的数据：" + readMsg);
        }
        //关闭ServerSocket
        serverSocket.close();
    }
}
