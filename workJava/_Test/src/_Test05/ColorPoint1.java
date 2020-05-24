package _Test05;


class ColorPoint1 extends Point1
{
	private String color;// 점의 색
	
	void showColorPoint()// 컬러 점의 좌표 출력
	{
		System.out.print(color);
		showPoint();// Point1 클래스의 showPoint() 호출
	}
	
	public ColorPoint1(int x, int y, String color)
	{
		super(x, y); // Point의 생성자 Point(x,y)호출
		this.color = color;
	}
}// class ColorPoint1