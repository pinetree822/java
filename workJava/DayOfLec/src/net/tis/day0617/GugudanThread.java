package net.tis.day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class GugudanThread extends Thread {
	
	
	
	public static void main(String[] args) {
		
		GugudanThread gg = new GugudanThread();
		//gg.run();// 에러는 없는데 단점이 숫자만 출력
		gg.start();//

		
		int dan=7;
		System.out.println( "====================================" );// 모니터
		System.out.println("dan = " + dan);
		for(int i=1; i<10; i++) {
			System.out.println(dan + "*" + i + " = " + dan*i );// 모니터
			try { Thread.sleep(100); } catch (InterruptedException e1) { e1.printStackTrace(); }
		}
		
		
		

		System.out.println();
		System.out.println("국어=89");
		System.out.println("수학=88");
		System.out.println("영어=90");try { Thread.sleep(100); } catch (InterruptedException e1) { e1.printStackTrace(); }
		System.out.println("총점=175");
		System.out.println("영수증출력");
		
		
	}// main()
	

	
	public void run() {
		int su=0, hap=0;

		try {
			while(su<30) {// while반복문 1~30;
				su=su+1;
				System.out.print(su+" \t");
				hap=hap+su;
				Thread.sleep(100);
				if(su%5==0) {System.out.println();}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}// catch
	}
	
	
}// class Gugudan
