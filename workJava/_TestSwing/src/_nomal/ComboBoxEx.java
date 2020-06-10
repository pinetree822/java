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
		setTitle("콤보박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());

		// 문자열 콤보박스 생성
		JComboBox<String> strCombo=new JComboBox<String>(fruits);
		c.add(strCombo);
		
		// 빈 콤보박스 생성
		JComboBox<String> nameCombo=new JComboBox<String>();
		// 콤보박스에 문자열 아이템 넣기
		for(int i=0; i<names.length; i++) nameCombo.addItem(names[i]);
		c.add(nameCombo);
		
		setSize(300, 300);
		setVisible(true);
		
	}// ComboBoxEx()
	
	public static void main(String[] args) {
		new ComboBoxEx();
		
		
		// lib/jar파일로  배포 
		// 프로젝트정보 > Java Build Path > Libraries > Add External JARS > 위치 > blue.jar
		// 해당 클래스 초기화 해서 사용한다.
		
//		TestCamping cu = new TestCamping();
//		cu.main(args);
	}// main()
	
}// ComboBoxEx
