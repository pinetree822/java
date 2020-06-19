package chat.serverClientLine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;




public class GuServer extends Frame implements ActionListener {

	TextArea txt_list;			// �ؽ�Ʈ�ۻ��� - ������Ȳ â
	JButton btn_exit;			// ��ư - ��������
	ServerSocket ss = null;		// �������� - ��Ű����� ����
	Vector user = new Vector();	// �迭 - ä�������� ��� ���� ����� - ������ü���� ��ü ����
	

	

	
	// txt_list ������Ȳ�� ������Ʈ ��Ű�� ���
	public void setMsg(String msg) {
		txt_list.append(msg);
	}// setMsg()

	
	// serverStart() ���� - ���� ����
	public void severStart(){
		
		final int PORT = 7500; // ���� ��� ��Ʈ ����
		
		////////////////////////
		// ����/Ŭ���̾�Ʈ ��� ���� ����
		////////////////////////
		try {

			System.out.println("���� ��� ���� \n");					// �ֿܼ� ������Ȳ �Է�
			txt_list.append("���� ��� ���� \n");						// �ؽ�Ʈ�ڽ��� ������Ȳ �Է�
			txt_list.setFont(new Font("����", Font.BOLD, 14));	// �ؽ�Ʈ�ڽ� ��ƮŬ������ ��ü ����
			
			
			/////////////////// ��� ���� /////////////////// 
			ss = new ServerSocket(PORT);
			
			while(true) {
				
				Socket sock = ss.accept();// ���Ͽ����� �ʱ�ȭ�� ������� ��ü(sock)
				String ipAddr = sock.getInetAddress().getHostAddress();// ������ ������ ����Ǹ� ip������ ��ȯ > ���ڿ���ȯ
				txt_list.append(ipAddr);// ������ �ؽ�Ʈ�ڽ��� ipAddr������ �Է�
				
				// ��� �ڵ鷯 ������ ��� ����///////////////////////
				GuSHandle ch= new GuSHandle(this, sock);// �ڵ鷯 ��ü�� ������ �������� (GuServer�� ����<sock>)����
				user.addElement(ch);// ������ user�迭<Vector����޸�>�� ������ �ڵ鷯(����� ������)�� ����
				ch.start();// ������ �ڵ鷯 ��ü�� ������ �����带 ���۽�Ų��.(������ Ŭ���̾�Ʈ�� ����� �ڵ鷯�� �۵��ȴ�.)
				// ��� �ڵ鷯 ������ ��� ��///////////////////////
				
				
				
			}// while	
			/////////////////// ��� ���� /////////////////// 
			
			
		} catch (Exception e) {
			
		}// try
		////////////////////////
		// ����/Ŭ���̾�Ʈ ��� ���� ����
		////////////////////////
		
	}// serverStart()
	
	
	
	
	
	
	
	// GuServerŬ���� �ʱ�ȭ
	public GuServer() {
		
		super("Guä�� ����");
		
		// ��ü ����
		txt_list = new TextArea(); 			// ������ ����/Ż��� ä�ñ� ������Ȳ �����ֱ�
		btn_exit = new JButton("��������");	// ���� ���� ��ư : â �ݱ�
		
		// ��ü ����
		txt_list.setBackground(Color.CYAN);	// �ؽ�Ʈ������ : ��׶��� ��
		
		// Gu�� ��ü �߰�
		add(txt_list, "Center");			// ������: �ؽ�Ʈ������ �߰� , ����-Center
		add(btn_exit, "South");				// ������: ��ư �߰� , ����-South
		
		// Gu�� ����
		setSize(450, 800);					// ������: ũ�� 450, 800
		setVisible(true);					// ������: ���̱�
		
		
		// Gu Ŭ���� Implements ActionListener(�����ʿ�)
		// btn_exit ��ư�� ������ �����Ѵ�.
		btn_exit.addActionListener(this);// GuŬ������ ActionListener�� ����ؼ� Gu��ü(this)�� ���ް���
		
		// ������ â ���� ������ - Frame�� window��ü���� ����
		// ��ӹ޾� WindowAdater�� �����Ѵ�.
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {
            	System.out.println("���� ��� ����");	// �ֿܼ� ������Ȳ �Է�
    			txt_list.append("���� ��� ���� \n");		// �ؽ�Ʈ�ڽ��� ������Ȳ �Է�
                dispose();
            }
        });
        
        /////////////////////////
        severStart();// ���� ����
        /////////////////////////

		// 5�ܰ� �����ʸ� ���� --> �������ڵ鷯 ListenerHandler
//		this.btnsend.addActionListener(this);
//		this.btnexit.addActionListener(this);
	}// GuServer()
	
	// Gu Ŭ���� Implements ActionListener(�����ʿ�) - �̺�Ʈ ������ �ʿ��ϴ�.
	// btn_exit.addActionListener, this.addWindowListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// ActionEvent �߻��� e�� �����Ͽ� "btn_exit" ��ü���� Ȯ��
		if(e.getSource()==btn_exit) {
        	System.out.println("���� ��� ����");	// �ֿܼ� ������Ȳ �Է�
			txt_list.append("���� ��� ���� \n");		// �ؽ�Ʈ�ڽ��� ������Ȳ �Է�
			System.exit(0);						// system ��Ű������ ���� - ���α׷� ����
		}
	}// actionPerformed()
	
	
	
	public static void main(String[] args) {
		new GuServer();// GuServer Ŭ���� �ʱ�ȭ�� ��üȭ
	}// main()
	
}// class GuServer
