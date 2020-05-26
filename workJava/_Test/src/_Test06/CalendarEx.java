package _Test06;

import java.util.Calendar;

public class CalendarEx {

	
	public static void printCalendar(String msg, Calendar cal)
	{
		int year		=cal.get(Calendar.YEAR);
		// get()은 0~30까지의 정수 리턴
		int month	=cal.get(Calendar.MONTH) + 1;
		int day		=cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		int hour		=cal.get(Calendar.HOUR);
		int hourOfDay=cal.get(Calendar.HOUR_OF_DAY);
		int ampm	=cal.get(Calendar.AM_PM);
		int minute	=cal.get(Calendar.MINUTE);
		int second	=cal.get(Calendar.SECOND);
		int millisecond=cal.get(Calendar.MILLISECOND);
		
//		처음 데이트한 날은 : 2020/6/26/
		System.out.print(msg + year + "/" + month + "/" + day + "/");
		
		// 금요일
		switch (dayOfWeek) {
			case Calendar.SUNDAY : System.out.print("일요일");break;
			case Calendar.MONDAY : System.out.print("월요일");break;
			case Calendar.TUESDAY : System.out.print("화요일");break;
			case Calendar.WEDNESDAY : System.out.print("수요일");break;
			case Calendar.THURSDAY : System.out.print("목요일");break;
			case Calendar.FRIDAY : System.out.print("금요일");break;
			case Calendar.SATURDAY : System.out.print("토요일");break;
		}
		
		// (20시)
		System.out.print(" (" + hourOfDay + "시)");
		
		// 오후
		if(ampm == Calendar.AM) System.out.print(" 오전");
		else System.out.print(" 오후");
		
		// 8 시 30분 0초 0밀리초
		System.out.println(hour + " 시 " + minute + "분 " + second + "초 " 
		+ millisecond + "밀리초");
		
	}
	
	
	// https://arabiannight.tistory.com/entry/JAVA-Java-Calendar-%EC%BA%98%EB%A6%B0%EB%8D%94-%EB%9E%80
	public static void main(String[] args) {
		
		Calendar now=Calendar.getInstance();
		printCalendar("현재 ", now);
		System.out.println();
//		현재 2020/5/26/

		
//		출처: https://arabiannight.tistory.com/entry/JAVA-Java-Calendar-캘린더-란 [아라비안나이트]
		Calendar firstDate = Calendar.getInstance();
		firstDate.clear();// void clear () : 모든 시간 필드의 값을 클리어

		firstDate.set(2020, 5, 26);
		firstDate.set(Calendar.HOUR_OF_DAY, 20);
		firstDate.set(Calendar.MINUTE, 30);
		
		printCalendar("처음 데이트한 날은 : ", firstDate);

		
	}
}
