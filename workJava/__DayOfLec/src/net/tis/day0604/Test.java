package net.tis.day0604;

public class Test {
	
	public static void main(String[] args) {

		// ǥ��Ÿ�� : int, double, boolean, char, byte
		// ǥ��Ÿ�� �� ==, Ŭ������.equal("")
		String a = "red";// ���� ���ڿ�
		String b = new String("red");
//		String b = "red";
		
		if(a == b) System.out.println("���� red");
		else System.out.println("Ʋ�� red");
		
		
		
		
		// char �迭 �����ؼ� red �ʱⰪ ����
//		char data[] = {'r', 'e', 'd'};
//		String c = new String(data);
		

		int x = 74;
		int y = 74;
		if(x == y) System.out.println("���� ����");
		else System.out.println("Ʋ�� ����");
		
//		Integer xxx = new Integer(74);
//		Integer yyy = new Integer(74);
//		if(xxx.equals(yyy)) System.out.println("xxx���� ����");
//		else System.out.println("Ʋ�� ����");
		
//		Integer xxx = 74;
//		Integer yyy = 74;
//		if(xxx.equals(yyy)) System.out.println("xxx���� ����");
//		else System.out.println("Ʋ�� ����");
		
		Integer xxx = (int)74;
		Integer yyy = (int)74;
		if(xxx.equals(yyy)) System.out.println("xxx���� ����");
		else System.out.println("Ʋ�� ����");

//		 // ����
//		int xx = new Integer(74);
//		int yy = new Integer(74);
//		if(xx.equals(yy)) System.out.println("xx���� ����"); // ����
//		else System.out.println("Ʋ�� ����");

		Integer xxxx = new Integer(74);
		int yyyy = new Integer(74);
		if(xxxx.equals(yyyy)) System.out.println("xxxx���� ����");
		else System.out.println("Ʋ�� ����");

//		 // ����
//		int xxxxx = new Integer(74);
//		Integer yyyyy = new Integer(74);
//		if(xxxxx.equals(yyyyy)) System.out.println("xxxx���� ����"); // ����
//		else System.out.println("Ʋ�� ����");

		
		
		
		
	}// main()
	
}// class Test
