package net.tis.day0605;


import java.util.Arrays;

//import net.tis.day0605;

public class Consumer {

	public Consumer() {
		Book my = new Book("��ǳ����");
		
		System.out.println("å���� : " + my.getTitle());
		System.out.println("�ζǼ��� : " + Arrays.toString(my.lotto()));
		
		String title = my.getTitle();
		System.out.println("����=" + title);
		System.out.println("����=" + title);
		
		// ���ϰ� ���� display()
//		my.display();
//		System.out.println(my.display());
		// å���� : my.geTitle()
		// �ζǼ��� :my.lotto()
		
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
