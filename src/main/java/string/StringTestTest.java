package string;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Created by hanqingsong on 18/10/26.
 *
 * @author hanqingsong
 * @date 18/10/26
 */
public class StringTestTest {
    @Test
    public void equalTest(){
        String s11 = new String("1")+new String("1");
        String s13 = s11.intern();
        String s12 = "11";
        System.out.println(s11 == s12);
        System.out.println(s11 == s13);
        System.out.println(s12 == s13);

        String x2 = new StringBuilder().append("bbb").toString();
        System.out.println(x2.intern() == x2);
    }
    @Test
    public void stringBuffer(){
        String nickName = "一二三四五六七八九十十一十二";
        StringBuffer stringBuffer = new StringBuffer(nickName);
        nickName = stringBuffer.replace(8, nickName.length(), "...").toString();
        System.out.printf(nickName);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(StringTestTest.class);
        boolean success = result.wasSuccessful();
        System.out.println(success);
        System.out.println(result.getRunCount());
    }
}
