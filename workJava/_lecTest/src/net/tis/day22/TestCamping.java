package net.tis.day22;

import java.util.Calendar;
import java.util.Scanner;

public class TestCamping {


//	호텔의 전체 방 리스트 정보
//	방 : [ 0 ] 빈방
//	방 : [ 1 ] 빈방
//	방 : [ 2 ] 빈방
//	방 : [ 3 ] 빈방
//	방 : [ 4 ] 빈방

	
//	1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료
//	>>> 1
//	몇번 방에서 예약하시겠습니까? >>> 
//	1
//	2020년 5월 29일 토요일 오후9시간 45분 46초 
//	호텔 : 1번 방 예약완료 되었습니다.
//	-----------------------------------------

	
//	1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료
//	>>> 1
//	몇번 방에서 예약하시겠습니까? >>> 
//	1
//	>>> 예약된 방입니다.
//	-----------------------------------------


//	1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료
//	>>> 2
//	몇번 방에서 퇴실하시겠습니까? >>> 
//	1
//	2020년 5월 29일 토요일 오후9시간 46분 13초 
//	호텔 : 1번 방 퇴실 되었습니다.
//	-----------------------------------------


//	1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료
//	>>> 2
//	몇번 방에서 퇴실하시겠습니까? >>> 
//	2
//	>>> 빈 방입니다.
//	-----------------------------------------


//	1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료
//	>>> 
//	3
//	몇번 방을 확인하시겠습니까? >>> 3
//
//	호텔 : 3번 방은 빈방 입니다.
//	-----------------------------------------

	
//	-----------------------------------------
//	1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료
//	>>> 4
//	호텔의 전체 방 리스트 정보
//	방 : [ 1 ] 예약
//	방 : [ 2 ] 예약
//	방 : [ 3 ] 예약
//	방 : [ 4 ] 빈방
//	방 : [ 5 ] 예약
//	-----------------------------------------


	
//	1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료
//	>>> 9
//	호텔 : 예약 프로그램을 종료합니다.


	
	static String roomChk(boolean chk)
	{
		return chk==false?"빈방":"예약";
	}//
	
	
	public static void main(String[] args) {
		
		boolean hotel[] = new boolean[5];// 방 만들기
		String weeks[] = {"일","월","화","수","목","금","토"};
		String apPm[] = {"오전","오후"};


//		예약<입실>
//		퇴실<빈방 만들기>
//		보기<해당방 보기>
//		전체<방 리스트>
//		종료<프로그램 종료>

//		1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료

		
		// 입력 핸들링
		Scanner scn = new Scanner(System.in);// 입력장치
		int inNum = 0;								// 서비스 번호
		int matchNum = 0;							// 방(예약,보기<검색>,퇴실)번호
        Calendar today;// 예약/퇴실/등록날짜
		
		while(true)
		{
			switch (inNum) {// "프로그램 서비스번호"
			
				////////////////////////////////case1 예약 ////////////////////////////////
				case 1:// 예약
					// 호텔 방번호로 예약 잡기
					System.out.println();
					System.out.print("몇번 방에서 예약하시겠습니까? >>> ");
					System.out.println();

					// 예약 방 번호 입력받기, 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum = scn.nextInt();
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum -= 1; 
					
					// 예약된 방인지 확인
					if(hotel[matchNum]==true)
					{
						System.out.println(">>> 예약된 방입니다.");
						System.out.println("-----------------------------------------");
						break;
					} else {
						// 해당방 인덱스 업데이트 하기
						hotel[matchNum] = true;
					}


			        // 기본적으로 현재날짜와 시간으로 설정된다.
			        today = Calendar.getInstance();
			        System.out.println(
			        				today.get(Calendar.YEAR) + "년 " + 
			        				(today.get(Calendar.MONTH) + 1) + "월 " + 
			        				today.get(Calendar.DATE) + "일 " + 
			        				weeks[ today.get(Calendar.DAY_OF_WEEK) ] + "요일 " +	// (1~7, 1:일요일)
			        				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:오전, 1:오후)
			        				today.get(Calendar.HOUR) + "시간 " + 					// (0~11)
			        				//today.get(Calendar.HOUR_OF_DAY) + "시간 " +			// (0~23)
			        				today.get(Calendar.MINUTE) + "분 " + 					// (0~59)
			        				today.get(Calendar.SECOND) + "초 " 					// (0~59)
			        );
					// 예약 완료 메시지 보여주기
					System.out.println("호텔 : " + (matchNum+1) + "번 방 예약완료 되었습니다.");
					System.out.println("-----------------------------------------");

					// 전체 방 현황 체크리스트
					System.out.println("호텔의 전체 방 리스트 정보");
					for(int i=0; i<hotel.length; i++)
						System.out.println( "방 : [ " + (i+1) + " ] " + roomChk(hotel[i]) );
					System.out.println("-----------------------------------------");
					
					break;
	
					
					
				//////////////////////////////// case2 퇴실////////////////////////////////
				case 2:// 퇴실

					// 호텔 방번호로 예약 잡기
					System.out.println();
					System.out.print("몇번 방에서 퇴실하시겠습니까? >>> ");
					System.out.println();

					// 예약 방 번호 입력받기, 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum = scn.nextInt();
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum -= 1; 

					
					// 빈 방인지 확인
					if(hotel[matchNum] == false)
					{
						System.out.println(">>> 빈 방입니다.");
						System.out.println("-----------------------------------------");
						break;
					} else {
						// 해당방 인덱스 업데이트 하기
						hotel[matchNum] = false;
					}

			        // 기본적으로 현재날짜와 시간으로 설정된다.
			        today = Calendar.getInstance();
			        System.out.println(
			        				today.get(Calendar.YEAR) + "년 " + 
			        				(today.get(Calendar.MONTH) + 1) + "월 " + 
			        				today.get(Calendar.DATE) + "일 " + 
			        				weeks[ today.get(Calendar.DAY_OF_WEEK) ] + "요일 " +	// (1~7, 1:일요일)
			        				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:오전, 1:오후)
			        				today.get(Calendar.HOUR) + "시간 " + 					// (0~11)
			        				//today.get(Calendar.HOUR_OF_DAY) + "시간 " +			// (0~23)
			        				today.get(Calendar.MINUTE) + "분 " + 					// (0~59)
			        				today.get(Calendar.SECOND) + "초 " 					// (0~59)
			        );
			        
					// 예약 완료 메시지 보여주기
					System.out.println("호텔 : " + (matchNum+1) + "번 방 퇴실 되었습니다.");
					System.out.println("-----------------------------------------");


					// 전체 방 현황 체크리스트
					System.out.println("호텔의 전체 방 리스트 정보");
					for(int i=0; i<hotel.length; i++)
						System.out.println( "방 : [ " + (i+1) + " ] " + roomChk(hotel[i]) );
					System.out.println("-----------------------------------------");
					
					break;

				////////////////////////////////case3 보기 ////////////////////////////////
				case 3://보기

					// 요청방 번호 입력받기 - 상태확인
					System.out.print("몇번 방을 확인하시겠습니까? >>> ");
					matchNum = scn.nextInt();
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum -= 1; 
					
					// 해당 방 상태 확인
					System.out.println();
					if( hotel[matchNum]==true ) {
						System.out.println("호텔 : " + (matchNum+1) + "번 방은 예약방 입니다.");
						System.out.println("-----------------------------------------");
					} else {
						System.out.println("호텔 : " + (matchNum+1) + "번 방은 빈방 입니다.");
						System.out.println("-----------------------------------------");
					}
					System.out.println();

					
					// 전체 방 현황 체크리스트
					System.out.println("호텔의 전체 방 리스트 정보");
					for(int i=0; i<hotel.length; i++)
						System.out.println( "방 : [ " + (i+1) + " ] " + roomChk(hotel[i]) );
					System.out.println("-----------------------------------------");

					break;

				////////////////////////////////case4 전체리스트 ////////////////////////////////
				case 4://전체리스트

					// 전체 방 현황 체크리스트
					System.out.println("호텔의 전체 방 리스트 정보");
					for(int i=0; i<hotel.length; i++)
						System.out.println( "방 : [ " + (i+1) + " ] " + roomChk(hotel[i]) );
					System.out.println("-----------------------------------------");
					
					break;

				////////////////////////////////case9 종료 ////////////////////////////////
				case 9://종료
					System.out.println("호텔 : 예약 프로그램을 종료합니다.");
					System.exit(0);
					break;

					////////////////////////////////case9 종료 ////////////////////////////////
				default :
					// 전체 방 현황 체크리스트
					System.out.println();
					System.out.println("호텔의 전체 방 리스트 정보");
					for(int i=0; i<hotel.length; i++)
						System.out.println( "방 : [ " + (i+1) + " ] " + roomChk(hotel[i]) );
					System.out.println("-----------------------------------------");
					break;
			}// switch


			System.out.println();
			System.out.println("1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료");
			
			// 프로그램 서비스번호 입력받기
			System.out.print(">>> ");
			inNum = scn.nextInt();
			
		}// while

		
	}// main
	
}// class hotel
