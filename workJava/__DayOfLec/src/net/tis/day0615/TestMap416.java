package net.tis.day0615;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TestMap416 {

	public static void main(String[] args) {

	
		HashMap<String, String> h = new HashMap<String, String>();
		// Ű������ ����ó�� - ��������
		h.put("e", "������ADSDFA-23411P234414");
		h.put("b", "����LAFDSF-923423K7897789");
		h.put("a", "���ǵ�QREWRE-3423423W243243");
		h.put("c", "������1ADSDFA-23411P234414");
		h.put("f", "����1LAFDSF-923423K7897789");
		h.put("d", "���ǵ�1QREWRE-3423423W243243");
		
		
		Set<String> key = h.keySet();
		Iterator<String> it = key.iterator();
		while(it.hasNext()==true) {
			String keys = it.next();
			String msg = h.get(keys);
			System.out.println(keys + " " + " - msg : " +msg);
		}

//		a  - msg : ���ǵ�QREWRE-3423423W243243
//		b  - msg : ����LAFDSF-923423K7897789
//		c  - msg : ������1ADSDFA-23411P234414
//		d  - msg : ���ǵ�1QREWRE-3423423W243243
//		e  - msg : ������ADSDFA-23411P234414
//		f  - msg : ����1LAFDSF-923423K7897789
		
		
		
		
		
		
	}// main()

}// class TestMap414
