package _Test02;
import java.util.Scanner;

public class NestedIf {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요. (0~100): ");
		
		int score = scn.nextInt(); // 점수 읽기
		System.out.print("학년을 입력하세요. (1~4): ");
		
		int year = scn.nextInt(); // 학년 읽기
		if(score >= 60) { // 60점 이상
			
			if(year != 4)// 4학년 아니면  60점이상 합격
				System.out.print("합격!");
			else if(score >= 70)// 4학년 이며 70점이상이면 합격
				System.out.print("합격!");
			else// 4학년 이며 70점 미만이면 불합격
				System.out.print("불합격!");
			
		} else { //60점 미만 불합격
			System.out.print("불합격!");
		}//else
		scn.close();		
	}// main
}//class
