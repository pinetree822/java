package _Test04;


public class Circle {

	int radius;
	String name;
	
	// ���� ������
	public Circle() {}
	
	//���� ���� ���
	public double getArea()
	{
		return 3.14*radius*radius;
	}
	
//	�ڹ������� ������ 314.0
//	�ڹٵ����� ������ 12.56
	
	public static void main(String[] args) {
			
		Circle pizza, donut;
		double area;
		
		pizza = new Circle();
		pizza.radius = 10;
		pizza.name = "�ڹ�����";
		area = pizza.getArea();
		System.out.println(pizza.name + "�� ������ " + area);
		
		
		donut = new Circle();
		donut.radius = 2;
		donut.name = "�ڹٵ���";
		area = donut.getArea();
		System.out.println(donut.name + "�� ������ " + area);
	}

}
