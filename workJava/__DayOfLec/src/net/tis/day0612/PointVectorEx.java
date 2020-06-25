package net.tis.day0612;

import java.util.Vector;

class Point {
	
	private int x, y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}// Point()
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
}// class Point




public class PointVectorEx {

	public static void main(String[] args) {
		
		Vector<Point> v = new Vector<Point>();
		
		// 3개의 Point 객체 삽입
		v.add(new Point(2,3));
		v.add(new Point(-5,20));
		v.add(new Point(30,8));
		
		v.remove(1);
		
		// 벡터에 있는 Point객체 모두 검색하여 출력
		for(int i=0; i<v.size(); i++) {
			Point p = v.get(i);
			System.out.println(p);// p.toString()을 이용하여 객체 p 출력
//			System.out.println(p.toString());// p.toString()을 이용하여 객체 p 출력
		}// for
		System.out.println();
//		(2,3)
//		(30,8)

		
		
	}// main
	
}// class PointVectorEx
