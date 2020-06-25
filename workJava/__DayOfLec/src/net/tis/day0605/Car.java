package net.tis.day0605;



// 예외x, 배열x, 메소드리턴값x, 새로운 메소드x
public class Car {

	private String brand;
	private int year;
	
	// 기본 생성자
	public Car() {
	}// car()
	public Car(String brand) {
		this.brand=brand;
		parking();
	}// car()
	public Car(String brand, int year) {
		this.brand=brand;
		this.year=year;
		parking();
	}// car()
	

	// 차회사에서 주차공간 공유사용
	void parking()
	{
		System.out.println("회사=" + this.brand);
		System.out.println("주차시설");
		System.out.println("안전주차");
	}// parking()
	
	// 차회사에서 주차공간 공유사용
	void parking(String brand)
	{
		System.out.println("회사=" + brand);
		System.out.println("년식 : " + this.year);
		System.out.println("주차시설");
		System.out.println("안전주차");
	}// parking()
	
	void display()
	{
		System.out.println("연비 : 5KM");
	}// display()
	
	public static void main(String[] args) {

		Car cc = new Car("현대기아");
//		new Car().parking();
//		new Car().display();
		
		
//		 배열, 예외처리x, 입력x
//		 생성자x, 메소드 새로 생성x
//		int su=739;
//		연산, if, while, 출력
//		결과 937;// 역순출력
		
//		100 10 1
		System.out.println("int su=739");
		int su=739;
		int remain3 = 0;
		String sus=String.valueOf(su);


		for(int i=sus.length(),res = 1; i>0; i--) {
//			System.out.println("res ="+ (res*=10));
			int muls = (res*=10)/10;// 1~100
			int remaind1 = (su%(muls));// 0,9,39
			int remaind2 = (su%(muls*10));// 9,39,739
//			int remaind3 = (su%(muls*10));// 9,39,739
//			System.out.print("muls="+ muls);
//			System.out.print(", remaind1="+ remaind1);
//			System.out.print(", remaind2="+ remaind2);
//			System.out.println(", remaind3="+ (remaind2-remaind1) );
//			System.out.println("remaind33="+ (remaind2-remaind1)/muls );
			
			remain3 += (remaind2-remaind1)/muls*(int)Math.pow(10, i-1);
//			System.out.println("remain3 = " + remain3);
//			System.out.println("remaind33="+ (remaind2-remaind1)/muls*(int)Math.pow(10, i-1) );
//			System.out.println("remaind4="+ (remaind2-remaind1)*(int)Math.pow(10, i-1));
			
//			int(9)*100
//			int(3.9)*10
//			int(7.39)1
//			System.out.println("su1="+ su1);
		}

		System.out.println("remain3 = " + remain3);
//		res %= 10;
		
		
//		for(int i=sus.length(); i>0; i--) {
//			System.out.println("i="+i+ ", res ="+ Math.pow(10, i-1));
//		}
			
			
//
//		System.out.println("연산, if, while, 출력");
//		
//		System.out.println("결과 : 937");
		
	}// main()
	
}// class Car
