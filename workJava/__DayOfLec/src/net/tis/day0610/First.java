package net.tis.day0610;

import java.awt.Button;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

//import net.tis.lecTest.TestCamping;
// ���� 
// ����.java ������ > export > java > jar���� ���� > ��������(.classPath,.project)����
// Select the export destination >> (�������� �����Ұ� ����)
// JAR file : C:\_xampp\htdocs\java\workJava\DayOfLec\lib\TestCamping.jar
//
// < ���� ���� ��� > 
//Java Build Path > Libraries > Add External JARS > ��ġ > blue.jar		
//TestCamping cu = new TestCamping();



public class First {

	public static void main(String[] args) {
		System.out.println("�ۼ� 05��25�� ������");
		System.out.println("���� 06��10�� ������");
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("�����Է� >>> ");
		int a = scn.nextInt();
		Math.random();
		
		
		Date dt = new Date();
		String locale = dt.toLocaleString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��-MM��-dd��");
		String wdate = sdf.format(dt);
		System.out.println("DateŬ����" + locale);
		System.out.println("SDF����" + wdate);
		
		
		Button btnSend;
		ArrayList alist;
		Vector vt;
		
		
	}// main()
}// class First
