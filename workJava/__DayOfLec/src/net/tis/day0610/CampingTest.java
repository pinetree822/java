package net.tis.day0610;

import java.util.Scanner;

public class CampingTest {

	private boolean camp[]= new boolean[5];// �渮��Ʈ

	/*
	 * @param int ho 
	 * @return null
	 * 
	 */
	// �Խ�
	public void input(int ho){ //�ԽǸ޼ҵ��ȣ���� �Ű����� int,���ϰ� X
		if(camp[ho-1]==true)
			System.out.println("���� ������̶� ������ �� �����ϴ�.");
		else {
			System.out.println("ķ���� ���� ���� �Ͽ����ϴ�.");
			camp[ho-1] = true;
		}
	}// input()
	
	// ���
	public void output(int ho){ //��� �޼ҵ��ȣ���� �Ű����� int,���ϰ� X
		if(camp[ho-1]==false)
			System.out.println(ho + "�� ķ���濡�� ��Ǽ��񽺸� ����� �� �����ϴ�.");
		else {
			camp[ho-1] = false;
			System.out.println(ho + "�� ķ���濡�� ��� �����Ͽ����ϴ�.");
		}
	}// output()

	/*
	 * @param null
	 * @return void
	 */
	// ��ü ķ�� ��Ȳ üũ����Ʈ
	public void map()
	{
		System.out.println("-----------------------------------------");
		System.out.println("ķ�� ����Ʈ ����");
		System.out.println("-----------------------------------------");
		for(int i=0; i<camp.length; i++)
		{
			if(camp[i]==true)
				System.out.print(" " + (i+1) + ": �Խ�" );
			else
				System.out.print(" " + (i+1) + ": ���" );
		}
		System.out.println("\n-----------------------------------------");
	}// map()

	
	// msg = msg: �Խ�,���, max = �氳�� �ִ밪?
	public int write(String msg, int max) {// ���ϰ�, �Ű����� 2��

/*
 * @param msg
 * @param max
 * @return int
 * ķ���� ��ȣ�ޱ�
 * 
 * 
 */
		Scanner scn = new Scanner(System.in);
		int a=0;
		do {
			System.out.println(">>" + msg + " �� ���ȣ?");
			a=Integer.parseInt(scn.nextLine());
			if(msg.contentEquals("�Խ�")) input(a);
			else output(a);
		} while(a<1||a>max);
		
		return a;// ���ȣ�� 1���� �۴ٸ� a=0, ���ȣ�� max���� ũ�� a=0;
		
	}// write()
	
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		CampingTest tc = new CampingTest();
		int ret;
		tc.map();// �� ������Ȳ �ѹ� ���
		

		while( true ) {
			System.out.print("1.�Խ� 2.��� 3.�����Ȳ 9.���� >>> ");
			int sel=Integer.parseInt(scn.nextLine());
			
			if(sel==1) { // �Խ�
				ret=tc.write("�Խ�", 5);
			} else if(sel==2) { // ���
				ret=tc.write("���", 5);
			} else if(sel==3) { // �����Ȳ
				tc.map();
			} else if(sel==9) { // ����
				System.out.print("ķ�� ���α׷� ���� �Ǿ����ϴ�.");
				System.exit(1);
			}// if
		}// while
		
//		int dt1 = tc.write("�Խ�", 2);
//		int dt2 = tc.write("�Խ�", 4);
	}
	
	
}// class test12
