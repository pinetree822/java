package _Test06;


class Point2
{
	private int x,y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Object obj)
	{
		Point2 p=(Point2)obj;
		if(x==p.x && y==p.y) return true;
		else return false;
	}
}// class Point2
