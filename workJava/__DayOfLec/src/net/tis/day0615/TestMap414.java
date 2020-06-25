package net.tis.day0615;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class TestMap414 {

	public static void main(String[] args) {

/*
		HashMap<Integer, String> h = new HashMap<Integer, String>();
		// 키순으로 정렬처리 - 내림차순
		h.put(3, "선유도ADSDFA-23411P234414");
		h.put(7, "독도LAFDSF-923423K7897789");
		h.put(9, "여의도QREWRE-3423423W243243");
		
		
		Set<Integer> key = h.keySet();
		Iterator<Integer> it = key.iterator();
		while(it.hasNext()==true) {
			Integer num = it.next();
			String  msg = h.get(num);
			System.out.println(num + " " + " - msg : " +msg);
		}
//		3  - msg : 선유도ADSDFA-23411P234414
//		7  - msg : 독도LAFDSF-923423K7897789
//		9  - msg : 여의도QREWRE-3423423W243243

*/
		
		/*
		
		Hashtable<Integer, String> h = new Hashtable<Integer, String>();
		// 키순으로 정렬처리 - 내림차순
		h.put(7, "선유도ADSDFA-23411P234414");
		h.put(3, "독도LAFDSF-923423K7897789");
		h.put(9, "여의도QREWRE-3423423W243243");
		h.put(17, "선유도1ADSDFA-23411P234414");
		h.put(13, "독도1LAFDSF-923423K7897789");
		h.put(9, "여의도1QREWRE-3423423W243243");
		
		
		
		
		Set<Integer> key = h.keySet();
		Iterator<Integer> it = key.iterator();
		while(it.hasNext()==true) {
			Integer num = it.next();
			String  msg = h.get(num);
			System.out.println(num + " " + " - msg : " +msg);
		}
//		9  - msg : 여의도1QREWRE-3423423W243243
//		7  - msg : 선유도ADSDFA-23411P234414
//		17  - msg : 선유도1ADSDFA-23411P234414
//		3  - msg : 독도LAFDSF-923423K7897789
//		13  - msg : 독도1LAFDSF-923423K7897789
*/
		

		
		Hashtable<Integer, String> h = new Hashtable<Integer, String>();
		// 키순으로 정렬처리 - 내림차순
		h.put(7000, "선유도ADSDFA-23411P234414");
		h.put(3000, "독도LAFDSF-923423K7897789");
		h.put(9000, "여의도QREWRE-3423423W243243");
		h.put(1700, "선유도1ADSDFA-23411P234414");
		h.put(1300, "독도1LAFDSF-923423K7897789");
		h.put(9000, "여의도1QREWRE-3423423W243243");
		
		Set<Integer> key = h.keySet();
		Iterator<Integer> it = key.iterator();
		while(it.hasNext()==true) {
			Integer num = it.next();
			String  msg = h.get(num);
			System.out.println(num + " " + " - msg : " +msg);
		}
//		3000  - msg : 독도LAFDSF-923423K7897789
//		1700  - msg : 선유도1ADSDFA-23411P234414
//		7000  - msg : 선유도ADSDFA-23411P234414
//		1300  - msg : 독도1LAFDSF-923423K7897789
//		9000  - msg : 여의도1QREWRE-3423423W243243

		
		
		
		
		
		
	}// main()

}// class TestMap414
