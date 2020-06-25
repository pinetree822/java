package test1;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class View_1_1 extends JFrame implements ActionListener{
		private JTextField tf1 = new JTextField(10);  				//	���̵� 	�ؽ�Ʈ�ʵ�
		private JPasswordField tf2 = new JPasswordField (10);  	//	��й�ȣ	�н������ʵ�
		private JButton bt1 = new JButton("���");					//	��Ϲ�ư
		private JButton bt2 = new JButton("Ȯ��");					//	Ȯ�ι�ư

		private Connection conn = null;
		private Statement stmt = null;
		private ResultSet rs = null;
		boolean member = false;

		public View_1_1() {
			super("�α���");
			this.init();
			this.start();
			this.setSize(380,100);
			this.setLocation(500,400);
			this.setVisible(true);
		}
		public void init() {  //ȭ�� ����
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
		public void start() {  //�̺�Ʈ
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			bt1.addActionListener(this);
			bt2.addActionListener(this);
		}
		public void connDB()  {  //DB�� ����
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				this.conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","pro","test");
				this.stmt = conn.createStatement();
			}catch(Exception ignore) {}
		}
		public void joinMember() {  //��� ��ư �̺�Ʈ�� ������ �޼ҵ�
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
		public void checkMember() {  //Ȯ�� ��ư �̺�Ʈ�� ������ �޼ҵ�
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
					JOptionPane.showMessageDialog(null, "ȸ���Դϴ�.");
				}else {
					JOptionPane.showMessageDialog(null, "��ȸ���Դϴ�.");
				}
			}catch(SQLException se) {}
		}

		public void actionPerformed(ActionEvent e) {  //ActionListener ����
			if(e.getSource() == bt1) {
				this.joinMember();
			}
			if(e.getSource() == bt2) {
				this.checkMember();
			}
		}
	}// class View_1_1 extends JFrame implements ActionListener