package net;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.plaf.synth.SynthSeparatorUI;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;


public class FTPServer extends Thread {

	private ServerSocket server;
	private Socket sock;
	private String upDir = "E:/Uplaod";	// ���� ����Ÿ ������ ��
	private ObjectInputStream ois; 					// �پ��� ��ü�� �ޱ����� �ʿ��ϴ�. //
	private FileOutputStream fos;						// ������ �ޱ� ���� �ʿ��ϴ�. (1byte ��Ʈ�� - �پ��� �����϶� ��ȿ�ϴ�.)
	
	public  FTPServer(){
		try {
			server = new ServerSocket(7788);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// run()-------------------
	
	public void run(){
		out.println("FTPServer Started...");
		try {
			while(true){
				sock = server.accept();
				out.println(sock.getInetAddress() + "�� �����ؿ�");
				
				ois = new ObjectInputStream( sock.getInputStream() );
				String fileName = ois.readUTF();			// ������ ���ϸ�
				String path = upDir + "/" + fileName;
				out.println(path);
				fos = new FileOutputStream(path);	
				
				// ������ Ŭ���̾�Ʈ���� ���� ������ ����.
				int input=0, count=0;
				byte[] data = new byte[1024];
				while( (input=ois.read(data))!= -1 ){
					fos.write(data, 0, input);
					fos.flush();
					count += input;
					System.out.println(count + " ���� ���ε���");
				}// while ------------------

				System.out.println(count + " ���� ���ε� �Ϸ�");
				if( fos!=null ) fos.close();
				if( ois!=null ) ois.close();
				if( sock!=null ) sock.close();
				
				// 
				// Ŭ�� �����ϸ� Ŭ�� ���ϸ��� �����ش�.
				// ������ �� ���ϸ��� �޾� �ش� ������ 
				// ���ε��� ���丮�� �����θ� �����
				// ��������.
				
			}// while-------
			
		} catch (Exception e) {
			e.printStackTrace();
		}// try------------------
		
	}// run()-------------------
	
	
	
	
	
	
	
	public static void main(String[] args) {
		FTPServer fserver = new FTPServer();
		fserver.start();
		
	}// main -----------------------

}
