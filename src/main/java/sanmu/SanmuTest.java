package sanmu;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hanqingsong on 16/8/10.
 */
public class SanmuTest {
    @Test
    public void timestampTest(){


    }

    @Test
    public void timeEndDay() {
        DateTime dateTimeNow = new DateTime();
        System.out.println(dateTimeNow.withTimeAtStartOfDay());
        System.out.println(dateTimeNow.withTime(23,59,59,59));

    }

    class Lesson {
    }
}
