package chatting11;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Enumeration;
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

		txt_list.setBackground(Color.PINK);
		add(txt_list, "Center");
		add(btn_exit, "South");
		setSize(450, 800);
		setVisible(true);

		// �̺�Ʈó��-----------------------
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btn_exit.addActionListener(this);
		user = new Vector();
		serverStart();
	}// ChatServer()

	public void serverStart() {

		try {
			ss = new ServerSocket(SERVER_PORT);
			System.out.println("������ �����մϴ�.\n");
			txt_list.append("������ �����մϴ�.\n");
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

	} // serverStart()

	public void setMsg(String string) {
		txt_list.append(string);
	} // setMsg()

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_exit)
			System.exit(0);
	} // actionPerformed()

	public static void main(String[] args) {
		new ChatServer();
	}// main()

}// class ChatServer

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
	} // ChatHandle()


	
	//////////////////////////////////////////////////////
	// Ŭ���̾�Ʈ���� ��ū�� �ӼӸ��� �ʺ����� ��� ���
	// Ŭ���̾�Ʈ���� ����� server.user.size(); - �ش��ϴ� ���̵� ����
	// ����� (�����̰ų� â�ݰų� quit�̰ų�) ���ܻ���ó��
	// 
	// ��ȭ�� ������ ���� ���̵� �����ؼ� +1 ���ְų� �ź��Ѵ�.
	//////////////////////////////////////////////////////
	public void run() {
//		super.run();

			String tcpState = "";	// ä�� ��ū ����
			Boolean welcome=false;	// ����/��ȭ�� ������


			// ����/����/��ȭ
			// ��ü/�ӼӸ�
			//////////////////////////���� ��ū ���� ////////////////////////////////////
			//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
			//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
			//TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::���̵𸮽�Ʈ:::������:::��ȭ������
			//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +"" +":::" +"" ;
			//////////////////////////���� ��ū ���� ////////////////////////////////////
			//////////////////////////Ŭ���̾�Ʈ ��ū ���� ////////////////////////////////////
			//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
			//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
			//TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::���̵𸮽�Ʈ:::������:::��ȭ������
			//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +frofile +":::" +"" ;
			//////////////////////////Ŭ���̾�Ʈ ��ū ���� ////////////////////////////////////
			
			
			
			// ��ȭ����-----------------------------------
			while (true) {
				try {
					String text = br.readLine();
			        // split�� �̿��� ä����ū ��ü���ڿ� �и�
			        String tokenMsg[] = text.split(":::",6) ;// ���ϸ޼��� �迭ȭ

			    	///////////////////////////////////////////////////////////////
					System.out.println("text1 = " + text);
					System.out.println("tokenMsg1 = " + tokenMsg.length + " , " + Arrays.toString(tokenMsg));
					///////////////////////////////////////////////////////////////
					text="";
			        
					// Ŭ���̾�Ʈ���� ��ū�� �ӼӸ��� �ʺ����� ��� ���
					// �����ڵ� ����( ���� ���̵�, ������<����,2���̻�> �������� ���� ���̵�) ������ ����
					if(!welcome) {// ���� ó���� ���̵��� ��Ÿ����.
						welcome=true;
						id = tokenMsg[1]+"";// ����ÿ��� text������ id����
						
					} else {// ��ȭ�ÿ��� text���� ��ȭ�������� ����.

//						text = tokenMsg[1]+"";// ����ÿ��� text������ id����
//						tcpState = "0" +":::" +id +":::" +"" +":::" +"" +":::" +"" +":::" +"";
				        if(tokenMsg[0].equals("0")) {
				        	System.out.println("���� �ϼ˽��ϴ�.");
				        } else if(tokenMsg[0].equals("1")) {
				        	System.out.println("���� �ϼ˽��ϴ�.");
				    		server.user.remove(this);
				        } else if(tokenMsg[0].equals("2")) {
				        	if(tokenMsg[2].equals("") || tokenMsg[2]==null) {
					        	System.out.println("��ȭ���Դϴ�.");
				        	} else {
					        	System.out.println(tokenMsg[2] + "�� �ӼӸ����Դϴ�.");
				        	}
				        } else {
				        	System.out.println("��Ÿ��� = " + tokenMsg[4]);
				        }
											
					}// else
					
					// �� Ŭ���̾�Ʈ�� ä����ū ����
					broadcast(tokenMsg);
					
				} catch (IOException e) {
					// ä������
				}// try
				
			} // while end
			// ��ȭ���� ��-----------------------------------

	} // run()

	
	
	// ��� �����ڿ��� �޼����� ������
//	void broadcast(String tokenMsg[], String text) {
	void broadcast(String tokenMsg[]) {

		String tcpState="";// ���ϸ޽��� �ٽ� ��Ʈ��ȭ
		
	///////////////////////////////////////////////////////////////
		System.out.println("tokenMsg2 = " + tokenMsg.length + " , " + Arrays.toString(tokenMsg));
//		System.out.println(Arrays.toString(tokenMsg));
		System.out.println("server.user.size() = " + server.user.size());
	///////////////////////////////////////////////////////////////
		
		
		// ä����ū - userId����Ʈ �߰�
		int s = server.user.size();
		for(int i=0;i<s;i++) {
			tokenMsg[3]=tokenMsg[3].concat(server.user.elementAt(i).id + ",")+"";
			System.out.println("user = " + server.user.elementAt(i).id);
		}
		

		// ����/����/��ȭ
		// ��ü/�ӼӸ�
		//////////////////////////���� ��ū ���� ////////////////////////////////////
		//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
		//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
		//TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::���̵𸮽�Ʈ:::������:::��ȭ������
		//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +"" +":::" +"" ;
		//////////////////////////���� ��ū ���� ////////////////////////////////////
		// �ӼӸ� �����
//		System.out.println("choice.getSelectedItem() = " + choice.getSelectedItem());// �ӼӸ� ���õ� ���̵�
//		// ��ü���� �ӼӸ�
//		if(choice.getSelectedItem().equals("�ӼӸ�"))
//			tcpState = "2" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +text;// ��ü��
//		else
//			tcpState = "2" +":::" +user.id +":::" +choice.getSelectedItem() +":::" +"" +":::" +"" +":::" +text;// �ӼӸ�
		
		
		
		// ä����ū - ��ȭ�� ��ġ�� / ���ͱ�� : (��ü�޽���, �ӼӸ�, �׷�޽���|| �� || �̸�Ƽ�� || ) ����(����) / ���ͱ��(����)
		tcpState = tokenMsg[0] +":::" +tokenMsg[1] +":::" +tokenMsg[2] +":::" +tokenMsg[3] +":::" +tokenMsg[4] +":::" +tokenMsg[5];

		// ���� ���̵�
		/**��ȭ�� �ߺ� ���θ� üũ�ϴ� �޼ҵ�*/
		boolean isDuplicateChatName(String chatName) {
			//server.user.elements();
			Vector<ChatHandle> user = server.user;
			while(user.hasMoreElements()){
				Enumeration<String> user = en.nextElement();
//				if(user.chatName.equals(chatName)){
//					return true;
//				}
			}//while-------------
			return false;
		}
	  	//2. ��ȿ�� üũ
    	if(id==null||chatName==null||gender==null||host==null
    			||id.trim().isEmpty()||chatName.trim().isEmpty()
    			||gender.trim().isEmpty()
    			||host.trim().isEmpty())
    	{
    		showMsg("�Է� �ڽ��� ���� ��� �Է��ϼ���");
    		tfId.requestFocus();
    		return;
    	}


		
		
		
		
		
		
		server.setMsg(tcpState+"\n");						// �����α�

		
		// Ŭ���̾�Ʈ user���� ä����ū ������
		for (int i = 0; i < s; i++) {
			ChatHandle ch = (ChatHandle) server.user.elementAt(i);
			ch.pw.println(tcpState);
			ch.pw.flush();
		}
	}// broadcast()
	
} // class ChatHandle






//tcpState = tcpState.concat(server.user.elementAt(i).id + ",");
//System.out.println("user = " + server.user.elementAt(i).id);
//tcpState = tcpState.concat(":::" +text +":::");		// 



// TCP:::stateChat:::targetPerson:::idList:::chatContext
// TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::(����Ʈ:ä��������)id1,id2,:::��ȭ������
// TCP:::���̵�:::id1,id2,id3,:::��ȭ����

// tcpState:::stateChat:::targetPerson:::idList:::chatContext
// int stateChat=0;
// targetPerson="";
// idList={};
// String tcpState = "TCP:::";

//broadcast(String.valueOf(server.user.size()));
//for (int i = 0; i < server.user.size(); i++) {
//	broadcast(server.user.elementAt(i).id);
//	// ������������ �׽�Ʈ
//	//System.out.println("user = " + server.user.elementAt(i).id);
//}


// printUser_id();
//for(int i=0;i<server.user.size();i++) {
//	ChatHandle ch = (ChatHandle) server.user.elementAt(i);
//	user_id[i]=ch.client.id;
//}
//for(int i=0;i<server.user.size();i++) {
//	broadcast(user_id[i]+" :: ");
//}

//broadcast(":" + server.user.size());


// TCP:::���̵�:::id1,id2,id3,:::��ȭ����
// tcpState:::stateChat:::targetPerson:::idList:::chatContext
// int stateChat=0;
// targetPerson="";
// idList={};

// TCP:::stateChat:::id:::whisperId:::idList:::chatContext
// TCP:::(����:����/����/��ȭ��/)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::(����Ʈ:ä��������)id1,id2,:::��ȭ������
//String tcpState = "TCP:::" +"1" +":::" +id +":::" +" " +":::" +"id1,id2," +":::" +" " ;
//server.setMsg(id + " �� ����\n");
//broadcast(id + " �� ����");





	
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