package _ViewTest2;
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
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

////////////////////////////////////////////////////////////////////////////////////////
// toDo : 
////////////////////////////////////////////////////////////////////////////////////////
class V_log{}				// ���
class V_debug{}			// �������
class V_logon{}			// �α׿� ���� Ŭ���� �����, �α׿�üũ, �α���, �α׾ƿ� ó��
class V_session{}		// �α׿�DB
class V_accessrole{}		// ���ٰ���(service,DB,userAccess),ȸ������,ȸ���׷�
class V_network{}		// ��Ʈ��ũ
class V_category{}		// ī�װ�������
class V_img{}				// �̹��� ����(����������, ���˺���, �ؽ���,��Ÿ
class V_g2d{}				// 2�� �׷��� ����
class V_g3d{}				// 3�� �׷��� ����
class V_game{}			// ���ӿ���
class V_unit{}				// objectToUnit
class V_add{}				// ����Ÿ ����
class V_timecontrol	{}	// �ð�����
class V_editor{}			// ������(�׷���,����,������,��Ʈ��ũ)
class V_shoppingmall{}	// ���θ�
class V_apimanager{}	// �ܺμ��� api����
class V_contentmanager{}	// �ܺμ��񽺿�������



////////////////////////////////////////////////////////////////////////////////////////
//��ü ���̾ƿ� ��Ʈ��
////////////////////////////////////////////////////////////////////////////////////////
public class View_Box extends JFrame {

	private JPanel contentPane;						// Frame�� ����� View_Box ��ü �ȿ� �ʱ�ȭ ���̾ƿ��гΰ����Ŵ���
	protected int logLevel = 0;						// �α��� �����ϱ� ���� ���� 
	protected ShopMemberList shopList;			// �����ڵ�����Ʈ
	protected int shopMemberListView;				// ��� - ȸ����ȣ ����
	protected Member VectorShopMemberInfo;	// �������⿡ ����ȸ���� �����ϱ� ���� ���� �������� View_Box������ ���� ����
	//Launch the application	
	public static void main(String[] args) {
		// EventQueue.invokeLate( new Runnable(){ public void run(){} } );
		// http://m.blog.daum.net/creazier/15309465 ����
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					View_Box win = new View_Box();		// View_Box.frame ��ü
					
					win.setTitle("��굿����");				// View_Box.frame ���� �ʱ�ȭ
					win.add(new View_1(win));				// View_Box.frame�� �մԸ���ȭ�� ��ü �ʱ�ȭ			// win.view_1 = new View_1(win);					//win.view_2 = new View_2(win);					//win.add(win.view_1);					// View_Box�� �մԸ���ȭ�� ��ü

					
					
					win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// View_Box.frame �ڵ��ݱ�
					win.setSize(820, 710);												// View_Box.frame ������
					win.setVisible(true);													// View_Box.frame ���̱�		// View_Box frame = new View_Box();					//frame.setVisible(true);
					win.setResizable(false);												// ViewFrame â �Ұ��� ����
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // public void run()
			
		});// EventQueue.invokeLater(new Runnable()
		
	}// public static void main(String[] args)

	
	// Create the frame
	public View_Box() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo.png"));	// View_Box.frame ��ܾ�����		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);							// View_Box.frame �ݱ�� ����
		setBounds(100, 100, 800, 600);													// View_Box.frame window�� ��ġ
		this.setLocationRelativeTo(null);													// View_Box ��ũ�� �߾� ���� 			///Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();		frame.setLocation((dim.width/2)-(frame.getWidth()/2), (dim.height/2)-(frame.getHeight()/2));

		
		contentPane = new JPanel();														// View_Box.frame ���̾ƿ��гΰ����Ŵ��� �ʱ�ȭ
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));							// View_Box.frame ���̾ƿ��гΰ����Ŵ��� ���麸������
		contentPane.setLayout(new BorderLayout(0, 0));								// View_Box.frame ���̾ƿ��гΰ����Ŵ��� ���̾ƿ��Ŵ��� ����
		setContentPane(contentPane);														// View_Box.frame�� ���̾ƿ��гΰ����Ŵ��� ����

	} // public View_Box()
	
	

	public void change(String panelName) {
		
		// �⺻ ���� �г� ����
		// setContentPane(contentPane) 										// View_Box Frame �� ������ ������ ���� ���
		// getContentPane().removeAll()										// View_Box Frame �� ��ϵ� ��� ������ ����Ʈ ����
		// getContentPane().add(tmpPanel,BorderLayout.CENTER)		// View_Box Frame �� tmpPanel �߰� ���
		// setContentPane(getJContentPane()) 								// View_Box Frame �� tmpPanel�� ������ �����ڷ� ���� ���
		getContentPane().removeAll();
		JPanel tmpPanel = new JPanel();										// �гΰ�ü �����ؼ� �ٸ� �ǵ��� ����ϱ� ���� ���� �����ص�(���� ��� �����丮 ���)
		if( panelName.equalsIgnoreCase("view_2") ) {
			getContentPane().add( tmpPanel=new View_2(this) );			// �����ڸ���ȭ�� ��ü	
			
		} else if( panelName.equalsIgnoreCase("view_1") ) {
			getContentPane().add( tmpPanel=new View_1(this) );			// �մԸ���ȭ�� ��ü
			
		} else if( panelName.equalsIgnoreCase("view_1_1") ) {
			getContentPane().add( tmpPanel=new View_1_1(this) );		// �α���ȭ�� ��ü	
			
		} else if( panelName.equalsIgnoreCase("view_4") ) {
			getContentPane().add( tmpPanel=new View_4(this) );			// ����ȸ�����ȭ�� ��ü	
			
		} else if( panelName.equalsIgnoreCase("view_9") ) {
			getContentPane().add( tmpPanel=new View_9(this) );			// ����ȸ������ȭ�� ��ü	
			
		} else { // view_1
			getContentPane().add( tmpPanel=new View_1(this) );			// �մԸ���ȭ�� ��ü		
			
		}

		//tmpPanel.getLocation();
		//tmpPanel.setLocation(10, 600);
		revalidate(); 									// frame ��Ȯ��
		repaint();										// frame �ٽ� �׸���	
	} // public void change(String panelName)

	
} //public class View_Box extends JFrame



class MemberManager{}// ȸ�������뵵�� ������ Ŭ����

// ����ȸ�� �Խ��Ǹ���Ʈ ���� + ȸ������Ÿ import  
// �ӽ� ȸ������(�߰�,����,����)
class ShopMemberList{
	
	Vector<Member> shopmem = new Vector<Member>();			// ��������Ʈ ��� ���Ͱ�ü
    Vector<JButton> listButton = new Vector<JButton>();			// ��������Ʈ�� �����ϴ� ��ư�����ϴ� ���Ͱ�ü
    Member insertmember;												// ȸ���߰�
    Member updatemember;												// ȸ������
    Member deletemember;												// ȸ������
    Member recoverymember;												// ȸ������
    int lineperpage = 8;													// �������� ������
    int firstpage;																// ù������
    int allpage;																// ��������
    int nowpage;															// ���������� 0-9, 10-19, 20-29
    //int shopcnt;															// ������
    //int nextpage;															// ����������
    //int prevpage;															// ����������
    //int lastpage;															// ��������
    
    
	public void ShopMembeList(){}

	///////////////////////////////////////////////////////////////////////////
	/// �����ڵ�����Ʈ - ����Ÿ �ε�
	/// ���Ͱ迭�� ���ȭ �ؼ� ����
	//  toDo : �Խ��� �ϴ� ��ȣ������ ī����(1,2,3,..8,9,10)���� ���� - �����༭ ��������
	//  toDo : �Խ��� �ϴ� ��ȣ������ �¿� 10�� 30�� �ǳʶٱ� ���̺���̼� ���� - �����༭ ��������
	/// toDo : ���� �ؽ�Ʈ ������ �ӽ� ���� �����ȹ
	/// toDo : ���� RDBMs(����Ŭ,Mysql,Mssql��),NoSql,Mongo,In-memory,Sqlite ����Ŭ������ Db����Ÿ �ε��� �������� ���� �Լ�
	/// toDo : ������ ����Ÿ�� ������� ���� ��������
	///////////////////////////////////////////////////////////////////////////	 
	public void dataGetLoader(){       
		// ���ʵ���Ÿ
        // shopmem ���� �߰�(����Ÿ �߰�)
        shopmem.addElement(new Member(1, "s1", "1234", "s1.PNG", "��õ���Ѹ�", "�ѽ�", "02-0268-8652", "���� �������� ��굿6�� 216-2 ����1��", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 4, "./m1.PNG","��ġ���̳ñ���,7000|�Ҹ���������,16000", "f1_1.PNG|f1_2.PNG"));// shopmem ���� �߰�(����Ÿ �߰�)
        shopmem.addElement(new Member(2, "s2", "1234", "s2.PNG", "������", "�ѽ�", "02-2633-8033", "���� �������� ��굿5�� 20", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 3, "./m2.PNG","�ҹ��Ұ��,5000|��â����,9000|�������,7000", "f2_1.PNG|f2_2.PNG|f2_3.PNG"));
        shopmem.addElement(new Member(3, "s3", "1234", "s3.PNG", "�ʵ������Ĵ�", "�ѽ�", "02-2634-5467", "���� �������� �������� ���� 5�� 57-1", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 1, "./m3.PNG","��������,15000~30000|�췷����,5000|��¡���,7000", "f3_1.PNG|f3_2.PNG|f3_3.PNG"));
        shopmem.addElement(new Member(4, "s4", "1234", "s4.PNG", "��ǳ�Ĵ�", "�ѽ�", "02-2634-1359", "���� �������� ����4�� 56", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 2, "./m4.PNG","������,16000|������,9000", "f4_1.PNG|f4_2.PNG"));
        shopmem.addElement(new Member(5, "s5", "1234", "s5.PNG", "��������", "�ѽ�", "02-2637-8989", "���� �������� ����4�� 192", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 5, "./m5.PNG","����Ұ��,8000|ī�����̽�,6000|�δ��,9000", "f5_1.PNG|f5_2.PNG|f5_3.PNG"));
        shopmem.addElement(new Member(6, "s6", "1234", "s6.PNG", "����", "�߽�", "02-2633-8124", "���� �������� ��굿5�� 42", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 2, "./m6.PNG","¥���,5000|�Ｑ«��,9000|������,12000", "f6_1.PNG|f6_2.PNG|f6_3.PNG"));
        shopmem.addElement(new Member(7, "s7", "1234", "s7.PNG", "ȫ�����", "�߽�", "02-2676-5892", "���� �������� ��굿6�� 399-2", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 1, "./m7.PNG","¥���,4000|«��,4500|������,8500", "f7_1.PNG|f7_2.PNG|f7_3.PNG"));
        shopmem.addElement(new Member(8, "s8", "1234", "s8.PNG", "�Ｚ��", "�߽�", "02-2634-1140", "���� �������� ��굿4�� 73-12", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 2, "./m8.PNG","¥���,5000|�ع�«��,7000|������,10000", "f8_1.PNG|f8_2.PNG|f8_3.PNG"));
        shopmem.addElement(new Member(9, "s9", "1234", "s9.PNG", "���̳״��粿ġ", "�߽�", "02-2678-5999", "���� �������� ��굿6�� 216-2", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 4, "./m9.PNG","�粿ġ,11000", "f9_1.PNG"));
        shopmem.addElement(new Member(10, "s10", "1234", "s10.PNG", "ȫ¥��", "�߽�", "02-2631-0875", "���� �������� ��굿5�� 32-1", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 3, "./m10.PNG","¥���,4000|«��,4500|������,8500", "f10_1.PNG|f10_2.PNG|f10_3.PNG"));
        shopmem.addElement(new Member(11, "s11", "1234", "s11.PNG", "�÷ο츶", "�Ͻ�", "02-0268-8652", "���� �������� ����4�� 278-3 1��", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 5, "./m11.PNG","������ �ʹ�(12pcs),16000|����ʹ�(14pcs),21000|�����ʹ�(14pcs),51000", "f11_1.PNG|f11_2.PNG"));
        shopmem.addElement(new Member(12, "s12", "1234", "s12.PNG", "����θ�", "�Ͻ�", "02-538-5166", "���� �������� ��굿5�� 9-3", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 5, "./m12.PNG","���������,7000|�������,7000|�̼Ҷ��,9000", "f12_1.PNG|f12_2.PNG|f12_3.PNG"));
        shopmem.addElement(new Member(13, "s13", "1234", "s13.PNG", "�߳�������", "�Ͻ�", "02-3667-1357", "���� �������� ����4�� 121", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 3, "./m13.PNG","�߳�������,5000|ġ�����,6000|�Ҽ���������,8000", "f13_1.PNG|f13_2.PNG|f13_3.PNG"));
        shopmem.addElement(new Member(14, "s14", "1234", "s14.PNG", "�ϳ�����ġ", "�Ͻ�", "02-2677-5633", "���� �������� ��굿5�� 33-6 �Ѽ������ 1��", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 2, "./m14.PNG","Ư��ġ,39000|�����ġ,29000|�������ġ,50000", "f14_1.PNG|f14_2.PNG|f14_3.PNG"));
        shopmem.addElement(new Member(15, "s15", "1234", "s15.PNG", "���긾", "�Ͻ�", "02-2677-0160", "���� �������� ��������8�� 68 û����� 1��", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 2, "./m15.PNG","�������,13000|��������,14000|�������û���,80000", "f15_1.PNG|f15_2.PNG|f15_3.PNG"));
        shopmem.addElement(new Member(16, "s16", "1234", "s16.PNG", "�������� �����Ľ�Ÿ", "���", "02-2068-7767", "���� �������� ��굿5�� 11-33", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 2, "./m16.PNG","��������,13000|��������,16000|õ�����,21000", "f16_1.PNG|f16_2.PNG|f16_3.PNG"));
        shopmem.addElement(new Member(17, "s17", "1234", "s17.PNG", "�������", "���", "02-8883-9088", "���� �������� ����4�� 116 �޶��������� 3��", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 1, "./m17.PNG","�Թڽ�����ũ,7900~13900|���İ�Ƽ,9900~13900", "f17_1.PNG|f17_2.PNG"));
        shopmem.addElement(new Member(18, "s18", "1234", "s18.PNG", "ī�俤���", "���", "070-8829-5057", "���� �������� ����4�� 199", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 1, "./m18.PNG","������ �׸�����,13000|����Ͻ� ������ �Ľ�Ÿ,12500", "f18_1.PNG|f18_2.PNG"));
        shopmem.addElement(new Member(19, "s19", "1234", "s19.PNG", "������21", "���", "02-2062-5445", "���� �������� ����5�� 106-1 �ڿ��յ�����Ÿ��1��", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 4, "./m19.PNG","�Ľ�Ÿ,11900|������,9000", "f19_1.PNG|f19_2.PNG"));
        shopmem.addElement(new Member(20, "s20", "1234", "s20.PNG", "�Ƶ�����", "���", "070-7209-0556", "���� �������� ��굿6�� 331-6", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 3, "./m20.PNG","�����̹���,4700|����,34400", "f20_1.PNG|f20_2.PNG"));
        shopmem.addElement(new Member(21, "s21", "1234", "s21.PNG", "����ġ��", "���", "070-7209-0556", "���� �������� ��굿6�� 331-6", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 5, "./m21.PNG","�����̹���,4700|���,4400", "f21_1.PNG|f21_2.PNG"));
        shopmem.addElement(new Member(22, "s21", "1234", "s22.PNG", "���彺���̼�", "���", "070-7209-0556", "���� �������� ��굿6�� 331-6", "���߱��� �̿��\n��꿪 3���ⱸ�� ���ż� ������ �� ���� 100m �ɾ� ���ø� �˴ϴ�.\n\n�ڰ��� �̿��\n�������� ������� ���� ��Ÿ����� ��ȸ���ؼ� ������� �����ø� �˴ϴ�.", 2, "./m22.PNG","�Ұ�������,4700|�Թڽ�����ũ,44400", "f22_1.PNG|f22_2.PNG"));

        // ���� ������ �з�
        //this.setNowpage(1);
	}
	
	// ȸ���߰��� ���� ������ ȸ�� ����Ÿ �����ؼ� �׳������� ����Ÿ �߰�
	public boolean setInsertMember(Member insertMember){	// ȸ�� �߰� ����
		Member tmpMember, lastOldMember;// ����ȸ���� �ű�ȸ��
		int tmpSize;	// ȸ������Ÿ ������ �ӽ�����;

		
		tmpSize = this.shopmem.size();			
		if( tmpSize >0 ) {	// ȸ������Ʈ�� �ϳ��� �ִٸ� ����������Ÿ ���� 
			lastOldMember = this.shopmem.get(this.shopmem.size()-1);		// ���͵���Ÿ�� shopmem���� ������ ȸ�������� �����Ѵ�.
			insertMember.setNum(lastOldMember.getNum()+1);				// ���͵���Ÿ�� �߰��� ȸ�������� ��ȣ�� ������ ȸ�������� ��ȣ+1�� �����Ѵ�. 
		} else { //ȸ�������� ���ٸ�
			insertMember.setNum(1); // �߰��� ȸ������ ��ȣ�� 1�� ����
		}
		
		// ����Ÿ ����ó���� �Է����������� ó���ϰų� ���⼭ó�� //* ����ó���� �ؾߵȴ�.
		this.insertmember = insertMember;			// �Էµ� ȸ������Ÿ ����
		this.shopmem.addElement(insertMember);	// �������� ó�� try
		return true;
	}
	public Member getInsertMember(){	// �߰�ȸ�� ����
		return this.insertmember;	//�߰�ȸ�� ����
	}
	public void setUpdateMember(Member updateMember){	// ȸ�� ���� ����
		this.updatemember = updateMember;
	}
	public Member getUpdateMember(){	// ȸ�� ���� ����
		return this.updatemember;
	}
	public void setDeleteMember(Member deletemember){	// ȸ�� ���� ����
		this.deletemember = deletemember;
	}
	public Member getDeleteMember(){	// ȸ�� ���� ����
		return this.deletemember;
	}
	/*
	public Member getFindMember(String type){	// ȸ�� type �˻� ����
		return new Member();
	}	
	public Member getFindMember(String id){	// ȸ�� ���̵�˻� ����
		return new Member();
	}	
	public Member getFindMember(String name){	// ȸ�� �̸��˻� ����
		return new Member();
	}
	public Member getFindMember(int Ranking){	// ȸ�� ��ŷ�˻� ����
		return new Member();
	}
	public Member getFindMember(String address){	// ȸ�� �����˻� ����
		return new Member();
	}
	public Member getFindMember(String menuname, int menuprice){	// ȸ�� �޴�/���ݰ˻� ����
		return new Member();
	}
	public Member getFindMember(String tel){	// ȸ�� ��ȭ�˻� ����
		return new Member();
	}*/
	
	public void setRecoveryMember(Member recoverymember){	// ȸ�� ���� ����
		this.recoverymember = recoverymember;
	}
	public Member getRecoveryMember(){	// ȸ�� ���� ����
		return this.recoverymember;
	}
	public void setLineperage(int line){	// �������� ���μ� ����
		this.lineperpage = line*1;
	}
	public void setNowpage(int nowp){// ���������� 0-9, 10-19, 20-29// 0 �������� �Ǹ� ȭ����� ����
		this.nowpage = nowp*1;
	}
	public int getShopcnt(){				// �����Ѽ� ��������
		return this.shopmem.size()*1;
	}
	public int getLineperage(){			// �������� ���μ� ��������
		return this.lineperpage*1;
	}
	public int getFirstpage(){				// ù������ ��������
		return 1;
	}
	public int getAllpage(){				// �������� ��������
		return (this.getShopcnt()/this.getLineperage()+1)*1;
	}
	public int getNowpage(){				// ���������� 0-9, 10-19, 20-29// 0 �������� �Ǹ� ȭ�����  ��������
		return this.nowpage*1;
	}
	public int getNextpage(){				// ���������� �������� ����
		int tmp;																						// ���������� �ӽ� ���尪

		if( this.getNowpage() >= this.getAllpage() )  tmp = this.getAllpage();				// ������������ ��ü���������� ũ�ų� ���ٸ� ��ü��������
		else if( this.getNowpage() < this.getFirstpage() )  tmp = this.getFirstpage();		// ������������ ù���������� ���ٸ� ù��������
		else tmp = this.getNowpage() + 1;														// �׿ܴ� ���������� + 1 ���� tmp�� �Ҵ��Ѵ�.
		return tmp;
	}
	public int getPrevpage(){				// ���������� ��������
		int tmp;																						// ���������� �ӽ� ���尪
		if( this.getNowpage() <= this.getFirstpage() )  tmp = this.getFirstpage();			// ������������ 1���� �۰ų� ���ٸ� 1��������
		else if( this.getNowpage() > this.getAllpage() )  tmp = this.getAllpage()-1;		// ������������ ��ü���������� ũ�ų� ���ٸ� ��ü������-1
		else tmp = this.getNowpage() - 1;														// �׿ܴ� ���������� + 1 ���� tmp�� �Ҵ��Ѵ�.
		return tmp;
	}
	public int getLastpage(){				// �������� ��������
		return this.getAllpage()*1;
	}
	public void previewCls(JPanel o){
		o.removeAll();			// sPanel_2_1 �г� ���� ���� - ��������Ʈ��ư ��ü ����
		o.revalidate();				// sPanel_2_1 �г� ���� Ȯ��
		o.repaint();				// sPanel_2_1 �г� �ٽ� �׸���
		//revalidate(); 			// frame ��Ȯ��
		//repaint();				// frame �ٽ� �׸���	
		
	}	
	// �׽�Ʈ�� ���ؼ� Vector ��ȣ�� �������ش�.  ---------> ���� ���� �����ȣ�� �������ش�.
	public Member infoMember(int idx){ // �Խ��ǿ��� �������� �Ҷ� ���� ȸ������ �����ϱ� ���� �Լ�
		return this.shopmem.get(idx);	
	}
	public void previewList(View_Box fBox, JPanel listPane){// ���ڰ�( ȭ����ü ��� �ڽ��г�=win=fBox , ������ư ����Ʈ ��� �ڽ��г�)
		
        // ���� ����Ʈ ��� ���� - //JButton list3 = new JButton("3 �����̸� | ��ȭ��ȣ | ����");			
		// ������ư ����Ʈ �۾�
		this.previewCls(listPane);				// ����Ʈ ��� �ڽ��г� �ٽ� ������� �ʱ�ȭ �۾�
		listButton.clear();							// �̰� �����ָ� ������ �׷��� ��ư�� ������ ���� ��ü listButton = new Vector<JButton>();
		//fBox.VectorShopMemberListIndex;	// �������⿡ ��ȣ�� �����ϱ� ���� ���� �������� View_Box������ ���� ����
        for(int i=(getNowpage()-1)*getLineperage(), k=0; i < (getNowpage())*getLineperage(); i++,k++ ){
    		try{
    			//protected Member VectorShopMemberInfo
    			// ���������� Vector �迭��ȣ �����ؼ� actionPerformed�� ���� 
    			// �������⿡ ��ȣ�� �����ϱ� ���� ���� ��������
    			int tmpNum = i; //���ͼ��� �����ϴ� ����
    			String str1 = "" + (i+1) + ". ���� :  " + shopmem.elementAt(i).getName() + " ����";		// ��ư�� ���� ���� ����
    			listButton.addElement(new JButton(str1));														// ����Ʈ��  jbutton��ü�� ���� �߰�
    			listButton.elementAt(k).setHorizontalAlignment(SwingConstants.LEFT);						// ��ư���� ��������
    			listButton.elementAt(k).addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {											// ��ư ������ �̺�Ʈó���Լ� ó��
						// ��ư Ŭ�������� Member ��ü Ÿ���� �������� �̵��Ѵ�.
						// ���� �����ϴ� ������ ������ �ϰ� �Ǹ� ���� ������ �ȵȴ�.
						fBox.VectorShopMemberInfo = infoMember(Integer.valueOf(tmpNum));			// for�� ���� i�� ���޵��� �ʾƼ� for�� �������� tmpNum�� ������ ������ ���簪 Member��ü ���� ����� ����.
    					JOptionPane.showMessageDialog(null, str1 );											// ��ư ���� ����
    					//fBox.shopMemberView = shopmem.elementAt(i).getId();							// ����ȸ�� ��ȣ
    					fBox.change("view_9"); 																		// �ش� �������� �̵�
    					//$$ win ����Ŭ���� ���鶧 ����
    				}
    			});
    			listPane.add(listButton.elementAt(k));	
    			listPane.validate();//$$ sPanel_2_1 ����Ŭ���� ���鶧 ����
    		} catch(ArrayIndexOutOfBoundsException e){														// listButton �迭������ ���� ��� ����ó��
    			System.out.println(" i = " + i + "ArrayInexOutOfBoundsException ������ �����ϴ�.");	// ����� �ϱ� ���ؼ� ������
    		} finally {
    		}
        }//for
	}// public void previewList(View_Box fBox, JPanel listPane)
	//public void setShopcnt(){}			// �����Ѽ� ����
	//public void setFirstpage(int first){}	// ù������ ����
	//public int setAllpage(){}				// �������� ����
	//public int setNextpage(){}			// ���������� ����
	//public int setPrevpage(){}				// ���������� ����
	//public void setLastpage(){}			// �������� ����
	
	
}	//// class ShopMemberList --------------------------------------




///////////////////////////////////////////////////////////////////////////
/// class Member ��� - ����ȸ�� 1���� ��� Ŭ����
///	(���߿� ������ ȸ�� ������ Ȯ���ؼ� �����)
///////////////////////////////////////////////////////////////////////////
class Member {
	public int num;				// ��Ϲ�ȣ
	public String id;				// ��Ͼ��̵�
	public String pass;			// ����н�
	public String name;			// ���� �̸�
	public String shopimg;		// ���� ���� �̹���
	public String type;			// ����
	public String tel;			// ��ȭ��ȣ
	public String juso;			// �ּ�
	public String mapinfo;		// ���� ��ȳ���
	public int ranking;			// ����
	public String mapimg;		// �����̹���
	public String folist;			// �������� ����Ʈ
	public String folistimg; 	// �����̹��� ����Ʈ
	
	// ���͹�ȣ, ���̵�, ��й�ȣ, �������ǻ���, �����̸�, ����, ��ȭ��ȣ, �ּ�, ����, �����̹���, �������� ����Ʈ, �����̹��� ����Ʈ
	// int num, String id, String pass, String shopimg, String name, String type, String tel, String juso, String mapinfo, int ranking, String mapimg, String foodlist, String foodlistimg 
	public Member(int num, String id, String pass, String shopimg, String name, String type, String tel, String juso, String mapinfo, int ranking, String mapimg, String foodlist, String foodlistimg ) {
		setNum(num);				// ��ȣ
		setId(id);						// ���̵�
		setPass(pass);				// ��й�ȣ
		setShopimg(shopimg);		// ���� ����
		setName(name);				// ���� �̸�
		setType(type);				// ����
		setTel(tel);						// ��ȭ��ȣ
		setJuso(juso);				// �ּ�
		setMapinfo(mapinfo);		// ���� ��ȳ� �Ұ�
		setRanking(ranking);		// ����
		setMapimg(mapimg);		// �����̹���
		setFolist(foodlist);			// �������� ����Ʈ
		setFolistimg(foodlistimg); 	// �����̹��� ����Ʈ
	}

	public int getNum(){							// ��ȣ
		return this.num;
	}
	public void setNum(int num){				// ��ȣ
		this.num = num;
	}
	public String getId(){							// ���̵�
		return this.id;
	}
	public void setId(String id){					// ���̵�
		this.id = id;
	}
	public String getPass(){						// ��й�ȣ
		return pass;
	}
	public void setPass(String pass){				//��й�ȣ
		this.pass = pass;
	}
	public String getName(){						// �����̸�
		return this.name;
	}
	public void setName(String name){			//�����̸�
		this.name = name;
	}
	public String getShopimg(){					// ���� ���� �̹���
		return this.shopimg;
	}
	public void setShopimg(String shopimg){	// ���� ���� �̹���
		this.shopimg = shopimg;
	}
	public String getMapinfo(){					// �����Ұ�
		return mapinfo;
	}
	public void setMapinfo(String mapinfo){	//�����Ұ�
		this.mapinfo = mapinfo;
	}
	public String getType(){						// ����
		return this.type;
	}
	public void setType(String type){				// ����
		this.type = type;
	}
	public String getTel(){							// ��ȭ��ȣ
		return this.tel;
	}
	public void setTel(String tel){					// ��ȭ��ȣ
		this.tel = tel;
	}
	public String getJuso(){						// �ּ�
		return this.juso;
	}
	public void setJuso(String juso){				// �ּ�
		this.juso = juso;
	}
	public int getRanking(){						// ����
		return this.ranking;
	}
	public void setRanking(int ranking){		// ����
		this.ranking = ranking;
	}
	public String getMapimg(){					// �����̹���
		return this.mapimg;
	}
	public void setMapimg(String mapimg){	// �����̹���
		this.mapimg = mapimg;
	}
	public String getFolist(){						// �������� ����Ʈ
		return this.folist;
	}
	public void setFolist(String folist){			// �������� ����Ʈ
		this.folist = folist;
	}
	public String getFolistimg(){					// �����̹��� ����Ʈ
		return this.folistimg;
	}
	public void setFolistimg(String folistimg){	// �����̹��� ����Ʈ
		this.folistimg = folistimg;
	}	
	
	public String allPrint(){							// �ʿ��� �ʵ� �������� ���Ѱ�
		return new String(getNum() + "," + getId() + "," + getPass());
	}
}	//// Member Class --------------------------------------













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
