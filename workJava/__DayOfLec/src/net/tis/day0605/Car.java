package net.tis.day0605;



// ����x, �迭x, �޼ҵ帮�ϰ�x, ���ο� �޼ҵ�x
public class Car {

	private String brand;
	private int year;
	
	// �⺻ ������
	public Car() {
	}// car()
	public Car(String brand) {
		this.brand=brand;
		parking();
	}// car()
	public Car(String brand, int year) {
		this.brand=brand;
		this.year=year;
		parking();
	}// car()
	

	// ��ȸ�翡�� �������� �������
	void parking()
	{
		System.out.println("ȸ��=" + this.brand);
		System.out.println("�����ü�");
		System.out.println("��������");
	}// parking()
	
	// ��ȸ�翡�� �������� �������
	void parking(String brand)
	{
		System.out.println("ȸ��=" + brand);
		System.out.println("��� : " + this.year);
		System.out.println("�����ü�");
		System.out.println("��������");
	}// parking()
	
	void display()
	{
		System.out.println("���� : 5KM");
	}// display()
	
	public static void main(String[] args) {

		Car cc = new Car("������");
//		new Car().parking();
//		new Car().display();
		
		
//		 �迭, ����ó��x, �Է�x
//		 ������x, �޼ҵ� ���� ����x
//		int su=739;
//		����, if, while, ���
//		��� 937;// �������
		
//		100 10 1
		System.out.println("int su=739");
		int su=739;
		int remain3 = 0;
		String sus=String.valueOf(su);


		for(int i=sus.length(),res = 1; i>0; i--) {
//			System.out.println("res ="+ (res*=10));
			int muls = (res*=10)/10;// 1~100
			int remaind1 = (su%(muls));// 0,9,39
			int remaind2 = (su%(muls*10));// 9,39,739
//			int remaind3 = (su%(muls*10));// 9,39,739
//			System.out.print("muls="+ muls);
//			System.out.print(", remaind1="+ remaind1);
//			System.out.print(", remaind2="+ remaind2);
//			System.out.println(", remaind3="+ (remaind2-remaind1) );
//			System.out.println("remaind33="+ (remaind2-remaind1)/muls );
			
			remain3 += (remaind2-remaind1)/muls*(int)Math.pow(10, i-1);
//			System.out.println("remain3 = " + remain3);
//			System.out.println("remaind33="+ (remaind2-remaind1)/muls*(int)Math.pow(10, i-1) );
//			System.out.println("remaind4="+ (remaind2-remaind1)*(int)Math.pow(10, i-1));
			
//			int(9)*100
//			int(3.9)*10
//			int(7.39)1
//			System.out.println("su1="+ su1);
		}

		System.out.println("remain3 = " + remain3);
//		res %= 10;
		
		
//		for(int i=sus.length(); i>0; i--) {
//			System.out.println("i="+i+ ", res ="+ Math.pow(10, i-1));
//		}
			
			
//
//		System.out.println("����, if, while, ���");
//		
//		System.out.println("��� : 937");
		
	}// main()
	
}// class Car
