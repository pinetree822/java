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
	private String text[] = {"사과", "배", "체리"};
	private ImageIcon image[] = {
			new ImageIcon("images/apple1.jpg"),
			new ImageIcon("images/pear1.jpg"),
			new ImageIcon("images/cherry1.jpg")
	};
	private JLabel imageLabel = new JLabel();
	
	
	public RadioButtonItemEventEx() {

		setTitle("라디오버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		// 3개의 라디오버튼을 부착할 패널
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.GRAY);
		
		ButtonGroup g = new ButtonGroup();
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]); // 버튼그룹에 레디오버튼 부착
			radioPanel.add(radio[i]);// radioPanel에 레디오버튼 부착
			radio[i].addItemListener(new MyItemListener());// 라디오버튼에 Item리스너 등록
		}// for
		
		radio[2].setSelected(true);// 체리 라디오버튼을 선택 상태로 설정
		c.add(radioPanel, BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);// 이미지의 중앙 정렬
		
		setSize(250, 200);
		setVisible(true);
	}// RadioButtonItemEventEx()
	
	
	
	class MyItemListener implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) {
			// item이 선택 해제 된 경우 그냥 리턴
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
