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
		
		// �߻�Ŭ���� �ʰ��� �ǽ�
		try {
			
			String path="C:\\Mtest\\abc.txt";
			
			Calendar cc=new GregorianCalendar();// �߻�Ŭ����
			OutputStream os= new FileOutputStream(path);
//			InputStream is = new FileInputStream(path);
			// �����Ŭ����
			ImageBoardImp ibi;
			SimpleDateFormat sdf;// �Ϲ�Ŭ����
			
		} catch (Exception e) {}
		
		
		
	}// main()
	public int house(String ss) {return 23;}
	public static void happy(int m) {}
	public abstract boolean card(int total);
	public abstract void cash(int total);
	
	
}// class Test
