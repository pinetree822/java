package net.tis.day0525;

import java.util.Scanner;

public class Calculator83 {

	public static void main(String[] args) {

		// 83page 산술연산 더하기 , 증연산 ===> 1씩 증가
		// a,b,c변수 사용금지
		
		// su변수
		// hap변수 이용해서 
		// 1 2 3 4 5 합계=15
		//
//		int a=7, b=7, c=7;
		int su=0;
		int hap=0;
		String suArr = "";

		
		Scanner scn = new Scanner(System.in);

		System.out.println("정수를 1개 5회 입력해주세요.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		System.out.println("정수를 1개 4회 입력해주세요.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		System.out.println("정수를 1개 3회 입력해주세요.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		System.out.println("정수를 1개 2회 입력해주세요.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		System.out.println("정수를 1개 1회 입력해주세요.");
		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
		suArr = suArr + String.valueOf(su);
		hap+=su;
		System.out.printf("%d \t\t", su);

		scn.close();
//		scn.nextLine();// 
		System.out.printf("%s ", suArr);
		System.out.printf("합계 = %d", hap);
		
//		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
//		System.out.printf("1 2 3 4 5 합계 = 15", su);
		
		
		
		
	}// main
	
//	public static int inSu(Scanner scn) {
//		System.out.println("정수 1개를 " + su + "회 입력해주세요.");
//		su = Integer.parseInt(scn.nextLine().split(" ")[0]);
//		hap+=su;
//		System.out.printf("%d\r\n", su);
//	}
}// class
