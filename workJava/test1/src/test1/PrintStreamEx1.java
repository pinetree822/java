package test1;
import java.util.Date;

public class PrintStreamEx1 {

	public static void main(String[] args) {
		int i = 65;
		float f = 1234.56789f;
		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		Date d4 = new Date();

		System.out.printf("문자 %c의 코드는 %d\n", i, i);				// 포맷프린트 유형 : i를 %c는 문자형, %d는 정수형 으로 프린트
		System.out.printf("%d는 8진수로 %o, 16진수로 %x\n", i, i, i);// 포맷프린트 유형 : i를 %d 정수형, %o는 8진수, %x는 16진수로 프린트 
		System.out.println();
		
		System.out.printf("123456789012345678901234567890\n");// println("") 같다
		System.out.printf("%s%-5s%5s\n","123", "123","123");		// i를 %s 문자열, %-5s 빈자리공백이며 왼쪽정렬인 5자리숫자 문자열, %5s 빈자리공백으로 5자리숫자 문자열 
		System.out.printf("%-8.1f%8.1f %e\n", f, f, f);					
		// f를 %-8.1f 소숫점이상 최소 6자리이며, 소숫점 이하 1자리, 출력될 자리수를 최소 8자리(소수점포함) 확보하며 /빈자리는 공백으로 채우고 왼쪽 정렬하고 프린트
		// f를 %8.1f  소숫자이상 최소 6자리이며, 소숫점 이하 1자리, 출력될 자리수를 최소 8자리(소수점포함) 확보하며 /빈자리는 0으로 채우고 프린트
		// f를 %e 지수형태 프린트
		System.out.println();
		
		
		// %tR = %tH:%tM = 시분(24시간) = 21:05
		// %tT = %tH:%tM:%tS = 시분초(24시간) = 21:05:33
		// %tD = %tm:%td:%ty = 연월일 = 02/16/07
		// %tF = %tY-%tm-%td = 연월일 = 2007-02-16
		
		System.out.printf("오늘은 %tY년 %tm월 %td일 입니다.\n", d1, d2, d3, d4);
		System.out.printf("지금은 %tH시 %tM분 %tS초 입니다.\n", d1, d2, d3, d4);
		System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초 입니다.\n", d1);// %1$tH 에서 1$의 의미는 뒤에 따라오는 매개변수 d1을 의미한다.
	}// 
	
}// PrintStreamEx1

/*

문자 A의 코드는 65
65는 8진수로 101, 16진수로 41

123456789012345678901234567890
123123    123
1234.6    1234.6 1.234568e+03

오늘은 2016년 10월 18일 입니다.
지금은 00시 25분 49초 입니다.
지금은 00시 25분 49초 입니다.



*/