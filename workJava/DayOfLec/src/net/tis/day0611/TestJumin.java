package net.tis.day0611;



public class TestJumin {

	public static void main(String[] args) {
		

//		String jumin = "981029-1872543";
//		String jumin = "981029-2872543";
//		String jumin = "981029-3872543";
//		String jumin = "981029-4872543";
		String jumin = "981029-5872543";
//		String jumin = "981029-6872543";

		

		int tmp = Integer.parseInt(""+jumin.charAt(7));// 7��° �ڸ����� ����
		System.out.println("�ֹι�ȣ : " + jumin);
		System.out.println("���� : " + (tmp==1||tmp==3||tmp==5?"��":tmp==2||tmp==4||tmp==6?"��":"�������� �ֹι�ȣ�� �ƴմϴ�."));
		

		// ���ڿ� -�� ���Ե��� Ȯ��
		// �ֹι�ȣ ���ڸ� ����.14�ڸ� , - ����
		// ���ڸ� 6�� ���ڸ� 7��
		int sCnt = jumin.length();// �ֹι�ȣ ��ü����
		String sArr[] = jumin.split("-");// -�� �����ڷ� ���ڿ� �迭 �����

		////////////////////////////////////////////////////////////////////////
		
		
		

		String min1 = new String("981029");
		String min2 = new String("5872543");
		int size1 = min1.length();
		int size2 = min2.length();
		if(size1!=6||size2!=7) System.out.println("�ֹι�ȣ �ڸ����� Ʋ���ϴ�.");
		else System.out.println(min1 + "-" + min2);
		
		String jumin2 = new String("981029-1872543");
		// ����� ������ 10�� 29�� �Դϴ�.
		// static ���� String substring(����,��) ���
		String m = "10";
		String d = "29";
		////////////////////////////////////////////////////////////////////////
		
		
		// �չ�ȣ �޹�ȣ �����ϱ�
		// String substring(������ġ,����ġ +1) ���
		String subStr1 = jumin2.substring(0, 6);
		String subStr2 = jumin2.substring(7, 14); 

		System.out.println("subStr1 = " + subStr1);
		System.out.println("subStr2 = " + subStr2);
		////////////////////////////////////////////////////////////////////////
		
		
		
		
		// ����4 static ���� int indexOf(String str)
		// static ���� 
		// ��� 981029-*******
		
		

		String subStr3 = jumin2.substring(0, 6);
		String subStr4 = jumin2.substring(7, 14);
		System.out.print(subStr3 + "-");
		for(int i=0;i<subStr4.length(); i++) System.out.print("*");
		
		

//		
//		15-1,3,5 = 1110,1100,
//				1101,1011,1001
//		
//		
//		1111 -15
//		1010 -10
//		1000 -8
//		0100 -4
//		0010 -2
//		0001 -1
	}// main()
	
}// class TestJumin
