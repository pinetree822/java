package _Test06.app;

import _Test06.lib.Calculator;


public class GoodCalc extends Calculator{
	// Че
	public int add(int a, int b) {
		return a+b;
	}
	// Тї
	public int subtract(int a, int b) {
		return a-b;
	}
	// ЦђБе
	public double average(int[] a) {
		double sum=0;
		for(int i=0; i<a.length; i++)
			sum += a[i];
		return sum/a.length;
	}
	// main
	public static void main(String[] args) {
		
		
//		5
//		-1
//		3.0

		Calculator c = new GoodCalc();
		System.out.println(c.add(2, 3));
		System.out.println(c.subtract(2, 3));
		System.out.println(c.average(new int [] {2,3,4}));
		
	}// main
}
