package _help2;
import java.net.*;
import java.io.*;
/*URL(Uniform Resource Locator)
 * - ���ͳݿ� ���� ������ �ڿ�(resource)�� �ּҸ� ǥ���ϴ� ������ ����
 *   ���⼭ �ڿ��� ���ͳ� ���� �������ݿ� ���� �ٸ� �� �ִ�.
 *   ���� http���������� ��� �ڿ��̶� html������, �̹��� ����,
 *   ���ø� �� ���� ���ϰ� ���丮�� �ǹ��Ѵ�.
 * - URL���� ���
 *   http://www.naver.com:80/member/join.jsp?name=hong#content
 *   protocol      host   :port/path         ?queryString#reference
 * */
public class URLTest {

	public static void main(String[] args) {
		String urlStr
		="http://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=103&oid=056&aid=0010377444";
		try {
			URL url=new URL(urlStr);
			
			System.out.println("��������: "+url.getProtocol());
			System.out.println("ȣ �� Ʈ: "+url.getHost());
			System.out.println("��Ʈ��ȣ: "+url.getDefaultPort());
			System.out.println("Path    : "+url.getPath());
			System.out.println("QueryString: "+url.getQuery());
			System.out.println("Reference: "+url.getRef());
			
			//�� ���ҽ� ������ �о  copy.html���Ϸ� �����ϰ�
			//�ֿܼ��� �������.
			InputStream is=url.openStream();
			//BufferedReader�� ���͸��ؼ� �ٴ����� �а� 
			//�ֿܼ� ����غ�����
			BufferedReader br
			=new BufferedReader(new InputStreamReader(is,"UTF-8"));
			PrintWriter pw=new PrintWriter(System.out,true);
			//FileWriter fw=new FileWriter("copy.html");
	OutputStreamWriter fw
	=new OutputStreamWriter(new FileOutputStream("copy.html"),"UTF-8");
			
			String line="";
			while((line=br.readLine())!=null){
				pw.println(line);
				fw.write(line+"\r\n");
				fw.flush();
			}
			br.close();
			is.close();
			pw.close();
			fw.close();
			
			
		} catch (MalformedURLException e) {		
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}












