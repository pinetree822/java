package net.tis.day0529;

import java.util.Calendar;
import java.util.Scanner;

public class TestHotel {

	public static void main(String[] args) {
		
		boolean hotel[] = new boolean[5];
		hotel[3] = true;
		
		for(int i=0; i<5; i++)
		{
			System.out.print((i+1) + "ķ��\t");
		}
		System.out.println();
		
		
		for(int i=0; i<5; i++)
		{
			if(hotel[i]==true)
			{
				System.out.print("������\t");
			} else{ // if
				System.out.print("�࿹��\t");
			}
		}// for
		
	}// main
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	static String roomChk(boolean chk)
//	{
//		return chk==false?"���":"����Ϸ�";
//	}
//	
//	public static void main(String[] args) {
//		
//		boolean hotel[] = new boolean[5];// �� �����
//		String weeks[] = {"��","��","ȭ","��","��","��","��"};
//		String apPm[] = {"����","����"};
//		// ��� ����Ʈ �����ֱ�
//		// ������ ���ȣ
//		// �� ���� - ����
//		// ��ü�� ����Ʈ
//		
//		System.out.println("ȣ���� ��ü �� ����Ʈ ����");
//		for(int i=0; i<hotel.length; i++)
//			System.out.println( "�� : [ " + i + " ] " + roomChk(hotel[i]) );
//		
//		
//		// �Է� �ڵ鸵
//		Scanner scn = new Scanner(System.in);
//		
//		// ȣ�� ���ȣ�� ���� ���
//		System.out.println();
//		System.out.print("ȣ�� �� ��ȣ�� ������ �Է����ּ���. >>> ");
//		
//		// ���� �� ��ȣ �Է¹ޱ�
//		int matchNum = scn.nextInt();
//		
//		// ���� �� ���� ���
//		hotel[matchNum] = true;
//		
//		
//
//        // �⺻������ ���糯¥�� �ð����� �����ȴ�.
//        Calendar today = Calendar.getInstance();
//        System.out.println(
//        				today.get(Calendar.YEAR) + "�� " + 
//        				(today.get(Calendar.MONTH) + 1) + "�� " + 
//        				today.get(Calendar.DATE) + "�� " + 
//        				weeks[ today.get(Calendar.DAY_OF_WEEK) ] + "���� " +	// (1~7, 1:�Ͽ���)
//        				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:����, 1:����)
//        				today.get(Calendar.HOUR) + "�ð� " + 					// (0~11)
//        				//today.get(Calendar.HOUR_OF_DAY) + "�ð� " +			// (0~23)
//        				today.get(Calendar.MINUTE) + "�� " + 					// (0~59)
//        				today.get(Calendar.SECOND) + "�� " 					// (0~59)
//        );
//		// ���� �Ϸ� �޽��� �����ֱ�
//		System.out.println("ȣ�� : " + matchNum + "�� �� ����Ϸ� �Ǿ����ϴ�.");
//		System.out.println();
//		
//		
//	}// main
	
}// class hotel