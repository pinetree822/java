package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


////////////////////////////////////////////////////////////////////////////////////////
//(손님)메인화면
////////////////////////////////////////////////////////////////////////////////////////
//public class View_2 extends JFrame {
class View_2 extends JPanel {
	private View_Box win;										// 레이아웃 틀 View_Box
	private JPanel view_2;
	private JPanel sPanel_1;
	private JPanel sPanel_2;
	private JPanel sPanel_1_1;
	private JPanel sPanel_1_2;
	private JPanel sPanel_2_1;
	private JPanel sPanel_2_2;
	private JTextField txt1;
	private JButton btn3;
	private JButton btn2;
	private JButton btn1;
	private JButton menu1;
	private JButton menu2;
	private JButton menu3;
	private JButton menu4;
	private JButton menu5;
	private JButton lbtn2;
	private JButton lbtn1;
	private JButton lbtn3;
	private JButton lbtn4;

	Vector<String> v=new Vector<String>();
	
	
	public View_2(View_Box win) {							// View_2 생성자의 인자로 온 Win_Box win
		
		///////////////////////////////////////////////////////////////////////////
		/// 메인 설정
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box 객체를 View_2 JPanel의 win 변수에 저장		
		view_2 = this;
		win.setTitle("당산동맛집-관리자메인화면(View_2)");	// View_Box 객체에서 전체레이아웃의 제목 변경
		//setLayout(null);											// View_2 객체 JPanel내 레이아웃 제거후 초기화
		//setBounds(100, 100, 800, 600);
		

		
		///////////////////////////////////////////////////////////////////////////
		/// 패널 초기화 정의
		///////////////////////////////////////////////////////////////////////////
		 sPanel_1 = new JPanel();
		 sPanel_2 = new JPanel();
		 sPanel_1_1 = new JPanel();
		 sPanel_1_2 = new JPanel();
		 sPanel_2_1 = new JPanel(){
			public Insets getInsets(){
				return new Insets(0,0,0,0);
			}
		};
		 sPanel_2_2 = new JPanel();
		FlowLayout fl_sPanel_1_1 = (FlowLayout) sPanel_1_1.getLayout();
		
		///////////////////////////////////////////////////////////////////////////
		/// 상위 검색, 로그인 , 검색분류버튼
		///////////////////////////////////////////////////////////////////////////
		JLabel lbl1 = new JLabel("관리자메인화면");		// 손님메인화면 label
		txt1 = new JTextField();								// 검색 TextField
		btn2 = new JButton("검색");						// 검색 button
		btn3 = new JButton("상점등록");					// 상점등록 button
		btn1 = new JButton("로그아웃");					// 로그아웃 button
		menu1 = new JButton("한식");					// 한식 button
		menu2 = new JButton("중식");					// 중식 button
		menu3 = new JButton("양식");					// 양식 button
		menu4 = new JButton("일식");					// 일식 button
		menu5 = new JButton("기타");					// 기타 button

		///////////////////////////////////////////////////////////////////////////
		/// 상점리스트
		///////////////////////////////////////////////////////////////////////////
		JButton list1 = new JButton("1 상점이름 | 전화번호 | 평점");
		JButton list2 = new JButton("2 상점이름 | 전화번호 | 평점");
		JButton list3 = new JButton("3 상점이름 | 전화번호 | 평점");
		JButton list4 = new JButton("4 상점이름 | 전화번호 | 평점");
		
		///////////////////////////////////////////////////////////////////////////
		/// 상점리스트 커서키
		///////////////////////////////////////////////////////////////////////////
		JButton lbtn2 = new JButton("처음");
		JButton lbtn1 = new JButton("이전");
		JButton lbtn3 = new JButton("다음");
		JButton lbtn4 = new JButton("끝");
		
		///////////////////////////////////////////////////////////////////////////
		/// 패널 레이아웃 설정
		///////////////////////////////////////////////////////////////////////////
		view_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		view_2.setLayout(new BorderLayout(0, 0));
		sPanel_1.setLayout(new BorderLayout(0, 0));
		sPanel_1_2.setLayout(new GridLayout(0, 5, 0, 0));
		sPanel_2.setLayout(new BorderLayout(0, 0));
		sPanel_2_1.setLayout(new GridLayout(0, 1, 800, 0));
		
		///////////////////////////////////////////////////////////////////////////
		/// 패널백그라운드
		///////////////////////////////////////////////////////////////////////////
		view_2.setBackground(Color.BLUE);
		sPanel_1.setBackground(Color.MAGENTA);
		sPanel_2.setBackground(Color.CYAN);
		sPanel_1_1.setBackground(Color.PINK);
		sPanel_1_2.setBackground(Color.ORANGE);
		sPanel_2_1.setBackground(Color.YELLOW);
		sPanel_2_2.setBackground(Color.GREEN);
		
		///////////////////////////////////////////////////////////////////////////
		/// 컴포넌트 패널에 추가
		///////////////////////////////////////////////////////////////////////////
		view_2.add(sPanel_1, BorderLayout.NORTH);
		view_2.add(sPanel_2, BorderLayout.CENTER);
		sPanel_1.add(sPanel_1_1, BorderLayout.NORTH);
		sPanel_1.add(sPanel_1_2, BorderLayout.SOUTH);
		sPanel_2.add(sPanel_2_1, BorderLayout.NORTH);
		sPanel_2.add(sPanel_2_2, BorderLayout.SOUTH);
		sPanel_1_1.add(lbl1);// 손님메인화면 label
		sPanel_1_1.add(txt1);// 검색 TextField
		sPanel_1_1.add(btn2);// 검색 button
		sPanel_1_1.add(btn3);// 상점등록 button
		sPanel_1_1.add(btn1);// 로그아웃 button
		sPanel_1_2.add(menu1);		
		sPanel_1_2.add(menu2);		
		sPanel_1_2.add(menu3);		
		sPanel_1_2.add(menu4);		
		sPanel_1_2.add(menu5);
		sPanel_2_1.add(list1);
		sPanel_2_1.add(list2);		
		sPanel_2_1.add(list3);		
		sPanel_2_1.add(list4);		
		sPanel_2_2.add(lbtn1);
		sPanel_2_2.add(lbtn2);		
		sPanel_2_2.add(lbtn3);		
		sPanel_2_2.add(lbtn4);
		
		///////////////////////////////////////////////////////////////////////////
		/// 정렬및 기타
		///////////////////////////////////////////////////////////////////////////
		fl_sPanel_1_1.setAlignment(FlowLayout.RIGHT);
		list1.setHorizontalAlignment(SwingConstants.LEFT);		
		list2.setHorizontalAlignment(SwingConstants.LEFT);
		list3.setHorizontalAlignment(SwingConstants.LEFT);
		list4.setHorizontalAlignment(SwingConstants.LEFT);
		txt1.setToolTipText("");
		txt1.setColumns(15);
		
		///////////////////////////////////////////////////////////////////////////
		/// 리스너 등록
		///////////////////////////////////////////////////////////////////////////
		txt1.addKeyListener( new MyActionListener());			// 검색 TextField
		btn3.addActionListener( new MyActionListener() );		// 검색 button
		btn2.addActionListener( new MyActionListener() );		// 검색 button
		btn1.addActionListener( new MyActionListener() );		//로그인 button
		menu1.addActionListener( new MyActionListener() );	// 한식 button
		menu2.addActionListener( new MyActionListener() );	// 중식 button
		menu3.addActionListener( new MyActionListener() );	// 양식 button
		menu4.addActionListener( new MyActionListener() );	// 일식 button
		menu5.addActionListener( new MyActionListener() );	// 기타 button

		lbtn2.addActionListener( new MyActionListener() );	// 처음 button
		lbtn1.addActionListener( new MyActionListener() );	// 이전 button
		lbtn3.addActionListener( new MyActionListener() );	// 다음 button
		lbtn4.addActionListener( new MyActionListener() );	// 끝 button
		
		
	}// public View_2()
	
	///////////////////////////////////////////////////////////////////////////
	/// 함수 등록
	///////////////////////////////////////////////////////////////////////////
	public int shopFind() {  								// 상점검색
		int result = -1;										// 결과값 확인
		String find =txt1.getText().trim();					// 검색 TextArea에서 텍스트를 공백삭제하고 가져오기
		
		if( find.equals("") ){									// 검색어가 공란이라면
			return result;										// 결과값  -1 리턴
		}
		if( find=="" ) {										// 검색어 결과값을 비교한다.
			result = 1;										// 결과값  1
		} else {
			result = 0;										// 결과값  0
		}
		return result;											// 결과값 리턴 => 나중에 검색 결과 배열을 가져와 리스트로 전달한다.
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	/// 리스너 등록
	/// View_Box win 의 change() 함수에 패널교환 대상 문자열"view_2" 을 전달한다.
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
				if( shopFind() == 1 ){
					JOptionPane.showMessageDialog(null, "검색합니다.");						// view_
					// 리스트를 변경한다.
				} else if( shopFind() == 0 ){
					JOptionPane.showMessageDialog(null, "허용하지 않는 문자열입니다.");	// view_
				} else {
					JOptionPane.showMessageDialog(null, "검색어가 공란입니다..");			// 	view_
					txt1.requestFocus(true);
				}
			}
		}// public void keyReleased(KeyEvent e)		
		
		///////////////////////////////////////////////////////////////////////////
		/// actionPerformed 이벤트 정의
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) { 			// ActionListener에서 이벤트 발생하면 자동호출되는 ActionEvent 인자값을 갖는 actionPerformed함수
			Object o=e.getSource(); 								// ActionEvent o에 대한 getSource()으로 부터 Object o에 값을 할당한다.
			if(o==btn2 ){				// 검색 button
				if( shopFind() == 1 ){
					
					/*String str=txt1.getText();
					char search=str.charAt(1);*/
					
					
					JOptionPane.showMessageDialog(null, "검색합니다.");						// view_
					
				} else if( shopFind() == 0 ){
					JOptionPane.showMessageDialog(null, "허용하지 않는 문자열입니다.");	// view_
				} else {
					JOptionPane.showMessageDialog(null, "검색어가 공란입니다..");			// 	view_
					txt1.requestFocus(true);
				}
			} else if(o==btn1 ){		// 로그아웃 button
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다..");	// view_5
				win.change("view_1_1");
			} else if(o==menu1 ){	// 한식 button
				JOptionPane.showMessageDialog(null, "한식전문점입니다.");
			} else if(o==menu2 ){	// 중식 button
				JOptionPane.showMessageDialog(null, "중식전문점입니다.");
			} else if(o==menu3 ){	// 양식 button
				JOptionPane.showMessageDialog(null, "양식전문점입니다.");
			} else if(o==menu4 ){	// 일식 button
				JOptionPane.showMessageDialog(null, "일식전문점입니다.");
			} else if(o==menu5 ){	// 기타 button
				JOptionPane.showMessageDialog(null, "기타전문점입니다.");
			} else if(o==btn3){
				JOptionPane.showMessageDialog(null, "상점등록 페이지로 이동합니다.");
				win.change("View_up");
			}
	
	}// public void actionPerformed(ActionEvent e)

	}// class MyActionListener implements ActionListener	
}//class View_2 extends JPanel





















