package _Test05;

//PDA ���
//MobilePhoneInterface, Mp3Interface ����� �߻�޼ҵ� ����
class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface
{
	//PhoneInterface �߻�޼ҵ� ����
	@Override
	public void sendCall() {	// �߻� �޼ҵ�
		System.out.println("����������~~~");
	}
	@Override
	public void receiveCall() {	// �߻� �޼ҵ�
		System.out.println("��ȭ �Ծ��.");
	}

	//MobilePhoneInterface �߻�޼ҵ� ����
	@Override
	public void sendSMS() { 	// �߻� �޼ҵ�
		System.out.println("���� ���ϴ�.");
	}
	@Override
	public void receiveSMS() {// �߻� �޼ҵ�
		System.out.println("���� �Ծ��.");
	}
	
	//MP3 �߻�޼ҵ� ����
	@Override
	public void play() {			// �߻� �޼ҵ�
		System.out.println("���� �����մϴ�.");
	}
	@Override
	public void stop() {		// �߻� �޼ҵ�
		System.out.println("���� �ߴ��մϴ�.");
	}
	
	// �߰� �ۼ��� �޼ҵ�
	public void schedule() {
		System.out.println("���� �����մϴ�.");
	}
	
}// class SmartPhone