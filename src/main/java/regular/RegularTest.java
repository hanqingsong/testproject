package regular;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hanqingsong on 17/2/23.
 */
public class RegularTest {

    @Test
    public void replaceTest() {
        String s1 = "Unit14 Month 1";
        String s2 = "Unit 14 Body Songs and Crafts";
//        String s3 = "Unit 14 Body Songs unit14 and Crafts";
        String s3 = "Unit14 Body Songs unit14 and Crafts";
        String s4 = "Unit 1";
        String s5 = "Winter Holiday Unit 3";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        String regex = "(^[U,u]nit\\s?\\d+\\s)|([U,u]nit\\s?\\d+$)";
//        String regex2 = "[U,u]nit\\s?\\d+$";
        s1=s1.replaceAll(regex, "");
        s2=s2.replaceAll(regex, "");
        s3=s3.replaceAll(regex, "");
        s4=s4.replaceAll(regex, "");
        s5=s5.replaceAll(regex, "");

        System.out.println("=====================");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }

    @Test
    public void flagTest(){

        // Pattern pattern = Pattern.compile("unit" );
        // CASE_INSENSITIVE 大小写忽略 unit 能匹配到Unit
        // Pattern pattern = Pattern.compile("unit", Pattern.CASE_INSENSITIVE);
        // String s1 = "Unit14 Month 1";

        // MULTILINE 多行匹配 如果打开能够匹配到里面的数字
        // 默认情况下，输入的字符串被看作是一行，即便是这一行中包好了换行符也被看作一行。
        // 当匹配“^”到“$”之间的内容的时候，整个输入被看成一个一行。启用多行模式之后，
        // 包含换行符的输入将被自动转换成多行，然后进行匹配
        String multiline = "^(\\d)+$";
        String multilineInput = "1234\r99\rabc\r128";
        Pattern pattern = Pattern.compile(multiline, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(multilineInput);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // .UNIX_LINE：unix行模式，大多多数系统的行都是以“\n”结尾的，但是少数系统，
        // 比如Windows，却是以“\r\n”组合来结尾的，启用这个模式之后，将会只以“\n”作为行结束符，这会影响到^、$和点号(点号匹配换行符)

        // DOTALL 启用dotall模式，一般情况下，点号（.）匹配任意字符，但不匹配换行符，启用这个模式之后，点号还能匹配换行符：
        String dotall = "<xml>(.)*</xml>";
        String dotallInput = "<xml>\r\n</xml>";
        boolean match = Pattern.compile(dotall,Pattern.DOTALL).matcher(dotallInput).matches();//true
        boolean match2 = Pattern.compile(dotall).matcher(dotallInput).matches();//false

        // Pattern.LITERAL：平白字符模式，启用这个模式之后，所有元字符、转义字符都被看成普通的字符，不再具有其他意义
        System.out.println(Pattern.compile("\\d",Pattern.LITERAL).matcher("\\d").matches());//true
        System.out.println(Pattern.compile("\\d",Pattern.LITERAL).matcher("2").matches());//false


    }
}
