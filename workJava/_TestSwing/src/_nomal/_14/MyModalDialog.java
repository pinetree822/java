package _nomal._14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class MyModalDialog extends JDialog {
	
	private JTextField tf = new JTextField(10);
	private JButton okButton = new JButton("OK");
	
	
	public MyModalDialog(JFrame frame, String title) {
		
		super(frame, title, true);	// true�� ���Ÿ���� ���鵵�� ����
		setLayout(new FlowLayout());// ���̾ƿ�
		add(tf);					// �ؽ�Ʈ�ʵ� �߰�
		add(okButton);				// ��ư �߰�
		setSize(200, 100);			// ������ ũ��
		
		// ��ư ������ �߰�
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);// ���̾�α׸� ������ dialog.setVisible(true); ��ġ�� ���� �����Ѵ�.
			}
			
		});// addActionListener
	}// MyModalDialog()
	
	// �ؽ�Ʈ�ʵ� â�� ����ڰ� �Է��� ���ڿ��� �����Ѵ�.
	// �Էµ� ������ ������ null�� �����Ѵ�.
	public String getInput() {
		if(tf.getSelectedText().length()==0) return null;
		else return tf.getSelectedText();
	}
	
}// class MyModalDialog








