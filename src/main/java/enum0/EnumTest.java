package enum0;

import org.junit.Test;

/**
 * Created by hanqingsong on 18/5/23.
 *
 * @author hanqingsong
 * @date 18/5/23
 */
public class EnumTest {
    @Test
    public void enumTest(){
        Day sunday = Day.SUNDAY;
        System.out.println(sunday);
        System.out.println(sunday.name());
        System.out.println(sunday.ordinal());
        Day sunday2 = Day.SUNDAY;
        Day monday = Day.MONDAY;
    }
}
