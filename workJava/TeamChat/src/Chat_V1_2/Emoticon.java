package Chat_V1_2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class Emoticon extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void Emoticonrun() {
				try {
					Emoticon frame = new Emoticon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public Emoticon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JList Emoticon_list = new JList();
		Emoticon_list.setBounds(12, 10, 393, 280);
		panel_1.add(Emoticon_list);
		
		JButton Em_select_btn = new JButton("\uC120\uD0DD");
		Em_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(Em_select_btn, BorderLayout.SOUTH);
	}
}
