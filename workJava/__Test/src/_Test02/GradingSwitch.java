package _Test02;
import java.util.Scanner;

public class GradingSwitch {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		char grade;
		
		System.out.print("점수를 입력하세요(0~100): ");
		
		int score = scn.nextInt();
		switch (score/10)
		{
			case 10 : // score=100
			case 9: // score=90~99
				grade = 'A';
				break;
			case 8: // score=80~89
				grade = 'B';
				break;
			case 7: // score=70~79
				grade = 'C';
				break;
			case 6: // score=60~69
				grade = 'D';
				break;
			default: // score>=59
					grade = 'F';
		}//switch
		
		System.out.println("학점은 " + grade + " 입니다.");
		scn.close();
		
	}// main

}//class
