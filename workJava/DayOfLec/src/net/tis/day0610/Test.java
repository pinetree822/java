package net.tis.day0610;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Test {

	public static void main(String[] args) throws Exception {
		
		// 추상클래스 초간단 실습
		try {
			
			String path="C:\\Mtest\\abc.txt";
			
			Calendar cc=new GregorianCalendar();// 추상클래스
			OutputStream os= new FileOutputStream(path);
//			InputStream is = new FileInputStream(path);
			// 사용자클래스
			ImageBoardImp ibi;
			SimpleDateFormat sdf;// 일반클래스
			
		} catch (Exception e) {}
		
		
		
	}// main()
	public int house(String ss) {return 23;}
	public static void happy(int m) {}
	public abstract boolean card(int total);
	public abstract void cash(int total);
	
	
}// class Test
