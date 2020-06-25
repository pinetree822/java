package chat.serverClientLine;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.glass.ui.Window;

public class GuClient extends JFrame implements ActionListener, Runnable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/////////////////���̾ƿ����� ����/////////////////////////////////////////////
	CardLayout cardLayout;// ��üȭ�� �г� ���̾ƿ� ����
	JPanel initMenu, logInMenu, logOnChatMenu;	// �г�(�ʱ�,ù,��)ȭ�� ����
	/////////////////�α���â/////////////////////////////////////////////
	JPanel logInMenuSubTop;					// �г� : ��
	JPanel logInMenuSubBottom;				// �г� : ��
	JPanel logInMenuSubAll;					// �г� : (��,�� ����)��
	JLabel info;							// ���̺� : "IP�� ��ȭ���� �Է��Ͻÿ�"
	JLabel lbAddr, lbNickName;				// ���̺� : "����IP:", "��ȭ��"
	JButton btnConnect;						// ��ư : "��������Connection"
	JTextField txtServerIp, txtNickName;	// �ؽ�Ʈ���� : ����������, ��ȭ��
	/////////////////�α���â/////////////////////////////////////////////
	//////////////////ä��â////////////////////////////////////////////
	JPanel logOnChatMenuSubBottom;	// �г� : ��
	JScrollPane chatScroll;			// �ؽ�Ʈ�����ũ�ѻ��� : �ؽ�Ʈ������ ���� ���α�
	JTextArea txtList;				// �ؽ�Ʈ��������� : ��ü ä�ñ� ����
//	JTextArea txtList = new JTextArea() {
//		private static final long serialVersionUID = 1L;
//		public void paintComponent(Graphics g) {
//			g.drawRect(10, 10, 20, 20);
//			super.paintComponent(g);
//		}
//	};
//	
	JTextField txtInput;			// �ؽ�Ʈ���� : ä�ñ� �Է�
	JButton btnSend, btnExit;		// ��ư : ����, ����
	//////////////////ä��â////////////////////////////////////////////
	
	
	/////////////////��ɰ��� ����/////////////////////////////////////////////
	Socket sock;				// ��Ű��� ��ü
	String ipTxt;				// �α��ν� ���������� ���� ���� ����
	final int PORT = 7500;		// �����Ʈ��ȣ
	PrintWriter pw = null;		// ����Ʈ�ϱ� ���� ��ġ��ü
	BufferedReader br = null;	// ���۸� �̿��ϱ� ���� ���۸��� ��ü
	OutputStream os = null;		// ����ϱ� ���� ��Ʈ�� ��ü
	
	
	

	public GuClient() {


		//	������ ȭ�� ����(�ʱ�ȭ ȭ��), ùȭ�� ��Ÿ����, �ι�°ȭ�� ��Ÿ���� �ϱ�
		//	�޴�ȭ�� ����
		//		�α��� ȭ��(logInMenu - logInScreen) �ʱ�ȭ
		//		�α׿�ä�� ȭ��(logOnChatMenu - logOnChatScreen) �ʱ�ȭ
		//	�ʱ�ȭ ȭ��(initMenu - GuClient)
		//	���̾ƿ� : �ʱ�ȭ ȭ�� - CardLayout ����

		
		logInScreen();			// Frame�� �α��� ȭ�� ���̱� // �Լ��ȿ��� logInMenu = new JPanel() ��Ŵ
		logOnChatScreen();		// Frame�� �α׿� ä��â ȭ��// �Լ��ȿ��� logOnChatMenu = new JPanel() ��Ŵ
		initMenu = new JPanel();// Frame �ʱ�ȭ �����г�
		
//		JFrame f = new JFrame("��� ���� ���α׷�");
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Image img = toolkit.getImage("images/c.gif");
//		this.setIconImage(img);

//		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/c.gif")));
//		this.setIconImage(new Image(Toolkit.getDefaultToolkit().getImage("images/c.gif")));

		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/1.png"));
		
		// �ʱ�ȭ�� ����� �����г�Ű ����
		this.setTitle("Tisä�� ���α׷�");					// GuClientFrame ����
		
		//////////// ��ġ�ٲٸ� ���� ���� /////////////////////
		// �ʱ�ȭ���� ī�巹�̾ƿ� ���� ������ �г� ���� ���ϱ�
		cardLayout = new CardLayout();					// cardLayout���� ����
		initMenu.setLayout(cardLayout);					// �ʱ�ȭ�鿡 cardLayout ����
		//////////// cardLayout���������� ���//////////////////
		
		
		
		
		
		initMenu.add(logInMenu,"�α���ȭ��");				// initMenu�гο� �α���ȭ��(logInMenu) �߰� ����
		initMenu.add(logOnChatMenu,"�α׿�ä��ȭ��");		// initMenu�гο� �α׿�ä��ȭ��(logOnChatMenu) �߰� ����
		
		cardLayout.show(initMenu,"�α���ȭ��");				// initMenu�гο��� "�α���ȭ��" �˻��Ͽ� �ش�Ǵ� logInMenu�� �����Ѵ�.
		this.add(initMenu);								// �ʱ�ȭ(initMenu)�г��� JFrame�� �߰�
		

		
		this.setBounds(200, 200, 440, 790);				// JFrame (x,y,width,height)
		this.setVisible(true);							// JFrame ���̱�


		
		
		
		///////////��� ī�� �̺�Ʈ ó�� /////////////////////
		// JFrame�� ActionListener ����ؼ�
		// actionPerformed(ActionEvent e) ���� ó���ϰ� ����
		// addActionListener(this);�� ó���� �����ϴ�.
		//////////////////////////////////////////////////////
		// �׿� Ư���� ��� �Ʒ��� ���� ó���Ѵ�.
		//	btnConnect.addActionListener(new ActionListener() {
		//		@Override
		//		public void actionPerformed(ActionEvent e) {}
		//	});
		///////////////////////////////////////////////////////
		// JFrame ������ �ݱ� - ������ ��� (x) ǥ ������ �̺�Ʈ ȣ�� ó��
		// super.setDefaultCloseOperation(EXIT_ON_CLOSE))
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				// ������â Yes/No â
				int confirm = JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);

				if(confirm == JOptionPane.OK_OPTION) { windowSelfCloseButton(); } 	// Yes ������ windownSelfCloseButton() > msgSend() ����
				else {																// No����
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);			// â�� ���� �ʴ´�.
					return;															// null ���ϰ���ȯ�� �Ѵ�.
				}
			}// windowClosing()
		});// addWinodwListener.newWindowAdapter()
		
		btnConnect.addActionListener(this); // ����ȭ�� "����������Connection" ��ư -  Action������ �ޱ�
		btnExit.addActionListener(this);	// ä��ȭ�� "����(q,quit)" ��ư - Action������ �ޱ�
		btnSend.addActionListener(this);	// ä��ȭ�� "����" ��ư - Action������ �ޱ�
		txtInput.addActionListener(this);	// ä��ȭ�� "ä���Է�â" �ؽ�Ʈ�ڽ� - Action������ �ޱ�
		///////////////////// �̺�Ʈ ó�� /////////////////////
	}// GuClient()
	

	
	// ���̾ƿ� : �α��� ȭ��
	public void logInScreen() {	

		ImageIcon backIcon1 = new ImageIcon("images/macao1.jpg");


//		logInMenu = new JPanel();// logInMenu�г� �ʱ�ȭ(GUClientŬ�������� �����)
//      logInMenu�г� �ʱ�ȭ(GUClientŬ�������� �����)
		logInMenu = new JPanel(){
	            public void paintComponent(Graphics g) {
	                 Dimension d = getSize();
	                 g.drawImage(backIcon1.getImage(), 0, 0, d.width, d.height, null);
	                 setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	                 super.paintComponent(g);
	            }// paintComponent()
		};// new JPanel()
		
		
		lbAddr = new JLabel("���� I P : ");				// ���̺� : "���� I P : "
		lbNickName = new JLabel("�� ȭ �� : ");				// ���̺� : "�� ȭ �� : "
		info = new JLabel("IP�� ��ȭ���� �Է��Ͻÿ�.");			// ���̺� : "IP�� ��ȭ���� �Է��Ͻÿ�.'
		info.setFont(new Font("����ü", Font.BOLD, 15));	// ���̺�(info) : ��Ʈ ����ü,��Ÿ��,ũ��
		info.setForeground(Color.WHITE);				// ���̺�(info) : ��Ʈ �÷�
		
//		txtServerIp = new JTextField("192.168.0.40", 15);// �ؽ�Ʈ���� : ����������
		txtServerIp = new JTextField("127.0.0.1", 15);
		// txtServerIp = new JTextField("localhost", 15);
		txtNickName = new JTextField("Tis", 15);		// �ؽ�Ʈ���� : �г�������
		btnConnect = new JButton("����������Connection");	// ��ư : ��������
		
		

		// �гα��� ���� : logInMenu > logInMenuSubAll > logInMenuSubTop
		// �гα��� ���� : logInMenu( logInMenuSubAll(logInMenuSubTop,logInMenuSubBottom) )
		logInMenuSubTop = new JPanel();		
		logInMenuSubBottom = new JPanel();
		logInMenuSubAll = new JPanel();

		// �α��� ȭ�� ���� - �����
		logInMenuSubTop.setBackground(new Color(255, 0, 0, 0));
		logInMenuSubBottom.setBackground(new Color(255, 0, 0, 0));
		logInMenuSubAll.setBackground(new Color(255, 0, 0, 0));
		
		// ������ �гο� ������Ʈ�� �߰�
		logInMenuSubTop.add(lbAddr);
		logInMenuSubTop.add(txtServerIp);
		
		logInMenuSubBottom.add(lbNickName);
		logInMenuSubBottom.add(txtNickName);
		
		logInMenuSubAll.add(logInMenuSubTop);
		logInMenuSubAll.add(logInMenuSubBottom);
		logInMenuSubAll.add(info);
		
		
		logInMenu.add(logInMenuSubAll);// ���� ���� �г�
//		// ������Ʈ �׷��� - ����: ����ä��ȭ�� 
		logInMenu.setBorder(BorderFactory.createTitledBorder("����ä��ȭ��"));
		logInMenu.setLayout(new BorderLayout());	// logInMenu���� : BorderLayout() ����
		logInMenu.add(logInMenuSubAll, "Center");	// logInMenu���� logInMenuSubAll�� �߰� Center�� ����
		logInMenu.add(btnConnect,"South");			// logInMenu���� btnConnect�� �߰� South�� ����
		
		
	}// logInScreen()
	
	
	// ���̾ƿ� : �α׿� ä��â ȭ��
	public void logOnChatScreen() {
		
		// �α׿� ä��â ȭ�� ����̹���
		ImageIcon backIcon2 = new ImageIcon("images/macao2.jpg");

		// logOnChatMenu�г� �ʱ�ȭ(GUClientŬ�������� �����)
		logOnChatMenu = new JPanel(){
	            public void paintComponent(Graphics g) {
	                Dimension d = getSize();// JPanel ũ�� ��������
	                g.drawImage(backIcon2.getImage(), 0, 0, d.width, d.height, null); // ũ�⿡ ���� �̹��� Ȯ�����
	                setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	                super.paintComponent(g);
	           }// paintComponent()
		};// new JPanel()
		
		logOnChatMenuSubBottom = new JPanel();
		chatScroll = new JScrollPane();
//		chatScroll.setBounds(41, 56, 267, 40);
		
		


		
		txtInput = new JTextField("", 20);		// ä��â ä���Է¹ڽ�
		btnSend = new JButton("����");			// ä��â ���۹�ư
		btnExit = new JButton("����(q,quit)");	// ä��â �����ư
		txtList = new JTextArea();				// ä��â ä����¹ڽ�
		chatScroll.setViewportView(txtList);	// ä��â ��ũ�� �߰�


		// �α��� ȭ�� ���� - �����
		logOnChatMenuSubBottom.setBackground(new Color(255, 0, 0, 0));
        //Code To make transparent
        chatScroll.getViewport().setOpaque(false);
        chatScroll.setOpaque(false);
        txtList.setOpaque(false);
        //Code To make transparent
		
		
		
		
		// logOnChatMenu > logOnChatMenuSubBottom ���� �׷���
		logOnChatMenu.setBorder(BorderFactory.createTitledBorder("��ä�ó����"));
		logOnChatMenuSubBottom.setBorder(BorderFactory.createTitledBorder("�ٴ�ȭ�ϱ��"));
		
		logOnChatMenuSubBottom.add(txtInput);	// logOnChatMenuSubBottom�� txtInput �߰�
		logOnChatMenuSubBottom.add(btnSend);	// logOnChatMenuSubBottom�� btnSend �߰�
		logOnChatMenuSubBottom.add(btnExit);	// logOnChatMenuSubBottom�� btnExit �߰�

		logOnChatMenu.setLayout(new BorderLayout());		// logOnChatMenu�гο� BorderLayout() ����
		logOnChatMenu.add(chatScroll, "Center");				// logOnChatMenu�гο� JTextArea�� txtList ���ڸ� �߰� Center ����
		logOnChatMenu.add(logOnChatMenuSubBottom, "South");	// logOnChatMenu�гο� logOnChatMenuSubBottom�г��� �߰� South ����

	}// logOnChatScreen()
	
	
	
	
	// ��� - �α׿�ä��ȭ�鿡�� ä���ؽ�Ʈ�ڽ����� �޼����� ������ ���� <enter>�� ġ��
	// msgSend ȣ���Ͽ� 
	// ���ڿ��� ���Ͽ� ������ ����
	// ���ڿ��� Ʋ���� �ؽ�Ʈ�ڽ��� ���� ����� �ٽ� ���콺�� �̵���Ų��.
	public void msgSend() {
		
		String text = txtInput.getText();// ä�ñ��� text������ ����
		
		// ä�� �޼����� "q"�� "quit" ���Ͽ� ������ ä�ù��� �����Ѵ�.
		if (text.equals("q") || text.equals("quit")) {
			text = "ä�ù��� �����մϴ�";
			pw.println(txtNickName.getText() + "�� �����մϴ� client q�Է� send( )�޼ҵ�\n");
			pw.flush();
			System.out.println("ä������ ���α׷��� ����˴ϴ�");
			System.exit(1);
		}

		txtInput.setText("");		// txtInput �ؽ�Ʈ�ڽ� ���� ��������.
		txtInput.requestFocus();	// txtInput �ؽ�Ʈ�ڽ� ���� �������� �ٽ� txtInputâ���� ���콺�� �̵�
		pw.println(text);
		pw.flush();	
	}

	
	
	// WindowSelfCloseButton
	public void windowSelfCloseButton() {
		
		txtInput.setText("quit");// 
		msgSend();
	}

	
	// Runnable ��� ó��- ä�ø޼��� �ְ�ޱ�
	public void run() {
		try {
			sock = new Socket(ipTxt, PORT); 					// ������ ������â(Thread) ���� �������
			String nickName = txtNickName.getText();			// �α��ν� �г����� ����
			
			// �������� ������ ������.
			os = sock.getOutputStream();						// Sock�� OutputStream�� ���� 
			pw = new PrintWriter(new OutputStreamWriter(os));	// ����Ʈ��ġ��(OutputStreamWriter)�� ����
			pw.println(nickName);								// �����ġ(OutputStreamWriter)�� �޼���(nickName) ���
			pw.flush();											// ��� �޼��� ���
			
			// �������� ������ �޴´�.
			InputStream is = sock.getInputStream();				// sock���� �� ������ �޾Ƽ� �д´�.
			br = new BufferedReader(new InputStreamReader(is));	// ���۸����� �б� ó���Ѵ�.

			
//////////////////////////////////////////////////////////////////////////////////
			JLabel label1 = new JLabel();
			ImageIcon dog = new ImageIcon("images/3.png");
//			 http://www.java2s.com/Code/Java/Swing-JFC/TextComponentsSamplerDemo.htm
//		    JTextPane textPane = new JTextPane();
//		    StyledDocument doc = textPane.getStyledDocument();
//		    addStylesToDocument(doc);
			//protected void addStylesToDocument(StyledDocument doc) {
			
			
			
			String str;
			while (true) {
				label1.setIcon(dog);
				label1.setText("aaaa");
				str = br.readLine();		// ���۸����� �Ѷ��ξ� �о
				txtList.add(label1);
				txtList.append( str + "\n");	// txtListe���ڿ� �޼����� �߰��Ѵ�.
				
				


				
				// ä��â�� ��ũ�ѹٸ� �ְ�, ���� ������ ä��â ���������� ���� ���ؼ� ó��
				chatScroll.getVerticalScrollBar().setValue(chatScroll.getVerticalScrollBar().getMaximum());// ä��â ��ȭ�� �ϴܳ��� �����ֱ�
			} // while end
		} catch (Exception e) {}

	} // run end
	
	
	
	
	
	
	// ����� �������� �̺�Ʈ ����
	public void actionPerformed(ActionEvent e) { 	// ActionEvent�� �߻��ϸ�
		
		Object ob = e.getSource();					// e ��ü ���ҽ��� objectŸ���� ob��ü�� �Ҵ�
		
		
		// �ʱ� ������ ä��â�� ������ ������ �ϳ� ����. 
		if (ob == btnConnect) {									// ������ ob��ü�� btnConect��ü�� �����ϴٸ�
			cardLayout.show(initMenu, "�α׿�ä��ȭ��");				// initMenu�гο��� ä��â �˻��ؼ� �ش��Ѵ� �г��� �����Ѵ�.
			this.setTitle("�������̸�:" + txtNickName.getText());	// ����â�� ������ �������� �г������� ����
			ipTxt = txtServerIp.getText();						// ipTxt�� �α���â�� ������������ �����Ѵ�.
			
			// �����带 ��� �������� ä��â �ϳ��� ������ �����Ѵ�.
			// �ش� ������(������) ������ �ش� �����츸 �����Ѵ�.
			Thread th = new Thread(this);
			th.start();						// run() �ڵ� ����
			///////////////////////////////////////////////////////////////
		} else if (ob == btnSend) {		// ������ ob��ü�� btnConect��ü�� �����ϴٸ�
			msgSend();
		} else if (ob == txtInput) {	// ������ ob��ü�� txtInput��ü�� �����ϴٸ�
			msgSend();
		} else if (ob == btnExit) {		// ������ ob��ü�� btnExit��ü�� �����ϴٸ�
			
			// ����Ʈ ��ü �̿��� ���
			pw.println(txtNickName.getText() + "�� �����մϴ� client btnExit \n");
			pw.flush();					// ����� ���� ����
			
			System.exit(1);				// ������ ����(������ ����)
//			��Ż �ڵ�
//
//			������ �ߵǾ��� �� 0;
//			1, -1, whatever != 0 ������ �߻��ϸ� �ٸ� ������ ������ ���� �ٸ� ���� ����� �� �ֽ��ϴ�.
//			�ùٸ� ���� �ڵ尡 ��� (�� : UNIX)�̰� ������ ���� ��� :
//
//			1-127�� ����� ���� �ڵ��Դϴ� (���� exit(n)�� ȣ���Ͽ� �����˴ϴ�).
//			128-255�� SIGSEGV �Ǵ� SIGTERM�� ���� �ٸ� ���н� ��ȣ�� ���� ���ῡ ���� ���� �� �ڵ��Դϴ�.
		}// if
		
	}// actionPerformed()

	
	public static void main(String[] args) {
		new GuClient();
	}// main()
	
}// GuClient()





// ���̾ƿ� �������̽� ȭ��
	// �α���â
		// ȸ������
			// ���̵� �ߺ� Ȯ�� â
			// ������ �̹��� ���� â
			// ���̵��й�ȣ ã��
	// ä��â
		// ����â ����
			// ����â ����Ʈ
			// ����â �б�
		// ����� ����Ʈ
			// �����ʺ���
			// ����������
			// �ӼӸ�������
			// �����Ű��
			// ���������ϱ�
		// ����â
		// ȸ������
			// ������ �̹��� ���� â
			// ��й�ȣ ���� â
			// ������ �̹��� ���� â
			// ���� �Ϸ� â
			// ȸ�� Ż�� â > Ż�� �Ϸ� ���â


// ������ ����

// �ڵ鷯 ����
	// ���� ����
		// �޼��� ����
			// �޼��� ������
			// �޼��� �ޱ�
				// �Ϲݸ� ,�ӼӸ� > �̸�Ƽ�� ���� > ����޼���
		// ����â ����
			// ����â ����Ʈ ����
				// ������ ����
			// ����â ����Ʈ �ݱ�








			
