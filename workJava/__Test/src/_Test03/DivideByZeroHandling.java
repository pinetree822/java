package _Test03;
import java.util.Scanner;

public class DivideByZeroHandling {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("���� �и���� �Է��ϼ���. : ");
			int dividend = scn.nextInt(); // ���� �и��
			
			System.out.print("���� ���ڼ��� �Է��ϼ���. : ");
			int divisor = scn.nextInt(); // ���� ���ڼ�
			try {
				System.out.println(dividend + "�� " + divisor + "�� ������ ����" +
						dividend/divisor + "�Դϴ�."
						);
				break;
			} catch (ArithmeticException e) {
				System.out.println("0���� ���� �� �����ϴ�.! �ٽ� �Է��ϼ���.");
			}// try
		}// while
		
		scn.close();
	}// main

}// class
