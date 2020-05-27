package _Test07;



// https://www.google.com/search?sxsrf=ALeKk00PRbLZng61JvtcHoBLiUQBBKGweQ%3A1590573275594&ei=2zjOXsvkI5j6wQPDwK-4Dg&q=%EC%9E%90%EB%B0%94+%EC%A0%9C%EB%84%88%EB%A6%AD&oq=%EC%9E%90%EB%B0%94+%EC%A0%9C%EB%84%88%EB%A6%AD&gs_lcp=CgZwc3ktYWIQAzIECAAQQzIECAAQCjIECAAQCjIECAAQQzIECAAQCjIECAAQCjIECAAQCjIECAAQCjIECAAQCjIECAAQQzoCCAA6BggAEAgQHjoHCAAQFBCHAlDmibwBWJOVvAFgzZa8AWgAcAB4AIABfIgB_AiSAQQwLjEwmAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiLvtKY49PpAhUYfXAKHUPgC-cQ4dUDCAw&uact=5

class GStack<T>	// 제네릭 스택 선언, 제네릭 타입 T
{
	int tos;
	Object[] stck; // 스택에 요소를 저장할 공간 배열
	
	public GStack() {
		tos=0;
		stck=new Object[10];
	}
	public void push(T item) {
		// 스택이 가득 차서 더 이상 요소를 삽입할 수 없음 그냥 리턴
		if(tos==10) return;
		stck[tos]=item;
		tos++;
	}
	@SuppressWarnings("unchecked")
	public T pop() {
		// 스택이 비어 있어 꺼낼 요소가 없음
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
		
		// String 타입의 GStack생성
		GStack<String> stringStack = new GStack<String>();
		stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("LA");
		
		// stringStack 스택에 있는 3개의 문자열 팝
		for(int n=0; n<3; n++)
			System.out.println(stringStack.pop());
//		LA
//		busan
//		seoul

		
		
		GStack<Integer> intStack = new GStack<Integer>();
		intStack.push(1);
		intStack.push(3);
		intStack.push(5);
		
		// intStack 스택에 있는 3개의 정수 팝
		for(int n=0; n<3; n++)
			System.out.println(intStack.pop());
//		5
//		3
//		1
		
		
	}// main
	
}// class MyStack
