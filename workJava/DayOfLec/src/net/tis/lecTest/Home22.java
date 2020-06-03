package net.tis.lecTest;

import java.util.Calendar;
import java.util.Scanner;

public class Home22 {

	
	public Home22() {}

	// 예약,빈방 확인해서 반환
	static String roomChk(boolean chk)
	{
		return chk==false?"번째 ◇캠프비사용":"번째 ◆캠프사용중";
	}//
	
	// 전체방 리스트
	static void roomList(boolean camp[])
	{
		// 전체 캠프 현황 체크리스트
		System.out.println("캠프 리스트 정보");
		for(int i=0; i<camp.length; i++)
		{
			if(camp[i]==true)
				System.out.println(" " + (i+1) + roomChk(camp[i]) );
			else
				System.out.println(" " + (i+1) + roomChk(camp[i]) );
		}
		System.out.println("-----------------------------------------");
	}
	// 제목 출력
	static void titleBar(String text)
	{
		System.out.println();
		System.out.print(text);
		System.out.println();
	}
	
	public static void main(String[] args) {

		// 배열
		// 1) boolean[] = new [5]
		// 입력, 형변환, 반복문
		// if
		// 2) try~ catch

		Scanner sc = new Scanner(System.in);
		boolean camp[] = new boolean[5];
		int num = 0;

		
		
		// 입력받기
		while(true)
		{
			
			try {
				
				System.out.println("\n1.예약 2.퇴실 3.보기 9.종료 >>> ");
				int sel = Integer.parseInt(sc.nextLine());// try~catch

				// 예약 // 호텔 방번호로 예약 잡기
				if(sel == 1) {
					// 제목 출력
					titleBar("캠프 : 몇번 방에서 예약하시겠습니까? >>> ");

					// 예약 방 번호 입력받기, 입력받은 수에서 1 빼면 인덱스랑 같다
					num = Integer.parseInt(sc.nextLine());
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					num -= 1; 
					
					// 예약된 방인지 확인
					if(camp[num]==true)
					{
						titleBar("캠프 : >>> 예약된 방입니다.");
						titleBar("-----------------------------------------");
//						break;
					} else {
						// 해당방 인덱스 업데이트 하기
						camp[num] = true;
					}
					
					// 예약 완료 메시지 보여주기
					titleBar("캠프 : " + (num+1) + "번 방 예약완료 되었습니다.");
					titleBar("-----------------------------------------");
					roomList(camp);// 전체방리스트
					
//					break;
					
				// 퇴실
				}else if(sel == 2) {

					// 제목 출력
					titleBar("캠프 :  몇번 방에서 퇴실하시겠습니까? >>> ");

					// 예약 방 번호 입력받기, 입력받은 수에서 1 빼면 인덱스랑 같다
					num = Integer.parseInt(sc.nextLine());
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					num -= 1; 
					
					// 빈 방인지 확인
					if(camp[num] == false)
					{
						titleBar("캠프 : >>> 빈 방입니다.");
						titleBar("-----------------------------------------");
//						break;
					} else {
						// 해당방 인덱스 업데이트 하기
						camp[num] = false;
					}

					// 예약 완료 메시지 보여주기
					titleBar("캠프 : " + (num+1) + "번 방 퇴실 되었습니다.");
					titleBar("-----------------------------------------");

					roomList(camp);// 전체방리스트					
//					break;
					
				// 보기
				}else if(sel == 3) {
					// 제목 출력
					titleBar("캠프 : 몇번 방을 확인하시겠습니까? >>> ");

					 // 요청방 번호 입력받기 - 상태확인
					num = Integer.parseInt(sc.nextLine());
					
					// 입력받은 수에서 1 빼면 인덱스랑 같다
					num -= 1; 
					
					// 해당 방 상태 확인
					if( camp[num]==true ) {
						titleBar("캠프 : " + (num+1) + "번 방은 예약방 입니다.");
						titleBar("-----------------------------------------");
					} else {
						titleBar("캠프 : 예약 프로그램을 종료합니다.");
						titleBar("캠프 : " + (num+1) + "번 방은 빈방 입니다.");
						titleBar("-----------------------------------------");
					}

					roomList(camp);// 전체방리스트
//					break;
					
					
				// 종료
				}else if(sel==9) {
					// 제목 출력
					titleBar("캠프장 프로그램 종료합니다.");
					System.exit(1);// https://www.it-swarm.dev/ko/java/%EC%8B%9C%EC%8A%A4%ED%85%9C%EC%9D%98-%EC%B0%A8%EC%9D%B4-exit-0-systemexit-1-java%EC%9D%98-systemexit-1/968068812/
					break;
					
				}else {
					System.out.println("해당하는 서비스가 없습니다.\n[ 1, 2, 3, 9] 정수를 입력해주세요.");
				}

			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("1~3을 입력해주세요.");
			}// try
			
		}// while
		sc.close();
		
	}// main()
	
}// class Home22
