package _Test05;


class ColorPoint1 extends Point1
{
	private String color;// ���� ��
	
	void showColorPoint()// �÷� ���� ��ǥ ���
	{
		System.out.print(color);
		showPoint();// Point1 Ŭ������ showPoint() ȣ��
	}
	
	public ColorPoint1(int x, int y, String color)
	{
		super(x, y); // Point�� ������ Point(x,y)ȣ��
		this.color = color;
	}
}// class ColorPoint1