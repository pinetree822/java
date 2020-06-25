package net;
import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/*
 * 클라이언트 단
 * 
	- Socket만 필요
	- 서버가 보내오는 숫자를 받자
	
 */


public class TCPClient {

	public static void main(String[] args) 
	throws IOException {
		
		// 클라이언트 소켓에서는 서버의 IP주소와 Port번호가 필요하다.
		// 서버와 연결되면 Socket이 생성되고
		// 연결이 안되면 예외가 발생됨
		//String ips;
		//if( args.length > 1 )

		//Socket sock = new Socket("192.168.10.150",5555); 
		//Socket sock = new Socket("192.168.10.98",5555); //23
		Socket sock = new Socket("192.168.10.98",5555); 
		
		// 서버가 보낸 데이터를 듣기 위해 스트림 연결
		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		int num = dis.readInt();
		
		JOptionPane.showMessageDialog(null, "서버가 보내온 행운의 숫자" + num);
		
		
//		// 서버에게 클이 메시지를 보내자
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("메시지를 입력하세요.");
		String str = sc.nextLine();
		
		// 출력 스트림 얻기 => 
		
		//String str="잘받았어요~~192.168.0.98~~^.^";		
		// 출력 스트림 얻기 => sock 통해서
		// 필터링
		// writeUTF(str) flush
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF(str);
		dos.flush();		

		dos.close();
		dis.close();
		is.close();
		sock.close();

	}

}
