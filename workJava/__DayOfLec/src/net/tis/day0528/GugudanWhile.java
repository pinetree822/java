package net.tis.day0528;

import java.lang.reflect.Executable;

public class GugudanWhile {

	public static void main(String[] args) {
		
		int dan=5;
		int i=1;
		boolean flag = true; // bool type


		
		
		
		while(flag)
		{
			System.out.println(dan + "*");
			
			i ++;
			if(i >5) flag=false;
		}// while

		
//		while(flag)
//		{
//			System.out.println(dan + "*");
//			
//			i ++;
//			if(i >5) break;
//		}// while
		
		
		
//		while( i<10)
//		{
//			System.out.println(dan + " * " + i + " = " +dan*i);
//			i ++;
//		}// while
		
		
	}// main
	
}// class GugudanWhile


//5 * 1 = 5
//5 * 2 = 10
//5 * 3 = 15
//5 * 4 = 20
//5 * 5 = 25
//5 * 6 = 30
//5 * 7 = 35
//5 * 8 = 40
//5 * 9 = 45
