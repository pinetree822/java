package net.tis.day22;

import java.util.Calendar;
import java.util.Scanner;

public class TestCamping {

	static String roomChk(boolean chk)
	{
		return chk==false?"���":"����";
	}

	
// 
	
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

//		 ��� ����Ʈ �����ֱ�
//		 ������ ���ȣ
//		 �� ���� - ����
//		 ��ü�� ����Ʈ
		
//		ķ���� ������� Ȯ��// ����Ʈ
//		1.���� 2.��� 3.���� 9.����
		
//		1) ����<�Խ�> 2)��� 3) ���� 4) ��ü 9)����
//		����Ʈ���
//		����̸� ���డ��
//		����� �ƴϸ� ��� ����

		
		// �Է� �ڵ鸵
		Scanner scn = new Scanner(System.in);// �Է���ġ
		int inNum = 0;// ���� ��ȣ
		int matchNum = 0;// ��˻�(����,����)��ȣ
        Calendar today;
		
		while(true)
		{
			switch (inNum) {// "�����ȣ"
			
				////////////////////////////////case1 ���� ////////////////////////////////
				case 1:// ����
					// ȣ�� ���ȣ�� ���� ���
					System.out.println();
					System.out.print("��� �濡�� �����Ͻðڽ��ϱ�? >>> ");
					System.out.println();

					// ���� �� ��ȣ �Է¹ޱ�, �Է¹��� ������ 1 ���� �ε����� ����
					matchNum = scn.nextInt();
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					matchNum -= 1; 
					
					// ����� ������ Ȯ��
					if(hotel[matchNum]==true)
					{
						System.out.println(">>> ����� ���Դϴ�.");
						System.out.println("-----------------------------------------");
						break;
					} else {
						// �ش�� �ε��� ������Ʈ �ϱ�
						hotel[matchNum] = true;
					}


			        // �⺻������ ���糯¥�� �ð����� �����ȴ�.
			        today = Calendar.getInstance();
			        System.out.println(
			        				today.get(Calendar.YEAR) + "�� " + 
			        				(today.get(Calendar.MONTH) + 1) + "�� " + 
			        				today.get(Calendar.DATE) + "�� " + 
			        				weeks[ today.get(Calendar.DAY_OF_WEEK) ] + "���� " +	// (1~7, 1:�Ͽ���)
			        				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:����, 1:����)
			        				today.get(Calendar.HOUR) + "�ð� " + 					// (0~11)
			        				//today.get(Calendar.HOUR_OF_DAY) + "�ð� " +			// (0~23)
			        				today.get(Calendar.MINUTE) + "�� " + 					// (0~59)
			        				today.get(Calendar.SECOND) + "�� " 					// (0~59)
			        );
					// ���� �Ϸ� �޽��� �����ֱ�
					System.out.println("ȣ�� : " + (matchNum+1) + "�� �� ����Ϸ� �Ǿ����ϴ�.");
					System.out.println("-----------------------------------------");


					break;
	
					
					
				//////////////////////////////// case2 ���////////////////////////////////
				case 2:// ���

					// ȣ�� ���ȣ�� ���� ���
					System.out.println();
					System.out.print("��� �濡�� ����Ͻðڽ��ϱ�? >>> ");
					System.out.println();

					// ���� �� ��ȣ �Է¹ޱ�, �Է¹��� ������ 1 ���� �ε����� ����
					matchNum = scn.nextInt();
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					matchNum -= 1; 

					
					// �� ������ Ȯ��
					if(hotel[matchNum] == false)
					{
						System.out.println(">>> �� ���Դϴ�.");
						System.out.println("-----------------------------------------");
						break;
					} else {
						// �ش�� �ε��� ������Ʈ �ϱ�
						hotel[matchNum] = false;
					}
					
					// �ش�� �ε��� ������Ʈ �ϱ�


			        // �⺻������ ���糯¥�� �ð����� �����ȴ�.
			        today = Calendar.getInstance();
			        System.out.println(
			        				today.get(Calendar.YEAR) + "�� " + 
			        				(today.get(Calendar.MONTH) + 1) + "�� " + 
			        				today.get(Calendar.DATE) + "�� " + 
			        				weeks[ today.get(Calendar.DAY_OF_WEEK) ] + "���� " +	// (1~7, 1:�Ͽ���)
			        				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:����, 1:����)
			        				today.get(Calendar.HOUR) + "�ð� " + 					// (0~11)
			        				//today.get(Calendar.HOUR_OF_DAY) + "�ð� " +			// (0~23)
			        				today.get(Calendar.MINUTE) + "�� " + 					// (0~59)
			        				today.get(Calendar.SECOND) + "�� " 					// (0~59)
			        );
					// ���� �Ϸ� �޽��� �����ֱ�
					System.out.println("ȣ�� : " + (matchNum+1) + "�� �� ��� �Ǿ����ϴ�.");
					System.out.println("-----------------------------------------");
					break;

				////////////////////////////////case3 ���� ////////////////////////////////
				case 3://����

					// ��û�� ��ȣ �Է¹ޱ� - ����Ȯ��
					System.out.print("��� ���� Ȯ���Ͻðڽ��ϱ�? >>> ");
					matchNum = scn.nextInt();
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					matchNum -= 1; 
					
					// �ش� �� ���� Ȯ��
					System.out.println();
					if( hotel[matchNum]==true ) {
						System.out.println("ȣ�� : " + (matchNum+1) + "�� ���� ����� �Դϴ�.");
						System.out.println("-----------------------------------------");
					} else {
						System.out.println("ȣ�� : " + (matchNum+1) + "�� ���� ��� �Դϴ�.");
						System.out.println("-----------------------------------------");
					}
					System.out.println();
					break;

				////////////////////////////////case4 ��ü����Ʈ ////////////////////////////////
				case 4://��ü����Ʈ

					// ��ü �� ��Ȳ üũ����Ʈ
					System.out.println("ȣ���� ��ü �� ����Ʈ ����");
					for(int i=0; i<hotel.length; i++)
						System.out.println( "�� : [ " + (i+1) + " ] " + roomChk(hotel[i]) );
					
					break;

				////////////////////////////////case9 ���� ////////////////////////////////
				case 9://����
					System.out.println("ȣ�� : ���� ���α׷��� �����մϴ�.");
					System.exit(0);
					break;

				////////////////////////////////default ////////////////////////////////
				default:
//					System.out.println("ȣ���� ��ü �� ����Ʈ ����");
//					for(int i=0; i<hotel.length; i++)
//						System.out.println( "�� : [ " + i + " ] " + roomChk(hotel[i]) );
					break;
			}// switch

			// ��ü �� ��Ȳ üũ����Ʈ
			System.out.println();
			System.out.println("ȣ���� ��ü �� ����Ʈ ����");
			for(int i=0; i<hotel.length; i++)
				System.out.println( "�� : [ " + (i+1) + " ] " + roomChk(hotel[i]) );

			System.out.println();
			System.out.println("1) ����<�Խ�> 2)��� 3) ���� 4) ��ü 9)����");
			
			// ���� ��ȣ �Է¹ޱ�
			System.out.print(">>> ");
			inNum = scn.nextInt();
			
		}// while
		

//		// ��ü �� ����Ʈ �����ֱ�
//		for(int i=0; i<hotel.length; i++)
//			System.out.println( "�� : [ " + i + " ] " + roomChk(hotel[i]) );

		// �� �Է� �ٽ� �ϱ�/// ��ǵ� �����ϰ�
		
	}// main
	
}// class hotel
