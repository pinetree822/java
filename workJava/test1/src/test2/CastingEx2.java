package test2;

// 정수형에서 2진형 변환
public class CastingEx2 {

	public static void main(String[] args) {
		int i = 10;
		byte b = (byte)i;
		System.out.printf("[int -> byte] i = %d -> b = %d%n", i, b);
		
		i = 128;
		b = (byte)i;
		System.out.printf("[int -> byte] i = %d -> b = %d%n", i, b);
		
		i = 300;
		b = (byte)i;
		System.out.printf("[int -> byte] i = %d -> b = %d%n", i, b);
		
		b = 10;
		i = (int)b;
		System.out.printf("[int -> byte] i = %d -> b = %d%n", b, i);
		
		b = -2;
		i = (int)b;
		System.out.printf("[int -> byte] i = %d -> b = %d%n", b, i);
		
		
		System.out.printf("i = " + Integer.toBinaryString(i));// 10진수를
		
	}// main ---------------

}// class castingEx2---------------
/*
		[int -> byte] i = 10 -> b = 10
		[int -> byte] i = 128 -> b = -128
		[int -> byte] i = 300 -> b = 44
		[int -> byte] i = 10 -> b = 10
		[int -> byte] i = -2 -> b = -2
		i = 11111111111111111111111111111110
*/