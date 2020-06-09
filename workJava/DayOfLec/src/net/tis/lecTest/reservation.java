package net.tis.lecTest;

import java.util.Date;
import java.util.Scanner;

public class reservation {

	// 12개 좌석( 창문쪽 6개, 통로쪽 6개)
	// 
	private static int[] seats = new int[12];
	
	
	public reservation() {
		
		System.out.println("사랑의 DIC 열차에 오신걸 환영합니다.");
		System.out.println("열차 티켓을 바로 여기에서 구입하십시오");
		System.out.println();
		
		// 12개의 좌석을 0으로 초기화 시킨다.
		for(int i=0; i<12; i++) seats[i]=0;
		
		Scanner s = new Scanner(System.in);// 입력할수 있게 준비 작업
		int choice=1;// 손님이 선택하는 ???
		
		// 사용자에게 창문이나 통로 좌석을 요청하고 음성을 저장합니다.
		System.out.println("0.종료 1.창좌석 2.통로좌석");
		choice=s.nextInt();// 사용자에게 입력받는다.
		
		// 입력된 번호를 분석한다.
		while(choice!=0)
		{
			int seatnumber=0; // 좌석 넘버를 입력받을 변수
			
			/////////////////////////////////////////////////////////
			// 입력된 번호가 1(창가좌석 예약)
			if(choice==1) {
				
				seatnumber = bookWindow(); // 창가좌석 예약
				// bookWindow()에서 -1을 반환하면(창가좌석이 없는경우) 통로좌석을 예약
				if(seatnumber==-1) {
					seatnumber=bookAisle();// 통로좌석 예약
					if(seatnumber!=-1) {// 통로좌석 예약됬다면
						System.out.println("죄송합니다. 창문 좌석을 예약 할 수 없습니다.\r\n" + 
								"그러나 통로 좌석을 예약하였습니다.");
						printBoardingPass(seatnumber);// 좌석현황 출력
					}// if
				}else {
					System.out.println("행운입니다. 창가좌석이 예약이 되었습니다.");
					printBoardingPass(seatnumber);// 좌석현황 출력
				}// if
				
			/////////////////////////////////////////////////////////
			// 입력된 번호가 2(통로좌석 예약) 
			}else if(choice==2) {
				
				// 통로 좌석 예약
				seatnumber = bookAisle();
				if(seatnumber==-1) {// 통로좌석이 예약 않됬다면
					// 창가좌석을 예약
					seatnumber=bookWindow();
					if(seatnumber!=-1) {// 창가좌석이 자동예약 됬다면
						System.out.println("통로 좌석을 예약 할 수 없습니다. 그러나 창문 좌석을 해야하였습니다.");
						printBoardingPass(seatnumber);
					}
				} else {// 통로좌석이 예약됬다면
					System.out.println("통로 좌석이 예약이 됬습니다!");
					printBoardingPass(seatnumber);
				}// if

			/////////////////////////////////////////////////////////
			// 입력된 번호가 1,2 이외의 번호가 입력됬다면..
			}else {
				System.out.println("잘못된 선택입니다. 다시 시도하십시오!");
				choice=0;
			}
			
			
			if(seatnumber==-1) {
				System.out.println("죄송합니다. 이용 가능한 창문 또는 통로 좌석이 없습니다");
				System.out.println();
			}// if
			
			System.out.print("0.종료 1.창좌석 2.통로좌석 >>> ");
			System.out.println();
			choice=s.nextInt();// 좌석 입력받기
		}// while


		System.out.println();
		System.out.println();
		System.out.println("==========================");
		System.out.println("열차 예약 프로그램을 종료합니다.");
		System.out.println("==========================");
		System.out.println();
		System.out.println();
		
	}// reservation()
	
	
	// 이 기능은 예약신청후 티켓정보 안내
	private void printBoardingPass(int seatnumber) {
		Date timenow=new Date();
		System.out.println();
		System.out.println("==========================");
		System.out.println("Date" + timenow.toString());
		System.out.println("좌석 번호 탑승권 :" + seatnumber);
		System.out.println("이 항공권은 환불 및 양도 할 수 없습니다.");
		System.out.println("담배를 피우지 않고 절제하십시오.");
		System.out.println("당신의 여행이 100배 즐길 수 있습니다.");
		System.out.println("==========================");
		System.out.println();
		System.out.println();
	}// printBoardingPass()

	// 이 기능은 통로 좌석이 있는지 확인하고 가득 찬 경우 -1을 확인합니다.
	private int bookAisle() {
		for(int i=6; i<12; i++) {
			if(seats[i]==0) {
				seats[i]=1;
				return i+1;
			}// 통로좌석 예약후 > 좌석 번호값 반환
		}//for
		return -1; // 통로좌석이 없다면 -1을 반환
	}// bookAisle()

	// 이 기능은 창 좌석을 확인하고 좌석 번호를 반환하거나 가득 찬 경우 -1을 반환합니다.
	private int bookWindow() {
		for(int i=0; i<6; i++) {
			if(seats[i]==0) {
				seats[i]=1;
				return i+1;
			}// 창가좌석 예약후 > 좌석 번호값 반환
		}//for
		return -1; // 창가좌석이 없다면 -1을 반환
	}// bookWindow()


	public static void main(String[] args) {
//		System.out.println("열차 예약 시스템에 오신 것을 환영합니다!");
//		System.out.println();
		System.out.println();
		new reservation();
	}// main()
	
}// class reservation
