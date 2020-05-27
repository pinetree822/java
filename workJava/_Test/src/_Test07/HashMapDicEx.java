package _Test07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDicEx {

	public static void main(String[] args) {
		

//		https://arabiannight.tistory.com/entry/�ڹ�Java-�ڹ�-HashMap-�̶� [�ƶ��ȳ���Ʈ]
//		Map�������̽��� �������ν� Key�� Value ������ �����͸� ����
		// �ؽø� ����
		HashMap<String,String> dic=new HashMap<String,String>();
		// 3���� ��(key, value)������ dic�� ����
		dic.put("baby", "�Ʊ�");
		dic.put("love", "���");
		dic.put("apple", "���");
		dic.put("banana", "banana");
		
		// �ؽ��� �˻� �ܾ� �Է�
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.print("ã�� ���� �ܾ��? >>>");
			String eng=scn.next();
			
			// while Ż�� �ܾ�
			if(eng.equals("exit")) {
				System.out.println("�����մϴ�...");
				break;
			}// if
			
			// �ؽøʿ��� 'eng'Ű������ 'kor'���� �ִ��� �˻�
			String kor = dic.get(eng);// HashMap����� ����ŸŸ�� ��������� ������ �ʳ���.
			if(kor == null) System.out.println(eng + "�� ���� �ܾ��Դϴ�.");
			else System.out.println("Ű(" + eng +") �� ���� " + kor + "�Դϴ�.");
		}// while
		
		scn.close();
		
	}// main
	
	
}// class HashMapDicEx
