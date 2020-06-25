package _Test02;

public class TypeConversion {

	public static void main(String[] args) {
		byte b = 127;
		int i = 100;

		
		System.out.println(b+i);// 227, b가 int타입으로 자동변환
		System.out.println(10/4);// 2
		System.out.println(10.0/4);// 2.5 4가 4.0으로 자동변환
		System.out.println(0x12340041);// 305397825
		System.out.println((char)0x12340041);// A
		
		System.out.println((byte)(b+i));// -29
		System.out.println((int)2.9 + 1.8);// 3.8
		System.out.println((int)(2.0 + 1.8));// 3
		System.out.println((int)2.9 + (int)1.8);// 3
	}

}
