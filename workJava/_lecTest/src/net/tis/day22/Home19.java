package net.tis.day22;

import java.util.Scanner;

public class Home19 {

	public static void main(String[] args) {
		
		// �迭 ������  �������
		// for�� �̿��ؼ� �Ѳ����� �Է¹޾Ƽ�
		// �ѹ��� ���

//		System.out.print(z+" ");
//		hap=x+y+z;
//		System.out.println("hap= " + hap);
		
		
		
//		// ����
//		int x = 0, y = 0, z = 0, hap=0;
//		Scanner scn = new Scanner(System.in);
//		System.out.print("x >>>");
//		x = scn.nextInt();System.out.println();
//		
//
//		System.out.print("y >>>");
//		y = scn.nextInt();System.out.println();
//		
//
//		System.out.print("z >>>");
//		z = scn.nextInt();System.out.println();
//		
//		hap = x + y + z;
//		System.out.print("x + y + z >>>");
//		System.out.println("hap= " + hap);
//		// ����
		
		
		
		
	
		Scanner scn = new Scanner(System.in);
		String input = new String();// �Է¹޴°�
		String inputs = new String();// ���Է¹޴°� -> 1,2,3,
		
		while(!input.equals("exit")) 
		{
			input=scn.nextLine();
			inputs += input + ",";
		}

		int maxInput = inputs.split(",").length-1; // ���Է°��� -1(exit)
		if( maxInput <= 0) {
			System.out.println("�Էµ� ���� �����ϴ�.");
			System.out.println("�����մϴ�.");
			System.exit(0);
		} else {
			System.out.println("�� �Է°���? ==> " + maxInput);// ���Է°��� ��ΰ�?
		}
		
		
		Integer[] arrInt = new Integer[maxInput]; // 
		

		
		
		
		System.out.println("�����մϴ�.");
		System.exit(0);
		
		
		
		
		
		
		
		
		
		
		
		
//		int[] arrInt = new Integer[maxInput]; // 
//		String[] arrayInput = new String[inputs.split(",").length-1]; // ���Է°����� -1(exit)
//		System.out.print(arrayInput.length);
//		String[] arrayInput = input.split(",");
		
		
//		System.out.print(Integer.parseInt(arrayInput[0]));
		
	}// main
	
}// class Home19
