package net.tis.day26;

import java.math.BigInteger;
import java.util.Scanner;

public class TestSj {

	
//    |- TestSJ.java ���� 
//	    �հ�,��� 
//    ����1] ���70�����Ժ��� �հ�/ 0~69 �����
//
//    ����=175
//    ���=87.5
//    ���=���հ�
//
//	94������ ���=����
//	if( ���� ) {  }  �ܼ�
//	if( ����1 && ����2 && ����3 ) {  }  �ܼ�
//	
//	if( ���� ) {  }  else { }  ����
	
	public static void main(String[] args) {
		
		int kor=0, eng=0;
		double avg=0.0, hap=0.0;
		String message = "";
		String input = "";
		char grade='F';
		
		
		Scanner scn = new Scanner(System.in);

		
		System.out.println("���������� ���� ������ �Է��ϼ���.");
//		kor = Integer.parseInt(scn.nextLine().split(" ")[0]);// java.lang.NumberFormatException
//		System.out.println("input = " + String.format("%040x", new BigInteger(1, input.getBytes(/*YOUR_CHARSET?*/))));
		while(true) {
			input = "";
			input = scn.nextLine().split(" ")[0];
			if(input.length() >0 && input.matches("^[0]?[1-9].*")) {
				kor = Integer.parseInt(input);
				break;
			} else {
				System.out.println("���������¾��� ������ �Է��ϼ���.");
			}// else
		}// while

		
		System.out.println("���������� ���� ������ �Է��ϼ���.");
		while(true) {
			input = "";
			input = scn.nextLine().split(" ")[0];
			if(input.length() >0 && input.matches("^[0]?[1-9].*")) {
				eng = Integer.parseInt(input);
				break;
			} else {
				System.out.println("���������� ���� ������ �Է��ϼ���.");
			}// else
		}// while

		
		hap=kor+eng;
		avg=(double)hap/2;
		
		if(avg >= 70) message = "����";
		else message = "�����";

		System.out.println("��������=" + kor);
		System.out.println("��������=" + eng);
		System.out.println("����=" + hap);
		System.out.println("���=" + avg);
		System.out.println("���=" + message);
		
		
		scn.close();
	}// main
}// class
