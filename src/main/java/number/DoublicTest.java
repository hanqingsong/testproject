package number;

import org.junit.Test;

/**
 * Created by hanqingsong on 16/12/13.
 */
public class DoublicTest {
    public static void main(String[] args) {
        /*Double d = 0.0d;
        System.out.println(d);
        System.out.println(d==0);
        if (d == 0) {
            System.out.println(d==0);
        }*/


        Double discountPrice = new Double(2);
        discountPrice = null;
        System.out.println(discountPrice);
        discountPrice = discountPrice==null?0:discountPrice;
        System.out.println(discountPrice);
    }

    @Test
    public void doubleIntTest() {
        Double d = 0.01;
        System.out.println(d); //0.01
        d = d > 1 ? 1 : d;
        System.out.println(d); //0.01
    }
    @Test
    public void doubleChuTest() {
        Double incomeValue = 5d;
        incomeValue = 169 / 100 * incomeValue;
        System.out.println(incomeValue);
    }
}
