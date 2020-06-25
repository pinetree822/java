package _nomal._14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyDialog extends JDialog{

	private JTextField tf = new JTextField(10);
	private JButton okButton = new JButton("OK");
	
	
	public MyDialog(JFrame frame, String title) {
		
		super(frame, title);
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200, 100);
		
		// ���̾�α��� OK��ư�� Action������ �ޱ�
		// OK��ư�� ���õǸ� ���̾�αװ� ȭ�鿡�� ������� �Ѵ�.
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);		// ���̾�α׸� ������ �ʰ� �Ѵ�.
			}
		});
	}// MyDialog()

}// class MyDialog
