package _Test05;

class B1 extends A1
{
	public B1() {
		System.out.println("생성자 B1");
	}
	public B1(int x)
	{
		super(x); // 상속한 A1(int x)를 호출한다.
		System.out.println("매개변수 생성자 B1(int x)" + x);
	}
}// class B1