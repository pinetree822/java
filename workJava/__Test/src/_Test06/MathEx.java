package _Test06;

import java.util.Random;

public class MathEx {
	
	public static void main(String[] args) {
		
		// 원주율 상수 출력
		System.out.println(Math.PI);
		
		// 올림
		System.out.println(Math.ceil(3.14));
		
		// 내림
		System.out.println(Math.floor(3.14));
		
		// 제곱근
		System.out.println(Math.sqrt(9));
		
		// e의 2승
		System.out.println(Math.exp(2));
		
		// 반올림
		System.out.println(Math.round(3.14));
		
		// [1, 45] 사이의 정수형 난수 5개 발생
		// 로또번호 출력시에 반복해서 나오는 번호 처리
//		이번주 행운의 번호는
//		38 	45 	22 	10 	12 	3 	: 행운의 번호 - 33
//		22 	13 	16 	11 	26 	29 	: 행운의 번호 - 1
//		35 	15 	15 	44 	4 	40 	: 행운의 번호 - 23
//		9 	27 	1 	21 	20 	18 	: 행운의 번호 - 8
//		1 	16 	36 	27 	10 	12 	: 행운의 번호 - 34
		
		System.out.print("이번주 행운의 번호는\n");
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<6; j++)
			{
			    double dValue = Math.random();
				System.out.print((int)(Math.random()*45 + 1) + " \t");
			}//for
		    double dValue = Math.random();
			System.out.println(": 행운의 번호 - " + (int)(Math.random()*45 + 1));
		}//for
		

		
//		Math.random() 번호는 1미만의 double형식의 숫자
//
//		0 = 0.9249873164366973
//		1 = 0.1891738021851197
//		2 = 0.8788934033275794
//		3 = 0.532929749993527
//		4 = 0.3261862480983213
		System.out.println("\n\nMath.random() 번호는 1미만의 double형식의 숫자\n");
		for(int i=0; i<5; i++)
		{
		    double dValue = Math.random();
		    System.out.println(i + " = " + dValue);
		}//for
		
		
		
//		0 ~ 9 사이의 정수형 난수
//		1
//		3
//		5
//		7
//		0
		for(int i=0; i< 5; i++)
		{
			double dValue = Math.random();
			int iValue = (int)(dValue * 10);
			System.out.println(iValue);
		}//for
		

//		출처: https://offbyone.tistory.com/237 [쉬고 싶은 개발자]		
//		알파벳을 랜던하게 발생
//		알파벳이 26자 이므로 0 ~ 26 까지의 난수를 발생

//		ASCII 코드표 참고
//		ASCII 코드에서 65번째 부터 대문자 A 
//		대문자 = B
//		소문자 = b
//		대문자 = C
//		소문자 = c
		
		
		for(int i=0; i<2; i++)
		{
			double dValue = Math.random();
			char cValue = (char)((dValue*26) + 65);// 대문자
			char sValue = (char)((dValue*26) + 97);// 소문자
			
			System.out.println("대문자 = " + cValue);
			System.out.println("소문자 = " + sValue);
		}
		
		
		// 기본 생성자를 사용해서 생성하면 
		// 현재 시스템 시간을 seed 값으로 가지는 Ramdom 객체를 생성
		Random rand1 = new Random(); // java.util.Random
		
		// seed 를 지정하여 객체를 생성하는 방법 입니다. 
		// long 타입의 seed 를 생성자의 인자
		long seed = System.currentTimeMillis();
		Random rand2 = new Random(seed);
		
		// 생성후 seed 를 변경
		rand2.setSeed(System.currentTimeMillis());
		
		
		
		
//		난수 발생 메소스
//		
//		- boolean nextBoolean() : 균일한 분포의 boolean 형 난수 발생
//		- int nextInt() : 균일한 분포의 int 형 난수 발생(int 전 범위에서 난수가 발생합니다.)
//		- long nextLong() : 균일한 분포의 long형 난수 발생(long 점 범위에서 난수가 발생합니다.)
//		- int nextInt(int n) : 균일한 분포의 0이상 n 미만의 int형 난수 발생
//		- float nextFloat() : 균일한 분포의 0.0이상 1.0 미만의 float형 난수 발생
//		- double nextDouble() : 균일한 분포의 0.0이상 1.0 미만의 double형 난수 발생
//		- double nextGaussian() : 정규 분포의 난수를 발생합니다.(평균이 0이고, 표준편차가 1인 분포 입니다.)

		
//		0 ~ 9 사이의 난수를 발생
//		rand3.nextInt(10) => 2
//		rand3.nextInt(10) => 1
//		rand3.nextInt(10) => 1
		Random rand3 = new Random();
		
		for(int i=0; i<3; i++) {
			int iValue = rand3.nextInt(10);		// 0 <= iValue < 10
			System.out.println("rand3.nextInt(10) => " + iValue);
		}
		
		
	}// main
}// class
