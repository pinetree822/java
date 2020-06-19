package chat.serverClientLine;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	JTextArea txtList;				// �ؽ�Ʈ��������� : ��ü ä�ñ� ����
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
		
		
		// �ʱ�ȭ�� ����� �����г�Ű ����
		this.setTitle("Tisä�� ���α׷�");				// GuClientFrame ����
		
		//////////// ��ġ�ٲٸ� ���� ���� /////////////////////
		// �ʱ�ȭ���� ī�巹�̾ƿ� ���� ������ �г� ���� ���ϱ�
		cardLayout = new CardLayout();					// cardLayout���� ����
		initMenu.setLayout(cardLayout);					// �ʱ�ȭ�鿡 cardLayout ����
		//////////// cardLayout���������� ���//////////////////
		
		
		
		
		
		initMenu.add(logInMenu,"�α���ȭ��");			// initMenu�гο� �α���ȭ��(logInMenu) �߰� ����
		initMenu.add(logOnChatMenu,"�α׿�ä��ȭ��");	// initMenu�гο� �α׿�ä��ȭ��(logOnChatMenu) �߰� ����
		
		cardLayout.show(initMenu,"�α���ȭ��");			// initMenu�гο��� "�α���ȭ��" �˻��Ͽ� �ش�Ǵ� logInMenu�� �����Ѵ�.
		this.add(initMenu);									// �ʱ�ȭ(initMenu)�г��� JFrame�� �߰�
		

		this.setBounds(200, 200, 450, 300);					// JFrame (x,y,width,height)
		this.setVisible(true);								// JFrame ���̱�

		super.setDefaultCloseOperation(EXIT_ON_CLOSE); // JFrame ������ �ݱ�
		
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

		btnConnect.addActionListener(this);
		btnExit.addActionListener(this);
		btnSend.addActionListener(this);
		txtInput.addActionListener(this);
		///////////////////// �̺�Ʈ ó�� /////////////////////
	}// GuClient()
	

	
	// ���̾ƿ� : �α��� ȭ��
	public void logInScreen() {	

		logInMenu = new JPanel();// logInMenu�г� �ʱ�ȭ(GUClientŬ�������� �����)
		
		lbAddr = new JLabel("���� I P : ");				// ���̺� : "���� I P : "
		lbNickName = new JLabel("�� ȭ �� : ");			// ���̺� : "�� ȭ �� : "
		info = new JLabel("IP�� ��ȭ���� �Է��Ͻÿ�.");	// ���̺� : "IP�� ��ȭ���� �Է��Ͻÿ�.'
		info.setFont(new Font("����ü", Font.BOLD, 15));// ���̺�(info) : ��Ʈ ����ü,��Ÿ��,ũ��
		info.setForeground(Color.magenta);				// ���̺�(info) : ��Ʈ �÷�
		
//		txtServerIp = new JTextField("192.168.0.40", 15);// �ؽ�Ʈ���� : ����������
		txtServerIp = new JTextField("127.0.0.1", 15);
		// txtServerIp = new JTextField("localhost", 15);
		txtNickName = new JTextField("Tis", 15);		// �ؽ�Ʈ���� : �г�������
		btnConnect = new JButton("����������Connection");// ��ư : ��������
		
		

		// �гα��� ���� : logInMenu > logInMenuSubAll > logInMenuSubTop
		// �гα��� ���� : logInMenu( logInMenuSubAll(logInMenuSubTop,logInMenuSubBottom) )
		logInMenuSubTop = new JPanel();		
		logInMenuSubBottom = new JPanel();
		logInMenuSubAll = new JPanel();

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

		logOnChatMenu = new JPanel();// logOnChatMenu�г� �ʱ�ȭ(GUClientŬ�������� �����)
		logOnChatMenuSubBottom = new JPanel();
		
		txtList = new JTextArea();
		txtInput = new JTextField("", 20);
		btnSend = new JButton("����");
		btnExit = new JButton("����(q,quit)");

		// logOnChatMenu > logOnChatMenuSubBottom ���� �׷���
		logOnChatMenu.setBorder(BorderFactory.createTitledBorder("��ä�ó����"));
		logOnChatMenuSubBottom.setBorder(BorderFactory.createTitledBorder("�ٴ�ȭ�ϱ��"));
		
		logOnChatMenuSubBottom.add(txtInput);	// logOnChatMenuSubBottom�� txtInput �߰�
		logOnChatMenuSubBottom.add(btnSend);	// logOnChatMenuSubBottom�� btnSend �߰�
		logOnChatMenuSubBottom.add(btnExit);	// logOnChatMenuSubBottom�� btnExit �߰�

		logOnChatMenu.setLayout(new BorderLayout());		// logOnChatMenu�гο� BorderLayout() ����
		logOnChatMenu.add(txtList, "Center");				// logOnChatMenu�гο� JTextArea�� txtList ���ڸ� �߰� Center ����
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
	

	
	// Runnable ��� ó��- ä�ø޼��� �ְ�ޱ�
	public void run() {
		try {
			sock = new Socket(ipTxt, PORT); 					// ������ ������â(Thread) ���� �������
			String nickName = txtNickName.getText();			// �α��ν� �г����� ����
			
			// �������� ������ ������.
			os = sock.getOutputStream();						// Sock�� OutputStream�� ���� 
			pw = new PrintWriter(new OutputStreamWriter(os));	// ����Ʈ��ġ��(OutputStreamWriter)�� ����
			pw.println(nickName);								// �����ġ�� �޼���(nickName) ���
			pw.flush();											// ��� �޼��� ���
			
			// �������� ������ �޴´�.
			InputStream is = sock.getInputStream();				// sock���� �� ������ �޾Ƽ� �д´�.
			br = new BufferedReader(new InputStreamReader(is));	// ���۸����� �б� ó���Ѵ�.

			String str;
			while (true) {
				str = br.readLine();		// ���۸����� �Ѷ��ξ� �о
				txtList.append(str + "\n");	// txtListe���ڿ� �޼����� �߰��Ѵ�.
			} // while end
		} catch (Exception e) {}

	} // run end
	
	
	
	
	
	
	// ����� �������� �̺�Ʈ ����
	public void actionPerformed(ActionEvent e) { 	// ActionEvent�� �߻��ϸ�
		
		Object ob = e.getSource();					// e ��ü ���ҽ��� objectŸ���� ob��ü�� �Ҵ�
		
		
		if (ob == btnConnect) {									// ������ ob��ü�� btnConect��ü�� �����ϴٸ�
			cardLayout.show(initMenu, "�α׿�ä��ȭ��");		// initMenu�гο��� ä��â �˻��ؼ� �ش��Ѵ� �г��� �����Ѵ�.
			this.setTitle("�������̸�:" + txtNickName.getText());// ����â�� ������ �������� �г������� ����
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








			
