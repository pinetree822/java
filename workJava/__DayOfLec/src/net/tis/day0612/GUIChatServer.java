package net.tis.day0612;

import java.net.Socket;
import java.util.Vector;

public class GUIChatServer {

	String[] dd = null;
	public GUIChatServer() {
		Vector user = new Vector();
//		Socket sock = new Socket(9909);/
		ChatHandle ch = new ChatHandle();
		user.add(ch);
	}
	
	
	public static void main(String[] args) {
		GUIChatServer gcs = new GUIChatServer();
	}// main()
	
	
	public void connect() {}
	public void sendMessage() {}
	
}// class GUIChatServer
