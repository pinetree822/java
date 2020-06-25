package net.tis.day0603;


class RectAngle 
{
	
	public int width;
	public int height;
	
	public int getArea() {
		int area;
		return (area=width*height);
	}// getArea()
	
	public RectAngle() {
	}
	
}// class RectAngle





public class RectApp 
{

	public static void main(String[] args) {
		
		System.out.println("졸음");
		
	}// main()
	
	// 내부클래스 , innerClass
	public class MyEx
	{
		public void display() {
			System.out.println("내부클래스");
		}
	}// class MyEx
	
	
	
	
}// class RectApp
