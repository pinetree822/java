package net.tis.day0612;

import java.util.ArrayList;
import java.util.Date;


//게시판, 방명록, 쇼핑몰
//class BoardDTO
//int 번호
//String pwd
//String 저자
//Date wdate
//boolean 비공개/공개
//
//public void setName(String 저자)
//public String Name()



public class TestBoard2 {

	public static void main(String[] args) {
		
		String write = new String("길동");
		Integer cnt = new Integer(7);
		Date wdate = new Date();


		ArrayList alist = new ArrayList();
		alist.add(new String("길동"));
		alist.add(new Integer(7));
		alist.add(new Date());
		
//		new ArrayList().add(new String(""));
		
		
		
		for(int i=0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}// for
		
		
//		alist.add(write);
//		alist.add(cnt);
//		alist.add(wdate);
		
		
		
		
		
		// 추가 add(), 갯수 size(), 가져오기 get(int)
		for(int i=0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}
		
		
		
	}// main()

	
}// class TestBoard
