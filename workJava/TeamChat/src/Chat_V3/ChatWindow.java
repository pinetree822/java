package Chat_V3;



import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.border.EmptyBorder;

import javax.swing.*;

public class ChatWindow extends JFrame implements ActionListener, Runnable {
	private static final int SERVER_PORT = 5000;
//	private static final String SERVER_IP = "192.168.219.198";
	private static final String SERVER_IP = "127.0.0.1";

	JFrame Login_f, Chatmain_f, Frofile_f, Emoticon_f;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField ip_tf, id_tf, send_tf;;
	private Socket socket;
	private BufferedWriter bw;
	private JTextArea textArea;
	JButton Exit_btn, Emoticon_btn, frofile_btn, send_btn, connect_btn;
	List list;
	PrintWriter pw = null;
	BufferedReader br = null;
	OutputStream os = null;
	JPanel panel, panel_1;
	JLabel lblNewLabel, lblNewLabel_1, UserCount_Label;
	String id = "";
	String ip = "";
	ImageIcon frofile = null;
	Socket sock;
	User user = new User();
	Choice choice = new Choice();
	Vector<User> User_list = new Vector<User>();
	String cnt = "0";
	int User_cnt = 0, user_idx = 0;

	public ChatWindow() {
		Login();
	}// ChatWindow()

	public void Login() {
		Login_f = new JFrame();
		Login_f.setTitle("로그인");
		Login_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Login_f.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Login_f.add(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNewLabel = new JLabel("\uC11C\uBC84 ip :"); // 서버 아이피 레이블
		lblNewLabel.setBounds(113, 84, 57, 15);
		panel.add(lblNewLabel);

//		ip_tf = new JTextField("192.168.219.198");
		ip_tf = new JTextField(SERVER_IP);	// 서버아이피 입력 상자
		ip_tf.setBounds(181, 81, 116, 21);
		panel.add(ip_tf);
		ip_tf.setColumns(10);

		lblNewLabel_1 = new JLabel("ID :");	// 아이디 레이블
		lblNewLabel_1.setBounds(113, 129, 57, 15);
		panel.add(lblNewLabel_1);

		id_tf = new JTextField("unknown"); // 사용자이름 입력 상자
		id_tf.setBounds(181, 126, 116, 21);
		panel.add(id_tf);
		id_tf.setColumns(10);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		frofile_btn = new JButton("\uD504\uB85C\uD544");	// 프로필 버튼
		frofile_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frofile();
			}
		});
		panel_1.add(frofile_btn);

		connect_btn = new JButton("\uC785\uC7A5"); // 연결하기 버튼
		connect_btn.addActionListener(this);
		panel_1.add(connect_btn);
		Login_f.setVisible(true);

	}// Login()

	public void Chatmain(String id, ImageIcon frofile) {
		setIF(id, frofile);
		Chatmain_f = new JFrame();
		// this.textArea.append("[ "+this.id+" ] 님이 입장하셨습니다.");
		Chatmain_f.setTitle("\uCC44\uD305");						// 패널 제목
		Chatmain_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 패널 종료
		Chatmain_f.setBounds(100, 100, 600, 378);					// 패널 크기,위치
//		Chatmain_f.setBounds(100, 100, 546, 378);					// 패널 크기,위치
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Chatmain_f.add(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		
		
		////////////////////////////수정:귓속말 리스트 화면 출력 - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////
		//JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");// 입력
		
		
		//choice.setSize(20, 35);
		//choice.add("귓속말");
		//choice.add("Apple");
		//choice.add("아이디");
		
		//choice.add(textField.getText());
		//choice.select(choice.getItemCount()-1);
		//
		//String data = "선택한 값보기 : "
		//+ choice.getItem(choice.getSelectedIndex())
		//+ statusLabel.setText(data);
		//
		//choice.getSelectedObjects();
		//choice.getSelectedItem();
		//choice.remove(choice.getSelectedIndex());
		//choice.removeAll();      
		//choice.addItem(item);
		//panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");			// 입력 : 레이블
		panel.add(lblNewLabel);
		
		choice = new Choice();										// 귓속말 : 초이스
		panel.add(choice);
		
		////////////////////////////수정:귓속말 리스트 화면 출력 - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////

		send_tf = new JTextField();									// 채팅 대화 상자
		send_tf.addActionListener(this);
		panel.add(send_tf);
		send_tf.setColumns(20);

		Emoticon_btn = new JButton("\uC774\uBAA8\uD2F0\uCF58");		// 이모티콘 버튼
		Emoticon_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emoticon();
			}
		});
		panel.add(Emoticon_btn);

		send_btn = new JButton("\uC804\uC1A1");						// 전송 버튼
		send_btn.addActionListener(this);
		panel.add(send_btn);

		Exit_btn = new JButton("\uB098\uAC00\uAE30");				// 나가기 버튼
		Exit_btn.addActionListener(this);
		panel.add(Exit_btn);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(357, 10, 154, 276);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uC811\uC18D\uC790 \uB9AC\uC2A4\uD2B8 : ");	// 접속자 리스트
		lblNewLabel_1.setBounds(10, 10, 100, 15);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uCD1D \uC778\uC6D0 \uC218 :");				// 총 인원 수
		lblNewLabel_2.setBounds(10, 251, 64, 15);
		panel_2.add(lblNewLabel_2);

		list = new List();	// 접속자 리스트 상자
		list.setBounds(10, 31, 134, 214);
		
		panel_2.add(list);

		UserCount_Label = new JLabel("0");		// 접속자 카운터 표시 레이블
		UserCount_Label.setBounds(85, 251, 44, 15);
		panel_2.add(UserCount_Label);
//		UserCount_Label.setText(sock.si);

		textArea = new JTextArea();				// 채팅 히스토리 상자
		textArea.setEditable(false);
		
		// 채팅창에 스크롤바를 넣고, 엔터 쳣을때 채팅창 마지막으로 가기 위해서 처리
		///////////////////////////////////////수정 - 스크롤팬 - 2020.06.24.14.58////////////////////////////////////////////////////////////////////
		textArea.setBounds(0, 0, 333, 276);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(12, 10, 333, 276);
		panel_1.add(scrollPane);
//		panel_1.add(textArea);
		///////////////////////////////////////수정 - 스크롤팬 - 2020.06.24.14.58//////////////////////////////////////
		
		// this.textArea.append("[ " + id_tf.getText() + " ] 님이 입장하셨습니다.\n");
//		User_cnt = Integer.parseInt(cnt);
//		User_cnt++;
//		UserCount_Label.setText(Integer.toString(User_cnt));
		Chatmain_f.setVisible(true);



//		Chatmain_f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		Chatmain_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Chatmain_f.addWindowListener(new WindowAdapter(){
//        	public void windowClosing(WindowEvent e){
////        		exitProc();
//    			pw.println(id_tf.getText() + " 님 퇴장");
//    			pw.flush();
//    			System.out.println("windowClose");
//        		try{
//        			if(pw!=null) pw.close();
//        			if(os!=null) os.close();
//        			if(br!=null) br.close();
//        			if(sock!=null){
//        				sock.close();
//        				sock=null;
//        			}
//        			dispose();
//        			System.exit(0);//프로세스 종료
//        		}
//        		catch(IOException e1){ out.println("창 종료시 예외: "+e1); }
//        		catch(Exception e2) {}
//        		finally {}
//        	}
//        });	

        ///////////////////수정///////////////////////////////////////////////////////////////////
        //창닫기 이벤트 처리---

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE // 윈도우 종료버튼 무효화
		// this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE // 윈도우 setVisible() 호출
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//출처: https://msource.tistory.com/3 [MLog]
        ////////////////////////////////////////////////////////////////////////////////////
		
		
	}// Chatamin_f()

	public void setIF(String id, ImageIcon frofile) {
		// TODO Auto-generated method stub
		this.id = id;
		this.frofile = frofile;
	}// setIf()

	public void Frofile() {
		Frofile_f = new JFrame();
		Frofile_f.setTitle("\uD504\uB85C\uD544");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frofile_f.setBounds(100, 100, 231, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Frofile_f.add(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel Image_label = new JLabel("\uC774\uBBF8\uC9C0 \uC5C6\uC74C");
		Image_label.setBounds(12, 10, 181, 145);
		panel.add(Image_label);

		JButton Frofile_select_btn = new JButton("\uC120\uD0DD");
		Frofile_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frofile_f.dispose();
			}
		});
		Frofile_select_btn.setBounds(108, 142, 97, 23);
		panel.add(Frofile_select_btn);
		Frofile_f.setVisible(true);

	}// Frofile()

	public void Emoticon() {
		Emoticon_f = new JFrame();
		Emoticon_f.setTitle("\uC774\uBAA8\uD2F0\uCF58");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Emoticon_f.setBounds(100, 100, 443, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Emoticon_f.add(contentPane);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JList Emoticon_list = new JList();
		Emoticon_list.setBounds(12, 10, 393, 280);
		panel_1.add(Emoticon_list);

		JButton Em_select_btn = new JButton("\uC120\uD0DD");
		Em_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emoticon_f.dispose();
			}
		});
		contentPane.add(Em_select_btn, BorderLayout.SOUTH);
		Emoticon_f.setVisible(true);
	}// Emoticon()

	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		if (ob == connect_btn) {
			this.setTitle("접속자이름 :" + id_tf.getText());
			id = id_tf.getText();
//			String ids = id_tf.getText();
//			this.setTitle("접속자이름 :" + ids.toString());

			Login_f.dispose();
			Chatmain(id, frofile);

			Thread th = new Thread(this);
			th.start();

			// list.add(user.id);

		}

		if (ob == send_btn) {
			send();
		}
		if (ob == send_tf) {
			send();
		}
		if (ob == Exit_btn) {
			////////// 수정필요 - 퇴장 ////////////////////////////////////////////////////
			String tcpState  = "1" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +"{ 퇴장 }";
//			pw.println(id_tf.getText() + " 님 퇴장");
			pw.println(tcpState);
			pw.flush();

			System.exit(1);
		}
	}// actionPerformed()

	public void send() {
		String text = send_tf.getText();
		String tcpState = "";
		if (text.equals("q") || text.equals("quit")) {
			// text = id + " 채팅방 퇴장";
			////////// 수정필요 - 퇴장 ////////////////////////////////////////////////////
			tcpState = "1" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +"{ 퇴장 }";
//			pw.println(id_tf.getText() + " 님 퇴장");
			pw.println(tcpState);
			pw.flush();
			/// System.out.println("채팅유저 프로그램이 종료됩니다");

			System.exit(1);
		}

		send_tf.setText("");
		send_tf.requestFocus();
		
		/////////////////// 수정필요 : 대화 - 2020.06.24.11.13 ////////////////////////////////////////////////////
		//choice.setSize(20, 35);
		//choice.add("귓속말");
		//choice.add("Apple");
		//choice.add("아이디");
				
		//choice.add(textField.getText());
		//choice.select(choice.getItemCount()-1);
		//      
		//String data = "선택한 값보기 : "
		//+ choice.getItem(choice.getSelectedIndex())
		//+ statusLabel.setText(data);
		//      
		//choice.getSelectedObjects();
		//choice.getSelectedItem();
		//choice.remove(choice.getSelectedIndex());
		//choice.removeAll();      
		//choice.addItem(item);
		//panel.add(lblNewLabel);
		//////////////////////////클라이언트 토큰 조합 ////////////////////////////////////
		//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
		//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
		//TCP:::(상태:대화중/입장/퇴장)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::아이디리스트:::프로필:::대화말내용
		//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +"" +":::" +"" ;
		//////////////////////////클라이언트 토큰 조합 ////////////////////////////////////
		
		
		System.out.println("choice.getSelectedItem() = " + choice.getSelectedItem());// 귓속말 선택된 아이디
		
		// 전체말과 귓속말
		if(choice.getSelectedItem().equals("귓속말"))
			tcpState = "2" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +text;// 전체말
		else
			tcpState = "2" +":::" +user.id +":::" +choice.getSelectedItem() +":::" +"" +":::" +"" +":::" +text;// 귓속말
		
		
		//pw.println(text);
		
/////////////////// 수정필요 : 대화 - 2020.06.24.11.13 ////////////////////////////////////////////////////
		
		pw.println(tcpState);
		pw.flush();
	} // send()

	
	
	
	
	@Override
	public void run() {
		
		try {
			sock = new Socket(SERVER_IP, SERVER_PORT);

			////////// 수정 ////////////////////////////////////////////////////
			user.id = id_tf.getText();
			user.frofile = null;
//			String userId = id_tf.getText();
//			String frofile = null;

			
			// sockOutPush......
			os = sock.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
			////////// 수정필요 - 입장 아이디////////////////////////////////////////////////////
			String tcpState = "0" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +"{ 입장 }";
			pw.println(tcpState);
			pw.flush();
			
			// sockInPull......
			InputStream is = sock.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));


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
			// Mission - > 대화중 이모티콘<아이콘> 처리 : 단독으로 처리



			String[] user_id = null;// list.add(user.id);
			String str;int j=0;			
			while (true) {
				
				str = br.readLine().trim();									// 전달된 토큰을 버퍼거쳐서 양쪽 공백 처리
				System.out.println("Client " + (j++)  + ",str = " + str);	// 전달된 전체토큰문자열 소스 출력
				
		        // split을 이용한 채팅토큰 전체문자열 분리
		        String[] tokenMsg = str.split(":::",6) ;
		         
		        // 채팅토큰 전체문자열 출력
		        System.out.println(">>> split ") ;
		        for(int i=0; i < tokenMsg.length; i++){
		            System.out.println(tokenMsg[i]) ;
		        }

		        // 사용자 리스트 출력			
		        String usersList[] = tokenMsg[3].split(",");			// 사용자 목록
		        int uCnt = usersList.length;							// 사용자 수
		        UserCount_Label.setText(String.valueOf(uCnt));
		        System.out.println("UserList = " + uCnt + "명입니다.");
		        

////////////////////////////수정:귓속말 리스트 출력 - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////
	        	list.removeAll();										// 사용자 접속 목록 초기화 후 > 채팅시 마다 목록 초기화
	        	choice.removeAll();										// 귓속말 사용자 목록 초기화 후 > 채팅시 마다 목록 초기화
	        	choice.add("귓속말");										// 전체대상 채팅 , 귓속말은 대상 아이디를 출력
		        for(int i=0; i<uCnt; i++) {
		        	list.add(usersList[i]);								// 사용자 접속 리스트 추가
		        	if(!user.id.equals(usersList[i]))
		        		choice.add(usersList[i]+"");					// 귓속말 사용자(자신제외) 리스트 추가
		        	System.out.println("사용자 : " + usersList[i]); 		// 사용자 목록 출력
		        }
////////////////////////////수정:귓속말 리스트 출력 - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////
//
//				귓속말 리스트 대상  참고 내역
//
//				JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");// 입력
//				Choice choice = new Choice();
//				panel.add(lblNewLabel);
//				panel.add(choice);
//				choice.add("Apple");
//				choice.add("아이디");
				
//				choice.add(textField.getText());
//				choice.select(choice.getItemCount()-1);
//				      
//				String data = "선택한 값보기 : "
//				+ choice.getItem(choice.getSelectedIndex())
//				+ statusLabel.setText(data);
//				      
//				choice.getSelectedObjects();
//				choice.getSelectedItem();//////////////////
//				choice.remove(choice.getSelectedIndex());
//				choice.removeAll();      
//				choice.addItem(item);
//				panel.add(lblNewLabel);
				
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		        
		        
		        // ******* 접속자리스트에 사용자 목록 업데이트 *************** //
		        // 현재 서버에서 보내주는 메세지만 분류
		        // 입장 / 퇴장 / 대화중 / 귓속말 / 기타 분류
				//	    	TCP:::(상태:대화중/입장/퇴장)0,1,2:::(selfId)"",id:::(대상:전체,귓속말id)"",id:::(생략):::(생략):::대화말내용
		        String headChat = "["+tokenMsg[1]+"] > ";	// [아이디] >
		        String middleChat = "";						// [귓속말:아이디] 
		        String tailChat = "";						// 입장하셨습니다.
		        String allChat = "";						// [아이디] > [귓속말:아이디] // 입장하셨습니다. 퇴장 하셨습니다.
		        
		        if(tokenMsg[0].equals("0")) {
		        	tailChat = "입장하셨습니다.";								System.out.println("입장 하셧습니다."); // 입장하셨습니다.
		        	allChat = headChat + middleChat + tailChat;
		        } else if(tokenMsg[0].equals("1")) {
		        	tailChat = "퇴장 하셨습니다.";								System.out.println("퇴장 하셧습니다.");// 퇴장 하셨습니다.
		        	allChat = headChat + middleChat + tailChat;
		        } else if(tokenMsg[0].equals("2")) {

		        	if(tokenMsg[2].equals("") || tokenMsg[2]==null) {
		        		System.out.println("대화중입니다."); //System.out.println(tokenMsg[4]);
				        allChat = headChat + middleChat + tailChat + tokenMsg[5];
		        	} else {
//		        		System.out.println("귓속말 => tokenMsg[1] = " + tokenMsg[1] + ", tokenMsg[2] = " + tokenMsg[2]);
			        	if(tokenMsg[1].equals(user.id) || tokenMsg[2].equals(user.id)) {// 받는아이디와 보낸
			        		middleChat = "[귓속말:"+tokenMsg[2]+"] "; System.out.println(tokenMsg[2] + "와 귓속말중입니다."); //System.out.println(tokenMsg[4]);
					        allChat = headChat + middleChat + tailChat + tokenMsg[5];
			        	} else { // 귓속말에 해당하는 아이디이면 생략
//			        		allChat = headChat + middleChat + tailChat;
			        		allChat = "";
			        	}
		        	}// if
		        	
		        } else {
		        	System.out.println("기타등등 = " + tokenMsg[5]);
		        	allChat = headChat + middleChat + tailChat;
		        	// 기타등등
		        }// if
		        
//		        allChat = headChat + middleChat + tailChat + tokenMsg[5];
		        if(!allChat.equals("")) { // 메세지 있는것만 출력
		        	this.textArea.append(allChat + "\n");// 채팅 히스토리 상자에 입력
		    		///////////////////////////////////////수정 - 스크롤팬 - 2020.06.24.14.58//////////////////////////////////////
		    		this.textArea.setCaretPosition(textArea.getDocument().getLength());// JTextArea에 내용이 추가될 때마다 스크롤을 내리지 않고 바로 보기 위해서는 다음 코드를 추가한다.
		        }
		        
		        
		      //textArea = new JTextArea();				// 채팅 히스토리 상자

		      // 채팅창에 메세지 출력
		      // 클라이언트 to 서버 메세지 정리
		      //textArea.append(tokenMsg[4].toString() + "\n");
		      //this.textArea.append("[ " + id_tf.getText() + " ] 님이 입장하셨습니다.\n");
		      //if(!tokenMsg.equals(""))
//		      	this.textArea.append("[ " + tokenMsg[4].toString() + " ] 님이 입장하셨습니다.\n");
		        
		        
			}// while

		} catch (IOException e) {}// try
		
	}// run()

	
	public static boolean isNum(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}// inNum()

	
	public static void main(String[] args) {
		new ChatWindow();

	}// main()

}// class ChatWindow

class User {
	String id = "";
	ImageIcon frofile = null;
}// class User











//list = usersList;
//java.awt.list.list();
//java.util.List<String> list = new ArrayList<String>(Arrays.asList(userList));
//list = new List();						// 접속자 리스트 상자
//UserCount_Label = new JLabel("0");		// 접속자 카운터 표시 레이블
//textArea = new JTextArea();				// 채팅 히스토리 상자		






//System.out.println("tokenMsg = " + tokenMsg.length);

// 채팅창에 메세지 출력
// 클라이언트 to 서버 메세지 정리
//textArea.append(tokenMsg[4].toString() + "\n");
//this.textArea.append("[ " + id_tf.getText() + " ] 님이 입장하셨습니다.\n");
//if(!tokenMsg.equals(""))
//	this.textArea.append("[ " + tokenMsg[4].toString() + " ] 님이 입장하셨습니다.\n");



//String[] option = str.split(" ");
//if (option[option.length - 1].equals("입장") || option[option.length - 1].equals("퇴장")) {
//	textArea.append(str + "\n");
//} else if (isNum(str)) {
//	User_cnt = Integer.parseInt(str);
//} else if(str.contains(":>>")){
//	textArea.append(str + "\n");
//} else {
////	if(User_cnt!=1) {
//		list.replaceItem(str,User_cnt-1);
////	}else {
////		list.add(str);
////	}// if
//}// if
//
//// send_tf.setText(str);
//UserCount_Label.setText(String.valueOf(User_cnt));







//
//String src ="tis  7a  9b 5";
//String msg ="";//tis7a9b5 공백제거
//String ret ="";// 795숫자만 추출
//
//
//
//System.out.println("msg = " + src.replace(" ", ""));
//System.out.println("ret = " + src.replaceAll("[^0-9]", ""));
//
//
//
//int size = src.length();
//
//for(int i=0; i<size; i++) {
//	if(src.charAt(i)==' ') {
//		// msg를 스트링버퍼로 삽입하던지
//		// tmp를 만들어서 스트림버퍼로 삽입 하던지
//	}else {
//		// 공란만 삭제하거나 숫자만 추출하거나
//	}
//}//for


//String[] str=null;
//int k=0;
//while(true) {
//	str[k]=br.readLine();
//	textArea.append(str+"\n");
//	k++;
//	if(br.readLine()==null) {
//		break;
//	}
//}

