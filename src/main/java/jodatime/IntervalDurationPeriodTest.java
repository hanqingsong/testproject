package jodatime;

import org.joda.time.*;
import org.joda.time.field.MillisDurationField;
import org.junit.Test;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-07-23 15:01
 */
public class IntervalDurationPeriodTest {
    @Test
    public void test(){
        /**
         * Intervals
         */
        System.out.println("Intervals=============================");
        // yearMoth
        YearMonth yearMonth = new YearMonth();
        //当前失去的Intervals
        System.out.println(yearMonth.toInterval());
        //MothDay
        YearMonthDay yearMonthDay = new YearMonthDay();
        System.out.println(yearMonthDay.toInterval());

        System.out.println(yearMonthDay.toInterval(DateTimeZone.UTC));

        System.out.println(Interval.parse("2018-08-01/2018-08-30"));


        /**
         * Duration
         */
        System.out.println("Duration=========================");
        System.out.println(Duration.standardDays(1L));
        System.out.println(Duration.standardHours(100));

        /**
         * Period
         */
        System.out.println("Period=========================");
        //使用Second直接获取Period
        System.out.println(Seconds.seconds(1));
        //使用Minutes直接获取Period
        System.out.println(Minutes.minutes(1));
        //使用Hours直接获取Period
        System.out.println("3" + Hours.hours(1));
        //使用Hours直接获取Period
        System.out.println(Days.days(1));
        System.out.println(Months.months(1));
        System.out.println(Weeks.weeks(1));
        System.out.println(Years.years(2).toString());
        System.out.println(Period.days(1));
        System.out.println(Period.minutes(15));
        System.out.println(Period.weeks(1));

    }

    @Test
    public void test2() {
        DateTime dateTime = new DateTime("2019-07-23T14:31:25.314+08:00");
        DateTime dateTime2 = new DateTime("2019-07-23T14:31:40.511+08:00");
        System.out.println("Seconds.secondsBetween=========================");
        Seconds seconds = Seconds.secondsBetween(dateTime, dateTime2);
        System.out.println(seconds.getSeconds()); // 15

        System.out.println("Interval=====toDuration====================");
        Duration duration = new Interval(dateTime, dateTime2).toDuration();
        System.out.println(duration.getStandardSeconds()); //15
        System.out.println(duration.getMillis()); //15197
        long durationMillis = new Interval(dateTime, dateTime2).toDurationMillis();
        System.out.println(durationMillis); // 15197

        System.out.println("Interval=====toPeriod====================");
        Period period = new Interval(dateTime, dateTime2).toPeriod();
        System.out.println(period.getSeconds()); // 15
        System.out.println(period.getMillis()); // 197

        System.out.println("Interval=====toInterval====================");
        Interval interval = new Interval(dateTime, dateTime2).toInterval();
        System.out.println(interval.getStartMillis());
        System.out.println(interval.getEndMillis());

        System.out.println("Duration=========================");
        long standardHours = Duration.standardDays(1).getStandardHours();
        System.out.println(standardHours); // 24


    }
}
