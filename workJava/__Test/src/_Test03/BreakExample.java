package _Test03;
import java.util.Scanner;


public class BreakExample {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("exit�� �Է��ϸ� �����մϴ�.");
		while(true) {
			System.out.print(">>");
			String text=scn.nextLine();
			if(text.equals("exit")) // exit �Է½� �ݺ�����
				break;// while�� Ż��
		}// while
		System.out.println("�����մϴ�...");
		scn.close();
	}// main

}// clasee
