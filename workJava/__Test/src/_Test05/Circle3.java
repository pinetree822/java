package _Test05;

// Circle3
public class Circle3 extends Shape3 
{
	@Override
	public void draw() { System.out.println("Circle3"); }
	public static void main(String[] args) {
		Shape3 b = new Circle3();
		b.paint();
	}
}// class Circle3
