package _nomal._14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DialogEx2 extends JFrame{

	private MyModalDialog dialog; // ���̾�α� ���۷���
	
	public DialogEx2() {
		
		super("DialogEx2 ���� ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Modal Dialog");
		
		// ��� ���̾�α� ����
		dialog = new MyModalDialog(this, "Test Modal Dialog");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dialog.setVisible(true);			// ��� ���̾�α� �۵� ����
				String text = dialog.getInput();	// ���̾�α׺��� ����ڰ� �Է��� ���ڿ��� �޾� �´�.
				
				if(text == null) return;			// �Է��� ���ڿ��� ���� ���
				JButton btn = (JButton)e.getSource();
				btn.setText(text);					// �Է��� ���ڿ��� �� ��ư�� ���ڿ��� �����Ѵ�.
				
			}// actionPerformed()
		});// addActionListener
		
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
		
		
	}// DialogEx2()
	
	
	public static void main(String[] args) {
		new DialogEx2();
	}// main()
	
}// class DialogEx2
