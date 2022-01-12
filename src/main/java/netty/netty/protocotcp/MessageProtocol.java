package netty.netty.protocotcp;

/**
 * 协议包
 *
 * @author hanqingsong
 * @version 1.0
 * @date 2022/1/11
 */
public class MessageProtocol {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
