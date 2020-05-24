package _Test03;
import java.util.Scanner;

public class DivideByZeroHandling {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("나눌 분모수를 입력하세요. : ");
			int dividend = scn.nextInt(); // 나눌 분모수
			
			System.out.print("나눌 분자수를 입력하세요. : ");
			int divisor = scn.nextInt(); // 나눌 분자수
			try {
				System.out.println(dividend + "를 " + divisor + "로 나누면 몫은" +
						dividend/divisor + "입니다."
						);
				break;
			} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.! 다시 입력하세요.");
			}// try
		}// while
		
		scn.close();
	}// main

}// class
