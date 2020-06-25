package net.tis.day0603;




public class Circle {

	public int radius;// 필드=field=전역변수
	
	public Circle() {
		
	}// Circle()
	public Circle(int r, String n) {
		
	}// Circle()
	
	double getArea() {
		double value = radius*radius*3.1415;
		return (radius*radius*3.1415);
	}// getArea()
	
	
	public static void main(String[] args) {
		System.out.println("원 지구본 축구공");
		Circle pizza=new Circle(10,"마스터피자");//18라인
		Circle donut=new Circle();//22라인
	}// main()
	
}// class Circle
