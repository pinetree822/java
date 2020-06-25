package net.tis.day0525;

import java.util.Scanner;

public class Test79 {

	public static void main(String[] args) {
		//76페이지 실습
		Scanner sc = new Scanner(System.in);
//		System.out.print("이름 >>> ");
//		String data1 = sc.nextLine();
		
		System.out.print("주민번호 >>> ");
//		int data1 = sc.nextInt();
//		int data1 = sc.nextInt();
//		sc.nextLine();// 뒤에 공백이나 기타 불안정한 데이타 버퍼에서 지우기
		int data1 = Integer.parseInt(sc.nextLine().split(" ")[0]);
		
		System.out.print("부서 >>> ");
//		String data2 = sc.nextLine();
		int data2 = sc.nextInt();
		
		sc.close();
		
		System.out.println();
//		System.out.println("이름 = " + data1);
//		System.out.println("부서 = " + data2);
		
		System.out.println("숫자1 = " + data1);
		System.out.println("숫자2 = " + data2);
		
		
		
	}
	
}
