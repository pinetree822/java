package _Test03;
import java.util.Scanner;

public class DivideByZero {

	
//	�����и���� �Է��ϼ��� : 10
//	�������ڼ��� �Է��Ͻÿ� : 3
//	10�� 3�� ������ ���� 3�Դϴ�.
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int dividend;		// ������
		int divisor;		// ������
		
		System.out.print("�����и���� �Է��ϼ��� : ");
		dividend = scn.nextInt();
		
		System.out.print("�������ڼ��� �Է��Ͻÿ� : ");
		divisor = scn.nextInt();
		
		System.out.println(dividend + "�� " + divisor + "�� ������ ���� "
				+ dividend/divisor + "�Դϴ�.");
		scn.close();
	}// main

}// class
