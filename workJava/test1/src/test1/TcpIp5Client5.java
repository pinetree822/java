package test1;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIp5Client5 {

	public static void main(String[] args) {
		
		String serverIp = "127.0.0.1";
		Socket socket;
		try {
			socket = new Socket(serverIp, 7777);// ������ �����Ͽ� ������ ��û�Ѵ�.
			System.out.println("������ �����Ͽ����ϴ�.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (ConnectException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}// main-----------------
}// class TcpIp5Client5 ----------


/*
 * 
	������ �����Ͽ����ϴ�.
	dkssud
	class Sender:Thread-0[/127.0.0.1 : 62528]yes?
	hi?
	class Sender:Thread-0[/127.0.0.1 : 62528]yes

*/