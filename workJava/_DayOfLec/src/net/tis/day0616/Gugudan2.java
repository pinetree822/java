package net.tis.day0616;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Gugudan2 {
	
	public static void main(String[] args) {

		int dan = 3;
		String path = "./src/net/tis/day0615/gugu.txt";
		
		try {
			
			
			System.out.println("������ �Է� >>> ");
			
//			InputStream is = System.in;
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
//			dan = Integer.parseInt(br.readLine());
			
			// dan = isr.read(); // �ѱ��� �о ����(ascii)�� �Ҵ�
			// dan = br.read(); br�ε� ascii�ڵ�� �ν�
			dan = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
			
			
			
			for(int i=0; i<10; i++) {
				System.out.println(dan+"*"+i+"="+(dan*i));
			}// for
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}// main()
	
	
	
}// class Gugodan2
