package net;
import java.net.*;
import java.io.*;


public class UDPReceiver {

	public static void main(String[] args) 
	throws Exception
	{
		// �����͸� �ޱ� ���� byte�迭�� �����Ѵ�.
		// UDP�� ���� �����ʹ� 512����Ʈ�� �����ϴ� ��찡 ����.
		
		byte[] buf = new byte[100];
		
		DatagramSocket ds = new DatagramSocket(3000);
		DatagramPacket pack = new DatagramPacket(buf, buf.length);
		
		while(true){
			
			ds.receive(pack);
			byte[] bmsg = pack.getData();
			String msg = new String(bmsg, 0 , pack.getLength());
			System.out.println( pack.getAddress() + "�� ���� >> [" + pack.getPort() +" �� ��Ʈ���� �� �޽��� : " + msg);
		}
		
	}

}// UDPReceiver------------------------
