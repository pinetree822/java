package _Test07;

import java.util.HashMap;
import java.util.Scanner;



public class HashMapStudentEx {

	public static void main(String[] args) {
		
		// (�̸�, Student��ü) ���� �ϴ� �ؽø� ����
		HashMap<String,Student> map=new HashMap<String,Student>();
		
		// 3���� �л�����
		map.put("Ȳ����", new Student(1,"010-111-1111"));
		map.put("���繮", new Student(2,"010-222-2222"));
		map.put("������", new Student(3,"010-333-3333"));
		
		
		// HashMap�� map�������� �̸��˻�
		Scanner scn=new Scanner(System.in);
		while(true)
		{
			System.out.print("�˻��� �̸�?");
			String name=scn.nextLine();
			if(name.equals("exit")) break; // �Է¿��� ��� ���� Ȯ��
			Student student = map.get(name); // HashMap ���ҵ��� ŰŸ���� �����ؾ� ����
			
			if(student == null)
				System.out.println(name + "�� ���� ����Դϴ�.");
			else
				System.out.println("id : " + student.getId() + ", ��ȭ : " + student.getTel());
			
		}// while
		
		scn.close();
		
		
		
	}// main
}// class HashMapStudent
