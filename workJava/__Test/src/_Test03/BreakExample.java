package _Test03;
import java.util.Scanner;


public class BreakExample {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("exit을 입력하면 종료합니다.");
		while(true) {
			System.out.print(">>");
			String text=scn.nextLine();
			if(text.equals("exit")) // exit 입력시 반복종료
				break;// while문 탈출
		}// while
		System.out.println("종료합니다...");
		scn.close();
	}// main

}// clasee
