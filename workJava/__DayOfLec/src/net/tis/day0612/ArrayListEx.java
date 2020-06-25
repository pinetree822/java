package net.tis.day0612;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {

	public static void main(String[] args) {
		
		ArrayList<String> arrList = new ArrayList<String>();
		
		Scanner scn = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			System.out.println("�̸��� �Է� >>> ");
			String s = scn.next();
			arrList.add(s);// �Է¹��� �̸� ArrayList<String>�� �߰�
		}// for
		
		
		// ArrayList<String>�� �� ��ü��� ���
		for(int i=0; i<arrList.size(); i++) {
			String name=arrList.get(i);
			System.out.println(name + " ");
		}// for
		
		
		// ���� �� �̸� ���
		int longestIndex = 0; // ���� ���� �� �̸��� �ִ� ArrayList���� �ε���
		for(int i=1; i<arrList.size(); i++) {
			// �̸����� ��
			if(arrList.get(longestIndex).length() < arrList.get(i).length()) {				
				longestIndex = i;// i��° �̸��� �� �� �̸���
			}// if
		}// for
		
		System.out.println("\n ���� �� �̸��� : " + arrList.get(longestIndex));
		scn.close();
		
		
	}// main
	
}// class ArrayListEx
