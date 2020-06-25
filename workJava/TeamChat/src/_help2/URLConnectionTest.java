package _help2;
import java.net.*;
import java.io.*;
/* URLConnectionŬ����
 * - �߻�Ŭ����
 * - URL��ü�� ���ؼ� ��´�.
 * - URLŬ�����δ� ���ݼ��� �ڿ��� ����� ��������
 *   URLConnection�� ����ϸ� ���ݼ����� ��� ������ �ڿ���
 *   ���� ������ ���� �� �ִ�.
 * */

public class URLConnectionTest {

	public static void main(String[] args) 
			throws IOException {
		String str
		="https://www.google.com/intl/ko_kr/insidesearch/images/features/searchbyimg-step1.jpg";
		URL url=new URL(str);
		URLConnection ucon=url.openConnection();
		ucon.connect();//����
		
		int fsize=ucon.getContentLength();
		System.out.println("������ ũ��: "+fsize);
		String contentType=ucon.getContentType();
		System.out.println("������ ����Ʈ Ÿ��: "+contentType);
		
		InputStream is=ucon.getInputStream();
		//���ͳݻ��� �̹��� ������ ���� ��ǻ�ͷ� ī���ϼ���
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
		System.out.println(count+"����Ʈ ī�� �Ϸ�!");
		
		

	}

}









