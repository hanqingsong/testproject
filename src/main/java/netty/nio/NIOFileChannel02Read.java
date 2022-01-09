package netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从文件读入内容转成string
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/2
 */
public class NIOFileChannel02Read {
    public static void main(String[] args) throws Exception {

        File file = new File("./file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取channel
        FileChannel channel = fileInputStream.getChannel();
        // 创建缓冲区 byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        // file -> channel -> byteBuffer -> str


        // 将通道数据读入到缓冲区
        channel.read(byteBuffer);

        // 缓存去数据转成string
        byte[] bytes = byteBuffer.array();
        System.out.println(new java.lang.String(bytes));

        fileInputStream.close();
    }
}
