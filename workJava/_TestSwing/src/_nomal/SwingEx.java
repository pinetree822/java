package _nomal;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;




public class SwingEx extends JFrame{

	public SwingEx() {
		setTitle("���� ������Ʈ ���̱� ����");
		createMenu();		// �޴��� ����
		createToolBar();	// ���� ����
		createSplitPane();	// pane ����
		
		setSize(500, 400);	// ������ ũ��
		setVisible(true);	// ������ ���
	}// SwingEx()
	
	
	private void createMenu(){
		JMenuBar mb = new JMenuBar(); // JMenuBar Ŭ���� �ʱ�ȭ
		mb.add(new JMenu("����"));
		mb.add(new JMenu("����"));
		mb.add(new JMenu("�ҽ�"));
		mb.add(new JMenu("������Ʈ"));
		mb.add(new JMenu("����"));
		
		this.setJMenuBar(mb);// SwingExŬ�������� JMenuBar�� ����
	}// createMenu()
	

	private void createToolBar(){
		JToolBar bar = new JToolBar("�浿 �޴�");// JToolBar Ŭ���� �ʱ�ȭ

		bar.setBackground(Color.LIGHT_GRAY);// JToolBar�� ���� ����
		bar.add(new JButton("New"));	// JToolBar�� JButton�߰�
		bar.add(new JButton(new ImageIcon("images/open.jpg")));// �̹��� �������� �ִ� JButton �߰�
		bar.addSeparator();// JToolBar�� ���� �޴����� �и���
		bar.add(new JButton(new ImageIcon("images/save.jpg")));
		bar.add(new JLabel("search"));
		bar.add(new JTextField("text field"));
		
		
		JComboBox<String> combo = new JComboBox<String>(); // JComboBox Ŭ���� �ʱ�ȭ
		combo.addItem("Java");// �޺��� ���ڿ� �߰��ϱ�
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		// �����ӿ� JToolBar�� BorderLayout�� NORTH�� ��ġ�Ѵ�.
		add(bar, BorderLayout.NORTH);
		add(bar, BorderLayout.NORTH);// �����ӿ� �޺����� �߰��ϱ�
		
	}// createToolBar()
	
	private void createSplitPane(){
		String fruits[] = {"apple", "banana", "kiwi", "mango", "pear", "peach",
				"berry", "strawberry", "blackberry"};// ���� ��� �迭
		// fruits ���ڿ� �迭�� ���� JList�迭�� scrollList
		JList<String> scrollList = new JList<String>(fruits);
		// JTabbedPane.LEFT
		JSplitPane pane = new JSplitPane(
								JSplitPane.HORIZONTAL_SPLIT,// JSplitPane �и��� ���� �ɼ�
								new JScrollPane(scrollList),// ���� JSplitPane�� JList�� ����
								new JScrollPane(			// ���� JSplitPane�� JLabel�� ����
									new JLabel(				// JLabel�� ImageIcon�� ����
										new ImageIcon("images/img1.jpg")
									)// JLabel �ʱ�ȭ
								)// JScrollPane �ʱ�ȭ
							);// JScroll
		
		// �����ӿ� JSplistPane�� BorderLayout�� Center�� �߰� ����
		add(pane, BorderLayout.CENTER);

	}// createSplitPane()
	
	public static void main(String[] args) {
		new SwingEx();
	}// main()
	
}// class SwingEx
