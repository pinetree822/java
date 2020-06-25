package _Test07;

import java.util.Vector;

//		https://hyeonstorage.tistory.com/208 [������ �ϰ� �;��]
//		������ ���̷� ���� ���������� �����ϱ� ���� Vector Ŭ������ ����
//		Vector Ŭ������ ���� ������ �迭

//		Vector()
//			10���� �����͸� ������ �� �ִ� ������ ��ü�� �����Ѵ�. 
//			���� ������ ������ ��� 10���� �����Ѵ�. 
//		Vector(int size) 
//			size ���� �����͸� ������ �� �ִ� ������ ��ü�� �����Ѵ�. 
//			��������� ������ ��� size���� �����Ѵ�. 
//		Vector(int size, int incr) 
//			size ���� �����͸� ������ �� �ִ� ������ ��ü�� �����Ѵ�. 
//			���� ������ ������ ��� incr ���� �����Ѵ�.
//
//		���� �߰��� �����ϱ�
//		void add(int index, Object element) 
//			Vector ���� index ��ġ�� element ��ü�� �����Ѵ�. 
//		boolean add(Object o) 
//			o ��ü�� Vector ���� �����ϰ� �� ��� ���θ� true, false�� ��ȯ�Ѵ�.


public class VectorEx2 {
	
	public static void main(String[] args) {
		
//		�������� �ٷ�� ���� ����
		Vector<Integer> v=new Vector<Integer>(); 
		v.add(5); // 5���� 
		v.add(4); // 4����
		v.add(-1); // -1����
		v.add(2,100);// 4�� -1���̿� 100 ����
		System.out.println("���� ���� ��� ��ü �� : " + v.size());// ũ�� 4
		System.out.println("������ ���� �뷮 : " + v.capacity());// ���� �뷮 10�� �ʱ�ȭ,����


		// ��� ��� ���� ����ϱ�
		for(int i=0; i<v.size(); i++) {
			int n=v.get(i);
			System.out.println(i);
		}// for
//		0
//		1
//		2
//		3

		
		// ���� ���� ��� ���� ���ϱ�
		int sum=0;
		for(int i=0; i<v.size(); i++) {
			int n = v.elementAt(i);// ������ i��° ����
			sum+=n;
		}// for
		System.out.println("���Ϳ� �ִ� ���� �� : " + sum);
//		���Ϳ� �ִ� ���� �� : 108

	}// main
	
}// class VectorEx
