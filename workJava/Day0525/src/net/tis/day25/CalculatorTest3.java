package net.tis.day25;


public class CalculatorTest3  {

	public static void main(String[] args) {

		int a=27, b=16, c=0;
		boolean ret1=false, ret2=false, ret3=false, ret4=false;

		ret1=(a>b);
		System.out.println(ret1);
		
		ret2=(a==b);
		System.out.println(ret2);

		ret3=(a!=b);
		System.out.println(ret3);
		
		ret4=(a<=b);
		System.out.println(ret4);

//		c=a>b;
//		2400 ; 에러
//		System.out.println(2400);// 출력만 조작불가능
//		2+3; 에러
//		System.out.println(2+4);
		
		
	}// main
}// class
