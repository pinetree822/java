package _Test04;

public class Circle3 {

	int radius;
	
	void set(int r) 
	{
		radius = r;
	}// set
	
	double getArea()
	{
		return 3.14*radius*radius;
	}
	public Circle3() {
	}
	public Circle3(int r) {
		radius = r;
	}
	
	// 객체 복사 ; 얇은복사에 대한
	public static void main(String[] args) {
		
		Circle3 pizza = new Circle3(10);
		System.out.println(pizza.getArea());
		
		Circle3 donut = new Circle3();
		System.out.println(donut.getArea());
		
	}// main
	
}//class
