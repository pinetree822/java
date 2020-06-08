package _nomal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class RadioButtonItemEventEx extends JFrame{

	private JRadioButton radio[] = new JRadioButton[3];
	private String text[] = {"���", "��", "ü��"};
	private ImageIcon image[] = {
			new ImageIcon("images/apple1.jpg"),
			new ImageIcon("images/pear1.jpg"),
			new ImageIcon("images/cherry1.jpg")
	};
	private JLabel imageLabel = new JLabel();
	
	
	public RadioButtonItemEventEx() {

		setTitle("������ư Item Event ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		// 3���� ������ư�� ������ �г�
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.GRAY);
		
		ButtonGroup g = new ButtonGroup();
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]); // ��ư�׷쿡 �������ư ����
			radioPanel.add(radio[i]);// radioPanel�� �������ư ����
			radio[i].addItemListener(new MyItemListener());// ������ư�� Item������ ���
		}// for
		
		radio[2].setSelected(true);// ü�� ������ư�� ���� ���·� ����
		c.add(radioPanel, BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);// �̹����� �߾� ����
		
		setSize(250, 200);
		setVisible(true);
	}// RadioButtonItemEventEx()
	
	
	
	class MyItemListener implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) {
			// item�� ���� ���� �� ��� �׳� ����
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return ;
			
			if(radio[0].isSelected())
				imageLabel.setIcon(image[0]);
			else if(radio[1].isSelected())
				imageLabel.setIcon(image[1]);
			else
				imageLabel.setIcon(image[2]);
		}// itemStateChanged()
		
	}// class MyItemListener
	
	
	
	public static void main(String[] args) {
		new RadioButtonItemEventEx();
	}// main()
	
	
}// class RadioButtonItemEventEx
