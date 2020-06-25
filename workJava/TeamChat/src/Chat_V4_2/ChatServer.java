package Chat_V4_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.*;

public class ChatServer extends JFrame implements ActionListener {
	private static final int SERVER_PORT = 5000;

//	ChatServer server = null;
//	Socket sock = null;
//	PrintWriter pw = null;
//	BufferedReader br = null;

	TextArea txt_list;
	JButton btn_exit;
	ServerSocket ss = null;
	Vector<ChatHandle> user; // 인원수 카운트

	public ChatServer() {
		super("Chatting Server");
		txt_list = new TextArea();
		btn_exit = new JButton("서버종료");

		txt_list.setBackground(Color.YELLOW);
		add(txt_list, "Center");
		add(btn_exit, "South");
		setSize(450, 800);
		setVisible(true);

		// 이벤트처리-----------------------
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		user = new Vector();
		btn_exit.addActionListener(this);
		
		serverStart();
	}

	public void serverStart() {

		try {
			ss = new ServerSocket(SERVER_PORT);
			System.out.println("ServerSocket start ~~~~\n");
			txt_list.append("ServerSocket start ~~~~\n");
			txt_list.setFont(new Font("궁서체", Font.BOLD, 14));
			while (true) {
				Socket sock = ss.accept();// 소켓을 서버에 들어오게함.
				String str = sock.getInetAddress().getHostAddress();
				txt_list.append(str);

				ChatHandle ch = new ChatHandle(this, sock);
				user.addElement(ch);

//				for(int i=0;i<user.size();i++) {
//					ch.broadcast(ch.client.id);
//				}
				ch.start(); // startServer()바로 위에 inwon=new Vector();
			}
		} catch (IOException e) {
		}

	} // end

	public void setMsg(String string) {
		txt_list.append(string);
	} // end

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_exit) {
			
			System.exit(0);
		}
	} // end

	public static void main(String[] args) {
		new ChatServer();
	}

}

class ChatHandle extends Thread {// CHAPTER14 요고시 쓰레드
	ChatServer server = null;
	Socket sock = null;
	PrintWriter pw = null;
	BufferedReader br = null;
	String[] user_id = null;
//	User client = new User();
	String id = "";
	ImageIcon frofile = null;

	public ChatHandle(ChatServer server, Socket sock) {

		this.server = server;
		this.sock = sock;

		try {
			InputStream is = sock.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));

			OutputStream os = sock.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end

	public void run() {
//		super.run();

		try {
			id = br.readLine();

			// TCP::채팅총접속자-10::접속자리스트-1,2,3,4,5,6,7,8,9,1
			server.setMsg(id + " 님 입장\n");
			broadcast(id + " 님 입장");
			broadcast(String.valueOf(server.user.size()));
			for (int i = 0; i < server.user.size(); i++) {
				broadcast(server.user.elementAt(i).id);		
			}

			// printUser_id();
//			for(int i=0;i<server.user.size();i++) {
//				ChatHandle ch = (ChatHandle) server.user.elementAt(i);
//				user_id[i]=ch.client.id;
//			}
//			for(int i=0;i<server.user.size();i++) {
//				broadcast(user_id[i]+" :: ");
//			}
			
//			broadcast(":" + server.user.size());

			// 대화시작-----------------------------------
			while (true) {
				try {
					String text = br.readLine();
					String[] option = text.split(" ");
					if (option[option.length - 1].equals("퇴장")) {
						server.user.remove(this);
					}
					server.setMsg(id + " :>> " + text + "\n");
					broadcast(id + " :>> " + text);
					
				} catch (IOException e) {
				}
			} // while end
				// 대화시작 끝-----------------------------------
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	} // end

	// 모든 접속자에게 메세지를 보내줌
	void broadcast(String string) {
		int s = server.user.size();
		for (int i = 0; i < s; i++) {
			ChatHandle ch = (ChatHandle) server.user.elementAt(i);
			// ch.pw.println(ch.client.id);
			// user_id[i]=ch.client.id;
			//user_id[i] = ch.id;
			ch.pw.println(string);
			// ch.pw.println("접속한 인원 수 : "+ s);
			// ch.pw.write(s);
			ch.pw.flush();
		}
	}

//	public void printUser_id() {
//		for (int i = 0; i < server.user.size(); i++) {
//			ChatHandle ch = (ChatHandle) server.user.elementAt(i);
//			ch.pw.println(ch.client.id + " : ");
//		}
//	}

//	public class User {
//		String id = "";
//		ImageIcon frofile = null;
//	}
}

//class Client{
//	String id="";
//	String ip="";
//	ImageIcon frofile =null;
//}
/*
 * public class User { private String user_ip = ""; private String user_id = "";
 * private ImageIcon user_frofile = null;
 * 
 * public void set_ip(String user_ip) { this.user_ip = user_ip; }
 * 
 * public void set_id(String user_id) { this.user_ip = user_id; }
 * 
 * public void set_frofile(ImageIcon frofile) { this.user_frofile = frofile; } }
 */