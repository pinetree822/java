package _Test06;

public class StringEx {
	
	public static void main(String[] args) {
		String a=new String(" C#");
		String b=new String(",C++");

//		 C#의 길이는 3
//		 false
//		  C#,C++
//		 C#,C++
//		 Java,C++
//		 분리된 문자열0 : Java
//		 분리된 문자열1 : C++
//		 C
		
		// 문자열의 길이(개수)
		System.out.println(a + "의 길이는 " + a.length());
		
		 // 문자열의 포함관계
		System.out.println(a.contains(b));
		
		// 문자열의 연결
		a=a.concat(b); 
		System.out.println(a);
		
		// 문자열 앞 뒤의 공백제거
		a=a.trim();
		System.out.println(a);
		
		 // 문자열 대치(바꿈)
		a=a.replace("C#", "Java");
		System.out.println(a);
		
		// 문자열 분리
		String s[] = a.split(",");
		for(int i=0; i<s.length; i++) System.out.println("분리된 문자열" + i + " : " + s[i]);
		
		// 인덱스 5부터 끝까지 서브 스트링 리턴(반환)
		a=a.substring(5);
		
		// 인덱스 2의 문자 리턴
		char c = a.charAt(0);
		System.out.println(c);
		
		
		
	}
	
}
