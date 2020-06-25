package _Test05;


// class InterfceEx
public class InterfaceEx {

	public static void main(String[] args) {
//		SamsungPhone phone = new SamsungPhone();
//		phone.printLogo();
//		phone.sendCall();
//		phone.receiveCall();
//		phone.flash();
		
		
//		** Phone **
//		따르르르릉~~~
//		음악 연주합니다.
//		3과 5를 더하면 8
//		일정 관리합니다.
		SmartPhone phone = new SmartPhone();
		phone.printLogo();
		phone.sendCall();
		phone.play();
		
		System.out.println("3과 5를 더하면 " + phone.calculate(3, 5));
		phone.schedule();
	}
	
}// class InterfaceEx
