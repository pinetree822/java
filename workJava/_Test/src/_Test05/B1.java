package _Test05;

class B1 extends A1
{
	public B1() {
		System.out.println("������ B1");
	}
	public B1(int x)
	{
		super(x); // ����� A1(int x)�� ȣ���Ѵ�.
		System.out.println("�Ű����� ������ B1(int x)" + x);
	}
}// class B1