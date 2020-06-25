package _Test05;

public class MethodOverridingEx {

	static void paint(Shape p)
	{
		p.draw();
	}
	
	public static void main(String[] args) {
		
		Line line = new Line();

		paint(line);			//		Line
		paint(new Line());	//		Line
		paint(new Shape());//		Shape
		paint(new Rect());	//		Rect
		paint(new Circle());	//		Circle
		
	}
	
}// class MethodOverridingEx
