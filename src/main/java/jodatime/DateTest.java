package jodatime;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hanqingsong on 16/8/10.
 */
public class DateTest {
    @Test
    public void timestampTest(){
        String timestamp = "1470757684147";
        Date date = new Date(new Long(timestamp));
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(format);
        DateTime dateTime = new DateTime(new Long(timestamp));
        LocalDate localDate = dateTime.toLocalDate();

    }

    @Test
    public void timeEndDay() {
        DateTime dateTimeNow = new DateTime();
        System.out.println(dateTimeNow.withTimeAtStartOfDay());
        System.out.println(dateTimeNow.toDateMidnight());
        System.out.println(dateTimeNow.withTime(23,59,59,59));

    }
    @Test
    public void timeNew() {
        DateTime dateTimeNow = new DateTime(1525780636);
        System.out.println(dateTimeNow);
        DateTime dateTimeNow2 = new DateTime(1525780636*1000);
        System.out.println(dateTimeNow2);


    }


    @Test
    public void TestAfterBefore() {
        DateTime dateTime2 = new DateTime("2014-09-03");
        DateTime dateTime3 = new DateTime("2014-08-01");
        boolean after = dateTime2.isAfter(dateTime3);
        boolean before = dateTime2.isBefore(dateTime3);
        System.out.println(after);
        System.out.println(before);
    }

    @Test
    public void TestDayOfMonth() {
        DateTime dateTime = new DateTime();
        DateTime.Property dayOfMonth = dateTime.dayOfMonth();

        System.out.println(dayOfMonth.get());
        System.out.println(dateTime.getDayOfMonth());
    }


    @Test
    public void TestWithDayOfWeek() {
        DateTime dateTime = new DateTime();
        DateTime withDayOfWeek1 = dateTime.withDayOfWeek(1);
        DateTime withDayOfWeek7 = dateTime.withDayOfWeek(7);


        System.out.println(withDayOfWeek1);
        System.out.println( withDayOfWeek1.withTimeAtStartOfDay());
        System.out.println( withDayOfWeek1.withTime(0,0,0,0));
        System.out.println( withDayOfWeek7.withTime(23,59,59,3));

    }



}
