package _help2;
import java.net.*;
import java.io.*;
/*URL(Uniform Resource Locator)
 * - 인터넷에 접근 가능한 자원(resource)의 주소를 표현하는 형식을 말함
 *   여기서 자원은 인터넷 응용 프로토콜에 따라 다를 수 있다.
 *   가령 http프로토콜의 경우 자원이란 html페이지, 이미지 파일,
 *   애플릿 등 각종 파일과 디렉토리를 의미한다.
 * - URL구성 요소
 *   http://www.naver.com:80/member/join.jsp?name=hong#content
 *   protocol      host   :port/path         ?queryString#reference
 * */
public class URLTest {

	public static void main(String[] args) {
		String urlStr
		="http://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=103&oid=056&aid=0010377444";
		try {
			URL url=new URL(urlStr);
			
			System.out.println("프로토콜: "+url.getProtocol());
			System.out.println("호 스 트: "+url.getHost());
			System.out.println("포트번호: "+url.getDefaultPort());
			System.out.println("Path    : "+url.getPath());
			System.out.println("QueryString: "+url.getQuery());
			System.out.println("Reference: "+url.getRef());
			
			//위 리소스 파일을 읽어서  copy.html파일로 저장하고
			//콘솔에도 출력하자.
			InputStream is=url.openStream();
			//BufferedReader로 필터링해서 줄단위로 읽고 
			//콘솔에 출력해보세요
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












