package _Test02;
import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {
		char grade;
		Scanner scn = new Scanner(System.in);
		
		System.out.print("������ �Է����ּ���(0~100) : ");
		
		int score = scn.nextInt(); //���� �б�
		
		if(score >= 90)//90�̻�
			grade = 'A';
		else if (score >= 80)//80�̻�
			grade = 'B';
		else if (score >= 70)//70�̻�
			grade = 'C';
		else if (score >= 60)//60�̻�
			grade = 'D';
		else//60�̸��̸�
			grade = 'F';
		System.out.println("������ " + grade + "�Դϴ�.");
		scn.close();
	}

}
