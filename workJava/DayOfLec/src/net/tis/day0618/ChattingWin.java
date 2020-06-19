package net.tis.day0618;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChattingWin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingWin frame = new ChattingWin();
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
	public ChattingWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("\uC785\uB825");
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
//		textField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				textArea.add
//			}
//		});
		panel_3.add(textField);
		textField.setColumns(15);
		
		JButton btnNewButton = new JButton("\uC804\uC1A1");
		
		
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC885\uB8CC");
		panel_3.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(60);
		textArea.setRows(10);
		textArea.setLineWrap(true);
		panel_4.add(textArea);
		

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText());
				textArea.append(textField.getText());
				textField.setText("");
			}
		});
	}

}
