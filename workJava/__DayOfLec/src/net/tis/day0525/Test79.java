package net.tis.day0525;

import java.util.Scanner;

public class Test79 {

	public static void main(String[] args) {
		//76������ �ǽ�
		Scanner sc = new Scanner(System.in);
//		System.out.print("�̸� >>> ");
//		String data1 = sc.nextLine();
		
		System.out.print("�ֹι�ȣ >>> ");
//		int data1 = sc.nextInt();
//		int data1 = sc.nextInt();
//		sc.nextLine();// �ڿ� �����̳� ��Ÿ �Ҿ����� ����Ÿ ���ۿ��� �����
		int data1 = Integer.parseInt(sc.nextLine().split(" ")[0]);
		
		System.out.print("�μ� >>> ");
//		String data2 = sc.nextLine();
		int data2 = sc.nextInt();
		
		sc.close();
		
		System.out.println();
//		System.out.println("�̸� = " + data1);
//		System.out.println("�μ� = " + data2);
		
		System.out.println("����1 = " + data1);
		System.out.println("����2 = " + data2);
		
		
		
	}
	
}
