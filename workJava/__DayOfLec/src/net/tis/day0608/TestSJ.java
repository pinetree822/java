package net.tis.day0608;

import java.util.Scanner;

public class TestSJ {
	
	public int getSum(int kor, int eng) {
		int tot=0;
		tot=(kor+eng);
		return tot;
	}// getSum()
	
	public double getAverage(int total)
	{
		return (double)total/2;
	}// getAverage()
	
	public void display(String name,int kor,int eng,int total,double avg) {
		System.out.println(name + " 국어점수 : " + kor);
		System.out.println(name + " 영어점수 : " + eng);
		System.out.println(name + " 전체총점 : " + total);
		System.out.println(name + " 평균점수 : " + avg);
	}
	public static void main(String[] args) {

		int kor=0, eng=0;
		// Scanner 클래스 키보드 입력, 예외, 0~100범위
		Scanner scn = new Scanner(System.in);
		System.out.println("국어입력 >>> ");
		kor=scn.nextInt();
		
		System.out.println("영어입력 >>> ");
		eng=scn.nextInt();
		
		TestSJ sj = new TestSJ();
		int total = sj.getSum(kor, eng);
		double avg = sj.getAverage(total);
		
		sj.display("길동",kor,eng,total,avg);
		
		// 총점, 평균, 학점, 결과
//		System.out.println(총점);
//		System.out.println(평균);
//		System.out.println(학점);
//		System.out.println(결과);
		
		
		// 메소드의 매개인자, 리턴값
		
	}// main()
	
}// class TestSJ
