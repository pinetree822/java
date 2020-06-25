package test1;
import java.io.IOException;

public class StandardIOEx1 {

	public static void main(String[] args) {
		
		int input = 0;// 버퍼 변수 선언및 할당
		
		try {
			while( (input=System.in.read()) != -1 ) {// 0~255문자 입력하며, input버퍼를 사용하기 때문에 백스페이스(del)키로 수정 가능하다.
				System.out.println(
						"input : " + input + 					// 입력된 숫자(키보드눌렀을때 입력되는 아스키 코드값)를 출력
						", (char)input : " + (char)input		// 입력된 숫자를 문자형 데이타로 변환 출력
				);
			}
		} catch (IOException e) { // System.in에서 에러 발생시 대비
			e.printStackTrace();
		}
	}// 
}//

/*
 * 
 * >> a자 입력시
a
input : 97, (char)input : a
input : 13, (char)input : 
										<----앞문자(개행문자)때문에 줄바꿈 출력
input : 10, (char)input : 


 * >> ㅁ자 입력시
ㅁ
input : 164, (char)input : ¤		// ㅁ 자 입력시
input : 177, (char)input : ±		// ㅁ 자 입력시
input : 13, (char)input : 			// CR, \r (Carriage Return)  문자 - 커서를 제일 앞으로 이동
										<----앞문자(\n개행문자)때문에 줄바꿈 출력
input : 10, (char)input : 			// LF, \n (Linefeed) 문자 - 커서를 새로운 행으로 이동
---------------------------------------------------------------------------------------------------------------




* 입력의 끝을 알리는 문자 				=> ^Z(Ctrl+z) , \r\n(Enter) 가 입력한 문자열의 끝(EOF)을 알리는 문자로 쓰인다.
* 윈도우 프로그램의 종료 문자     		=> ^Z는 read()에서 입력의 종료되었음(스트림의 끝)을 인식하고 -1을 반환하여 알린다.
* 유닉스,매킨토시 프로그램의 종료 문자 => ^D
* 윈도우 콘솔은 한번에 최대 255문자 입력 가능
* 

콘솔( console, 도스창)을 통한 데이터 입력과 콘솔로의 데이터 출력 의미

System.in 	- 콘솔로부터 데이터 입력 ( 타입 : InputStream)
System.out 	- 콘솔로 데이터 출력( 타입 : PrintStream..)
System.err 	- 콘솔로 데이타 출력( 타입 : PrintStream..)


--- 클래스 참고
public final class System {
	public final static InputStream in = nullInputStream();
	public final static PrintStream out = nullInputStream();
	public final static PrintStream err = nullInputStream();
	..
}
------------------------


in, out, err 는 System클래스에서 선언된 클래스변수( Static변수) 이다.











---------------------------------------------------------------------------------------------------------------
http://zetawiki.com/wiki/%EA%B0%9C%ED%96%89%EB%AC%B8%EC%9E%90,_%EB%9D%BC%EC%9D%B8%ED%94%BC%EB%93%9C,_%EC%BA%90%EB%A6%AC%EC%A7%80%EB%A6%AC%ED%84%B4
newline, line ending, line break; break, end-of-line; EOL
새줄문자, 라인엔딩, 뉴라인, 개행문자, 줄바꿈문자, 줄내림문자, 복귀개행

line feed; LF, \n 			= 라인 피드, 뉴라인
carrige return; CR, \r 		= 캐리지 리턴, 리턴

OS									개행문자				16진수 표현
윈도우								CRLF ( \r\n )		0d0a
유닉스 계열(맥 OS, 리눅스)	LF ( \n )				0a
맥 스타일[1]						CR ( \r )				0d
 */
