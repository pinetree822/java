package net.tis.day0609;




public class Board {

	private String title; // title필드는 현재클래스에서 사용
	private String msg;

	public Board() {
	}// Board()
	public Board(String admin) {
		System.out.println(admin + " 생성자");
	}// Board()
	public Board(int age) {
		System.out.println(age + " 생성자");
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
		System.out.println("계절시기 " + this.msg);
		System.out.println("계절시기 " + a);
		System.out.println("계절시기 " + this.getTitle());
	}

	
//	 
//	public static void main(String[] args) {
//		Board bb=new Board();
//		bb.setTitle("여름날 summertime");
//		bb.display();
//		
//		System.out.println();
//		System.out.println();
//	}// main()
	
}// class Board
