package net.tis.day0601;

public class Calc149 {

	public static void main(String[] args) {
		
//		double avg = 45.6;
//		String data = "1200";
//		
//		int a = avg;
//		int b = data;
		
		String cook = args[0];
		String price = args[1];
		int total = Integer.parseInt(price)*3;
		

		System.out.println(cook + "���� �丮�� ���İ����� " + price + "���Դϴ�.");
		System.out.println(cook + "���� �丮�� ���İ����� " + total + "���Դϴ�.");
		
		// �丮���� 2400 ��� * 3
		// ���� >>> �ڻ���
		// ���� >>> 2400
		// �������� �丮�� ���İ����� 7200���Դϴ�.
		
		
	}// main
	
}// Calc149
