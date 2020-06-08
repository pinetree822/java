package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class ListEx extends JFrame{

	private String fruits[] = {
			"apple","banana","kiwi","mango","pear","peach","strawberry","blackberry"
			};
	private ImageIcon images[] = {
			new ImageIcon("images/icon1.png"),
			new ImageIcon("images/icon2.png"),
			new ImageIcon("images/icon3.png"),
			new ImageIcon("images/icon4.png")
	};
	
	public ListEx() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		// 문자열 리스트 생성
		JList<String> strList = new JList<String>(fruits);
		c.add(strList);// 컨테이너에 문자열리스트 추가
		
		// 이미지 리스트 생성
		JList<ImageIcon> imageList = new JList<ImageIcon>();
		imageList.setListData(images);// 이미지 리스트에 ImageIcon 배열을 할당한다.
		c.add(imageList);// 컨테이너에 이미지리스트 추가
		
		JList<String> scrollList = new JList<String>(fruits);
		c.add(new JScrollPane(scrollList));//컨테이너에 JScrollPane의 scrollList를 추가
		
		
		
		setSize(300, 300);
		setVisible(true);
	}// ListEx()

	
	public static void main(String[] args) {
		new ListEx();
	}// main()
	
	
}// class ListEx
