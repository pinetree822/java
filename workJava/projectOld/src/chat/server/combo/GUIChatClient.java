package chat.server.combo;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class GUIChatClient extends JFrame implements ActionListener, Runnable {
	JPanel mainPan, firstPan, twoPan;

	JLabel info;
	JButton btn_connect, btn_send, btn_exit;
	JTextField txt_server_ip, txt_name, txt_input;
	TextArea txt_list;
	CardLayout cardlayout;

	String ip_txt;
	Socket sock;
	final int PORT = 7500;
	PrintWriter pw = null;
	BufferedReader br = null;
	OutputStream os = null;


	/////////////////////////변경/////////////////////////////////
	// 콤보 박스의 아이템
	String[] fruits = { "Sad", "Fear", "Angry", "Disgust", "Joy" };

	// 이미지 객체 배열
	ImageIcon[] images = {
		new ImageIcon("images/d.jpg"),
		new ImageIcon("images/b.gif"),
		new ImageIcon("images/c.gif"),
		new ImageIcon("images/d.jpg"),
		new ImageIcon("images/c.gif"),
	};

	// 이미지 레이블 컴포넌트
	JLabel imgLabel = new JLabel(images[0]);
	// 문자열 컴포넌트
	JComboBox<String> strCombo = new JComboBox<String>(fruits);
	//////////////////////////////////////////////////////////
        
	public GUIChatClient() {
		this.setTitle("Chatting Client(ver 5.0)");
		serverConnect();
		ChatPane();

		// card-----------------------------
		cardlayout = new CardLayout();
		mainPan = new JPanel();
		mainPan.setLayout(cardlayout);
		mainPan.add(firstPan, "접속창");
		mainPan.add(twoPan, "채팅창");
		cardlayout.show(mainPan, "접속창"); // 기본선택
		// ----------------------------------
		add(mainPan);
		setBounds(200, 200, 450, 300);
		setVisible(true);

		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 이벤트처리-----------------------
		btn_connect.addActionListener(this);
		btn_exit.addActionListener(this);
		btn_send.addActionListener(this);
		txt_input.addActionListener(this);
		// ----------------------------------
	} // end

	public void serverConnect() {
		firstPan = new JPanel();
		JPanel pn = new JPanel();
		/////////////////변경//////////////////////////
		JPanel pnn = new JPanel();// 추가 레이어
		/////////////////////////////////////////
		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();

		info = new JLabel("IP와 대화명을 입력하시오");
		info.setFont(new Font("굴림체", Font.BOLD, 15));
		info.setForeground(Color.magenta);

		JLabel lb1 = new JLabel("서버 I P : ");
//		txt_server_ip = new JTextField("192.168.0.40", 15);
		txt_server_ip = new JTextField("127.0.0.1", 15);
		// txt_server_ip = new JTextField("localhost", 15);
		pn1.add(lb1);
		pn1.add(txt_server_ip);

		JLabel lb2 = new JLabel("대 화 명 : ");
		txt_name = new JTextField("young", 15);

		pn2.add(lb2);
		pn2.add(txt_name);

		//////////////////변경/////////////////////////////////
//		pn.add(strCombo);
//		pn.add(imgLabel);
		pnn.add(strCombo);
		pnn.add(imgLabel);
		//////////////////////////////////////////////////////////
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(info);
		pn.add(pnn);

		
		///////////////////////변경///////////////////////////////////
		//Action 리스너 등록
		strCombo.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Action 이벤트가 발생한 콤보박스 알아내기
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				// 콤보박스의 선택된 아이템의 인덱스 번호 알아내기.
				int index = cb.getSelectedIndex();
				// 인덱스의 이미지를 이미지 레이블 컴포넌트에 출력
				imgLabel.setIcon(images[index]);
			}
		});
		//////////////////////////////////////////////////////////
		
		btn_connect = new JButton("서버에접속Connection");
		
		
		firstPan.setBorder(BorderFactory.createTitledBorder("다중채팅화면"));
		firstPan.setLayout(new BorderLayout());
		firstPan.add(pn, "Center");
		firstPan.add(btn_connect, "South");
	} // end

	public void ChatPane() {
		twoPan = new JPanel();
		JPanel pn = new JPanel();
		txt_list = new TextArea();
		txt_input = new JTextField("", 20);
		btn_send = new JButton("전송");
		btn_exit = new JButton("종료(q,quit)");

		pn.setBorder(BorderFactory.createTitledBorder("☆대화하기☆"));
		pn.add(txt_input);
		pn.add(btn_send);
		pn.add(btn_exit);

		twoPan.setBorder(BorderFactory.createTitledBorder("♣채팅내용♣"));
		twoPan.setLayout(new BorderLayout());
		twoPan.add(txt_list, "Center");
		twoPan.add(pn, "South");
	} // end
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == btn_connect) {
			cardlayout.show(mainPan, "채팅창");
			this.setTitle("접속자이름:" + txt_name.getText());
			ip_txt = txt_server_ip.getText();
			Thread th = new Thread(this);
			th.start();
		}

		if (ob == btn_send) {
			send();
		}
		if (ob == txt_input) {
			send();
		}
		if (ob == btn_exit) {
			pw.println(txt_name.getText() + "님 퇴장합니다 client btn_exit \n");
			pw.flush();
			System.exit(1);
		}
	} // actionPerformed end

	public void send() {
		String text = txt_input.getText();
		if (text.equals("q") || text.equals("quit")) {
			text = "채팅방을 퇴장합니다";
			pw.println(txt_name.getText() + "님 퇴장합니다 client q입력 send( )메소드\n");
			pw.flush();
			System.out.println("채팅유저 프로그램이 종료됩니다");
			System.exit(1);
		}

		txt_input.setText("");
		txt_input.requestFocus();
		pw.println(text);
		pw.flush();
	} // end

	public void run() {
		try {
			sock = new Socket(ip_txt, PORT);
			String nickname = txt_name.getText();
			os = sock.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
			pw.println(nickname);
			pw.flush();
			InputStream is = sock.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));

			String str;
			while (true) {
				str = br.readLine();
				txt_list.append(str + "\n");
			} // while end
		} catch (IOException e) {
		}

	} // run end

	public static void main(String[] args) {
//		new ComboActionEx();
		new GUIChatClient();
	} // end
}// GUIChatClient class END




