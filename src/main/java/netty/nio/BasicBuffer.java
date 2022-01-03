package netty.nio;


import java.nio.IntBuffer;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/2
 */
public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        // 将buffer转换，读写切换
        intBuffer.flip();

        // 从buffer读数据
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
