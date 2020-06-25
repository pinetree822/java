package net.tis.lecTest;

import java.util.Calendar;
import java.util.Scanner;

public class TestCamping2 {

	// 예약,빈방 확인해서 반환
	static String roomChk(int chk)
	{
		return chk==0?"빈방":"예약";
	}//
	
	
	// 전체방 리스트
	static void roomList(int hotel[])
	{
		// 전체 방 현황 체크리스트
		System.out.println("호텔의 전체 방 리스트 정보");
		for(int i=0; i<hotel.length; i++)
			System.out.println( "방 : [ " + (i+1) + " ] " + roomChk(hotel[i]) );
		System.out.println("-----------------------------------------");
	}

	// 현재의 시간
	static void regisTime()
	{
		String weeks[] = {"일","월","화","수","목","금","토"};
		String apPm[] = {"오전","오후"};
        // 기본적으로 현재날짜와 시간으로 설정된다.
        Calendar today = Calendar.getInstance();
        System.out.println(
        				today.get(Calendar.YEAR) + "년 " + 
        				(today.get(Calendar.MONTH) + 1) + "월 " + 
        				today.get(Calendar.DATE) + "일 " + 
        				weeks[ today.get(Calendar.DAY_OF_WEEK)-1 ] + "요일 " +	// (1~7, 1:일요일)
        				apPm[ today.get(Calendar.AM_PM) ] + 				// (0:오전, 1:오후)
        				today.get(Calendar.HOUR) + "시간 " + 					// (0~11)
        				//today.get(Calendar.HOUR_OF_DAY) + "시간 " +			// (0~23)
        				today.get(Calendar.MINUTE) + "분 " + 					// (0~59)
        				today.get(Calendar.SECOND) + "초 " 					// (0~59)
        );
	}
	
	
	// 제목 출력
	static void titleBar(String text)
	{
		System.out.println();
		System.out.print(text);
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args) {
		
		int hotel[] = new int[5];// 방 만들기
		int inNum = 0;								// 서비스 번호
		int matchNum = 0;							// 방(예약,보기<검색>,퇴실)번호
		
		// 입력 핸들링
		Scanner scn = new Scanner(System.in);// 입력장치
		
		while(true)
		{
			switch (inNum) {// "프로그램 서비스번호"
			
				////////////////////////////////case1 예약 ////////////////////////////////
				case 1:// 예약 // 호텔 방번호로 예약 잡기
					// 제목 출력
					titleBar("호텔 : 몇번 방에서 예약하시겠습니까? >>> ");

					// 예약 방 번호 입력받기, 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum = scn.nextInt();
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum -= 1; 
					
					// 예약된 방인지 확인
					if(hotel[matchNum]==1)
					{
						titleBar("호텔 : >>> 예약된 방입니다.");
						titleBar("-----------------------------------------");
						break;
					} else {
						// 해당방 인덱스 업데이트 하기
						hotel[matchNum] = 1;
					}
			        
					regisTime();// 현날짜,시간
					
					// 예약 완료 메시지 보여주기
					titleBar("호텔 : " + (matchNum+1) + "번 방 예약완료 되었습니다.");
					titleBar("-----------------------------------------");

					roomList(hotel);// 전체방리스트					
					break;
	
					
					
				//////////////////////////////// case2 퇴실////////////////////////////////
				case 2:// 퇴실

					// 제목 출력
					titleBar("호텔 :  몇번 방에서 퇴실하시겠습니까? >>> ");

					// 예약 방 번호 입력받기, 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum = scn.nextInt();
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum -= 1; 

					
					// 빈 방인지 확인
					if(hotel[matchNum] == 0)
					{
						titleBar("호텔 : >>> 빈 방입니다.");
						titleBar("-----------------------------------------");
						break;
					} else {
						// 해당방 인덱스 업데이트 하기
						hotel[matchNum] = 0;
					}

					regisTime();// 현날짜,시간
					
					// 예약 완료 메시지 보여주기
					titleBar("호텔 : " + (matchNum+1) + "번 방 퇴실 되었습니다.");
					titleBar("-----------------------------------------");

					roomList(hotel);// 전체방리스트					
					break;

				////////////////////////////////case3 보기 ////////////////////////////////
				case 3://보기
					// 제목 출력
					titleBar("호텔 : 몇번 방을 확인하시겠습니까? >>> ");

					 // 요청방 번호 입력받기 - 상태확인
					matchNum = scn.nextInt();
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					matchNum -= 1; 
					
					// 해당 방 상태 확인
					if( hotel[matchNum]==1 ) {
						titleBar("호텔 : " + (matchNum+1) + "번 방은 예약방 입니다.");
						titleBar("-----------------------------------------");
					} else {
						titleBar("호텔 : 예약 프로그램을 종료합니다.");
						titleBar("호텔 : " + (matchNum+1) + "번 방은 빈방 입니다.");
						titleBar("-----------------------------------------");
					}

					roomList(hotel);// 전체방리스트
					break;

				////////////////////////////////case4 전체리스트 ////////////////////////////////
				case 4://전체리스트
					roomList(hotel);// 전체방리스트
					break;

				////////////////////////////////case9 종료 ////////////////////////////////
				case 9://종료
					// 제목 출력
					titleBar("호텔 : 예약 프로그램을 종료합니다.");
					System.exit(0);
					break;

				////////////////////////////////default 종료 ////////////////////////////////
				default :
					roomList(hotel);// 전체방리스트
					break;
			}// switch

			
			

			// 제목 출력
			titleBar("1) 예약<입실> 2)퇴실 3) 보기 4) 전체 9)종료");
			
			// 프로그램 서비스번호 입력받기
			System.out.print(">>> ");
			inNum = scn.nextInt();
			
		}// while

		
	}// main
	
}// class hotel
