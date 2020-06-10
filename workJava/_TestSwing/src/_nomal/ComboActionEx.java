package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class ComboActionEx extends JFrame{

	private String fruits[]= {"apple","banana","kiwi","mango"};
	private ImageIcon images[]= {
			new ImageIcon("images/apple2.jpg"),
			new ImageIcon("images/banana2.jpg"),
			new ImageIcon("images/kiwi2.jpg"),
			new ImageIcon("images/mango2.jpg")
	};// �̹��� ��ü �迭
	
	
	
	// JLabelŬ������ ��ü�� imgLabel�� images[0]�� ���� �̹����� �Ҵ�.
	private JLabel imgLabel = new JLabel(images[0]);
	
	// <String>�� �迭�� ������ JComboBoxŬ������ strCombo ��ü ����
	// ���ڿ�(String) fruits�迭�� JComboBox<String>Ŭ���� ��ü�� �Ҵ� 
	private JComboBox<String> strCombo=new JComboBox<String>(fruits);
	
	
	
	
	public ComboActionEx() {

		setTitle("�޺��ڽ� Ȱ�� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);
		
		// Action������ ���
		strCombo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox) e.getSource();// ��ü��������
				int index = cb.getSelectedIndex();// �޺��ڽ��� ������ �������� �迭��ȣ ��������
				imgLabel.setIcon(images[index]);// �迭��ȣ�� ImageIcon��ü �迭 images�迭�� �������� ��������
			}
		});
		setSize(300, 250);
		setVisible(true);
	}// ComboActionEx()
	
	public static void main(String[] args) {
		new ComboActionEx();
	}// main()
	
	
}// class ComboActionEx
