package net.tis.day0609;




public class Board {

	private String title; // title�ʵ�� ����Ŭ�������� ���
	private String msg;

	public Board() {
	}// Board()
	public Board(String admin) {
		System.out.println(admin + " ������");
	}// Board()
	public Board(int age) {
		System.out.println(age + " ������");
	}// Board()
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String subject) {
		this.title = subject;
	}
	
	public void display() {
		System.out.println("display");
		String a=this.getTitle();
		System.out.println("�����ñ� " + this.msg);
		System.out.println("�����ñ� " + a);
		System.out.println("�����ñ� " + this.getTitle());
	}

	
//	 
//	public static void main(String[] args) {
//		Board bb=new Board();
//		bb.setTitle("������ summertime");
//		bb.display();
//		
//		System.out.println();
//		System.out.println();
//	}// main()
	
}// class Board
