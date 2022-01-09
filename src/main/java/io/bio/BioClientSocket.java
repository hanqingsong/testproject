package io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/10/18
 */
public class BioClientSocket {
    public static void main(String[] args) throws IOException {
        //创建一个Socket，连接服务端
        Socket socket = new Socket("localhost", 8998);
        //写数据
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String writeMsg = scanner.nextLine();
        outputStream.write(writeMsg.getBytes("utf-8"));
        //关闭连接
        scanner.close();
        socket.close();
    }
}
