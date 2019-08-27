package hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.Week;
import org.joda.time.DateTimeUtils;
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
    @Test
    public void weekDate(){
        DateTime now =  Convert.convert(DateTime.class,"2019-03-15");
        // DateTime now = DateTime.now();
        Week firstDayOfWeek = now.getFirstDayOfWeek();
        System.out.println(firstDayOfWeek.toChinese());

        org.joda.time.DateTime dateTime1 = new org.joda.time.DateTime(now);
        org.joda.time.DateTime dateTime2 = dateTime1.withDayOfWeek(1);
        org.joda.time.DateTime dateTime3 = dateTime1.withDayOfWeek(7);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime3);


        DateTime dateTime = now.setFirstDayOfWeek(Week.MONDAY);
        System.out.println(dateTime);

        int dayOfWeekInMonth = now.dayOfWeekInMonth();
        System.out.println(dayOfWeekInMonth);

        int dayOfWeek = now.dayOfWeek();
        System.out.println(dayOfWeek);

        int month = now.month();
        System.out.println(month);

        Month monthEnum = now.monthEnum();
        System.out.println(monthEnum.getValue());

    }

}
