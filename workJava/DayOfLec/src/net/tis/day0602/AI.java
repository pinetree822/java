package net.tis.day0602;

import java.util.Scanner;

public class AI {

	// �ܵ����� main�޼ҵ尡 ��� �ܵ� ����
	String name = "����";// field=�ʵ�=��������=member����=Global
	
	// Constructor = �⺻ ������ = ��������
	// �����ڴ� newŰ���� �������� ȣ��
	public AI() {
	}
	
	void info() {// none-static �޼ҵ�
		Scanner scn = new Scanner(System.in);// localObject
		System.out.println("AIŬ���� info�޼ҵ� ");
		System.out.println("AIŬ���� �̸�: " + name);
	}// info()
	
	// a,b �Ű�����=parameter
	void guessMax(int a, int b) {
		System.out.println("AIŬ���� guess�޼ҵ� ");
		System.out.println("AIŬ���� �̸�: " + name);
		System.out.println("AIŬ���� �ִ밪: " +(a>b?a:b) );
	}// guessMax()
	
	static void book(){
		System.out.println();
		System.out.println();
	}
	
//	
//	public static void main(String[] args) {
//		
//	}
}// class AI
