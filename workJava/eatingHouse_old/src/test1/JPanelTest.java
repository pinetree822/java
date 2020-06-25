package test1;
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
import javax.swing.*;
import javax.swing.border.*;

public class JPanelTest extends JFrame {

	private JPanel contentPane;//
	public JPanel01 jpanel01 = null;
	public JPanel02 jpanel02 = null;

	//Launch the application	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPanelTest win = new JPanelTest();
					
					win.setTitle("프레임 전환");
					win.jpanel01 = new JPanel01(win);
					win.jpanel02 = new JPanel02(win);
					
					win.add(win.jpanel01);
					win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					win.setSize(800, 600);
					win.setVisible(true);
					//JPanelTest frame = new JPanelTest();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// public static void main(String[] args)

	
	// Create the frame
	public JPanelTest() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 600);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
	} // public JPanelTest()
	
	public void change(String panelName) {
		if( panelName.equalsIgnoreCase("panel01") ) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate(); // void java.awt.Component.revalidate() // 패널 내 동적컴포넌트 생성시, Contaniner 레이아웃 자동변화시 재인식
			repaint();			
		} else {
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate(); // void java.awt.Component.revalidate()
			repaint();
		}
	} // public void change(String panelName)
} //public class JPanelTest extends JFrame


// 1번째 패널
class JPanel01 extends JPanel {
	private JButton jButton1;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JPanelTest win;
	
	public JPanel01(JPanelTest win) {
		this.win = win;
		setLayout(null);
		
		jButton1 = new JButton("버튼");
		jButton1.setSize(70,20);
		jButton1.setLocation(10, 10);
		add(jButton1);
		
		jTextArea1 = new JTextArea();

		jScrollPane1 = new JScrollPane( jTextArea1 );
		jScrollPane1.setSize(200, 150);
		jScrollPane1.setLocation(10, 40);
		add(jScrollPane1);
		
		jButton1.addActionListener( new MyActionListener() );
	}
	class MyActionListener implements ActionListener { // 버튼 키 누르면 패널 2번 호출
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}
	
} //class JPanel01 extends JPanel 



// 2번째 패널
class JPanel02 extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanelTest win;
	
	public JPanel02(JPanelTest win) {
		this.win = win;
		setLayout(null);
		
		JLabel lblLbl = new JLabel("아이디");
		lblLbl.setBounds(31, 40, 67, 15);
		add(lblLbl);
		
		textField = new JTextField();
		textField.setBounds(123, 40, 116, 15);
		add(textField);
		textField.setColumns(10);
		
		
		JLabel lblLbl_1 = new JLabel("암호");
		lblLbl_1.setBounds(31, 84, 116, 21);
		add(lblLbl_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 84, 67, 15);
		add(passwordField);
		
		JButton btn = new JButton("버튼");
		btn.setSize(70, 20);
		btn.setLocation(10, 10);
		add(btn);
		
		btn.addActionListener( new MyActionListener() );
		
	}
	class MyActionListener implements ActionListener { // 버튼 키 누르면 패널 1번 호출
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");
		}
	}
	
	
} //class JPanel02 extends JPanel 


















