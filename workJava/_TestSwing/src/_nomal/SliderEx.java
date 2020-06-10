package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;


public class SliderEx extends JFrame{

	public SliderEx() {
		
		setTitle("슬라이더 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		/*
		* @param orientation  the orientation of the slider
		* @param min  the minimum value of the slider
		* @param max  the maximum value of the slider
		* @param value  the initial value of the slider
		*/
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
		// 슬라이더 그리기
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		
		// 최대/최소 간격 
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		
		c.add(slider);
		
		
		setSize(300, 100);
		setVisible(true);
		
	}// SliderEx()
	
	public static void main(String[] args) {
		new SliderEx();
	}// main()
}// class SliderEx
