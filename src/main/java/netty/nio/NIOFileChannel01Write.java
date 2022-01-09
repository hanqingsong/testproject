package netty.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 将string内容写入到文件
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/2
 */
public class NIOFileChannel01Write {
    public static void main(String[] args) throws Exception {
        String str = "hello 你好";

        FileOutputStream fileOutputStream = new FileOutputStream("./file01.txt");
        // 获取channel
        FileChannel channel = fileOutputStream.getChannel();
        // 创建缓冲区 byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // str -> byteBuffer -> channel -> file

        // 缓存放入数据
        byteBuffer.put(str.getBytes());
        // byteBuffer反转
        byteBuffer.flip();
        // 将缓冲区数据写入到channel
        channel.write(byteBuffer);

        fileOutputStream.close();
    }
}
