package _nomal;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class ButtonEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame("��ư �׽�Ʈ");// ������ ����
		Panel p = new Panel();// �г� ����
		
		
		Button b1 = new Button();// ��ư ����
		Button b2 = new Button("���");//
		Button b3 = new Button("����");//
		Button b4 = new Button("����");//
		

		b1.setLabel("�Է�");// ��ư1���� �ؽ�Ʈ �Է� ����
		
		// �гο� ��ư ���̱�
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		
		// �����ӿ� �г� ���̱�
		f.add(p);
		
		
		f.setLocation(300,300);		// ������ ��ġ
		f.setSize(300,100);			// ������ ũ��
		f.setVisible(true); 			// ������ ����(���̱�)
		
		f.setVisible(true);// ������ ���( ������Ѷ�)
	}// main
	
}// ButtonEx
