package _nomal;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class testPrj1 {
	
	Frame frame = new Frame("������ �̸�");
	TextField txt = new TextField("�ؽ�Ʈ ����");
	Label lbl = new Label("�׽�Ʈ ���̺�");
	Button btn = new Button("�׽�Ʈ ��ư");
	
	public void createFrame()
	{
		// ���̾ƿ��� ������� ����
		frame.setLayout(null);

		// ������ ũ�� ����
		frame.setSize(400, 400);
		
		// ������Ʈ ũ��, ��ġ ����
		lbl.setBounds(10, 30, 350, 40);// x��ǥ, y��ǥ, �ʺ�, ����
		txt.setBounds(10, 70, 350, 40);
		btn.setBounds(10, 140, 350, 40);
		
		// �����ӿ� ������Ʈ �߰�
		frame.add(lbl);
		frame.add(txt);
		frame.add(btn);
		
		// ������ ���̱�
		frame.setVisible(true);
		
	}// createFrame()
	
	public static void main(String[] args) {
		
		// ������ ����
		testPrj1 frm = new testPrj1();
		frm.createFrame();
		
	}// main()
}// class testPrj1
