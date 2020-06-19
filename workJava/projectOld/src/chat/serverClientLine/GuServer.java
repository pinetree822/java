package chat.serverClientLine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;




public class GuServer extends Frame implements ActionListener {

	TextArea txt_list;			// 텍스트글상자 - 서버현황 창
	JButton btn_exit;			// 버튼 - 서버종료
	ServerSocket ss = null;		// 서버소켓 - 통신관리자 선언
	Vector user = new Vector();	// 배열 - 채팅참여자 목록 가상 저장소 - 서버객체마다 전체 공유
	

	

	
	// txt_list 서버현황을 업데이트 시키는 기능
	public void setMsg(String msg) {
		txt_list.append(msg);
	}// setMsg()

	
	// serverStart() 실행 - 서버 실행
	public void severStart(){
		
		final int PORT = 7500; // 서버 통신 포트 설정
		
		////////////////////////
		// 서버/클라이언트 통신 실행 구간
		////////////////////////
		try {

			System.out.println("서버 통신 시작 \n");					// 콘솔에 서버현황 입력
			txt_list.append("서버 통신 시작 \n");						// 텍스트박스에 서버현황 입력
			txt_list.setFont(new Font("굴림", Font.BOLD, 14));	// 텍스트박스 폰트클래스로 서체 설정
			
			
			/////////////////// 통신 시작 /////////////////// 
			ss = new ServerSocket(PORT);
			
			while(true) {
				
				Socket sock = ss.accept();// 소켓연결자 초기화및 연결관리 객체(sock)
				String ipAddr = sock.getInetAddress().getHostAddress();// 소켓이 열리고 연결되면 ip정보를 반환 > 문자열반환
				txt_list.append(ipAddr);// 서버의 텍스트박스에 ipAddr정보를 입력
				
				// 통신 핸들러 쓰레드 사용 시작///////////////////////
				GuSHandle ch= new GuSHandle(this, sock);// 핸들러 객체에 구현된 쓰레드의 (GuServer및 소켓<sock>)전달
				user.addElement(ch);// 서버에 user배열<Vector가상메모리>에 각각의 핸들러(사용자 정보값)을 저장
				ch.start();// 각각의 핸들러 객체에 구현된 쓰레드를 시작시킨다.(각각의 클라이언트와 연결된 핸들러가 작동된다.)
				// 통신 핸들러 쓰레드 사용 끝///////////////////////
				
				
				
			}// while	
			/////////////////// 통신 시작 /////////////////// 
			
			
		} catch (Exception e) {
			
		}// try
		////////////////////////
		// 서버/클라이언트 통신 실행 구간
		////////////////////////
		
	}// serverStart()
	
	
	
	
	
	
	
	// GuServer클래스 초기화
	public GuServer() {
		
		super("Gu채팅 서버");
		
		// 객체 생성
		txt_list = new TextArea(); 			// 참여자 참가/탈퇴및 채팅글 서버현황 보여주기
		btn_exit = new JButton("서버종료");	// 서버 종료 버튼 : 창 닫기
		
		// 객체 설정
		txt_list.setBackground(Color.CYAN);	// 텍스트에리어 : 백그라운드 색
		
		// Gu에 객체 추가
		add(txt_list, "Center");			// 프레임: 텍스트에리어 추가 , 정렬-Center
		add(btn_exit, "South");				// 프레임: 버튼 추가 , 정렬-South
		
		// Gu에 설정
		setSize(450, 800);					// 프레임: 크기 450, 800
		setVisible(true);					// 프레임: 보이기
		
		
		// Gu 클래스 Implements ActionListener(구현필요)
		// btn_exit 버튼에 리스너 설정한다.
		btn_exit.addActionListener(this);// Gu클래스가 ActionListener를 상속해서 Gu자체(this)를 전달가능
		
		// 윈도우 창 종료 리스너 - Frame의 window객체에서 지원
		// 상속받아 WindowAdater를 구현한다.
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {
            	System.out.println("서버 통신 종료");	// 콘솔에 서버현황 입력
    			txt_list.append("서버 통신 종료 \n");		// 텍스트박스에 서버현황 입력
                dispose();
            }
        });
        
        /////////////////////////
        severStart();// 서버 시작
        /////////////////////////

		// 5단계 리스너를 연결 --> 리스너핸들러 ListenerHandler
//		this.btnsend.addActionListener(this);
//		this.btnexit.addActionListener(this);
	}// GuServer()
	
	// Gu 클래스 Implements ActionListener(구현필요) - 이벤트 구현에 필요하다.
	// btn_exit.addActionListener, this.addWindowListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// ActionEvent 발생시 e를 참조하여 "btn_exit" 객체인지 확인
		if(e.getSource()==btn_exit) {
        	System.out.println("서버 통신 종료");	// 콘솔에 서버현황 입력
			txt_list.append("서버 통신 종료 \n");		// 텍스트박스에 서버현황 입력
			System.exit(0);						// system 팩키지에서 지원 - 프로그램 종료
		}
	}// actionPerformed()
	
	
	
	public static void main(String[] args) {
		new GuServer();// GuServer 클래스 초기화및 객체화
	}// main()
	
}// class GuServer
