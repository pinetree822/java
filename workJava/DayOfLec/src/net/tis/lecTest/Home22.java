package net.tis.lecTest;

import java.util.Calendar;
import java.util.Scanner;

public class Home22 {

	
	public Home22() {}

	// ����,��� Ȯ���ؼ� ��ȯ
	static String roomChk(boolean chk)
	{
		return chk==false?"��° ��ķ������":"��° ��ķ�������";
	}//
	
	// ��ü�� ����Ʈ
	static void roomList(boolean camp[])
	{
		// ��ü ķ�� ��Ȳ üũ����Ʈ
		System.out.println("ķ�� ����Ʈ ����");
		for(int i=0; i<camp.length; i++)
		{
			if(camp[i]==true)
				System.out.println(" " + (i+1) + roomChk(camp[i]) );
			else
				System.out.println(" " + (i+1) + roomChk(camp[i]) );
		}
		System.out.println("-----------------------------------------");
	}
	// ���� ���
	static void titleBar(String text)
	{
		System.out.println();
		System.out.print(text);
		System.out.println();
	}
	
	public static void main(String[] args) {

		// �迭
		// 1) boolean[] = new [5]
		// �Է�, ����ȯ, �ݺ���
		// if
		// 2) try~ catch

		Scanner sc = new Scanner(System.in);
		boolean camp[] = new boolean[5];
		int num = 0;

		
		
		// �Է¹ޱ�
		while(true)
		{
			
			try {
				
				System.out.println("\n1.���� 2.��� 3.���� 9.���� >>> ");
				int sel = Integer.parseInt(sc.nextLine());// try~catch

				// ���� // ȣ�� ���ȣ�� ���� ���
				if(sel == 1) {
					// ���� ���
					titleBar("ķ�� : ��� �濡�� �����Ͻðڽ��ϱ�? >>> ");

					// ���� �� ��ȣ �Է¹ޱ�, �Է¹��� ������ 1 ���� �ε����� ����
					num = Integer.parseInt(sc.nextLine());
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					num -= 1; 
					
					// ����� ������ Ȯ��
					if(camp[num]==true)
					{
						titleBar("ķ�� : >>> ����� ���Դϴ�.");
						titleBar("-----------------------------------------");
//						break;
					} else {
						// �ش�� �ε��� ������Ʈ �ϱ�
						camp[num] = true;
					}
					
					// ���� �Ϸ� �޽��� �����ֱ�
					titleBar("ķ�� : " + (num+1) + "�� �� ����Ϸ� �Ǿ����ϴ�.");
					titleBar("-----------------------------------------");
					roomList(camp);// ��ü�渮��Ʈ
					
//					break;
					
				// ���
				}else if(sel == 2) {

					// ���� ���
					titleBar("ķ�� :  ��� �濡�� ����Ͻðڽ��ϱ�? >>> ");

					// ���� �� ��ȣ �Է¹ޱ�, �Է¹��� ������ 1 ���� �ε����� ����
					num = Integer.parseInt(sc.nextLine());
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					num -= 1; 
					
					// �� ������ Ȯ��
					if(camp[num] == false)
					{
						titleBar("ķ�� : >>> �� ���Դϴ�.");
						titleBar("-----------------------------------------");
//						break;
					} else {
						// �ش�� �ε��� ������Ʈ �ϱ�
						camp[num] = false;
					}

					// ���� �Ϸ� �޽��� �����ֱ�
					titleBar("ķ�� : " + (num+1) + "�� �� ��� �Ǿ����ϴ�.");
					titleBar("-----------------------------------------");

					roomList(camp);// ��ü�渮��Ʈ					
//					break;
					
				// ����
				}else if(sel == 3) {
					// ���� ���
					titleBar("ķ�� : ��� ���� Ȯ���Ͻðڽ��ϱ�? >>> ");

					 // ��û�� ��ȣ �Է¹ޱ� - ����Ȯ��
					num = Integer.parseInt(sc.nextLine());
					
					// �Է¹��� ������ 1 ���� �ε����� ����
					num -= 1; 
					
					// �ش� �� ���� Ȯ��
					if( camp[num]==true ) {
						titleBar("ķ�� : " + (num+1) + "�� ���� ����� �Դϴ�.");
						titleBar("-----------------------------------------");
					} else {
						titleBar("ķ�� : ���� ���α׷��� �����մϴ�.");
						titleBar("ķ�� : " + (num+1) + "�� ���� ��� �Դϴ�.");
						titleBar("-----------------------------------------");
					}

					roomList(camp);// ��ü�渮��Ʈ
//					break;
					
					
				// ����
				}else if(sel==9) {
					// ���� ���
					titleBar("ķ���� ���α׷� �����մϴ�.");
					System.exit(1);// https://www.it-swarm.dev/ko/java/%EC%8B%9C%EC%8A%A4%ED%85%9C%EC%9D%98-%EC%B0%A8%EC%9D%B4-exit-0-systemexit-1-java%EC%9D%98-systemexit-1/968068812/
					break;
					
				}else {
					System.out.println("�ش��ϴ� ���񽺰� �����ϴ�.\n[ 1, 2, 3, 9] ������ �Է����ּ���.");
				}

			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("1~3�� �Է����ּ���.");
			}// try
			
		}// while
		sc.close();
		
	}// main()
	
}// class Home22
