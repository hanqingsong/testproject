package string;

/**
 * Created by hanqingsong on 18/11/1.
 *
 * @author hanqingsong
 * @date 18/11/1
 */
public class StringObjectCount {
    public static void main(String[] args) {
        // String s1=new String("he")+new String("llo");
        // s1.intern();
        // String s2 = "hello";
        // System.out.println(s1==s2);

        String s11 = new String("1")+new String("1");
        // String s13 = s11.intern();
        // String s13 = "11";
        s11.intern();
        String s12 = "11";
        System.out.println(s11 == s12);
        // System.out.println(s11 == s13);

        // 猜测s3.intern();往常量池中放时已经存在java字符串，直接返回常量池中的引用（其实没有做任何操作）
        // 所以String s4 = "java" 获取的是常量池java字符串的引用和s3引用不同。
        // String s4 = "java"; 在执行该行指令的时候才会绑定常量池中的直接引用
        String s3=new String("ja")+new String("va");
        s3.intern();
        String s4 = "java";
        System.out.println(s3==s4);

        // 猜测s5.intern();往常量池中放时不已经存在java2字符串，放入常量池该引用
        // String s6 = "java2"; 在执行该行指令的时候才会绑定常量池中的直接引用，此处是s5的直接引用
        String s5=new String("ja")+new String("va2");
        s5.intern();
        String s6 = "java2";
        System.out.println(s5==s6);

        String s7=new String("ja")+new String("va2");
        s7.intern();
        System.out.println(s7==s5);
    }
}
