package net.tis.lecTest;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Vector;

//1) ScannerŬ����
//�̸� >>>
//�޿� >>>			=> ���� 20~100
//���� >>>			=> ����
//2) �����̸� ���
//3) Pay = 92 * 1500

//System.out.println("�̸�: " + "ȫ�浿");
//System.out.println("�޿�: " + "4234234");
//System.out.println("����: " + "����");

//�̸�: ȫ�浿
//�޿�: 4234234
//����: ����


public class Home9 {
	 
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String name;
		double pay;
		double payCal; 
		String city;
		//String[] sav = {};
		Vector v = new Vector();
		
		System.out.print("�̸� >>>");
		while(true) {
			try {
				name = scn.nextLine();
				v.add(0, name);
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println("�����Դϴ�.");
				continue;
			}
		}// while
		

		while(true) {
			try {
				System.out.print("�޿� >>>");
				payCal = Integer.parseInt(scn.nextLine().split(" ")[0]); // 20~100
				pay = payCal * 1500;
				System.out.println("pay = " + pay);

				if (payCal >= 20 && payCal <=100 ) {
					v.add(1, pay);
				} else {
					System.out.println("�޿��� 20���� 100���� �Է����ּ���.");
					continue;
				}
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println("�����Դϴ�.");
				continue;
			}
		}// while
		

		System.out.print("���� >>>");
		while(true) {
			try {
				city = scn.nextLine();
				v.add(2, city);
				System.out.println();
				break;
			} catch (Exception e) {
				System.out.println("�����Դϴ�.");
				continue;
			}
		}// while
		
		scn.close();
//		System.out.println("�� �Է��� ������ = " + v.size());
		
		for(int i=0; i<v.size(); i++) {
			switch (i) {
				case 0:
					System.out.println("�̸�: " + v.get(i));
					break;
				case 1:
					System.out.printf("�޿�: %,.0f��\n", (v.get(i)));
					break;
				case 2:
					System.out.println("����: " + v.get(i));
					break;
				default:
					break;
			}// switch
		}// for
		scn.close();
		v.clear();
		
	}// main
}// class Home9
