package net.tis.day22;

import java.text.Format;

public class Home10 {
	
//		기본문제1] 작은순으로 출력하세요
//		int b=7;
//		int c=6;
//		결과출력 6  7 

	public static void main(String[] args) {
		
		int b=7;
		int c=6;
//		결과출력 6  7
		
		System.out.printf("결과출력 %s", sort1(b,c));;
		
	}
	
	
	static String sort1(int a, int b) {
		String tmp="";
		if(a>b)
			tmp = b + " " + a;
		else 
			tmp = a+ " " + b;
		return tmp;
	}
	
	
}
