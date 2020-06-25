package shop_regis;

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

public class shop_register extends JFrame {

	private JPanel mPane;
	private JTextField tf_2;
	private JTextField tf_1;
	private JTextField tf_3;
	private JTextField tf_4;
	private JTextField tf_5;
	private JTextField tf_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shop_register frame = new shop_register();
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
	public shop_register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\java\\_lecture\\study\\eclipse_home_java_workspace\\eatingHouse\\images\\logo.png"));
		setTitle("\uB2F9\uC0B0\uB3D9\uB9DB\uC9D1-\uC0C1\uC810\uC815\uBCF4");
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
		
		tf_2 = new JTextField();
		tf_2.setColumns(10);
		
		tf_3 = new JTextField();
		tf_3.setColumns(10);
		
		JLabel lbl_1 = new JLabel("\uC0C1\uC810\uC774\uB984");
		
		JLabel lbl_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		
		tf_4 = new JTextField();
		tf_4.setColumns(10);
		
		JLabel lbl_4 = new JLabel("\uC0C1\uC810\uC8FC\uC18C");
		
		JLabel lbl_5 = new JLabel("\uC0C1\uC810\uD3C9\uC810");
		
		JLabel lbl_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		
		JLabel lbl_6 = new JLabel("\uBA54\uB274\uC18C\uAC1C");
		
		JTextArea ta_1 = new JTextArea();
		ta_1.setLineWrap(true);
		
		JLabel lbl_9 = new JLabel("\uC0C1\uC810\uC885\uB958");
		
		tf_9 = new JTextField();
		tf_9.setColumns(10);
		GroupLayout gl_cPane_1 = new GroupLayout(cPane_1);
		gl_cPane_1.setHorizontalGroup(
			gl_cPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_cPane_1.createSequentialGroup()
					.addGap(236)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cPane_1.createSequentialGroup()
							.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_9, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_1, Alignment.TRAILING)
								.addComponent(lbl_2, Alignment.TRAILING)
								.addComponent(lbl_3, Alignment.TRAILING)
								.addComponent(lbl_4, Alignment.TRAILING)
								.addComponent(lbl_5, Alignment.TRAILING)
								.addComponent(lbl_6, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tf_4, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_5, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_cPane_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tf_3, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
								.addComponent(tf_2, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
									.addComponent(tf_9, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
									.addComponent(tf_1, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))
						.addGroup(gl_cPane_1.createSequentialGroup()
							.addComponent(ta_1, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 4, GroupLayout.PREFERRED_SIZE)))
					.addGap(217))
		);
		gl_cPane_1.setVerticalGroup(
			gl_cPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cPane_1.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_9, Alignment.TRAILING)
						.addComponent(tf_9, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_1, Alignment.TRAILING)
						.addComponent(tf_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_2, Alignment.TRAILING)
						.addComponent(tf_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_3, Alignment.TRAILING)
						.addComponent(tf_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_5, Alignment.TRAILING)
						.addComponent(tf_5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lbl_6)
					.addGap(18)
					.addComponent(ta_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		cPane_1.setLayout(gl_cPane_1);
		
		JPanel cPane_2 = new JPanel();
		mPane.add(cPane_2, BorderLayout.SOUTH);
		
		JButton btn_1 = new JButton("\uB4F1\uB85D");
		cPane_2.add(btn_1);
		
		JButton btn_2 = new JButton("\uC218\uC815");
		cPane_2.add(btn_2);
		
		JButton btn_3 = new JButton("\uC0AD\uC81C");
		cPane_2.add(btn_3);
		
		JButton btn_4 = new JButton("\uCDE8\uC18C");
		cPane_2.add(btn_4);
	}
}
