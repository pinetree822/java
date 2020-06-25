package _javaChat4;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

public class Net_socket_ChatServer {
	Vector vClients;
	
	public Net_socket_ChatServer(){
		vClients = new Vector();
	}
	
	public void addClient(ChatThread thd){
		vClients.addElement(thd);
	}
	
	public void removeClient(ChatThread thd){
		vClients.removeElement(thd);
	}

	public void sendUserList(ChatThread client) throws IOException{
		if (client.nState < 3) return;
		
		client.sendMessage("#����� ����Ʈ");
		for(int i=0; i<vClients.size(); i++){
			ChatThread thd = ((ChatThread)vClients.elementAt(i));
			client.sendMessage(thd.szUserName);
		}
	}
	
	public void broadcast(String msg) throws IOException{
		for(int i=0; i<vClients.size(); i++){
			ChatThread thd = ((ChatThread)vClients.elementAt(i));
			
			if (thd.nState >= 3) thd.sendMessage(msg);		
		}
	}

	public static void main(String[] args) {
		Net_socket_ChatServer server;
		ServerSocket serverSocket = null;
		int port = 4444;
		boolean listening = true;
        
        	server = new Net_socket_ChatServer();
        	
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("���� �����Դϴ�.");
            		System.exit(-1);
		}
		
		System.out.println(
			"���� \n" + serverSocket
			+ "\n���� ������ ��ٸ��ϴ�."
		);

		try {
			while (listening) {
				ChatThread thread;
				
				thread = new ChatThread(server, serverSocket.accept());
				thread.start();
		
				server.addClient(thread);
			}

			serverSocket.close();
		} catch (IOException e){}
		
		System.out.println("������ �����մϴ�.");
	}
}
