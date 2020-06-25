package net.tis.day0525;

public class CalculatorTest2 {

	public static void main(String[] args) {

		int a=7, b=7, c=7, d=7;
		int hap=0, tot=0, sum=0;

		
//		a=9	hap=9
//		b=8	tot=7
//		c=8	sum=8
// 		d++=7	++d=9
		
		a=a+1;
		hap=hap+(++a);
		System.out.println("a=" + a + "\thap=" + hap);
		
//		b=b+1;
		tot=tot+(b++);
		System.out.println("b=" + b + "\ttot=" + tot);
		
		c=c+1;
		sum=sum+c;
		System.out.println("c=" + c + "\tsum=" + sum);
		
		System.out.println("d++=" + d++ + "\t++d=" + ++d);

	}// main
}// class