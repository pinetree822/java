package net.tis.day0601;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		
		int dan = 1, i = 0;
		Scanner sc = new Scanner(System.in); // ScannerŬ���� �ʱⰪ�� ��Ȱ��(��ġ����̹��� �ν� �ȵ�)
		
		// Ctrl + Shift + f
		// �������� ����� Shift + TabŰ
		// ���������� �鿩���� TabŰ
		
		while (true) {
			System.out.print("�� �Է� >>> ");

			try {
//				dan = sc.nextInt();// ���� enterġ�� enterŰ���� �ٽ� dan��������
				dan = Integer.parseInt(sc.nextLine());// ���� enterġ�� enterŰ���� �ٽ� dan��������

				if (dan == 0 || dan == -1) {
					System.out.println("������ ���α׷��� �����մϴ�.");
//					break;
					System.exit(0);
				}

				for (i = 1; i < 10; i++)
					System.out.println(dan + "*" + i + "=" + (dan * i));

				break;// �����ϸ� �������� while(true){}
			} catch (Exception e) {
				System.out.println("������ ���ڸ� �Է��ϼ���.");
				continue;
			}
		} // while

		System.out.println("=========================");
		System.out.println("***����ó��***");
		System.out.println("����=175");
		System.out.println("���=87.5");
		System.out.println("���������");
		
		sc.close();

	}// main
	
}// class Gugudan
