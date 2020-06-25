package shop_view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class shop_view extends JFrame {

	private JPanel mPane;
	private JTextField tf_1;
	private JTextField tf_3;
	private JTextField tf_4;
	private JTextField tf_5;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shop_view frame = new shop_view();
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
	public shop_view() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\java\\_lecture\\study\\eclipse_home_java_workspace\\eatingHouse\\images\\logo.png"));
		setTitle("\uB2F9\uC0B0\uB3D9\uB9DB\uC9D1-\uC0C1\uC810\uBCF4\uAE30");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		mPane = new JPanel();
		mPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mPane);
		mPane.setLayout(new BorderLayout(0, 0));
		
		JPanel cPane = new JPanel();
		mPane.add(cPane, BorderLayout.NORTH);
		
		JPanel cPane_1 = new JPanel();
		mPane.add(cPane_1, BorderLayout.CENTER);
		
		tf_5 = new JTextField();
		tf_5.setColumns(10);
		
		tf_1 = new JTextField();
		tf_1.setColumns(10);
		
		tf_3 = new JTextField();
		tf_3.setColumns(10);
		
		JLabel lbl_1 = new JLabel("\uC0C1\uC810\uC774\uB984");
		
		tf_4 = new JTextField();
		tf_4.setColumns(10);
		
		JLabel lbl_4 = new JLabel("\uC0C1\uC810\uC8FC\uC18C");
		
		JLabel lbl_5 = new JLabel("\uC0C1\uC810\uD3C9\uC810");
		
		JLabel lbl_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		
		JLabel lbl_6 = new JLabel("\uBA54\uB274\uC18C\uAC1C");
		
		JTextArea ta_1 = new JTextArea();
		ta_1.setLineWrap(true);
		
		JLabel label = new JLabel("\uC0C1\uC810\uC885\uB958");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_cPane_1 = new GroupLayout(cPane_1);
		gl_cPane_1.setHorizontalGroup(
			gl_cPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cPane_1.createSequentialGroup()
					.addGap(237)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cPane_1.createSequentialGroup()
							.addComponent(lbl_5)
							.addGap(24)
							.addComponent(tf_5, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
						.addComponent(lbl_6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(ta_1, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cPane_1.createSequentialGroup()
							.addComponent(lbl_3)
							.addGap(24)
							.addComponent(tf_3, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
						.addGroup(gl_cPane_1.createSequentialGroup()
							.addComponent(lbl_1)
							.addGap(24)
							.addComponent(tf_1, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
						.addGroup(gl_cPane_1.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_cPane_1.createSequentialGroup()
							.addComponent(lbl_4)
							.addGap(24)
							.addComponent(tf_4, 245, 245, 245)))
					.addGap(220))
		);
		gl_cPane_1.setVerticalGroup(
			gl_cPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cPane_1.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, Alignment.TRAILING))
					.addGap(27)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(tf_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_1, Alignment.TRAILING))
					.addGap(27)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(tf_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_3, Alignment.TRAILING))
					.addGap(27)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(tf_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(tf_5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_5, Alignment.TRAILING))
					.addGap(34)
					.addComponent(lbl_6)
					.addGap(18)
					.addComponent(ta_1, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(53))
		);
		cPane_1.setLayout(gl_cPane_1);
		
		JPanel cPane_2 = new JPanel();
		mPane.add(cPane_2, BorderLayout.SOUTH);
		
		JButton btn_2 = new JButton("\uD504\uB9B0\uD2B8");
		cPane_2.add(btn_2);
		
		JButton btn_4 = new JButton("\uB2EB\uAE30");
		cPane_2.add(btn_4);
	}
}
