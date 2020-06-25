package net;
import java.net.*;
import java.io.*;
/* URLConnection Ŭ����
 * 
	- �߻�Ŭ����
	- URL��ü�� ���ؼ� �д´�.
	- URLŬ�����δ� ���ݼ��� �ڿ��� ����� ��������
	URLConnection�� ����ϸ� ���ݼ����� ��� ������ �ڿ���
	���� ������ ���� �� �ִ�.
	
 * 
 */


public class URLConnectionTest {

	public static void main(String[] args) throws IOException {
		String str = "http://movie.phinf.naver.net/20161007_56/14758034371160CtEW_JPEG/movie_image.jpg?type=m427_320_2";
		URL url = new URL(str);
		URLConnection ucon = url.openConnection();
		ucon.connect();// ����
		
		int fsize = ucon.getContentLength();
		System.out.println("������ ũ�� : " + fsize);
		
		String contentType = ucon.getContentType();
		System.out.println("������ ����Ʈ Ÿ�� : " + contentType);
		
		// ������ ũ�� : 30276
		// ������ ����Ʈ Ÿ�� : image/jpeg
		
		

		
//		// ���ͳݻ��� �̹��� ������ ���� ��ǻ�ͷ� ī���ϼ���.
		// copy3.jpg
		
		InputStream is = ucon.getInputStream();									// �б�
		BufferedInputStream bis = new BufferedInputStream(is);				// ���� ����
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy3.jpg"));// �������( FileOutputStream("copy3.jpg")�� ������� ���Ͼ��ⰴü ���� ) ����
		
		int input = 0, count = 0;			// ��������Ʈ, ����������
		byte[] data = new byte[1024];	// ���� ����
		while((input=bis.read(data))!=-1){
			bos.write(data, 0, input); // ���۾���
			bos.flush();					// ���ۺ���
			count += input;				// ���羲�ⷮ
		}

		System.out.println("ī�ǿϷ�");
		bis.close();
		bos.close();
		is.close();
		//		int input ; // ���� ���� ���� �Ҵ�
//		FileOutputStream fos = new FileOutputStream("UrlConnection.jpg");
//		while((input=is.read())!=-1){
//			fos.write(input);// ��µǴ� �����ʹ� ������ StringBuffer�� ����
//			fos.flush();
//		}
//		fos.close();
		
		
	}

}
