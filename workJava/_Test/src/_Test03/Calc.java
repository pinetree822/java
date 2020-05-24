package _Test03;

public class Calc {

	public static void main(String[] args) {
		
		double sum = 0.0;
		
		for(int i=0; i<args.length; i++)
		{
			sum += Double.parseDouble(args[i]);// 문자열을 실수(double 타입)으로 변환
		}// for
		
		System.out.println("합계는 = " + sum);
	}// main

}// Calc

// Terminal에서 실행시 bin에서 실행
// D:\_xampp\htdocs\java\workJava\_Test\bin>java _Test03.Calc
// 합계는 = 0.0

// D:\_xampp\htdocs\java\workJava\_Test\bin>java _Test03.Calc 1 2 3 4
// 합계는 = 10.0