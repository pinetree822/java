package net.tis.day0602;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		int com=0, my=0, count=0, flag=0;
		
		// �����߻�
		com=(int)(Math.random()*100)+1;
		System.out.println("com=" + com);
		
		// �Է¹޾� ���߱�
		Scanner scn = new Scanner(System.in);
		
		while(flag>=0)
		{
			System.out.println("����[1~100] �Է� >>> ");
			my=scn.nextInt();// ���� nextLine();
			
			if(my<=0 || my>100) {
				System.out.println("1~100 �Է� ���ּ���.");
				continue;
			}
			count++;

			if(com != my) {
				System.out.println("Ʋ�Ƚ��ϴ�.");
				System.out.println( my + (com>my?"���� Ů�ϴ�.":"���� �����ϴ�.") );
				if(5>count)
					System.out.println((5-count) + "ȸ ���ҽ��ϴ�.");
				
				if(count>=5) {
					System.out.println("������ " + com + "���Դϴ�.");
					flag=-1;
				}
			} else {
				System.out.println("������ " + com + "���Դϴ�.");
				System.out.println("���߾����ϴ�.");
				flag=-1;
			}// if
			
		}// while
		System.out.println("=========== GAME OVER ==============");
		
		// ������ �̿��ؼ� ���� ���߱�
		// ����] 5ȸ���� ���ڸ��߱�
		
		// ���� �迭������
		
		// �Է� ������ ������ 1~100 �Դϴ�.
		// Ʋ�Ƚ��ϴ�.
		// 4ȸ ���ҽ��ϴ�.
			// my(7)���� �����ϴ�.
			// my(7)���� Ů�ϴ�.
			// ������ ����Դϴ�.
		// ���߾����ϴ�.
		
		
		
		
	}// main()
	
}// class Game
