package _Test07;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {

	public static void main(String[] args) {
		
		// ���׸� ����(��������) ����
//		Vector v = new Vector();
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2,100);// Vector<Integer>�� �ε��� 2��° �߰�
		
		
		
//		n=5
//		n=4
//		n=100
//		n=-1
		// https://m.blog.naver.com/PostView.nhn?blogId=rwans0397&logNo=220622092974&proxyReferer=https:%2F%2Fwww.google.com%2F
		// java.util.Iterator class ����
		// Iterator�� �̿��� ��ü �ε��� ���� ���
		Iterator<Integer> it = v.iterator();// Iterator ��ü ���
		while(it.hasNext()) {
			int n = it.next();
			System.out.println("n=" + n);
		}// while
		
		
		

//		���Ϳ� �ִ� ���� �� : 108
		int sum = 0;
		it = v.iterator(); // Iterator ��ü ���
		while(it.hasNext()) {
			int n = it.next();
			sum+=n;
		}
		System.out.println("���Ϳ� �ִ� ���� �� : " + sum);
		
		
	}// main
}// class IteratorEx
