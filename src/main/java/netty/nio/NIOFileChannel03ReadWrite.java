package netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用一个buffer完成文件读取，完成文件的拷贝
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/2
 */
public class NIOFileChannel03ReadWrite {
    public static void main(String[] args) throws Exception {

        File file = new File("./file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileOutputStream fileOutputStream = new FileOutputStream("./file02.txt");
        FileChannel channel2 = fileOutputStream.getChannel();

        // 获取channel
        FileChannel channel = fileInputStream.getChannel();
        // 创建缓冲区 byteBuffer
        // ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        // file -> channel -> byteBuffer -> channel2 -> file2

        // 将通道数据读入到缓冲区
        // channel.read(byteBuffer);
        // 使用while循环读取，因为不知道文件有多大
        while (true) {
            // 一定先重置标志位
            byteBuffer.clear();
            int read = channel.read(byteBuffer);
            if (read == -1) {
                break;
            }

            // 一定要切换读写
            byteBuffer.flip();
            //将缓冲区数据写入到另一个通道
            channel2.write(byteBuffer);
        }

        //将缓冲区数据写入到另一个通道
        // byteBuffer.flip();
        // channel2.write(byteBuffer);

        fileOutputStream.close();
        fileInputStream.close();
    }
}
