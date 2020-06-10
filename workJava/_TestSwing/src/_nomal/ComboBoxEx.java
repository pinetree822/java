package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import net.tis.lecTest.TestCamping;

public class ComboBoxEx extends JFrame{

	private String fruits[]= {"apple","banana","kiwi","mango","pear",
			"peach","berry","strawberry","blackberry"
	};
	private String names[]= {"kitae","jaehoon","hyosoo","namyun"};
	
	
	public ComboBoxEx() {
		setTitle("�޺��ڽ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());

		// ���ڿ� �޺��ڽ� ����
		JComboBox<String> strCombo=new JComboBox<String>(fruits);
		c.add(strCombo);
		
		// �� �޺��ڽ� ����
		JComboBox<String> nameCombo=new JComboBox<String>();
		// �޺��ڽ��� ���ڿ� ������ �ֱ�
		for(int i=0; i<names.length; i++) nameCombo.addItem(names[i]);
		c.add(nameCombo);
		
		setSize(300, 300);
		setVisible(true);
		
	}// ComboBoxEx()
	
	public static void main(String[] args) {
		new ComboBoxEx();
		
		
		// lib/jar���Ϸ�  ���� 
		// ������Ʈ���� > Java Build Path > Libraries > Add External JARS > ��ġ > blue.jar
		// �ش� Ŭ���� �ʱ�ȭ �ؼ� ����Ѵ�.
		
//		TestCamping cu = new TestCamping();
//		cu.main(args);
	}// main()
	
}// ComboBoxEx
