package Chat_V5;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class ChatWindow extends JFrame implements ActionListener,MouseListener, Runnable {
	private static final int SERVER_PORT = 5000;
//	private static final String SERVER_IP = "192.168.219.198";
	private static final String SERVER_IP = "127.0.0.1";
	
	JFrame Login_f, Chatmain_f, Frofile_f, Emoticon_f;
	private JPanel contentPane;
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
	Vector<User> User_list = new Vector<User>();
	String cnt = "0";
	int User_cnt = 0, user_idx = 0;
	int frofile_idx; // ������ ���� index
	ImageIcon frofile1 = null;
	
	
	
	
	
	
	
	
	public ChatWindow() {
		Login();
	}

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

	}

	public void Chatmain(String id, int frofile_idx) {
		//setIF(id, frofile);
		Chatmain_f = new JFrame();
		// this.textArea.append("[ "+this.id+" ] ���� �����ϼ̽��ϴ�.");
		Chatmain_f.setTitle("\uCC44\uD305");						// �г� ����
		Chatmain_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// �г� ����
		Chatmain_f.setBounds(100, 100, 546, 378);					// �г� ũ��,��ġ
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Chatmain_f.add(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");			// �Է� : ���̺�
		panel.add(lblNewLabel);

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
		textArea.setBounds(12, 10, 333, 276);
		textArea.setEditable(false);
		panel_1.add(textArea);
		// this.textArea.append("[ " + id_tf.getText() + " ] ���� �����ϼ̽��ϴ�.\n");
//		User_cnt = Integer.parseInt(cnt);
//		User_cnt++;
//		UserCount_Label.setText(Integer.toString(User_cnt));
		Chatmain_f.setVisible(true);
	}



	public void Frofile() {
		Frofile_f = new JFrame();
		Dimension dim = new Dimension(396,425);
		Frofile_f.setPreferredSize(dim);
		Frofile_f.setTitle("\uD504\uB85C\uD544");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frofile_f.setBounds(100, 100, 231, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Frofile_f.add(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		

		//ImageIcon frofile1 = null;
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		frofile1 = new ImageIcon("images/������01.png");
		JLabel image1 = new JLabel(frofile1);
//		image1.setIconTextGap(10);////////////////////////////////////////////�߰�
		GridBagConstraints gbc_image1 = new GridBagConstraints();
		gbc_image1.insets = new Insets(0, 0, 5, 5);
		gbc_image1.gridx = 0;
		gbc_image1.gridy = 0;
		panel.add(image1, gbc_image1);
		image1.addMouseListener(this);
		
		ImageIcon frofile2 = new ImageIcon("images/������02.png");
		JLabel image2 = new JLabel(frofile2);
		GridBagConstraints gbc_image2 = new GridBagConstraints();
		gbc_image2.insets = new Insets(0, 0, 5, 5);
		gbc_image2.gridx = 1;
		gbc_image2.gridy = 0;
		panel.add(image2, gbc_image2);
		image2.addMouseListener(this);
		
		ImageIcon frofile3 = new ImageIcon("images/������03.png");
		JLabel image3 = new JLabel(frofile3);
		GridBagConstraints gbc_image3 = new GridBagConstraints();
		gbc_image3.insets = new Insets(0, 0, 5, 0);
		gbc_image3.gridx = 2;
		gbc_image3.gridy = 0;
		panel.add(image3, gbc_image3);
		image3.addMouseListener(this);
		
		ImageIcon frofile4 = new ImageIcon("images/������04.png");
		JLabel image4 = new JLabel(frofile4);
		GridBagConstraints gbc_image4 = new GridBagConstraints();
		gbc_image4.insets = new Insets(0, 0, 5, 5);
		gbc_image4.gridx = 0;
		gbc_image4.gridy = 1;
		panel.add(image4, gbc_image4);
		image4.addMouseListener(this);
		
		ImageIcon frofile5 = new ImageIcon("images/������05.png");
		JLabel image5 = new JLabel(frofile5);
		GridBagConstraints gbc_image5 = new GridBagConstraints();
		gbc_image5.insets = new Insets(0, 0, 5, 5);
		gbc_image5.gridx = 1;
		gbc_image5.gridy = 1;
		panel.add(image5, gbc_image5);
		image5.addMouseListener(this);
		
		ImageIcon frofile6 = new ImageIcon("images/������06.png");
		JLabel image6 = new JLabel(frofile6);
		GridBagConstraints gbc_image6 = new GridBagConstraints();
		gbc_image6.insets = new Insets(0, 0, 5, 0);
		gbc_image6.gridx = 2;
		gbc_image6.gridy = 1;
		panel.add(image6, gbc_image6);
		image6.addMouseListener(this);
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		Frofile_f.setVisible(true);

	}

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
	}
	public void setIF(String id, int frofile_idx){
		this.id=id;
		this.frofile_idx = frofile_idx;
	}

	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		if (ob == connect_btn) {
			this.setTitle("�������̸� :" + id_tf.getText());
			id = id_tf.getText();
			
//			String ids = id_tf.getText();
//			this.setTitle("�������̸� :" + ids.toString());
			

			Login_f.dispose();
			Chatmain(id, frofile_idx);
			setIF(id,frofile_idx);

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
			pw.println(id_tf.getText() + " �� ����");
			pw.flush();

			System.exit(1);
		}
	}

	public void send() {
		String text = send_tf.getText();
		if (text.equals("q") || text.equals("quit")) {
			// text = id + " ä�ù� ����";
			pw.println(id_tf.getText() + " �� ����");
			pw.flush();
			/// System.out.println("ä������ ���α׷��� ����˴ϴ�");

			System.exit(1);
		}

		send_tf.setText("");
		send_tf.requestFocus();
		pw.println(text);
		pw.flush();
	} // end

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
			pw.println(user.id);
			pw.flush();
			
			// sockInPull......
			InputStream is = sock.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));


////////////////////////// Ŭ���̾�Ʈ ��ū ���� ////////////////////////////////////
//	    	TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]				
//	    	TCP:::stateChat:::id:::whisperId:::idList:::chatContext
//	    	TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::(����Ʈ:ä��������)id1,id2,:::��ȭ������
//	    	String tcpState = "TCP:::" +"1" +":::" +id +":::" +" " +":::" +"id1,id2," +":::" +" " ;
//////////////////////////Ŭ���̾�Ʈ ��ū ���� ////////////////////////////////////

// ����/����/��ȭ
// ��ü/�ӼӸ�
			
//////////////////////////���� ��ū ���� ////////////////////////////////////
//	    	TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]				
//	    	TCP:::stateChat:::id:::whisperId:::idList:::chatContext
//	    	TCP:::(����:��ȭ��/����/����)0,1,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::(����Ʈ:ä��������)id1,id2,:::��ȭ������
//	    	String tcpState = "TCP:::" +"1" +":::" +id +":::" +" " +":::" +"id1,id2," +":::" +" " ;			
//////////////////////////���� ��ū ���� ////////////////////////////////////
			
			
			
			// Mission - > ��ȭ�� �̸�Ƽ��<������> ó�� : �ܵ����� ó��
			// 
			
			
//////////////////////////���� ��ū ���� ////////////////////////////////////
//TCP:::tokenMsg[0]:::tokenMsg[1]:::tokenMsg[2]:::tokenMsg[3]:::tokenMsg[4]				
//TCP:::stateChat:::id:::whisperId:::idList:::chatContext
//TCP:::(����:����/(��ȭ, ����))0,2:::(selfId)"",id:::(���:��ü,�ӼӸ�id)"",id:::(����Ʈ:ä��������)id1,id2,:::��ȭ������
//String tcpState = "TCP:::" +"1" +":::" +id +":::" +" " +":::" +"id1,id2," +":::" +" " ;			
//////////////////////////���� ��ū ���� ////////////////////////////////////
			
			String[] user_id = null;// list.add(user.id);
			String str;int j=0;			
			while (true) {
				
				str = br.readLine().trim();									// ���޵� ��ū�� ���۰��ļ� ���� ���� ó��
				System.out.println("Client " + (j++)  + ",str = " + str);	// ���޵� ��ü��ū���ڿ� �ҽ� ���
				
		        // split�� �̿��� ä����ū ��ü���ڿ� �и�
		        String[] tokenMsg = str.split(":::",5) ;
		        
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
		        
	        	list.removeAll();										// ����� ���� ��� �ʱ�ȭ �� > ä�ý� ���� ��� �ʱ�ȭ
		        for(int i=0; i<uCnt; i++) {
		        	list.add(usersList[i]);
		        	System.out.println("����� : " + usersList[i]); 		// ����� ��� ���
		        }

		        
		        //list �ڽ� ���ÿ� ���� ����
		        //https://sodocumentation.net/ko/swing/topic/5413/jlist
		        // https://raccoonjy.tistory.com/16
		        //list = usersList;
		        //java.awt.list.list();
//		        java.util.List<String> list = new ArrayList<String>(Arrays.asList(userList));
//				list = new List();						// ������ ����Ʈ ����
//				UserCount_Label = new JLabel("0");		// ������ ī���� ǥ�� ���̺�
//				textArea = new JTextArea();				// ä�� �����丮 ����		  
		        


		        // ******* �����ڸ���Ʈ�� ����� ��� ������Ʈ *************** //
		        // ���� �������� �����ִ� �޼����� �з�
		        // ���� / ���� / ��ȭ�� / �ӼӸ� / ��Ÿ �з�
		        if(tokenMsg[0].equals("0")) {
		        	System.out.println("���� �ϼ˽��ϴ�.");
		        	textArea.append(tokenMsg[1]+"�� ����"+"\n"+String.valueOf(this.frofile_idx));
		        } else if(tokenMsg[0].equals("1")) {
		        	System.out.println("���� �ϼ˽��ϴ�.");
		        } else if(tokenMsg[0].equals("2")) {
		        	if(tokenMsg[2].equals("") || tokenMsg[2]==null) {
			        	System.out.println("��ȭ���Դϴ�.");
			        	System.out.println(tokenMsg[4]);
			        	textArea.append(tokenMsg[1]+" :>> "+tokenMsg[4]+"\n");
		        	} else {
			        	System.out.println(tokenMsg[2] + "�� �ӼӸ����Դϴ�.");
			        	System.out.println(tokenMsg[4]);
		        	}
		        } else {
		        	System.out.println("��Ÿ��� = " + tokenMsg[4]);
		        	// ��Ÿ���
		        }

		        // ä��â�� �޼��� ���
		        // Ŭ���̾�Ʈ to ���� �޼��� ����
		        
		        
		        
		        
		        
//				String[] option = str.split(" ");
//				if (option[option.length - 1].equals("����") || option[option.length - 1].equals("����")) {
//					textArea.append(str + "\n");
//				} else if (isNum(str)) {
//					User_cnt = Integer.parseInt(str);
//				} else if(str.contains(":>>")){
//					textArea.append(str + "\n");
//				} else {
////					if(User_cnt!=1) {
//						list.replaceItem(str,User_cnt-1);
////					}else {
////						list.add(str);
////					}// if
//				}// if
//
//				// send_tf.setText(str);
//				UserCount_Label.setText(String.valueOf(User_cnt));

			}// while

			
//
//			String src ="tis  7a  9b 5";
//			String msg ="";//tis7a9b5 ��������
//			String ret ="";// 795���ڸ� ����
//			
//			
//
//			System.out.println("msg = " + src.replace(" ", ""));
//			System.out.println("ret = " + src.replaceAll("[^0-9]", ""));
//			
//
//			
//			int size = src.length();
//			
//			for(int i=0; i<size; i++) {
//				if(src.charAt(i)==' ') {
//					// msg�� ��Ʈ�����۷� �����ϴ���
//					// tmp�� ���� ��Ʈ�����۷� ���� �ϴ���
//				}else {
//					// ������ �����ϰų� ���ڸ� �����ϰų�
//				}
//			}//for
			
			
			
			
//			String[] str=null;
//			int k=0;
//			while(true) {
//				str[k]=br.readLine();
//				textArea.append(str+"\n");
//				k++;
//				if(br.readLine()==null) {
//					break;
//				}
//			}

		} catch (IOException e) {
		}
	}

	public static boolean isNum(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		new ChatWindow();

	}

	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void mouseClicked(MouseEvent e) {

		// TODO Auto-generated method stub
		Object ob = (Object)e.getSource();
		System.out.println(Frofile_f);
		
//		Object ob = e.getSource();
//		if (ob == image1) {
//			this.setTitle("�������̸� :" + id_tf.getText());
//			id = id_tf.getText();
//			
////			String ids = id_tf.getText();
////			this.setTitle("�������̸� :" + ids.toString());
//			
//
//			Login_f.dispose();
//			Chatmain(id, frofile_idx);
//			setIF(id,frofile_idx);
//
//			Thread th = new Thread(this);
//			th.start();
//
//			// list.add(user.id);
//
//		}

		
		
		if(e.getSource() == frofile1) {
			
			
			
		}else if(ob.equals("image2")) {
			
		}else if(ob.equals("image3")) {
			
		}else if(ob.equals("image4")) {
			
		}else {
			
		}

		System.out.println((JLabel)e.getSource());
		System.out.println(ob.toString());
		Frofile_f.dispose();
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}

class User {
	String id = "";
	ImageIcon frofile = null;
}