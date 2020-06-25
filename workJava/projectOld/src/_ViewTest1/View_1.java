package _ViewTest1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;






////////////////////////////////////////////////////////////////////////////////////////
//(손님)메인화면
////////////////////////////////////////////////////////////////////////////////////////
//public class View_1 extends JFrame {
class View_1 extends JPanel {
	private View_Box win;										// 레이아웃 틀 View_Box
	private JPanel view_1;
	private JPanel sPanel_1;
	private JPanel sPanel_2;
	private JPanel sPanel_1_1;
	private JPanel sPanel_1_2;
	private JPanel sPanel_2_1;
	private JPanel sPanel_2_2;
	private JTextField txt1;
	private JButton btn2;
	private JButton btn1;
	private JButton menu1;
	private JButton menu2;
	private JButton menu3;
	private JButton menu4;
	private JButton menu5;
	private JButton lbtn1;
	private JButton lbtn2;
	private JButton lbtn3;
	private JButton lbtn4;
	//private ShopMemberList shopList;	//상점자동리스트
	//protected int shopMemberView;		//상점회원보기 번호
	
	
	public View_1(View_Box win) {							// View_1 생성자의 인자로 온 Win_Box win
		
		///////////////////////////////////////////////////////////////////////////
		/// 메인 설정
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box 객체를 View_1 JPanel의 win 변수에 저장		
		view_1 = this;
		win.setTitle("당산동맛집 -  화면(" + this.getClass().getName() +")");	// View_Box 객체에서 전체레이아웃의 제목 변경
		//win.setTitle("당산동맛집-손님메인화면(View_1)");	// View_Box 객체에서 전체레이아웃의 제목 변경
		//setLayout(null);											// View_1 객체 JPanel내 레이아웃 제거후 초기화
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
		JLabel lbl1 = new JLabel("손님메인화면");		// 손님메인화면 label
		txt1 = new JTextField();								// 검색 TextField
		btn1 = new JButton("로그인");			// 로그인 button
		btn2 = new JButton("검색");				// 검색 button
		menu1 = new JButton("한식");			// 한식 button
		menu2 = new JButton("중식");			// 중식 button
		menu3 = new JButton("양식");			// 양식 button
		menu4 = new JButton("일식");			// 일식 button
		menu5 = new JButton("기타");			// 기타 button
		
	
		///////////////////////////////////////////////////////////////////////////
		/// 패널 레이아웃 설정
		///////////////////////////////////////////////////////////////////////////
		view_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		view_1.setLayout(new BorderLayout(0, 0));
		sPanel_1.setLayout(new BorderLayout(0, 0));
		sPanel_1_2.setLayout(new GridLayout(0, 5, 0, 0));
		sPanel_2.setLayout(new BorderLayout(0, 0));
		sPanel_2_1.setLayout(new GridLayout(0, 1, 800, 0));
		
		///////////////////////////////////////////////////////////////////////////
		/// 패널백그라운드
		///////////////////////////////////////////////////////////////////////////
		view_1.setBackground(Color.BLUE);
		sPanel_1.setBackground(Color.MAGENTA);
		sPanel_2.setBackground(Color.CYAN);
		sPanel_1_1.setBackground(Color.PINK);
		sPanel_1_2.setBackground(Color.ORANGE);
		sPanel_2_1.setBackground(Color.YELLOW);
		sPanel_2_2.setBackground(Color.GREEN);
		
		///////////////////////////////////////////////////////////////////////////
		/// 컴포넌트 패널에 추가
		///////////////////////////////////////////////////////////////////////////
		sPanel_1_2.add(menu1);		// 한식
		sPanel_1_2.add(menu2);		// 중식
		sPanel_1_2.add(menu3);		// 양식
		sPanel_1_2.add(menu4);		// 일식
		sPanel_1_2.add(menu5);		// 기타
		
		view_1.add(sPanel_2, BorderLayout.CENTER);
		sPanel_2.add(sPanel_2_1, BorderLayout.NORTH);
		sPanel_2.add(sPanel_2_2, BorderLayout.SOUTH);
		view_1.add(sPanel_1, BorderLayout.NORTH);
		sPanel_1.add(sPanel_1_1, BorderLayout.NORTH);
		sPanel_1_1.add(lbl1);		// 관리자메인화면 label
		sPanel_1_1.add(txt1);		// 검색박스
		sPanel_1_1.add(btn2);		// 검색버튼
		sPanel_1_1.add(btn1);		// 로그인버튼
		sPanel_1.add(sPanel_1_2, BorderLayout.SOUTH);

		
		
		
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////////
		/// 상점자동리스트
		///////////////////////////////////////////////////////////////////////////
		//win.shopList =new ShopMemberList();	// 상점자동리스트
		//win.shopList.dataGetLoader();				// 상점데이타 리스트 로딩
		if( win.shopList.getNowpage() <= 1 ) {
			win.shopList.setNowpage(1);				// 첫페이지 로딩
		}
		win.shopList.previewList(win,sPanel_2_1);	// 상점데이타로 리스트를 화면 프린트
		
		
		
		///////////////////////////////////////////////////////////////////////////
		/// 상점리스트 네비게이션 커서키 컴포넌트 패널에 추가
		///////////////////////////////////////////////////////////////////////////
		lbtn1 = new JButton("처음");
		lbtn2 = new JButton("이전");
		lbtn3 = new JButton("다음");
		lbtn4 = new JButton("끝");
		
		sPanel_2_2.add(lbtn1);		// 처음
		sPanel_2_2.add(lbtn2);		// 이전
		sPanel_2_2.add(lbtn3);		// 다음
		sPanel_2_2.add(lbtn4);		// 끝

		lbtn1.addActionListener( new MyActionListener() );	// 처음 button
		lbtn2.addActionListener( new MyActionListener() );	// 이전 button
		lbtn3.addActionListener( new MyActionListener() );	// 다음 button
		lbtn4.addActionListener( new MyActionListener() );	// 끝 button

		
		
		///////////////////////////////////////////////////////////////////////////
		/// 정렬및 기타
		///////////////////////////////////////////////////////////////////////////
		fl_sPanel_1_1.setAlignment(FlowLayout.RIGHT);
		txt1.setToolTipText("");
		txt1.setColumns(15);
		
		///////////////////////////////////////////////////////////////////////////
		/// 리스너 등록
		///////////////////////////////////////////////////////////////////////////
		txt1.addKeyListener( new MyActionListener());			// 검색 TextField
		btn2.addActionListener( new MyActionListener() );		// 검색 button
		btn1.addActionListener( new MyActionListener() );		// 로그인 button
		
		menu1.addActionListener( new MyActionListener() );	// 한식 button
		menu2.addActionListener( new MyActionListener() );	// 중식 button
		menu3.addActionListener( new MyActionListener() );	// 양식 button
		menu4.addActionListener( new MyActionListener() );	// 일식 button
		menu5.addActionListener( new MyActionListener() );	// 기타 button

        
	}// public View_1()



	
	
	
	///////////////////////////////////////////////////////////////////////////
	/// 함수 등록 - 상점검색
	///////////////////////////////////////////////////////////////////////////
	public int shopFind() {  										// 상점검색
		int result = -1;												// 결과값 확인
		String find =txt1.getText().trim();						// 검색 TextArea에서 텍스트를 공백삭제하고 가져오기
		
		if( find.equals("") ){										// 검색어가 공란이라면
			return result;											// 결과값  -1 리턴
		}
		if( find=="" ) {												// 검색어 결과값을 비교한다.
			result = 1;												// 결과값  1
		} else {
			result = 0;												// 결과값  0
		}
		return result;												// 결과값 리턴 => 나중에 검색 결과 배열을 가져와 리스트로 전달한다.
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	/// 리스너 등록
	//
	/// View_Box win 의 change() 함수에 패널교환 대상 문자열을 전달한다. 
	/// 화면구상도의 패널구성 목록의 "view_2" 형식으로 전달한다.
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
		public void actionPerformed(ActionEvent e) { 						// ActionListener에서 이벤트 발생하면 자동호출되는 ActionEvent 인자값을 갖는 actionPerformed함수
			Object o=e.getSource(); 												// ActionEvent o에 대한 getSource()으로 부터 Object o에 값을 할당한다.
			//JOptionPane.showMessageDialog(null, "페이지 클릭.");		// + o.toString()
			if(o==btn2 ){		// 검색 button
				if( shopFind() == 1 ){
					JOptionPane.showMessageDialog(null, "검색합니다.");						// view_
					// 리스트를 변경한다.
				} else if( shopFind() == 0 ){
					JOptionPane.showMessageDialog(null, "허용하지 않는 문자열입니다.");	// view_
				} else {
					JOptionPane.showMessageDialog(null, "검색어가 공란입니다..");			// 	view_
					txt1.requestFocus(true);
				}				
			} else if(o==btn1 ){		// 로그인 button
				JOptionPane.showMessageDialog(null, "로그인화면으로 이동합니다.");			// view_1_1_1
				win.logLevel = 0;// 로그온 확인
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
			} else if(o==lbtn1) {	//처음
				JOptionPane.showMessageDialog(null, "첫페이지 클릭.");
				//win.shopList = new ShopMemberList();				// 상점자동리스트 - 실시간 관리가 필요할때 변화는 자료 계속 읽음
				//win.shopList.dataGetLoader();							// 초기화 리스트 데이타 리스트 재로딩 - 계속 추가 되므로 해제 새로운 리스트 읽을 함수 필요
				win.shopList.setNowpage(win.shopList.getFirstpage());	// 처음페이지 얻어서 현재 페이지 설정
				win.shopList.previewList(win,sPanel_2_1);				// 현재페이지 기준으로 페이지리스트 프린트
	
			} else if(o==lbtn2) {	//이전버튼
				JOptionPane.showMessageDialog(null, "이전 클릭.");
				//win.shopList = new ShopMemberList();				// 상점자동리스트
				//win.shopList.dataGetLoader();							// 초기화 리스트 데이타 리스트 재로딩
				int tmpPrevBtn = win.shopList.getPrevpage();		// ShopMemberList를 초기화 시켜서 이전에 값을 받아서 저장해서 Prev페이지 네이비게이션 값으로 쓴다.
				win.shopList.setNowpage(tmpPrevBtn);				// 이전페이지 얻어서 현재 페이지 설정
				win.shopList.previewList(win,sPanel_2_1);				// 현재페이지 기준으로 페이지리스트 프린트
				
			} else if(o==lbtn3) {	//다음버튼
				JOptionPane.showMessageDialog(null, "다음 클릭.");
				//win.shopList = new ShopMemberList();				// 상점자동리스트
				//win.shopList.dataGetLoader();							// 초기화 리스트 데이타 리스트 재로딩
				int tmpNextBtn = win.shopList.getNextpage();		// ShopMemberList를 초기화 시켜서 이전에 값을 받아서 저장해서 Next페이지 네이비게이션 값으로 쓴다.
				win.shopList.setNowpage(tmpNextBtn);				// 처음페이지 얻어서 현재 페이지 설정
				win.shopList.previewList(win,sPanel_2_1);				// 현재페이지 기준으로 페이지리스트 프린트
				
			} else if(o==lbtn4) {	//끝버튼
				/* 변수확인 경고창
						JOptionPane.showMessageDialog(null, "검증 = win.shopList.getAllpage = " + (win.shopList.getAllpage()*1) + ", 검증 = win.shopList.getLastpage = " + win.shopList.getLastpage()*1 + ", 검증 = win.shopList.getNowpage = " + win.shopList.getNowpage()*1);			// view_1_1_1
				 */
				JOptionPane.showMessageDialog(null, "끝페이지 클릭.");
				win.shopList.setNowpage(win.shopList.getLastpage());	// 처음페이지 얻어서 현재 페이지 설정
				win.shopList.previewList(win,sPanel_2_1);				// 현재페이지 기준으로 페이지리스트 프린트
			} else {
			}
		} // public void actionPerformed(ActionEvent e)
	
	}// class MyActionListener implements ActionListener	


}//class View_1 extends JPanel

