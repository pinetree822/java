package net.tis.lecTest;

import java.util.Scanner;

public class Home20 {

	public static void main(String[] args) {
		// 배열사용
		// 시험과목 입력점수 4과목, 4과목 합계

//		
//		jumsu[0] 점수
//		1
//		jumsu[1] 점수
//		2
//		jumsu[2] 점수
//		3
//		jumsu[3] 점수
//		4
//
//		1 
//		2 
//		3 
//		4 
//		hap = 10
		
	
		int jumsu[] = new int[4];
		int hap = 0;
		Scanner sc = new Scanner(System.in);
		
		
		for(int i=0; i<4; i++) {
			System.out.println("jumsu[" + i + "] 점수 입력");
			jumsu[i] = sc.nextInt();
			hap = hap + jumsu[i];
		}
	

		System.out.println();
		for(int i=0; i<4; i++)
		{
			System.out.println(jumsu[i] + " ");
		}
		
		System.out.println("hap = " + hap);
		
		
	}// main
	
}// class Home20
