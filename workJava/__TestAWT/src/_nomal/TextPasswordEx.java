package _nomal;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class TextPasswordEx {

	public static void main(String[] args) {
		
		// ������ ����
		Frame f = new Frame("�ؽ�Ʈ�ʵ� �׽�Ʈ");
		
		// �г� ����
		Panel p = new Panel();
		
		// �ؽ�Ʈ�ʵ� ����(�ؽ�Ʈ,ũ��)
		// https://m.blog.naver.com/PostView.nhn?blogId=bestheroz&logNo=103730014&proxyReferer=https:%2F%2Fwww.google.com%2F
		TextField tf1 = new TextField("���̵� �Է�", 12);
		TextField tf2 = new TextField("��ȣ �Է�", 10); 
		
		// ��� text�� ���õ� ����
		tf1.selectAll();
		tf2.selectAll();
		
		// ���ڰ� *�� ���̰� �ϴ� �ɼ�
		tf2.setEchoChar('*');
		
		// �гο� �ؽ�Ʈ�ʵ� ����
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);// �����ӿ� �г� �ֱ�
		f.setSize(300, 100);// ������ ũ��
		f.setVisible(true);// ����(���̱�)
		
		
	}// main
}// class TextPasswordEx
