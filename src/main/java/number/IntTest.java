package number;

import md5.MD5;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Random;

/**
 * Created by hanqingsong on 16/7/29.
 */
public class IntTest {
    @Test
    public void int2Double(){
        double ii = 1800.0;
        System.out.println(ii);
        System.out.println(new Double(ii).intValue());

        System.out.println(MD5.crypt("xlh"+ MD5.crypt("123456")+"fs"));
//        for (int i = 0; i < 90; i++) {
//
//            int i1 = new Random().nextInt(40) + 60;
//            Double readScore = (double) i1;
//            System.out.println(i1);
//            System.out.println(readScore);
//        }
    }
    @Test
    public void intRandom(){

        for (int i = 0; i < 20; i++) {
            int canReplaceNum = RandomUtils.nextInt(1, 7);
            System.out.println(canReplaceNum);
        }


    }
    @Test
    public void intQuyu(){
        int c = 0;
        for (int i = 0; i < 8; i++) {
            int yy = c%8;
            System.out.println(c+"%8="+yy);
            c++;
        }


    }

    @Test
    public void InterStrEqual(){
        Integer i = 10;
        String s = "10";
        System.out.println(i.toString().equals(s));


    }





}
