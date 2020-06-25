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
				"클라이언트\n"
				+ xSocket
				+ " \n에서 접속하였습니다."
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
				xServer.broadcast( "# " + szUserName + " 님이  들어오셨습니다");
			} else {
				sendMessage("지원하지 않는 터미널입니다.");
				szUserName = "몰라요";
				nState = 3;
			}

			while ((inputLine = streamIn.readLine()) != null) {
				if(inputLine.equals("/h")){
					sendMessage(
						"#도움말\n"
						+ "/h : 도움말\n"
						+ "/u : 전체 사용자\n"
						+ "/k [사용자이름] : 사용자 이름 바꾸기\n"
						+ "/x : 퇴장 (연결해제) \n"
					);
				} else if(inputLine.equals("/u")){
					xServer.sendUserList(ChatThread.this);
				} else if(inputLine.regionMatches(0, "/k", 0, 2)){
					String new_name = inputLine.substring(2).trim();
					xServer.broadcast(
						"# 사용자 "
						+ szUserName +
						" 님의 이름이 [" 
						+ new_name 
						+ "](으)로 바뀌었습니다."
					);
					
					szUserName = new_name;
				} else if(inputLine.equals("//disconnect")){
				        xServer.broadcast( "# " + szUserName + " 님이 퇴장하셨습니다.");
				        
				        xServer.removeClient(this);
				        System.out.println(
				                "클라이언트\n"
				                + xSocket
				                + " \n의 접속이 끊겼습니다."
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
				"클라이언트\n"
				+ xSocket
				+ " \n의 접속이 끊겼습니다."
			);
		}
	}
}