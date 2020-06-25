package _help2;
import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/*클라이언트 단
 * - Socket만 필요
 * - 서버가 보내오는 숫자를 받자*/
public class TCPClient {
	
	public static void main(String[] args) 
	throws IOException
	{
		Socket sock=new Socket("192.168.10.150",5555);
		//클라이언트 소켓에서는 서버의 IP주소와 port번호가 필요
		//하다.
		//서버와 연결되면 Socket이 생성되고,
		//연결이 안돼면 예외가 발생됨
		System.out.println("서버와 연결됨...");
		
		//서버가 보낸 데이터를 듣기 위해 스트림 연결
		InputStream is=sock.getInputStream();
		DataInputStream dis
		=new DataInputStream(is);
		int num=dis.readInt();
		JOptionPane.showMessageDialog(null,
				"서버가 보내온 행운의 숫자:"+num);
		
		//서버에게 클이 메시지를 보내자
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("메시지를 입력하세요=>");
		String str=sc.nextLine();
		
		//출력 스트림 얻기=>sock통해서
		OutputStream os=sock.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
		dos.writeUTF(str);
		dos.flush();

		dos.close();
		dis.close();
		is.close();
		os.close();
		sock.close();
	}

}






