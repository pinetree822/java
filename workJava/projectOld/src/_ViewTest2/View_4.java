package _ViewTest2;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class View_4 extends JPanel {

	private View_Box win;
	private JPanel view_4;
	JLabel lb1,lb2,lb3,lb4,lb5;
	static JTextField tf1,tf2,tf3,tf4;
	static JTextArea ta1;
	JButton b1,b2;
	JPanel p,p1,p2,p3,p4,p5;
//	Vector<String> v=new Vector<String>();
	/*Vector<Integer> v2=new Vector<Integer>();*/

	public View_4(View_Box win){							// View_4 생성자의 인자로 온 Win_Box win
		///////////////////////////////////////////////////////////////////////////
		/// 메인 설정
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box 객체를 View_1 JPanel의 win 변수에 저장		
		view_4 = this;
		
		//win.setTitle("관리자 등록 페이지(Biew_up)");
		win.setTitle("당산동맛집 - 관리자 등록 페이지 화면(" + this.getClass().getName() +")");	// View_Box 객체에서 전체레이아웃의 제목 변경
		GridLayout g=new GridLayout(5,0);
		setLayout(g);
		
		lb1=new JLabel("식당 이름"); tf1=new JTextField(20);
		lb2=new JLabel("대표 메뉴"); tf2=new JTextField(20);
		lb3=new JLabel("전화번호");  tf3=new JTextField(20);
		lb4=new JLabel("위       치"); tf4=new JTextField(20);
								  /* ta1=new JTextArea(30,50);*/
		
		b1=new JButton("저장 완료");
		b2=new JButton("뒤로가기");		
		
		p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p1);
		p1.add(lb1); p1.add(tf1);

		
		p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p2);
		p2.add(lb2); p2.add(tf2);
		
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p3);
		p3.add(lb3); p3.add(tf3);
		
		p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p4);
		p4.add(lb4); p4.add(tf4);
		add(p4);
		
		p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p5); p5.add(b1); p5.add(b2); 				//<== 버튼 중앙에 위치시키기  
		

		///////////////////////////////////////////////////////////////////////////
		/// 리스너 등록
		///////////////////////////////////////////////////////////////////////////
		b1.addActionListener( new MyActionListener());			// 저장완료
		b2.addActionListener( new MyActionListener() );		// 뒤로가기
		
		
		setSize(800,600);
		setVisible(true);		
		/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
	}//////////////////
	

	
	///////////////////////////////////////////////////////////////////////////
	/// 리스너 등록
	//
	/// View_Box win 의 change() 함수에 패널교환 대상 문자열을 전달한다. 
	/// 화면구상도의 패널구성 목록의 "view_2" 형식으로 전달한다.
	/// 리스너의 ActionListener를 구현한 MyActionListener핸들러 정의 
	///////////////////////////////////////////////////////////////////////////
	class MyActionListener implements ActionListener {
		
		///////////////////////////////////////////////////////////////////////////
		/// actionPerformed 이벤트 정의
		///////////////////////////////////////////////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) { 					// ActionListener에서 이벤트 발생하면 자동호출되는 ActionEvent 인자값을 갖는 actionPerformed함수
			Object o=e.getSource(); 										// ActionEvent o에 대한 getSource()으로 부터 Object o에 값을 할당한다.
			
			if(o==b1) { // <-- 공백일때도 등록 완료 되는 것
				// 회원추가 테스트
//				String name=tf1.getText(); String menu=tf2.getText();
//				String tel=tf3.getText();  String addr=tf4.getText();
//				v.add(name); v.add(menu); v.add(tel); v.add(addr);

				Member insertMember = new Member(22, "s21", "1234", "s22.PNG", "뉴욕스테이션", "양식", "070-7209-0556", "서울 영등포구 당산동6가 331-6", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 2, "./m22.PNG","불고기상하이,4700|함박스테이크,44400", "f22_1.PNG|f22_2.PNG");

				win.shopList = new ShopMemberList();				// 상점자동리스트
				win.shopList.dataGetLoader();							// 초기화 리스트 데이타 리스트 재로딩
				if( win.shopList.setInsertMember( insertMember ) ) {
					JOptionPane.showMessageDialog(null, insertMember.allPrint());
				}else {
					JOptionPane.showMessageDialog(null, "입력실패");
				}
				JOptionPane.showMessageDialog(null, "등록 완료"); 					//등록완료후 관리자메인 리스트로 //null 메시지창 윈도우 중앙에//
				win.shopList.setNowpage(win.shopList.getNowpage());				// 이동전 페이지 얻어서 현재 페이지 설정
				win.logLevel = win.logLevel;// 로그온 확인
				win.change("View_2");
			} else if(o==b2) {
				JOptionPane.showMessageDialog(null, "관리자 페이지로 이동합니다.");
				win.shopList.setNowpage(win.shopList.getNowpage());				// 이동전 페이지 얻어서 현재 페이지 설정
				win.logLevel = win.logLevel;// 로그온 확인
				win.change("View_2");
			}//	if		
		} // public void actionPerformed(ActionEvent e)
	
	}// class MyActionListener implements ActionListener	
	
	
}// public class View_4 extends JPanel implements ActionListener
