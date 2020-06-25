package test2;

// 실수형 이진형변환
public class FloatToBinEx {

	public static void main(String[] args) {
		float f = 9.1234567f;
		int i = Float.floatToIntBits(f);// float의 값을 int형으로 변환해서 반환
		// 값이 오버플러우 정수형값에서 벗어나면 비정상적인 값을 반환한다.
		
		System.out.printf("%f%n", f);
		System.out.printf("%X%n", i);//16진수 출력
	}//--- main

}//---clas FloatToBinEx
/*
		9.123457		<--		9.1234567f
		4111F9AE	<--		Float.floatToIntBits(f);
*/