package day0625;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class TestVectorSample  {
	public static void main(String[] args) {
	   Vector vt = new Vector();
	   vt.add("DONG");
	   vt.add(24);
	   vt.add(true);
	   
	   for(int i=0; i<vt.size();i++) {
	  	 System.out.print(vt.get(i) +" ");
	   } System.out.println();
	   
	   Enumeration et =vt.elements();  //나열 열거 
	   while(et.hasMoreElements()==true) {
	  	 System.out.print(et.nextElement() +" ");
	   }System.out.println();
	   
	   //411페이지, 414페이지 
	   Iterator it = vt.iterator();  //권장형 나열 열거
	   while(it.hasNext()==true) {
	  	 System.out.print(it.next() +" ");
	   }
	   
	}//main end
}// class END








