package net;
import java.net.*;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import static java.lang.System.out;
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


public class EchoServer {

	public static void main(String[] args) 
	throws IOException
	{
		//String ip = JOptionPane.showInputDialog("서버의 아이피주소를 입력하세요.");
		//int port = 6666;
		
		// ServerSocket , Socket
		ServerSocket server = new ServerSocket(6666); // serverSock
		out.println("EchoServer Ready...");
		
		Socket sock = server.accept();
		String cip = sock.getInetAddress().getHostAddress();
		out.println( cip + "님이 접속했어요." );
		// 클이 접속하면 먼저 인사말을 보낸다.
		
		OutputStream os = sock.getOutputStream();
		PrintWriter pout = new PrintWriter(os, true);
		pout.println("안녕하세요?" + cip + "님~");
		
		// 클의 메시지를 듣는 스트림 얻기 => 필터링
		
		// 반복문 돌면서 클의 메시지를 계속 듣고
		// 그 메시지를 분석하여 메아리를 듣는다.
		
		InputStream is = sock.getInputStream();
		BufferedReader bs = new BufferedReader(new InputStreamReader(is));
		String clientMsg = "";
		String serverMsg = "";
		int sumMsg = 0;
		
		while( (clientMsg = bs.readLine())!=null  ){
			out.println("클라이언트 보낸 정보 >> " + clientMsg);
			if( (clientMsg.indexOf("안녕")>-1) || ( clientMsg.indexOf("하이")>-1) || (clientMsg.indexOf("방가")>-1) ) {
				serverMsg += "반가워요~~" + cip + "님~";
				sumMsg++;
			} 
			if( clientMsg.indexOf("날짜") > -1 ) {
				serverMsg += "오늘의 날짜는 " + new Date().toString();		
				//serverMsg += "오늘의 날짜는 " + new Date().toLocaleString();		
				sumMsg++;	
			}
			if( sumMsg < 1 ) {
				serverMsg += "" + cip + "님~ 어여 가!!";
			}
			out.println(serverMsg);
			pout.println( serverMsg );
			sumMsg = 0;
			serverMsg = "";
		}// while------

		bs.close();
		is.close();
		pout.close();
		os.close();
		sock.close();
		server.close();
		
		
	}

}
