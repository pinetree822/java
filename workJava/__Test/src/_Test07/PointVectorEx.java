package _Test07;

import java.util.Vector;



public class PointVectorEx {
	
	public static void main(String[] args) {
		
		Vector<Point> v= new Vector<Point>();
		
		// 3���� Point ��ü ����
		v.add(new Point(2,3));
		v.add(new Point(-5,20));
		v.add(new Point(30,-8));
		
		// v���� ��ü Point ��ü �˻� ���
		for(int i=0; i<v.size(); i++) {
			Point p = v.get(i);// vector�� i��° Point��ü ���
			System.out.println(p);// p.toString()�̿� ��ü p���
		}// for
//		(2,3)
//		(-5,20)
//		(30,-8)
		System.out.println();

		
		v.remove(1);// �ε��� 1 ����
		
		for(int i=0; i<v.size(); i++) {
			Point p = v.get(i);// vector�� i��° Point��ü ���
			System.out.println(p);// p.toString()�̿� ��ü p���
		}// for

//		(2,3)
//		(30,-8)
		
	}// main
	
}// class PointVectorEx
