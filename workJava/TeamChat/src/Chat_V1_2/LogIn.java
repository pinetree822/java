package Chat_V1_2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField ip_tf;
	private JTextField id_tf;

	/**
	 * Launch the application.
	 */
	

	public void LogInVisible() {
		try {
			LogIn frame = new LogIn();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//	
	/**
	 * Create the frame.
	 */
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC11C\uBC84 ip :");
		lblNewLabel.setBounds(113, 84, 57, 15);
		panel.add(lblNewLabel);

		ip_tf = new JTextField();
		ip_tf.setBounds(181, 81, 116, 21);
		panel.add(ip_tf);
		ip_tf.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(113, 129, 57, 15);
		panel.add(lblNewLabel_1);

		id_tf = new JTextField();
		id_tf.setBounds(181, 126, 116, 21);
		panel.add(id_tf);
		id_tf.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton frofiel_btn = new JButton("\uD504\uB85C\uD544");
		frofiel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frofile ff = new Frofile();
				ff.Frofilerun();
			}
		});
		panel_1.add(frofiel_btn);

		JButton connect_btn = new JButton("\uC785\uC7A5");
		connect_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainChat mc = new MainChat();
				mc.MainChatrun();
			}
		});
		panel_1.add(connect_btn);
	}
}
