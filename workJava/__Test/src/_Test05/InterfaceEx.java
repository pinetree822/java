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
//		����������~~~
//		���� �����մϴ�.
//		3�� 5�� ���ϸ� 8
//		���� �����մϴ�.
		SmartPhone phone = new SmartPhone();
		phone.printLogo();
		phone.sendCall();
		phone.play();
		
		System.out.println("3�� 5�� ���ϸ� " + phone.calculate(3, 5));
		phone.schedule();
	}
	
}// class InterfaceEx
