package project1;
// ���� �˻� : �ڹ� ���̾�α�
// https://www.google.co.kr/search?q=%EC%9E%90%EB%B0%94+%EC%B0%BD&oq=%EC%9E%90%EB%B0%94+%EC%B0%BD&aqs=chrome..69i57j69i65j69i61l2.4773j0j8&{google:bookmarkBarPinned}sourceid=chrome&{google:omniboxStartMarginParameter}ie=UTF-8#q=%EC%9E%90%EB%B0%94+%EB%8B%A4%EC%9D%B4%EC%96%BC%EB%A1%9C%EA%B7%B8
// Dialog - ���
// [Java] �ڹ� Swing JDialog�� �θ� JFrame �߾ӿ� ���� // http://kwangshin.pe.kr/blog/2012/10/08/java-%EC%9E%90%EB%B0%94-swing-jdialog%EB%A5%BC-%EB%B6%80%EB%AA%A8-jframe-%EC%A4%91%EC%95%99%EC%97%90-%EB%9D%84%EC%9A%B0%EA%B8%B0/
// http://egloos.zum.com/happy2ni/v/2837922
// http://ddoriya.tistory.com/entry/JAVA-swing-custum-Dialog-%EB%A7%8C%EB%93%A4%EA%B8%B0
// �ڹ� ������â �����(�۾���, �̹��� �ֱ�) - http://zinlee.tistory.com/122
// [JAVA] GUI �� â ũ�� ���� ���ϰ� �ϴ� ��� - http://howhelove.tistory.com/22

// ���޼��� - ���̵�/��й�ȣ �Է����ּ���.
// http://hsp1116.tistory.com/3
// http://ibabo.tistory.com/250

// ���۰˻� - �ڹ� ���� ȭ�� ��ȯ
// https://www.google.co.kr/search?q=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98&oq=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98&aqs=chrome..69i57.8403j0j8&{google:bookmarkBarPinned}sourceid=chrome&{google:omniboxStartMarginParameter}ie=UTF-8
// http://blog.naver.com/PostView.nhn?blogId=battledocho&logNo=220012083751

// ���۰˻� - �ڹ� ���� ����Ÿ .txt ����
// https://www.google.co.kr/search?q=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98&oq=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98&aqs=chrome..69i57.8403j0j8&{google:bookmarkBarPinned}sourceid=chrome&{google:omniboxStartMarginParameter}ie=UTF-8#q=%EC%9E%90%EB%B0%94+%EC%8A%A4%EC%9C%99+%EB%8D%B0%EC%9D%B4%ED%83%80+.txt+%EC%A0%80%EC%9E%A5
// http://mwultong.blogspot.com/2006/10/java-text-file-write.html
// http://castleone88.blogspot.kr/2016/02/javatextarea_12.html
// http://seinarin.tistory.com/41
// http://gnujava.com/board/article_view.jsp?article_no=4292&board_no=1&table_cd=EPAR01&table_no=01
// http://1bestcsharp.blogspot.kr/2015/04/java-io-how-to-export-jtable-data-to-txt-File-In-Java.html

// ���۰˻� - �ڹ� txt ���� �˻�
// http://www.yunsobi.com/blog/153
// http://www.yunsobi.com/blog/543
// http://mantdu.tistory.com/731


// ���۰˻� - �ڹ� �̹��� ���� ���� �˻�
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

// ���۰˻� - �ڹ� ���� ���� ���
// http://sexy.pe.kr/tc/763
// JFileChooser, ���� â, ���� â, ���� ���� â, Swing - http://blog.naver.com/PostView.nhn?blogId=cracker542&logNo=40119977325&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView

// ���۰˻� - �ڹ� JOptionPane �ڼ��� ��
// http://hallang.tistory.com/139
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;


////////////////////////////////////////////////////////////////////////////////////////
//��ü ���̾ƿ� ��Ʈ��
////////////////////////////////////////////////////////////////////////////////////////
public class View_Box extends JFrame {

	private JPanel contentPane;				// View_Box ��ü�� Frame�� ���� �ʱ�ȭ ���̾ƿ��гΰ����Ŵ��� 

	//Launch the application	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					View_Box win = new View_Box();		// View_Box.frame ��ü
					
					win.setTitle("��굿����");				// View_Box.frame ���� �ʱ�ȭ
					win.add(new View_1(win));				// View_Box.frame�� �մԸ���ȭ�� ��ü �ʱ�ȭ									// win.view_1 = new View_1(win);					//win.view_2 = new View_2(win);					//win.add(win.view_1);					// View_Box�� �մԸ���ȭ�� ��ü

					win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// View_Box.frame �ڵ��ݱ�
					win.setSize(800, 600);												// View_Box.frame ������
					win.setVisible(true);													// View_Box.frame ���̱�						// View_Box frame = new View_Box();					//frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} // public void run()
			
		});// EventQueue.invokeLater(new Runnable()
		
	}// public static void main(String[] args)

	
	// Create the frame
	public View_Box() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\java\\_lecture\\study\\eclipse_home_java_workspace\\eatingHouse\\images\\logo.png"));	// View_Box.frame ������		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// View_Box.frame �ݱ�� ����
		setBounds(100, 100, 800, 600);									// View_Box.frame window�� ��ġ
		this.setLocationRelativeTo(null);									// View_Box ��ũ�� �߾� ���� 			///Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();		frame.setLocation((dim.width/2)-(frame.getWidth()/2), (dim.height/2)-(frame.getHeight()/2));

		
		contentPane = new JPanel();										// View_Box.frame ���̾ƿ��гΰ����Ŵ��� �ʱ�ȭ
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));			// View_Box.frame ���̾ƿ��гΰ����Ŵ��� ���麸������
		contentPane.setLayout(new BorderLayout(0, 0));				// View_Box.frame ���̾ƿ��гΰ����Ŵ��� ���̾ƿ��Ŵ��� ����
		setContentPane(contentPane);										// View_Box.frame�� ���̾ƿ��гΰ����Ŵ��� ����

	} // public View_Box()
	
	

	public void change(String panelName) {
		
		// �⺻ ���� �г� ����
		getContentPane().removeAll();								// View_Box.frame ���� ����
		JPanel tmpPanel = new JPanel();
		if( panelName.equalsIgnoreCase("view_2") ) {
			getContentPane().add( tmpPanel=new View_2(this) );			// �����ڸ���ȭ�� ��ü	
			
		} else if( panelName.equalsIgnoreCase("view_1") ) {
			getContentPane().add( tmpPanel=new View_1(this) );			// �մԸ���ȭ�� ��ü
			
		} else if( panelName.equalsIgnoreCase("view_1_1") ) {
			getContentPane().add( tmpPanel=new View_1_1(this) );			// �α���ȭ�� ��ü	
			
		} else if( panelName.equalsIgnoreCase("View_up") )  {
			getContentPane().add( tmpPanel=new View_up(this) );
		} 
		  else { // view_1
			getContentPane().add( tmpPanel=new View_1(this) );			// �մԸ���ȭ�� ��ü		
			
		}

		//tmpPanel.getLocation();
		//tmpPanel.setLocation(10, 600);
		revalidate(); 									// frame ��Ȯ��
		repaint();										// frame �ٽ� �׸���	
	} // public void change(String panelName)

	
} //public class View_Box extends JFrame






/*	// Object.getClass().getName();
	//Overloding , ��ü�ȿ� �� ������� ����? �ڿ��Һ� �� ũ��
	public void change(String panelName, Object panelObjet) {
		
		// �⺻ ���� �г� ����
		getContentPane().removeAll();			// view_Box frame ���� ����
		
		// ���ڿ� panelName�� ��ҹ��ڹ����� "view_2" �ϰ� ����?
		// ������ �ش� ȭ�� �׷��ش�.
		// Ʋ���� �մԸ���ȭ�� �׷��ش�.
		if( panelName.equalsIgnoreCase("view_2") ) {
			//getContentPane().add(view_2);			// frame�� ���� ����ȭ��(�մԿ�)���� ä���
			getContentPane().add(new View_2(this));			// frame�� ���� ����ȭ��(�մԿ�)���� ä���
			// void java.awt.Component.revalidate() // �г� �� ����������Ʈ ������, Contaniner ���̾ƿ� �ڵ���ȭ�� ���ν�
			// void java.awt.Component.revalidate() // �г� �� ����������Ʈ ������, Contaniner ���̾ƿ� �ڵ���ȭ�� ���ν�
			//view_1.revalidate();					// view_1 ��Ȯ��
			//view_1.repaint();						// view_1 �ٽ� �׸���	
			
		} else if( panelName.equalsIgnoreCase("view_1") ) {
			getContentPane().add(new View_1(this));			// view_1 frame ���� ä���	
			
		} else if( panelName.equalsIgnoreCase("view_1_1") ) {
			getContentPane().add(new View_1_1(this));			// view_1 frame ���� ä���	
			
		} else { // view_1
			getContentPane().add(new View_1(this));			// view_1 frame ���� ä���		
			
		}
		
		revalidate(); 								// frame ��Ȯ��
		repaint();									// frame �ٽ� �׸���	
	} // public void change(String panelName)
*/	
