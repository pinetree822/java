package _Test07;


class GStack2<T> { // ���׸� ���� ����. ���׸� Ÿ�� T
	int tos; 
	Object [] stck; // ���ÿ� ��Ҹ� ������ ���� �迭
	public GStack2() {
		tos = 0; 
		stck = new Object [10];
	}
	public void push(T item) {
		if(tos == 10) // ������ �� ���� �� �̻� ��Ҹ� ������ �� ����
			return;  
		stck[tos] = item;
		tos++;
	}
	@SuppressWarnings("unchecked")
	public T pop() {
		if(tos == 0) // ������ ��� �־� ���� ��Ұ� ����
			return null;
		tos--; 
		return (T)stck[tos]; // Ÿ�� �Ű� ���� Ÿ������ ĳ���� 
	}
}
