package _Test07;



// https://www.google.com/search?sxsrf=ALeKk00PRbLZng61JvtcHoBLiUQBBKGweQ%3A1590573275594&ei=2zjOXsvkI5j6wQPDwK-4Dg&q=%EC%9E%90%EB%B0%94+%EC%A0%9C%EB%84%88%EB%A6%AD&oq=%EC%9E%90%EB%B0%94+%EC%A0%9C%EB%84%88%EB%A6%AD&gs_lcp=CgZwc3ktYWIQAzIECAAQQzIECAAQCjIECAAQCjIECAAQQzIECAAQCjIECAAQCjIECAAQCjIECAAQCjIECAAQCjIECAAQQzoCCAA6BggAEAgQHjoHCAAQFBCHAlDmibwBWJOVvAFgzZa8AWgAcAB4AIABfIgB_AiSAQQwLjEwmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiLvtKY49PpAhUYfXAKHUPgC-cQ4dUDCAw&uact=5

class GStack<T>	// ���׸� ���� ����, ���׸� Ÿ�� T
{
	int tos;
	Object[] stck; // ���ÿ� ��Ҹ� ������ ���� �迭
	
	public GStack() {
		tos=0;
		stck=new Object[10];
	}
	public void push(T item) {
		// ������ ���� ���� �� �̻� ��Ҹ� ������ �� ���� �׳� ����
		if(tos==10) return;
		stck[tos]=item;
		tos++;
	}
	@SuppressWarnings("unchecked")
	public T pop() {
		// ������ ��� �־� ���� ��Ұ� ����
		if(tos==0) return null;
		tos--;
		return (T)stck[tos];
	}
}// class GStack<T>


class GenericMethodEx
{
	static <T> void toStack (T[] a, GStack<T> gs) {
		for(int i=0; i<a.length; i++)
			gs.push(a[i]);
	}// 
}// class GenericMethodEx




public class MyStack {

	public static void main(String[] args) {
		
		// String Ÿ���� GStack����
		GStack<String> stringStack = new GStack<String>();
		stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("LA");
		
		// stringStack ���ÿ� �ִ� 3���� ���ڿ� ��
		for(int n=0; n<3; n++)
			System.out.println(stringStack.pop());
//		LA
//		busan
//		seoul

		
		
		GStack<Integer> intStack = new GStack<Integer>();
		intStack.push(1);
		intStack.push(3);
		intStack.push(5);
		
		// intStack ���ÿ� �ִ� 3���� ���� ��
		for(int n=0; n<3; n++)
			System.out.println(intStack.pop());
//		5
//		3
//		1
		
		
	}// main
	
}// class MyStack
