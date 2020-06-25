package test2;

public class StringEx {

	public static void main(String[] args) {
		String name = "Ja" + "va";
		String str = name + 8.0;

		System.out.println("name = " + name);
		System.out.println("str = " + str);
		System.out.println("7+\" \" = " + 7+" ");
		System.out.println("\" \" + 7 = " + " " + 7);
		System.out.println("7 + \"\" = " + 7 + "");
		System.out.println("\"\" + 7 = " + "" + 7);
		System.out.println("\"\" + \"\" = " + "" + "");
		System.out.println(" 7 + 7 + \"\" = " + 7 + 7 + "");
		System.out.println("\"\" + 7 + 7 = " + "" + 7 + 7);
		
		//System.out.println("8*\" \" = " + 8*" "); // 컴파일오류가 남
		//System.out.println("8/\" \" = " + 8/" "); // 컴파일오류가 남
		//System.out.println("8-\" \" = " + 8-" "); // 컴파일오류가 남

		//System.out.println("9-8+\" \" = " + 9 - 8 + " "); // // 컴파일오류가 남
		System.out.println("9-8+\" \" = " + (9 - 8) + " "); // 정상출력 : 1
		
		
	}//public static void main(String[] args)

}//public class StringEx 

/*
 * (+) 계산순서
 * 
 * 왼쪽에서 오른쪽으로 계산
 * 
 * 숫자형이 나오면 숫자형 계산되고 
 * 문자형이 문자열 계산한다.
 * 
 * 1 + 2 +"3"
 * 1 은 숫자형 계산	-> 합은 1
 * 2 는 숫자형 계산	-> 합은 3
 * 3 은 문자열 계산	-> 합은 "33"
 * 
	name 			= Java
	str 			= Java8.0
	7+" " 			= 7 
	" " + 7 		=  7
	7 + "" 		= 7
	"" + 7 		= 7
	"" + "" 		= 
	 7 + 7 + "" 	= 77
	"" + 7 + 7 	= 77
	9-8+" " = 1 
*/