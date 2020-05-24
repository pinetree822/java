package _Test04;

class Circle5
{
	int radius;
	
	public Circle5(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
}// class


public class ReferencePassing {
	
	static void increase(Circle5 m)
	{
		m.radius++;
	}
	
	public static void main(String[] args) {
		
		Circle5 pizza = new Circle5(10);
		
		increase(pizza);
		System.out.println("pizza Circle5 : " + pizza.radius);
	}
}
