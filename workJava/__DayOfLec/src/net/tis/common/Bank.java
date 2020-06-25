package net.tis.common;

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
	public void getTotal() {}
	
	public static void main(String[] args) {
		System.out.println("Bank클래스");
//		this.getTotal();
		input();
		output();
		//new Bank().output();
	}// main()
	
}// class Bank




// 메소드 public키워드 다음에 static있으면
// 클래스이름.메소드() 직접 접근가능
// 메소드호출 메소드이름 다음에 괄호()


// 필드 public키워드 다음에 static있으면
// 클래스이름.필드 직접 접근가능
// 필드는 괄호 없어요.




