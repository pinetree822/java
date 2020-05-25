package net.tis.day25;

public class CalculatorTest {

	public static void main(String[] args) {

		int a=5, b=5, c=5;

//		a=5, b=5, c=5		
		System.out.println("a=" + a + ", b=" + b + ", c=" + c);
		System.out.println();

//		a=++6, b=++6, c=++6
		a = ++a; b = ++b; c = ++c;// 전치 단항 연산
		System.out.println("a=++" + a + ", b=++" + b + ", c=++" + c);
		System.out.println();

//		a=6++, b=6++, c=6++
		a = a++; b = b++; c = c++; // 후치 단항 연산
		System.out.println("a=" + a + "++, b=" + b + "++, c=" + c+ "++");
		System.out.println();

//		a=6, b=6, c=6
		System.out.println("a=" + a + ", b=" + b + ", c=" + c);
		System.out.println();
	}// main
}// class
