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
			
			System.out.println("������ �Է� >>> ");
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			dan = Integer.parseInt(br.readLine());
			System.out.println( "====================================" );// �����
			System.out.println("dan = " + dan);
			for(int i=1; i<10; i++) {
				System.out.println(dan + "*" + i + " = " + dan*i );// �����
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
//			System.out.println("������ �Է� >>> ");
//			
//			InputStream is = System.in;
//			InputStreamReader isr = null;
//			BufferedReader br = null;
//			
//			isr = new InputStreamReader(is);
//			int isrRead = isr.read();
//			int isrRead2 = Integer.parseInt(((char)isrRead+""));
//			System.out.println( "isrRead = " + isrRead + ", isrRead2 = " + isrRead2 );// �����
//			System.out.println( "====================================" );// �����
//			System.out.println( "dan = " + isrRead2 );// �����
//			
//			
//			for(int i=1; i<10; i++) {
//				System.out.println(isrRead + "*" + i + " = " + isrRead2*i );// �����
//				Thread.sleep(100);// 0.1�� ���� �ڵ鷯 = ����ó��
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
//			System.out.println("������ �Է� >>> ");
//			isr = new InputStreamReader(is);
//			br = new BufferedReader(isr);// �ƽ�Ű�ڵ带 ���ڿ��� �ڵ� ��ȯ
//			String dan2;
//				dan2 = br.readLine();
//			System.out.println( "====================================" );// �����
//			System.out.println("dan2 = " + dan2);
//	//		while((dan=br.readLine())!=null) {
//	//			System.out.println("dan = " + dan);
//	//		}
//			
//			for(int i=1; i<10; i++) {
//				System.out.println(dan2 + "*" + i + " = " + (Integer.parseInt(dan2)*i) );// �����
//			}
//
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}	

		///////////////////////////////////////////////////////////////////////////////////
		
//		sc.close();// scanner �ڵ鷯 ����
		
		
		
		
		
		
		
		
		

		

		
	}// main()
	
	
	
}// class Gugudan3
