package net.tis.day0525;




public class Calculator80 {

	public static void main(String[] args) {

//		3 + 1 = 4
//		"3" + 1 = 31
		System.out.println("3 + 1 = " + (3 + 1));
		System.out.println("\"3\" + 1 = " + ("3" + 1));
		
		
		int a=19, b=3;
		int hap=0, sub=0, gob=0, nmg=0;
		double  mok;// 0.0
		
		hap=a+b; sub=a-b;
		gob=a*b; nmg=a%3;
		mok=a/b;

//		hap(22)=a+b
//		sub(16)=a-b
//		gob(57)=a*b
//		nmg(1)=a/b
//		mok(6.0)=a/b
//		mok(6.00)=a/b
		
		System.out.println("hap("+hap+")=a+b");
		System.out.println("sub("+sub+")=a-b");
		System.out.println("gob("+gob+")=a*b");
		System.out.println("nmg("+nmg+")=a/b");
		System.out.println("mok("+mok+")=a/b");
		System.out.printf("mok(%.2f)=a/b", mok);
		System.out.println("");
		
	}// main
}// class
