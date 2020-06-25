package net.tis.day0612;

import java.util.ArrayList;
import java.util.Date;

public class TestBoard3 {

	public static void main(String[] args) {
		
		String write = "길동";
		int cnt = 7;
		java.util.Date wdate = new java.util.Date();
		
		
		
		ArrayList<BoardDTO> alist = new ArrayList<BoardDTO>();
		
		BoardDTO dto = new BoardDTO();
		dto.setName(new String("길동"));
		dto.setCnt(new Integer(7));
		dto.setWdate(new Date());
//		dto.setEmail(new String("aaa@gg.com"));
		
		alist.add(dto);
		
		

		
		
		// 기본정보를 등록
//		Object[] info = new Object[3];	// 배열크기가 많은게 단점
//		Object[] info = new String[3];	//
//		Object[] info = new Object[3];
//		info[0] = write; info[1] = cnt; info[2] = wdate;
		
		// Vector동기=속도가더딤=>정확도100%
		// 비동기처리=속도가빠름=>웹프로그램에서사용
//		ArrayList alist = new ArrayList();
//		alist.add(write);
//		alist.add(cnt);
//		alist.add(wdate);
//		
//		// 추가 add(), 갯수 size(), 가져오기 get(int)
//		for(int i=0; i<alist.size(); i++) {
//			System.out.println(alist.get(i));
//		}
//		
		
		
	}// main()

	
}// class TestBoard
