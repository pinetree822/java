package net.tis.day0612;

import java.util.ArrayList;
import java.util.Date;

public class TestBoard3 {

	public static void main(String[] args) {
		
		String write = "�浿";
		int cnt = 7;
		java.util.Date wdate = new java.util.Date();
		
		
		
		ArrayList<BoardDTO> alist = new ArrayList<BoardDTO>();
		
		BoardDTO dto = new BoardDTO();
		dto.setName(new String("�浿"));
		dto.setCnt(new Integer(7));
		dto.setWdate(new Date());
//		dto.setEmail(new String("aaa@gg.com"));
		
		alist.add(dto);
		
		

		
		
		// �⺻������ ���
//		Object[] info = new Object[3];	// �迭ũ�Ⱑ ������ ����
//		Object[] info = new String[3];	//
//		Object[] info = new Object[3];
//		info[0] = write; info[1] = cnt; info[2] = wdate;
		
		// Vector����=�ӵ�������=>��Ȯ��100%
		// �񵿱�ó��=�ӵ�������=>�����α׷��������
//		ArrayList alist = new ArrayList();
//		alist.add(write);
//		alist.add(cnt);
//		alist.add(wdate);
//		
//		// �߰� add(), ���� size(), �������� get(int)
//		for(int i=0; i<alist.size(); i++) {
//			System.out.println(alist.get(i));
//		}
//		
		
		
	}// main()

	
}// class TestBoard
