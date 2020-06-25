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

public class View_Box1 extends JFrame implements ActionListener{
	private Container con;											//	최고상위 컨테이너
	private JTextField tf1 = new JTextField(10);  				//	아이디 	텍스트필드
	private JPasswordField tf2 = new JPasswordField (10);  	//	비밀번호	패스워드필드

	public View_Box1() {		
		this(new View_1_1());
	}// public View_Box1()
	public View_Box1(JFrame f) {		
		con = this.getContentPane(); // View_Box1
		this.init();
		//this.start();
		this.setSize(380,100);
		this.setLocation(500,400);
		this.setVisible(true);
		
	}// public View_Box1()

	public void init() {  //화면 구성		
		View_1_1 view = new View_1_1();
		
		JPanel pn1 = new JPanel(new FlowLayout());
		pn1.add(new JLabel("ID"));
		pn1.add(tf1);
		pn1.add(new JLabel("Passwd"));
		pn1.add(tf2);
		
		con.setLayout(new GridLayout(2,1));
		con.add(pn1);
	}
}// public class View_Box1
