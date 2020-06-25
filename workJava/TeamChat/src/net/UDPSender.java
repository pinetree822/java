package net;
import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/*
 * 데이터를 보내는 측
 * UDP방식 : 비연결 지향. 비신뢰적
 * 데이터가 순서대로 도착한다는 보장을 못함
 * TCP방식보다 빠르게 전달한다.
 * DatagramPacket, DatagramSocket을 사용
 * 
 * - DatagramSocket : 데이터 송수신과 관련된 클래스(우체부)
 * - DatagramPacket : 주고받을 데이터와 관련된 클래스(소포)
 * 수신을 위한 생성자와
 * 송신을 위한 생성자 두가지를 제공
 * 
 * TCP의 경우 스트림을 이용해 데이터를 주고받지만
 * UDP의 경우 데이터그램을 이용해 데이터를 송수신한다.
 * 
 */

public class UDPSender {

	public static void main(String[] args) 
	throws Exception
	{
		String ip = JOptionPane.showInputDialog("IP주소를 입력하세요.");
		
		if( ip==null || ip.trim().isEmpty() ){
			ip = "localhost";
		}
		InetAddress inet = InetAddress.getByName(ip);
		
		// 키보드 입력
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("보낼 내용을 입력하세요.");

		// 바이트단위로 쪼개서 패킷으로 보내고 소켓으로 보낸다.
		DatagramSocket ds = new DatagramSocket();// 송수신때 쓰는..
		
		String sendMsg = "";
		while( (sendMsg=key.readLine())!=null ){
			if(sendMsg.equalsIgnoreCase("x")) break; // 종료
			// 문자열을 byte배열에 담자.
			byte[] data = sendMsg.getBytes();
			DatagramPacket pack=new DatagramPacket(data, data.length, inet, 3000);
			ds.send(pack);// sock에 보낸다.
			System.out.println("보낼 내용을 입력하세요.");
		}// while ---------
		if( ds!=null ) ds.close();
		
	}

}// UDPSender---------------------------
