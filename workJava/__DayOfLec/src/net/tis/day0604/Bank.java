package net.tis.day0604;




public class Bank {

	// 7789번호 체크 맞으면 처리/틀리면 메세지 출력
	// 종자돈 1000원, 오늘입금 700, 오늘출금 500
	public static void input() {
		int pwd=7789;
		int money=700;
		if(pwd==7789) {
			money=money+700;
			System.out.println("현재잔액=" + money);
		}else
			System.out.println("비밀번호가 틀립니다.");
	}
	public static void output() {
		int pwd=7789;
		int money=700;
		if(pwd==7789) {
			money=money+700;
			System.out.println("현재잔액=" + money);
		}else
			System.out.println("비밀번호가 틀립니다.");
	}
	public static void getTotal() {}
	
	public static void main(String[] args) {
		System.out.println("Bank클래스");
		getTotal();
		input();
		output();
		//new Bank().output();
	}// main()
	
}// class Bank
