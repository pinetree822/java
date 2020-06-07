package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class CheckBoxItemEventEx extends JFrame{

	private JCheckBox fruits[] = new JCheckBox[3]; // üũ�ڽ� �迭
	private String names[] = {"���", "��", "ü��"};// üũ�ڽ� ���ڿ��� ����� ���ڿ��迭
	private JLabel sumLabel;// ��� ���� ����� ���̺�
	
	
	public CheckBoxItemEventEx() {
		
		setTitle("üũ�ڽ��� ItemEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("��� 100��, �� 500��, ü�� 20000��"));
		
		// item������ ������ MyItemListener�� �ν��Ͻ��� �����Ѵ�.
		MyItemListener listener = new MyItemListener();

		// 3���� üũ�ڽ��� ����, ����Ʈ �ҿ� �����ϰ� Item������ ���
		for(int i=0; i<fruits.length; i++) {
			// names���ڿ��� üũ�ڽ� ����
			fruits[i] = new JCheckBox(names[i]);
			
			// üũ�ڽ� �ܰ��� ���̵��� ����
			fruits[i].setBorderPainted(true);
			
			// ����Ʈ �ҿ� üũ�ڽ� ����
			c.add(fruits[i]);
			
			// üũ�ڽ��� Item������ ���
			fruits[i].addItemListener(listener);
		}
		
		sumLabel = new JLabel("���� 0 �� �Դϴ�.");
		c.add(sumLabel);
		
		setSize(250, 200);
		setVisible(true);
		
	}// CheckBoxItemEventEx()
	
	
	// Item ������ ����
	class MyItemListener implements ItemListener
	{
		private int sum=0;// ������ ��
		
		// üũ�ڽ��� ���� ���°� ���ϸ� itemStateChanged()�� ȣ���
		@Override
		public void itemStateChanged(ItemEvent e) {
			// ������ ���
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(e.getItem() == fruits[0]) {			// ��� üũ
					sum += 100;	
				} else if(e.getItem() == fruits[1]) {	// �� üũ
					sum += 500;	
				} else {								// ü�� üũ	
					sum += 20000;		
				}
				
			// ������ ���
			}else {
				if(e.getItem() == fruits[0])			// ��� üũ
					sum -=100;
				else if(e.getItem() == fruits[1])		// �� üũ
					sum -=500;
				else									// ü�� üũ
					sum -=20000;
			}
			sumLabel.setText("���� " + sum + "�� �Դϴ�.");// �����
		}// itemStateChanged()
		
	}// class MyItemListener
	
	
	public static void main(String[] args) {
		new CheckBoxItemEventEx();
	}//main()
	
	
}// class CheckBoxItemEventEx
