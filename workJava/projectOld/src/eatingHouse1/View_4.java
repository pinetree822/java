package eatingHouse1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class View_4 extends JPanel implements ActionListener{

	private View_Box win;										// 레이아웃 틀 View_Box
	JLabel lb1,lb2,lb3,lb4,lb5;
	static JTextField tf1,tf2,tf3,tf4;
	static JTextArea ta1;
	JButton b1,b2;
	JPanel p,p1,p2,p3,p4,p5;
	Vector<String> v=new Vector<String>();
	/*Vector<Integer> v2=new Vector<Integer>();*/
	
	public View_4(View_Box win){
		///////////////////////////////////////////////////////////////////////////
		/// 메인 설정
		///////////////////////////////////////////////////////////////////////////
		this.win = win;											// View_Box 객체를 View_1_1 JPanel의 win 변수에 저장		
		View_4 view_4 = this;
		
		//win.setTitle("관리자 등록 페이지(Biew_up)");
		win.setTitle("당산동맛집 - 관리자 등록 페이지 화면(" + this.getClass().getName() +")");	// View_Box 객체에서 전체레이아웃의 제목 변경
		GridLayout g=new GridLayout(5,0);
		setLayout(g);
		
		lb1=new JLabel("식당 이름"); tf1=new JTextField(20);
		lb2=new JLabel("대표 메뉴"); tf2=new JTextField(20);
		lb3=new JLabel("전화번호");  tf3=new JTextField(20);
		lb4=new JLabel("위       치"); tf4=new JTextField(20);
								  /* ta1=new JTextArea(30,50);*/
		
		b1=new JButton("저장 완료");
		b2=new JButton("뒤로가기");		
		
		p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p1);
		p1.add(lb1); p1.add(tf1);

		
		p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p2);
		p2.add(lb2); p2.add(tf2);
		
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p3);
		p3.add(lb3); p3.add(tf3);
		
		p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p4);
		p4.add(lb4); p4.add(tf4);
		add(p4);
		
		p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p5); p5.add(b1); p5.add(b2); 				//<== 버튼 중앙에 위치시키기  
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);

		setSize(800,600);
		setVisible(true);
		
		/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}///con
	
	public void actionPerformed(ActionEvent e){
		Object o=e.getSource();
		
		if(o==b1){ 							// <-- 공백일때도 등록 완료 되는 것
			String name=tf1.getText(); String menu=tf2.getText();
			String tel=tf3.getText();  String addr=tf4.getText();
			v.add(name); v.add(menu); v.add(tel); v.add(addr);
			JOptionPane.showMessageDialog(null, "등록 완료"); //null 메시지창 윈도우 중앙에	
			///win.logLevel = 1;// 로그온 확인
			win.change("View_4");
			}//
		else if(o==b2){
			JOptionPane.showMessageDialog(null, "관리자 페이지로 이동합니다.");
			//win.logLevel = 1;// 로그온 확인
			win.change("View_2");
		}//
	
	}///

	
	
	
}/////cs
