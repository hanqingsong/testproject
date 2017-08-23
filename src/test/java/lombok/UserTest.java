package lombok;

import static org.testng.Assert.*;

/**
 * Created by hanqingsong on 17/8/23.
 */
public class UserTest {

    public void test1(){
        User user = new User();
        user.setPassword("ss");
    }
}