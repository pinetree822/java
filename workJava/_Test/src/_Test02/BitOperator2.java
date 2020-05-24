package _Test02;

public class BitOperator2 {

	public static void main(String[] args) {
		
		int i = 170;
		
//		Number = 170
//		Binary = 10101010
//		Number of one bits = 4
//		Highest one bit = 128
//		Lowest one bit = 2
//		Number of leading zeros = 24
//				
		System.out.println("Number = " + i);
		System.out.println("Binary = " + Integer.toBinaryString(i));
		System.out.println("Number of one bits = " + Integer.bitCount(i));
		System.out.println("Highest one bit = " + Integer.highestOneBit(i));
		System.out.println("Lowest one bit = " + Integer.lowestOneBit(i));
		System.out.println("Number of leading zeros = " + Integer.numberOfLeadingZeros(i));
		
		
		// 비트 시프트 연산
		byte c = 20; // 0x14
		byte d = -8; // 0xf8
		
//		[시프트 연산 결과]
//		비트: 0014
//		비트: 00f8
//		0014
//		00f8
//		0080, 0050
//		0005, 0005
//		-002, 00fe
//		3ffffffe

		System.out.println("[시프트 연산 결과]");
		System.out.printf("%04x\n", (c));// 비트: 0014
		System.out.printf("%04x\n", (d));// 비트: 00f8
		System.out.printf("%04d, %04x\n", (c << 2), (c << 2)); // c를 2비트 왼쪽 시프트
		System.out.printf("%04d, %04x\n", (c >> 2), (c >> 2)); // c를 2비트 오른쪽 시프트, 0 삽입
		System.out.printf("%04d, %04x\n", (d >> 2), (d >> 2)); // d를 2비트 오른쪽 시프트. 1 삽입
		System.out.printf("%x\n", (d >>>2)); // d를 2비트 오른쪽 시프트. 0 삽입
		
	}

}
