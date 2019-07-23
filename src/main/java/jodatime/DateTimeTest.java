package jodatime;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

public class DateTimeTest {
	public static void main(String[] args) {
		DateTime dateTimeNow = new DateTime();

//		Property[weekOfWeekyear]
//				2
//				Property[dayOfWeek
		/*System.out.println(dateTimeNow.weekOfWeekyear());
		System.out.println(dateTimeNow.plusDays(3).getDayOfWeek());
		System.out.println(dateTimeNow.dayOfWeek());*/
		
		DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimePattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		String dateStr = dateTimeNow.toString(dateFormatter);
		DateTime dateTimeOrigin = DateTime.parse(dateStr+" 23:59:59", dateTimePattern);
		//System.out.println(dateTimeOrigin);
		DateTime dateTime = dateTimeOrigin.plusDays(1);
		
//		System.out.println(dateTimeOrigin);

//		System.out.println(dateTimeOrigin.plusDays(3));
		
//		System.out.println(dateTimeOrigin);
		
		DateTime recent = DateTime.parse("2016-05-18 17:40:00", dateTimePattern);
//		System.out.println(recent);
		DateTime before = recent.plusMinutes(-15);
//		System.out.println(dateTimeNow);
//		System.out.println(recent.toLocalDate());
//		System.out.println(dateTimeNow.getDayOfYear());
		
//		System.out.println(isBefore());// today before tomorrow  true
		//isSun();
//		isBefore();
		//datBettweans();
//		nowBettweansDate();
//		nowBettweansYear();

//		paser();
//		parseDate();
		nowBettweansDate();
	}

	static void ttt(){
		DateTime dateTimeNow = new DateTime();
		DateTime dateTimeEnd = new DateTime( DateTime.parse("2016-08-14 17:13:58", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));//2016-08-14 17:13:58
		int leftDays = Days.daysBetween(dateTimeNow.withTimeAtStartOfDay(), dateTimeEnd.withTimeAtStartOfDay()).getDays();
		int days=90;
		System.out.println(leftDays>=days);
		System.out.println(leftDays>=days);
	}

	static void nowBettweansDate(){
		DateTime now = new DateTime();//当前时间

		DateTime tryEndTime = DateTime.parse("2016-11-17 23:59:59",DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		int days = Days.daysBetween(now.withTimeAtStartOfDay(), tryEndTime.withTimeAtStartOfDay()).getDays();
		System.out.println(days);
	}

	static void nowBettweansYear(){
		DateTime now = new DateTime();//当前时间

		DateTime tryEndTime = DateTime.parse("2014-10-17 23:59:59",DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		int years = Years.yearsBetween(tryEndTime, now).getYears();
		System.out.println(years);
	}
	@Test
	public void isBefore(){// 现在 isbefore 明天 true
		boolean before = new DateTime().isBefore(new DateTime().plus(1));
		System.out.println(before);
	}

	static void paser() {
//		DateTime dateTime = ISODateTimeFormat.dateTimeParser().parseDateTime("2016-06-03");//2016-06-03T00:00:00.000+08:00
		DateTime dateTime = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2016-06-03 23:59:59");//2016-06-03T23:59:59.000+08:00
//		DateTime dateTime = DateTime.parse("2016-06-03"); //2016-06-03T00:00:00.000+08:00
//		DateTime dateTime = DateTime.parse("2016-06-03 23:59:59"); //Invalid format: "2016-06-03 23:59:59" is malformed at " 23:59:59"

		System.out.printf("===="+dateTime);
	}

	static void parseDate(){
		String date="2016-06-03";
		DateTime dateTime = new DateTime(date);
		Date startDate  = DateTime.parse("2016-12-19", DateTimeFormat.forPattern("yyyy-MM-dd")).toDate();
		DateTime dateTime1 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2016-12-19").plusDays(1).minusMillis(1);
		String userLid = "9acc9f7e095f46a78755e6a0adaaf924";
		String s = new DateTime(startDate).toString(DateTimeFormat.forPattern("M.d期"));
		DateTime now = new DateTime();
		DateTime dateTime2 = now.plusDays(-6);
		System.out.println(s);
		System.out.println(dateTime);
		System.out.println(dateTime2);
	}

	/**
	 * 时间差，几年几个月
	 */

	@Test
	public void intervalDate(){

		long birthdayValue = DateTime.parse("2017-06-07 00:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate().getTime();
		if (birthdayValue > 0) {
			Interval interval = new Interval(birthdayValue, DateTime.now().getMillis());
			// Interval interval = new Interval( DateTime.now().getMillis(),birthdayValue);// error
			Period period = interval.toPeriod();
			int years = period.getYears();
			System.out.println(years);
			int months = period.getMonths();
			System.out.println(months);
			String birthdayDesc = new StringBuilder().append(years).append("岁").append(months).append("个月").toString();
			System.out.println(birthdayDesc);
		}
	}

	
	static void isSun(){
		int addDays = 2;
		DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimePattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		String dateStr = new DateTime().toString(dateFormatter);
		DateTime dateTimeOrigin = DateTime.parse(dateStr+" 23:59:59", dateTimePattern);
		
		//判断是否包含周六周日
		for(int i=addDays;i>0;i--){
			DateTime loopDate = dateTimeOrigin.plusDays(i);
			System.out.println(loopDate);
			if (loopDate.getDayOfWeek() == 6 || loopDate.getDayOfWeek() == 7) {//如果包含周六周日
				//查数据库中当天是否有课，如果没课，tryendTime＋1
				Date startDate = loopDate.withTimeAtStartOfDay().toDate();
				System.out.println(loopDate.getDayOfWeek());
				System.out.println(startDate);
				System.out.println(loopDate.toDate());
			}
		}
	}
	
	static void datBettweans(){

		DateTime dateTimeNow = DateTime.parse("2016-05-24 13:59:59",DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		DateTime dateTimeEnd = DateTime.parse("2016-05-24 23:59:59",DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dateTimeNow);
		System.out.println(dateTimeEnd);
		int leftDays = Days.daysBetween(dateTimeNow.withTimeAtStartOfDay(), dateTimeEnd.withTimeAtStartOfDay()).getDays();


		System.out.println("剩余天数"+leftDays);
	}

	@Test
	public void dayWeek() {
		DateTime dateTime = new DateTime();
		System.out.println(dateTime.toString("yyyy-MM-dd"));
		System.out.println(dateTime.toString("yyyy-M-d"));
		System.out.println(dateTime.getDayOfWeek());
		System.out.println(dateTime.getWeekOfWeekyear());
	}

	@Test
	public void dateOfNextWeek() {
		DateTime dateTime = new DateTime();
		dateTime = dateTime.plusWeeks(1);
		System.out.println(dateTime.weekOfWeekyear().getDateTime());
//		System.out.println(dateTime.weekOfWeekyear().addToCopy(1));
		System.out.println(dateTime.weekOfWeekyear().roundFloorCopy());
		System.out.println(dateTime.weekOfWeekyear().roundCeilingCopy());
		System.out.println(dateTime.getDayOfWeek());
		System.out.println(dateTime.getWeekOfWeekyear());
	}
	@Test
	public void nowBettweansTommrow(){
		DateTime now = new DateTime();//当前时间
		DateTime tomorrowDt = now.plusDays(1);//明天

		int days = Days.daysBetween(now, tomorrowDt).getDays();
		System.out.println(days);//1
	}

	@Test
	public void testMonthPlus(){
		DateTime now = new DateTime(2017,1,31,0,0,0);//当前时间
		System.out.println(now);//1
		System.out.println(now.isBeforeNow());//1

		// now = now.plusDays(29);
		now = now.plusMonths(1);
		System.out.println(now);
	}

	@Test
	public void testMonthGet(){
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime startTime = DateTime.parse("2018-07-10 00:00:00", formatter);
		System.out.println(startTime.toString(DateTimeFormat.forPattern("M").withLocale(Locale.ENGLISH)));
		System.out.println(startTime.toString(DateTimeFormat.forPattern("MM").withLocale(Locale.ENGLISH)));
		System.out.println(startTime.toString(DateTimeFormat.forPattern("MMM").withLocale(Locale.ENGLISH)));
		System.out.println(startTime.toString(DateTimeFormat.forPattern("MMMM").withLocale(Locale.ENGLISH)));
		DateTime endTime = DateTime.parse("2018-08-09 23:59:59", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(endTime.toString(DateTimeFormat.forPattern("M").withLocale(Locale.ENGLISH)));
		System.out.println(endTime.toString(DateTimeFormat.forPattern("MM").withLocale(Locale.ENGLISH)));
		System.out.println(endTime.toString(DateTimeFormat.forPattern("MMM").withLocale(Locale.ENGLISH)));
		System.out.println(endTime.toString(DateTimeFormat.forPattern("MMMM").withLocale(Locale.ENGLISH)));

	}

	@Test
	public void testPeriod(){
		TimePeriodEnum currentPeriodStartTime = TimePeriodEnum.getCurrentPeriodStartTime(DateTime.now());
		System.out.println(currentPeriodStartTime);
	}



}
