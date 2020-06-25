package net.tis.day0602;

import java.util.Arrays;

public class testArray1 {

	
	public static void main(String[] args) {
		
		int scores[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		for(int i = 0; i < scores.length; i++) { scores[i] = i; }
		System.out.println(Arrays.toString(scores));
		
	}
}
