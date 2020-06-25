package _Test07;

import java.util.Vector;



public class PointVectorEx {
	
	public static void main(String[] args) {
		
		Vector<Point> v= new Vector<Point>();
		
		// 3개의 Point 객체 삽입
		v.add(new Point(2,3));
		v.add(new Point(-5,20));
		v.add(new Point(30,-8));
		
		// v벡터 전체 Point 객체 검색 출력
		for(int i=0; i<v.size(); i++) {
			Point p = v.get(i);// vector의 i번째 Point객체 얻기
			System.out.println(p);// p.toString()이용 객체 p출력
		}// for
//		(2,3)
//		(-5,20)
//		(30,-8)
		System.out.println();

		
		v.remove(1);// 인덱스 1 삭제
		
		for(int i=0; i<v.size(); i++) {
			Point p = v.get(i);// vector의 i번째 Point객체 얻기
			System.out.println(p);// p.toString()이용 객체 p출력
		}// for

//		(2,3)
//		(30,-8)
		
	}// main
	
}// class PointVectorEx
