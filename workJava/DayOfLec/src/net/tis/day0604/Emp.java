package net.tis.day0604;

import java.util.Scanner;


public class Emp {

	public int Gtotal;
//	protected static Scanner scn = new Scanner(System.in);// String name = scn.nextLine();
		
	
	public Emp() {
		System.out.println("Emp 생성자 궁금");
	}// Emp()
	
	
	public static void main(String[] args) {
		
		Emp me = new Emp();// new키워드 생성자 콜
		
		
		System.out.println("");
		String name = "저자";
		Scanner scn = new Scanner(System.in);
		System.out.print("메딕 >>> ");
		name = scn.nextLine();
		
		System.out.print(""+ name);
		
	}
	
}// class Emp
