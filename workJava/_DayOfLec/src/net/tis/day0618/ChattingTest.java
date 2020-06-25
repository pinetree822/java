package net.tis.day0618;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class ChattingTest extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// 이벤트 자동으로 발생
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ChattingTest frame = new ChattingTest();
					frame.setVisible(true);
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}// run
		});// EvnetQueue.invokeLater(newRunnable())
	}// main()
	
	
	/**
	 * Create the frame.
	 */
	public ChattingTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "채팅접속", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(93, 201, 248, 47);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC11C\uBC84\uC811\uC18D");
		btnNewButton.setBounds(6, 17, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC885\uB8CC");
		btnNewButton_1.setBounds(145, 17, 97, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "채팅프로그램", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(16, 21, 388, 45);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(65, 17, 116, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 17, 116, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778");
		lblNewLabel.setBounds(6, 20, 57, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(204, 20, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(127, 104, 154, 71);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, -1, 30, 73);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("\uC774\uBBF8\uC9C0\uC0C1\uC790");
		lblNewLabel_2.setBounds(1, 1, 124, 71);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC544\uC774\uB514\uC640 \uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(98, 72, 240, 15);
		getContentPane().add(lblNewLabel_3);
	}
}
