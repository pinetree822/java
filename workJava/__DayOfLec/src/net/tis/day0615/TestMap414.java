package net.tis.day0615;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class TestMap414 {

	public static void main(String[] args) {

/*
		HashMap<Integer, String> h = new HashMap<Integer, String>();
		// Ű������ ����ó�� - ��������
		h.put(3, "������ADSDFA-23411P234414");
		h.put(7, "����LAFDSF-923423K7897789");
		h.put(9, "���ǵ�QREWRE-3423423W243243");
		
		
		Set<Integer> key = h.keySet();
		Iterator<Integer> it = key.iterator();
		while(it.hasNext()==true) {
			Integer num = it.next();
			String  msg = h.get(num);
			System.out.println(num + " " + " - msg : " +msg);
		}
//		3  - msg : ������ADSDFA-23411P234414
//		7  - msg : ����LAFDSF-923423K7897789
//		9  - msg : ���ǵ�QREWRE-3423423W243243

*/
		
		/*
		
		Hashtable<Integer, String> h = new Hashtable<Integer, String>();
		// Ű������ ����ó�� - ��������
		h.put(7, "������ADSDFA-23411P234414");
		h.put(3, "����LAFDSF-923423K7897789");
		h.put(9, "���ǵ�QREWRE-3423423W243243");
		h.put(17, "������1ADSDFA-23411P234414");
		h.put(13, "����1LAFDSF-923423K7897789");
		h.put(9, "���ǵ�1QREWRE-3423423W243243");
		
		
		
		
		Set<Integer> key = h.keySet();
		Iterator<Integer> it = key.iterator();
		while(it.hasNext()==true) {
			Integer num = it.next();
			String  msg = h.get(num);
			System.out.println(num + " " + " - msg : " +msg);
		}
//		9  - msg : ���ǵ�1QREWRE-3423423W243243
//		7  - msg : ������ADSDFA-23411P234414
//		17  - msg : ������1ADSDFA-23411P234414
//		3  - msg : ����LAFDSF-923423K7897789
//		13  - msg : ����1LAFDSF-923423K7897789
*/
		

		
		Hashtable<Integer, String> h = new Hashtable<Integer, String>();
		// Ű������ ����ó�� - ��������
		h.put(7000, "������ADSDFA-23411P234414");
		h.put(3000, "����LAFDSF-923423K7897789");
		h.put(9000, "���ǵ�QREWRE-3423423W243243");
		h.put(1700, "������1ADSDFA-23411P234414");
		h.put(1300, "����1LAFDSF-923423K7897789");
		h.put(9000, "���ǵ�1QREWRE-3423423W243243");
		
		Set<Integer> key = h.keySet();
		Iterator<Integer> it = key.iterator();
		while(it.hasNext()==true) {
			Integer num = it.next();
			String  msg = h.get(num);
			System.out.println(num + " " + " - msg : " +msg);
		}
//		3000  - msg : ����LAFDSF-923423K7897789
//		1700  - msg : ������1ADSDFA-23411P234414
//		7000  - msg : ������ADSDFA-23411P234414
//		1300  - msg : ����1LAFDSF-923423K7897789
//		9000  - msg : ���ǵ�1QREWRE-3423423W243243

		
		
		
		
		
		
	}// main()

}// class TestMap414
