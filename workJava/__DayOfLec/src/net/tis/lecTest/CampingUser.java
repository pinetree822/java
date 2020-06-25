package net.tis.lecTest;

import java.util.Scanner;



public class CampingUser {

	
	
	
	public CampingUser() {}// CampingUser()
	
	
	
	
	void menu() {}
	void input() {}
	void output() {}
	void map() {}
	void write() {}
	
	
	
	
	public static void main(String[] args) {
		
//		1.예약 2.퇴실 3.보기 9.종료 >>> 

		CampingTest ct=new CampingTest();
		Scanner scmain=new Scanner(System.in);
		int sel=3, num=0;// 지역변수
		

//		while(true) {
//			
//			try {
//				
//				sel=ct.menu();// 주메인메뉴 출력
//				
//				if(sel==1) {
//					num=ct.write("입실", 5);
//					ct.input(num);
//					ct.map();
//				}else if(sel==2) {
//					num=ct.write("퇴실", 5);
//					ct.input(num);
//					ct.map();
//				}else if(sel==3) {
//					num=ct.write("보기", 5);
//					ct.input(num);
//					ct.map();
//				}else if(sel==9) {
//					System.out.println("프로그램을 종료합니다.");
//				}else {
//					System.out.println("잘못 입력하셨습니다.");
//				}//if
//				
//				ct.map();
//			} catch (Exception e) {}//try
//			
//		}// while
		
		
	}// main()
	
	
}// class CampingUser
