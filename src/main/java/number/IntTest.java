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
    public void int2Double() {
        double ii = 1800.0;
        System.out.println(ii);
        System.out.println(new Double(ii).intValue());

        System.out.println(MD5.crypt("xlh" + MD5.crypt("123456") + "fs"));
//        for (int i = 0; i < 90; i++) {
//
//            int i1 = new Random().nextInt(40) + 60;
//            Double readScore = (double) i1;
//            System.out.println(i1);
//            System.out.println(readScore);
//        }
    }

    @Test
    public void intRandom() {

        for (int i = 0; i < 20; i++) {
            int canReplaceNum = RandomUtils.nextInt(1, 7);
            System.out.println(canReplaceNum);
        }


    }

    @Test
    public void intQuyu() {
        int c = 0;
        for (int i = 0; i < 8; i++) {
            int yy = c % 8;
            int i1 = new Random().nextInt(7);
            Integer canReplaceNum = RandomUtils.nextInt(1, 6 + 1);
            System.out.println("i1= " + i1);
            System.out.println("canReplaceNum= " + canReplaceNum);
//            System.out.println(c+"%8="+yy);
            c++;
        }


    }

    /**
     * 数值和字符串比较是相等的
     * 底层使用字符串转char数组比较，比较的是字符值
     */
    @Test
    public void InterStrEqual() {
        Integer i = 10;
        String s = "10";
        System.out.println(i.toString().equals(s));

    }

    @Test
    public void intTest() {
        int length = 8;
        int num = 18;
        int index = 18%length;

        System.out.println(index);
        int index2 = (length-1)&17;
        System.out.println(index2);
        index2 = (length-1)&18;
        System.out.println(index2);
        index2 = (length-1)&19;
        System.out.println(index2);
        index2 = (length-1)&20;
        System.out.println(index2);
    }


    /**
     * 所有的包装类对象之间值的比较，全部使用equals方法比较。
     * 说明：对于Integer var=?在-128至127之间的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象，
     * 这个区间内的Integer值可以直接使用==进行判断，但是这个区间之外的所有数据，都会在堆上产生，
     * 并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断
     */
    @Test
    public void intEqualTest(){
        Integer i1=1;
        Integer i2=1;
        Integer i3=1000;
        Integer i4=1000;

        System.out.println(i1==i2);
        System.out.println(i3==i4);
    }

}
