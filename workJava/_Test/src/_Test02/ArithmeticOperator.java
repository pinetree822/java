package _Test02;

import java.util.Scanner;


public class ArithmeticOperator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("�ʸ� �ð�,��,�ʷ� �����ϴ�. ������ �Է��ϼ���.");
		
//		12345�ʴ� 
//		3�ð�, 
//		25��, 
//		45���Դϴ�.
		
		int time = scn.nextInt(); // �����Է�
		int hour = (time / 60) / 60; // 60���� ���� ���� �ٽ� 60���� ���� ���� �ð�
		int minute = (time / 60) %60; // 60���� ���� ���� �ٽ� 60���� ���� �������� ��
		int second = time % 60; // 60���� ���� �������� ��
		
		System.out.print(time + "�ʴ� ");
		System.out.print("�� " + hour + "�ð�, ");
		System.out.print(minute + "��, ");
		System.out.println(second + "���Դϴ�.");
		
		
		scn.close();
	}

}
