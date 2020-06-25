package net.tis.day0615;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TestMap416 {

	public static void main(String[] args) {

	
		HashMap<String, String> h = new HashMap<String, String>();
		// 키순으로 정렬처리 - 내림차순
		h.put("e", "선유도ADSDFA-23411P234414");
		h.put("b", "독도LAFDSF-923423K7897789");
		h.put("a", "여의도QREWRE-3423423W243243");
		h.put("c", "선유도1ADSDFA-23411P234414");
		h.put("f", "독도1LAFDSF-923423K7897789");
		h.put("d", "여의도1QREWRE-3423423W243243");
		
		
		Set<String> key = h.keySet();
		Iterator<String> it = key.iterator();
		while(it.hasNext()==true) {
			String keys = it.next();
			String msg = h.get(keys);
			System.out.println(keys + " " + " - msg : " +msg);
		}

//		a  - msg : 여의도QREWRE-3423423W243243
//		b  - msg : 독도LAFDSF-923423K7897789
//		c  - msg : 선유도1ADSDFA-23411P234414
//		d  - msg : 여의도1QREWRE-3423423W243243
//		e  - msg : 선유도ADSDFA-23411P234414
//		f  - msg : 독도1LAFDSF-923423K7897789
		
		
		
		
		
		
	}// main()

}// class TestMap414
