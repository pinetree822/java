package net.tis.day0612;

import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		
		v.add(2, 100);// 4�� -1 ���̿� 100 ����
		
		System.out.println("���� ���� ��� ��ü �� : " + v.size());
		System.out.println("������ ���� �뷮 : " + v.capacity());
//		���� ���� ��� ��ü �� : 4
//		������ ���� �뷮 : 10
		
		
		// ��� ��� ���� ���
		for(int i=0; i<v.size(); i++) {
			int n=v.get(i);
			System.out.println(n);
		}// for
//		5
//		4
//		100
//		-1
		
		// ���� ���� ��� ���� ���ϱ�
		int sum=0;
		for(int i=0; i<v.size(); i++) {
			int n=v.elementAt(i);
			sum+=n;
		}// for
		System.out.println(sum);
//		108
		
		
		
	}// main
	
}// VectorEx
