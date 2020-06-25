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
	Vector<ChatHandle> user; // 인원수 카운트

	public ChatServer() {
		super("Chatting Server");
		txt_list = new TextArea();
		btn_exit = new JButton("서버종료");

		txt_list.setBackground(Color.PINK);
		add(txt_list, "Center");
		add(btn_exit, "South");
		setSize(450, 800);
		setVisible(true);

		// 이벤트처리-----------------------
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btn_exit.addActionListener(this);
		user = new Vector();
		serverStart();
	}// ChatServer()

	public void serverStart() {

		try {
			ss = new ServerSocket(SERVER_PORT);
			System.out.println("서버를 시작합니다.\n");
			txt_list.append("서버를 시작합니다.\n");
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
	} // ChatHandle()


	
	//////////////////////////////////////////////////////
	// 클라이언트에서 토큰에 귓속말을 않보내서 잠시 대기
	// 클라이언트에서 퇴장시 server.user.size(); - 해당하는 아이디 삭제
	// 퇴장시 (오류이거나 창닫거나 quit이거나) 예외사항처리
	// 
	// 대화명 생성시 같은 아이디 검증해서 +1 해주거나 거부한다.
	//////////////////////////////////////////////////////
	public void run() {
//		super.run();

			String tcpState = "";	// 채팅 토큰 전달
			Boolean welcome=false;	// 입장/대화중 구분자


			// 입장/퇴장/대화
			// 전체/귓속말
			//////////////////////////서버 토큰 조합 ////////////////////////////////////
			//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
			//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
			//TCP:::(상태:대화중/입장/퇴장)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::아이디리스트:::프로필:::대화말내용
			//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +"" +":::" +"" ;
			//////////////////////////서버 토큰 조합 ////////////////////////////////////
			//////////////////////////클라이언트 토큰 조합 ////////////////////////////////////
			//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
			//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
			//TCP:::(상태:대화중/입장/퇴장)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::아이디리스트:::프로필:::대화말내용
			//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +frofile +":::" +"" ;
			//////////////////////////클라이언트 토큰 조합 ////////////////////////////////////
			
			
			
			// 대화시작-----------------------------------
			while (true) {
				try {
					String text = br.readLine();
			        // split을 이용한 채팅토큰 전체문자열 분리
			        String tokenMsg[] = text.split(":::",6) ;// 소켓메세지 배열화

			    	///////////////////////////////////////////////////////////////
					System.out.println("text1 = " + text);
					System.out.println("tokenMsg1 = " + tokenMsg.length + " , " + Arrays.toString(tokenMsg));
					///////////////////////////////////////////////////////////////
					text="";
			        
					// 클라이언트에서 토큰에 귓속말을 않보내서 잠시 대기
					// 검증코드 생략( 같은 아이디, 아이피<문제,2개이상> 검증되지 않은 아이디) 강퇴기능 생략
					if(!welcome) {// 입장 처음만 아이디값이 나타난다.
						welcome=true;
						id = tokenMsg[1]+"";// 입장시에만 text내용을 id저장
						
					} else {// 대화시에만 text내용 대화내용으로 쓴다.

//						text = tokenMsg[1]+"";// 입장시에만 text내용을 id저장
//						tcpState = "0" +":::" +id +":::" +"" +":::" +"" +":::" +"" +":::" +"";
				        if(tokenMsg[0].equals("0")) {
				        	System.out.println("입장 하셧습니다.");
				        } else if(tokenMsg[0].equals("1")) {
				        	System.out.println("퇴장 하셧습니다.");
				    		server.user.remove(this);
				        } else if(tokenMsg[0].equals("2")) {
				        	if(tokenMsg[2].equals("") || tokenMsg[2]==null) {
					        	System.out.println("대화중입니다.");
				        	} else {
					        	System.out.println(tokenMsg[2] + "와 귓속말중입니다.");
				        	}
				        } else {
				        	System.out.println("기타등등 = " + tokenMsg[4]);
				        }
											
					}// else
					
					// 각 클라이언트에 채팅토큰 전달
					broadcast(tokenMsg);
					
				} catch (IOException e) {
					// 채팅종료
				}// try
				
			} // while end
			// 대화시작 끝-----------------------------------

	} // run()

	
	
	// 모든 접속자에게 메세지를 보내줌
//	void broadcast(String tokenMsg[], String text) {
	void broadcast(String tokenMsg[]) {

		String tcpState="";// 소켓메시지 다시 스트링화
		
	///////////////////////////////////////////////////////////////
		System.out.println("tokenMsg2 = " + tokenMsg.length + " , " + Arrays.toString(tokenMsg));
//		System.out.println(Arrays.toString(tokenMsg));
		System.out.println("server.user.size() = " + server.user.size());
	///////////////////////////////////////////////////////////////
		
		
		// 채팅토큰 - userId리스트 추가
		int s = server.user.size();
		for(int i=0;i<s;i++) {
			tokenMsg[3]=tokenMsg[3].concat(server.user.elementAt(i).id + ",")+"";
			System.out.println("user = " + server.user.elementAt(i).id);
		}
		

		// 입장/퇴장/대화
		// 전체/귓속말
		//////////////////////////서버 토큰 조합 ////////////////////////////////////
		//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
		//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
		//TCP:::(상태:대화중/입장/퇴장)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::아이디리스트:::프로필:::대화말내용
		//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +"" +":::" +"" ;
		//////////////////////////서버 토큰 조합 ////////////////////////////////////
		// 귓속말 만들기
//		System.out.println("choice.getSelectedItem() = " + choice.getSelectedItem());// 귓속말 선택된 아이디
//		// 전체말과 귓속말
//		if(choice.getSelectedItem().equals("귓속말"))
//			tcpState = "2" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +text;// 전체말
//		else
//			tcpState = "2" +":::" +user.id +":::" +choice.getSelectedItem() +":::" +"" +":::" +"" +":::" +text;// 귓속말
		
		
		
		// 채팅토큰 - 대화말 합치기 / 필터기능 : (전체메시지, 귓속말, 그룹메시지|| 욕 || 이모티콘 || ) 구분(생략) / 필터기능(생략)
		tcpState = tokenMsg[0] +":::" +tokenMsg[1] +":::" +tokenMsg[2] +":::" +tokenMsg[3] +":::" +tokenMsg[4] +":::" +tokenMsg[5];

		// 같은 아이디
		/**대화명 중복 여부를 체크하는 메소드*/
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
	  	//2. 유효성 체크
    	if(id==null||chatName==null||gender==null||host==null
    			||id.trim().isEmpty()||chatName.trim().isEmpty()
    			||gender.trim().isEmpty()
    			||host.trim().isEmpty())
    	{
    		showMsg("입력 박스에 값을 모두 입력하세요");
    		tfId.requestFocus();
    		return;
    	}


		
		
		
		
		
		
		server.setMsg(tcpState+"\n");						// 서버로그

		
		// 클라이언트 user에게 채팅토큰 보내기
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
// TCP:::(상태:대화중/입장/퇴장)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::(리스트:채팅접속자)id1,id2,:::대화말내용
// TCP:::아이디:::id1,id2,id3,:::대화내용

// tcpState:::stateChat:::targetPerson:::idList:::chatContext
// int stateChat=0;
// targetPerson="";
// idList={};
// String tcpState = "TCP:::";

//broadcast(String.valueOf(server.user.size()));
//for (int i = 0; i < server.user.size(); i++) {
//	broadcast(server.user.elementAt(i).id);
//	// 사용자정보출력 테스트
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


// TCP:::아이디:::id1,id2,id3,:::대화내용
// tcpState:::stateChat:::targetPerson:::idList:::chatContext
// int stateChat=0;
// targetPerson="";
// idList={};

// TCP:::stateChat:::id:::whisperId:::idList:::chatContext
// TCP:::(상태:입장/퇴장/대화중/)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::(리스트:채팅접속자)id1,id2,:::대화말내용
//String tcpState = "TCP:::" +"1" +":::" +id +":::" +" " +":::" +"id1,id2," +":::" +" " ;
//server.setMsg(id + " 님 입장\n");
//broadcast(id + " 님 입장");





	
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