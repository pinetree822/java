package _Test02;
import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {
		char grade;
		Scanner scn = new Scanner(System.in);
		
		System.out.print("점수를 입력해주세요(0~100) : ");
		
		int score = scn.nextInt(); //정수 읽기
		
		if(score >= 90)//90이상
			grade = 'A';
		else if (score >= 80)//80이상
			grade = 'B';
		else if (score >= 70)//70이상
			grade = 'C';
		else if (score >= 60)//60이상
			grade = 'D';
		else//60미만이면
			grade = 'F';
		System.out.println("학점은 " + grade + "입니다.");
		scn.close();
	}

}
