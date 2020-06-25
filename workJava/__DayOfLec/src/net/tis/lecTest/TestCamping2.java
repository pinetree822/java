package net.tis.lecTest;

import java.util.Calendar;
import java.util.Scanner;

public class TestCamping2 {

	// ����,��� Ȯ���ؼ� ��ȯ
	static String roomChk(int chk)
	{
		return chk==0?"���":"����";
	}//
	
	
	// ��ü�� ����Ʈ
	static void roomList(int hotel[])
	{
		// ��ü �� ��Ȳ üũ����Ʈ
		System.out.println("ȣ���� ��ü �� ����Ʈ ����");
		for(int i=0; i<hotel.length; i++)
			System.out.println( "�� : [ " + (i+1) + " ] " + roomChk(hotel[i]) );
		System.out.println("-----------------------------------------");
	}

	// ������ �ð�
	static void regisTime()
	{
		String weeks[] = {"��","��","ȭ","��","��","��","��"};
		String apPm[] = {"����","����"};
        // �⺻������ ���糯¥�� �ð����� �����ȴ�.
        Calendar today = Calendar.getInstance();
        System.out.println(
        				today.get(Calendar.YEAR) + "�� " + 
        				(today.get(Calendar.MONTH) + 1) + "�� " + 
        				today.get(Calendar.DATE) + "�� " + 
        				weeks[ today.get(Calendar.DAY_OF_WEEK)-1 ] + "���� " +	// (1~7, 1:�Ͽ���)
        				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:����, 1:����)
        				today.get(Calendar.HOUR) + "�ð� " + 					// (0~11)
        				//today.get(Calendar.HOUR_OF_DAY) + "�ð� " +			// (0~23)
        				today.get(Calendar.MINUTE) + "�� " + 					// (0~59)
        				today.get(Calendar.SECOND) + "�� " 					// (0~59)
        );
	}
	
	
	// ���� ���
	static void titleBar(String text)
	{
		System.out.println();
		System.out.print(text);
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args) {
		
		int hotel[] = new int[5];// �� �����
		int inNum = 0;								// ���� ��ȣ
		int matchNum = 0;							// ��(����,����<�˻�>,���)��ȣ
		
		// �Է� �ڵ鸵
		Scanner scn = new Scanner(System.in);// �Է���ġ
		
		while(true)
		{
			switch (inNum) {// "���α׷� ���񽺹�ȣ"
			
				////////////////////////////////case1 ���� ////////////////////////////////
				case 1:// ���� // ȣ�� ���ȣ�� ���� ���
					// ���� ���
					titleBar("ȣ�� : ��� �濡�� �����Ͻðڽ��ϱ�? >>> ");

					// ���� �� ��ȣ �Է¹ޱ�, �Է¹��� ������ 1 ���� �ε����� ����
					matchNum = scn.nextInt();
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					matchNum -= 1; 
					
					// ����� ������ Ȯ��
					if(hotel[matchNum]==1)
					{
						titleBar("ȣ�� : >>> ����� ���Դϴ�.");
						titleBar("-----------------------------------------");
						break;
					} else {
						// �ش�� �ε��� ������Ʈ �ϱ�
						hotel[matchNum] = 1;
					}
			        
					regisTime();// ����¥,�ð�
					
					// ���� �Ϸ� �޽��� �����ֱ�
					titleBar("ȣ�� : " + (matchNum+1) + "�� �� ����Ϸ� �Ǿ����ϴ�.");
					titleBar("-----------------------------------------");

					roomList(hotel);// ��ü�渮��Ʈ					
					break;
	
					
					
				//////////////////////////////// case2 ���////////////////////////////////
				case 2:// ���

					// ���� ���
					titleBar("ȣ�� :  ��� �濡�� ����Ͻðڽ��ϱ�? >>> ");

					// ���� �� ��ȣ �Է¹ޱ�, �Է¹��� ������ 1 ���� �ε����� ����
					matchNum = scn.nextInt();
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					matchNum -= 1; 

					
					// �� ������ Ȯ��
					if(hotel[matchNum] == 0)
					{
						titleBar("ȣ�� : >>> �� ���Դϴ�.");
						titleBar("-----------------------------------------");
						break;
					} else {
						// �ش�� �ε��� ������Ʈ �ϱ�
						hotel[matchNum] = 0;
					}

					regisTime();// ����¥,�ð�
					
					// ���� �Ϸ� �޽��� �����ֱ�
					titleBar("ȣ�� : " + (matchNum+1) + "�� �� ��� �Ǿ����ϴ�.");
					titleBar("-----------------------------------------");

					roomList(hotel);// ��ü�渮��Ʈ					
					break;

				////////////////////////////////case3 ���� ////////////////////////////////
				case 3://����
					// ���� ���
					titleBar("ȣ�� : ��� ���� Ȯ���Ͻðڽ��ϱ�? >>> ");

					 // ��û�� ��ȣ �Է¹ޱ� - ����Ȯ��
					matchNum = scn.nextInt();
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					matchNum -= 1; 
					
					// �ش� �� ���� Ȯ��
					if( hotel[matchNum]==1 ) {
						titleBar("ȣ�� : " + (matchNum+1) + "�� ���� ����� �Դϴ�.");
						titleBar("-----------------------------------------");
					} else {
						titleBar("ȣ�� : ���� ���α׷��� �����մϴ�.");
						titleBar("ȣ�� : " + (matchNum+1) + "�� ���� ��� �Դϴ�.");
						titleBar("-----------------------------------------");
					}

					roomList(hotel);// ��ü�渮��Ʈ
					break;

				////////////////////////////////case4 ��ü����Ʈ ////////////////////////////////
				case 4://��ü����Ʈ
					roomList(hotel);// ��ü�渮��Ʈ
					break;

				////////////////////////////////case9 ���� ////////////////////////////////
				case 9://����
					// ���� ���
					titleBar("ȣ�� : ���� ���α׷��� �����մϴ�.");
					System.exit(0);
					break;

				////////////////////////////////default ���� ////////////////////////////////
				default :
					roomList(hotel);// ��ü�渮��Ʈ
					break;
			}// switch

			
			

			// ���� ���
			titleBar("1) ����<�Խ�> 2)��� 3) ���� 4) ��ü 9)����");
			
			// ���α׷� ���񽺹�ȣ �Է¹ޱ�
			System.out.print(">>> ");
			inNum = scn.nextInt();
			
		}// while

		
	}// main
	
}// class hotel
