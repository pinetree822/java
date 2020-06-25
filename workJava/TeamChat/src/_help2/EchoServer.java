package _help2;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
/*[구현할 내용]
 *  Client가 Server에 접속하면
 * [1] 서버는 먼저 클에게 "안녕하세요? 클(ip)님~~" 
 *       메시지를 보낸다
 * [2] 그러면 클은 키보드입력을 통해 서버에 응답 메시지를 보낸다.
 * [3] 서버는 클의 메시지를 듣고 메시지를 분석해서
 *      3가지 유형의 답변을 보낸다.
 *      (1) "안녕하세요" 또는 "하이" 란 메시지가 오면
 *      	=> "반가워요~~"
 *      (2) "오늘 날짜는" 이란 메시지가 오면
 *         => 오늘 날짜를 알려준다
 *      (3) 그 외 다른 메시지가 오면
 *         => "~~님 어여 가!!" 란 메시지를 보내자   
 * */

public class EchoServer {

	public static void main(String[] args) 
	throws IOException
	{
		//ServerSocket, Socket
		ServerSocket server=new ServerSocket(6666);
		out.println("EchoServer Ready...");
		Socket sock=server.accept();
		String cip=sock.getInetAddress().getHostAddress();
		out.println(cip+"님이 접속했어요");
		
		//클이 접속하면 먼저 인사말을 건넨다.
		OutputStream os=sock.getOutputStream();
		PrintWriter pout=new PrintWriter(os,true);
		pout.println("안녕하세요? "+cip+"님~~");
		
		//클의 메시지를 듣는 스트림 얻기=>필터링
		InputStream is=sock.getInputStream();
		BufferedReader in
		=new BufferedReader(new InputStreamReader(is));
		
		//반복문 돌면서 클의 메시지를 계속 듣고
		// 그 메시지를 분석하여 메아리를 보낸다.
		String cmsg="";
		while((cmsg=in.readLine())!=null){
			//cmsg를 분석하자.
			int i=cmsg.indexOf("안녕");
			int j=cmsg.indexOf("하이");
			int k=cmsg.indexOf("날짜");
			if(i!=-1 ||j!=-1)
			{
				pout.println("반갑습니다.");
			}else if(k!=-1){
				pout.println(new Date().toString());
			}else{
				pout.println(cip+"님 어여 가~~~");
			}
		}//while---------------
		in.close();
		pout.close();
		is.close();
		os.close();
		sock.close();
		server.close();

	}

}











