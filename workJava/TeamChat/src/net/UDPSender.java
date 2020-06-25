package net;
import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/*
 * �����͸� ������ ��
 * UDP��� : �񿬰� ����. ��ŷ���
 * �����Ͱ� ������� �����Ѵٴ� ������ ����
 * TCP��ĺ��� ������ �����Ѵ�.
 * DatagramPacket, DatagramSocket�� ���
 * 
 * - DatagramSocket : ������ �ۼ��Ű� ���õ� Ŭ����(��ü��)
 * - DatagramPacket : �ְ���� �����Ϳ� ���õ� Ŭ����(����)
 * ������ ���� �����ڿ�
 * �۽��� ���� ������ �ΰ����� ����
 * 
 * TCP�� ��� ��Ʈ���� �̿��� �����͸� �ְ������
 * UDP�� ��� �����ͱ׷��� �̿��� �����͸� �ۼ����Ѵ�.
 * 
 */

public class UDPSender {

	public static void main(String[] args) 
	throws Exception
	{
		String ip = JOptionPane.showInputDialog("IP�ּҸ� �Է��ϼ���.");
		
		if( ip==null || ip.trim().isEmpty() ){
			ip = "localhost";
		}
		InetAddress inet = InetAddress.getByName(ip);
		
		// Ű���� �Է�
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���� ������ �Է��ϼ���.");

		// ����Ʈ������ �ɰ��� ��Ŷ���� ������ �������� ������.
		DatagramSocket ds = new DatagramSocket();// �ۼ��Ŷ� ����..
		
		String sendMsg = "";
		while( (sendMsg=key.readLine())!=null ){
			if(sendMsg.equalsIgnoreCase("x")) break; // ����
			// ���ڿ��� byte�迭�� ����.
			byte[] data = sendMsg.getBytes();
			DatagramPacket pack=new DatagramPacket(data, data.length, inet, 3000);
			ds.send(pack);// sock�� ������.
			System.out.println("���� ������ �Է��ϼ���.");
		}// while ---------
		if( ds!=null ) ds.close();
		
	}

}// UDPSender---------------------------
