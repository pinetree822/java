package net.tis.day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Gugudan4 {
	
	
	
	public static void main(String[] args) {


		try {

			int dan2 = 0;
			String tmp = "";
			
			InputStream is = System.in;
			InputStreamReader isr = null;
			BufferedReader br = null;
			
			System.out.println("구구단 입력 >>> ");
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);// 아스키코드를 문자열로 자동 변환
			
			dan2 = br.read();
//			while((tmp=br.readLine())!=null) {
//			System.out.println("tmp = " + tmp);
//		}
			System.out.println( "====================================" );// 모니터
			System.out.println("dan2 = " + dan2);

			
			for(int i=1; i<10; i++) {
				System.out.println(dan2 + "*" + i + " = " + (Integer.parseInt((char)dan2+"")*i) );// 모니터
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// main()
	
	
}// class Gugudan3
