package _Test03;
import java.util.Scanner;
import java.util.InputMismatchException;



//		0>>d
//		������ �ƴմϴ�. �ٽ� �Է����ּ���.
//		0>>d
//		������ �ƴմϴ�. �ٽ� �Է����ּ���.
//		0>>1
//		1>>2
//		2>>3
//		���� 6

public class InputException {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("���� 3���� �Է��ϼ���.");
		
		int sum=0, n=0;
		
		for(int i=0; i<3; i++)
		{
			System.out.print(i +">>");
			try {
				n = scn.nextInt(); // ���� �Է�
			} catch (InputMismatchException e) {
				System.out.println("������ �ƴմϴ�. �ٽ� �Է����ּ���.");
				scn.next(); // �Է½�Ʈ�� ���ۿ� �ִ� ������ �ƴ� ��ū ���� ������.
				i--; // �ε����� ���������� ������.
				continue;
			}
			sum+=n;
			
		}// for
		
		System.out.println("���� " + sum);
		scn.close();
		
	}// main

}// class
