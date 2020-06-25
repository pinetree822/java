package test2;

public class PrintEx2 {

	public static void main(String[] args) {
		String url = "www.codechobo.com";
		
		float f1 = .10f;
		float f2 = 1e1f;
		float f3 = 3.14e3f;
		double d = 1.23456789;

		System.out.printf("f1 = %f, %e, %g%n", f1, f1, f1); // 실수형, 지수형, 간략하게, 프린트
		System.out.printf("f2 = %f, %e, %g%n", f2, f2, f2);
		System.out.printf("f3 = %f, %e, %g%n", f3, f3, f3);
		

		System.out.printf("d=%f%n", d ); // 정수형을 실수형을 프린트
		System.out.printf("d=%14.10f%n", d );		// 자리수 14자리 ( . 도 자리수다)
		

		System.out.printf( "[12345678901234567890]%n" );
		
		System.out.printf( "[%s]%n", url );		// 문자열 출력
		System.out.printf( "[%20s]%n", url );	// 자리수가 20자인
		System.out.printf( "[%-20s]%n", url );	// 왼쪽 정렬
		System.out.printf( "[%.8s]%n", url );	// 왼쪽에서 8글자만 출력

	}// main-------------

}//-- class -------------


/*
 * 
		f1 = 0.100000, 1.000000e-01, 0.100000
		f2 = 10.000000, 1.000000e+01, 10.0000
		f3 = 3140.000000, 3.140000e+03, 3140.00
		
		d=1.234568
		d=  1.2345678900
		
		[12345678901234567890]
		
		[www.codechobo.com]
		[   www.codechobo.com]
		[www.codechobo.com   ]
		[www.code]

*/
