package _ViewTest1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


////////////////////////////////////////////////////////////////////////////////////////
//로그인창
////////////////////////////////////////////////////////////////////////////////////////
//public class View_1_1 extends JFrame {
class View_1_1 extends JPanel {
	private View_Box win;				// 레이아웃 틀 View_Box
	private JPanel view_1_1;			// 현재 화면 객체
	private JLabel lbId;					// 비밀번호 아이디
	private JLabel lbPwd;				// 비밀번호 레이블
	private JTextField txtId;				// 비밀번호 텍스트 상자
	private JPasswordField txtPwd;	// 비밀번호 암호텍스트 상자
	private JButton btLogin;			// 로그인 버튼
	private JButton btCancel;			// 취소 버튼
	private JButton bt_login_out;// 로그아웃 테스트 하기 위해 만든 객체
	
	
	public View_1_1(View_Box win) {							// View_1_1 생성자의 인자로 온 Win_Box win
		
		///////////////////////////////////////////////////////////////////////////
		/// 메인 설정
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box 객체를 View_1_1 JPanel의 win 변수에 저장		
		view_1_1 = this;
		//win.setTitle("당산동맛집-로그인화면(View_1_1)");
		win.setTitle("당산동맛집 - 로그인화면(" + this.getClass().getName() +")");	// View_Box 객체에서 전체레이아웃의 제목 변경
		//setLayout(null);											// View_1_1 객체 JPanel내 레이아웃 제거후 초기화
		//setBounds(100, 100, 350, 274);
		setBounds(100, 100, 800, 600);
		

		///////////////////////////////////////////////////////////////////////////
		/// 패널 초기화 정의
		///////////////////////////////////////////////////////////////////////////
		lbId = new JLabel("아이디");
		lbPwd = new JLabel("비밀번호");
		txtId = new JTextField();
		txtPwd = new JPasswordField();
		btLogin = new JButton("로그인");
		btCancel = new JButton("취소");
		bt_login_out = new JButton("로그아웃");// 로그아웃 테스트 하기 위해 만든 객체

		///////////////////////////////////////////////////////////////////////////
		/// 패널 레이아웃 설정
		///////////////////////////////////////////////////////////////////////////
		//log_main = new JPanel();
		view_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		//win.setContentPane(log_main);
		view_1_1.setLayout(null);
		
		///////////////////////////////////////////////////////////////////////////
		/// 정렬,위치 기타
		///////////////////////////////////////////////////////////////////////////
		txtId.setColumns(10);	
		txtPwd.setColumns(10);

		
		
		lbId.setBounds(267, 196, 57, 15);
		lbPwd.setBounds(267, 239, 57, 15);
		txtId.setBounds(349, 193, 116, 21);	
		txtPwd.setBounds(349, 236, 116, 21);
		
		btLogin.setBounds(246, 291, 97, 23);
		btCancel.setBounds(368, 291, 97, 23);
		//bt_login_out.setBounds(175, 154, 97, 23);
		
		///////////////////////////////////////////////////////////////////////////
		/// 컴포넌트 패널에 추가
		///////////////////////////////////////////////////////////////////////////
		view_1_1.add(lbId);
		view_1_1.add(lbPwd);
		view_1_1.add(txtId);
		view_1_1.add(txtPwd);
		
		view_1_1.add(btLogin);
		view_1_1.add(btCancel);
		//log_main.add(bt_login_out);


		
		///////////////////////////////////////////////////////////////////////////
		/// 리스너 등록
		///////////////////////////////////////////////////////////////////////////
		txtId.addKeyListener( new MyActionListener());							// 아이디 유효성
		txtPwd.addKeyListener( new MyActionListener());						// 비밀번호 유효성
		btLogin.addActionListener( new MyActionListener() );					// 검색 button
		btCancel.addActionListener( new MyActionListener() );				// 로그인 button		
		
	}// public View_1_1()
	
	///////////////////////////////////////////////////////////////////////////
	/// 함수 등록
	///////////////////////////////////////////////////////////////////////////
	public int checkMember() {  							// 관리자 로그인 창
		int result = -1;										// 결과값 확인
		//String pass = null;		
		String cId = "admin"; 										// 관리자 아이디 초기화
		String cPass = "1234"; 										// 관리자 비밀번호 초기화
		String id = txtId.getText().trim();							// 아이디 TextField에서 양쪽 공백 삭제하고 문자열 가져오기
		String pass = new String(txtPwd.getPassword());		// 비밀번호 PasswordField에서 텍스트를 가져와서 문자열로 바꿔오기

		if( id.equals("") || pass.equals("") ){						// 아이디와 비밀번호가 하나라도 공란이라면
			return result;												// 결과값  -1 리턴
		}
		if(cId.equals(id) && cPass.equals(pass)) {				// 아이디와 비밀번호를 비교해서 같다면
			result = 1;												// 결과값  1
		} else {
			result = 0;												// 결과값  0
		}
		return result;													// 결과값 리턴
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	/// 리스너 등록
	/// View_Box win 의 change() 함수에 패널교환 대상 문자열"view_1_1" 을 전달한다.
	/// 리스너의 ActionListener를 구현한 MyActionListener핸들러 정의 
	///////////////////////////////////////////////////////////////////////////
	class MyActionListener implements ActionListener, KeyListener {
		
		///////////////////////////////////////////////////////////////////////////
		/// key 이벤트 정의
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void keyTyped(KeyEvent e) { }	// 키이벤트 관련
		@Override
		public void keyPressed(KeyEvent e) { }	// 키이벤트 관련
		@Override
		public void keyReleased(KeyEvent e) {	// 키이벤트 관련	
			if (e.getKeyCode()==KeyEvent.VK_ENTER){	// 키코드 상수값비교 관련

				Object o=e.getSource(); 										// 이벤트발생된 객체 할당
				String findId = txtId.getText().trim();							// 아이디 TextField에서 양쪽 공백 삭제하고 문자열 가져오기
				String findPwd = new String(txtPwd.getPassword());		// 비밀번호 PasswordField에서 텍스트를 가져와서 문자열로 바꿔오기
				
				if( findId.equals("") ){
					JOptionPane.showMessageDialog(null, "아이디가 공란입니다.");
					txtId.requestFocus(true);
				} else if( findPwd.equals("") ){	
					JOptionPane.showMessageDialog(null, "비밀번호가 공란입니다.");
					txtPwd.requestFocus(true);
				} else {
					//JOptionPane.showMessageDialog(null, "인증중입니다.");
					if( checkMember() == 1 ){
						JOptionPane.showMessageDialog(null, "관리자페이지로 이동합니다.");			// 관리자페이지 이동
						win.logLevel = 1;// 로그온 확인
						win.change("view_2");
					} else if( checkMember() == 0 ){
						JOptionPane.showMessageDialog(null, "아이디 정보가 올바르지 않습니다.");	// 손님페이지 이동
						win.change("view_1");
						win.logLevel = 0;// 관리자/손님/회원 분류
					} else {
						JOptionPane.showMessageDialog(null, "양식을 채워주시기 바랍니다.");		// 	다시 재입력
						txtId.requestFocus(true);
						//win.change("view_1");
					}
				}
			}
		}// public void keyReleased(KeyEvent e)		

		
		///////////////////////////////////////////////////////////////////////////
		/// actionPerformed 이벤트 정의
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) { 								// ActionListener에서 이벤트 발생하면 자동호출되는 ActionEvent 인자값을 갖는 actionPerformed함수
			Object o=e.getSource(); 													// ActionEvent o에 대한 getSource()으로 부터 Object o에 값을 할당한다.
			String findId = txtId.getText().trim();							// 아이디 TextField에서 양쪽 공백 삭제하고 문자열 가져오기
			String findPwd = new String(txtPwd.getPassword());		// 비밀번호 PasswordField에서 텍스트를 가져와서 문자열로 바꿔오기
			
			if( (o==btLogin & findId.equals("")) ){
				JOptionPane.showMessageDialog(null, "아이디가 공란입니다.");
				txtId.requestFocus(true);
			} else if(  (o==btLogin & findPwd.equals("")) ){	
				JOptionPane.showMessageDialog(null, "비밀번호가 공란입니다.");
				txtPwd.requestFocus(true);
			}
			
			if(o==btLogin ){																// 로그인 button
				//JOptionPane.showMessageDialog(null, "인증중입니다.");
				if( checkMember() == 1 ){
					JOptionPane.showMessageDialog(null, "관리자페이지로 이동합니다.");			// 관리자페이지 이동
					win.logLevel = 1;// 로그온 확인
					win.change("view_2");
				} else if( checkMember() == 0 ){
					JOptionPane.showMessageDialog(null, "아이디 정보가 올바르지 않습니다.");	// 손님페이지 이동
					win.logLevel = 0;// 로그온 확인
					win.change("view_1");
				} else {
					JOptionPane.showMessageDialog(null, "양식을 채워주시기 바랍니다.");		// 	다시 재입력
					txtId.requestFocus(true);
				}	
			} else if(o==btCancel ){																	// 취소 button
				JOptionPane.showMessageDialog(null, "손님페이지로 이동합니다.");
				win.logLevel = 0;// 로그아웃 확인
				win.shopList.setNowpage(1);	// 처음페이지 얻어서 현재 페이지 설정
				win.change("view_1");
			} else {
			}
			
		} // public void actionPerformed(ActionEvent e)
	
	}// class MyActionListener implements ActionListener	


}//class View_1_1 extends JPanel

