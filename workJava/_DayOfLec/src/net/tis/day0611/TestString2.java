package net.tis.day0611;

import java.util.StringTokenizer;

public class TestString2 {

	public static void main(String[] args) {
		
//		String str = new String("kimLAST");
//		StringBuffer sb = new StringBuffer();
//		
////		sb.append(3, " nice ");
////		sb.insert(3, "nice");
//		str = str.concat("nice");
//		sb.append("kimLAST");
//		sb.insert(3, "nice");
//		System.out.println(str);
//		System.out.println(sb);
		
		
		///////////////////////////////////////
		
		String str = "ab&cd&red&max&tea";
		StringTokenizer st = new StringTokenizer(str, "&");
		
		int n = st.countTokens();
		System.out.println("token 개수="+n);
		
		for(int i=0; i<n; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}// for
		
		System.out.println();
		
		
		// 370페이지 for반복문 대신 while반복문 hasMoreTokens()

		String token1;
		while(st.hasMoreTokens()==true) {
			token1 = st.nextToken();
			System.out.println(token1);
		}
		
		
		
		
	}// main()
}// class TestString2
