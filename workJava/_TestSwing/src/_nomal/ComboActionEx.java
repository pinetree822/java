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
	};// 이미지 객체 배열
	
	
	
	// JLabel클래스의 객체인 imgLabel에 images[0]에 대한 이미지를 할당.
	private JLabel imgLabel = new JLabel(images[0]);
	
	// <String>을 배열로 가지는 JComboBox클래스의 strCombo 객체 생성
	// 문자열(String) fruits배열을 JComboBox<String>클래스 객체에 할당 
	private JComboBox<String> strCombo=new JComboBox<String>(fruits);
	
	
	
	
	public ComboActionEx() {

		setTitle("콤보박스 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);
		
		// Action리스너 등록
		strCombo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox) e.getSource();// 객체가져오기
				int index = cb.getSelectedIndex();// 콤보박스의 선택한 아이템의 배열번호 가져오기
				imgLabel.setIcon(images[index]);// 배열번호를 ImageIcon객체 배열 images배열에 같은순서 가져오기
			}
		});
		setSize(300, 250);
		setVisible(true);
	}// ComboActionEx()
	
	public static void main(String[] args) {
		new ComboActionEx();
	}// main()
	
	
}// class ComboActionEx
