package net.tis.day0605;


import java.util.Arrays;

//import net.tis.day0605;

public class Consumer {

	public Consumer() {
		Book my = new Book("영풍문고");
		
		System.out.println("책제목 : " + my.getTitle());
		System.out.println("로또숫자 : " + Arrays.toString(my.lotto()));
		
		String title = my.getTitle();
		System.out.println("제목=" + title);
		System.out.println("제목=" + title);
		
		// 리턴값 없는 display()
//		my.display();
//		System.out.println(my.display());
		// 책제목 : my.geTitle()
		// 로또숫자 :my.lotto()
		
		int[] dt = my.lotto();
		for(int i=0; i<dt.length; i++) {
			System.out.print(dt[i] + " ");
		}
		System.out.println();
		
		
		for(int temp : dt){
			System.out.print(temp + " ");
		}
		System.out.println();
		
		
	}// Consumer()
	
	public static void main(String[] args) {
		new Consumer();
	}// main()
	
}// class Consumer
