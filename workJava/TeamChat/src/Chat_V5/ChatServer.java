package Chat_V5;


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
	Vector<ChatHandle> user; // �ο��� ī��Ʈ

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
				txt_list.append(str+"\n");

				ChatHandle ch = new ChatHandle(this, sock);
				user.addElement(ch);// ����� �ڵ� �߰�

//				for(int i=0;i<user.size();i++) {
//					ch.broadcast(ch.client.id);
//				}
				ch.start(); // startServer()�ٷ� ���� inwon=new Vector();
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
			user.remove(this);
		}
			
	} // end

	public static void main(String[] args) {
		new ChatServer();
	}

}

class ChatHandle extends Thread {// CHAPTER14 ���� ������
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

	
	
	
	



	// TCP:::stateChat:::targetPerson:::idList:::chatContext
	// TCP:::(����:����/����/��ȭ��)0,1,2:::(���:��ü,�ӼӸ�id)"",id:::(����Ʈ:ä��������)id1,id2,:::��ȭ������
	// TCP:::���̵�:::id1,id2,id3,:::��ȭ����

	// tcpState:::stateChat:::targetPerson:::idList:::chatContext
	// int stateChat=0;
	// targetPerson="";
	// idList={};
	// String tcpState = "TCP:::";
	
//	broadcast(String.valueOf(server.user.size()));
//	for (int i = 0; i < server.user.size(); i++) {
//		broadcast(server.user.elementAt(i).id);
//		// ������������ �׽�Ʈ
//		//System.out.println("user = " + server.user.elementAt(i).id);
//	}

	
	// printUser_id();
//	for(int i=0;i<server.user.size();i++) {
//		ChatHandle ch = (ChatHandle) server.user.elementAt(i);
//		user_id[i]=ch.client.id;
//	}
//	for(int i=0;i<server.user.size();i++) {
//		broadcast(user_id[i]+" :: ");
//	}
	
//	broadcast(":" + server.user.size());


	// TCP:::���̵�:::id1,id2,id3,:::��ȭ����
	// tcpState:::stateChat:::targetPerson:::idList:::chatContext
	// int stateChat=0;
	// targetPerson="";
	// idList={};

	// TCP:::stateChat:::id:::whisperId:::idList:::chatContext
	// TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::(����Ʈ:ä��������)id1,id2,:::��ȭ������
//	String tcpState = "TCP:::" +"1" +":::" +id +":::" +" " +":::" +"id1,id2," +":::" +" " ;
//	server.setMsg(id + " �� ����\n");
//	broadcast(id + " �� ����");
	
	
	
	
	//////////////////////////////////////////////////////
	// Ŭ���̾�Ʈ���� ��ū�� �ӼӸ��� �ʺ����� ��� ���
	// Ŭ���̾�Ʈ���� ����� server.user.size(); - �ش��ϴ� ���̵� ����
	// ����� (�����̰ų� â�ݰų� quit�̰ų�) ���ܻ���ó��
	// 
	// ��ȭ�� ������ ���� ���̵� �����ؼ� +1 ���ְų� �ź��Ѵ�.
	//////////////////////////////////////////////////////
	
	
	
	
	
	
	// TCP:::(����:����/��ȭ��/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::(����Ʈ:ä��������)id1,id2,:::��ȭ������
	
	public void run() {
//		super.run();

			String tcpState = "";	// ä�� ��ū ����
			Boolean welcome=false;	// ����/��ȭ�� ������
			
			// ��ȭ����-----------------------------------
			while (true) {
				try {
					String text = br.readLine();
					// Ŭ���̾�Ʈ���� ��ū�� �ӼӸ��� �ʺ����� ��� ���
					String[] temp = text.split(":::",5);
					
					if(!welcome) {// ���� ó���� ���̵��� ��Ÿ����.
						welcome=true;
						id = text;// ����ÿ��� text������ id����
						text="";
						tcpState = "0" +":::" +id +":::" +"" +":::";
					} 
//					else if(!temp[4].isEmpty()) {
//						//tcpState = "1" +":::" +id +":::" +"" +":::";
//						if(temp[4].split(" ")[temp[4].length()].equals("����")) {
//							server.user.remove(this);	
//						}
//						
//					}
					
					
					else {// ��ȭ�ÿ��� text���� ����
						tcpState = "2" +":::" +id +":::" +"" +":::";	
						if(text.substring(text.length()-2).equals("����")) {	//���� Ŭ���̾�Ʈ���� ���� �޽����� ������ ������ 
							server.user.remove(this);						//�ش� ������ user ����
						}
						
//						if(temp[4].split(" ").equals("����")) {
//							server.user.remove(this);	
//						}

					}
					
					
					
					
					
					// �� Ŭ���̾�Ʈ�� ä����ū ����
					broadcast(tcpState, text);
					
				} catch (IOException e) {
					// ä������
				}
			} // while end
			// ��ȭ���� ��-----------------------------------

	} // end

	
	
	// ��� �����ڿ��� �޼����� ������
	void broadcast(String token, String text) {

		String tcpState = token;
		
		// ä����ū - userId����Ʈ �߰�
		int s = server.user.size();
		for(int i=0;i<s;i++) {
			tcpState = tcpState.concat(server.user.elementAt(i).id + ",");
//			System.out.println("user = " + server.user.elementAt(i).id);
		}
		
		// ä����ū - ��ȭ�� ��ġ��
		tcpState = tcpState.concat(":::" + text);
		server.setMsg(tcpState+"\n");		// �����α�
		
		// user���� ä����ū ������
		for (int i = 0; i < s; i++) {
			ChatHandle ch = (ChatHandle) server.user.elementAt(i);
			ch.pw.println(tcpState);
			ch.pw.flush();
		}
	}
	
	
	
//	// ��� �����ڿ��� �޼����� ������
//	void broadcast(String string) {
//		int s = server.user.size();
//		for (int i = 0; i < s; i++) {
//			ChatHandle ch = (ChatHandle) server.user.elementAt(i);
//			// ch.pw.println(ch.client.id);
//			// user_id[i]=ch.client.id;
//			//user_id[i] = ch.id;
//			// ch.pw.println("������ �ο� �� : "+ s);
//			// ch.pw.write(s);
//			ch.pw.println(string);
//			ch.pw.flush();
//		}
//	}

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