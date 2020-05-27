package net.tis.day27;

import java.math.BigInteger;
import java.util.Scanner;

public class TestSj {


	public static void main(String[] args) {
		
		int kor=0, eng=0;
		double avg=0.0, hap=0.0;
		String name = "kim";
		String msg = "";
		String input = "";
		char grade='F';

		kor=90; eng=85;
		hap=kor+eng;
		avg=(double)hap/2;
		
		if(avg >= 70) msg = "축합격";
		else msg = "재시험";
		

		String ret = (avg>=70) ? "pass" : "failed";
		boolean flag = (avg>=70) ? true : false;
		double point = (avg>=70) ? 7.9 : 1.2;
		int save = (avg>=70) ? 2000 : 9;
		

//		if(avg>=90) { grade='A'; }
//		if(avg>=80) { grade='B'; }
//		if(avg>=70) { grade='C'; }
//		if(avg>=60) { grade='D'; }
//		else { grade='F'; }
		
		
		// 100페이지에 switch(조건에 double에러) {}
		// 87.2, 85.8, 89.7, 83.5
		switch ((int)avg/10) {
				case 10: grade='A';
				case 9: grade='B'; break;
				case 8: grade='C'; break;
				case 7: grade='D'; break;
				default: grade='F'; break;
		}// switch
		

		
		System.out.println("grade = " + grade);
		

		// 90~100 A, ...나머지 590 F
		System.out.println("\n=========성 적 처 리 ==========");
		System.out.println("이름=" + name);
		System.out.println("총점=" + hap);
		System.out.println("평균=" + avg);
		System.out.println("학점=" + grade);
		System.out.println("결과=" + msg);
//		System.out.println("누적=" + save);
//		System.out.println("국어점수=" + kor);
//		System.out.println("영어점수=" + eng);
		
		
		
		
		
	}// main
}// class
