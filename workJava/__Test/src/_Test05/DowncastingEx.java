package _Test05;

// C:\Users\USER\Desktop\���������\��ǰJAVA���α׷���(����4��)_�н��ڿ�[20190220] (1)\���� �� �׸� �ҽ�\5��\chap05-fig5-15\src

public class DowncastingEx {
	
//	������
//	A

	public static void main(String[] args) {
		Person2 p = new Student2("������"); // ��ĳ����
		Student2 s;
		
		s = (Student2)p; // �ٿ�ĳ����
		
		System.out.println(s.name);
		s.grade = "A";
		System.out.println(s.grade);
	}// main
}// class
