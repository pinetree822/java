package net.tis.day0612;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestBoard {

	public static void main(String[] args) {
		
		// �Խ��ǿ��� �ʼ��׸� 3���� ���
		// ������, �������, �Ѱǻ���
		// ����, ����, �����Ͱ���
		// �ۿø� ���=String �浿, ��ȸ��=int 0, ��¥=Date 2020-06-12
		// �ۿø��� ����� �ο��ľ� �����ϱ� ����
		
		String write = "�浿";
		int cnt = 7;
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		String fds = sdf.format(dt);
		System.out.println(fds);
		
		
		List alist = null;	// �������̽�  List()
		Set aset = null;	// �������̽�  Set()
		Map amap = null;	// �������̽�  Map()
		
		
		
		
		
	}// main()
	
	
	
	
	public boolean boardInsert(String w, String title, Date d) {
		
		boolean success = false;
		success = true;
		
		
		return success;
	}// boardInsert()
	
	
	public void boardAllPrint() {}
	public void boardDetail() {}
	
}// class TestBoard
