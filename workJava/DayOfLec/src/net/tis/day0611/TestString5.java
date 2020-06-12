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
			System.out.println("b글자 포함된 문자열입니다.");
		} else {
			System.out.println("조회글자가 없습니다.");
		}
		// b글자 포함된 문자열입니다.
		
		
		
	}// main()
	
}// class TestString5
