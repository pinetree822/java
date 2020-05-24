package _Test04;

class StaticSample1
{
	public int n;
	
	public void g() { m = 20; }
	public void h() { m = 30; }
	public static int m;
	public static void f() { m = 5; }
	public void show() {
		System.out.println("n = " + this.n + "," + " m = " + m);
	}
	
}// class

public class Ex2 {
	
	public static void main(String[] args) {
		
		StaticSample1.m = 10;
		
		StaticSample s1;
		s1 = new StaticSample();
		System.out.println(s1.m);// 0
		s1.show();// n = 0, m = 0
		
		s1.f();
		StaticSample1.f();
		s1.show();// n = 0, m = 5
		
		
	}
}//class
