package _Test02;
import java.util.Scanner;

public class SuccessOrFail {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("�������Է��Ͻÿ�: ");
		
		int score = scn.nextInt();
		if(score >= 80)
			System.out.println("�����մϴ�! �հ��Դϴ�.");
		else 
			System.out.println("���� ��ȸ��! ���հ��Դϴ�.");
		scn.close();
	}

}
