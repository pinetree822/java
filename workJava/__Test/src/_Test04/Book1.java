package _Test04;

public class Book1 {

	String title;
	String author;

	public Book1() {
		this("", "");
		System.out.println("Book1 ������ ȣ���");
	}
	public Book1(String title) {
		this(title, "���ڹ̻�");
	}
	public Book1(String title,String author) {
		this.title = title;
		this.author = author;
	}
	
	
	
	
//	Book1 ������ ȣ���
//	< ������ > å ���ڴ� ���ڹ̻�
	void show() {
		System.out.println("< " + title + " > å ���ڴ� " + author  );
	};
	
	
	public static void main(String[] args) {
		Book1 prince = new Book1("�����", "�������丮");
		Book1 princess = new Book1("������");
		Book1 emptyBook = new Book1();
		
		princess.show();
	}
	
	
}
