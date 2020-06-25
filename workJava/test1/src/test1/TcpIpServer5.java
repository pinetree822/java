package test1;
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class TcpIpServer5 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			// 서버소켓을 생성하여 7777번 포트와 결합(bind)한다.
			serverSocket = new ServerSocket(7777);
			
			socket = serverSocket.accept();// 통신리스너 생성
			
			Sender sender = new Sender(socket);		//  
			Receiver receiver = new Receiver(socket);// 
			
			sender.start();
			receiver.start();
			
		} catch(Exception e){
			
		}// try -----------
	}// main-----
	
}// class ------------



class Sender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;
	
	Sender(Socket socket){
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			name = this.getClass()+ ":" + this.getName() + "[" + socket.getInetAddress() + " : " +	socket.getPort() +	"]";
		} catch(Exception e) {}
	}// Sender----------
	
	public void run(){
		Scanner scanner = new Scanner(System.in);
		while(out!=null){
			try {
				out.writeUTF(name + scanner.nextLine());
			} catch (IOException e){}
		}
	}// run -------------
}// class ------------



class Receiver extends Thread {
	Socket socket;
	DataInputStream in;
	
	Receiver(Socket socket){
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch(Exception e) {}
		
	}// Receiver-------
	
	public void run(){
		while(in!=null){
			try{
				System.out.println(in.readUTF());
			} catch(IOException e){}
		}// while ---------
	}// run ------------
}// class ------------


