package _Test04;


public class Circle {

	int radius;
	String name;
	
	// 원의 생성자
	public Circle() {}
	
	//원의 면적 계산
	public double getArea()
	{
		return 3.14*radius*radius;
	}
	
//	자바피자의 면적은 314.0
//	자바도넛의 면적은 12.56
	
	public static void main(String[] args) {
			
		Circle pizza, donut;
		double area;
		
		pizza = new Circle();
		pizza.radius = 10;
		pizza.name = "자바피자";
		area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);
		
		
		donut = new Circle();
		donut.radius = 2;
		donut.name = "자바도넛";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area);
	}

}
