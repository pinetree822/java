package _Test04;

public class Circle1 {

	int radius;
	String name;
	
	// ������ - �Ű����� ����
	public Circle1() {
		radius=1; name="";// �ʵ��ʱ�ȭ
	}
	// ������ - �Ű����� �ִ�
	public Circle1(int r, String n) {
		radius=r; name=n; // �ʵ��ʱ�ȭ
	}
	
	
	// �� ���� ���
	public double getArea() {
		return 3.14*radius*radius;
	}

	
	
//	���������� ũ�Ⱑ 3.14�Դϴ�.
//	�ڹ������� ũ�Ⱑ 314.0�Դϴ�.
	public static void main(String[] args) {

		Circle1 pizza , donut;
		double area;

		donut = new Circle1();
		donut.name="��������";
		area = donut.getArea();
		System.out.println(donut.name + "�� ũ�Ⱑ " + area + "�Դϴ�.");
		
		pizza = new Circle1(10, "�ڹ�����");
		area = pizza.getArea();
		System.out.println(pizza.name + "�� ũ�Ⱑ " + area + "�Դϴ�.");
	}
	
}
