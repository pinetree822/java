package net.tis.day0603;


// 187 Page 생성자
// 생성자는 클래스이름과 동일
// 생성자는 중복해서 작성가능
// 생성자메소드는 리턴값 없지만 void 기술 않함
// 기본생성자는 생략가능 -> 190 Page
public class Car {

	int sp;
	
	// 기본 생성자 생략 가능
	public Car() {
	}
	// 생성자
	public Car(String make) {
	}
	// 생성자
	public Car(int price) {
	}
	// 생성자
	public Car(String make, int m) {
	}
	
	
	public void parking() {}
	public void speedUp() { sp=sp+10; }
	public void speedDown() { sp=sp-20; }
	
	public static void main(String[] args) {
//		Car my=new Car("현대");// my삼성현대쌍용
//		Car my=new Car();// my삼성현대쌍용
//		Hotel tt = new Hotel("부다페");
		Car kim = new Car(); kim.parking();
		Car lee = new Car(); lee.parking();
		Car hong = new Car(); hong.parking();
	}
	
}// class Car
