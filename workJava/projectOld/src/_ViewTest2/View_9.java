package _ViewTest2;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Array;
import java.util.StringTokenizer;
// 상점정보
public class View_9 extends JPanel {

	private View_Box win;												// 레이아웃 틀 View_Box
	private JPanel view_9;
	private ShopMemberList shopList;								//	상점자동리스트
	protected String errContext1="";									// - 에러처리 내용 : db에서 내용 파싱을 많이 하는곳 
	protected int errNum1=0;										// - 에러관련 번호
	protected JTabbedPane mTpanel_1, mTpanel_2;
	//JLabel lb, shopContext, lb2, lb2_1, , lb3_1;

	protected JLabel shopImg, foodImg_1, foodImg_2, foodImg_3;
	protected JLabel shopContext, foodContext_1, foodContext_2, foodContext_3;
	protected JLabel mapPanel;
	protected JTextArea ta, ta2, ta3;
	protected JButton bBack;														// 이전으로
	//protected JButton b1, b2, b3;												// 이전,처음,끝
	protected JPanel layerPanel_1, layerPanel_1_2, layerPanel_2, layerPanel_3;
	protected JTextPane jmTpanel_2;												// jmTpanel_2JTextPane 		- 지도
	protected JPanel layerMapPanel;												// layerMapPanel - JPanle		- 지도
	
	
	
	public View_9(View_Box win) {
		///////////////////////////////////////////////////////////////////////////
		/// 메인 설정
		///////////////////////////////////////////////////////////////////////////
		this.win = win;																						// View_Box 객체를 View_1 JPanel의 win 변수에 저장		
		view_9 = this;
		win.setTitle("당산동맛집-" + win.VectorShopMemberInfo.getName() +"화면(" + this.getClass().getName() +")");	// View_Box 객체에서 전체레이아웃의 제목 변경
		//JOptionPane.showMessageDialog(null, win.shopList.getNextpage() );
		//System.out.println( win.shopList.getNowpage() );

		//JOptionPane.showMessageDialog(null, win );
		
		/*
		// setLayout(null);																					// View_1 객체 JPanel내 레이아웃 제거후 초기화
		// setBounds(100, 100, 800, 600);
		// setSize(800, 600);
 		//win.VectorShopMemberInfo
		//fBox.VectorShopMemberInfo --> View_Box에서 VectorShopMemberInfo변수에 Member 데이타 저장
		//JOptionPane.showMessageDialog(null, win.VectorShopMemberInfo.getNum() );	

 		*/
		String tmpShopContext ="";																		// 맛집 요약 소개
		tmpShopContext += ("업체명 : " + win.VectorShopMemberInfo.getName() +"\n");
		tmpShopContext += ("업종 : " + win.VectorShopMemberInfo.getType() +"\n");
		tmpShopContext += ("전화번호 : " + win.VectorShopMemberInfo.getTel() +"\n");
		tmpShopContext += ("주소 : " + win.VectorShopMemberInfo.getJuso() +"\n");
		tmpShopContext += ("평점 : ") ;
		int maxRank = 5;
		for(int i=0; i<maxRank; i++){
			if ( i <= win.VectorShopMemberInfo.getRanking() ) tmpShopContext += "★";
			else tmpShopContext += "☆";
		}
		//tmpShopContext += (win.VectorShopMemberInfo.getNum() +"\n\n");	
		
		

		/////////////////////////////////////////////////////////////////////////////////////////
		/// 메인 초기화
		/////////////////////////////////////////////////////////////////////////////////////////
		// 레이아웃 패널
		mTpanel_1=new JTabbedPane(JTabbedPane.LEFT);			// 탭을 갖는 패널
		mTpanel_1.setPreferredSize(new Dimension(800, 600)); 		// 1단계 메뉴 싸이즈 조정
		Font font_1=new Font("Dialog",Font.BOLD,18);					// 폰트 Dialog Bold체 18싸이즈 설정 초기화

		//상점소개 레이어
		JPanel layerPanel_1=new JPanel(new BorderLayout());		// 버튼제외한 컴포넌트 속한 레이어
		JPanel layerPanel_1_2=new JPanel(new FlowLayout());			// 네비게이션 버튼이 속한 레이어
		
		//Container cp=this.getContentPane();							// 컨테이너패널 정보 가져오기
		// 상위레이어
		view_9.add(mTpanel_1, "Center");									// 상위 메뉴및 기타 컴포넌트들 내용
		view_9.add(layerPanel_1_2, "South");								// 버튼이 속한 레이어
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		/// 맛집소개
		/////////////////////////////////////////////////////////////////////////////////////////
		mTpanel_1.add("맛집소개", layerPanel_1);// 1단계 메뉴
		shopContext=new JLabel();
		JTextPane shopContext_Text=new JTextPane();						// shopContext_Text - JTextPane - 
		shopContext_Text.setText(tmpShopContext);							// 상점소개 텍스트 설정
		shopContext_Text.setFont(new Font("Gothic", Font.BOLD, 15));	// 상점소개 텍스트에레어(shopContext_Text) 폰트 설정
		shopImg=new JLabel(new ImageIcon("images/" + win.VectorShopMemberInfo.getShopimg()));		// 상점소개 - 이미지
		layerPanel_1.add(shopImg, "North");
		layerPanel_1.add(shopContext_Text, "Center");


		/////////////////////////////////////////////////////////////////////////////////////////
		// 메뉴관련
		/////////////////////////////////////////////////////////////////////////////////////////
		//메뉴
		mTpanel_1.add(mTpanel_2=new JTabbedPane(JTabbedPane.LEFT),"메뉴"); // 1단계 메뉴
		
		
		// 음식정보 	- 배열(음식이름,음식가격|음식이름,음식가격)
		// 이미지 		- 배열(음식이미지|음식이미지)
		//getFolist;			// 김치말이냉국수,7000|불맛더덕구이,16000
		//getFolistimg;		// f1_1.PNG|f1_2.PNG
		String foSpliter1 = "\\|";			// folist 1차 문자열 분리자
		String foSpliter2 = ",";				// folist 2차 문자열 분리자
		String foimgSpliter1 = "\\|";		// folistimg 1차 문자열 분리자
		try {
			// java.lang.NullPointerException	// for문까지 발생가능함
			// indexOverflow
			// 
			String[] folistToArr1 = win.VectorShopMemberInfo.getFolist().split(foSpliter1);					// 음식메뉴리스트(이름,가격) 배열
			String[] folistimgToFilename = win.VectorShopMemberInfo.getFolistimg().split(foSpliter1);	// 음식이미지리스트
			String[] folistToFood = new String[(folistToArr1.length)];		// 음식메뉴 이름
			String[] folistToPrice = new String[(folistToArr1.length)];		// 음식메뉴 가격
	
			for (int i=0; i<folistToArr1.length; i++) {// 배열은 여러개 일수 있다.
				String[] folistToArr2 = folistToArr1[i].split(foSpliter2);
				if( (Integer.valueOf((folistToArr2.length/2))).intValue() != 1 ) { break; }					// 배열이 2개의 값이 아니라면 비정상적인 값일 경우다. ( Exception 발생 시켜야 됨 )
				if( (Integer.valueOf((folistToArr2.length%2))).intValue() == 1 ) { break; }				// 배열이 2개의 값이 아니라면 비정상적인 값일 경우다. ( Exception 발생 시켜야 됨 )
			     for(int k=0; k < folistToArr2.length; k++) {				// 배열은 2개뿐이다
			    	if( k == 0 ) folistToFood[i] = folistToArr2[k];			// 첫번째는 음식이름
			    	else if ( k == 1 ) folistToPrice[i] = folistToArr2[k];		// 두번째는 가격
			     }
			}
	
	
			// 음식메뉴 초기화
			JPanel[] menuPanes = new JPanel[folistToFood.length]; 			// 음식메뉴리스트 배열
			JLabel[] menufoodImg = new JLabel[folistToFood.length]; 		// 음식이미지리스트 배열
			JLabel[] menuContext = new JLabel[folistToFood.length]; 		// 음식내용리스트 배열
			
			for(int i=0; i < menuPanes.length; i++) {
				menuPanes[i] = new JPanel(new BorderLayout());													// 음식메뉴리스트
				menufoodImg[i] = new JLabel(new ImageIcon("images/" + folistimgToFilename[i])); 		// 음식이미지리스트
				menuContext[i] = new JLabel("가격 : " + folistToPrice[i] + "원"); 								// 음식내용리스트folistToPrice
				//menuContext[i] = new JLabel("묶은지와 제주돼지가 어우러진 제육볶음 입니다. 가격은 15,000원!"); 	// 음식내용리스트
				menuPanes[i].add(menufoodImg[i], "Center");
				menuPanes[i].add(menuContext[i], "South");
				mTpanel_2.add(folistToFood[i], menuPanes[i]);						// mTpanel_2Panel에 1번째 메뉴바 menuPane_1 Panel 추가			
			}
		} catch (NullPointerException e) {
			// http://soonrok.tistory.com/114 참고
			errNum1++;
			errContext1 = ("알수없는에러가 났읍니다.");
		} catch( IndexOutOfBoundsException e) {
			errNum1++;
			errContext1 = ("알수없는에러가 났읍니다.");
		} catch (Exception e) {
			errNum1++;
			errContext1 = "";
		} finally {
			// 로그인 체크
			if(errNum1 > 0 ) {
				win.logLevel = win.logLevel; // 회원레벨 그대로 저장해서 넘겨주기
				win.change("view_2"); 
			}
		}

//java.lang.NullPointerException	// for문까지 발생가능함


		


		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		/// Map 정보 
		/////////////////////////////////////////////////////////////////////////////////////////

		jmTpanel_2=new JTextPane();												// jmTpanel_2JTextPane 		- 지도
		jmTpanel_2.setFont(new Font("Gothic", Font.BOLD, 14));				// 지도(jmTpanel_2) 폰트설정  - 
		// jmTpanel_2 지도설명
		jmTpanel_2.setText(win.VectorShopMemberInfo.getMapinfo());
		mapPanel=new JLabel(new ImageIcon("images/" + win.VectorShopMemberInfo.getMapimg()));			// mapPanel 이미지 추가 		- 지도

		layerMapPanel=new JPanel(new BorderLayout());						// layerMapPanel - JPanle		- 지도
		layerMapPanel.add(mapPanel, "Center");									// 지도패널 - mapPanel 지도 이미지 추가
		layerMapPanel.add(jmTpanel_2, "South");								// 지도패널 - shopContext_Text - JTextPane 추가
		mTpanel_1.add("찾아 오는 길",layerMapPanel);							// 1단계 메뉴 -  mTpanel_1패널에 layerMapPanel Panel 지도 추가
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		/// 네비게이션 하단 버튼
		/////////////////////////////////////////////////////////////////////////////////////////
		bBack=new JButton("이전으로");
		//b2=new JButton("처음");
		//b3=new JButton("앞으로");
		
		layerPanel_1_2.add(bBack);// 버튼 이전으로 추가
		//layerPanel_1_2.add(b2);// 버튼 처음으로 추가
		//layerPanel_1_2.add(b3);// 버튼 앞으로 추가

		/////////////////////////////////////////////////////////////////////////////////////////
		/// 상점정보 텍스트 변경
		/////////////////////////////////////////////////////////////////////////////////////////

		
		//lb2_1.setFont(f);// 1번째 JLable>메뉴설명>폰트 설정
		//lb2_1.setFont(f);// 2번째 JLable>메뉴설명>폰트 설정
		

		setVisible(true);// Frame 보이기 설정

		
		///////////////////////////////////////////////////////////////////////////
		/// 리스너 등록
		///////////////////////////////////////////////////////////////////////////
		bBack.addActionListener( new MyActionListener() );		// 검색 button
		
		//손님 리뷰 (게시판 형식)
		/*ta3=new JTextArea("손님 리뷰");
		mTpanel_1.add(new JScrollPane(ta3), "손님 리뷰");*/
		
		//찾아오는 길
		//mTpanel_1.setPreferredSize(new Dimension(770, 520));/// 싸이즈 맞추기
		//mTpanel_2.setPreferredSize(new Dimension(300, 300));/// 싸이즈 맞추기		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자-----------------------------


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
			//JOptionPane.showMessageDialog(null, "페이지 클릭.");	// + o.toString()
			if(o==bBack ){					// 검색 button
				win.logLevel = win.logLevel;// 회원레벨 그대로 저장해서 넘겨주기
				if (win.logLevel == 1 )	win.change("view_2");
				else win.change("view_1");
			} else {
			}
		} // public void actionPerformed(ActionEvent e)
	
	}// class MyActionListener implements ActionListener	
	
	
	

}