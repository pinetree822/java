package _nomal._14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class ToolTipEx extends JFrame {

	private Container contentPane;
	
	public ToolTipEx() {
		setTitle("���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		createToolBar();
		
		setSize(400, 150);
		setVisible(true);
		
	}// ToolTipEx()


	// ���ٸ� �����Ͽ� ����Ʈ���� NORTH�� �����Ѵ�.
	private void createToolBar(){
		
		JToolBar bar = new JToolBar("ȫ�浿 �޴�");	// ���� ����
		bar.setBackground(Color.LIGHT_GRAY);		// ���� ��� ����
		
		JButton newBtn = new JButton("New");		// New��ư ����
		newBtn.setToolTipText("������ �����մϴ�.");// New��ư ���� ����
		
		JButton openBtn = new JButton(new ImageIcon("images/open.jpg"));// Open �̹�����ư ����
		openBtn.setToolTipText("������ ���ϴ�.");
		
		JButton saveBtn = new JButton(new ImageIcon("images/save.jpg"));// Save �̹�����ư ����
		saveBtn.setToolTipText("������ �����մϴ�.");
		
		JTextField tf = new JTextField("text field");			// �ؽ�Ʈ�ʵ� ����
		tf.setToolTipText("ã�����ϴ� ���ڿ��� �Է��ϼ���.");	// �ؽ�Ʈ�ʵ� ���� ����
		

		bar.add(newBtn);	// ���ٿ� NEW��ư �߰�
		bar.add(openBtn);	// ���ٿ� Open��ư �߰�
		bar.addSeparator();	// ���ٿ� ���ؼ� �߰�
		bar.add(saveBtn);	// ���ٿ� Save��ư �߰�
		bar.add(new JLabel("search"));	/// ���ٿ� search �̸����� �� ���̺� �߰�
		bar.add(tf);		// ���ٿ� �ؽ�Ʈ�ʵ� �߰�
		contentPane.add(bar, BorderLayout.NORTH); // ����Ʈ �ҿ� ���� ������ BorderLayout�� �������� ����
		
	}// createToolBar()
	
	
	public static void main(String[] args) {
		new ToolTipEx();
	}// main()
	
	
}// class ToolTipEx
