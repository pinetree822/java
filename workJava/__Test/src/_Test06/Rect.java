package _Test06;

public class Rect {
	
	int width;
	int height;
	
	public Rect(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	// �簢�� ���� ��
	public boolean equals(Object obj)
	{
		// obj�� RectŸ������ �ٿ�ĳ����
		Rect p = (Rect)obj;
		if(width*height == p.width*p.height) return true;
		else return false;
	}
	
}// class Rect
