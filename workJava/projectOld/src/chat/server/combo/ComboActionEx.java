package chat.server.combo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class ComboActionEx extends JFrame{

	// 콤보 박스의 아이템
	private String[] fruits = { "Sad", "Fear", "Angry", "Disgust", "Joy" };

	// 이미지 객체 배열
	private ImageIcon[] images = {
		new ImageIcon("images/a.png"),
		new ImageIcon("images/b.gif"),
		new ImageIcon("images/c.gif"),
		new ImageIcon("images/d.jpg"),
		new ImageIcon("images/e.jpg"),
	};
	
	// 이미지 레이블 컴포넌트
	private JLabel imgLabel = new JLabel(images[0]);
	// 문자열 컴포넌트
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	

	public ComboActionEx() {
		
		setTitle("프로필 사진 설정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		
		c.add(strCombo);
		c.add(imgLabel);
		
		//Action 리스너 등록
		strCombo.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Action 이벤트가 발생한 콤보박스 알아내기
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				// 콤보박스의 선택된 아이템의 인덱스 번호 알아내기.
				int index = cb.getSelectedIndex();
				// 인덱스의 이미지를 이미지 레이블 컴포넌트에 출력
				imgLabel.setIcon(images[index]);
			}
		});
		setSize(300,250);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ComboActionEx();
	}
}
