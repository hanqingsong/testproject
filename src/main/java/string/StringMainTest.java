package string;

/**
 * Created by hanqingsong on 18/10/26.
 *
 * @author hanqingsong
 * @date 18/10/26
 */
public class StringMainTest {
    public static void main(String[] args) {
        // String s1 = new String("ab")+new String("cd");
        // s1.intern();
        // // String s3 = s1.intern();
        // String s2 = "abcd";
        //
        //
        // // System.out.println(s1==s3);
        // System.out.println(s1==s2);
        // // System.out.println(s2==s3);

        // // 常量池中没有“计算机软件”，放入常量池此对象引用，所以两个引用相同
        // String str1 = new StringBuilder("计算机").append("软件").toString();
        // System.out.println(str1.intern()==str1);
        //
        // // 常量池中已经有java，返回常量池中的引用，和str2引用不相同
        // String str2 = new StringBuilder("ja").append("va").toString();
        // System.out.println(str2.intern()==str2);

        String s11 = new String("1")+new String("1");
        String s13 = s11.intern();
        String s12 = "11";
        System.out.println(s11 == s12); // false
        System.out.println(s11 == s13); // true
        System.out.println(s12 == s13); // false


        String x2 = new StringBuilder().append("Stringaaa").append("Testaaa").toString();
        System.out.println(x2.intern() == x2);
        String x3 = new String("Stringbbb");
        System.out.println(x3.intern() == x3);
    }

}
