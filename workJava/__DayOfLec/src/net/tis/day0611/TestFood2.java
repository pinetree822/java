package net.tis.day0611;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// ����, if, while
// �Է�, ���, ����for

public class TestFood2 {

	public static void main(String[] args) {
		
		String lunch[] = {"���", "���", "���ö�", "����", "����", "����"};
		int sel = (int) (Math.random()*6);
		for(int i=0; i<20; i++) {
			sel = (int) (Math.random()*6);
			System.out.print(sel + " ");
		}
		System.out.println();
		System.out.println("���� ���� �޴���? >> " + lunch[sel]);
		
		
//		Random rd = new Random();
//		sel = rd.nextInt();
		sel = new Random().nextInt(6);// 0��° ����
		System.out.println("sel = " + sel);
		System.out.println("���� �Ļ�޴� : " + lunch[sel]);
		
		
		
		java.util.Date date1 = new java.util.Date();
		Date dt = new Date();
		
		String pattern = "yyyy��-MM��dd�� HH��mm��ss��";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);// �ؽ�Ʈ ������ ����
		String hh = sdf.format(dt);
		
		
		
		System.out.println("�ð� = " + hh);
		System.out.println("�ð� " + dt);
		System.out.println("�ð� " + dt.toLocaleString());
		
	}// main()
}// class TestFood
