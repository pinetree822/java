package net;
import java.net.*;
import java.io.*;
/* URLConnection 클래스
 * 
	- 추상클래스
	- URL객체를 통해서 읽는다.
	- URL클래스로는 원격서버 자원의 결과만 얻어오지만
	URLConnection을 사용하면 원격서버의 헤더 정보와 자원에
	대한 정보를 얻을 수 있다.
	
 * 
 */


public class URLConnectionTest {

	public static void main(String[] args) throws IOException {
		String str = "http://movie.phinf.naver.net/20161007_56/14758034371160CtEW_JPEG/movie_image.jpg?type=m427_320_2";
		URL url = new URL(str);
		URLConnection ucon = url.openConnection();
		ucon.connect();// 연결
		
		int fsize = ucon.getContentLength();
		System.out.println("파일의 크기 : " + fsize);
		
		String contentType = ucon.getContentType();
		System.out.println("파일의 컨텐트 타입 : " + contentType);
		
		// 파일의 크기 : 30276
		// 파일의 컨텐트 타입 : image/jpeg
		
		

		
//		// 인터넷상의 이미지 파일을 로컬 컴퓨터로 카피하세요.
		// copy3.jpg
		
		InputStream is = ucon.getInputStream();									// 읽기
		BufferedInputStream bis = new BufferedInputStream(is);				// 버퍼 생성
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy3.jpg"));// 쓰기버퍼( FileOutputStream("copy3.jpg")을 기반으로 파일쓰기객체 생성 ) 생성
		
		int input = 0, count = 0;			// 읽은바이트, 현재읽은량
		byte[] data = new byte[1024];	// 버퍼 변수
		while((input=bis.read(data))!=-1){
			bos.write(data, 0, input); // 버퍼쓰기
			bos.flush();					// 버퍼비우기
			count += input;				// 현재쓰기량
		}

		System.out.println("카피완료");
		bis.close();
		bos.close();
		is.close();
		//		int input ; // 버퍼 변수 선언 할당
//		FileOutputStream fos = new FileOutputStream("UrlConnection.jpg");
//		while((input=is.read())!=-1){
//			fos.write(input);// 출력되는 데이터는 내부의 StringBuffer에 저장
//			fos.flush();
//		}
//		fos.close();
		
		
	}

}
