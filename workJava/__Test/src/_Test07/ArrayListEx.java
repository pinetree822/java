package _Test07;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
	
	public static void main(String[] args) {
		
		ArrayList<String> a=new ArrayList<String>();
		Scanner scn=new Scanner(System.in);
		
		// ArrayList�� �̸� 4���� �߰�
		for(int i=0;i<4;i++) {
			System.out.println("�̸��� �Է��ϼ���. >>");
			String s = scn.next();	// �̸� �Է�
			a.add(s);					// ArrayLIst �÷��ǿ� ����
		}// for
		
		
		// ArrayList ��ü �̸� ���
		for(int i=0; i<a.size(); i++) {
			String name=a.get(i); // i��° ���ڿ� ���
			
		}// for
		
		
		// ���� �� �̸� ���
		int longestIndex = 0; // �� �̸� ArrayList���� �ε��� ��ȣ ����
		for(int i=0; i<a.size(); i++) {
			if(a.get(longestIndex).length() < a.get(i).length()) // �̸� ���� ��
				longestIndex = i; /// �̸��� �� i �ε��� ����
		}
		System.out.println("\n���� �� �̸��� : " + a.get(longestIndex));
		scn.close();
		
	}// main
	
}// class ArrayListEx
