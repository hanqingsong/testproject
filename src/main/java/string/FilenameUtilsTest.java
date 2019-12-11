package string;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-08-28 13:54
 */
public class FilenameUtilsTest {
    @Test
    public void test(){
        String url = "https://fal.gaokaopai.com/jzb/image/12d2815296514e5ca9f2ce56d9a88bce.jpg";
        //返回文件全名 12d2815296514e5ca9f2ce56d9a88bce.jpg
        String name = FilenameUtils.getName(url);
        System.out.println(name);

        //返回文件名，不包含后缀名 12d2815296514e5ca9f2ce56d9a88bce
        String baseName = FilenameUtils.getBaseName(url);
        System.out.println(baseName);

        //返回文件后缀名 jpg
        String extension = FilenameUtils.getExtension(url);
        System.out.println(extension);

    }
}
