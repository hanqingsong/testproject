package string;

import org.junit.Test;

/**
 * Created by hanqingsong on 18/1/6.
 * 测试java的引用传值
 */
public class ArgumentTest {
    /**
     * 1. 基本数据类型：传值，方法不会改变实参的值
     */
    @Test
    public void baseTypeTest() {
        int a = 5;
        ArgumentTest.baseTypeOper(a);
        System.out.println(a);
    }

    public static void baseTypeOper(int i) {
        i += 55;
        System.out.println(i);
    }

    /**
     * 2. 对象类型参数：方法体内改变形参引用，但不会改变实参引用 ，实参值不变
     *
     */
    @Test
    public void stringTypeTest() {
        String a = "hi";
        ArgumentTest.stringTypeOper(a);
        System.out.println(a);
        String b =null;
        if (b == null || b.length() == 0) {
            System.out.println("null");
        }else {
            System.out.println("not null");
        }
    }

    public static void stringTypeOper(String str) {
        str = "hello";
        System.out.println(str);
    }

    /**
     * 3. 对象类型参数：方法体内，通过引用改变了实际参数对象的内容，注意是“内容”，引用还是不变的。
     */
    @Test
    public void stringBufferTypeTest() {
        StringBuffer a = new StringBuffer("hi");
        ArgumentTest.stringBufferTypeOper(a);
        System.out.println(a);
    }

    public static void stringBufferTypeOper(StringBuffer sb) {
        sb.append("hello");
        System.out.println(sb);
    }

}
