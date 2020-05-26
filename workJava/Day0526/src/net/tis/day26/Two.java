package net.tis.day26;

import java.util.Scanner;

public class Two {
	public static void main(String[] args) {
		
		System.out.println("===========================");
		// 증감연산자 대입연산자 사용
		int a=0, hap=0;
		double avg = 0.0;
		String[] grade; // 0~10까지 학점담기,11개
		String[] gradeMsg; // 0~10까지 학점 축하메세지
		
		// 배열에 넣기 - 60점이상 축하
		grade = "FFFFFFDCBAA".split("");
		gradeMsg = "재시험,재시험,재시험,재시험,재시험,재시험,축하,축하,축하,축하,축하".split(",");
		Scanner scn=new Scanner(System.in);

		// 6:110, 5:101
		//    >> 2
		// byte 3<= 110
		
		System.out.println(" 학점을 입력해주세요.");
		while(true) {
			try {
				int inGra = Integer.parseInt(scn.nextLine().split(" ")[0])/10;
				
				System.out.println("학점은" + grade[inGra] + "입니다.");
				System.out.println("" + gradeMsg[inGra] + "합니다.");
				break;
			} catch (Exception e) {
				System.out.println("학점은 0~100점 사이 양수입니다.");
				continue;
			}
		}
		System.out.println("===========================");
		
		
		
		
		// 스캐너에 넣고, if로 비교
		int a1=0, hap1=0;
		double avg1 = 0.0;
		char grade1;
		
		System.out.println(" 학점을 입력해주세요.");
		a = scn.nextInt();

		if( a >= 90 ) grade1 = 'A';
		else if( a >= 90 ) grade1 = 'B';
		else if( a >= 70 ) grade1 = 'C';
		else if( a >= 60 ) grade1 = 'D';
		else  grade1 = 'F';
		System.out.println("학점은" + grade1 + "입니다.");
		System.out.println("===========================");
		
		
		
		
		// 논리연산자 샘플
		int a2=3, b2=7;
//		// 관계연산자
//		3>7 결과 false
//		3==7 결과 false
//		3<7 결과 true
//		3!=7 결과 true

		System.out.println("3>7 결과" +  (3>7));
		System.out.println("3==7 결과" +  (3==7));
		System.out.println("3<7 결과" +  (3<7));
		System.out.println("3!=7 결과" +  (3!=7));
		
		System.out.println("===========================");
	}// main
}// class Two
