package net.tis.day0602;

import java.util.Scanner;

public class AI {

	// 단독실행 main메소드가 없어서 단독 실행
	String name = "깡통";// field=필드=전역변수=member변수=Global
	
	// Constructor = 기본 생성자 = 생략가능
	// 생성자는 new키워드 다음에서 호출
	public AI() {
	}
	
	void info() {// none-static 메소드
		Scanner scn = new Scanner(System.in);// localObject
		System.out.println("AI클래스 info메소드 ");
		System.out.println("AI클래스 이름: " + name);
	}// info()
	
	// a,b 매개인자=parameter
	void guessMax(int a, int b) {
		System.out.println("AI클래스 guess메소드 ");
		System.out.println("AI클래스 이름: " + name);
		System.out.println("AI클래스 최대값: " +(a>b?a:b) );
	}// guessMax()
	
	static void book(){
		System.out.println();
		System.out.println();
	}
	
//	
//	public static void main(String[] args) {
//		
//	}
}// class AI
