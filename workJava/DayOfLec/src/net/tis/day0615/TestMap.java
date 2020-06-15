package net.tis.day0615;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;




public class TestMap {// 412page

	
	public TestMap() {}

	
	public static void main(String[] args) {
	
		// Map, List, Set 인터페이스 new 키워드 불가
		HashMap h = new HashMap();

//		h.put(key, value)
		h.put("1200", "사과");
		h.put("3400", "체리");
		
		
		
		String msg = (String)h.get("1");
		
		System.out.println("h = " + h);
		System.out.println("msg = " + msg);
		System.out.println("(String)h.get(\"1\") = " + (String)h.get("1200"));
//		h = {1200=사과, 3400=체리}
//		msg = null
//		(String)h.get("1") = 사과
		
		

		String msg1 = (String)h.get("3400");
		
		System.out.println("h = " + h);
		System.out.println("msg = " + msg1);
		System.out.println("(String)h.get(\"1\") = " + (String)h.get("3400"));
//		h = {1200=사과, 3400=체리}
//		msg = 체리
//		(String)h.get("1") = 체리
		

		System.out.println(h.keySet());// [1200, 3400]
//		System.out.println(h.keySet());// [1200, 3400]
		System.out.println(h.keySet().getClass().getName());
		// str.getClass().getName();
		

		
		Set key = h.keySet();
		Iterator it = h.keySet().iterator();
		
		String data = (String)it.next();
		String msg2 = (String)h.get("21");
		
		System.out.println(data + " " + msg2);// 1200 null
		System.out.println("data = " + data);// data = 1200
		
		
//		Iterator it = (String)h.get("7800")
//		for(int i=0; i<h.size(); i++) {
//			System.out.println(Iterator<E>);
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}// main()

	
}// class TestMap
