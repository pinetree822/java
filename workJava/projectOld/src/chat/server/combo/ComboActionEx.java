package chat.server.combo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class ComboActionEx extends JFrame{

	// �޺� �ڽ��� ������
	private String[] fruits = { "Sad", "Fear", "Angry", "Disgust", "Joy" };

	// �̹��� ��ü �迭
	private ImageIcon[] images = {
		new ImageIcon("images/a.png"),
		new ImageIcon("images/b.gif"),
		new ImageIcon("images/c.gif"),
		new ImageIcon("images/d.jpg"),
		new ImageIcon("images/e.jpg"),
	};
	
	// �̹��� ���̺� ������Ʈ
	private JLabel imgLabel = new JLabel(images[0]);
	// ���ڿ� ������Ʈ
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	

	public ComboActionEx() {
		
		setTitle("������ ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		
		c.add(strCombo);
		c.add(imgLabel);
		
		//Action ������ ���
		strCombo.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Action �̺�Ʈ�� �߻��� �޺��ڽ� �˾Ƴ���
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				// �޺��ڽ��� ���õ� �������� �ε��� ��ȣ �˾Ƴ���.
				int index = cb.getSelectedIndex();
				// �ε����� �̹����� �̹��� ���̺� ������Ʈ�� ���
				imgLabel.setIcon(images[index]);
			}
		});
		setSize(300,250);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ComboActionEx();
	}
}
