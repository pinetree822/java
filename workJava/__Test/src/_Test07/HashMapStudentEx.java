package _Test07;

import java.util.HashMap;
import java.util.Scanner;



public class HashMapStudentEx {

	public static void main(String[] args) {
		
		// (이름, Student객체) 저장 하는 해시맵 생성
		HashMap<String,Student> map=new HashMap<String,Student>();
		
		// 3명의 학생저장
		map.put("황기태", new Student(1,"010-111-1111"));
		map.put("이재문", new Student(2,"010-222-2222"));
		map.put("김태훈", new Student(3,"010-333-3333"));
		
		
		// HashMap인 map변수에서 이름검색
		Scanner scn=new Scanner(System.in);
		while(true)
		{
			System.out.print("검색할 이름?");
			String name=scn.nextLine();
			if(name.equals("exit")) break; // 입력에서 벗어나 종료 확인
			Student student = map.get(name); // HashMap 원소들의 키타입을 지정해야 가능
			
			if(student == null)
				System.out.println(name + "은 없는 사람입니다.");
			else
				System.out.println("id : " + student.getId() + ", 전화 : " + student.getTel());
			
		}// while
		
		scn.close();
		
		
		
	}// main
}// class HashMapStudent
