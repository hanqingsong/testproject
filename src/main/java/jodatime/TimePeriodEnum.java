package jodatime;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Objects;


/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-04-28 15:08
 */
public enum TimePeriodEnum {
    /**
     * 开始时间， 结束时间
     */
    TIME_PERIOD_1("18:00", "21:59"),
    TIME_PERIOD_2("22:00", "01:59"),
    TIME_PERIOD_3("02:00", "05:59"),
    TIME_PERIOD_4("06:00", "09:59"),
    TIME_PERIOD_5("10:00", "13:59"),
    TIME_PERIOD_6("14:00", "17:59");

    private String startTimePeriod;
    private String endTimePeriod;

    TimePeriodEnum(String startTimePeriod, String startEndPeriod) {
        this.startTimePeriod = startTimePeriod;
        this.endTimePeriod = startEndPeriod;
    }

    /**
     * 获取当前时间段的结束时间
     * 比较小时是否在范围内
     *
     * @param now
     * @return org.joda.time.DateTime
     * @author hanqingsong
     * @date 2019-04-28
     */
    public static TimePeriodEnum getCurrentPeriodStartTime(DateTime now) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        int nowHourOfDay = now.getHourOfDay();

        TimePeriodEnum[] values = TimePeriodEnum.values();
        for (TimePeriodEnum periodEnum : values) {
            String startTimePeriod = periodEnum.startTimePeriod;
            String endTimePeriod = periodEnum.endTimePeriod;
            DateTime startTime = DateTime.parse(startTimePeriod, formatter);
            DateTime endTime = DateTime.parse(endTimePeriod, formatter);
            int startHour = startTime.getHourOfDay();
            int endHour = endTime.getHourOfDay();
            if (nowHourOfDay >= startHour && nowHourOfDay <= endHour) {
                // now = now.withHourOfDay(startTime.getHourOfDay()).withMinuteOfHour(startTime.getMinuteOfHour());
                // now = now.withTime(startTime.getHourOfDay(), startTime.getMinuteOfHour(), 0, 0);
                LocalTime time = startTime.toLocalTime();
                now = now.withTime(time);
                now = now.withTime(endTime.toLocalTime());
                System.out.println(now.toString());
                return periodEnum;
            }
        }
        return null;
    }

    public String getStartTimePeriod() {
        return startTimePeriod;
    }

    public String getEndTimePeriod() {
        return endTimePeriod;
    }
}
