package _Test04;

public class Circle1 {

	int radius;
	String name;
	
	// 생성자 - 매개변수 없는
	public Circle1() {
		radius=1; name="";// 필드초기화
	}
	// 생성자 - 매개변수 있는
	public Circle1(int r, String n) {
		radius=r; name=n; // 필드초기화
	}
	
	
	// 원 면적 계산
	public double getArea() {
		return 3.14*radius*radius;
	}

	
	
//	도넛피자은 크기가 3.14입니다.
//	자바피자은 크기가 314.0입니다.
	public static void main(String[] args) {

		Circle1 pizza , donut;
		double area;

		donut = new Circle1();
		donut.name="도넛피자";
		area = donut.getArea();
		System.out.println(donut.name + "은 크기가 " + area + "입니다.");
		
		pizza = new Circle1(10, "자바피자");
		area = pizza.getArea();
		System.out.println(pizza.name + "은 크기가 " + area + "입니다.");
	}
	
}
