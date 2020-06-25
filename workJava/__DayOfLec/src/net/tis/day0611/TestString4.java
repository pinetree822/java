package net.tis.day0611;

import java.util.StringTokenizer;

public class TestString4 {

	public static void main(String[] args) {

		String story="蕊何/愁何//力厚/何措骂霸";
		StringTokenizer st2 = new StringTokenizer(story,"/");
		
		while(st2.hasMoreTokens()==true) {
			System.out.println(st2.nextToken());
		}
		System.out.println();
		
		
		String data[] = story.split(story);
		
		
		
		
		
				
		
	}// main()
	
}// class TestString4
