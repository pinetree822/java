package _Test04;

class Sample
{
	public int a;
	private int b;
	int c; // ����Ʈ ����
}


public class AccessEx {

	public static void main(String[] args) {
		Sample sample = new Sample();

		sample.a = 10;
		//sample.b = 10;// ���ٺҰ���
		sample.c = 10;
		
//		Exception in thread "main" java.lang.Error: 
//			Unresolved compilation problem: 
//			The field Sample.b is not visible
		
	}
}
