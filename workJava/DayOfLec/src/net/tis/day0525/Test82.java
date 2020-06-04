package net.tis.day0525;

import java.util.Scanner;

public class Test82 {

	public static void main(String[] args) {
		//76페이지 실습
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 >>> ");
		String data1 = sc.nextLine();
		
		System.out.print("주소 >>> ");
		String data2 = sc.nextLine();
		
		sc.close();
		
		System.out.println();
		System.out.println("이름 = " + data1);
		System.out.println("부서 = " + data2);
	}// main
}// class
