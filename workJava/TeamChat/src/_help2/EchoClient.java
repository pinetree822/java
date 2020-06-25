package _help2;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import javax.swing.*;

public class EchoClient {

	public static void main(String[] args) 
	throws IOException
	{
		//Socket생성=> ip주소, port번호 필요
		String ip=JOptionPane.showInputDialog(
				"서버의 아이피 주소를 입력하세요");
		int port=6666;
		//1)Socket생성
		Socket sock=new Socket(ip,port);
		out.println("##서버와 접속됨###");
		
		//2) 서버에 접속하면 서버가 먼저 인사말을 건낸다.
		//=>클은 인사말을 듣고 콘솔에 출력하자
		InputStream is=sock.getInputStream();
		BufferedReader br
		=new BufferedReader(new InputStreamReader(is));
		String serverMsg=br.readLine();
		out.println("From Server>>"+serverMsg);
		//서버에 메시지를 보내기 위해
		//  키보드 입력 스트림과
		//  서버에 출력하는 스트림이 필요
		//3) 키보드 입력 스트림 생성 (System.in)
		BufferedReader key
		=new BufferedReader(new InputStreamReader(System.in));
		
		//4) 서버에 메시지를 보낼 출력스트림
		PrintWriter pw
		=new PrintWriter(sock.getOutputStream(), true);
		
		String clientMsg="";
		
		while((clientMsg=key.readLine())!=null){//키보드 입력
			pw.println(clientMsg);//5)서버에 메시지를 전송
			//6)서버에서 보내오는 메시지를 듣는다.
			serverMsg=br.readLine();
			out.println("From Server>>"+serverMsg);
		}
		
		key.close();
		pw.close();
		br.close();
		is.close();
		sock.close();
	}

}











