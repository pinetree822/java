package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

////////////////////////////////////////////////////////////////////////////////////////
//로그인창
////////////////////////////////////////////////////////////////////////////////////////
class View0_1_1 extends JPanel {
	private JTextField jTF1;									// 텍스트필드	 - 아이디 입력
	private JPasswordField jPF1;							// 패스워드 필드 - 비밀번호 입력
	private View_Box win;									// 레이아웃 틀 View_Box
	private JLabel jLB1;										// jLB1 레이블 - 아이디
	private JLabel jLB2;										// jLB1 레이블 - 비밀번호
	private JButton jB1;										// jB1 버튼 - 접속
	private JButton jB2;										// jB1 버튼 - 손님화면이동 버튼
	private String cId,cPass;								// cId 관리자아이디(admin), cPass(관리자비번)
	private String id,pass;									// 폼 관리자아이디 입력값, 폼 관리자비밀번호 입력값
	
	public View0_1_1(View_Box win) {
	
		this.win = win;										// View_1_1에 win멤버변수에 Win_Box win 할당
		win.setTitle("당산동맛집-로그인화면(View_1_1)");// Win_Box win 제목 변경
		setLayout(null);										// View_1_1 레이아웃 제거 초기화
		
		jLB1 = new JLabel("아이디");						// jLB1 아이디 제목
		jLB2 = new JLabel("비밀번호");;					// jLB2 비밀번호 제목
		jTF1 = new JTextField();								// jTF1 아이디 텍스트
		jPF1 = new JPasswordField();						// jPF1 비밀번호 텍스트
		jB1 = new JButton("접속");							// jB1 접속 버튼
		jB2 = new JButton("손님메인화면");				// jB1 접속 버튼
		
		
		jLB1.setBounds(31, 40, 67, 15);					// jLB1 아이디제목 위치 크기 설정
		jLB2.setBounds(31, 84, 116, 21);					// jLB2 비밀번호제목 위치 크기 설정
		jTF1.setBounds(123, 40, 116, 15);					// jTF1 아이디텍스트 위치 크기 설정
		jPF1.setBounds(123, 84, 67, 15);					// jPF1 비밀번호텍스트 위치 크기 설정
		jB1.setBounds(10, 114, 70, 20);					// jB1 버튼 위치 크기설정
		jB2.setBounds(80, 114, 140, 20);					// jB1 버튼 위치 크기설정
		//jB1.setLocation(10, 10);
		//jB1.setSize(70, 20);
		
		jTF1.setColumns(10);								// jTF1 아이디텍스트 컬럼 크기 10 설정
		
		add(jLB1);												// View_2에 jLB1 아이디제목 추가		
		add(jLB2);												// View_2에 jLB2 비밀번호제목 추가		
		add(jTF1);												// View_2에 jTF1 아이디텍스트 추가
		add(jPF1);												// View_2에 jPF1 비밀번호텍스트 추가
		add(jB1);												// View_2에 jB1 접속버튼 추가
		add(jB2);												// View_2에 jB2 손님화면이동버튼 추가
		
		jB1.addActionListener( new MyActionListener() );	// jB1 접속버튼에 ActionListener  ( 핸들러 MyActionListener() )
		jB2.addActionListener( new MyActionListener() );	// jB2 손님화면버튼에 ActionListener  ( 핸들러 MyActionListener() )
		jTF1.addKeyListener( new MyActionListener());		// 아이디 입력 TextField에서 키리스너 등록
		jPF1.addKeyListener( new MyActionListener());		// 비밀번호 입력 TextField에서 키리스너 등록
	
	}// public View_1_1(View_Box win)

	public int checkMember() {  							// 관리자 로그인 창
		int result = -1;										// 결과값 확인
		//String pass = null;		
		cId = "admin"; 										// 관리자 아이디 초기화
		cPass = "1234"; 										// 관리자 비밀번호 초기화
		id = jTF1.getText().trim();							// 아이디 TextField에서 텍스트를 공백삭제하고 가져오기
		pass = new String(jPF1.getPassword());			// 비밀번호 PasswordField에서 텍스트를 가져와서 문자열로 바꿔오기
		
		if( id.equals("") || pass.equals("") ){				// 아이디와 비밀번호가 하나라도 공란이라면
			return result;										// 결과값  -1 리턴
		}
		if(cId.equals(id) && cPass.equals(pass)) {		// 아이디와 비밀번호를 비교해서 같다면
			result = 1;										// 결과값  1
		} else {
			result = 0;										// 결과값  0
		}
		return result;											// 결과값 리턴
	}
	class MyActionListener implements ActionListener, KeyListener {
	
		@Override
		public void keyTyped(KeyEvent e) { }	// 키이벤트 관련
		@Override
		public void keyPressed(KeyEvent e) { }	// 키이벤트 관련
		@Override
		public void keyReleased(KeyEvent e) {	// 키이벤트 관련	
			if (e.getKeyCode()==KeyEvent.VK_ENTER){	// 키코드 상수값비교 관련
				if( checkMember() == 1 ){
					JOptionPane.showMessageDialog(null, "관리자페이지로 이동합니다.");			// view_1_1_1 
					win.change("view_2");
				} else if( checkMember() == 0 ){
					JOptionPane.showMessageDialog(null, "아이디 정보가 올바르지 않습니다.");	// view_1_1_2
					win.change("view_1");
				} else {
					JOptionPane.showMessageDialog(null, "양식을 채워주시기 바랍니다..");		// 	view_1_1_3
					jTF1.requestFocus(true);
					//win.change("view_1");
				}
			}
		}// public void keyReleased(KeyEvent e)
		/*
		public void keyPressed(KeyEvent e){ 					// 키가 눌렷을때의 이벤트
		String s = e.getKeyText(e.getKeyCode());			// 키값
		if(e.getKeyCode() == KeyEvent.VK_F1){			// F1누를시
		}else if(e.getKeyChar() == '%'){}					// %눌를시
		}
		*/
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource(); 							// ActionEvent o에 대한 getSource()으로 부터 Object o에 값을 할당한다.
			if(o==jB1){											// 로그인화면 버튼
				if( checkMember() == 1 ){
					JOptionPane.showMessageDialog(null, "관리자페이지로 이동합니다.");			// view_1_1_1
					win.change("view_2");
				} else if( checkMember() == 0 ){
					JOptionPane.showMessageDialog(null, "아이디 정보가 올바르지 않습니다.");	// view_1_1_2
					win.change("view_1_1");
				} else {
					JOptionPane.showMessageDialog(null, "양식을 채워주시기 바랍니다..");		// 	view_1_1_3
					jTF1.requestFocus(true);
					//win.change("view_1");
				}
			} else if(o==jB2){									// 손님화면 버튼 									//win.setTitle("당산동맛집-관리자메인화면(View_2)");	// View_Box 객체인 win에서 Frame 제목을 바꾼다.
				win.change("view_1");							// 패널을 교체하기 위해서 View_Box Frame win 의 change함수에 "view_2"패널명(관리자메인화면)을 전달한다.
			}
		}// public void actionPerformed(ActionEvent e)
		
	}// class MyActionListener implements ActionListener

} //class View_1_1 extends JPanel 


