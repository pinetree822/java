package _Test06;

public class Rect {
	
	int width;
	int height;
	
	public Rect(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	// 사각형 면적 비교
	public boolean equals(Object obj)
	{
		// obj를 Rect타입으로 다운캐스팅
		Rect p = (Rect)obj;
		if(width*height == p.width*p.height) return true;
		else return false;
	}
	
}// class Rect
