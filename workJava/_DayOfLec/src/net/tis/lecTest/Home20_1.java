package net.tis.lecTest;

import java.util.Scanner;

public class Home20_1 {

	public static void main(String[] args) {
		// �迭���
		// ������� �Է����� 4����, 4���� �հ�
		
		
//		�����Ͻ÷��� exit �� �Է����ּ���.
//		������� ���ڸ� �Է����ּ���.
//		1
//		������� ���ڸ� �Է����ּ���.
//
//		������� ���ڸ� �Է����ּ���.
//		2
//		������� ���ڸ� �Է����ּ���.
//		������������
//		������� ���ڸ� �Է����ּ���.
//		1234 423141234
//		������� ���ڸ� �Է����ּ���.
//		exit
//		�� �Է°���? ==> 2
//		�Էµ� ���ڴ� >>>
//		1 2 �Դϴ�.
//		�� 2�� �ԷµǾ����ϴ�.
//		�հ� : 3�Դϴ�.
//		�����մϴ�.

		
		
		
		Scanner scn = new Scanner(System.in);// �Է¹��� Handler
		String input = new String();// �Է¹޴°�
		String inputs = new String();// ���Է¹޴°� ����Ʈ -> 1,2,3,
		char tmp; // �Է¹������� ����
		int maxInput=0; // �� ���� �Է°���
		
		// <enter>Ű ó��
		// ���� �ƴ� ����ó��, ascii�ڵ� ���ڸ� �ޱ�
		// ����<0~9>,  // 10��<80~89>,  // 16��<0x50~0x59>
		// https://pridiot.tistory.com/34
		System.out.println("�����Ͻ÷��� exit �� �Է����ּ���.");
		while(!input.equals("exit")) 				// �Էµ� ���ڰ� exit�ΰ� Ȯ��
		{
			System.out.println("������� ���ڸ� �Է����ּ���.");
			input=scn.nextLine();					// Ű���忡�� �Է¹��� ���ڿ��� input ���ڿ��� �Ҵ��Ѵ�.
			if(input.length()==1) {					// ���̰� �� �����ΰ͸� �˻��Ѵ�.
				tmp = input.charAt(0);				// ��Ʈ��(���ڿ�)�� ù��°�� tmp������
				//System.out.println("�Է°� ==>" + (byte)tmp); // �Էµ� ���� �ƽ�Ű�ڵ��
				if(('0'<=tmp && tmp <='9')) { 	// ���� '0'~'9' �� ���̶��
					maxInput++; // ���Է°���
					inputs += input + ",";			// ���ڿ�(input)�� ',' �����ڷ� �߰���Ų��.
				}//if
			}// if
		}//while

		
		

		// �Էµ� ���ڹ��ڰ� ���ٸ�
		if( maxInput <= 0) {
			System.out.println("�� �Է°���? ==> " + maxInput);// ���Է°��� ��ΰ�?
			System.out.println("�Էµ� ���� �����ϴ�.");
			System.out.println("�����մϴ�.");
			System.exit(0);
		} else {
			System.out.println("�� �Է°���? ==> " + maxInput);// ���Է°��� ��ΰ�?
		}

		
		// �Էµ� ������ �����迭 �����
		String[] arrStr = inputs.split(",");	
		// �ش�Ǵ� ������ �����迭 �����
		int[] arrInt = new int[maxInput]; 
		// �Էµ� ������ ����
		double sum = 0.0;
		
		
		// �Էµ� ���� ������ŭ �迭�� �����.
		for (int i=0; i<maxInput; i++) {
			try {
				// ������ �����迭�� ������ �����迭�� �Ҵ�
				arrInt[i] = Integer.parseInt(arrStr[i]);
			} catch (NumberFormatException nfe) {// �������� �ѱ��
			} catch (Exception e) {}// try , �׿� ��Ÿ ����
		}// for
		
		
		System.out.println("�Էµ� ���ڴ� >>>");
		for(int i=0; i<arrInt.length; i++) {
			sum+=arrInt[i];
			System.out.print( arrInt[i] + " " );
		}
		System.out.println("�Դϴ�.");
		System.out.println("�� " + maxInput + "�� �ԷµǾ����ϴ�.");
		System.out.println("�հ� : " + (int)sum + "�Դϴ�.");
		
		System.out.println("�����մϴ�.");
		System.exit(0);
		
		
		
	}// main
	
}// class Home20

