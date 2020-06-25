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
	private String upDir = "E:/Uplaod";	// 보낼 데이타 저장할 곳
	private ObjectInputStream ois; 					// 다양한 객체를 받기위해 필요하다. //
	private FileOutputStream fos;						// 파일을 받기 위해 필요하다. (1byte 스트림 - 다양한 파일일때 유효하다.)
	
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
				out.println(sock.getInetAddress() + "가 접속해옴");
				
				ois = new ObjectInputStream( sock.getInputStream() );
				String fileName = ois.readUTF();			// 서버가 파일명
				String path = upDir + "/" + fileName;
				out.println(path);
				fos = new FileOutputStream(path);	
				
				// 서버가 클라이언트에서 보낸 파일을 받자.
				int input=0, count=0;
				byte[] data = new byte[1024];
				while( (input=ois.read(data))!= -1 ){
					fos.write(data, 0, input);
					fos.flush();
					count += input;
					System.out.println(count + " 파일 업로드중");
				}// while ------------------

				System.out.println(count + " 파일 업로드 완료");
				if( fos!=null ) fos.close();
				if( ois!=null ) ois.close();
				if( sock!=null ) sock.close();
				
				// 
				// 클이 접속하면 클이 파일명을 보내준다.
				// 서버가 이 파일명을 받아 해당 파일을 
				// 업로드할 디렉토리와 절대경로를 만들어
				// 내보낸다.
				
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
