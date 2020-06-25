package _Test04;

public class Book1 {

	String title;
	String author;

	public Book1() {
		this("", "");
		System.out.println("Book1 생성자 호출됨");
	}
	public Book1(String title) {
		this(title, "작자미상");
	}
	public Book1(String title,String author) {
		this.title = title;
		this.author = author;
	}
	
	
	
	
//	Book1 생성자 호출됨
//	< 춘향전 > 책 저자는 작자미상
	void show() {
		System.out.println("< " + title + " > 책 저자는 " + author  );
	};
	
	
	public static void main(String[] args) {
		Book1 prince = new Book1("어린왕자", "생텍쥐페리");
		Book1 princess = new Book1("춘향전");
		Book1 emptyBook = new Book1();
		
		princess.show();
	}
	
	
}
