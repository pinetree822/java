package _Test04;


public class Circle4 {
	
	int radius;

	public Circle4(int radius) 
	{
		this.radius = radius;
	}
	public void set(int radius)
	{
		this.radius = radius;
	}

//	obj1.radius = 2
//	obj2.radius = 2

	
	public static void main(String[] args) {
		
		Circle4 obj1 = new Circle4(1);
		Circle4 obj2 = new Circle4(2);
		Circle4 s;
		

		System.out.println("obj1.radius = " + obj1.radius);
		System.out.println("obj2.radius = " + obj2.radius);
		
		s = obj2;
		obj1 = obj2; // °´Ã¼ Ä¡È¯
		obj2.radius = 9;

		System.out.println("obj1.radius = " + obj1.radius);
		System.out.println("obj2.radius = " + obj2.radius);
		System.out.println("s.radius = " + s.radius);
		
		
		
	}//main
}// class
