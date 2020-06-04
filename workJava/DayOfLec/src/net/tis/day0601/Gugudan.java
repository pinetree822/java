package net.tis.day0601;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		
		int dan = 1, i = 0;
		Scanner sc = new Scanner(System.in); // Scanner클래스 초기값이 미활성(장치드라이버가 인식 안됨)
		
		// Ctrl + Shift + f
		// 왼쪽으로 내어쓸때 Shift + Tab키
		// 오른쪽으로 들여쓸때 Tab키
		
		while (true) {
			System.out.print("단 입력 >>> ");

			try {
//				dan = sc.nextInt();// 숫자 enter치면 enter키값이 다시 dan변수대입
				dan = Integer.parseInt(sc.nextLine());// 숫자 enter치면 enter키값이 다시 dan변수대입

				if (dan == 0 || dan == -1) {
					System.out.println("구구단 프로그램을 종료합니다.");
//					break;
					System.exit(0);
				}

				for (i = 1; i < 10; i++)
					System.out.println(dan + "*" + i + "=" + (dan * i));

				break;// 생략하면 문법에러 while(true){}
			} catch (Exception e) {
				System.out.println("정수형 숫자를 입력하세요.");
				continue;
			}
		} // while

		System.out.println("=========================");
		System.out.println("***성적처리***");
		System.out.println("총점=175");
		System.out.println("평균=87.5");
		System.out.println("영수증출력");
		
		sc.close();

	}// main
	
}// class Gugudan
