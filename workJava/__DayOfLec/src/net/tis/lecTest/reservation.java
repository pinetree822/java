package net.tis.lecTest;

import java.util.Date;
import java.util.Scanner;

public class reservation {

	// 12�� �¼�( â���� 6��, ����� 6��)
	// 
	private static int[] seats = new int[12];
	
	
	public reservation() {
		
		System.out.println("����� DIC ������ ���Ű� ȯ���մϴ�.");
		System.out.println("���� Ƽ���� �ٷ� ���⿡�� �����Ͻʽÿ�");
		System.out.println();
		
		// 12���� �¼��� 0���� �ʱ�ȭ ��Ų��.
		for(int i=0; i<12; i++) seats[i]=0;
		
		Scanner s = new Scanner(System.in);// �Է��Ҽ� �ְ� �غ� �۾�
		int choice=1;// �մ��� �����ϴ� ???
		
		// ����ڿ��� â���̳� ��� �¼��� ��û�ϰ� ������ �����մϴ�.
		System.out.println("0.���� 1.â�¼� 2.����¼�");
		choice=s.nextInt();// ����ڿ��� �Է¹޴´�.
		
		// �Էµ� ��ȣ�� �м��Ѵ�.
		while(choice!=0)
		{
			int seatnumber=0; // �¼� �ѹ��� �Է¹��� ����
			
			/////////////////////////////////////////////////////////
			// �Էµ� ��ȣ�� 1(â���¼� ����)
			if(choice==1) {
				
				seatnumber = bookWindow(); // â���¼� ����
				// bookWindow()���� -1�� ��ȯ�ϸ�(â���¼��� ���°��) ����¼��� ����
				if(seatnumber==-1) {
					seatnumber=bookAisle();// ����¼� ����
					if(seatnumber!=-1) {// ����¼� ������ٸ�
						System.out.println("�˼��մϴ�. â�� �¼��� ���� �� �� �����ϴ�.\r\n" + 
								"�׷��� ��� �¼��� �����Ͽ����ϴ�.");
						printBoardingPass(seatnumber);// �¼���Ȳ ���
					}// if
				}else {
					System.out.println("����Դϴ�. â���¼��� ������ �Ǿ����ϴ�.");
					printBoardingPass(seatnumber);// �¼���Ȳ ���
				}// if
				
			/////////////////////////////////////////////////////////
			// �Էµ� ��ȣ�� 2(����¼� ����) 
			}else if(choice==2) {
				
				// ��� �¼� ����
				seatnumber = bookAisle();
				if(seatnumber==-1) {// ����¼��� ���� �ʉ�ٸ�
					// â���¼��� ����
					seatnumber=bookWindow();
					if(seatnumber!=-1) {// â���¼��� �ڵ����� ��ٸ�
						System.out.println("��� �¼��� ���� �� �� �����ϴ�. �׷��� â�� �¼��� �ؾ��Ͽ����ϴ�.");
						printBoardingPass(seatnumber);
					}
				} else {// ����¼��� ������ٸ�
					System.out.println("��� �¼��� ������ ����ϴ�!");
					printBoardingPass(seatnumber);
				}// if

			/////////////////////////////////////////////////////////
			// �Էµ� ��ȣ�� 1,2 �̿��� ��ȣ�� �Է�ٸ�..
			}else {
				System.out.println("�߸��� �����Դϴ�. �ٽ� �õ��Ͻʽÿ�!");
				choice=0;
			}
			
			
			if(seatnumber==-1) {
				System.out.println("�˼��մϴ�. �̿� ������ â�� �Ǵ� ��� �¼��� �����ϴ�");
				System.out.println();
			}// if
			
			System.out.print("0.���� 1.â�¼� 2.����¼� >>> ");
			System.out.println();
			choice=s.nextInt();// �¼� �Է¹ޱ�
		}// while


		System.out.println();
		System.out.println();
		System.out.println("==========================");
		System.out.println("���� ���� ���α׷��� �����մϴ�.");
		System.out.println("==========================");
		System.out.println();
		System.out.println();
		
	}// reservation()
	
	
	// �� ����� �����û�� Ƽ������ �ȳ�
	private void printBoardingPass(int seatnumber) {
		Date timenow=new Date();
		System.out.println();
		System.out.println("==========================");
		System.out.println("Date" + timenow.toString());
		System.out.println("�¼� ��ȣ ž�±� :" + seatnumber);
		System.out.println("�� �װ����� ȯ�� �� �絵 �� �� �����ϴ�.");
		System.out.println("��踦 �ǿ��� �ʰ� �����Ͻʽÿ�.");
		System.out.println("����� ������ 100�� ��� �� �ֽ��ϴ�.");
		System.out.println("==========================");
		System.out.println();
		System.out.println();
	}// printBoardingPass()

	// �� ����� ��� �¼��� �ִ��� Ȯ���ϰ� ���� �� ��� -1�� Ȯ���մϴ�.
	private int bookAisle() {
		for(int i=6; i<12; i++) {
			if(seats[i]==0) {
				seats[i]=1;
				return i+1;
			}// ����¼� ������ > �¼� ��ȣ�� ��ȯ
		}//for
		return -1; // ����¼��� ���ٸ� -1�� ��ȯ
	}// bookAisle()

	// �� ����� â �¼��� Ȯ���ϰ� �¼� ��ȣ�� ��ȯ�ϰų� ���� �� ��� -1�� ��ȯ�մϴ�.
	private int bookWindow() {
		for(int i=0; i<6; i++) {
			if(seats[i]==0) {
				seats[i]=1;
				return i+1;
			}// â���¼� ������ > �¼� ��ȣ�� ��ȯ
		}//for
		return -1; // â���¼��� ���ٸ� -1�� ��ȯ
	}// bookWindow()


	public static void main(String[] args) {
//		System.out.println("���� ���� �ý��ۿ� ���� ���� ȯ���մϴ�!");
//		System.out.println();
		System.out.println();
		new reservation();
	}// main()
	
}// class reservation
