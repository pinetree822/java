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

	private JLabel colorLabel;// JLabel 생성
	private JSlider sl[] = new JSlider[3]; // 3개의 슬라이더 배열 생성

	
	public SliderChangeEx() {

		setTitle("슬라이더와 ChangeEvent예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 제목 
		colorLabel = new JLabel("   SLIDER EXAMPLE   ");
		c.add(colorLabel);// 배경색을 바꿀 Label 추가
		
		// 슬라이더를 3개 생성하고 모양을 제어한다.
		for(int i=0; i<sl.length; i++) {
			// 슬라이더 정령 HORIZONTAL, 0~255, 초기값 128
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);// slider 설정들
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			
			sl[i].addChangeListener(new MyChangeListener());// 슬라이더에 리스너 추가
			c.add(sl[i]);// 컨테이너에 슬라이더 개별 추가
		}// for

		// 개별 슬라이더 배경색 설정
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);
		
		
		// 슬라이더의 수치를 가져와서 - 각각 초기 설정값 r,g,b에 설정.
		int r = sl[0].getValue(); // 1번째 슬라이더 수치
		int g = sl[1].getValue(); // 2번째 슬라이더 수치
		int b = sl[2].getValue(); // 3번째 슬라이더 수치
		
		// colorLabel 초기 설정값 설정
		colorLabel.setOpaque(true);// 투명화
		colorLabel.setBackground(new Color(r,g,b));// 배경색
		
		
		c.add(colorLabel);// 컨텐트에 설정값이 적용된 colorLable을 추가
		setSize(300, 230);// Frame 크기
		setVisible(true);// Frame 보이기
		
	}// SliderChangeEx()
	
	
	class MyChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue(); // R값 얻기
			int g = sl[1].getValue(); // R값 얻기
			int b = sl[2].getValue(); // b값 얻기
			
			colorLabel.setBackground(new Color(r,g,b));
		}// stateChanged()
	}// class MyChangeListener
	
	
	
	public static void main(String[] args) {
		new SliderChangeEx();
	}// main()
	
}// class SliderChangeEx
