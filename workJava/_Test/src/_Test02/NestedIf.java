package _Test02;
import java.util.Scanner;

public class NestedIf {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ���. (0~100): ");
		
		int score = scn.nextInt(); // ���� �б�
		System.out.print("�г��� �Է��ϼ���. (1~4): ");
		
		int year = scn.nextInt(); // �г� �б�
		if(score >= 60) { // 60�� �̻�
			
			if(year != 4)// 4�г� �ƴϸ�  60���̻� �հ�
				System.out.print("�հ�!");
			else if(score >= 70)// 4�г� �̸� 70���̻��̸� �հ�
				System.out.print("�հ�!");
			else// 4�г� �̸� 70�� �̸��̸� ���հ�
				System.out.print("���հ�!");
			
		} else { //60�� �̸� ���հ�
			System.out.print("���հ�!");
		}//else
		scn.close();		
	}// main
}//class
