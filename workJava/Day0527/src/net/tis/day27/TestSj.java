package net.tis.day27;

import java.math.BigInteger;
import java.util.Scanner;

public class TestSj {


	public static void main(String[] args) {
		
		int kor=0, eng=0;
		double avg=0.0, hap=0.0;
		String name = "kim";
		String msg = "";
		String input = "";
		char grade='F';

		kor=90; eng=85;
		hap=kor+eng;
		avg=(double)hap/2;
		
		if(avg >= 70) msg = "���հ�";
		else msg = "�����";
		

		String ret = (avg>=70) ? "pass" : "failed";
		boolean flag = (avg>=70) ? true : false;
		double point = (avg>=70) ? 7.9 : 1.2;
		int save = (avg>=70) ? 2000 : 9;
		

//		if(avg>=90) { grade='A'; }
//		if(avg>=80) { grade='B'; }
//		if(avg>=70) { grade='C'; }
//		if(avg>=60) { grade='D'; }
//		else { grade='F'; }
		
		
		// 100�������� switch(���ǿ� double����) {}
		// 87.2, 85.8, 89.7, 83.5
		switch ((int)avg/10) {
				case 10: grade='A';
				case 9: grade='B'; break;
				case 8: grade='C'; break;
				case 7: grade='D'; break;
				default: grade='F'; break;
		}// switch
		

		
		System.out.println("grade = " + grade);
		

		// 90~100 A, ...������ 590 F
		System.out.println("\n=========�� �� ó �� ==========");
		System.out.println("�̸�=" + name);
		System.out.println("����=" + hap);
		System.out.println("���=" + avg);
		System.out.println("����=" + grade);
		System.out.println("���=" + msg);
//		System.out.println("����=" + save);
//		System.out.println("��������=" + kor);
//		System.out.println("��������=" + eng);
		
		
		
		
		
	}// main
}// class
