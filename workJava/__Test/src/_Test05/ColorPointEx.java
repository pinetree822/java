package _Test05;

public class ColorPointEx {

	public static void main(String[] args) {

		Point p = new Point();
		p.set(1, 2);
		p.showPoint();//(1, 2)
		
		ColorPoint cp = new ColorPoint();
		cp.set(3, 4);
		cp.setColor("red");
		cp.showColorPoint();//red (3, 4)
	}
	
}// class ColorPointEx
