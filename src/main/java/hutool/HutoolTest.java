package hutool;

import cn.hutool.core.convert.Convert;
import org.junit.Test;

import java.util.Date;

/**
 * @Description
 * @Author hanqingsong
 * @Date 2019-01-18 13:14
 * @Version 1.0
 */
public class HutoolTest {
    @Test
    public void convertTest(){
        int a = 1;
        String s = Convert.toStr(a);
        System.out.println(s);

//        long[] b = {1,2,3,4,5};
//        //bStr为："[1, 2, 3, 4, 5]"
//        String bStr = Convert.toStr(b);
//        System.out.println(bStr);


        String[] b = { "1", "2", "3", "4" };
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);

        long[] c = {1,2,3,4,5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
    }

    @Test
    public void conbertDate(){
        String a = "2017-05-06";
        Date value = Convert.toDate(a);
        System.out.println(value);
    }
}
