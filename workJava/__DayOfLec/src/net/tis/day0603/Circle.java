package net.tis.day0603;




public class Circle {

	public int radius;// �ʵ�=field=��������
	
	public Circle() {
		
	}// Circle()
	public Circle(int r, String n) {
		
	}// Circle()
	
	double getArea() {
		double value = radius*radius*3.1415;
		return (radius*radius*3.1415);
	}// getArea()
	
	
	public static void main(String[] args) {
		System.out.println("�� ������ �౸��");
		Circle pizza=new Circle(10,"����������");//18����
		Circle donut=new Circle();//22����
	}// main()
	
}// class Circle
