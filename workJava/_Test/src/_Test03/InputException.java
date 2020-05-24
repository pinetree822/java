package _Test03;
import java.util.Scanner;
import java.util.InputMismatchException;



//		0>>d
//		정수가 아닙니다. 다시 입력해주세요.
//		0>>d
//		정수가 아닙니다. 다시 입력해주세요.
//		0>>1
//		1>>2
//		2>>3
//		합은 6

public class InputException {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("정수 3개를 입력하세요.");
		
		int sum=0, n=0;
		
		for(int i=0; i<3; i++)
		{
			System.out.print(i +">>");
			try {
				n = scn.nextInt(); // 정수 입력
			} catch (InputMismatchException e) {
				System.out.println("정수가 아닙니다. 다시 입력해주세요.");
				scn.next(); // 입력스트림 버퍼에 있는 정수가 아닌 토큰 값을 버린다.
				i--; // 인덱스를 이전값으로 돌린다.
				continue;
			}
			sum+=n;
			
		}// for
		
		System.out.println("합은 " + sum);
		scn.close();
		
	}// main

}// class
