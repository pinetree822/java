package net;
import java.io.*;
import java.net.*;
/* URL(Uniform Resource Locator)
 * 
 * - ���ͳݿ� ���� ������ �ڿ�(resource)�� �ּҸ� ǥ���ϴ� ������ ����
		���⼭�� �ڿ��� ���ͳ� ���� �������ݿ� ���� �ٸ��� �ִ�.
		
		���� http ���������� ��� �ڿ��̶� html ������, �̹��� ����,
		���ø� �� ���� ���ϰ� ���丮�� �ǹ��Ѵ�.
		
 * - URL �������
 		http://www.naver.com:80/member/join.jsp?name=hong#content
 		protocol		host		:port/path			?queryString#reference
 		
 		
 */

public class URLTest {

	public static void main(String[] args) {
		try {
			String urlStr = "http://movie.naver.com/movie/bi/mi/basic.nhn?code=38899";
			URL url = new URL(urlStr);
			
			URLConnection ucon = url.openConnection();
			//System.out.println("���ڵ� :" + ucon.getContentEncoding()); // �ּ������� ���ڵ� Ȯ��

			System.out.println("��������    : " + url.getProtocol());
			System.out.println("ȣ �� Ʈ     : " + url.getHost());
			System.out.println("��     Ʈ     : " + url.getDefaultPort());
			System.out.println("Path          : " + url.getPath());
			System.out.println("QueryString : " + url.getQuery());
			System.out.println("Reference    : " + url.getRef());
			
			// �� ���ҽ� ������ �о copy.html�� ��������.
			// �ֿܼ��� �������.
			

			String line = ""; // ���� ���� ���� �Ҵ�
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));// ���� ���ڵ� ������
			PrintWriter pw = new PrintWriter( System.out, true ); // �ܼ����
			//FileWriter  fw = new FileWriter("copy.html");
			OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream("copy.html"), "UTF-8"); // ���� ���ڵ� ������

			while((line = br.readLine())!=null){
				pw.println(line);// �ܼ����
				fw.write(line + "\r\n");// �������
				fw.flush();
			}
			
			br.close(); 	// System.in�� ���� ǥ��������� ���� �ʾƵ� �ȴ�.
			is.close();	// ��Ʈ������ �ݱ�
			pw.close();	// ��Ʈ������ �ݱ�
			fw.close();
			System.out.println("���α׷��� �����մϴ�.");

			//System.out.println(is.);
			

		} catch (MalformedURLException e) {// �ּҰ� ���Ŀ� ��߳��� �߻�
			e.printStackTrace();
			
		} catch (IOException e) {// InputStream
			e.printStackTrace();
			
		}
		
	}//public static void main(String[] args)

}//public class URLTest
/*
 * 

	��������    : http
	ȣ �� Ʈ     : movie.naver.com
	��     Ʈ      : 80
	Path          : /movie/bi/mi/basic.nhn
	QueryString : code=38899
	Reference    : aaa

 * 
 */
