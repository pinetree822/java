package net.tis.day0604;

import java.util.Scanner;


public class Emp {

	public int Gtotal;
//	protected static Scanner scn = new Scanner(System.in);// String name = scn.nextLine();
		
	
	public Emp() {
		System.out.println("Emp ������ �ñ�");
	}// Emp()
	
	
	public static void main(String[] args) {
		
		Emp me = new Emp();// newŰ���� ������ ��
		
		
		System.out.println("");
		String name = "����";
		Scanner scn = new Scanner(System.in);
		System.out.print("�޵� >>> ");
		name = scn.nextLine();
		
		System.out.print(""+ name);
		
	}
	
}// class Emp
