package net.tis.common;

public class Bank {


	// 7789��ȣ üũ ������ ó��/Ʋ���� �޼��� ���
	// ���ڵ� 1000��, �����Ա� 700, ������� 500
	public static void input() {
		int pwd=7789;
		int money=700;
		if(pwd==7789) {
			money=money+700;
			System.out.println("�����ܾ�=" + money);
		}else
			System.out.println("��й�ȣ�� Ʋ���ϴ�.");
	}
	public static void output() {
		int pwd=7789;
		int money=700;
		if(pwd==7789) {
			money=money+700;
			System.out.println("�����ܾ�=" + money);
		}else
			System.out.println("��й�ȣ�� Ʋ���ϴ�.");
	}
	public void getTotal() {}
	
	public static void main(String[] args) {
		System.out.println("BankŬ����");
//		this.getTotal();
		input();
		output();
		//new Bank().output();
	}// main()
	
}// class Bank




// �޼ҵ� publicŰ���� ������ static������
// Ŭ�����̸�.�޼ҵ�() ���� ���ٰ���
// �޼ҵ�ȣ�� �޼ҵ��̸� ������ ��ȣ()


// �ʵ� publicŰ���� ������ static������
// Ŭ�����̸�.�ʵ� ���� ���ٰ���
// �ʵ�� ��ȣ �����.




