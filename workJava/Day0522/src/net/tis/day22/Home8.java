package net.tis.day22;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

//�����̸��̳� ���γ��� �Է�( �̸��� �Է¹޾Ƶ�  �˴ϴ�)
//�����̸��̳� ���γ��� �Է�( ���̸� �Է¹޾Ƶ� �˴ϴ�)

public class Home8 {

	public static void main(String[] args) throws Exception // ����ó�����
	{
		// ����� ���
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		// ���� ���
		System.out.println("�̸� ���� ������ �������� �Է����ּ���.");
		Scanner sc = new Scanner(System.in);
		
		String name = sc.next();
		int age = sc.nextInt();
//		int age = Integer.parseInt(sc.next());
		
		
		System.out.println("�̸��� " + name +", ���̴� " + age + "�� �Դϴ�.");
		
	}

}
