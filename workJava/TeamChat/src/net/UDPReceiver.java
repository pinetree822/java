package net;
import java.net.*;
import java.io.*;


public class UDPReceiver {

	public static void main(String[] args) 
	throws Exception
	{
		// 데이터를 받기 위해 byte배열을 생성한다.
		// UDP의 실제 데이터는 512바이트로 제한하는 경우가 많다.
		
		byte[] buf = new byte[100];
		
		DatagramSocket ds = new DatagramSocket(3000);
		DatagramPacket pack = new DatagramPacket(buf, buf.length);
		
		while(true){
			
			ds.receive(pack);
			byte[] bmsg = pack.getData();
			String msg = new String(bmsg, 0 , pack.getLength());
			System.out.println( pack.getAddress() + "로 부터 >> [" + pack.getPort() +" 번 포트에서 온 메시지 : " + msg);
		}
		
	}

}// UDPReceiver------------------------
