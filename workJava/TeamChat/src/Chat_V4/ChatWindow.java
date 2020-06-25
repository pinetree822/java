package Chat_V4;

import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
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

		lblNewLabel = new JLabel("\uC11C\uBC84 ip :");
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

		frofile_btn = new JButton("\uD504\uB85C\uD544");
		frofile_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frofile();
			}
		});
		panel_1.add(frofile_btn);

		connect_btn = new JButton("\uC785\uC7A5");
		connect_btn.addActionListener(this);
		panel_1.add(connect_btn);
		Login_f.setVisible(true);

	}

	public void Chatmain(String id, ImageIcon frofile) {
		setIF(id, frofile);
		Chatmain_f = new JFrame();
		// this.textArea.append("[ "+this.id+" ] 님이 입장하셨습니다.");
		Chatmain_f.setTitle("\uCC44\uD305");
		Chatmain_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Chatmain_f.setBounds(100, 100, 546, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Chatmain_f.add(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		
////////////////////////////수정:귓속말 리스트 화면 출력 - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////
//		JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");// 입력


		choice = new Choice();
		panel.add(lblNewLabel);
		panel.add(choice);
//		choice.setSize(20, 35);
//		choice.add("귓속말");
//		choice.add("Apple");
//		choice.add("아이디");
		
//		choice.add(textField.getText());
//		choice.select(choice.getItemCount()-1);
//		      
//		String data = "선택한 값보기 : "
//		+ choice.getItem(choice.getSelectedIndex())
//		+ statusLabel.setText(data);
//		      
//		choice.getSelectedObjects();
//		choice.getSelectedItem();
//		choice.remove(choice.getSelectedIndex());
//		choice.removeAll();      
//		choice.addItem(item);
//		panel.add(lblNewLabel);
		
////////////////////////////수정:귓속말 리스트 화면 출력 - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////

		
		
		
		
		send_tf = new JTextField();
		send_tf.addActionListener(this);
		panel.add(send_tf);
		send_tf.setColumns(15);

		Emoticon_btn = new JButton("\uC774\uBAA8\uD2F0\uCF58");
		Emoticon_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emoticon();
			}
		});
		panel.add(Emoticon_btn);

		send_btn = new JButton("\uC804\uC1A1");
		send_btn.addActionListener(this);
		panel.add(send_btn);

		Exit_btn = new JButton("\uB098\uAC00\uAE30");
		Exit_btn.addActionListener(this);
		panel.add(Exit_btn);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(357, 10, 154, 276);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uC811\uC18D\uC790 \uB9AC\uC2A4\uD2B8 : ");
		lblNewLabel_1.setBounds(10, 10, 100, 15);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uCD1D \uC778\uC6D0 \uC218 :");
		lblNewLabel_2.setBounds(10, 251, 64, 15);
		panel_2.add(lblNewLabel_2);
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

		
		
		
		
		
		

//		Chatmain_f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		Chatmain_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Chatmain_f.addWindowListener(new WindowAdapter(){
//        	public void windowClosing(WindowEvent e){
////        		exitProc();
//    			pw.println(id_tf.getText() + " 님 퇴장");
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
//        			System.exit(0);//프로세스 종료
//        		}
//        		catch(IOException e1){ out.println("창 종료시 예외: "+e1); }
//        		catch(Exception e2) {}
//        		finally {}
//        	}
//        });	

        ///////////////////수정///////////////////////////////////////////////////////////////////
        //창닫기 이벤트 처리---

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE // 윈도우 종료버튼 무효화
		// this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE // 윈도우 setVisible() 호출
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//출처: https://msource.tistory.com/3 [MLog]
        ////////////////////////////////////////////////////////////////////////////////////
		
		
		
		

	}// chatMain()

	public void setIF(String id, ImageIcon frofile) {
		// TODO Auto-generated method stub
		this.id = id;
		this.frofile = frofile;
	}

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

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == connect_btn) {

			this.setTitle("접속자이름 :" + id_tf.getText());

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
			pw.println(id_tf.getText() + " 님 퇴장");
			pw.flush();

			System.exit(1);
		}
	}

	public void send() {
		String text = send_tf.getText();
		if (text.equals("q") || text.equals("quit")) {
			// text = id + " 채팅방 퇴장";
			pw.println(id_tf.getText() + " 님 퇴장");
			pw.flush();
			/// System.out.println("채팅유저 프로그램이 종료됩니다");

			System.exit(1);
		}

		send_tf.setText("");
		send_tf.requestFocus();
		pw.println(text);
		pw.flush();
	} // end

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			sock = new Socket(SERVER_IP, SERVER_PORT);

			////////// 수정 ////////////////////////////////////////////////////
			user.id = id_tf.getText();
			user.frofile = null;
//			String userId = id_tf.getText();
//			String frofile = null;

			os = sock.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
			pw.println(user.id);

			pw.flush();
			InputStream is = sock.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String[] user_id = null;
			// list.add(user.id);

//			String[] str = null;
//			int k=0;
//			while (br.readLine()!=null) {
//				
//
//				str[k] = br.readLine();
//				//textArea.append(str[k]+"\n");
//				k++;
//			}
			// String[] temp;
			for(int i=0;i<20;i++) {
				list.add("");
			}
			String str;
			String[] temp=new String[20];
			int k=0;
			while (true) {
				
				str = br.readLine().trim();
				String[] option = str.split(" ");
				if (option[option.length - 1].equals("입장") || option[option.length - 1].equals("퇴장")) {
					textArea.append(str + "\n");
					if(option[option.length - 1].equals("퇴장")) {
						User_cnt--;
					}
				} else if (isNum(str)) {
					User_cnt = Integer.parseInt(str);
				} else if(str.contains(":>>")){
					textArea.append(str + "\n");
				} else {
//					list.add(str);
					temp[k]=str;
					k++;
				}

//////////////////////////// 수정:귓속말 리스트 출력 - 2020.6.24.9.42 //////////////////////////////////////////////////////////////////////////

//				choice = new Choice();
				choice.removeAll();
				choice.add("귓속말");
				for(int i=0;i<User_cnt;i++) {
					list.replaceItem(temp[i], i);
					choice.add(temp[i]+"");
					//k=0;
					//
				}
//////////////////////////// 수정:귓속말 리스트 출력 - 2020.6.24.9.42  //////////////////////////////////////////////////////////////////////////


//				JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");// 입력
//				Choice choice = new Choice();
//				panel.add(lblNewLabel);
//				panel.add(choice);
//				choice.add("Apple");
//				choice.add("아이디");
				
//				choice.add(textField.getText());
//				choice.select(choice.getItemCount()-1);
//				      
//				String data = "선택한 값보기 : "
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
				// send_tf.setText(str);
				UserCount_Label.setText(String.valueOf(User_cnt));

			}

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
		// TODO Auto-generated method stub
		new ChatWindow();

	}

}

class User {
	String id = "";
	ImageIcon frofile = null;
}