package number;

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
}
