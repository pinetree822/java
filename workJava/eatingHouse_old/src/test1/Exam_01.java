package test1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Exam_01 {
	public static void main(String[] ar) {  //메인
		Exam_01_Sub es = new Exam_01_Sub();
	}
}

class Exam_01_Sub extends JFrame implements ActionListener{
	private Container con;
	private JTextField tf1 = new JTextField(10);  //아이디를 쓸 텍스트 필드
	private JPasswordField tf2 = new JPasswordField (10);  //비밀번호를 쓸 패스워드 필드
	private JButton bt1 = new JButton("등록");
	private JButton bt2 = new JButton("확인");

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	boolean member = false;

	public Exam_01_Sub() {
		super("로그인");
		this.init();
		this.start();
		this.setSize(380,100);
		this.setLocation(500,400);
		this.setVisible(true);
	}
	public void init() {  //화면 구성
		con = this.getContentPane();
		JPanel pn1 = new JPanel(new FlowLayout());
		pn1.add(new JLabel("ID"));
		pn1.add(tf1);
		pn1.add(new JLabel("Passwd"));
		pn1.add(tf2);
		JPanel pn2 = new JPanel(new FlowLayout());
		pn2.add(bt1);
		pn2.add(bt2);
		con.setLayout(new GridLayout(2,1));
		con.add(pn1);
		con.add(pn2);

	}
	public void start() {  //이벤트
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	public void connDB()  {  //DB와 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","pro","test");
			this.stmt = conn.createStatement();
		}catch(Exception ignore) {}
	}
	public void joinMember() {  //등록 버튼 이벤트시 수행할 메소드
		this.connDB();
		String id,pass;
		id = tf1.getText().trim();
		pass=new String(tf2.getPassword());
		String sql= "insert into mtest values(?,?)";
		try{
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1,id);
			stat.setString(2,pass);
			stat.executeUpdate();
		}catch(SQLException se) {}
	}
	public void checkMember() {  //확인 버튼 이벤트시 수행할 메소드
		this.connDB();
		String id,pass;
		String pass1 = null;
		id = tf1.getText().trim();
		pass = new String(tf2.getPassword());
		try {
			rs = stmt.executeQuery("select pass from mtest where id = '"+id+"'");
			while(rs.next()) {
				pass1 = rs.getString("pass");
			}
			if(pass.equals(pass1)) {
				JOptionPane.showMessageDialog(null, "회원입니다.");
			}else {
				JOptionPane.showMessageDialog(null, "비회원입니다.");
			}
		}catch(SQLException se) {}
	}

	public void actionPerformed(ActionEvent e) {  //ActionListener 구현
		if(e.getSource() == bt1) {
			this.joinMember();
		}
		if(e.getSource() == bt2) {
			this.checkMember();
		}
	}
}