package net.tis.day0604;




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
	public static void getTotal() {}
	
	public static void main(String[] args) {
		System.out.println("BankŬ����");
		getTotal();
		input();
		output();
		//new Bank().output();
	}// main()
	
}// class Bank
