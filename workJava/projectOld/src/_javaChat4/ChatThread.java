package _javaChat4;

import java.net.*;
import java.io.*;
import java.util.*;

class ChatThread extends Thread {
	private Net_socket_ChatServer xServer;
	private Socket xSocket;
	
	int nState;
	String szUserName;
	
	PrintWriter streamOut;
	BufferedReader streamIn;
	
	public ChatThread(Net_socket_ChatServer server, Socket socket) {
		super("Echo Service Thread");
		
		xServer = server;
		xSocket = socket;
		
		nState = 0;
		
		streamOut = null;
		streamIn = null;
	}
	
	public void sendMessage(String msg) throws IOException{
		if (streamOut != null){
			streamOut.println(msg);
		}
	}
	
	public void run() {
		try {
			System.out.println(
				"Ŭ���̾�Ʈ\n"
				+ xSocket
				+ " \n���� �����Ͽ����ϴ�."
			);

			streamOut = new PrintWriter(xSocket.getOutputStream(), true);
			streamIn = new BufferedReader(
				new InputStreamReader(
					xSocket.getInputStream()
				)
			);

			String inputLine, outputLine;
			
			nState = 1;
			streamOut.println("Terminal");

			if ("JChat_01".equals(streamIn.readLine())){
				nState = 2;
			
				streamOut.println("UserName:");
				szUserName = streamIn.readLine();
				nState = 3;
			
				sendMessage(szUserName);
				xServer.broadcast( "# " + szUserName + " ����  �����̽��ϴ�");
			} else {
				sendMessage("�������� �ʴ� �͹̳��Դϴ�.");
				szUserName = "�����";
				nState = 3;
			}

			while ((inputLine = streamIn.readLine()) != null) {
				if(inputLine.equals("/h")){
					sendMessage(
						"#����\n"
						+ "/h : ����\n"
						+ "/u : ��ü �����\n"
						+ "/k [������̸�] : ����� �̸� �ٲٱ�\n"
						+ "/x : ���� (��������) \n"
					);
				} else if(inputLine.equals("/u")){
					xServer.sendUserList(ChatThread.this);
				} else if(inputLine.regionMatches(0, "/k", 0, 2)){
					String new_name = inputLine.substring(2).trim();
					xServer.broadcast(
						"# ����� "
						+ szUserName +
						" ���� �̸��� [" 
						+ new_name 
						+ "](��)�� �ٲ�����ϴ�."
					);
					
					szUserName = new_name;
				} else if(inputLine.equals("//disconnect")){
				        xServer.broadcast( "# " + szUserName + " ���� �����ϼ̽��ϴ�.");
				        
				        xServer.removeClient(this);
				        System.out.println(
				                "Ŭ���̾�Ʈ\n"
				                + xSocket
				                + " \n�� ������ ������ϴ�."
				        );
				} else {
					xServer.broadcast("["+ szUserName + "] " + inputLine);
				}
			}
			
			streamOut.close();
			streamIn.close();
			xSocket.close();
		} catch (IOException e) {
			xServer.removeClient(this);
			
			System.out.println(
				"Ŭ���̾�Ʈ\n"
				+ xSocket
				+ " \n�� ������ ������ϴ�."
			);
		}
	}
}