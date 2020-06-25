package net.tis.day0612;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {

	public static void main(String[] args) {
		
		// https://vaert.tistory.com/108
		// https://riptutorial.com/ko/java/example/11685/iterator%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-%EB%AA%A9%EB%A1%9D%EC%97%90%EC%84%9C-%EC%9D%BC%EC%B9%98-%ED%95%AD%EB%AA%A9-%EC%A0%9C%EA%B1%B0-
		// https://blog.benelog.net/1382604.html
		// ���� ���� �ٷ�� ���׸� ���� ����
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2,100);// ÷�� 2��° ���� �߰��� ������ �迭�� �ļ����� �и���.
		
		
		// Iterator�� �̿��� ��� ���� ���
		Iterator<Integer> it=v.iterator();
		while(it.hasNext()) {
			int n = it.next();
			System.out.println(n);
		}// while
//		5
//		4
//		100
//		-1
		
		
		// Iterator�� �̿��Ͽ� ��� ���� ���ϱ�
		int sum=0;
//		it=v.iterator();
		while(it.hasNext()) {
			int n=it.next();
			sum+=n;
		}
		
		System.out.println("���Ϳ� �ִ� ������ �� : " + sum);
//		���Ϳ� �ִ� ������ �� : 108
		
		
	}// main
	
}// class IteratorEx
