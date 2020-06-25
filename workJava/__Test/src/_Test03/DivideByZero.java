package _Test03;
import java.util.Scanner;

public class DivideByZero {

	
//	나눔분모수를 입력하세요 : 10
//	나눌분자수를 입력하시오 : 3
//	10를 3로 나누면 몫은 3입니다.
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int dividend;		// 나뉨수
		int divisor;		// 나눗수
		
		System.out.print("나눔분모수를 입력하세요 : ");
		dividend = scn.nextInt();
		
		System.out.print("나눌분자수를 입력하시오 : ");
		divisor = scn.nextInt();
		
		System.out.println(dividend + "를 " + divisor + "로 나누면 몫은 "
				+ dividend/divisor + "입니다.");
		scn.close();
	}// main

}// class
