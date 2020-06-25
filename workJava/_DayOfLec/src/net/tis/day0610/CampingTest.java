package net.tis.day0610;

import java.util.Scanner;

public class CampingTest {

	private boolean camp[]= new boolean[5];// 방리스트

	/*
	 * @param int ho 
	 * @return null
	 * 
	 */
	// 입실
	public void input(int ho){ //입실메소드괄호안의 매개인자 int,리턴값 X
		if(camp[ho-1]==true)
			System.out.println("현재 사용중이라서 예약할 수 없습니다.");
		else {
			System.out.println("캠프방 예약 성공 하였습니다.");
			camp[ho-1] = true;
		}
	}// input()
	
	// 퇴실
	public void output(int ho){ //퇴실 메소드괄호안의 매개인자 int,리턴값 X
		if(camp[ho-1]==false)
			System.out.println(ho + "방 캠프방에서 퇴실서비스를 사용할 수 없습니다.");
		else {
			camp[ho-1] = false;
			System.out.println(ho + "방 캠프방에서 퇴실 성공하였습니다.");
		}
	}// output()

	/*
	 * @param null
	 * @return void
	 */
	// 전체 캠프 현황 체크리스트
	public void map()
	{
		System.out.println("-----------------------------------------");
		System.out.println("캠프 리스트 정보");
		System.out.println("-----------------------------------------");
		for(int i=0; i<camp.length; i++)
		{
			if(camp[i]==true)
				System.out.print(" " + (i+1) + ": 입실" );
			else
				System.out.print(" " + (i+1) + ": 빈방" );
		}
		System.out.println("\n-----------------------------------------");
	}// map()

	
	// msg = msg: 입실,퇴실, max = 방개수 최대값?
	public int write(String msg, int max) {// 리턴값, 매개인자 2개

/*
 * @param msg
 * @param max
 * @return int
 * 캠프장 번호받기
 * 
 * 
 */
		Scanner scn = new Scanner(System.in);
		int a=0;
		do {
			System.out.println(">>" + msg + " 할 방번호?");
			a=Integer.parseInt(scn.nextLine());
			if(msg.contentEquals("입실")) input(a);
			else output(a);
		} while(a<1||a>max);
		
		return a;// 방번호가 1보다 작다면 a=0, 방번호가 max보다 크면 a=0;
		
	}// write()
	
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		CampingTest tc = new CampingTest();
		int ret;
		tc.map();// 방 예약현황 한번 출력
		

		while( true ) {
			System.out.print("1.입실 2.퇴실 3.예약상황 9.종료 >>> ");
			int sel=Integer.parseInt(scn.nextLine());
			
			if(sel==1) { // 입실
				ret=tc.write("입실", 5);
			} else if(sel==2) { // 퇴실
				ret=tc.write("퇴실", 5);
			} else if(sel==3) { // 예약상황
				tc.map();
			} else if(sel==9) { // 종료
				System.out.print("캠프 프로그램 종료 되었습니다.");
				System.exit(1);
			}// if
		}// while
		
//		int dt1 = tc.write("입실", 2);
//		int dt2 = tc.write("입실", 4);
	}
	
	
}// class test12
