package s3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class login_success extends JFrame {

	private JPanel log_main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_success frame = new login_success();
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
	public login_success() {
		setTitle("\uB2F9\uC0B0\uB3D9\uB9DB\uC9D1-\uB85C\uADF8\uC778\uC131\uACF5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 274);
		log_main = new JPanel();
		log_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(log_main);
		log_main.setLayout(null);
		
		JButton bt_logsuccess_go_main = new JButton("\uC11C\uBE44\uC2A4\uC774\uB3D9");
		bt_logsuccess_go_main.setBounds(117, 153, 97, 23);
		log_main.add(bt_logsuccess_go_main);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uB2D8 \uB2F9\uC0B0\uB3D9\uB9DB\uC9D1\uC5D0 \uC811\uC18D\uD558\uC168\uC2B5\uB2C8\uB2E4.");
		label.setBounds(65, 93, 204, 15);
		log_main.add(label);
		
		JLabel label_1 = new JLabel("\uD658\uC601\uD569\uB2C8\uB2E4.");
		label_1.setBounds(65, 55, 73, 15);
		log_main.add(label_1);
	}
}
