package _Test04;

public class Book {
	
	String title;
	String author;

	public Book(String t) {
		title = t;
		author="작자미상";
	}
	public Book(String t, String a) {
		title = t;
		author=a;
	}
	
//	어린왕자 책의 저자는 생텍쥐페리
//	춘향전 책의 저자는 작자미상
	public static void main(String[] args) {
		
		Book prince = new Book("어린왕자", "생텍쥐페리");// Book(t,a)호출
		Book princess = new Book("춘향전");// Book(t)호출

		System.out.println(prince.title + " 책의 저자는 " + prince.author);
		System.out.println(princess.title + " 책의 저자는 " + princess.author);
		
	}
	
}
