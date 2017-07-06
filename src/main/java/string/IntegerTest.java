package string;

/**
 * Created by hanqingsong on 16/10/9.
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer integer = new Integer(2222);
        Integer integer1 = new Integer(2);
        Long aLong = new Long(22334);
        System.out.println(aLong.toString());
        System.out.println(integer==integer1);
        int i = integer.intValue();
        int i1 = integer1.intValue();
        System.out.println(i == i1);
    }
}
