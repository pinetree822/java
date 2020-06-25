package test2;

// 실수형과 더블형의 printf표시
public class FloatEx1 {
	public static void main(String[] args)
	{
		float f     = 9.12345678901234567890f;
		float f2   = 1.2345678901234567890f;
		double d = 9.12345678901234567890d;
		
		System.out.println("        123456789012345678901234%n");
		System.out.printf("f     :   %f%n", f);// 소수점 이하 6째자리까지 출력
		System.out.printf("f     :   %24.20f%n", f);
		System.out.printf("f2   :   %24.20f%n", f2);
		System.out.printf("d    :   %24.20f%n", d);
	}
}

/*
		        123456789012345678901234%n
		f     :   9.123457								<--- 7자리에서 반올림 되었음
		f     :     9.12345695495605500000
		f2   :     1.23456788063049320000		<--- 정밀도가 7자리이므로 원래값과 7자리이후 부터는 차이가 나게 저장된다.
		d    :     9.12345678901234600000
*/