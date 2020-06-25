package net.tis.day0608;




public class Book {

	

	public static void main(String[] args) {
		System.out.println("영풍문고");
		System.out.println("교보문고");
		
		//Book book = new Book();
		//book.display();
		
	}// main()
	
	

	
	public void display(){// non-static메서드
		String a = getTitle();
		int b = price();
		note();// 리턴값 없는 메소드 호출
	
		System.out.println("책제목=" + a);
		System.out.println("책제목=" + getTitle());
		System.out.println("책가격=" + b);
		System.out.println("책가격=" + price());
		// 리턴값 없는 메소드는 호출가능?
		
		int lot[] = lotto();
		
	}// display()
	
	public String getTitle(){// non-static메서드
		String name="몽블랑";// 지역변수 title기억 , 다른곳에서
		return name;
	}// getTitle()
	
	public int price(){// non-static메서드
		int m=2700;
		return m;
	}// price()
	

	public void note(){// non-static메서드
		System.out.println("note메소드");
//		System.out.println("로또발생=42,31,7,16,29,30");
//		System.out.println("난수="+Math.random());
	}// note()
	
	// static 없는 메소드를 non-static
	// 같은 클래스에서 non-static끼리는 서로 호출 가능
	
	public int lotto()[] {
		int[] su = {42, 31, 7, 16, 29, 34};
//		int[] su = 42;
		return su;
	}
	
	public boolean camping()[] {
//		boolean cm = true;
		boolean cm[] = new boolean[5];
		return cm;
	}
	
	public double save() {
		double point = 7.2;
		return point;
	}
	
	public String city()[] {
		String dong[] = {"제주", "독도", "선유도"};
		return dong;
	}
}// class Book
