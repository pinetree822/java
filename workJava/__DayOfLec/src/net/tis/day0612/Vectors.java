package net.tis.day0612;

import java.util.Vector;


public class Vectors {

	
	public static void main(String[] args) {
		
		Vector<Integer> my = new Vector<Integer>();
		
//		my.addElement("�ٳ���");
//		my.add(Integer.parseInt("�ٳ���"));
		my.add(Integer.parseInt("3200"));
		my.add(3200);
//		my.add("������");
//		my.add("false");
		
		
		for(int i=0; i<my.size(); i++) {
			System.out.println(my.get(i));			
		}
	}// main
	
}// class Vector
