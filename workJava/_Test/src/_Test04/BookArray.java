package _Test04;
import java.util.Scanner;

class Book2 {
	String title, author;
	
	public Book2(String title, String author) {
		this.title=title;
		this.author=author;
	}
}



//제목 >>장미의 기사
//저자 >>미상
//제목 >>설원기차
//저자 >>홍길동
//제목 : 장미의 기사, 저자 : 미상
//제목 : 설원기차, 저자 : 홍길동


public class BookArray {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		Book2[] book = new Book2[2];// book.length는 Book2가 2개
		
		// 입력
		for(int i=0; i<book.length;i++) {
			System.out.print("제목 >>");
			String title = scn.nextLine();
			
			System.out.print("저자 >>");
			String author = scn.nextLine();
			
			book[i] = new Book2(title, author);// 배열내 원소 객체 생성
		}//for
		
		// 출력
		for(int i=0; i<book.length; i++) {
			System.out.print("제목 : " + book[i].title);
			System.out.println(", 저자 : " + book[i].author);
		}//for
		
		scn.close();
	}//main
	
}// class
