package _Test05;

class Point1
{
	private int x, y;
	
	// ÁÂÇ¥Ãâ·Â
	void showPoint()
	{
		System.out.println("( " +x+", "+y+" )");
	}
	public Point1() {
		this.x = this.y = 0;
	}
	public Point1(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}// class Point