package net.tis.day22;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		String name;
		int age;
		double height;
		String intro;
		String buffer;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���");
		name = sc.next();
		System.out.println("���̸� �Է��ϼ���");
		age = sc.nextInt();
		System.out.println("Ű�� �Է��ϼ���");
		height = sc.nextDouble();
		System.out.println("�ڱ�Ұ��� �Է��ϼ���");
		buffer = sc.nextLine();
		intro = sc.nextLine();
		
		System.out.println("�̸��� "+name+"���̴� "+age+",Ű�� "+height+"�Դϴ�.");
		System.out.println(intro);
	}

}