package _ViewTest2;
// 구글 검색 : 자바 다이얼로그
// https://www.google.co.kr/search?q=%EC%9E%90%EB%B0%94+%EC%B0%BD&oq=%EC%9E%90%EB%B0%94+%EC%B0%BD&aqs=chrome..69i57j69i65j69i61l2.4773j0j8&{google:bookmarkBarPinned}sourceid=chrome&{google:omniboxStartMarginParameter}ie=UTF-8#q=%EC%9E%90%EB%B0%94+%EB%8B%A4%EC%9D%B4%EC%96%BC%EB%A1%9C%EA%B7%B8
// Dialog - 모달
// [Java] 자바 Swing JDialog를 부모 JFrame 중앙에 띄우기 // http://kwangshin.pe.kr/blog/2012/10/08/java-%EC%9E%90%EB%B0%94-swing-jdialog%EB%A5%BC-%EB%B6%80%EB%AA%A8-jframe-%EC%A4%91%EC%95%99%EC%97%90-%EB%9D%84%EC%9A%B0%EA%B8%B0/
// http://egloos.zum.com/happy2ni/v/2837922
// http://ddoriya.tistory.com/entry/JAVA-swing-custum-Dialog-%EB%A7%8C%EB%93%A4%EA%B8%B0
// 자바 윈도우창 만들기(글쓰기, 이미지 넣기) - http://zinlee.tistory.com/122
// [JAVA] GUI 때 창 크기 변경 못하게 하는 방법 - http://howhelove.tistory.com/22

// 경고메세지 - 아이디/비밀번호 입력해주세요.
// http://hsp1116.tistory.com/3
// http://ibabo.tistory.com/250

// 구글검색 - 자바 스윙 화면 전환
// https://www.google.co.kr/search?q=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98&oq=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98&aqs=chrome..69i57.8403j0j8&{google:bookmarkBarPinned}sourceid=chrome&{google:omniboxStartMarginParameter}ie=UTF-8
// http://blog.naver.com/PostView.nhn?blogId=battledocho&logNo=220012083751

// 구글검색 - 자바 스윙 데이타 .txt 저장
// https://www.google.co.kr/search?q=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98&oq=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98&aqs=chrome..69i57.8403j0j8&{google:bookmarkBarPinned}sourceid=chrome&{google:omniboxStartMarginParameter}ie=UTF-8#q=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%EB%8D%B0%EC%9D%B4%ED%83%80+.txt+%EC%A0%80%EC%9E%A5
// http://mwultong.blogspot.com/2006/10/java-text-file-write.html
// http://castleone88.blogspot.kr/2016/02/javatextarea_12.html
// http://seinarin.tistory.com/41
// http://gnujava.com/board/article_view.jsp?article_no=4292&board_no=1&table_cd=EPAR01&table_no=01
// http://1bestcsharp.blogspot.kr/2015/04/java-io-how-to-export-jtable-data-to-txt-File-In-Java.html

// 구글검색 - 자바 txt 파일 검색
// http://www.yunsobi.com/blog/153
// http://www.yunsobi.com/blog/543
// http://mantdu.tistory.com/731


// 구글검색 - 자바 이미지 파일 저장 검색
// http://develop88.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EB%B6%88%EB%9F%AC%EC%99%80%EC%84%9C-%EC%88%98%EC%A0%95-%ED%9B%84-%EC%A0%80%EC%9E%A5
// http://ithub.tistory.com/15
// http://gnujava.com/board/article_view.jsp?article_no=7139&menu_cd=16&board_no=3&table_cd=EPAR01&table_no=01
// http://blog.naver.com/PostView.nhn?blogId=milki0110&logNo=40042663065&redirect=Dlog&widgetTypeCall=true
// https://www.google.co.kr/search?biw=1097&bih=735&q=%EC%9E%90%EB%B0%94+%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8+txt+%EC%A0%80%EC%9E%A5&sa=X&ved=0ahUKEwjmyv-1ysbPAhWHoZQKHfYPBnAQ1QIIZygA#q=%EC%9E%90%EB%B0%94+%EC%9D%B4%EB%AF%B8%EC%A7%80+%ED%8C%8C%EC%9D%BC+%EC%A0%80%EC%9E%A5+%EA%B2%80%EC%83%89
// http://jang8584.tistory.com/154
// http://jp1020.tistory.com/entry/java-image-%EC%A0%80%EC%9E%A5
// http://goppa.tistory.com/entry/JAVA-Graphics-%EC%9E%90%EB%B0%94-14-ImageIO%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-JPG-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%A0%80%EC%9E%A5
// http://13clover.tistory.com/120
// http://egloos.zum.com/unibest/v/1023453

// 구글검색 - 자바 파일 저장 경로
// http://sexy.pe.kr/tc/763
// JFileChooser, 열기 창, 저장 창, 파일 선택 창, Swing - http://blog.naver.com/PostView.nhn?blogId=cracker542&logNo=40119977325&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView

// 구글검색 - 자바 JOptionPane 자세한 글
// http://hallang.tistory.com/139
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

////////////////////////////////////////////////////////////////////////////////////////
// toDo : 
////////////////////////////////////////////////////////////////////////////////////////
class V_log{}				// 기록
class V_debug{}			// 디버그툴
class V_logon{}			// 로그온 세션 클래스 만들기, 로그온체크, 로그인, 로그아웃 처리
class V_session{}		// 로그온DB
class V_accessrole{}		// 접근관리(service,DB,userAccess),회원레벨,회원그룹
class V_network{}		// 네트워크
class V_category{}		// 카테고리관리툴
class V_img{}				// 이미지 관련(싸이즈조정, 포맷변경, 텍스쳐,기타
class V_g2d{}				// 2디 그래픽 엔진
class V_g3d{}				// 3디 그래픽 엔진
class V_game{}			// 게임엔진
class V_unit{}				// objectToUnit
class V_add{}				// 데이타 압축
class V_timecontrol	{}	// 시간제어
class V_editor{}			// 에디터(그래픽,파일,동영상,네트워크)
class V_shoppingmall{}	// 쇼핑몰
class V_apimanager{}	// 외부서비스 api관리
class V_contentmanager{}	// 외부서비스연동관리



////////////////////////////////////////////////////////////////////////////////////////
//전체 레이아웃 컨트롤
////////////////////////////////////////////////////////////////////////////////////////
public class View_Box extends JFrame {

	private JPanel contentPane;						// Frame을 상속한 View_Box 객체 안에 초기화 레이아웃패널관리매니저
	protected int logLevel = 0;						// 로그인 검증하기 위한 변수 
	protected ShopMemberList shopList;			// 상점자동리스트
	protected int shopMemberListView;				// 폐기 - 회원번호 전달
	protected Member VectorShopMemberInfo;	// 상점보기에 상점회원을 전달하기 위해 만든 전역변수 View_Box에서만 쓰는 변수
	//Launch the application	
	public static void main(String[] args) {
		// EventQueue.invokeLate( new Runnable(){ public void run(){} } );
		// http://m.blog.daum.net/creazier/15309465 참고
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					View_Box win = new View_Box();		// View_Box.frame 객체
					
					win.setTitle("당산동맛집");				// View_Box.frame 제목 초기화
					win.add(new View_1(win));				// View_Box.frame에 손님메인화면 교체 초기화			// win.view_1 = new View_1(win);					//win.view_2 = new View_2(win);					//win.add(win.view_1);					// View_Box에 손님메인화면 교체

					
					
					win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// View_Box.frame 자동닫기
					win.setSize(820, 710);												// View_Box.frame 싸이즈
					win.setVisible(true);													// View_Box.frame 보이기		// View_Box frame = new View_Box();					//frame.setVisible(true);
					win.setResizable(false);												// ViewFrame 창 불가능 조절
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // public void run()
			
		});// EventQueue.invokeLater(new Runnable()
		
	}// public static void main(String[] args)

	
	// Create the frame
	public View_Box() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo.png"));	// View_Box.frame 상단아이콘		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);							// View_Box.frame 닫기시 종료
		setBounds(100, 100, 800, 600);													// View_Box.frame window내 위치
		this.setLocationRelativeTo(null);													// View_Box 스크린 중앙 정렬 			///Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();		frame.setLocation((dim.width/2)-(frame.getWidth()/2), (dim.height/2)-(frame.getHeight()/2));

		
		contentPane = new JPanel();														// View_Box.frame 레이아웃패널관리매니저 초기화
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));							// View_Box.frame 레이아웃패널관리매니저 공백보더지정
		contentPane.setLayout(new BorderLayout(0, 0));								// View_Box.frame 레이아웃패널관리매니저 레이아웃매니저 지정
		setContentPane(contentPane);														// View_Box.frame의 레이아웃패널관리매니저 지정

	} // public View_Box()
	
	

	public void change(String panelName) {
		
		// 기본 메인 패널 삭제
		// setContentPane(contentPane) 										// View_Box Frame 내 컨테츠 제공자 설정 등록
		// getContentPane().removeAll()										// View_Box Frame 내 등록된 모든 컨테츠 리스트 삭제
		// getContentPane().add(tmpPanel,BorderLayout.CENTER)		// View_Box Frame 내 tmpPanel 추가 등록
		// setContentPane(getJContentPane()) 								// View_Box Frame 내 tmpPanel을 컨테츠 제공자로 설정 등록
		getContentPane().removeAll();
		JPanel tmpPanel = new JPanel();										// 패널객체 저장해서 다른 의도로 사용하기 위해 선언 정의해둠(예를 들어 히스토리 기능)
		if( panelName.equalsIgnoreCase("view_2") ) {
			getContentPane().add( tmpPanel=new View_2(this) );			// 관리자메인화면 교체	
			
		} else if( panelName.equalsIgnoreCase("view_1") ) {
			getContentPane().add( tmpPanel=new View_1(this) );			// 손님메인화면 교체
			
		} else if( panelName.equalsIgnoreCase("view_1_1") ) {
			getContentPane().add( tmpPanel=new View_1_1(this) );		// 로그인화면 교체	
			
		} else if( panelName.equalsIgnoreCase("view_4") ) {
			getContentPane().add( tmpPanel=new View_4(this) );			// 상점회원등록화면 교체	
			
		} else if( panelName.equalsIgnoreCase("view_9") ) {
			getContentPane().add( tmpPanel=new View_9(this) );			// 상점회원보기화면 교체	
			
		} else { // view_1
			getContentPane().add( tmpPanel=new View_1(this) );			// 손님메인화면 교체		
			
		}

		//tmpPanel.getLocation();
		//tmpPanel.setLocation(10, 600);
		revalidate(); 									// frame 재확인
		repaint();										// frame 다시 그리기	
	} // public void change(String panelName)

	
} //public class View_Box extends JFrame



class MemberManager{}// 회원관리용도로 선언한 클래스

// 상점회원 게시판리스트 전용 + 회원데이타 import  
// 임시 회원관리(추가,수정,삭제)
class ShopMemberList{
	
	Vector<Member> shopmem = new Vector<Member>();			// 상점리스트 담는 벡터객체
    Vector<JButton> listButton = new Vector<JButton>();			// 상점리스트를 구현하는 버튼저장하는 벡터객체
    Member insertmember;												// 회원추가
    Member updatemember;												// 회원수정
    Member deletemember;												// 회원삭제
    Member recoverymember;												// 회원복구
    int lineperpage = 8;													// 페이지당 상점수
    int firstpage;																// 첫페이지
    int allpage;																// 총페이지
    int nowpage;															// 현재페이지 0-9, 10-19, 20-29
    //int shopcnt;															// 상점수
    //int nextpage;															// 다음페이지
    //int prevpage;															// 이전페이지
    //int lastpage;															// 끝페이지
    
    
	public void ShopMembeList(){}

	///////////////////////////////////////////////////////////////////////////
	/// 상점자동리스트 - 데이타 로드
	/// 벡터계열로 디비화 해서 구현
	//  toDo : 게시판 하단 번호페이지 카운터(1,2,3,..8,9,10)까지 구현 - 변수줘서 조절가능
	//  toDo : 게시판 하단 번호페이지 좌우 10개 30개 건너뛰기 네이비게이션 구현 - 변수줘서 조절가능
	/// toDo : 현재 텍스트 파일을 임시 디비로 만들계획
	/// toDo : 향후 RDBMs(오라클,Mysql,Mssql등),NoSql,Mongo,In-memory,Sqlite 연결클래스에 Db데이타 로드할 목적으로 만든 함수
	/// toDo : 참조나 데이타를 끌어오기 위한 참조구현
	///////////////////////////////////////////////////////////////////////////	 
	public void dataGetLoader(){       
		// 기초데이타
        // shopmem 끝에 추가(데이타 추가)
        shopmem.addElement(new Member(1, "s1", "1234", "s1.PNG", "알천세뚜리", "한식", "02-0268-8652", "서울 영등포구 당산동6가 216-2 지하1층", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 4, "./m1.PNG","김치말이냉국수,7000|불맛더덕구이,16000", "f1_1.PNG|f1_2.PNG"));// shopmem 끝에 추가(데이타 추가)
        shopmem.addElement(new Member(2, "s2", "1234", "s2.PNG", "종가집", "한식", "02-2633-8033", "서울 영등포구 당산동5가 20", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 3, "./m2.PNG","뚝배기불고기,5000|곱창전골,9000|된장찌게,7000", "f2_1.PNG|f2_2.PNG|f2_3.PNG"));
        shopmem.addElement(new Member(3, "s3", "1234", "s3.PNG", "너도나도식당", "한식", "02-2634-5467", "서울 영등포구 영등포구 양평동 5가 57-1", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 1, "./m3.PNG","제육볶음,15000~30000|우렁된장,5000|오징어볶음,7000", "f3_1.PNG|f3_2.PNG|f3_3.PNG"));
        shopmem.addElement(new Member(4, "s4", "1234", "s4.PNG", "길풍식당", "한식", "02-2634-1359", "서울 영등포구 양평동4가 56", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 2, "./m4.PNG","꼬리탕,16000|설렁탕,9000", "f4_1.PNG|f4_2.PNG"));
        shopmem.addElement(new Member(5, "s5", "1234", "s5.PNG", "빨간찬장", "한식", "02-2637-8989", "서울 영등포구 양평동4가 192", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 5, "./m5.PNG","석쇠불고기,8000|카레라이스,6000|부대찌개,9000", "f5_1.PNG|f5_2.PNG|f5_3.PNG"));
        shopmem.addElement(new Member(6, "s6", "1234", "s6.PNG", "강남", "중식", "02-2633-8124", "서울 영등포구 당산동5가 42", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 2, "./m6.PNG","짜장면,5000|삼선짬뽕,9000|탕수육,12000", "f6_1.PNG|f6_2.PNG|f6_3.PNG"));
        shopmem.addElement(new Member(7, "s7", "1234", "s7.PNG", "홍콩반점", "중식", "02-2676-5892", "서울 영등포구 당산동6가 399-2", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 1, "./m7.PNG","짜장면,4000|짬뽕,4500|탕수육,8500", "f7_1.PNG|f7_2.PNG|f7_3.PNG"));
        shopmem.addElement(new Member(8, "s8", "1234", "s8.PNG", "삼성원", "중식", "02-2634-1140", "서울 영등포구 당산동4가 73-12", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 2, "./m8.PNG","짜장면,5000|해물짬뽕,7000|탕수육,10000", "f8_1.PNG|f8_2.PNG|f8_3.PNG"));
        shopmem.addElement(new Member(9, "s9", "1234", "s9.PNG", "준이네당산양꼬치", "중식", "02-2678-5999", "서울 영등포구 당산동6가 216-2", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 4, "./m9.PNG","양꼬치,11000", "f9_1.PNG"));
        shopmem.addElement(new Member(10, "s10", "1234", "s10.PNG", "홍짜장", "중식", "02-2631-0875", "서울 영등포구 당산동5가 32-1", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 3, "./m10.PNG","짜장면,4000|짬뽕,4500|탕수육,8500", "f10_1.PNG|f10_2.PNG|f10_3.PNG"));
        shopmem.addElement(new Member(11, "s11", "1234", "s11.PNG", "시로우마", "일식", "02-0268-8652", "서울 영등포구 양평동4가 278-3 1층", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 5, "./m11.PNG","오늘의 초밥(12pcs),16000|모듬초밥(14pcs),21000|연어초밥(14pcs),51000", "f11_1.PNG|f11_2.PNG"));
        shopmem.addElement(new Member(12, "s12", "1234", "s12.PNG", "히어로멘", "일식", "02-538-5166", "서울 영등포구 당산동5가 9-3", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 5, "./m12.PNG","돈코츠라멘,7000|소유라멘,7000|미소라멘,9000", "f12_1.PNG|f12_2.PNG|f12_3.PNG"));
        shopmem.addElement(new Member(13, "s13", "1234", "s13.PNG", "잘난돈가스", "일식", "02-3667-1357", "서울 영등포구 양평동4가 121", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 3, "./m13.PNG","잘난돈가스,5000|치즈돈가스,6000|소세지돈가스,8000", "f13_1.PNG|f13_2.PNG|f13_3.PNG"));
        shopmem.addElement(new Member(14, "s14", "1234", "s14.PNG", "하네코참치", "일식", "02-2677-5633", "서울 영등포구 당산동5가 33-6 한성장모텔 1층", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 2, "./m14.PNG","특참치,39000|모듬참치,29000|스페셜참치,50000", "f14_1.PNG|f14_2.PNG|f14_3.PNG"));
        shopmem.addElement(new Member(15, "s15", "1234", "s15.PNG", "샤브맘", "일식", "02-2677-0160", "서울 영등포구 영등포동8가 68 청담빌딩 1층", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 2, "./m15.PNG","쇠고기샤브,13000|버섯샤브,14000|옥스각시샤브,80000", "f15_1.PNG|f15_2.PNG|f15_3.PNG"));
        shopmem.addElement(new Member(16, "s16", "1234", "s16.PNG", "정진석의 달인파스타", "양식", "02-2068-7767", "서울 영등포구 당산동5가 11-33", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 2, "./m16.PNG","고구마피자,13000|범벅피자,16000|천하장사,21000", "f16_1.PNG|f16_2.PNG|f16_3.PNG"));
        shopmem.addElement(new Member(17, "s17", "1234", "s17.PNG", "쿠겐파파", "양식", "02-8883-9088", "서울 영등포구 양평동4가 116 휴라이프빌딩 3층", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 1, "./m17.PNG","함박스테이크,7900~13900|스파게티,9900~13900", "f17_1.PNG|f17_2.PNG"));
        shopmem.addElement(new Member(18, "s18", "1234", "s18.PNG", "카페엘디아", "양식", "070-8829-5057", "서울 영등포구 양평동4가 199", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 1, "./m18.PNG","스페인 그릴목등심,13000|스페니쉬 샐러드 파스타,12500", "f18_1.PNG|f18_2.PNG"));
        shopmem.addElement(new Member(19, "s19", "1234", "s19.PNG", "스퀘어21", "양식", "02-2062-5445", "서울 영등포구 양평동5가 106-1 코오롱디지털타워1층", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 4, "./m19.PNG","파스타,11900|샐러드,9000", "f19_1.PNG|f19_2.PNG"));
        shopmem.addElement(new Member(20, "s20", "1234", "s20.PNG", "맥도날드", "양식", "070-7209-0556", "서울 영등포구 당산동6가 331-6", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 3, "./m20.PNG","상하이버거,4700|피자,34400", "f20_1.PNG|f20_2.PNG"));
        shopmem.addElement(new Member(21, "s21", "1234", "s21.PNG", "강원치뿌", "양식", "070-7209-0556", "서울 영등포구 당산동6가 331-6", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 5, "./m21.PNG","상하이버거,4700|빅맥,4400", "f21_1.PNG|f21_2.PNG"));
        shopmem.addElement(new Member(22, "s21", "1234", "s22.PNG", "뉴욕스테이션", "양식", "070-7209-0556", "서울 영등포구 당산동6가 331-6", "대중교통 이용시\n당산역 3번출구로 오셔서 앞으로 쭉 도보 100m 걸어 오시면 됩니다.\n\n자가용 이용시\n선유도역 방면으로 양평동 사거리에서 좌회전해서 골목으로 들어오시면 됩니다.", 2, "./m22.PNG","불고기상하이,4700|함박스테이크,44400", "f22_1.PNG|f22_2.PNG"));

        // 상점 페이지 분류
        //this.setNowpage(1);
	}
	
	// 회원추가시 제일 마지막 회원 데이타 추출해서 그내용으로 데이타 추가
	public boolean setInsertMember(Member insertMember){	// 회원 추가 정보
		Member tmpMember, lastOldMember;// 기존회원및 신규회원
		int tmpSize;	// 회원데이타 싸이즈 임시저장;

		
		tmpSize = this.shopmem.size();			
		if( tmpSize >0 ) {	// 회원리스트가 하나라도 있다면 마지막데이타 추출 
			lastOldMember = this.shopmem.get(this.shopmem.size()-1);		// 벡터데이타인 shopmem에서 마지막 회원정보를 추출한다.
			insertMember.setNum(lastOldMember.getNum()+1);				// 벡터데이타로 추가할 회원정보의 번호를 마지막 회원정보의 번호+1로 수정한다. 
		} else { //회원정보가 없다면
			insertMember.setNum(1); // 추가할 회원정보 번호를 1로 수정
		}
		
		// 데이타 검증처리는 입력페이지에서 처리하거나 여기서처리 //* 에러처리두 해야된다.
		this.insertmember = insertMember;			// 입력될 회원데이타 저장
		this.shopmem.addElement(insertMember);	// 에러나면 처리 try
		return true;
	}
	public Member getInsertMember(){	// 추가회원 정보
		return this.insertmember;	//추가회원 정보
	}
	public void setUpdateMember(Member updateMember){	// 회원 수정 정보
		this.updatemember = updateMember;
	}
	public Member getUpdateMember(){	// 회원 수정 정보
		return this.updatemember;
	}
	public void setDeleteMember(Member deletemember){	// 회원 삭제 정보
		this.deletemember = deletemember;
	}
	public Member getDeleteMember(){	// 회원 삭제 정보
		return this.deletemember;
	}
	/*
	public Member getFindMember(String type){	// 회원 type 검색 정보
		return new Member();
	}	
	public Member getFindMember(String id){	// 회원 아이디검색 정보
		return new Member();
	}	
	public Member getFindMember(String name){	// 회원 이름검색 정보
		return new Member();
	}
	public Member getFindMember(int Ranking){	// 회원 랭킹검색 정보
		return new Member();
	}
	public Member getFindMember(String address){	// 회원 지역검색 정보
		return new Member();
	}
	public Member getFindMember(String menuname, int menuprice){	// 회원 메뉴/가격검색 정보
		return new Member();
	}
	public Member getFindMember(String tel){	// 회원 전화검색 정보
		return new Member();
	}*/
	
	public void setRecoveryMember(Member recoverymember){	// 회원 복구 정보
		this.recoverymember = recoverymember;
	}
	public Member getRecoveryMember(){	// 회원 복구 정보
		return this.recoverymember;
	}
	public void setLineperage(int line){	// 페이지당 라인수 저장
		this.lineperpage = line*1;
	}
	public void setNowpage(int nowp){// 현재페이지 0-9, 10-19, 20-29// 0 페이지가 되면 화면없음 저장
		this.nowpage = nowp*1;
	}
	public int getShopcnt(){				// 상점총수 가져오기
		return this.shopmem.size()*1;
	}
	public int getLineperage(){			// 페이지당 라인수 가져오기
		return this.lineperpage*1;
	}
	public int getFirstpage(){				// 첫페이지 가져오기
		return 1;
	}
	public int getAllpage(){				// 총페이지 가져오기
		return (this.getShopcnt()/this.getLineperage()+1)*1;
	}
	public int getNowpage(){				// 현재페이지 0-9, 10-19, 20-29// 0 페이지가 되면 화면없음  가져오기
		return this.nowpage*1;
	}
	public int getNextpage(){				// 다음페이지 가져오기 저장
		int tmp;																						// 다음페이지 임시 저장값

		if( this.getNowpage() >= this.getAllpage() )  tmp = this.getAllpage();				// 현재페이지가 전체페이지보다 크거나 같다면 전체페이지로
		else if( this.getNowpage() < this.getFirstpage() )  tmp = this.getFirstpage();		// 현재페이지가 첫페이지보다 적다면 첫페이지로
		else tmp = this.getNowpage() + 1;														// 그외는 현재페이지 + 1 값을 tmp에 할당한다.
		return tmp;
	}
	public int getPrevpage(){				// 이전페이지 가져오기
		int tmp;																						// 이전페이지 임시 저장값
		if( this.getNowpage() <= this.getFirstpage() )  tmp = this.getFirstpage();			// 현재페이지가 1보다 작거나 같다면 1페이지로
		else if( this.getNowpage() > this.getAllpage() )  tmp = this.getAllpage()-1;		// 현재페이지가 전체페이지보다 크거나 같다면 전체페이지-1
		else tmp = this.getNowpage() - 1;														// 그외는 현재페이지 + 1 값을 tmp에 할당한다.
		return tmp;
	}
	public int getLastpage(){				// 끝페이지 가져오기
		return this.getAllpage()*1;
	}
	public void previewCls(JPanel o){
		o.removeAll();			// sPanel_2_1 패널 내용 삭제 - 상점리스트버튼 전체 삭제
		o.revalidate();				// sPanel_2_1 패널 내용 확인
		o.repaint();				// sPanel_2_1 패널 다시 그리기
		//revalidate(); 			// frame 재확인
		//repaint();				// frame 다시 그리기	
		
	}	
	// 테스트를 위해서 Vector 번호를 전달해준다.  ---------> 서비스 때는 절대번호를 전달해준다.
	public Member infoMember(int idx){ // 게시판에서 상점보기 할때 관련 회원정보 전달하기 위한 함수
		return this.shopmem.get(idx);	
	}
	public void previewList(View_Box fBox, JPanel listPane){// 인자값( 화면전체 담는 박스패널=win=fBox , 상점버튼 리스트 담는 박스패널)
		
        // 현재 리스트 출력 내용 - //JButton list3 = new JButton("3 상점이름 | 전화번호 | 평점");			
		// 상점버튼 리스트 작업
		this.previewCls(listPane);				// 리스트 담는 박스패널 다시 담기위해 초기화 작업
		listButton.clear();							// 이걸 안해주면 기존에 그려진 버튼의 흔적이 남음 대체 listButton = new Vector<JButton>();
		//fBox.VectorShopMemberListIndex;	// 상점보기에 번호를 전달하기 위해 만든 전역변수 View_Box에서만 쓰는 변수
        for(int i=(getNowpage()-1)*getLineperage(), k=0; i < (getNowpage())*getLineperage(); i++,k++ ){
    		try{
    			//protected Member VectorShopMemberInfo
    			// 전역변수로 Vector 배열번호 저장해서 actionPerformed에 전달 
    			// 상점보기에 번호를 전달하기 위해 만든 전역변수
    			int tmpNum = i; //벡터순서 저장하는 변수
    			String str1 = "" + (i+1) + ". 맛집 :  " + shopmem.elementAt(i).getName() + " 보기";		// 버튼에 들어가는 내용 정리
    			listButton.addElement(new JButton(str1));														// 리스트에  jbutton객체를 끝에 추가
    			listButton.elementAt(k).setHorizontalAlignment(SwingConstants.LEFT);						// 버튼글자 왼쪽정렬
    			listButton.elementAt(k).addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {											// 버튼 누를때 이벤트처리함수 처리
						// 버튼 클릭했을때 Member 객체 타입을 저장한후 이동한다.
						// 값을 복사하는 이유는 참조를 하게 되면 값이 유지가 안된다.
						fBox.VectorShopMemberInfo = infoMember(Integer.valueOf(tmpNum));			// for문 변수 i가 전달되지 않아서 for문 전역변수 tmpNum을 선언해 전달후 복사값 Member객체 값을 만들어 낸다.
    					JOptionPane.showMessageDialog(null, str1 );											// 버튼 내용 보기
    					//fBox.shopMemberView = shopmem.elementAt(i).getId();							// 상점회원 번호
    					fBox.change("view_9"); 																		// 해당 상점보기 이동
    					//$$ win 독립클래스 만들때 조심
    				}
    			});
    			listPane.add(listButton.elementAt(k));	
    			listPane.validate();//$$ sPanel_2_1 독립클래스 만들때 조심
    		} catch(ArrayIndexOutOfBoundsException e){														// listButton 배열범위를 넘을 경우 예외처리
    			System.out.println(" i = " + i + "ArrayInexOutOfBoundsException 에러가 났습니다.");	// 디버그 하기 위해서 찍어놓음
    		} finally {
    		}
        }//for
	}// public void previewList(View_Box fBox, JPanel listPane)
	//public void setShopcnt(){}			// 상점총수 저장
	//public void setFirstpage(int first){}	// 첫페이지 저장
	//public int setAllpage(){}				// 총페이지 저장
	//public int setNextpage(){}			// 다음페이지 저장
	//public int setPrevpage(){}				// 이전페이지 저장
	//public void setLastpage(){}			// 끝페이지 저장
	
	
}	//// class ShopMemberList --------------------------------------




///////////////////////////////////////////////////////////////////////////
/// class Member 등록 - 상점회원 1개씩 담는 클래스
///	(나중에 레벨별 회원 쓸때는 확장해서 쓰면됨)
///////////////////////////////////////////////////////////////////////////
class Member {
	public int num;				// 등록번호
	public String id;				// 등록아이디
	public String pass;			// 등록패스
	public String name;			// 맛집 이름
	public String shopimg;		// 맛집 간판 이미지
	public String type;			// 종류
	public String tel;			// 전화번호
	public String juso;			// 주소
	public String mapinfo;		// 맛집 길안내글
	public int ranking;			// 평점
	public String mapimg;		// 지도이미지
	public String folist;			// 음식정보 리스트
	public String folistimg; 	// 음식이미지 리스트
	
	// 벡터번호, 아이디, 비밀번호, 맛집간판사진, 맛집이름, 업종, 전화번호, 주소, 평점, 지도이미지, 음식정보 리스트, 음식이미지 리스트
	// int num, String id, String pass, String shopimg, String name, String type, String tel, String juso, String mapinfo, int ranking, String mapimg, String foodlist, String foodlistimg 
	public Member(int num, String id, String pass, String shopimg, String name, String type, String tel, String juso, String mapinfo, int ranking, String mapimg, String foodlist, String foodlistimg ) {
		setNum(num);				// 번호
		setId(id);						// 아이디
		setPass(pass);				// 비밀번호
		setShopimg(shopimg);		// 맛집 사진
		setName(name);				// 맛집 이름
		setType(type);				// 종류
		setTel(tel);						// 전화번호
		setJuso(juso);				// 주소
		setMapinfo(mapinfo);		// 맛집 길안내 소개
		setRanking(ranking);		// 평점
		setMapimg(mapimg);		// 지도이미지
		setFolist(foodlist);			// 음식정보 리스트
		setFolistimg(foodlistimg); 	// 음식이미지 리스트
	}

	public int getNum(){							// 번호
		return this.num;
	}
	public void setNum(int num){				// 번호
		this.num = num;
	}
	public String getId(){							// 아이디
		return this.id;
	}
	public void setId(String id){					// 아이디
		this.id = id;
	}
	public String getPass(){						// 비밀번호
		return pass;
	}
	public void setPass(String pass){				//비밀번호
		this.pass = pass;
	}
	public String getName(){						// 맛집이름
		return this.name;
	}
	public void setName(String name){			//맛집이름
		this.name = name;
	}
	public String getShopimg(){					// 맛집 간판 이미지
		return this.shopimg;
	}
	public void setShopimg(String shopimg){	// 맛집 간판 이미지
		this.shopimg = shopimg;
	}
	public String getMapinfo(){					// 맛집소개
		return mapinfo;
	}
	public void setMapinfo(String mapinfo){	//맛집소개
		this.mapinfo = mapinfo;
	}
	public String getType(){						// 종류
		return this.type;
	}
	public void setType(String type){				// 종류
		this.type = type;
	}
	public String getTel(){							// 전화번호
		return this.tel;
	}
	public void setTel(String tel){					// 전화번호
		this.tel = tel;
	}
	public String getJuso(){						// 주소
		return this.juso;
	}
	public void setJuso(String juso){				// 주소
		this.juso = juso;
	}
	public int getRanking(){						// 평점
		return this.ranking;
	}
	public void setRanking(int ranking){		// 평점
		this.ranking = ranking;
	}
	public String getMapimg(){					// 지도이미지
		return this.mapimg;
	}
	public void setMapimg(String mapimg){	// 지도이미지
		this.mapimg = mapimg;
	}
	public String getFolist(){						// 음식정보 리스트
		return this.folist;
	}
	public void setFolist(String folist){			// 음식정보 리스트
		this.folist = folist;
	}
	public String getFolistimg(){					// 음식이미지 리스트
		return this.folistimg;
	}
	public void setFolistimg(String folistimg){	// 음식이미지 리스트
		this.folistimg = folistimg;
	}	
	
	public String allPrint(){							// 필요한 필드 가져오기 위한것
		return new String(getNum() + "," + getId() + "," + getPass());
	}
}	//// Member Class --------------------------------------













/*	// Object.getClass().getName();
	//Overloding , 객체안에 다 집어넣쿠 전달? 자원소비가 넘 크네
	public void change(String panelName, Object panelObjet) {
		
		// 기본 메인 패널 삭제
		getContentPane().removeAll();			// view_Box frame 내용 제거
		
		// 문자열 panelName에 대소문자무시한 "view_2" 하고 같나?
		// 같으면 해당 화면 그려준다.
		// 틀리면 손님메인화면 그려준다.
		if( panelName.equalsIgnoreCase("view_2") ) {
			//getContentPane().add(view_2);			// frame에 내용 메인화면(손님용)으로 채우기
			getContentPane().add(new View_2(this));			// frame에 내용 메인화면(손님용)으로 채우기
			// void java.awt.Component.revalidate() // 패널 내 동적컴포넌트 생성시, Contaniner 레이아웃 자동변화시 재인식
			// void java.awt.Component.revalidate() // 패널 내 동적컴포넌트 생성시, Contaniner 레이아웃 자동변화시 재인식
			//view_1.revalidate();					// view_1 재확인
			//view_1.repaint();						// view_1 다시 그리기	
			
		} else if( panelName.equalsIgnoreCase("view_1") ) {
			getContentPane().add(new View_1(this));			// view_1 frame 내용 채우기	
			
		} else if( panelName.equalsIgnoreCase("view_1_1") ) {
			getContentPane().add(new View_1_1(this));			// view_1 frame 내용 채우기	
			
		} else { // view_1
			getContentPane().add(new View_1(this));			// view_1 frame 내용 채우기		
			
		}
		
		revalidate(); 								// frame 재확인
		repaint();									// frame 다시 그리기	
	} // public void change(String panelName)
*/	
