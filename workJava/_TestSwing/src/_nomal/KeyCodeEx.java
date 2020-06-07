package _nomal;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class KeyCodeEx extends JFrame{

	private JLabel la = new JLabel();
	
	public KeyCodeEx() {
		//������ ����, �ݱ⼳��
		setTitle("Key Code���� : F1-�ʷϻ�, % Ű �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �����̳� ���� - Ű������ ����, ���̺� �߰� ����
		Container c = getContentPane();
		c.addKeyListener(new MyKeyListener());
		c.add(la);
		
		// ������ ũ��, ���̱� ����
		setSize(300, 150);
		setVisible(true);
		
		
		c.setFocusable(true);	// ����Ʈ ���� ��Ŀ�� ������ �ֵ��� ����
		c.requestFocus();		// ����Ʈ ���� Ű�Է��� ���� �� �ֵ��� ��Ŀ�� ���� ����
		
	}// keyCodeEx()
	

	// keyListener ����
	class MyKeyListener extends KeyAdapter
	{
		// Ű ���������� ȿ�� 
		@Override
		public void keyPressed(KeyEvent e) {
			
			// �����̳� �ν��Ͻ� ��������
			Container contentPane = (Container)e.getSource();
			
			// la���̺� ����ڰ� �Էµ� Ű�� �̸����ڿ��� ����Ͽ�
			// ����ڿ��� ������
			la.setText(KeyEvent.getKeyText(e.getKeyCode()) + "Ű�� �ԷµǾ���");
			
			// ����Ʈ�� ������ Ű�� ���ڿ���
			// '%'�Էµɶ� �����, 'F1'�Էµɶ� ������� �����Ѵ�.
			if(e.getKeyChar() == '%')
				contentPane.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F1)
				contentPane.setBackground(Color.GREEN);
			
		}
	}// class MyKeyListener
	
	public static void main(String[] args) {
		new KeyCodeEx();
	}
}// class KeyCodeEx

