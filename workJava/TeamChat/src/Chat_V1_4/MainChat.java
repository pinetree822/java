package Chat_V1_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.List;

public class MainChat extends JFrame {

	private JPanel contentPane;
	private JTextField send_tf;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	
			public void MainChatrun() {
				try {
					MainChat frame = new MainChat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public MainChat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");
		panel.add(lblNewLabel);
		
		send_tf = new JTextField();
		send_tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(send_tf);
		send_tf.setColumns(20);
		
		JButton Emoticon_btn = new JButton("\uC774\uBAA8\uD2F0\uCF58");
		Emoticon_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		panel.add(Emoticon_btn);
		
		JButton Send_btn = new JButton("\uC804\uC1A1");
		Send_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		panel.add(Send_btn);
		
		JButton Exit_btn = new JButton("\uB098\uAC00\uAE30");
		Exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		panel.add(Exit_btn);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 10, 333, 276);
		panel_1.add(textArea);
		
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
		
		List list = new List();
		list.setBounds(10, 31, 134, 214);
		panel_2.add(list);
		
		JLabel UserCount_Label = new JLabel("0");
		UserCount_Label.setBounds(85, 251, 44, 15);
		panel_2.add(UserCount_Label);
	}
	private void send() {
		// TODO Auto-generated method stub
		String data= this.send_tf.getText();
		this.textArea.append(data+"\n");
		send_tf.setText("");
		send_tf.requestFocus();
		if(data.equals("q")||data.equals("quit")||data.equals("Q")||data.equals("QUIT")) {
			System.exit(1);
		}
	}
}
