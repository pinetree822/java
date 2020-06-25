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
		btn_exit.addActionListener(this);
		user = new Vector();
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
				txt_list.append(str+"\n");

				ChatHandle ch = new ChatHandle(this, sock);
				user.addElement(ch);// 사용자 핸들 추가

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
			user.remove(this);
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

	
	
	
	



	// TCP:::stateChat:::targetPerson:::idList:::chatContext
	// TCP:::(상태:입장/퇴장/대화중)0,1,2:::(대상:전체,귓속말id)"",id:::(리스트:채팅접속자)id1,id2,:::대화말내용
	// TCP:::아이디:::id1,id2,id3,:::대화내용

	// tcpState:::stateChat:::targetPerson:::idList:::chatContext
	// int stateChat=0;
	// targetPerson="";
	// idList={};
	// String tcpState = "TCP:::";
	
//	broadcast(String.valueOf(server.user.size()));
//	for (int i = 0; i < server.user.size(); i++) {
//		broadcast(server.user.elementAt(i).id);
//		// 사용자정보출력 테스트
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


	// TCP:::아이디:::id1,id2,id3,:::대화내용
	// tcpState:::stateChat:::targetPerson:::idList:::chatContext
	// int stateChat=0;
	// targetPerson="";
	// idList={};

	// TCP:::stateChat:::id:::whisperId:::idList:::chatContext
	// TCP:::(상태:대화중/입장/퇴장)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::(리스트:채팅접속자)id1,id2,:::대화말내용
//	String tcpState = "TCP:::" +"1" +":::" +id +":::" +" " +":::" +"id1,id2," +":::" +" " ;
//	server.setMsg(id + " 님 입장\n");
//	broadcast(id + " 님 입장");
	
	
	
	
	//////////////////////////////////////////////////////
	// 클라이언트에서 토큰에 귓속말을 않보내서 잠시 대기
	// 클라이언트에서 퇴장시 server.user.size(); - 해당하는 아이디 삭제
	// 퇴장시 (오류이거나 창닫거나 quit이거나) 예외사항처리
	// 
	// 대화명 생성시 같은 아이디 검증해서 +1 해주거나 거부한다.
	//////////////////////////////////////////////////////
	
	
	
	
	
	
	// TCP:::(상태:입장/대화중/퇴장)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::(리스트:채팅접속자)id1,id2,:::대화말내용
	
	public void run() {
//		super.run();

			String tcpState = "";	// 채팅 토큰 전달
			Boolean welcome=false;	// 입장/대화중 구분자
			
			// 대화시작-----------------------------------
			while (true) {
				try {
					String text = br.readLine();
					// 클라이언트에서 토큰에 귓속말을 않보내서 잠시 대기
					String[] temp = text.split(":::",5);
					
					if(!welcome) {// 입장 처음만 아이디값이 나타난다.
						welcome=true;
						id = text;// 입장시에만 text내용을 id저장
						text="";
						tcpState = "0" +":::" +id +":::" +"" +":::";
					} 
//					else if(!temp[4].isEmpty()) {
//						//tcpState = "1" +":::" +id +":::" +"" +":::";
//						if(temp[4].split(" ")[temp[4].length()].equals("퇴장")) {
//							server.user.remove(this);	
//						}
//						
//					}
					
					
					else {// 대화시에만 text내용 저장
						tcpState = "2" +":::" +id +":::" +"" +":::";	
						if(text.substring(text.length()-2).equals("퇴장")) {	//만약 클라이언트에서 퇴장 메시지를 서버로 보낼시 
							server.user.remove(this);						//해당 서버의 user 제거
						}
						
//						if(temp[4].split(" ").equals("퇴장")) {
//							server.user.remove(this);	
//						}

					}
					
					
					
					
					
					// 각 클라이언트에 채팅토큰 전달
					broadcast(tcpState, text);
					
				} catch (IOException e) {
					// 채팅종료
				}
			} // while end
			// 대화시작 끝-----------------------------------

	} // end

	
	
	// 모든 접속자에게 메세지를 보내줌
	void broadcast(String token, String text) {

		String tcpState = token;
		
		// 채팅토큰 - userId리스트 추가
		int s = server.user.size();
		for(int i=0;i<s;i++) {
			tcpState = tcpState.concat(server.user.elementAt(i).id + ",");
//			System.out.println("user = " + server.user.elementAt(i).id);
		}
		
		// 채팅토큰 - 대화말 합치기
		tcpState = tcpState.concat(":::" + text);
		server.setMsg(tcpState+"\n");		// 서버로그
		
		// user에게 채팅토큰 보내기
		for (int i = 0; i < s; i++) {
			ChatHandle ch = (ChatHandle) server.user.elementAt(i);
			ch.pw.println(tcpState);
			ch.pw.flush();
		}
	}
	
	
	
//	// 모든 접속자에게 메세지를 보내줌
//	void broadcast(String string) {
//		int s = server.user.size();
//		for (int i = 0; i < s; i++) {
//			ChatHandle ch = (ChatHandle) server.user.elementAt(i);
//			// ch.pw.println(ch.client.id);
//			// user_id[i]=ch.client.id;
//			//user_id[i] = ch.id;
//			// ch.pw.println("접속한 인원 수 : "+ s);
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