package _Test04;

public class Book {
	
	String title;
	String author;

	public Book(String t) {
		title = t;
		author="���ڹ̻�";
	}
	public Book(String t, String a) {
		title = t;
		author=a;
	}
	
//	����� å�� ���ڴ� �������丮
//	������ å�� ���ڴ� ���ڹ̻�
	public static void main(String[] args) {
		
		Book prince = new Book("�����", "�������丮");// Book(t,a)ȣ��
		Book princess = new Book("������");// Book(t)ȣ��

		System.out.println(prince.title + " å�� ���ڴ� " + prince.author);
		System.out.println(princess.title + " å�� ���ڴ� " + princess.author);
		
	}
	
}
