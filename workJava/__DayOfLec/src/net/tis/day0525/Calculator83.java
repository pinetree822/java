package net.tis.day0525;

import java.util.Scanner;

public class Calculator83 {

	public static void main(String[] args) {

		// 83page ������� ���ϱ� , ������ ===> 1�� ����
		// a,b,c���� ������
		
		// su����
		// hap���� �̿��ؼ� 
		// 1 2 3 4 5 �հ�=15
		//
//		int a=7, b=7, c=7;
		int su=0;
		int hap=0;
		String suArr = "";

		
		Scanner scn = new Scanner(System.in);

		System.out.println("������ 1�� 5ȸ �Է����ּ���.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		System.out.println("������ 1�� 4ȸ �Է����ּ���.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		System.out.println("������ 1�� 3ȸ �Է����ּ���.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		System.out.println("������ 1�� 2ȸ �Է����ּ���.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		System.out.println("������ 1�� 1ȸ �Է����ּ���.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		scn.close();
//		scn.nextLine();// 
		System.out.printf("%s ", suArr);
		System.out.printf("�հ� = %d", hap);
		
//		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
//		System.out.printf("1 2 3 4 5 �հ� = 15", su);
		
		
		
		
	}// main
	
//	public static int inSu(Scanner scn) {
//		System.out.println("���� 1���� " + su + "ȸ �Է����ּ���.");
//		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
//		hap+=su;
//		System.out.printf("%d\r\n", su);
//	}
}// class
