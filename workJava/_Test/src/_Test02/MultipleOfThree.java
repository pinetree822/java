package _Test02;
import java.util.Scanner;

public class MultipleOfThree {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int number= scn.nextInt();//���� �Է�
		if(number % 3 == 0)//3���� ���� �������� 0���� �˻�
			System.out.println("3�� ����Դϴ�.");
		else
			System.out.println("3�� ����� �ƴմϴ�.");
		scn.close();
		
	}

}
