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
public class NIOFileChannel03TransferFrom {
    public static void main(String[] args) throws Exception {

        File file = new File("./file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取channel
        FileChannel channel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("./file02.txt");
        FileChannel channel2 = fileOutputStream.getChannel();

        channel2.transferFrom(channel, 0, channel.size());

        channel2.close();
        channel.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
