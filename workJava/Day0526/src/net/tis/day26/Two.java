package net.tis.day26;

import java.util.Scanner;

public class Two {
	public static void main(String[] args) {
		
		System.out.println("===========================");
		// ���������� ���Կ����� ���
		int a=0, hap=0;
		double avg = 0.0;
		String[] grade; // 0~10���� �������,11��
		String[] gradeMsg; // 0~10���� ���� ���ϸ޼���
		
		// �迭�� �ֱ� - 60���̻� ����
		grade = "FFFFFFDCBAA".split("");
		gradeMsg = "�����,�����,�����,�����,�����,�����,����,����,����,����,����".split(",");
		Scanner scn=new Scanner(System.in);

		// 6:110, 5:101
		//    >> 2
		// byte 3<= 110
		
		System.out.println(" ������ �Է����ּ���.");
		while(true) {
			try {
				int inGra = Integer.parseInt(scn.nextLine().split(" ")[0])/10;
				
				System.out.println("������" + grade[inGra] + "�Դϴ�.");
				System.out.println("" + gradeMsg[inGra] + "�մϴ�.");
				break;
			} catch (Exception e) {
				System.out.println("������ 0~100�� ���� ����Դϴ�.");
				continue;
			}
		}
		System.out.println("===========================");
		
		
		
		
		// ��ĳ�ʿ� �ְ�, if�� ��
		int a1=0, hap1=0;
		double avg1 = 0.0;
		char grade1;
		
		System.out.println(" ������ �Է����ּ���.");
		a = scn.nextInt();

		if( a >= 90 ) grade1 = 'A';
		else if( a >= 90 ) grade1 = 'B';
		else if( a >= 70 ) grade1 = 'C';
		else if( a >= 60 ) grade1 = 'D';
		else  grade1 = 'F';
		System.out.println("������" + grade1 + "�Դϴ�.");
		System.out.println("===========================");
		
		
		
		
		// �������� ����
		int a2=3, b2=7;
//		// ���迬����
//		3>7 ��� false
//		3==7 ��� false
//		3<7 ��� true
//		3!=7 ��� true

		System.out.println("3>7 ���" +  (3>7));
		System.out.println("3==7 ���" +  (3==7));
		System.out.println("3<7 ���" +  (3<7));
		System.out.println("3!=7 ���" +  (3!=7));
		
		System.out.println("===========================");
	}// main
}// class Two
