package Chat_V3;



import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.border.EmptyBorder;

import javax.swing.*;

public class ChatWindow extends JFrame implements ActionListener, Runnable {
	private static final int SERVER_PORT = 5000;
//	private static final String SERVER_IP = "192.168.219.198";
	private static final String SERVER_IP = "127.0.0.1";

	JFrame Login_f, Chatmain_f, Frofile_f, Emoticon_f;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField ip_tf, id_tf, send_tf;;
	private Socket socket;
	private BufferedWriter bw;
	private JTextArea textArea;
	JButton Exit_btn, Emoticon_btn, frofile_btn, send_btn, connect_btn;
	List list;
	PrintWriter pw = null;
	BufferedReader br = null;
	OutputStream os = null;
	JPanel panel, panel_1;
	JLabel lblNewLabel, lblNewLabel_1, UserCount_Label;
	String id = "";
	String ip = "";
	ImageIcon frofile = null;
	Socket sock;
	User user = new User();
	Choice choice = new Choice();
	Vector<User> User_list = new Vector<User>();
	String cnt = "0";
	int User_cnt = 0, user_idx = 0;

	public ChatWindow() {
		Login();
	}// ChatWindow()

	public void Login() {
		Login_f = new JFrame();
		Login_f.setTitle("�α���");
		Login_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Login_f.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Login_f.add(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNewLabel = new JLabel("\uC11C\uBC84 ip :"); // ���� ������ ���̺�
		lblNewLabel.setBounds(113, 84, 57, 15);
		panel.add(lblNewLabel);

//		ip_tf = new JTextField("192.168.219.198");
		ip_tf = new JTextField(SERVER_IP);	// ���������� �Է� ����
		ip_tf.setBounds(181, 81, 116, 21);
		panel.add(ip_tf);
		ip_tf.setColumns(10);

		lblNewLabel_1 = new JLabel("ID :");	// ���̵� ���̺�
		lblNewLabel_1.setBounds(113, 129, 57, 15);
		panel.add(lblNewLabel_1);

		id_tf = new JTextField("unknown"); // ������̸� �Է� ����
		id_tf.setBounds(181, 126, 116, 21);
		panel.add(id_tf);
		id_tf.setColumns(10);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		frofile_btn = new JButton("\uD504\uB85C\uD544");	// ������ ��ư
		frofile_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frofile();
			}
		});
		panel_1.add(frofile_btn);

		connect_btn = new JButton("\uC785\uC7A5"); // �����ϱ� ��ư
		connect_btn.addActionListener(this);
		panel_1.add(connect_btn);
		Login_f.setVisible(true);

	}// Login()

	public void Chatmain(String id, ImageIcon frofile) {
		setIF(id, frofile);
		Chatmain_f = new JFrame();
		// this.textArea.append("[ "+this.id+" ] ���� �����ϼ̽��ϴ�.");
		Chatmain_f.setTitle("\uCC44\uD305");						// �г� ����
		Chatmain_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// �г� ����
		Chatmain_f.setBounds(100, 100, 600, 378);					// �г� ũ��,��ġ
//		Chatmain_f.setBounds(100, 100, 546, 378);					// �г� ũ��,��ġ
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Chatmain_f.add(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		
		
		////////////////////////////����:�ӼӸ� ����Ʈ ȭ�� ��� - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////
		//JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");// �Է�
		
		
		//choice.setSize(20, 35);
		//choice.add("�ӼӸ�");
		//choice.add("Apple");
		//choice.add("���̵�");
		
		//choice.add(textField.getText());
		//choice.select(choice.getItemCount()-1);
		//
		//String data = "������ ������ : "
		//+ choice.getItem(choice.getSelectedIndex())
		//+ statusLabel.setText(data);
		//
		//choice.getSelectedObjects();
		//choice.getSelectedItem();
		//choice.remove(choice.getSelectedIndex());
		//choice.removeAll();      
		//choice.addItem(item);
		//panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");			// �Է� : ���̺�
		panel.add(lblNewLabel);
		
		choice = new Choice();										// �ӼӸ� : ���̽�
		panel.add(choice);
		
		////////////////////////////����:�ӼӸ� ����Ʈ ȭ�� ��� - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////

		send_tf = new JTextField();									// ä�� ��ȭ ����
		send_tf.addActionListener(this);
		panel.add(send_tf);
		send_tf.setColumns(20);

		Emoticon_btn = new JButton("\uC774\uBAA8\uD2F0\uCF58");		// �̸�Ƽ�� ��ư
		Emoticon_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emoticon();
			}
		});
		panel.add(Emoticon_btn);

		send_btn = new JButton("\uC804\uC1A1");						// ���� ��ư
		send_btn.addActionListener(this);
		panel.add(send_btn);

		Exit_btn = new JButton("\uB098\uAC00\uAE30");				// ������ ��ư
		Exit_btn.addActionListener(this);
		panel.add(Exit_btn);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(357, 10, 154, 276);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uC811\uC18D\uC790 \uB9AC\uC2A4\uD2B8 : ");	// ������ ����Ʈ
		lblNewLabel_1.setBounds(10, 10, 100, 15);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uCD1D \uC778\uC6D0 \uC218 :");				// �� �ο� ��
		lblNewLabel_2.setBounds(10, 251, 64, 15);
		panel_2.add(lblNewLabel_2);

		list = new List();	// ������ ����Ʈ ����
		list.setBounds(10, 31, 134, 214);
		
		panel_2.add(list);

		UserCount_Label = new JLabel("0");		// ������ ī���� ǥ�� ���̺�
		UserCount_Label.setBounds(85, 251, 44, 15);
		panel_2.add(UserCount_Label);
//		UserCount_Label.setText(sock.si);

		textArea = new JTextArea();				// ä�� �����丮 ����
		textArea.setEditable(false);
		
		// ä��â�� ��ũ�ѹٸ� �ְ�, ���� ������ ä��â ���������� ���� ���ؼ� ó��
		///////////////////////////////////////���� - ��ũ���� - 2020.06.24.14.58////////////////////////////////////////////////////////////////////
		textArea.setBounds(0, 0, 333, 276);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(12, 10, 333, 276);
		panel_1.add(scrollPane);
//		panel_1.add(textArea);
		///////////////////////////////////////���� - ��ũ���� - 2020.06.24.14.58//////////////////////////////////////
		
		// this.textArea.append("[ " + id_tf.getText() + " ] ���� �����ϼ̽��ϴ�.\n");
//		User_cnt = Integer.parseInt(cnt);
//		User_cnt++;
//		UserCount_Label.setText(Integer.toString(User_cnt));
		Chatmain_f.setVisible(true);



//		Chatmain_f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		Chatmain_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Chatmain_f.addWindowListener(new WindowAdapter(){
//        	public void windowClosing(WindowEvent e){
////        		exitProc();
//    			pw.println(id_tf.getText() + " �� ����");
//    			pw.flush();
//    			System.out.println("windowClose");
//        		try{
//        			if(pw!=null) pw.close();
//        			if(os!=null) os.close();
//        			if(br!=null) br.close();
//        			if(sock!=null){
//        				sock.close();
//        				sock=null;
//        			}
//        			dispose();
//        			System.exit(0);//���μ��� ����
//        		}
//        		catch(IOException e1){ out.println("â ����� ����: "+e1); }
//        		catch(Exception e2) {}
//        		finally {}
//        	}
//        });	

        ///////////////////����///////////////////////////////////////////////////////////////////
        //â�ݱ� �̺�Ʈ ó��---

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE // ������ �����ư ��ȿȭ
		// this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE // ������ setVisible() ȣ��
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//��ó: https://msource.tistory.com/3 [MLog]
        ////////////////////////////////////////////////////////////////////////////////////
		
		
	}// Chatamin_f()

	public void setIF(String id, ImageIcon frofile) {
		// TODO Auto-generated method stub
		this.id = id;
		this.frofile = frofile;
	}// setIf()

	public void Frofile() {
		Frofile_f = new JFrame();
		Frofile_f.setTitle("\uD504\uB85C\uD544");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frofile_f.setBounds(100, 100, 231, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Frofile_f.add(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel Image_label = new JLabel("\uC774\uBBF8\uC9C0 \uC5C6\uC74C");
		Image_label.setBounds(12, 10, 181, 145);
		panel.add(Image_label);

		JButton Frofile_select_btn = new JButton("\uC120\uD0DD");
		Frofile_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frofile_f.dispose();
			}
		});
		Frofile_select_btn.setBounds(108, 142, 97, 23);
		panel.add(Frofile_select_btn);
		Frofile_f.setVisible(true);

	}// Frofile()

	public void Emoticon() {
		Emoticon_f = new JFrame();
		Emoticon_f.setTitle("\uC774\uBAA8\uD2F0\uCF58");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Emoticon_f.setBounds(100, 100, 443, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Emoticon_f.add(contentPane);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JList Emoticon_list = new JList();
		Emoticon_list.setBounds(12, 10, 393, 280);
		panel_1.add(Emoticon_list);

		JButton Em_select_btn = new JButton("\uC120\uD0DD");
		Em_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emoticon_f.dispose();
			}
		});
		contentPane.add(Em_select_btn, BorderLayout.SOUTH);
		Emoticon_f.setVisible(true);
	}// Emoticon()

	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		if (ob == connect_btn) {
			this.setTitle("�������̸� :" + id_tf.getText());
			id = id_tf.getText();
//			String ids = id_tf.getText();
//			this.setTitle("�������̸� :" + ids.toString());

			Login_f.dispose();
			Chatmain(id, frofile);

			Thread th = new Thread(this);
			th.start();

			// list.add(user.id);

		}

		if (ob == send_btn) {
			send();
		}
		if (ob == send_tf) {
			send();
		}
		if (ob == Exit_btn) {
			////////// �����ʿ� - ���� ////////////////////////////////////////////////////
			String tcpState  = "1" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +"{ ���� }";
//			pw.println(id_tf.getText() + " �� ����");
			pw.println(tcpState);
			pw.flush();

			System.exit(1);
		}
	}// actionPerformed()

	public void send() {
		String text = send_tf.getText();
		String tcpState = "";
		if (text.equals("q") || text.equals("quit")) {
			// text = id + " ä�ù� ����";
			////////// �����ʿ� - ���� ////////////////////////////////////////////////////
			tcpState = "1" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +"{ ���� }";
//			pw.println(id_tf.getText() + " �� ����");
			pw.println(tcpState);
			pw.flush();
			/// System.out.println("ä������ ���α׷��� ����˴ϴ�");

			System.exit(1);
		}

		send_tf.setText("");
		send_tf.requestFocus();
		
		/////////////////// �����ʿ� : ��ȭ - 2020.06.24.11.13 ////////////////////////////////////////////////////
		//choice.setSize(20, 35);
		//choice.add("�ӼӸ�");
		//choice.add("Apple");
		//choice.add("���̵�");
				
		//choice.add(textField.getText());
		//choice.select(choice.getItemCount()-1);
		//      
		//String data = "������ ������ : "
		//+ choice.getItem(choice.getSelectedIndex())
		//+ statusLabel.setText(data);
		//      
		//choice.getSelectedObjects();
		//choice.getSelectedItem();
		//choice.remove(choice.getSelectedIndex());
		//choice.removeAll();      
		//choice.addItem(item);
		//panel.add(lblNewLabel);
		//////////////////////////Ŭ���̾�Ʈ ��ū ���� ////////////////////////////////////
		//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
		//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
		//TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::���̵𸮽�Ʈ:::������:::��ȭ������
		//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +"" +":::" +"" ;
		//////////////////////////Ŭ���̾�Ʈ ��ū ���� ////////////////////////////////////
		
		
		System.out.println("choice.getSelectedItem() = " + choice.getSelectedItem());// �ӼӸ� ���õ� ���̵�
		
		// ��ü���� �ӼӸ�
		if(choice.getSelectedItem().equals("�ӼӸ�"))
			tcpState = "2" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +text;// ��ü��
		else
			tcpState = "2" +":::" +user.id +":::" +choice.getSelectedItem() +":::" +"" +":::" +"" +":::" +text;// �ӼӸ�
		
		
		//pw.println(text);
		
/////////////////// �����ʿ� : ��ȭ - 2020.06.24.11.13 ////////////////////////////////////////////////////
		
		pw.println(tcpState);
		pw.flush();
	} // send()

	
	
	
	
	@Override
	public void run() {
		
		try {
			sock = new Socket(SERVER_IP, SERVER_PORT);

			////////// ���� ////////////////////////////////////////////////////
			user.id = id_tf.getText();
			user.frofile = null;
//			String userId = id_tf.getText();
//			String frofile = null;

			
			// sockOutPush......
			os = sock.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
			////////// �����ʿ� - ���� ���̵�////////////////////////////////////////////////////
			String tcpState = "0" +":::" +user.id +":::" +"" +":::" +"" +":::" +"" +":::" +"{ ���� }";
			pw.println(tcpState);
			pw.flush();
			
			// sockInPull......
			InputStream is = sock.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));


			// ����/����/��ȭ
			// ��ü/�ӼӸ�
			//////////////////////////���� ��ū ���� ////////////////////////////////////
			//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
			//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
			//TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::���̵𸮽�Ʈ:::������:::��ȭ������
			//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +"" +":::" +"" ;
			//////////////////////////���� ��ū ���� ////////////////////////////////////
			//////////////////////////Ŭ���̾�Ʈ ��ū ���� ////////////////////////////////////
			//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]:::tokenMsg[5]
			//TCP:::stateChat:::id:::whisperId:::idList:::frofile:::chatContext
			//TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::���̵𸮽�Ʈ:::������:::��ȭ������
			//String tcpState = "TCP:::" +"1" +":::" +id +":::" +"" +":::" +"id1,id2," +":::" +frofile +":::" +"" ;
			//////////////////////////Ŭ���̾�Ʈ ��ū ���� ////////////////////////////////////
			// Mission - > ��ȭ�� �̸�Ƽ��<������> ó�� : �ܵ����� ó��



			String[] user_id = null;// list.add(user.id);
			String str;int j=0;			
			while (true) {
				
				str = br.readLine().trim();									// ���޵� ��ū�� ���۰��ļ� ���� ���� ó��
				System.out.println("Client " + (j++)  + ",str = " + str);	// ���޵� ��ü��ū���ڿ� �ҽ� ���
				
		        // split�� �̿��� ä����ū ��ü���ڿ� �и�
		        String[] tokenMsg = str.split(":::",6) ;
		         
		        // ä����ū ��ü���ڿ� ���
		        System.out.println(">>> split ") ;
		        for(int i=0; i < tokenMsg.length; i++){
		            System.out.println(tokenMsg[i]) ;
		        }

		        // ����� ����Ʈ ���			
		        String usersList[] = tokenMsg[3].split(",");			// ����� ���
		        int uCnt = usersList.length;							// ����� ��
		        UserCount_Label.setText(String.valueOf(uCnt));
		        System.out.println("UserList = " + uCnt + "���Դϴ�.");
		        

////////////////////////////����:�ӼӸ� ����Ʈ ��� - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////
	        	list.removeAll();										// ����� ���� ��� �ʱ�ȭ �� > ä�ý� ���� ��� �ʱ�ȭ
	        	choice.removeAll();										// �ӼӸ� ����� ��� �ʱ�ȭ �� > ä�ý� ���� ��� �ʱ�ȭ
	        	choice.add("�ӼӸ�");										// ��ü��� ä�� , �ӼӸ��� ��� ���̵� ���
		        for(int i=0; i<uCnt; i++) {
		        	list.add(usersList[i]);								// ����� ���� ����Ʈ �߰�
		        	if(!user.id.equals(usersList[i]))
		        		choice.add(usersList[i]+"");					// �ӼӸ� �����(�ڽ�����) ����Ʈ �߰�
		        	System.out.println("����� : " + usersList[i]); 		// ����� ��� ���
		        }
////////////////////////////����:�ӼӸ� ����Ʈ ��� - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////
//
//				�ӼӸ� ����Ʈ ���  ���� ����
//
//				JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");// �Է�
//				Choice choice = new Choice();
//				panel.add(lblNewLabel);
//				panel.add(choice);
//				choice.add("Apple");
//				choice.add("���̵�");
				
//				choice.add(textField.getText());
//				choice.select(choice.getItemCount()-1);
//				      
//				String data = "������ ������ : "
//				+ choice.getItem(choice.getSelectedIndex())
//				+ statusLabel.setText(data);
//				      
//				choice.getSelectedObjects();
//				choice.getSelectedItem();//////////////////
//				choice.remove(choice.getSelectedIndex());
//				choice.removeAll();      
//				choice.addItem(item);
//				panel.add(lblNewLabel);
				
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		        
		        
		        // ******* �����ڸ���Ʈ�� ����� ��� ������Ʈ *************** //
		        // ���� �������� �����ִ� �޼����� �з�
		        // ���� / ���� / ��ȭ�� / �ӼӸ� / ��Ÿ �з�
				//	    	TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::(����):::(����):::��ȭ������
		        String headChat = "["+tokenMsg[1]+"] > ";	// [���̵�] >
		        String middleChat = "";						// [�ӼӸ�:���̵�] 
		        String tailChat = "";						// �����ϼ̽��ϴ�.
		        String allChat = "";						// [���̵�] > [�ӼӸ�:���̵�] // �����ϼ̽��ϴ�. ���� �ϼ̽��ϴ�.
		        
		        if(tokenMsg[0].equals("0")) {
		        	tailChat = "�����ϼ̽��ϴ�.";								System.out.println("���� �ϼ˽��ϴ�."); // �����ϼ̽��ϴ�.
		        	allChat = headChat + middleChat + tailChat;
		        } else if(tokenMsg[0].equals("1")) {
		        	tailChat = "���� �ϼ̽��ϴ�.";								System.out.println("���� �ϼ˽��ϴ�.");// ���� �ϼ̽��ϴ�.
		        	allChat = headChat + middleChat + tailChat;
		        } else if(tokenMsg[0].equals("2")) {

		        	if(tokenMsg[2].equals("") || tokenMsg[2]==null) {
		        		System.out.println("��ȭ���Դϴ�."); //System.out.println(tokenMsg[4]);
				        allChat = headChat + middleChat + tailChat + tokenMsg[5];
		        	} else {
//		        		System.out.println("�ӼӸ� => tokenMsg[1] = " + tokenMsg[1] + ", tokenMsg[2] = " + tokenMsg[2]);
			        	if(tokenMsg[1].equals(user.id) || tokenMsg[2].equals(user.id)) {// �޴¾��̵�� ����
			        		middleChat = "[�ӼӸ�:"+tokenMsg[2]+"] "; System.out.println(tokenMsg[2] + "�� �ӼӸ����Դϴ�."); //System.out.println(tokenMsg[4]);
					        allChat = headChat + middleChat + tailChat + tokenMsg[5];
			        	} else { // �ӼӸ��� �ش��ϴ� ���̵��̸� ����
//			        		allChat = headChat + middleChat + tailChat;
			        		allChat = "";
			        	}
		        	}// if
		        	
		        } else {
		        	System.out.println("��Ÿ��� = " + tokenMsg[5]);
		        	allChat = headChat + middleChat + tailChat;
		        	// ��Ÿ���
		        }// if
		        
//		        allChat = headChat + middleChat + tailChat + tokenMsg[5];
		        if(!allChat.equals("")) { // �޼��� �ִ°͸� ���
		        	this.textArea.append(allChat + "\n");// ä�� �����丮 ���ڿ� �Է�
		    		///////////////////////////////////////���� - ��ũ���� - 2020.06.24.14.58//////////////////////////////////////
		    		this.textArea.setCaretPosition(textArea.getDocument().getLength());// JTextArea�� ������ �߰��� ������ ��ũ���� ������ �ʰ� �ٷ� ���� ���ؼ��� ���� �ڵ带 �߰��Ѵ�.
		        }
		        
		        
		      //textArea = new JTextArea();				// ä�� �����丮 ����

		      // ä��â�� �޼��� ���
		      // Ŭ���̾�Ʈ to ���� �޼��� ����
		      //textArea.append(tokenMsg[4].toString() + "\n");
		      //this.textArea.append("[ " + id_tf.getText() + " ] ���� �����ϼ̽��ϴ�.\n");
		      //if(!tokenMsg.equals(""))
//		      	this.textArea.append("[ " + tokenMsg[4].toString() + " ] ���� �����ϼ̽��ϴ�.\n");
		        
		        
			}// while

		} catch (IOException e) {}// try
		
	}// run()

	
	public static boolean isNum(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}// inNum()

	
	public static void main(String[] args) {
		new ChatWindow();

	}// main()

}// class ChatWindow

class User {
	String id = "";
	ImageIcon frofile = null;
}// class User











//list = usersList;
//java.awt.list.list();
//java.util.List<String> list = new ArrayList<String>(Arrays.asList(userList));
//list = new List();						// ������ ����Ʈ ����
//UserCount_Label = new JLabel("0");		// ������ ī���� ǥ�� ���̺�
//textArea = new JTextArea();				// ä�� �����丮 ����		






//System.out.println("tokenMsg = " + tokenMsg.length);

// ä��â�� �޼��� ���
// Ŭ���̾�Ʈ to ���� �޼��� ����
//textArea.append(tokenMsg[4].toString() + "\n");
//this.textArea.append("[ " + id_tf.getText() + " ] ���� �����ϼ̽��ϴ�.\n");
//if(!tokenMsg.equals(""))
//	this.textArea.append("[ " + tokenMsg[4].toString() + " ] ���� �����ϼ̽��ϴ�.\n");



//String[] option = str.split(" ");
//if (option[option.length - 1].equals("����") || option[option.length - 1].equals("����")) {
//	textArea.append(str + "\n");
//} else if (isNum(str)) {
//	User_cnt = Integer.parseInt(str);
//} else if(str.contains(":>>")){
//	textArea.append(str + "\n");
//} else {
////	if(User_cnt!=1) {
//		list.replaceItem(str,User_cnt-1);
////	}else {
////		list.add(str);
////	}// if
//}// if
//
//// send_tf.setText(str);
//UserCount_Label.setText(String.valueOf(User_cnt));







//
//String src ="tis  7a  9b 5";
//String msg ="";//tis7a9b5 ��������
//String ret ="";// 795���ڸ� ����
//
//
//
//System.out.println("msg = " + src.replace(" ", ""));
//System.out.println("ret = " + src.replaceAll("[^0-9]", ""));
//
//
//
//int size = src.length();
//
//for(int i=0; i<size; i++) {
//	if(src.charAt(i)==' ') {
//		// msg�� ��Ʈ�����۷� �����ϴ���
//		// tmp�� ���� ��Ʈ�����۷� ���� �ϴ���
//	}else {
//		// ������ �����ϰų� ���ڸ� �����ϰų�
//	}
//}//for


//String[] str=null;
//int k=0;
//while(true) {
//	str[k]=br.readLine();
//	textArea.append(str+"\n");
//	k++;
//	if(br.readLine()==null) {
//		break;
//	}
//}

