package net.tis.day0612;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Set;
import java.util.HashSet;

public class TestCollection {

	public static void main(String[] args) {
		
		// ArrayList()
		List it = new ArrayList();
		it.add("red");
		it.add(24);
		it.add(true);
		it.add(7.8);
		it.add("red");
		it.add("tis");
		System.out.println(it);// [red, 24, true, 7.8, red, tis]
		
		

		// Vector()
		Vector v = new Vector();
		v.add("blue");
		v.add(34);
		v.add(9.3);
		v.add(24);
		v.add("blue");
		System.out.println(v);//[blue, 34, 9.3, 24, blue]
		
		
		
		Set st = new HashSet();
		st.add("java");
		st.add(56);
		st.add(9.3);
		st.add(56);
		st.add("java");
		st.add("last");
		st.add("java");
		System.out.println(st);//[java, last, 56, 9.3]
		
		
		
//		boolean sss = new Boolean(true);
		
		
	}// main()
	
}// class TestCollection
