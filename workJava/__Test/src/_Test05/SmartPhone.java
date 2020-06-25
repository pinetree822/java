package _Test05;

//PDA 상속
//MobilePhoneInterface, Mp3Interface 선언된 추상메소드 구현
class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface
{
	//PhoneInterface 추상메소드 구현
	@Override
	public void sendCall() {	// 추상 메소드
		System.out.println("따르르르릉~~~");
	}
	@Override
	public void receiveCall() {	// 추상 메소드
		System.out.println("전화 왔어요.");
	}

	//MobilePhoneInterface 추상메소드 구현
	@Override
	public void sendSMS() { 	// 추상 메소드
		System.out.println("문자 갑니다.");
	}
	@Override
	public void receiveSMS() {// 추상 메소드
		System.out.println("문자 왔어요.");
	}
	
	//MP3 추상메소드 구현
	@Override
	public void play() {			// 추상 메소드
		System.out.println("음악 연주합니다.");
	}
	@Override
	public void stop() {		// 추상 메소드
		System.out.println("음악 중단합니다.");
	}
	
	// 추가 작성한 메소드
	public void schedule() {
		System.out.println("일정 관리합니다.");
	}
	
}// class SmartPhone