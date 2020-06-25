package _Test07;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {

	public static void main(String[] args) {
		
		// 제네릭 벡터(정수값만) 생성
//		Vector v = new Vector();
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2,100);// Vector<Integer>의 인덱스 2번째 추가
		
		
		
//		n=5
//		n=4
//		n=100
//		n=-1
		// https://m.blog.naver.com/PostView.nhn?blogId=rwans0397&logNo=220622092974&proxyReferer=https:%2F%2Fwww.google.com%2F
		// java.util.Iterator class 쓰기
		// Iterator를 이용한 전체 인덱스 정수 출력
		Iterator<Integer> it = v.iterator();// Iterator 객체 얻기
		while(it.hasNext()) {
			int n = it.next();
			System.out.println("n=" + n);
		}// while
		
		
		

//		벡터에 있는 정수 합 : 108
		int sum = 0;
		it = v.iterator(); // Iterator 객체 얻기
		while(it.hasNext()) {
			int n = it.next();
			sum+=n;
		}
		System.out.println("벡터에 있는 정수 합 : " + sum);
		
		
	}// main
}// class IteratorEx
