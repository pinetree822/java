package _Test06;

public class StringBufferEx {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("This");
		
//		This is pencil
//		This is my pencil
//		This is your pencil
//		This is pencil
//		This
		
		// 문자열 덧붙이기
		sb.append(" is pencil");
		System.out.println(sb);
		
		// " my" 문자열 삽입
		sb.insert(7, " my");
		System.out.println(sb);
		
		// "my"를 "your"로 변경
		sb.replace(8, 10, "your1234");
		System.out.println(sb);
		
		// "your " 삭제
		sb.delete(8, 13);
		System.out.println(sb);
		
		// 스트링 버퍼 내 문자열 길이를 4로 축소, 문자열 잘림
		sb.setLength(4);
		System.out.println(sb);
		
		
	}
}
