package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


////////////////////////////////////////////////////////////////////////////////////////
//(관리자)메인화면
////////////////////////////////////////////////////////////////////////////////////////
class View0_2 extends JPanel {
	private View_Box win;										// 레이아웃 틀 View_Box
	private JButton jB1;											// 샘플 글버튼 관리자화면
	private JButton jB2;											// 샘플 글버튼 로그인화면
	private JTextArea jTA1;										// 샘플 글상자
	private JScrollPane jSP1;									// 샘플 글상자 감싸는 JScrollPane
	
	public View0_2(View_Box win) {
	
		this.win = win;											// View_2에 win멤버변수에 Win_Box win 할당
		win.setTitle("당산동맛집-관리자메인화면(View_2)");	// Win_Box win 제목 변경
		setLayout(null);											// View_2 레이아웃 제거 초기화
		
		
		// 사용되는 변수에 객체 할당
		jB1 = new JButton("손님화면");						// jB1 관리자화면 버튼
		jB2 = new JButton("로그아웃");						// jB2 로그인화면 버튼
		jTA1 = new JTextArea();								// jTA1 글상자 초기화
		jSP1 = new JScrollPane( jTA1 );						// jTA1 을 감싸는 jSP1 ScrollPane 초기화
		
		// 버튼,상자 크기및 View_1 JPanel에서 위치 조정
		jB1.setBounds(10, 10, 140, 20);						// View_2객체 JPanel에서 jB1 버튼 위치 크기 설정
		jB2.setBounds(150, 10, 90, 20);						// View_2객체 JPanel에서 jB2 버튼 위치 크기 설정
		
		jSP1.setBounds(10, 40, 200, 150);						// View_2안에 jSP1 스크롤 위치
		
		// View_2 JPanel에 버튼,상자 추가
		add(jB1);													// View_2객체 JPanel에 jB1 버튼 추가
		add(jB2);													// View_2객체 JPanel에 jB2 버튼 추가
		add(jSP1);													// View_2객체 JPanel에 jSP1 TextArea 추가
		
		// jB1버튼을 누르면 이벤트발생하는지 이벤트 감시자인 리스너종류 중 ActionListener 부착 ( 핸들러를 익명 MyActionListener() ) 를 추가한다.
		jB1.addActionListener( new MyActionListener() );
		jB2.addActionListener( new MyActionListener() );
	
	}// public view_2(View_Box win)
	
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource(); 							// ActionEvent o에 대한 getSource()으로 부터 Object o에 값을 할당한다.
			if(o==jB1){											// 손님화면 버튼 									//win.setTitle("당산동맛집-관리자메인화면(View_2)");	// View_Box 객체인 win에서 Frame 제목을 바꾼다.
				win.change("view_1");							// 패널을 교체하기 위해서 View_Box Frame win 의 change함수에 "view_2"패널명(관리자메인화면)을 전달한다.
			} else if(o==jB2){ 									// 로그아웃화면 버튼
				// View_
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다..");	// view_5
				win.change("view_1_1");
			}
		}
	}// class MyActionListener implements ActionListener


} //class JPanel02 extends JPanel 