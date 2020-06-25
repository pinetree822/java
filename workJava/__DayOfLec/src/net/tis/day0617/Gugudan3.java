package net.tis.day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Gugudan3 {
	
	
	
	public static void main(String[] args) {


		try {
			int dan=7;
			InputStream is = System.in;
			InputStreamReader isr = null;
			BufferedReader br = null;
			
			System.out.println("구구단 입력 >>> ");
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			dan = Integer.parseInt(br.readLine());
			System.out.println( "====================================" );// 모니터
			System.out.println("dan = " + dan);
			for(int i=1; i<10; i++) {
				System.out.println(dan + "*" + i + " = " + dan*i );// 모니터
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		


		

		
		
		///////////////////////////////////////////////////////////////////////////////////
//
//		
//		try {
//
//			int dan=7;
//			System.out.println("구구단 입력 >>> ");
//			
//			InputStream is = System.in;
//			InputStreamReader isr = null;
//			BufferedReader br = null;
//			
//			isr = new InputStreamReader(is);
//			int isrRead = isr.read();
//			int isrRead2 = Integer.parseInt(((char)isrRead+""));
//			System.out.println( "isrRead = " + isrRead + ", isrRead2 = " + isrRead2 );// 모니터
//			System.out.println( "====================================" );// 모니터
//			System.out.println( "dan = " + isrRead2 );// 모니터
//			
//			
//			for(int i=1; i<10; i++) {
//				System.out.println(isrRead + "*" + i + " = " + isrRead2*i );// 모니터
//				Thread.sleep(100);// 0.1초 지연 핸들러 = 예외처리
//			}
//
//		
//		} catch (Exception e) {}
//		
///////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////
//		try {
//			String dan="";
//	
//			InputStream is = System.in;
//			InputStreamReader isr = null;
//			BufferedReader br = null;
//			
//			System.out.println("구구단 입력 >>> ");
//			isr = new InputStreamReader(is);
//			br = new BufferedReader(isr);// 아스키코드를 문자열로 자동 변환
//			String dan2;
//				dan2 = br.readLine();
//			System.out.println( "====================================" );// 모니터
//			System.out.println("dan2 = " + dan2);
//	//		while((dan=br.readLine())!=null) {
//	//			System.out.println("dan = " + dan);
//	//		}
//			
//			for(int i=1; i<10; i++) {
//				System.out.println(dan2 + "*" + i + " = " + (Integer.parseInt(dan2)*i) );// 모니터
//			}
//
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}	

		///////////////////////////////////////////////////////////////////////////////////
		
//		sc.close();// scanner 핸들러 종료
		
		
		
		
		
		
		
		
		

		

		
	}// main()
	
	
	
}// class Gugudan3
