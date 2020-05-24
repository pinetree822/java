package _Test02;
import java.util.Scanner;

public class MultipleOfThree {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int number= scn.nextInt();//정수 입력
		if(number % 3 == 0)//3으로 나눈 나머지가 0인지 검사
			System.out.println("3의 배수입니다.");
		else
			System.out.println("3의 배수가 아닙니다.");
		scn.close();
		
	}

}
