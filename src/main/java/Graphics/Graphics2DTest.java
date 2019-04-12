package Graphics;

import com.alibaba.fastjson.serializer.FilterUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hanqingsong on 2019-04-12.
 *
 * @author hanqingsong
 * @date 2019-04-12
 */
public class Graphics2DTest {
    /**
     * 合成一张图片
     */
    @Test
    public void GraphicsDraw() {
        File file = new File("/Users/hanqingsong/Desktop/s.png");
        File fileq = new File("/Users/hanqingsong/Desktop/q.png");
        File fileout = new File("/Users/hanqingsong/Desktop/aaa.png");
        try {
            BufferedImage basImage = ImageIO.read(file);
            BufferedImage qrcodeImage = ImageIO.read(fileq);
            BufferedImage bufferedImage = new BufferedImage(basImage.getWidth(), basImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.drawImage(basImage,0,0,null);
            graphics.drawImage(qrcodeImage, 20, 100, 430, 430, Color.RED,null);
            graphics.drawImage(qrcodeImage, 20, 1400, 430, 430, Color.RED,null);
            graphics.setColor(Color.yellow);
            graphics.setStroke(new BasicStroke(1));
            graphics.drawRect(100,600,300,400);
            graphics.setColor(Color.red);
            graphics.setStroke(new BasicStroke(10,   // 线宽
                    BasicStroke.CAP_BUTT,   // 端点样式
                    BasicStroke.JOIN_BEVEL,  // 接头样式
                    15.0f,       // 拼接限制
                    new   float[]{10,   10},             // 虚线
                    1f));      //虚线的设置
            graphics.drawRect(500,1400,430,430);
            graphics.dispose();
            ImageIO.write(bufferedImage, "png", fileout);

            Graphics2D graphics2D = basImage.createGraphics();
            // graphics2D.setComposite(AlphaComposite.getInstance(3));
            // graphics2D.getDeviceConfiguration().createCompatibleImage(basImage.getWidth(), basImage.getHeight(),
            //         Transparency.TRANSLUCENT);
            //设置透明色
            AlphaComposite ac = java.awt.AlphaComposite.getInstance(3, 1F);
            graphics2D.setComposite(ac);
            graphics2D.drawImage(qrcodeImage, 20, 1400, 430, 430, Color.blue,null);
            graphics2D.drawImage(qrcodeImage, 20, 100, 430, 430, Color.blue,null);
            // graphics2D.setColor(Color.red);
            // 设置画笔样式
            graphics2D.setStroke(new BasicStroke(30,   // 线宽
                    BasicStroke.CAP_BUTT,   // 端点样式
                    BasicStroke.JOIN_BEVEL,  // 接头样式
                    15.0f,       // 拼接限制
                    new   float[]{10,   10},             // 虚线
                    1f));      //虚线的设置
            graphics2D.drawRect(30,1400,400,400);
            graphics2D.dispose();
            ImageIO.write(basImage, "png", new File("/Users/hanqingsong/Desktop/bbb.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
