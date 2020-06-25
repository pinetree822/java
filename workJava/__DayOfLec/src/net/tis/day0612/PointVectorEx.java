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
		
		// 3���� Point ��ü ����
		v.add(new Point(2,3));
		v.add(new Point(-5,20));
		v.add(new Point(30,8));
		
		v.remove(1);
		
		// ���Ϳ� �ִ� Point��ü ��� �˻��Ͽ� ���
		for(int i=0; i<v.size(); i++) {
			Point p = v.get(i);
			System.out.println(p);// p.toString()�� �̿��Ͽ� ��ü p ���
//			System.out.println(p.toString());// p.toString()�� �̿��Ͽ� ��ü p ���
		}// for
		System.out.println();
//		(2,3)
//		(30,8)

		
		
	}// main
	
}// class PointVectorEx
