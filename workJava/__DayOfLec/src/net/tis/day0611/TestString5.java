package net.tis.day0611;





public class TestString5 {

	public static void main(String[] args) {
		
	
		
		
		String story = "BlueBook";
		System.out.println(story.toLowerCase());// bluebook
		System.out.println(story.toUpperCase());// BLUEBOOK

		String a = story.replace("B", "LA");
		System.out.println(a);// LAlueLAook
		System.out.println(story.replace("B","LA"));// LAlueLAook
		
		boolean ret = story.contains("B");
		if (ret==true) {
			System.out.println("b���� ���Ե� ���ڿ��Դϴ�.");
		} else {
			System.out.println("��ȸ���ڰ� �����ϴ�.");
		}
		// b���� ���Ե� ���ڿ��Դϴ�.
		
		
		
	}// main()
	
}// class TestString5
