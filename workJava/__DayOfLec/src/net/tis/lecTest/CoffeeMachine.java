package net.tis.lecTest;

import java.util.Calendar;
import java.util.Scanner;



public class CoffeeMachine {

//	
//	static String roomChk(boolean chk)
//	{
//		return chk==false?"���":"����Ϸ�";
//	}
//
//	
	
	
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		


		System.out.print("����� �Է�>>> ");
		int saveMoney = scn.nextInt();	// ���Ǳ� ���ݾ� ����
		int sellMoney = 0;	// �Ǹ� �ݾ�
		
		int seller; // ���Ǳ� ��ȣ ����
		String balance = "";			// "����ݾ�","��ȯ�ݾ�" ǥ��
		boolean orderChk = false;		// ����ݾ�+�Ǹűݾ� �����Ѱ�? Ȯ��üũ
		String msg = "";				// �޴����ý� ������ ��

		
		while(true)
		{	
			
			System.out.println("------------- Ŀ�� ���Ǳ� -------------");
			System.out.println("1.Ŀ��(300) 2.���ھ�(350) 3.��ȯ 4.����");


			System.out.print("�޴�����>>> ");	// ���Ǳ� �޴� ����  �Է�ǥ��
			seller = scn.nextInt(); 		// ���Ǳ� ��ȣ ����
			

			// �Ǹűݾ��� �ܿ����� ���°�? Ȯ��!
			if(seller==1) {			// Ŀ��
				sellMoney = 300;
			} else if(seller==2) {	// ���ھ�
				sellMoney = 350;
			} else if(seller==3) {	// �ܿ���
				sellMoney = 0;
			} else if(seller==4) {	// ����
				sellMoney = 0;
			}

			// �ֹ��� �������� Ȯ��
			// �ܾ��� ���Ƽ� �ݳ� �������� Ȯ��
			orderChk = false;
			if(saveMoney-sellMoney > 0) {
				orderChk = true;
				saveMoney-=sellMoney;
			}
			
			switch (seller) {
				case 1:
					msg = ((orderChk==true)?"Ŀ���ֹ� ���� ���ְ� ��ſ�.":"Ŀ���ֹ� ���� �ϼ˽��ϴ�.");
					balance = "����ݾ�";
					break;
				case 2:
					msg = ((orderChk==true)?"���ھ��ֹ� ���� ���ְ� ��ſ�.":"���ھ��ֹ� ���� �ϼ˽��ϴ�.");
					balance = "����ݾ�";
					break;
				case 3:
					msg = ((orderChk==true)?"�ܾ����� �ұ��?\n���� �����÷��� �����Ͻñ� �ٶ��ϴ�.":"�ܾ����� ���� �ϼ˽��ϴ�.");
					balance = "��ȯ�ݾ�";
					sellMoney = saveMoney;
					break;
				case 4:
					msg = "�ܵ������ص�Ƚ��ϴ�.\n���� ���Ǳ⸦ �����մϴ�.";
					balance = "��ȯ�ݾ�";
					sellMoney = 0;
					break;
			}

			// ����ݾ� - �ֹ��ݾ� = �ܾ�ǥ��
			System.out.println(msg);//  �ܾ׺����մϴ�.
			System.out.println(balance + "= " + saveMoney);
			System.out.println();

			
			if(seller == 4) break;
			
//			
//			System.out.print("����� �Է�>>>");
//			saveMoney = scn.nextInt();	// ���Ǳ� ���ݾ� ����

			
		}// while(true)
		
		

		
	}// main
	
}// class CoffeeMachine















//
//
//boolean hotel[] = new boolean[5];// �� �����
//String weeks[] = {"��","��","ȭ","��","��","��","��"};
//String apPm[] = {"����","����"};
//// ��� ����Ʈ �����ֱ�
//// ������ ���ȣ
//// �� ���� - ����
//// ��ü�� ����Ʈ
//
//System.out.println("ȣ���� ��ü �� ����Ʈ ����");
//for(int i=0; i<hotel.length; i++)
//	System.out.println( "�� : [ " + i + " ] " + roomChk(hotel[i]) );
//
//
//// �Է� �ڵ鸵
//Scanner scn = new Scanner(System.in);
//
//// ȣ�� ���ȣ�� ���� ���
//System.out.println();
//System.out.print("ȣ�� �� ��ȣ�� ������ �Է����ּ���. >>> ");
//System.out.println();
//
//// ���� �� ��ȣ �Է¹ޱ�
//int matchNum = scn.nextInt();
//
//// ���� �� ���� ���
//hotel[matchNum] = true;
//
//
//
//// �⺻������ ���糯¥�� �ð����� �����ȴ�.
//Calendar today = Calendar.getInstance();
//System.out.println(
//				today.get(Calendar.YEAR) + "�� " + 
//				(today.get(Calendar.MONTH) + 1) + "�� " + 
//				today.get(Calendar.DATE) + "�� " + 
//				weeks[ today.get(Calendar.DAY_OF_WEEK) ] + "���� " +	// (1~7, 1:�Ͽ���)
//				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:����, 1:����)
//				today.get(Calendar.HOUR) + "�ð� " + 					// (0~11)
//				//today.get(Calendar.HOUR_OF_DAY) + "�ð� " +			// (0~23)
//				today.get(Calendar.MINUTE) + "�� " + 					// (0~59)
//				today.get(Calendar.SECOND) + "�� " 					// (0~59)
//);
//// ���� �Ϸ� �޽��� �����ֱ�
//System.out.println("ȣ�� : " + matchNum + "�� �� ����Ϸ� �Ǿ����ϴ�.");
//System.out.println();
//
//// ��ü �� ����Ʈ �����ֱ�
//for(int i=0; i<hotel.length; i++)
//	System.out.println( "�� : [ " + i + " ] " + roomChk(hotel[i]) );
//
//
//
//// �� �Է� �ٽ� �ϱ�/// ��ǵ� �����ϰ�

