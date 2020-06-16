package _nomal._14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JToolBar;




public class ToolBarEx extends JFrame{

	private Container contentPane;// ����Ʈ �� ����
	
	private void createToolBar() {
		// ���� ����
		JToolBar toolBar = new JToolBar("���� �׽�Ʈ");
		
		// ���ٿ� �޴��� ����� ������Ʈ�� ����
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton(new ImageIcon("images/open.jpg")));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("images/save.jpg")));
		toolBar.add(new JButton("search"));
		toolBar.add(new JButton("text field"));
		
		JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolBar.add(combo);
		
		// ���ٸ� ���������� NORTH�� ����
		contentPane.add(toolBar, BorderLayout.NORTH);
		
	}// createToolBar()
	
	public ToolBarEx() {
		setTitle("���� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		createToolBar();
		
		setSize(400, 200);
		setVisible(true);
	}// ToolBarEx()
	
	public static void main(String[] args) {
		new ToolBarEx();
	}// main()
	
	
}// class ToolBarEx