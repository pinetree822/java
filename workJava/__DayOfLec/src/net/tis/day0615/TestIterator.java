package net.tis.day0615;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;




public class TestIterator {// 410page

	public static void main(String[] args) {
		
		// 이름,나이,성별 true/false
		Vector vt = new Vector();
		
		char data[] = {'d','o','n','g'};
		String nick = new String("길동");
		Integer age = new Integer(27);
		Boolean gender = new Boolean(false);
		

		vt.add(nick);
		vt.add(age);
		vt.add(gender);
		
		vt.add(new String("길동"));
		vt.add(new Integer(27));
		vt.add(new Boolean(false));
		
		vt.add("길동");
		vt.add(Integer.valueOf(27));
		vt.add(false);
		
		

		System.out.println("======= vt =======");
		System.out.println(vt);
//		======= vt =======
//		[길동, 27, false, 길동, 27, false, 길동, 27, false]


		
		
		System.out.println("======= vt.get() =======");
		for(int i=0; i<vt.size(); i++) {
			System.out.print(vt.get(i) + " ");
		}System.out.println();
//		======= vt.get() =======
//		길동 27 false 길동 27 false 길동 27 false 


		
		
		//410page Iterator속도가 빠름
		System.out.println("======= it.next() =======");
		Iterator it = vt.iterator();
		while(it.hasNext()==true) {
			System.out.print( it.next() + " ");
		}System.out.println();
//		======= it.next() =======
//		길동 27 false 길동 27 false 길동 27 false 



		
		System.out.println("======= et.nextElement() =======");
		Enumeration et = vt.elements();
		while(et.hasMoreElements()) {
			System.out.print(et.nextElement() + " ");
		}System.out.println();
//		======= et.nextElement() =======
//		길동 27 false 길동 27 false 길동 27 false 
		
		
		
		
		
		
		
	}// main
	
}// class TestIterator
