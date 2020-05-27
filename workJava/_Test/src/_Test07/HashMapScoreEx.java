package _Test07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapScoreEx {

	
	public static void main(String[] args) {
		
//		HashMap�� ��� ���� : 5
//		������ : 99
//		���繮 : 70
//		�賲�� : 98
//		�輺�� : 97
//		Ȳ���� : 88

		// �̸�, ���� ������ HashMap �÷��� ���
		HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
		
		// 5���� ���� ����
		scoreMap.put("�輺��", 97);
		scoreMap.put("Ȳ����", 88);
		scoreMap.put("�賲��", 98);
		scoreMap.put("���繮", 70);
		scoreMap.put("������", 99);
		
		// HashMap ���� ����
		System.out.println("HashMap�� ��� ���� : " + scoreMap.size());
		
		
		// HashMap�� ��� ��� ���� ���(key, value)������ ���
		Set keys = scoreMap.keySet();// ��� key�� ���� Set �÷��� ����
		Iterator<String> it = keys.iterator();// Set�� �ִ� ��� key�� ������� �˻��ϴ� Iterator ����
		
		while(it.hasNext()) {
			String name = it.next();
			int score = scoreMap.get(name);
			System.out.println(name + " : " + score);
		}
		
	}//main
	
}// class HashMapScoreEx
