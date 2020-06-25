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

public class Frofile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void Frofilerun() {
				try {
					Frofile frame = new Frofile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public Frofile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 231, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Image_label = new JLabel("\uC774\uBBF8\uC9C0 \uC5C6\uC74C");
		Image_label.setBounds(12, 10, 181, 145);
		panel.add(Image_label);
		
		JButton Frofile_select_btn = new JButton("\uC120\uD0DD");
		Frofile_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Frofile_select_btn.setBounds(108, 142, 97, 23);
		panel.add(Frofile_select_btn);
	}

}
