package net.tis.day0604;





public class First {

	int kor=0;
	
	public First() {
		
	}// First()
	
	
	public static void main(String[] args) {
		int kor=78;
		System.out.println(new First().ten());
		System.out.println(new First().ten());
//		System.out.println(First.ten());
	}
	public int ten()
	{
		this.kor++;
		return this.kor;
	}
	
}// class First
