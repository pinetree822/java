package net.tis.day0608;

import java.util.Scanner;

public class TestSJ {
	
	public int getSum(int kor, int eng) {
		int tot=0;
		tot=(kor+eng);
		return tot;
	}// getSum()
	
	public double getAverage(int total)
	{
		return (double)total/2;
	}// getAverage()
	
	public void display(String name,int kor,int eng,int total,double avg) {
		System.out.println(name + " �������� : " + kor);
		System.out.println(name + " �������� : " + eng);
		System.out.println(name + " ��ü���� : " + total);
		System.out.println(name + " ������� : " + avg);
	}
	public static void main(String[] args) {

		int kor=0, eng=0;
		// Scanner Ŭ���� Ű���� �Է�, ����, 0~100����
		Scanner scn = new Scanner(System.in);
		System.out.println("�����Է� >>> ");
		kor=scn.nextInt();
		
		System.out.println("�����Է� >>> ");
		eng=scn.nextInt();
		
		TestSJ sj = new TestSJ();
		int total = sj.getSum(kor, eng);
		double avg = sj.getAverage(total);
		
		sj.display("�浿",kor,eng,total,avg);
		
		// ����, ���, ����, ���
//		System.out.println(����);
//		System.out.println(���);
//		System.out.println(����);
//		System.out.println(���);
		
		
		// �޼ҵ��� �Ű�����, ���ϰ�
		
	}// main()
	
}// class TestSJ
