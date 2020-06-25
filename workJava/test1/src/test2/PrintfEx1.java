package test2;

public class PrintfEx1 {

	public static void main(String[] args) {
		byte b = 1;		// 1byte
		short s = 2;		// 2byte
		char c = 'A';		// 2byte - 유니코드문자임
		int finger = 10;	// 4byte
		long big = 100_000_000_000L;			// 정수형 8byte - 리터럴 표기법 long형
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;	// 정수형 8byte - 리터럴 표기법 long형 long hex = 0xFFFFFFFFFFFFFFFFL
		// float 은 4byte, double형은 8byte
		int octNum = 010;							// 8진수		=> 10진수로 8
		int hexNum = 0x10;						// 16진수		=> 10진수로 16
		int binNum = 0b1111;					// 2진수		=> 10진수로 2
		

		System.out.printf( "b = %d%n", b  );					// %n : line separator, %d는 정수형 포맷
		System.out.printf( "s = %d%n", s );						// 문자를 정수형으로 포맷 프린트
		System.out.printf( "c = %c, %d, %n", c, (int)c  );		// %c 문자형 포맷
		
		System.out.printf( "finger = [%5d]%n", finger );		// 총자리수 5개 / 왼쪽부터   / 나머지 자리수는  / 공란으로 채우기
		System.out.printf( "finger = [%-5d]%n", finger  );	// 총자리수 5개 / 오른쪽부터 / 나머지 자리수는 / 공란으로 채우기
		System.out.printf( "finger = [%05d]%n", finger  );	// 총자리수 5개 / 왼쪽부터    / 나머지 자리수는 / 0으로 채우기
		
		System.out.printf( "big = %d%n", big );				// 정수형으로 포맷 프린터
		System.out.printf( "hex = %x%n",hex  );				// 16진수로 포맷
		System.out.printf( "hex = %#x%n",hex  );				// 16진수로 포맷 (# 은 접두사[ 16진수일때 0x, 8진수일때 0 ] )
		//System.out.printf( "",  );
		
		System.out.printf( "octNum  = %o, %d%n", octNum, octNum );		// 8진수를 8진수로 포맷프린트, 8진수를 8진수로 포맷프린트
		System.out.printf( "hexNum  = %x, %d%n", hexNum, hexNum );	// 16진수를 16진수로 포맷프린트, 16진수를 정수형으로 포맷프린트
		System.out.printf( "binNum  = %s, %d%n", Integer.toBinaryString(binNum), binNum );	// 이진수를 Integer.toBinaryString을 써서 이진 문자열로 포맷 프린트, 이진수를 이진수로 포맷프린트

	}//main----------

}//class ----------------

/*
 * 
		b = 1
		s = 2
		c = A, 65, 
		finger = [   10]
		finger = [10   ]
		finger = [00010]
		big = 100000000000
		hex = ffffffffffffffff
		hex = 0xffffffffffffffff
		octNum  = 10, 8
		hexNum  = 10, 16
		binNum  = 1111, 15

 * 
 * */
