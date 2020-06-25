package chat.serverClientLine;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.glass.ui.Window;

public class GuClient extends JFrame implements ActionListener, Runnable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/////////////////레이아웃설정 변수/////////////////////////////////////////////
	CardLayout cardLayout;// 전체화면 패널 레이아웃 설정
	JPanel initMenu, logInMenu, logOnChatMenu;	// 패널(초기,첫,둘)화면 설정
	/////////////////로그인창/////////////////////////////////////////////
	JPanel logInMenuSubTop;					// 패널 : 상
	JPanel logInMenuSubBottom;				// 패널 : 중
	JPanel logInMenuSubAll;					// 패널 : (상,중 포함)하
	JLabel info;							// 레이블 : "IP와 대화명을 입력하시오"
	JLabel lbAddr, lbNickName;				// 레이블 : "서버IP:", "대화명"
	JButton btnConnect;						// 버튼 : "서버접속Connection"
	JTextField txtServerIp, txtNickName;	// 텍스트상자 : 서버아이피, 대화명
	/////////////////로그인창/////////////////////////////////////////////
	//////////////////채팅창////////////////////////////////////////////
	JPanel logOnChatMenuSubBottom;	// 패널 : 하
	JScrollPane chatScroll;			// 텍스트에리어스크롤상자 : 텍스트에리어 상자 감싸기
	JTextArea txtList;				// 텍스트에리어상자 : 전체 채팅글 상자
//	JTextArea txtList = new JTextArea() {
//		private static final long serialVersionUID = 1L;
//		public void paintComponent(Graphics g) {
//			g.drawRect(10, 10, 20, 20);
//			super.paintComponent(g);
//		}
//	};
//	
	JTextField txtInput;			// 텍스트상자 : 채팅글 입력
	JButton btnSend, btnExit;		// 버튼 : 전송, 종료
	//////////////////채팅창////////////////////////////////////////////
	
	
	/////////////////기능관련 변수/////////////////////////////////////////////
	Socket sock;				// 통신관리 객체
	String ipTxt;				// 로그인시 서버아이피 정보 저장 변수
	final int PORT = 7500;		// 통신포트번호
	PrintWriter pw = null;		// 프린트하기 위한 장치객체
	BufferedReader br = null;	// 버퍼를 이용하기 위한 버퍼리더 객체
	OutputStream os = null;		// 출력하기 위한 스트림 객체
	
	
	

	public GuClient() {


		//	디자인 화면 설계(초기화 화면), 첫화면 나타내기, 두번째화면 나타나게 하기
		//	메뉴화면 설정
		//		로그인 화면(logInMenu - logInScreen) 초기화
		//		로그온채팅 화면(logOnChatMenu - logOnChatScreen) 초기화
		//	초기화 화면(initMenu - GuClient)
		//	레이아웃 : 초기화 화면 - CardLayout 설정

		
		logInScreen();			// Frame에 로그인 화면 붙이기 // 함수안에서 logInMenu = new JPanel() 시킴
		logOnChatScreen();		// Frame에 로그온 채팅창 화면// 함수안에서 logOnChatMenu = new JPanel() 시킴
		initMenu = new JPanel();// Frame 초기화 메인패널
		
//		JFrame f = new JFrame("사원 관리 프로그램");
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Image img = toolkit.getImage("images/c.gif");
//		this.setIconImage(img);

//		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/c.gif")));
//		this.setIconImage(new Image(Toolkit.getDefaultToolkit().getImage("images/c.gif")));

		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/1.png"));
		
		// 초기화면 제목및 서브패널키 설정
		this.setTitle("Tis채팅 프로그램");					// GuClientFrame 제목
		
		//////////// 위치바꾸면 문제 생김 /////////////////////
		// 초기화면의 카드레이아웃 내부 설정의 패널 순서 정하기
		cardLayout = new CardLayout();					// cardLayout변수 설정
		initMenu.setLayout(cardLayout);					// 초기화면에 cardLayout 설정
		//////////// cardLayout선언정의후 사용//////////////////
		
		
		
		
		
		initMenu.add(logInMenu,"로그인화면");				// initMenu패널에 로그인화면(logInMenu) 추가 설정
		initMenu.add(logOnChatMenu,"로그온채팅화면");		// initMenu패널에 로그온채팅화면(logOnChatMenu) 추가 설정
		
		cardLayout.show(initMenu,"로그인화면");				// initMenu패널에서 "로그인화면" 검색하여 해당되는 logInMenu를 오픈한다.
		this.add(initMenu);								// 초기화(initMenu)패널을 JFrame에 추가
		

		
		this.setBounds(200, 200, 440, 790);				// JFrame (x,y,width,height)
		this.setVisible(true);							// JFrame 보이기


		
		
		
		///////////모든 카드 이벤트 처리 /////////////////////
		// JFrame이 ActionListener 상속해서
		// actionPerformed(ActionEvent e) 구현 처리하고 나서
		// addActionListener(this);로 처리가 가능하다.
		//////////////////////////////////////////////////////
		// 그외 특수한 경우 아래와 같이 처리한다.
		//	btnConnect.addActionListener(new ActionListener() {
		//		@Override
		//		public void actionPerformed(ActionEvent e) {}
		//	});
		///////////////////////////////////////////////////////
		// JFrame 윈도우 닫기 - 윈도우 상단 (x) 표 누르면 이벤트 호출 처리
		// super.setDefaultCloseOperation(EXIT_ON_CLOSE))
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				// 윈도우창 Yes/No 창
				int confirm = JOptionPane.showConfirmDialog(null,"종료하시겠습니까?","종료",JOptionPane.YES_NO_OPTION);

				if(confirm == JOptionPane.OK_OPTION) { windowSelfCloseButton(); } 	// Yes 선택후 windownSelfCloseButton() > msgSend() 오픈
				else {																// No선택
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);			// 창을 닫지 않는다.
					return;															// null 리턴값반환만 한다.
				}
			}// windowClosing()
		});// addWinodwListener.newWindowAdapter()
		
		btnConnect.addActionListener(this); // 접속화면 "서버에접속Connection" 버튼 -  Action리스너 달기
		btnExit.addActionListener(this);	// 채팅화면 "종료(q,quit)" 버튼 - Action리스너 달기
		btnSend.addActionListener(this);	// 채팅화면 "전송" 버튼 - Action리스너 달기
		txtInput.addActionListener(this);	// 채팅화면 "채팅입력창" 텍스트박스 - Action리스너 달기
		///////////////////// 이벤트 처리 /////////////////////
	}// GuClient()
	

	
	// 레이아웃 : 로그인 화면
	public void logInScreen() {	

		ImageIcon backIcon1 = new ImageIcon("images/macao1.jpg");


//		logInMenu = new JPanel();// logInMenu패널 초기화(GUClient클래스에서 사용함)
//      logInMenu패널 초기화(GUClient클래스에서 사용함)
		logInMenu = new JPanel(){
	            public void paintComponent(Graphics g) {
	                 Dimension d = getSize();
	                 g.drawImage(backIcon1.getImage(), 0, 0, d.width, d.height, null);
	                 setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	                 super.paintComponent(g);
	            }// paintComponent()
		};// new JPanel()
		
		
		lbAddr = new JLabel("서버 I P : ");				// 레이블 : "서버 I P : "
		lbNickName = new JLabel("대 화 명 : ");				// 레이블 : "대 화 명 : "
		info = new JLabel("IP와 대화명을 입력하시오.");			// 레이블 : "IP와 대화명을 입력하시오.'
		info.setFont(new Font("굴림체", Font.BOLD, 15));	// 레이블(info) : 폰트 글자체,스타일,크기
		info.setForeground(Color.WHITE);				// 레이블(info) : 폰트 컬러
		
//		txtServerIp = new JTextField("192.168.0.40", 15);// 텍스트상자 : 아이피정보
		txtServerIp = new JTextField("127.0.0.1", 15);
		// txtServerIp = new JTextField("localhost", 15);
		txtNickName = new JTextField("Tis", 15);		// 텍스트상자 : 닉네임정보
		btnConnect = new JButton("서버에접속Connection");	// 버튼 : 서버접속
		
		

		// 패널깊이 순서 : logInMenu > logInMenuSubAll > logInMenuSubTop
		// 패널깊이 구성 : logInMenu( logInMenuSubAll(logInMenuSubTop,logInMenuSubBottom) )
		logInMenuSubTop = new JPanel();		
		logInMenuSubBottom = new JPanel();
		logInMenuSubAll = new JPanel();

		// 로그인 화면 바탕 - 투명색
		logInMenuSubTop.setBackground(new Color(255, 0, 0, 0));
		logInMenuSubBottom.setBackground(new Color(255, 0, 0, 0));
		logInMenuSubAll.setBackground(new Color(255, 0, 0, 0));
		
		// 각각의 패널에 컴포넌트를 추가
		logInMenuSubTop.add(lbAddr);
		logInMenuSubTop.add(txtServerIp);
		
		logInMenuSubBottom.add(lbNickName);
		logInMenuSubBottom.add(txtNickName);
		
		logInMenuSubAll.add(logInMenuSubTop);
		logInMenuSubAll.add(logInMenuSubBottom);
		logInMenuSubAll.add(info);
		
		
		logInMenu.add(logInMenuSubAll);// 제일 상위 패널
//		// 컴포넌트 그룹핑 - 제목: 다중채팅화면 
		logInMenu.setBorder(BorderFactory.createTitledBorder("다중채팅화면"));
		logInMenu.setLayout(new BorderLayout());	// logInMenu에서 : BorderLayout() 설정
		logInMenu.add(logInMenuSubAll, "Center");	// logInMenu에서 logInMenuSubAll을 추가 Center로 정렬
		logInMenu.add(btnConnect,"South");			// logInMenu에서 btnConnect을 추가 South로 정렬
		
		
	}// logInScreen()
	
	
	// 레이아웃 : 로그온 채팅창 화면
	public void logOnChatScreen() {
		
		// 로그온 채팅창 화면 배경이미지
		ImageIcon backIcon2 = new ImageIcon("images/macao2.jpg");

		// logOnChatMenu패널 초기화(GUClient클래스에서 사용함)
		logOnChatMenu = new JPanel(){
	            public void paintComponent(Graphics g) {
	                Dimension d = getSize();// JPanel 크기 가져오기
	                g.drawImage(backIcon2.getImage(), 0, 0, d.width, d.height, null); // 크기에 맞춰 이미지 확대축소
	                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	                super.paintComponent(g);
	           }// paintComponent()
		};// new JPanel()
		
		logOnChatMenuSubBottom = new JPanel();
		chatScroll = new JScrollPane();
//		chatScroll.setBounds(41, 56, 267, 40);
		
		


		
		txtInput = new JTextField("", 20);		// 채팅창 채팅입력박스
		btnSend = new JButton("전송");			// 채팅창 전송버튼
		btnExit = new JButton("종료(q,quit)");	// 채팅창 종료버튼
		txtList = new JTextArea();				// 채팅창 채팅출력박스
		chatScroll.setViewportView(txtList);	// 채팅창 스크롤 추가


		// 로그인 화면 바탕 - 투명색
		logOnChatMenuSubBottom.setBackground(new Color(255, 0, 0, 0));
        //Code To make transparent
        chatScroll.getViewport().setOpaque(false);
        chatScroll.setOpaque(false);
        txtList.setOpaque(false);
        //Code To make transparent
		
		
		
		
		// logOnChatMenu > logOnChatMenuSubBottom 각각 그룹핑
		logOnChatMenu.setBorder(BorderFactory.createTitledBorder("♣채팅내용♣"));
		logOnChatMenuSubBottom.setBorder(BorderFactory.createTitledBorder("☆대화하기☆"));
		
		logOnChatMenuSubBottom.add(txtInput);	// logOnChatMenuSubBottom에 txtInput 추가
		logOnChatMenuSubBottom.add(btnSend);	// logOnChatMenuSubBottom에 btnSend 추가
		logOnChatMenuSubBottom.add(btnExit);	// logOnChatMenuSubBottom에 btnExit 추가

		logOnChatMenu.setLayout(new BorderLayout());		// logOnChatMenu패널에 BorderLayout() 적용
		logOnChatMenu.add(chatScroll, "Center");				// logOnChatMenu패널에 JTextArea의 txtList 상자를 추가 Center 정렬
		logOnChatMenu.add(logOnChatMenuSubBottom, "South");	// logOnChatMenu패널에 logOnChatMenuSubBottom패널을 추가 South 정렬

	}// logOnChatScreen()
	
	
	
	
	// 기능 - 로그온채팅화면에서 채팅텍스트박스에서 메세지를 보내기 위해 <enter>를 치면
	// msgSend 호출하여 
	// 문자열을 비교하여 같으면 종료
	// 문자열이 틀리면 텍스트박스의 글을 지우고 다시 마우스를 이동시킨다.
	public void msgSend() {
		
		String text = txtInput.getText();// 채팅글을 text변수에 저장
		
		// 채팅 메세지를 "q"나 "quit" 비교하여 같으면 채팅방을 종료한다.
		if (text.equals("q") || text.equals("quit")) {
			text = "채팅방을 퇴장합니다";
			pw.println(txtNickName.getText() + "님 퇴장합니다 client q입력 send( )메소드\n");
			pw.flush();
			System.out.println("채팅유저 프로그램이 종료됩니다");
			System.exit(1);
		}

		txtInput.setText("");		// txtInput 텍스트박스 글이 지워진다.
		txtInput.requestFocus();	// txtInput 텍스트박스 글이 지워지고 다시 txtInput창으로 마우스를 이동
		pw.println(text);
		pw.flush();	
	}

	
	
	// WindowSelfCloseButton
	public void windowSelfCloseButton() {
		
		txtInput.setText("quit");// 
		msgSend();
	}

	
	// Runnable 상속 처리- 채팅메세지 주고받기
	public void run() {
		try {
			sock = new Socket(ipTxt, PORT); 					// 생성된 윈도우창(Thread) 마다 소켓통신
			String nickName = txtNickName.getText();			// 로그인시 닉네임을 저장
			
			// 소켓으로 내용을 보낸다.
			os = sock.getOutputStream();						// Sock에 OutputStream을 지정 
			pw = new PrintWriter(new OutputStreamWriter(os));	// 프린트장치에(OutputStreamWriter)을 지정
			pw.println(nickName);								// 출력장치(OutputStreamWriter)로 메세지(nickName) 출력
			pw.flush();											// 모든 메세지 출력
			
			// 소켓으로 내용을 받는다.
			InputStream is = sock.getInputStream();				// sock으로 온 내용을 받아서 읽는다.
			br = new BufferedReader(new InputStreamReader(is));	// 버퍼리더로 읽기 처리한다.

			
//////////////////////////////////////////////////////////////////////////////////
			JLabel label1 = new JLabel();
			ImageIcon dog = new ImageIcon("images/3.png");
//			 http://www.java2s.com/Code/Java/Swing-JFC/TextComponentsSamplerDemo.htm
//		    JTextPane textPane = new JTextPane();
//		    StyledDocument doc = textPane.getStyledDocument();
//		    addStylesToDocument(doc);
			//protected void addStylesToDocument(StyledDocument doc) {
			
			
			
			String str;
			while (true) {
				label1.setIcon(dog);
				label1.setText("aaaa");
				str = br.readLine();		// 버퍼리더로 한라인씩 읽어서
				txtList.add(label1);
				txtList.append( str + "\n");	// txtListe상자에 메세지를 추가한다.
				
				


				
				// 채팅창에 스크롤바를 넣고, 엔터 쳣을때 채팅창 마지막으로 가기 위해서 처리
				chatScroll.getVerticalScrollBar().setValue(chatScroll.getVerticalScrollBar().getMaximum());// 채팅창 대화시 하단내용 보여주기
			} // while end
		} catch (Exception e) {}

	} // run end
	
	
	
	
	
	
	// 상속한 리스너의 이벤트 구현
	public void actionPerformed(ActionEvent e) { 	// ActionEvent가 발생하면
		
		Object ob = e.getSource();					// e 객체 리소스를 object타입의 ob객체로 할당
		
		
		// 초기 윈도우 채팅창이 열리면 쓰레드 하나 연다. 
		if (ob == btnConnect) {									// 임의의 ob객체가 btnConect객체와 동일하다면
			cardLayout.show(initMenu, "로그온채팅화면");				// initMenu패널에서 채팅창 검색해서 해당한는 패널을 오픈한다.
			this.setTitle("접속자이름:" + txtNickName.getText());	// 열린창의 제목을 접속자의 닉네임으로 설정
			ipTxt = txtServerIp.getText();						// ipTxt를 로그인창의 아이피정보를 저장한다.
			
			// 쓰레드를 띄워 독립적인 채팅창 하나로 규정후 실행한다.
			// 해당 윈도우(쓰레드) 닫으면 해당 윈도우만 종료한다.
			Thread th = new Thread(this);
			th.start();						// run() 자동 실행
			///////////////////////////////////////////////////////////////
		} else if (ob == btnSend) {		// 임의의 ob객체가 btnConect객체와 동일하다면
			msgSend();
		} else if (ob == txtInput) {	// 임의의 ob객체가 txtInput객체와 동일하다면
			msgSend();
		} else if (ob == btnExit) {		// 임의의 ob객체가 btnExit객체와 동일하다면
			
			// 프린트 객체 이용한 출력
			pw.println(txtNickName.getText() + "님 퇴장합니다 client btnExit \n");
			pw.flush();					// 저장된 내용 뱉어내기
			
			System.exit(1);				// 윈도우 종료(쓰레드 종료)
//			이탈 코드
//
//			실행이 잘되었을 때 0;
//			1, -1, whatever != 0 오류가 발생하면 다른 종류의 오류에 대해 다른 값을 사용할 수 있습니다.
//			올바른 종료 코드가 양수 (예 : UNIX)이고 범위에 따른 경우 :
//
//			1-127는 사용자 정의 코드입니다 (따라서 exit(n)을 호출하여 생성됩니다).
//			128-255는 SIGSEGV 또는 SIGTERM과 같은 다른 유닉스 신호로 인해 종료에 의해 생성 된 코드입니다.
		}// if
		
	}// actionPerformed()

	
	public static void main(String[] args) {
		new GuClient();
	}// main()
	
}// GuClient()





// 레이아웃 인터페이스 화면
	// 로그인창
		// 회원가입
			// 아이디 중복 확인 창
			// 프로필 이미지 선택 창
			// 아이디비밀번호 찾기
	// 채팅창
		// 공지창 열기
			// 공지창 리스트
			// 공지창 읽기
		// 대기자 리스트
			// 프로필보기
			// 쪽지보내기
			// 귓속말보내기
			// 강퇴시키기
			// 방장위임하기
		// 에러창
		// 회원수정
			// 프로필 이미지 선택 창
			// 비밀번호 변경 창
			// 프로필 이미지 선택 창
			// 수정 완료 창
			// 회원 탈퇴 창 > 탈퇴 완료 경고창


// 리스너 설계

// 핸들러 설계
	// 소켓 연결
		// 메세지 전송
			// 메세지 보내기
			// 메세지 받기
				// 일반말 ,귓속말 > 이모티콘 전송 > 종료메세지
		// 공지창 열기
			// 공지창 리스트 열기
				// 공지글 열기
			// 공지창 리스트 닫기








			
