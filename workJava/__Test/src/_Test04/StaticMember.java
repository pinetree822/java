package _Test04;
import java.text.DecimalFormat; // ���ڿ� �޸�
import java.util.Scanner;


class CurrencyConverter
{
	private static double rate; // 1$�� ���� ��ȭ
	
	// �̴޷� ȯ�� ����
	public static void setRate(double r)
	{
		rate = r;
	}
	
	// ��ȭ�� �޷���
	public static double toDollar(double won)
	{
		return won/rate;
	}
	
	// �޷��� ��ȭ��
	public static double toKWR(double dollar)
	{
		return dollar * rate;
	}
}// class



//ȯ��(1�޷�)>>1270
//
//>> ȯ�� : 1.00$ = 1270.00�� 
//========================
//
//10,000,000���� 7,874.02$ �Դϴ�.
//100$�� 127,000�� �Դϴ�.

public class StaticMember {

	public static void main(String[] args) {
		
		DecimalFormat formatter = new DecimalFormat("###,###.##");// ���� �޸�
		Scanner scn = new Scanner(System.in);
		System.out.print("ȯ��(1�޷�)>>");
		
		double rate = scn.nextDouble();
		double dollarVal = 100;
		double wonVal = 10000000;
		CurrencyConverter.setRate(rate); // �� �޷�ȯ�� ����

//		System.out.println(wonVal + "���� $" + CurrencyConverter.toDollar(wonVal) + " �Դϴ�.");
//		System.out.printf("%.2f���� $%.2f �Դϴ�.\r\n", wonVal, CurrencyConverter.toDollar(wonVal));
//		System.out.printf("$%.2f�� %.2f�� �Դϴ�.", dollarVal, CurrencyConverter.toKWR(dollarVal));

		System.out.println();
		System.out.printf(">> ȯ�� : %.2f$ = %.2f�� \r\n", (double) 1, (double)rate );
		System.out.println("========================\r\n");
		System.out.printf("%s���� %s$ �Դϴ�.\r\n", formatter.format(wonVal), formatter.format(CurrencyConverter.toDollar(wonVal)) );
		System.out.printf("%s$�� %s�� �Դϴ�.\r\n", formatter.format(dollarVal), formatter.format(CurrencyConverter.toKWR(dollarVal)) );
		
		scn.close();
	}// main
	
}// class












