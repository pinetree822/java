package net.tis.lecTest;

import java.util.Scanner;

public class Home20 {

	public static void main(String[] args) {
		// �迭���
		// ������� �Է����� 4����, 4���� �հ�

//		
//		jumsu[0] ����
//		1
//		jumsu[1] ����
//		2
//		jumsu[2] ����
//		3
//		jumsu[3] ����
//		4
//
//		1 
//		2 
//		3 
//		4 
//		hap = 10
		
	
		int jumsu[] = new int[4];
		int hap = 0;
		Scanner sc = new Scanner(System.in);
		
		
		for(int i=0; i<4; i++) {
			System.out.println("jumsu[" + i + "] ���� �Է�");
			jumsu[i] = sc.nextInt();
			hap = hap + jumsu[i];
		}
	

		System.out.println();
		for(int i=0; i<4; i++)
		{
			System.out.println(jumsu[i] + " ");
		}
		
		System.out.println("hap = " + hap);
		
		
	}// main
	
}// class Home20
