package net.tis.day0604;




public class Test2 {
	
	int radius;
	void set(int r) { radius =r;}
	double getArea() {return 3.14*radius*radius;}
	
	
	public Test2(int r) {
		radius = r;
		
	}
	

	public static void main(String [] args) {
		Test2 test = new Test2(10);
		test.set(3);
		System.out.println(test.getArea());
		
		
		
		
		
	
	}	
}
