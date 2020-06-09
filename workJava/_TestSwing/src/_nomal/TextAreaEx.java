package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaEx extends JFrame{
	
	private JTextField tf = new JTextField(20);
	// ���ٿ� 20�� �Է� ����, 7�� �Է�â
	private JTextArea ta = new JTextArea(7,20);
	
	public TextAreaEx() {
		
		setTitle("�ؽ�Ʈ���� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("�Է� �� <Enter>Ű�� �Է��ϼ���."));
		c.add(tf);
		c.add(new JScrollPane(ta));
		
		// �ؽ�Ʈ�ʵ忡 <Enter>Ű �Է� �� �߻��ϴ� 
		// Action �̺�Ʈ�� ������ ���
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				// �ؽ�Ʈ �ʵ��� ���ڿ��� �ؽ�Ʈ ���� â�� ����
				ta.append(t.getText() + "\n");
				// �� �ؽ�Ʈ �ʵ忡 �Էµ� ���� �����
				t.setText("");
			}
		});
		
		setSize(300, 300);
		setVisible(true);
		
	}// TextAreaEx()
	
	
	
	public static void main(String[] args) {
		new TextAreaEx();
	}// main()
	
	
}// class TextAreaEx
