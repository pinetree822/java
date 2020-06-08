package _nomal;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/*
 * ���� �������� ������ ���̱� ���� ��
 */



public class JFrameEx extends JFrame{

	public JFrameEx() {
		
		setTitle("������ ����");		// ������ ����
		
		// �޴��� �ʱ�ȭ ����
		JMenuBar mb = new JMenuBar();
		
		// �޴� ��� �ʱ�ȭ ����
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu sourceMenu = new JMenu("Source");
		JMenu searchMenu = new JMenu("Search");
		JMenu windowMenu = new JMenu("Window");
		
		// JMenuBar�� JMenu�߰�
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(sourceMenu);
		mb.add(searchMenu);
		mb.add(windowMenu);
		
		// Frame�� JMenuBar�� JMenuBar �߰�
		setJMenuBar(mb);
		
		// contentPane - https://solt.tistory.com/20
		// getContentPane - JRootPane type�� ��ȯ
		// (container = JRootPane Ŭ������ ���� Ŭ����)
		this.getContentPane().setLayout(new FlowLayout()); // ���� �гο� FlowLayout
		this.getContentPane().setBackground(new Color(186, 143, 45));// ���� �гο� Background Color ����
		this.add(new JButton("add"));// JFrame�� JButton �߰�
		this.add(new JButton("sub"));
		this.add(new JButton("mul"));
		this.add(new JButton("div"));
		
		setSize(300, 200);	// ������ ũ��
		setVisible(true);		// ������ ���̱�
		
		
	}// JFrameEx()
	
	public static void main(String[] args) {
		new JFrameEx();
	}
	
}// class JFrameEx
