package regular;

import org.junit.Test;

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
}
