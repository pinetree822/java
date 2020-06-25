package net.tis.day0605;




public class Book {

	// 186~187page 생성자=Constructor
	public Book() {
		System.out.println("Book클래스 기본생성자 / 생략가능");
	}// Book()
	public Book(String books) {
		System.out.println("== [ 책방 : " + books + " ] ==");
	}// Book()

	
	// 클래스 생성자의 특성
	// 클래스이름과 동일
	// 리턴값 없어도 void기술 않함
	// 여러번 중복가능(타입이나 개수 다름)
	// 호출 new키워드 다음에 기술
	// 단한번 호출/ 역활은 초기화
	// ubuntu -hp driver of latest hplip-3.20.5
	public int price(){
		int m=2700;
		return m;
	}// price()
	
	public static String getTitle(){
		String name="몽블랑";
		return name;
	}// getTitle()
	
	public void display(){
		System.out.println("display메소드");
		System.out.println("void display()");
		order(7);
//		return ;// 생략가능
	}// display()

	
	public void order(int dt) {
		int su=dt;
		System.out.println(su);
		// this 키워드는 생략가능
//		return 0;
	}
	
	
	public int lotto()[] {
		int a=27, b=45, c=34, x=22, y=11, z=10;
		int highest[] = {a,b,c,x,y,z};
		return highest;
	}// lotto()

//	
//	public ??? save(){
//		double point=7.9;
//		return point;
//	}// save()
//	
//	
	
	// 개인정보
	// 채팅 / 성별, 나이, 닉네임
	// 데이타저장할 사용할 구조체 - java.util Api 참고 : 
	// List인터페이스, ArryaList, - 저장타입이 모두 다를경우 사용
	// Map - 저장타입이 모두 다를경우 사용

	
}// class Book
