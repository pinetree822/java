package _Test06;

import java.util.Calendar;

public class CalendarEx {

	
	public static void printCalendar(String msg, Calendar cal)
	{
		int year		=cal.get(Calendar.YEAR);
		// get()�� 0~30������ ���� ����
		int month	=cal.get(Calendar.MONTH) + 1;
		int day		=cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		int hour		=cal.get(Calendar.HOUR);
		int hourOfDay=cal.get(Calendar.HOUR_OF_DAY);
		int ampm	=cal.get(Calendar.AM_PM);
		int minute	=cal.get(Calendar.MINUTE);
		int second	=cal.get(Calendar.SECOND);
		int millisecond=cal.get(Calendar.MILLISECOND);
		
//		ó�� ����Ʈ�� ���� : 2020/6/26/
		System.out.print(msg + year + "/" + month + "/" + day + "/");
		
		// �ݿ���
		switch (dayOfWeek) {
			case Calendar.SUNDAY : System.out.print("�Ͽ���");break;
			case Calendar.MONDAY : System.out.print("������");break;
			case Calendar.TUESDAY : System.out.print("ȭ����");break;
			case Calendar.WEDNESDAY : System.out.print("������");break;
			case Calendar.THURSDAY : System.out.print("�����");break;
			case Calendar.FRIDAY : System.out.print("�ݿ���");break;
			case Calendar.SATURDAY : System.out.print("�����");break;
		}
		
		// (20��)
		System.out.print(" (" + hourOfDay + "��)");
		
		// ����
		if(ampm == Calendar.AM) System.out.print(" ����");
		else System.out.print(" ����");
		
		// 8 �� 30�� 0�� 0�и���
		System.out.println(hour + " �� " + minute + "�� " + second + "�� " 
		+ millisecond + "�и���");
		
	}
	
	
	// https://arabiannight.tistory.com/entry/JAVA-Java-Calendar-%EC%BA%98%EB%A6%B0%EB%8D%94-%EB%9E%80
	public static void main(String[] args) {
		
		Calendar now=Calendar.getInstance();
		printCalendar("���� ", now);
		System.out.println();
//		���� 2020/5/26/

		
//		��ó: https://arabiannight.tistory.com/entry/JAVA-Java-Calendar-Ķ����-�� [�ƶ��ȳ���Ʈ]
		Calendar firstDate = Calendar.getInstance();
		firstDate.clear();// void clear () : ��� �ð� �ʵ��� ���� Ŭ����

		firstDate.set(2020, 5, 26);
		firstDate.set(Calendar.HOUR_OF_DAY, 20);
		firstDate.set(Calendar.MINUTE, 30);
		
		printCalendar("ó�� ����Ʈ�� ���� : ", firstDate);

		
	}
}
