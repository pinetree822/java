package net.tis.day0605;




public class Book {

	// 186~187page ������=Constructor
	public Book() {
		System.out.println("BookŬ���� �⺻������ / ��������");
	}// Book()
	public Book(String books) {
		System.out.println("== [ å�� : " + books + " ] ==");
	}// Book()

	
	// Ŭ���� �������� Ư��
	// Ŭ�����̸��� ����
	// ���ϰ� ��� void��� ����
	// ������ �ߺ�����(Ÿ���̳� ���� �ٸ�)
	// ȣ�� newŰ���� ������ ���
	// ���ѹ� ȣ��/ ��Ȱ�� �ʱ�ȭ
	// ubuntu -hp driver of latest hplip-3.20.5
	public int price(){
		int m=2700;
		return m;
	}// price()
	
	public static String getTitle(){
		String name="�����";
		return name;
	}// getTitle()
	
	public void display(){
		System.out.println("display�޼ҵ�");
		System.out.println("void display()");
		order(7);
//		return ;// ��������
	}// display()

	
	public void order(int dt) {
		int su=dt;
		System.out.println(su);
		// this Ű����� ��������
//		return 0;
	}
	
	
	public int lotto()[] {
		int a=27, b=45, c=34, x=22, y=11, z=10;
		int highest[] = {a,b,c,x,y,z};
		return highest;
	}// lotto()

//	
//	public ??? save(){
//		double point=7.9;
//		return point;
//	}// save()
//	
//	
	
	// ��������
	// ä�� / ����, ����, �г���
	// ����Ÿ������ ����� ����ü - java.util Api ���� : 
	// List�������̽�, ArryaList, - ����Ÿ���� ��� �ٸ���� ���
	// Map - ����Ÿ���� ��� �ٸ���� ���

	
}// class Book
