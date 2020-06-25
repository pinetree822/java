package net.tis.day0615;

import java.util.Calendar;
import java.util.Date;

public class CalendarEx {

	// 375Page 3번라인 static 제거한 후 메인메소드에서 호출
	public void printCalendar(String msg, Calendar cal) {
		
	}// printCalendar()
	
	public static void main(String[] args) {
	
		Calendar cal = Calendar.getInstance();
		Date dt = new Date();


//		System.out.println("cal = " + cal);
//		System.out.println("dt = " + dt);
//		
//		System.out.println(cal.toString());
//		System.out.println(dt.toString());
		
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		
		
	}// main()
	
}// class CalendarEx



//
//cal = java.util.GregorianCalendar[
//			time=1592184576606,
//			areFieldsSet=true,
//			areAllFieldsSet=true,
//			lenient=true,
//			zone=sun.util.calendar.ZoneInfo[
//	            id="Asia/Seoul",
//	            offset=32400000,
//	            dstSavings=0,
//	            useDaylight=false,
//	            transitions=30,
//	            lastRule=null
//	    	],
//			firstDayOfWeek=1,
//			minimalDaysInFirstWeek=1,
//			ERA=1,
//			YEAR=2020,
//			MONTH=5,
//			WEEK_OF_YEAR=25,
//			WEEK_OF_MONTH=3,
//			DAY_OF_MONTH=15,
//			DAY_OF_YEAR=167,
//			DAY_OF_WEEK=2,
//			DAY_OF_WEEK_IN_MONTH=3,
//			AM_PM=0,
//			HOUR=10,
//			HOUR_OF_DAY=10,
//			MINUTE=29,
//			SECOND=36,
//			MILLISECOND=606,
//			ZONE_OFFSET=32400000,
//			DST_OFFSET=0
//		]
//dt = Mon Jun 15 10:29:36 KST 2020
//
