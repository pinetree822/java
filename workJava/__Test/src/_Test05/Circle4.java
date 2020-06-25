package _Test05;


//	Shape4
//	Circle4
public class Circle4 extends Shape4 
{
	protected String name;
	
	@Override
	public void draw()
	{
		name = "Circle4";
		super.name = "Shape4";
		super.draw();
		System.out.println(name);
	}
	public static void main(String[] args) {
		Shape4 b = new Circle4();
		b.paint();
	}// main
}// Circle4
