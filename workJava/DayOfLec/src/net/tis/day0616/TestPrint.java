package net.tis.day0616;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Calendar;

public class TestPrint {

	public static void main(String[] args) {

		// java.lang팩키지 final class System 클래스
		// in err out
		// Field = 필드 = 전역변수 
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
//			// 표준 모니터 출력
//			PrintStream ps = System.out;
//			
//			System.out.println("화요일");
//			System.out.println("토요일");
//			System.out.println("일요일");
//			
//			
//			ps.print("데이터 입력 >>> ");
//			
//			InputStream is = System.in;
//			int c = is.read();// 입력 : AB 출력 65
//			
//			ps.println();// 라인개행 = enter기능
//			ps.println("입력데이터는 " + c + " 입니다.");
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//

		
		
	}// main()
	
}// class TestPrint
