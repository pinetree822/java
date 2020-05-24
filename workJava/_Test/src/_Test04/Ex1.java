package _Test04;

class StaticSample
{
	public int n;

	public void g() 	{ m = 20; }
	public void h() { m = 30; }
	public static int m;
	public static void f() { m = 5; }
	public void show() {
		System.out.println("n = " + this.n + "," + " m = " + m);
	}
}// class StaticSample


public class Ex1 {
	
	public static void main(String[] args) {
		
		StaticSample s1, s2;
		
		s1 = new StaticSample();
		s1.n = 5; 		s1.show();	//n = 5, m = 0
		s1.g(); 		s1.show();	//n = 5, m = 20
		s1.m = 50;	s1.show();	//n = 5, m = 50	 // static	field
		
		s2 = new StaticSample();
		s2.n = 8;		s2.show();	//n = 8, m = 50
		s2.h();			s2.show();	//n = 8, m = 30
		s2.f();			s2.show();	//n = 8, m = 5	 // static func
		
		s1.show();					//n = 5, m = 5
		
	}// main
}// class Ex1
