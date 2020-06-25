package project1;
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

import javax.swing.*;
import javax.swing.border.*;


////////////////////////////////////////////////////////////////////////////////////////
//전체 레이아웃 컨트롤
////////////////////////////////////////////////////////////////////////////////////////
public class View_Box extends JFrame {

	private JPanel contentPane;				// View_Box 객체내 Frame에 속한 초기화 레이아웃패널관리매니저 

	//Launch the application	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					View_Box win = new View_Box();		// View_Box.frame 객체
					
					win.setTitle("당산동맛집");				// View_Box.frame 제목 초기화
					win.add(new View_1(win));				// View_Box.frame에 손님메인화면 교체 초기화									// win.view_1 = new View_1(win);					//win.view_2 = new View_2(win);					//win.add(win.view_1);					// View_Box에 손님메인화면 교체

					win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// View_Box.frame 자동닫기
					win.setSize(800, 600);												// View_Box.frame 싸이즈
					win.setVisible(true);													// View_Box.frame 보이기						// View_Box frame = new View_Box();					//frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} // public void run()
			
		});// EventQueue.invokeLater(new Runnable()
		
	}// public static void main(String[] args)

	
	// Create the frame
	public View_Box() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\java\\_lecture\\study\\eclipse_home_java_workspace\\eatingHouse\\images\\logo.png"));	// View_Box.frame 아이콘		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// View_Box.frame 닫기시 종료
		setBounds(100, 100, 800, 600);									// View_Box.frame window내 위치
		this.setLocationRelativeTo(null);									// View_Box 스크린 중앙 정렬 			///Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();		frame.setLocation((dim.width/2)-(frame.getWidth()/2), (dim.height/2)-(frame.getHeight()/2));

		
		contentPane = new JPanel();										// View_Box.frame 레이아웃패널관리매니저 초기화
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));			// View_Box.frame 레이아웃패널관리매니저 공백보더지정
		contentPane.setLayout(new BorderLayout(0, 0));				// View_Box.frame 레이아웃패널관리매니저 레이아웃매니저 지정
		setContentPane(contentPane);										// View_Box.frame의 레이아웃패널관리매니저 지정

	} // public View_Box()
	
	

	public void change(String panelName) {
		
		// 기본 메인 패널 삭제
		getContentPane().removeAll();								// View_Box.frame 내용 제거
		JPanel tmpPanel = new JPanel();
		if( panelName.equalsIgnoreCase("view_2") ) {
			getContentPane().add( tmpPanel=new View_2(this) );			// 관리자메인화면 교체	
			
		} else if( panelName.equalsIgnoreCase("view_1") ) {
			getContentPane().add( tmpPanel=new View_1(this) );			// 손님메인화면 교체
			
		} else if( panelName.equalsIgnoreCase("view_1_1") ) {
			getContentPane().add( tmpPanel=new View_1_1(this) );			// 로그인화면 교체	
			
		} else if( panelName.equalsIgnoreCase("View_up") )  {
			getContentPane().add( tmpPanel=new View_up(this) );
		} 
		  else { // view_1
			getContentPane().add( tmpPanel=new View_1(this) );			// 손님메인화면 교체		
			
		}

		//tmpPanel.getLocation();
		//tmpPanel.setLocation(10, 600);
		revalidate(); 									// frame 재확인
		repaint();										// frame 다시 그리기	
	} // public void change(String panelName)

	
} //public class View_Box extends JFrame






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
