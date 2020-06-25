package net.tis.day0529;

import java.util.Calendar;
import java.util.Scanner;


/// 수정해야됨
public class TestHotel1 {

	static String roomChk(boolean chk)
	{
		return chk==false?"빈방":"예약";
	}

	
//	호텔의 전체 방 리스트 정보
//	방 : [ 0 ] 빈방
//	방 : [ 1 ] 빈방
//	방 : [ 2 ] 빈방
//	방 : [ 3 ] 빈방
//	방 : [ 4 ] 빈방
//
//	호텔 방 번호를 정수로 입력해주세요. >>> 1
//	2020년 5월 29일 토요일 오후1시간 53분 3초 
//	호텔 : 1번 방 예약완료 되었습니다.
	
	
	public static void main(String[] args) {
		
		boolean hotel[] = new boolean[5];// 방 만들기
		String weeks[] = {"일","월","화","수","목","금","토"};
		String apPm[] = {"오전","오후"};
		// 빈방 리스트 보여주기
		// 예약할 방번호
		// 방 예약 - 변경
		// 전체방 리스트
		

		


		
		while(true)
		{
			System.out.println("호텔의 전체 방 리스트 정보");
			for(int i=0; i<hotel.length; i++)
				System.out.println( "방 : [ " + (i+1) + " ] " + roomChk(hotel[i]) );

			// 입력 핸들링
			Scanner scn = new Scanner(System.in);
			
			// 호텔 방번호로 예약 잡기
			System.out.println();
			System.out.print("호텔 방 번호를 정수로 입력해주세요. >>> ");
			System.out.println();
			
			
			
			// 입력받은 호텔 방번호 값을  hotel배열의 인덱스로 전환(hotel) 확인
			int matchNum = scn.nextInt()-1;// 방번호를 인덱스로 전환
			int matchRoom = (matchNum>0 && matchNum<=hotel.length)?matchNum:1;//인덱스에 벗어나면 
			
			

			// 예약 : 1, 퇴실 : 0
			// 방에 대한 상태변화 입력 : 예약/퇴실 방 번호
			
			// 0 < matchNum-1 < hotel.length
			// 일치된 방번호인지 확인
			// 방의 상태변화가 맞는지
			// 예약(입실) 	-> 퇴실
			// 퇴실 		-> 예약(입실)
			if(0 <= matchNum) {}

			// 예약 방 예약 잡기
			hotel[matchNum] = true;

			
			break;
		}
		
		
		
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
//		// 전체 방 리스트 보여주기
//		for(int i=0; i<hotel.length; i++)
//			System.out.println( "방 : [ " + i + " ] " + roomChk(hotel[i]) );
//		
//		

		// 방 입력 다시 하기/// 예약(입실)은 퇴실 가능한다.
		// 빈방은 퇴실이 불가능하다.
		
	}// main
	
}// class hotel
