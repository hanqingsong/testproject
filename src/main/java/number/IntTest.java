package number;

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
//        for (int i = 0; i < 90; i++) {
//
//            int i1 = new Random().nextInt(40) + 60;
//            Double readScore = (double) i1;
//            System.out.println(i1);
//            System.out.println(readScore);
//        }
    }
}
