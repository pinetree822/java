package _Test06;

//_Test06.Point					// Ŭ���� �̸�
//366712642						// Ŭ���� �ؽ� �ڵ尪
//_Test06.Point@15db9742	// Ŭ���� ��ü�� ���ڿ��� ���
//_Test06.Point@15db9742	// Ŭ���� ��ü ���
public class ObjectPropertyEx {
	
	public static void print(Object obj)
	{
		System.out.println(obj.getClass().getName());	// Ŭ���� �̸�
		System.out.println(obj.hashCode());				// Ŭ���� �ؽ� �ڵ� ��
		System.out.println(obj.toString());				// Ŭ���� ��ü�� ���ڿ��� ���
		System.out.println(obj);							// Ŭ���� ��ü ���
	}
	
	public static void main(String[] args) {
		Point p = new Point(2,3);
		print(p);
	}
}// class ObjectPropertyEx
