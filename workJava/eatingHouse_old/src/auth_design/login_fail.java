package auth_design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class login_fail extends JFrame {

	private JPanel log_main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_fail frame = new login_fail();
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
	public login_fail() {
		setTitle("\uB2F9\uC0B0\uB3D9\uB9DB\uC9D1-\uB85C\uADF8\uC778\uC2E4\uD328");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 274);
		log_main = new JPanel();
		log_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(log_main);
		log_main.setLayout(null);
		
		JButton bt_logfail_go_login = new JButton("\uB85C\uADF8\uC778");
		bt_logfail_go_login.setBounds(56, 152, 97, 23);
		log_main.add(bt_logfail_go_login);
		
		JLabel label = new JLabel("\uC190\uB2D8 \uB2F9\uC0B0\uB3D9\uB9DB\uC9D1 \uC811\uC18D\uC5D0 \uC2E4\uD328\uD558\uC168\uC2B5\uB2C8\uB2E4.");
		label.setBounds(41, 59, 246, 15);
		log_main.add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514\uC640 \uBE44\uBC00\uBC88\uD638\uB97C \uD655\uC778\uD558\uC2DC\uAE30 \uBC14\uB78D\uB2C8\uB2E4.");
		label_1.setBounds(41, 102, 246, 15);
		log_main.add(label_1);
		
		JButton bt_logfail_close = new JButton("\uB2EB\uAE30");
		bt_logfail_close.setBounds(165, 152, 97, 23);
		log_main.add(bt_logfail_close);
	}
}
