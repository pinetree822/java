package net;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import javax.swing.*;



/*
 * [구현할 내용]
		Client가 Server에게 접속하면
		
		[1] 서버는 먼저 클에게 "안녕하세요? 클(ip)님~~ "
			메시지를 보낸다.
			
		[2] 클라이언트는 키보드입력을 통해 서버에 응답 메시지를 보낸다.
		
		[3] 서버는 클의 메시지를 듣고 메시지를 분석해서
			3가지 유형의 답변을 보낸다. (메아리)
			(1) "안녕하세요." 또는 "하이" 란 메시지가 오면
				=> "반가워요~~"
			(2) "오늘 날짜는" 이란 메시지가 오면
				=> 오늘 날짜를 알려준다.
			(3) 그 외 다른 메시지가 오면
				=> "~~님 어여 가!!" 란 메시지를 보내자
				
 * 
 */

public class EchoClient {

	public static void main(String[] args) 
	throws IOException
	{// Socket생성 => ip주소, port번호, 필요
		
		String ip = JOptionPane.showInputDialog("서버의 아이피주소를 입력하세요.");
		int port = 6666;
		
		// 1) 소켓생성
		Socket sock = new Socket(ip, port);					// 소켓생성
		out.println("## " + ip + " 서버와 접속되었습니다. ##");
		
		// 2) 서버에 접속하면 서버가 먼저 인사말을 건낸다.
		// => 클은 인사말을 듣고 콘솔에 출력한다.
		InputStream is = sock.getInputStream();				// 소켓을 연결시킨 InputStream
		BufferedReader br = new BufferedReader( new InputStreamReader(is) );
		
		String serverMsg = br.readLine();
		out.println("From Server >> " + serverMsg);
		
		//3) 서버에 메시지를 보내기 위해
		// 키보드 입력 스트림과 
		// 서버에 출력하는 스트림이 필요
		//
		// 3) 키보드 입력 스트림 생성( System.in )
		
		BufferedReader key = new BufferedReader( new InputStreamReader(System.in) );
		
		//4) 서버에 메시지를 보낼 출력스트림
		PrintWriter pw = new PrintWriter( sock.getOutputStream(), true );
		
		String clientMsg = "";
		
		while( (clientMsg=key.readLine())!=null ) // 키보드 입력
		{
			pw.println(clientMsg); // 5) 서버에 메시지를 전송
			// 6) 서버에서 보내오는 메시지를 듣는다.
			serverMsg = br.readLine();
			out.println("From Server >>" + serverMsg);
		}
		
		key.close();
		pw.close();
		br.close();
		is.close();
		sock.close();
	}

}
