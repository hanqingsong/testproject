package netty.nio.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * java IO 客户端
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/3
 */
public class OldIOClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("loocalhost", 7001);
        String fileName = "./file01.txt";
        FileInputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] byteArray = new byte[4096];
        long readCount ;
        long total = 0;
        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(byteArray)) >= 0) {
            total += readCount;
            dataOutputStream.write(byteArray);
        }

        System.out.println("发送总字节数：" + total + ",耗时：" + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
