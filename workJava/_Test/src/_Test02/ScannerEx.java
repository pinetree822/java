package _Test02;

public class ScannerEx {

	public static void main(String[] args) {
//		System.out.println();
		java.util.Scanner scn = new java.util.Scanner(System.in);
		System.out.println("�̸�, ����, ����, ü��, ���� ���θ� ��ĭ���� �и��Ͽ� �Է��ϼ���.");
		
		String name = scn.next();// ���ڿ� �б�
		String city = scn.next();//���ڿ� �б�
		int age = scn.nextInt();//���� �б�
		double weight = scn.nextDouble();// �Ǽ� �б�
		boolean isSingle = scn.nextBoolean();// ���� �б�
		scn.close();
		
		// ������ ���� 48 88 true
		System.out.print("�̸��� " + name + ", ");
		System.out.print("���ô� " + city + ", ");
		System.out.print("������ " + age + "��, ");
		System.out.print("ü���� " + weight + "kg, ");
		System.out.println("������ " + isSingle + "�Դϴ�.");
		
		scn.close();
//		������, ����, 49, 99, ��ȥ
//		Exception in thread "main" java.util.InputMismatchException
//			at java.util.Scanner.throwFor(Unknown Source)
//			at java.util.Scanner.next(Unknown Source)
//			at java.util.Scanner.nextInt(Unknown Source)
//			at java.util.Scanner.nextInt(Unknown Source)
//			at _Test02.ScannerEx.main(ScannerEx.java:12)
	}

}
