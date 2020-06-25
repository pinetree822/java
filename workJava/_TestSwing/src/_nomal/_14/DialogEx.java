package _nomal._14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class DialogEx extends JFrame {
	
	private MyDialog dialog;
	
	public DialogEx() {
		
		super("dialogEx ���� ������");// ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���̾�α�â �ݱ�
		
		JButton btn = new JButton("Show Dialog");// ��ư ����
		dialog = new MyDialog(this, "Test Dialog");// ���̾�α� ����
		
		// ��ư �̺�Ʈ ����
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});// event
		
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
		
		
	}// DialogEx()
	
	public static void main(String[] args) {
		new DialogEx();
	}// main()
	
}// class DialogEx


