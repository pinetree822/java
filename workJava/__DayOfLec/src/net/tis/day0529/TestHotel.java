package net.tis.day0529;

import java.util.Calendar;
import java.util.Scanner;

public class TestHotel {

	public static void main(String[] args) {
		
		boolean hotel[] = new boolean[5];
		hotel[3] = true;
		
		for(int i=0; i<5; i++)
		{
			System.out.print((i+1) + "캠프\t");
		}
		System.out.println();
		
		
		for(int i=0; i<5; i++)
		{
			if(hotel[i]==true)
			{
				System.out.print("■사용중\t");
			} else{ // if
				System.out.print("□예약\t");
			}
		}// for
		
	}// main
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	static String roomChk(boolean chk)
//	{
//		return chk==false?"빈방":"예약완료";
//	}
//	
//	public static void main(String[] args) {
//		
//		boolean hotel[] = new boolean[5];// 방 만들기
//		String weeks[] = {"일","월","화","수","목","금","토"};
//		String apPm[] = {"오전","오후"};
//		// 빈방 리스트 보여주기
//		// 예약할 방번호
//		// 방 예약 - 변경
//		// 전체방 리스트
//		
//		System.out.println("호텔의 전체 방 리스트 정보");
//		for(int i=0; i<hotel.length; i++)
//			System.out.println( "방 : [ " + i + " ] " + roomChk(hotel[i]) );
//		
//		
//		// 입력 핸들링
//		Scanner scn = new Scanner(System.in);
//		
//		// 호텔 방번호로 예약 잡기
//		System.out.println();
//		System.out.print("호텔 방 번호를 정수로 입력해주세요. >>> ");
//		
//		// 예약 방 번호 입력받기
//		int matchNum = scn.nextInt();
//		
//		// 예약 방 예약 잡기
//		hotel[matchNum] = true;
//		
//		
//
//        // 기본적으로 현재날짜와 시간으로 설정된다.
//        Calendar today = Calendar.getInstance();
//        System.out.println(
//        				today.get(Calendar.YEAR) + "년 " + 
//        				(today.get(Calendar.MONTH) + 1) + "월 " + 
//        				today.get(Calendar.DATE) + "일 " + 
//        				weeks[ today.get(Calendar.DAY_OF_WEEK) ] + "요일 " +	// (1~7, 1:일요일)
//        				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:오전, 1:오후)
//        				today.get(Calendar.HOUR) + "시간 " + 					// (0~11)
//        				//today.get(Calendar.HOUR_OF_DAY) + "시간 " +			// (0~23)
//        				today.get(Calendar.MINUTE) + "분 " + 					// (0~59)
//        				today.get(Calendar.SECOND) + "초 " 					// (0~59)
//        );
//		// 예약 완료 메시지 보여주기
//		System.out.println("호텔 : " + matchNum + "번 방 예약완료 되었습니다.");
//		System.out.println();
//		
//		
//	}// main
	
}// class hotel
