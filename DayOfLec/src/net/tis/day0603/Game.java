package net.tis.day0603;

import java.util.Scanner;


class Playing {
	static Scanner sc = null;
	static int cnt = 0;
	int num = 0;
	
	public Playing() {
		sc = new Scanner(System.in);
	}

}

public class Game {
	
	public static void main(String[] args) {
		Playing pScn = new Playing();

		System.out.println("오빠");
		System.out.println("점수입력 >>> ");
		System.out.println(pScn.sc.nextInt());
		System.out.println("cnt = " + Playing.cnt);
//		System.out.println("num = " + Playing.num);
		
		
		System.out.println("메이플");
		System.out.println("점수입력 >>> ");
		System.out.println(Playing.sc.nextInt());
		System.out.println("cnt = " + pScn.cnt++);
//		System.out.println("num = " + Playing.num++);
		
		
		System.out.println("오빠");
		System.out.println("점수입력 >>> ");
		System.out.println(Playing.sc.nextInt());
		System.out.println("cnt = " + Playing.cnt);
//		System.out.println("num = " + Playing.num);
		
//		System.out.println(sc.nextInt());
//		int jumsu = new Scanner(System.in).nextInt();
	}
}// class Game




//
//public class Game {
//	
//	static int cnt = 0;
//	int num = 0;
//	
//	
//	public static void main(String[] args) {
//		
//		Game a = new Game();
//
//		System.out.println("a.cnt = " + a.cnt);
//		System.out.println("a.cnt++ = " + a.cnt++);
//		System.out.println("a.cnt = " + a.cnt);
//		
//		System.out.println("a.num = " + a.num);
//		System.out.println("a.num++ = " + a.num++);		
//		System.out.println("a.num = " + a.num);
//		System.out.println("===================");
//		
//		
//		Game b = new Game();
//		System.out.println("b.cnt = " + b.cnt);
//		System.out.println("b.cnt++ = " + b.cnt++);
//		System.out.println("b.cnt = " + b.cnt);
//		
//		System.out.println("b.num = " + b.num);
//		System.out.println("b.num++ = " + b.num++);
//		System.out.println("b.num = " + b.num);
//		
//
//
//		String lineSeparator = System.getProperty("line.separator");
//		System.out.println("lineSeparatory = " + lineSeparator.charAt(0));
//		
//	}
//}// class Game

