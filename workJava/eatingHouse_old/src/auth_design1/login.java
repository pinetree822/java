package auth_design1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class login extends JFrame {

	private JPanel log_main;
	private JTextField tf_log;
	private JTextField tf_pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("\uB2F9\uC0B0\uB3D9\uB9DB\uC9D1-\uB85C\uADF8\uC778\uD654\uBA74");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 274);
		log_main = new JPanel();
		log_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(log_main);
		log_main.setLayout(null);
		
		JButton bt_login_submit = new JButton("\uD68C\uC6D0\uC811\uC18D");
		bt_login_submit.setBounds(53, 154, 97, 23);
		log_main.add(bt_login_submit);
		
		JButton bt_login_cancel = new JButton("\uCDE8\uC18C");
		bt_login_cancel.setBounds(175, 154, 97, 23);
		log_main.add(bt_login_cancel);
		
		tf_log = new JTextField();
		tf_log.setBounds(156, 56, 116, 21);
		log_main.add(tf_log);
		tf_log.setColumns(10);
		
		tf_pwd = new JTextField();
		tf_pwd.setBounds(156, 99, 116, 21);
		log_main.add(tf_pwd);
		tf_pwd.setColumns(10);
		
		JLabel lbl_log = new JLabel("\uC544\uC774\uB514");
		lbl_log.setBounds(74, 59, 57, 15);
		log_main.add(lbl_log);
		
		JLabel lbl_pwd = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_pwd.setBounds(74, 102, 57, 15);
		log_main.add(lbl_pwd);
	}
}
