package net.tis.day0616;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Calendar;

public class TestPrint {

	public static void main(String[] args) {

		// java.lang��Ű�� final class System Ŭ����
		// in err out
		// Field = �ʵ� = �������� 
		// Math, System, Calendar

		
		
		
		
		try {
			double d = Math.PI;
			System.out.println(d);// 3.141592653589793
			
			int y = Calendar.YEAR;
			
			Calendar cc = Calendar.getInstance();
			int x = Calendar.YEAR;
			int y2 = cc.get(y);
			System.out.println(y2);// 2020
			
			
			
			
			PrintStream ps = System.out;
			ps.println();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
//		
//		try {
//			// ǥ�� ����� ���
//			PrintStream ps = System.out;
//			
//			System.out.println("ȭ����");
//			System.out.println("�����");
//			System.out.println("�Ͽ���");
//			
//			
//			ps.print("������ �Է� >>> ");
//			
//			InputStream is = System.in;
//			int c = is.read();// �Է� : AB ��� 65
//			
//			ps.println();// ���ΰ��� = enter���
//			ps.println("�Էµ����ʹ� " + c + " �Դϴ�.");
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//

		
		
	}// main()
	
}// class TestPrint
