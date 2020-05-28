package net.tis.day22;

import java.util.Scanner;

public class Home17 {

	public static void main(String[] args) {
		
		int x=7, y=8, z=9, hap=0;
		hap = 7 + 8 + 9;
		System.out.println(x + " " + y + " " + z + " " + "hap=" + hap);
		System.out.println();
		int total=0;// 배열 데이터 합계
		int[] su = new int[3];// 4Byte * 3 => 12 바이트
//		su[0]=7; su[1]=8; su[2]=9;
		


		
		
		

//		안내문
//		System.out.println("sc[0] + sc[1] + sc[2]);
//		score[0] = 7 <enter>
//		score[1] = 8 <enter>
//		score[2] = 9 <enter>
//		7	8	9	hap=24
		System.out.println("문제1 : 정수 3개를 입력해주세요.");
		
		Scanner scn = new Scanner(System.in);
		su[0] = scn.nextInt();
		System.out.println("score[0] = "  + su[0]);
		su[1] = scn.nextInt();
		System.out.println("score[0] = "  + su[1]);
		su[2] = scn.nextInt();
		System.out.println("score[0] = "  + su[2]);
		
		System.out.println(su[0] + " " + su[1] + " " + su[2] + " hap=" + (su[0]+ su[1]+ su[2]));
//		정수 3개를 입력해주세요.
//		1
//		score[0] = 1
//		2
//		score[0] = 2
//		3
//		score[0] = 3
//		1 2 3 hap=6
		
		
		
		
		
		

//		변수 데이터 7 8 9 hap=24
//		-> for 반복문 이용해서 합계구하기
//		배열 데이터 7 8 9 total=24
//		-> for 응용
//		score[0] = 7 <enter>
//		score[1] = 8 <enter>
//		score[2] = 9 <enter>
		
		System.out.println("문제2 : for문을 이용한 배열 할당과 합계");
		for(int i=0; i<su.length; i++) {
		
		//	System.out.print("score[" + i + "] = "  + su[i]);
			System.out.print(su[i] + " ");
			total+=su[i];
			
			if( i == su.length-1) {
				System.out.println("total=" + total);
			}//if
		}// for
//		문제2 : for문을 이용한 배열 할당과 합계
//		7 8 9 total=24


		
		
		
		
		
// 133페이지 참고 키보드 입력 Scanner
		int tot=0;
		int[] score = new int[3];

		System.out.println("문제 3 : 정수 3개를 입력해주세요.");
		scn.nextLine();
		su= null;// 클리어
		
		//System.out.print("문제3 : ");
		for(int i=0; i<score.length; i++) {
			score[i] = scn.nextInt();
			System.out.print(score[i] + " ");
			tot+=score[i];
			System.out.println("total1=" + tot);
			if( i == score.length-1) {
				System.out.println("total=" + tot);
			}//if
		}// for
		scn.close();// 종료
		
		
		
		
	
//		문제 3 : 정수 3개를 입력해주세요.
//		1
//		1 total1=1
//		2
//		2 total1=3
//		3
//		3 total1=6
//		total=6		
	}
}
