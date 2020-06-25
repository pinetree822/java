package net.tis.day0612;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestBoard {

	public static void main(String[] args) {
		
		// 게시판에서 필수항목 3가지 기술
		// 내용등록, 내용출력, 한건상제
		// 수정, 삭제, 데이터갯수
		// 글올린 사람=String 길동, 조회수=int 0, 날짜=Date 2020-06-12
		// 글올리는 사람들 인원파악 가늠하기 힘듬
		
		String write = "길동";
		int cnt = 7;
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		String fds = sdf.format(dt);
		System.out.println(fds);
		
		
		List alist = null;	// 인터페이스  List()
		Set aset = null;	// 인터페이스  Set()
		Map amap = null;	// 인터페이스  Map()
		
		
		
		
		
	}// main()
	
	
	
	
	public boolean boardInsert(String w, String title, Date d) {
		
		boolean success = false;
		success = true;
		
		
		return success;
	}// boardInsert()
	
	
	public void boardAllPrint() {}
	public void boardDetail() {}
	
}// class TestBoard
