package net.tis.day0529;

import java.util.Calendar;
import java.util.Scanner;


/// �����ؾߵ�
public class TestHotel1 {

	static String roomChk(boolean chk)
	{
		return chk==false?"���":"����";
	}

	
//	ȣ���� ��ü �� ����Ʈ ����
//	�� : [ 0 ] ���
//	�� : [ 1 ] ���
//	�� : [ 2 ] ���
//	�� : [ 3 ] ���
//	�� : [ 4 ] ���
//
//	ȣ�� �� ��ȣ�� ������ �Է����ּ���. >>> 1
//	2020�� 5�� 29�� ����� ����1�ð� 53�� 3�� 
//	ȣ�� : 1�� �� ����Ϸ� �Ǿ����ϴ�.
	
	
	public static void main(String[] args) {
		
		boolean hotel[] = new boolean[5];// �� �����
		String weeks[] = {"��","��","ȭ","��","��","��","��"};
		String apPm[] = {"����","����"};
		// ��� ����Ʈ �����ֱ�
		// ������ ���ȣ
		// �� ���� - ����
		// ��ü�� ����Ʈ
		

		


		
		while(true)
		{
			System.out.println("ȣ���� ��ü �� ����Ʈ ����");
			for(int i=0; i<hotel.length; i++)
				System.out.println( "�� : [ " + (i+1) + " ] " + roomChk(hotel[i]) );

			// �Է� �ڵ鸵
			Scanner scn = new Scanner(System.in);
			
			// ȣ�� ���ȣ�� ���� ���
			System.out.println();
			System.out.print("ȣ�� �� ��ȣ�� ������ �Է����ּ���. >>> ");
			System.out.println();
			
			
			
			// �Է¹��� ȣ�� ���ȣ ����  hotel�迭�� �ε����� ��ȯ(hotel) Ȯ��
			int matchNum = scn.nextInt()-1;// ���ȣ�� �ε����� ��ȯ
			int matchRoom = (matchNum>0 && matchNum<=hotel.length)?matchNum:1;//�ε����� ����� 
			
			

			// ���� : 1, ��� : 0
			// �濡 ���� ���º�ȭ �Է� : ����/��� �� ��ȣ
			
			// 0 < matchNum-1 < hotel.length
			// ��ġ�� ���ȣ���� Ȯ��
			// ���� ���º�ȭ�� �´���
			// ����(�Խ�) 	-> ���
			// ��� 		-> ����(�Խ�)
			if(0 <= matchNum) {}

			// ���� �� ���� ���
			hotel[matchNum] = true;

			
			break;
		}
		
		
		
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
//		// ��ü �� ����Ʈ �����ֱ�
//		for(int i=0; i<hotel.length; i++)
//			System.out.println( "�� : [ " + i + " ] " + roomChk(hotel[i]) );
//		
//		

		// �� �Է� �ٽ� �ϱ�/// ����(�Խ�)�� ��� �����Ѵ�.
		// ����� ����� �Ұ����ϴ�.
		
	}// main
	
}// class hotel