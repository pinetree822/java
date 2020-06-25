package Chat_V2;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.border.EmptyBorder;

import javax.swing.*;

public class ChatWindow extends JFrame implements ActionListener, Runnable {
	private static final int SERVER_PORT = 5000;
//	private static final String SERVER_IP = "192.168.219.198";
	private static final String SERVER_IP = "127.0.0.1";

	JFrame Login_f, Chatmain_f, Frofile_f, Emoticon_f;
	private JPanel contentPane;
	private JTextField ip_tf, id_tf, send_tf;
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

	public ChatWindow() {
		Login();
	}

	public void Login() {
		Login_f = new JFrame();
		Login_f.setTitle("로그인");
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

		lblNewLabel = new JLabel("서버 ip :");
		lblNewLabel.setBounds(113, 84, 57, 15);
		panel.add(lblNewLabel);
		
//		ip_tf = new JTextField("192.168.219.198");
		ip_tf = new JTextField(SERVER_IP);
		ip_tf.setBounds(181, 81, 116, 21);
		panel.add(ip_tf);
		ip_tf.setColumns(10);

		lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(113, 129, 57, 15);
		panel.add(lblNewLabel_1);

		id_tf = new JTextField("unknown");
		id_tf.setBounds(181, 126, 116, 21);
		panel.add(id_tf);
		id_tf.setColumns(10);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		frofile_btn = new JButton("프로필");
		frofile_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frofile();
			}
		});
		panel_1.add(frofile_btn);

		connect_btn = new JButton("입장");
		connect_btn.addActionListener(this);
		panel_1.add(connect_btn);
		Login_f.setVisible(true);

	}

	public void Chatmain(String id, ImageIcon frofile) {
		
		setIF(id, frofile);
		Chatmain_f = new JFrame();
		// this.textArea.append("[ "+this.id+" ] 님이 입장하셨습니다.");
		Chatmain_f.setTitle("채팅");
		Chatmain_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Chatmain_f.setBounds(100, 100, 546, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Chatmain_f.add(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("입력 : ");
		panel.add(lblNewLabel);

		send_tf = new JTextField();
		send_tf.addActionListener(this);
		panel.add(send_tf);
		send_tf.setColumns(20);

		
		
		Emoticon_btn = new JButton("이모티콘");
		Emoticon_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emoticon();
			}
		});
		panel.add(Emoticon_btn);

		send_btn = new JButton("전송");
		send_btn.addActionListener(this);
		panel.add(send_btn);

		Exit_btn = new JButton("나가기");
		Exit_btn.addActionListener(this);
		panel.add(Exit_btn);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(357, 10, 154, 276);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("접속자 리스트 : ");
		lblNewLabel_1.setBounds(10, 10, 100, 15);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("총 인원 수 :");
		lblNewLabel_2.setBounds(10, 251, 64, 15);
		panel_2.add(lblNewLabel_2);

		list = new List();
		list.setBounds(10, 31, 134, 214);
		panel_2.add(list);

		UserCount_Label = new JLabel("0");
		UserCount_Label.setBounds(85, 251, 44, 15);
		panel_2.add(UserCount_Label);
//		UserCount_Label.setText(sock.si);

		textArea = new JTextArea();
		textArea.setBounds(12, 10, 333, 276);
		textArea.setEditable(false);
		panel_1.add(textArea);
		// this.textArea.append("[ " + id_tf.getText() + " ] 님이 입장하셨습니다.\n");
//		User_cnt = Integer.parseInt(cnt);
//		User_cnt++;
//		UserCount_Label.setText(Integer.toString(User_cnt));
		Chatmain_f.setVisible(true);
	}

	public void setIF(String id, ImageIcon frofile) {
		this.id = id;
		this.frofile = frofile;
	}

	public void Frofile() {
		Frofile_f = new JFrame();
		Frofile_f.setTitle("이미지 없음");
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

		JLabel Image_label = new JLabel("이미지 없음");
		Image_label.setBounds(12, 10, 181, 145);
		panel.add(Image_label);

		JButton Frofile_select_btn = new JButton("선택");
		Frofile_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frofile_f.dispose();
			}
		});
		Frofile_select_btn.setBounds(108, 142, 97, 23);
		panel.add(Frofile_select_btn);
		Frofile_f.setVisible(true);

	}


	// 이모티콘 리스트 만들어서 배열화 시켜서 각각의 이모티콘을 선택해서
	// 입력창에 보낸다.
	public void Emoticon() {
		Emoticon_f = new JFrame();
		Emoticon_f.setTitle("이모티콘");
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

		JButton Em_select_btn = new JButton("나가기");
		Em_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emoticon_f.dispose();
			}
		});
		contentPane.add(Em_select_btn, BorderLayout.SOUTH);
		Emoticon_f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == connect_btn) {

			this.setTitle("접속자이름 :" + id_tf.getText());
			System.out.println("log1 접속자이름: " + id_tf.getText());
			Login_f.dispose();
			System.out.println("log2 접속자이름: " + id_tf.getText());
			Chatmain(id, frofile);
			
			System.out.println("log3 접속자이름: " + id_tf.getText());
			Thread th = new Thread(this);
			th.start();
			System.out.println("log4 접속자이름: " + id_tf.getText());
			// list.add(user.id);
			
		}

		if (ob == send_btn) {
			send();
		}
		if (ob == send_tf) {
			send();
		}
		if (ob == Exit_btn) {
			pw.println(id_tf.getText() + " 님 퇴장");
			pw.flush();

			System.exit(1);
		}
	}

	public void send() {
		String text = send_tf.getText();
		if (text.equals("q") || text.equals("quit")) {
			//text = id + " 채팅방 퇴장";
			pw.println(id_tf.getText() + " 님 퇴장");
			pw.flush();
			System.out.println("채팅유저 프로그램이 종료됩니다");

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

			
			////////// 수정 ////////////////////////////////////////////////////
			user.id = id_tf.getText();
			user.frofile = null;

			os = sock.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
			pw.println(user.id);
			pw.flush();

			InputStream is = sock.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			// list.add(user.id);

			
			String str=null;
			while ((str=br.readLine())!=null) {

//				if((str=br.readLine())==null) break;
				System.out.println("ServerMsg = " + str);///////////////////
				/////////////////////////////////////////////////////////
				// chatMain()에서 textArea = new TextArea() 초기화 되서 에러남
				///////////////////////////////////////////////////////
				textArea.append(str + "\n");
//				String[] user_id = str.split(" ");
//				String option = str.substring(str.length() - 2, str.length());
//				
//				
//				if (option.equals("입장")) {
//					list.add(user_id[0], User_cnt);
//					User_cnt++;
//					User_list.add(user);
//					UserCount_Label.setText(String.valueOf(User_cnt));
//				} else if (option.equals("퇴장")) {
//					for (int i = 0; i < list.getItemCount(); i++) {
//						if (user_id[0].equals(list.getItem(i))) {
//							list.remove(i);
//						}
//					}
//					User_cnt--;
//					UserCount_Label.setText(String.valueOf(User_cnt));
//				}
				
				
				// User_cnt++;

			} // while end
		} catch (IOException e) {
			try {
				os.close();
				pw.close();
				br.close();
				sock.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ChatWindow();

	}

}

class User {
	String id = "";
	ImageIcon frofile = null;
}