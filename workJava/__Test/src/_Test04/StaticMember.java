package _Test04;
import java.text.DecimalFormat; // 숫자에 콤마
import java.util.Scanner;


class CurrencyConverter
{
	private static double rate; // 1$에 대한 원화
	
	// 미달러 환율 설정
	public static void setRate(double r)
	{
		rate = r;
	}
	
	// 원화를 달러로
	public static double toDollar(double won)
	{
		return won/rate;
	}
	
	// 달러를 원화로
	public static double toKWR(double dollar)
	{
		return dollar * rate;
	}
}// class



//환율(1달러)>>1270
//
//>> 환율 : 1.00$ = 1270.00원 
//========================
//
//10,000,000원은 7,874.02$ 입니다.
//100$은 127,000원 입니다.

public class StaticMember {

	public static void main(String[] args) {
		
		DecimalFormat formatter = new DecimalFormat("###,###.##");// 숫자 콤마
		Scanner scn = new Scanner(System.in);
		System.out.print("환율(1달러)>>");
		
		double rate = scn.nextDouble();
		double dollarVal = 100;
		double wonVal = 10000000;
		CurrencyConverter.setRate(rate); // 미 달러환율 설정

//		System.out.println(wonVal + "원은 $" + CurrencyConverter.toDollar(wonVal) + " 입니다.");
//		System.out.printf("%.2f원은 $%.2f 입니다.\r\n", wonVal, CurrencyConverter.toDollar(wonVal));
//		System.out.printf("$%.2f는 %.2f원 입니다.", dollarVal, CurrencyConverter.toKWR(dollarVal));

		System.out.println();
		System.out.printf(">> 환율 : %.2f$ = %.2f원 \r\n", (double) 1, (double)rate );
		System.out.println("========================\r\n");
		System.out.printf("%s원은 %s$ 입니다.\r\n", formatter.format(wonVal), formatter.format(CurrencyConverter.toDollar(wonVal)) );
		System.out.printf("%s$은 %s원 입니다.\r\n", formatter.format(dollarVal), formatter.format(CurrencyConverter.toKWR(dollarVal)) );
		
		scn.close();
	}// main
	
}// class












