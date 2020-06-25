package net;
import java.io.*;
import java.net.*;
/* URL(Uniform Resource Locator)
 * 
 * - 인터넷에 접근 가능한 자원(resource)의 주소를 표현하는 형식을 말함
		여기서는 자원은 인터넷 응용 프로토콜에 따라 다를수 있다.
		
		가령 http 프로토콜의 경우 자원이란 html 페이지, 이미지 파일,
		애플릿 등 각종 파일과 디렉토리를 의미한다.
		
 * - URL 구성요소
 		http://www.naver.com:80/member/join.jsp?name=hong#content
 		protocol		host		:port/path			?queryString#reference
 		
 		
 */

public class URLTest {

	public static void main(String[] args) {
		try {
			String urlStr = "http://movie.naver.com/movie/bi/mi/basic.nhn?code=38899";
			URL url = new URL(urlStr);
			
			URLConnection ucon = url.openConnection();
			//System.out.println("인코딩 :" + ucon.getContentEncoding()); // 주소페이지 인코딩 확인

			System.out.println("프로토콜    : " + url.getProtocol());
			System.out.println("호 스 트     : " + url.getHost());
			System.out.println("포     트     : " + url.getDefaultPort());
			System.out.println("Path          : " + url.getPath());
			System.out.println("QueryString : " + url.getQuery());
			System.out.println("Reference    : " + url.getRef());
			
			// 위 리소스 파일을 읽어서 copy.html로 저장하자.
			// 콘솔에도 출력하자.
			

			String line = ""; // 버퍼 변수 선언 할당
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));// 파일 엔코딩 문제시
			PrintWriter pw = new PrintWriter( System.out, true ); // 콘솔출력
			//FileWriter  fw = new FileWriter("copy.html");
			OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream("copy.html"), "UTF-8"); // 파일 엔코딩 문제시

			while((line = br.readLine())!=null){
				pw.println(line);// 콘솔출력
				fw.write(line + "\r\n");// 파일출력
				fw.flush();
			}
			
			br.close(); 	// System.in과 같은 표준입출력은 닫지 않아도 된다.
			is.close();	// 스트림리더 닫기
			pw.close();	// 스트림리더 닫기
			fw.close();
			System.out.println("프로그램을 종료합니다.");

			//System.out.println(is.);
			

		} catch (MalformedURLException e) {// 주소가 형식에 어긋나면 발생
			e.printStackTrace();
			
		} catch (IOException e) {// InputStream
			e.printStackTrace();
			
		}
		
	}//public static void main(String[] args)

}//public class URLTest
/*
 * 

	프로토콜    : http
	호 스 트     : movie.naver.com
	포     트      : 80
	Path          : /movie/bi/mi/basic.nhn
	QueryString : code=38899
	Reference    : aaa

 * 
 */
