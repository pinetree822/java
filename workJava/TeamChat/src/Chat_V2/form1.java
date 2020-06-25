package Chat_V2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class form1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form1 frame = new form1();
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
	public form1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton, BorderLayout.WEST);
		

		JLabel lblNewLabel = new JLabel("\uC785\uB825 : ");
		contentPane.add(lblNewLabel);
		

		contentPane.add(new JButton("\uC774\uBAA8\uD2F0\uCF58"));
		contentPane.add(new JButton("\uC804\uC1A1"));
		contentPane.add(new JButton("\uB098\uAC00\uAE30"));
		contentPane.add(new JLabel("\uC811\uC18D\uC790 \uB9AC\uC2A4\uD2B8 : "));
		contentPane.add(new JLabel("\uCD1D \uC778\uC6D0 \uC218 :"));
		
		
		

		contentPane.add(new JLabel("\uC774\uBBF8\uC9C0 \uC5C6\uC74C"));
		contentPane.add(new JLabel("\uC785\uC7A5"));
		
		
	}

}
