package _help2;
import java.net.*;
import java.io.*;
/* URLConnection클래스
 * - 추상클래스
 * - URL객체를 통해서 얻는다.
 * - URL클래스로는 원격서버 자원의 결과만 얻어오지만
 *   URLConnection을 사용하면 원격서버의 헤더 정보와 자원에
 *   대한 정보를 얻을 수 있다.
 * */

public class URLConnectionTest {

	public static void main(String[] args) 
			throws IOException {
		String str
		="https://www.google.com/intl/ko_kr/insidesearch/images/features/searchbyimg-step1.jpg";
		URL url=new URL(str);
		URLConnection ucon=url.openConnection();
		ucon.connect();//연결
		
		int fsize=ucon.getContentLength();
		System.out.println("파일의 크기: "+fsize);
		String contentType=ucon.getContentType();
		System.out.println("파일의 컨텐트 타입: "+contentType);
		
		InputStream is=ucon.getInputStream();
		//인터넷상의 이미지 파일을 로컬 컴퓨터로 카피하세요
		//copy3.jpg
		
		BufferedInputStream bis
				=new BufferedInputStream(is);
		BufferedOutputStream bos
		=new BufferedOutputStream(new FileOutputStream("copy3.jpg"));
		
		int input=0,count=0;
		byte[] data=new byte[1024];
		while((input=bis.read(data))!=-1){
			bos.write(data,0,input);
			bos.flush();
			count+=input;
		}
		bis.close();
		is.close();
		bos.close();
		System.out.println(count+"바이트 카피 완료!");
		
		

	}

}









