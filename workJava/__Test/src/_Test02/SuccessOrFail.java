package _Test02;
import java.util.Scanner;

public class SuccessOrFail {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("점수를입력하시오: ");
		
		int score = scn.nextInt();
		if(score >= 80)
			System.out.println("축하합니다! 합격입니다.");
		else 
			System.out.println("다음 기회에! 불합격입니다.");
		scn.close();
	}

}
