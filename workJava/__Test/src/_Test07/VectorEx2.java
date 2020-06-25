package _Test07;

import java.util.Vector;

//		https://hyeonstorage.tistory.com/208 [개발이 하고 싶어요]
//		동적인 길이로 여러 데이터형을 저장하기 위해 Vector 클래스를 제공
//		Vector 클래스는 가변 길이의 배열

//		Vector()
//			10개의 데이터를 저장할 수 있는 길이의 객체를 생성한다. 
//			저장 공간이 부족한 경우 10개씩 증가한다. 
//		Vector(int size) 
//			size 개의 데이터를 저장할 수 있는 길이의 객체를 생성한다. 
//			저장공간이 부족할 경우 size개씩 증가한다. 
//		Vector(int size, int incr) 
//			size 개의 데이터를 저장할 수 있는 길이의 객체를 생성한다. 
//			저장 공간이 부족한 경우 incr 개씩 증가한다.
//
//		벡터 중간에 삽입하기
//		void add(int index, Object element) 
//			Vector 내의 index 위치에 element 객체를 저장한다. 
//		boolean add(Object o) 
//			o 객체를 Vector 내에 저장하고 그 결과 여부를 true, false로 반환한다.


public class VectorEx2 {
	
	public static void main(String[] args) {
		
//		정수값만 다루는 벡터 생성
		Vector<Integer> v=new Vector<Integer>(); 
		v.add(5); // 5삽입 
		v.add(4); // 4삽입
		v.add(-1); // -1삽입
		v.add(2,100);// 4와 -1사이에 100 삽입
		System.out.println("벡터 내의 요소 객체 수 : " + v.size());// 크기 4
		System.out.println("벡터의 현재 용량 : " + v.capacity());// 벡터 용량 10씩 초기화,증가


		// 모든 요소 정수 출력하기
		for(int i=0; i<v.size(); i++) {
			int n=v.get(i);
			System.out.println(i);
		}// for
//		0
//		1
//		2
//		3

		
		// 벡터 속의 모든 정수 더하기
		int sum=0;
		for(int i=0; i<v.size(); i++) {
			int n = v.elementAt(i);// 벡터의 i번째 정수
			sum+=n;
		}// for
		System.out.println("벡터에 있는 정수 합 : " + sum);
//		벡터에 있는 정수 합 : 108

	}// main
	
}// class VectorEx
