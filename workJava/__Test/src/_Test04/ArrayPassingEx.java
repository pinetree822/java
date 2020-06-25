package _Test04;

public class ArrayPassingEx {

	// 배열 a의 공백문자를 ','로 변경
	static void replaceSpace(char a[]) {
		System.out.println("배열개수 확인>>");
		for(int i=0; i<a.length; i++) {
			System.out.print(i +" ");
			if(a[i] == ' ') a[i] = ',';
		}
		System.out.println();
	}
	// 배열 a의 문자들을 화면에 출력
	static void printCharArray(char a[]) {
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]);
		System.out.println();
	}

	
//	This is a pencil
//	배열개수 확인>>
//	0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
//	This,is,a,pencil
	
	public static void main(String[] args) {
		
		String tmp = "This is a pencil";
		char[] c = tmp.toCharArray();// 문자 배열화
		
		printCharArray(c); // char c 배열 변경전 확인
		replaceSpace(c); // 공백을 ','로 변경
		printCharArray(c);// char c 배열 변경후 확인
		
	}// main
} // class
