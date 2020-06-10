package _nomal;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderChangeEx extends JFrame{

	private JLabel colorLabel;// JLabel ����
	private JSlider sl[] = new JSlider[3]; // 3���� �����̴� �迭 ����

	
	public SliderChangeEx() {

		setTitle("�����̴��� ChangeEvent����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// ���� 
		colorLabel = new JLabel("   SLIDER EXAMPLE   ");
		c.add(colorLabel);// ������ �ٲ� Label �߰�
		
		// �����̴��� 3�� �����ϰ� ����� �����Ѵ�.
		for(int i=0; i<sl.length; i++) {
			// �����̴� ���� HORIZONTAL, 0~255, �ʱⰪ 128
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);// slider ������
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			
			sl[i].addChangeListener(new MyChangeListener());// �����̴��� ������ �߰�
			c.add(sl[i]);// �����̳ʿ� �����̴� ���� �߰�
		}// for

		// ���� �����̴� ���� ����
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);
		
		
		// �����̴��� ��ġ�� �����ͼ� - ���� �ʱ� ������ r,g,b�� ����.
		int r = sl[0].getValue(); // 1��° �����̴� ��ġ
		int g = sl[1].getValue(); // 2��° �����̴� ��ġ
		int b = sl[2].getValue(); // 3��° �����̴� ��ġ
		
		// colorLabel �ʱ� ������ ����
		colorLabel.setOpaque(true);// ����ȭ
		colorLabel.setBackground(new Color(r,g,b));// ����
		
		
		c.add(colorLabel);// ����Ʈ�� �������� ����� colorLable�� �߰�
		setSize(300, 230);// Frame ũ��
		setVisible(true);// Frame ���̱�
		
	}// SliderChangeEx()
	
	
	class MyChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue(); // R�� ���
			int g = sl[1].getValue(); // R�� ���
			int b = sl[2].getValue(); // b�� ���
			
			colorLabel.setBackground(new Color(r,g,b));
		}// stateChanged()
	}// class MyChangeListener
	
	
	
	public static void main(String[] args) {
		new SliderChangeEx();
	}// main()
	
}// class SliderChangeEx
