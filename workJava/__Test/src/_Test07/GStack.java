package _Test07;

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