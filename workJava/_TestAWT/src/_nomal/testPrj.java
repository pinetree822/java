package _nomal;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class testPrj {

	Frame frm = new Frame("������ �̸�");
	Button btn1 = new Button("��ư1");
	Button btn2 = new Button("��ư2");
	Button btn3 = new Button("��ư3");
	FlowLayout flow = new FlowLayout();
	
	public void creatFrame()
	{
		// ������ ũ�� ����
		frm.setSize(400,400);
		
		// �����ӿ� ������Ʈ �߰�
		frm.add(btn1);
		frm.add(btn2);
		frm.add(btn3);
		
		// ���̾ƿ� ����
		frm.setLayout(flow);
		
		// ������ ���̱�
		frm.setVisible(true);
		
	}// createFrame
	
	public static void main(String[] args) {
		testPrj frame = new testPrj();
		frame.creatFrame();
	}// main
}// class testPrj
