package net.tis.day0603;


// 187 Page ������
// �����ڴ� Ŭ�����̸��� ����
// �����ڴ� �ߺ��ؼ� �ۼ�����
// �����ڸ޼ҵ�� ���ϰ� ������ void ��� ����
// �⺻�����ڴ� �������� -> 190 Page
public class Car {

	int sp;
	
	// �⺻ ������ ���� ����
	public Car() {
	}
	// ������
	public Car(String make) {
	}
	// ������
	public Car(int price) {
	}
	// ������
	public Car(String make, int m) {
	}
	
	
	public void parking() {}
	public void speedUp() { sp=sp+10; }
	public void speedDown() { sp=sp-20; }
	
	public static void main(String[] args) {
//		Car my=new Car("����");// my�Ｚ����ֿ�
//		Car my=new Car();// my�Ｚ����ֿ�
//		Hotel tt = new Hotel("�δ���");
		Car kim = new Car(); kim.parking();
		Car lee = new Car(); lee.parking();
		Car hong = new Car(); hong.parking();
	}
	
}// class Car
