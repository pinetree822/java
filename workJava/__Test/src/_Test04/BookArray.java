package _Test04;
import java.util.Scanner;

class Book2 {
	String title, author;
	
	public Book2(String title, String author) {
		this.title=title;
		this.author=author;
	}
}



//���� >>����� ���
//���� >>�̻�
//���� >>��������
//���� >>ȫ�浿
//���� : ����� ���, ���� : �̻�
//���� : ��������, ���� : ȫ�浿


public class BookArray {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		Book2[] book = new Book2[2];// book.length�� Book2�� 2��
		
		// �Է�
		for(int i=0; i<book.length;i++) {
			System.out.print("���� >>");
			String title = scn.nextLine();
			
			System.out.print("���� >>");
			String author = scn.nextLine();
			
			book[i] = new Book2(title, author);// �迭�� ���� ��ü ����
		}//for
		
		// ���
		for(int i=0; i<book.length; i++) {
			System.out.print("���� : " + book[i].title);
			System.out.println(", ���� : " + book[i].author);
		}//for
		
		scn.close();
	}//main
	
}// class
