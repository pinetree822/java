package net.tis.day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class GugudanThread extends Thread {
	
	
	
	public static void main(String[] args) {
		
		GugudanThread gg = new GugudanThread();
		//gg.run();// ������ ���µ� ������ ���ڸ� ���
		gg.start();//

		
		int dan=7;
		System.out.println( "====================================" );// �����
		System.out.println("dan = " + dan);
		for(int i=1; i<10; i++) {
			System.out.println(dan + "*" + i + " = " + dan*i );// �����
			try { Thread.sleep(100); } catch (InterruptedException e1) { e1.printStackTrace(); }
		}
		
		
		

		System.out.println();
		System.out.println("����=89");
		System.out.println("����=88");
		System.out.println("����=90");try { Thread.sleep(100); } catch (InterruptedException e1) { e1.printStackTrace(); }
		System.out.println("����=175");
		System.out.println("���������");
		
		
	}// main()
	

	
	public void run() {
		int su=0, hap=0;

		try {
			while(su<30) {// while�ݺ��� 1~30;
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
