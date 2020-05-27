package net.tis.day26;

import java.math.BigInteger;
import java.util.Scanner;

public class TestSj {

	
//    |- TestSJ.java 성적 
//	    합계,평균 
//    조건1] 평균70점포함부터 합격/ 0~69 재시험
//
//    총점=175
//    평균=87.5
//    결과=축합격
//
//	94페이지 제어문=조건
//	if( 조건 ) {  }  단순
//	if( 조건1 && 조건2 && 조건3 ) {  }  단순
//	
//	if( 조건 ) {  }  else { }  이중
	
	public static void main(String[] args) {
		
		int kor=0, eng=0;
		double avg=0.0, hap=0.0;
		String message = "";
		String input = "";
		char grade='F';
		
		
		Scanner scn = new Scanner(System.in);

		
		System.out.println("국어점수를 양의 정수로 입력하세요.");
//		kor = Integer.parseInt(scn.nextLine().split(" ")[0]);// java.lang.NumberFormatException
//		System.out.println("input = " + String.format("%040x", new BigInteger(1, input.getBytes(/*YOUR_CHARSET?*/))));
		while(true) {
			input = "";
			input = scn.nextLine().split(" ")[0];
			if(input.length() >0 && input.matches("^[0]?[1-9].*")) {
				kor = Integer.parseInt(input);
				break;
			} else {
				System.out.println("국어점수는양의 정수로 입력하세요.");
			}// else
		}// while

		
		System.out.println("영어점수를 양의 정수로 입력하세요.");
		while(true) {
			input = "";
			input = scn.nextLine().split(" ")[0];
			if(input.length() >0 && input.matches("^[0]?[1-9].*")) {
				eng = Integer.parseInt(input);
				break;
			} else {
				System.out.println("영어점수는 양의 정수로 입력하세요.");
			}// else
		}// while

		
		hap=kor+eng;
		avg=(double)hap/2;
		
		if(avg >= 70) message = "축하";
		else message = "재시험";

		System.out.println("국어점수=" + kor);
		System.out.println("영어점수=" + eng);
		System.out.println("총점=" + hap);
		System.out.println("평균=" + avg);
		System.out.println("결과=" + message);
		
		
		scn.close();
	}// main
}// class
