import md5.UUIDGenerator;
import org.junit.Test;

/**
 * Created by hanqingsong on 16/7/28.
 */
public class TestString {
    @Test
    public void testPrint() {
        System.out.println("dddd");
        String s = UUIDGenerator.generateShort();
        System.out.println(s);
        System.out.println(0%10);
        System.out.println(8%10);
        System.out.println(10%10);
        System.out.println("=======================");


        for (int ci = 0; ci < 5; ci++) {

            System.out.println("班级="+ci+",分配旁听生");

            for (int i = 0; i < 3; i++) {
                System.out.println(i);
                System.out.println(ci*3+i);

                System.out.println("班级={},分配旁听生,   "+i );
            }
        }
    }
}
