package net.tis.day22;

import java.text.Format;

public class Home10 {
	
//		�⺻����1] ���������� ����ϼ���
//		int b=7;
//		int c=6;
//		������ 6  7 

	public static void main(String[] args) {
		
		int b=7;
		int c=6;
//		������ 6  7
		
		System.out.printf("������ %s", sort1(b,c));;
		
	}
	
	
	static String sort1(int a, int b) {
		String tmp="";
		if(a>b)
			tmp = b + " " + a;
		else 
			tmp = a+ " " + b;
		return tmp;
	}
	
	
}
