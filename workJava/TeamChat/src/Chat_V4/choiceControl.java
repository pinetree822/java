package Chat_V4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.FlowLayout;

public class choiceControl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choiceControl frame = new choiceControl();
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
	public choiceControl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		Choice choice = new Choice();
		contentPane.add(choice);
//		choice.setBounds(x, y, width, height);
		choice.add("귓속말");
		choice.add("Apple");
		choice.add("아이디");
		//choice.add(textField.getText());
		//choice.select(choice.getItemCount()-1);
		
//		String data = "선택한 값보기 : "
//				+ choice.getItem(choice.getSelectedIndex())
//				+ statusLabel.setText(data);
		
//		choice.getSelectedObjects();
//		choice.getSelectedItem();
//		choice.remove(choice.getSelectedIndex());
//		choice.removeAll();		
		//		choice.addItem(item);
	}

}
