package net.tis.lecTest;

import java.util.Scanner;

public class Home19 {

	public static void main(String[] args) {
		
		// 배열 사용금지  절대금지
		// for문 이용해서 한꺼번에 입력받아서
		// 한번에 출력

//		System.out.print(z+" ");
//		hap=x+y+z;
//		System.out.println("hap= " + hap);
	
		
//		// 숙제///////////////////////////////////////////////////////////
		int x = 0, y = 0, z = 0, hap=0;
		Scanner scn = new Scanner(System.in);
		
		System.out.print("x >>>");
		x = scn.nextInt();System.out.println();

		System.out.print("y >>>");
		y = scn.nextInt();System.out.println();

		System.out.print("z >>>");
		z = scn.nextInt();System.out.println();
		
		hap = x + y + z;
		System.out.print("x + y + z >>>");
		System.out.println("hap= " + hap);
//		// 숙제///////////////////////////////////////////////////////////
		
		

		
		

	}// main
	
}// class Home19
