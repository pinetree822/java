package _Test05;

public class Shape3
{
	protected String name;
	
	public void paint() { draw(); }
	public void draw() { System.out.println("Shape3"); }
	public static void main(String[] args) {
		Shape3 a = new Shape3();
		a.paint();
	}
}// class Shape3