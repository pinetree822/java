package net.tis.day0612;

import java.util.ArrayList;
import java.util.Date;


//�Խ���, ����, ���θ�
//class BoardDTO
//int ��ȣ
//String pwd
//String ����
//Date wdate
//boolean �����/����
//
//public void setName(String ����)
//public String Name()



public class TestBoard2 {

	public static void main(String[] args) {
		
		String write = new String("�浿");
		Integer cnt = new Integer(7);
		Date wdate = new Date();


		ArrayList alist = new ArrayList();
		alist.add(new String("�浿"));
		alist.add(new Integer(7));
		alist.add(new Date());
		
//		new ArrayList().add(new String(""));
		
		
		
		for(int i=0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}// for
		
		
//		alist.add(write);
//		alist.add(cnt);
//		alist.add(wdate);
		
		
		
		
		
		// �߰� add(), ���� size(), �������� get(int)
		for(int i=0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}
		
		
		
	}// main()

	
}// class TestBoard
