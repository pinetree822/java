package Chat_V2;

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



public class ChatServer extends JFrame implements ActionListener{
	private static final int SERVER_PORT = 5000;

//	ChatServer server = null;
//	Socket sock = null;
//	PrintWriter pw = null;
//	BufferedReader br = null;
	
	
	TextArea txt_list;
	JButton btn_exit;
	ServerSocket ss = null;
	Vector user; // �ο��� ī��Ʈ
	
	public ChatServer() {
		super("Chatting Server");
		txt_list = new TextArea();
		btn_exit = new JButton("��������");
		
		txt_list.setBackground(Color.YELLOW);
		add(txt_list, "Center");
		add(btn_exit, "South");
		setSize(450, 800);
		setVisible(true);

		// �̺�Ʈó��-----------------------
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btn_exit.addActionListener(this);
		user = new Vector();
		serverStart();
	}
	public void serverStart() {

		try {
			ss = new ServerSocket(SERVER_PORT);
			System.out.println("ServerSocket start ~~~~\n");
			txt_list.append("ServerSocket start ~~~~\n");
			txt_list.setFont(new Font("�ü�ü", Font.BOLD, 14));
			while (true) {
				Socket sock = ss.accept();// ������ ������ ��������.
				String str = sock.getInetAddress().getHostAddress();
				txt_list.append(str);

				ChatHandle ch = new ChatHandle(this, sock);
				user.addElement(ch);
				ch.start(); // startServer()�ٷ� ���� inwon=new Vector();
			}
		} catch (IOException e) {
		}
		
	} // end
	public void setMsg(String string) {
		txt_list.append(string);
	} // end

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_exit)
			System.exit(0);
	} // end
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatServer();
	}



}
class ChatHandle extends Thread {// CHAPTER14 ���� ������
	ChatServer server = null;
	Socket sock = null;
	PrintWriter pw = null;
	BufferedReader br = null;

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
		super.run();
//		String nickname = null;
		Boolean welcome = false;
		String tmp=null, text="", nickname="";
		


//			try {
//				nickname = br.readLine();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}// try
//			server.setMsg( nickname+" �� ����\n");			
//			broadcast(nickname+" �� ����");///////////////
//			

			// ��ȭ����-----------------------------------
//			while (true) {
			try {
				while ((tmp=br.readLine())!=null) {
						//if((tmp=br.readLine())!=null) break;
						if(!welcome) {
							nickname = tmp;
							text = tmp + " �� ����\n";
							welcome=!welcome;
						} else {
							text = tmp + "\n";
						}
						server.setMsg( text );
						broadcast( text );
						tmp=null;
				}
			} catch (Exception e) {
				e.printStackTrace();				
			} finally {
				try {
					sock.close();
					pw.close();
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}// while end
			// ��ȭ���� ��-----------------------------------
			

		
		
//		try {
//			nickname = br.readLine();
//			server.setMsg( nickname+" �� ����\n");			
//			broadcast(nickname+" �� ����");///////////////
//			
//			// ��ȭ����-----------------------------------
//			while (true) {
//				try {
//					String text = br.readLine();
//					server.setMsg(nickname + " :>> " + text + "\n");
//					broadcast(nickname + " :>> " + text);//////////////
//				} catch (IOException e) {
//				}
//			} // while end
//			// ��ȭ���� ��-----------------------------------
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//		}
	} // end

	// ��� �����ڿ��� �޼����� ������
	private void broadcast(String string) {
		int s = server.user.size();
		for (int i = 0; i < s; i++) {
			ChatHandle ch = (ChatHandle) server.user.elementAt(i);
			string = "������ �ο� : " + s + string;
			ch.pw.println(string);
			//ch.pw.println("������ �ο� �� : "+ s);
			//ch.pw.write(s);
			ch.pw.flush();
		}
	} 
}
//class Client{
//	String id="";
//	String ip="";
//	ImageIcon frofile =null;
//}
/*
public class User {
	private String user_ip = "";
	private String user_id = "";
	private ImageIcon user_frofile = null;

	public void set_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public void set_id(String user_id) {
		this.user_ip = user_id;
	}

	public void set_frofile(ImageIcon frofile) {
		this.user_frofile = frofile;
	}
}*/