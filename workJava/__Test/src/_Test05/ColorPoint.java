package _Test05;

class ColorPoint extends Point {
	private String color;// ���� ��
	
	public void setColor(String color)
	{
		this.color = color;
	}// setColor
	public void showColorPoint()
	{
		System.out.print(color);
		showPoint();
	}// showColorPoint
}// class ColorPoint