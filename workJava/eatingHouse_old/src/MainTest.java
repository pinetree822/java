package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainTest extends JFrame implements ActionListener{
	
	JPanel p,p1,p2,p3/*카드*/,p4,p5,p6,p7,p8;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7;
	JButton li1,li2,li3,li4,li5,li6,li7,li8,li9,li10;
	
	JButton btBack1,btBack2,btBack3,btBack4;
	CardLayout card=new CardLayout();
	
	public MainTest(){
		super("::음식점::");
		
	
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel(card){
			@Override
			public Insets getInsets(){
				return new Insets(35,10,40,10);
			}///
		};
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p=new JPanel(new GridLayout(2,1));
		p.add(p1);
		p.add(p2);
		add(p,"North");	//2행 전체를 윗쪽으로	
		add(p3,"Center"); //p3 센터

		p1.setBackground(Color.green);
		p2.setBackground(Color.blue);
		p3.setBackground(Color.red);
		
		
		bt1=new JButton("로그인");
		bt2=new JButton("회원가입");
		bt3=new JButton("한식");
		bt4=new JButton("중식");
		bt5=new JButton("일식");
		bt6=new JButton("양식");
		bt7=new JButton("기타");
		
		btBack1=new JButton("이전으로");
		btBack2=new JButton("이전으로");
		btBack3=new JButton("이전으로");
		btBack4=new JButton("이전으로");
		
		
		p1.add(bt1); p1.add(bt2);
		p2.add(bt3); p2.add(bt4);
		p2.add(bt5); p2.add(bt6);
		p2.add(bt7);
		

		/*tf=new JTextArea(30,30);
		p3.add(tf);
		tf.setBackground(Color.lightGray);
		tf.setEditable(false);*/
		
		li1=new JButton("1.한식 식당 이름");
		li2=new JButton("2.한식 식당 이름");
		li3=new JButton("3.한식 식당 이름");
		li4=new JButton("4.한식 식당 이름");
		li5=new JButton("5.한식 식당 이름");
		li6=new JButton("6.한식 식당 이름");
		li7=new JButton("7.한식 식당 이름");
		li8=new JButton("8.한식 식당 이름");
		li9=new JButton("9.한식 식당 이름");
		li10=new JButton("10.한식 식당 이름");
		
	//p3는 카드레이아웃
	//p4에 식당이름 1~10 붙어있는 것 
		//p3.setLayout(new GridLayout(0,1,5,5));
		p4=new JPanel(new GridLayout(0,1,5,5));
		p5=new JPanel();
		p5.setBackground(Color.yellow);
		
		p3.add(p4,"K"); //한식
		p3.add(p5,"C");
		p3.add(p6,"J");
		p3.add(p7,"U");
		p3.add(p8, "O");
		
		
		/*p3.add(p5,"c");
		p3.add(p6,"j");
		p3.add(p7,"u");
		p3.add(p8,"ex");*/
		
		p4.add(li1); p4.add(li2);
		p4.add(li3); p4.add(li4);
		p4.add(li5); p4.add(li6);
		p4.add(li7); p4.add(li8);
		p4.add(li9); p4.add(li10);
		
		
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		bt7.addActionListener(this);
		btBack1.addActionListener(this);
		btBack2.addActionListener(this);
		btBack3.addActionListener(this);
		btBack4.addActionListener(this);
		
		
		p5.add(btBack1);
		p6.add(btBack2);
		p7.add(btBack3);
		p8.add(btBack4);

		setSize(800,600);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}///con
	
	@Override
	public void actionPerformed(ActionEvent e){
			Object o=e.getSource();
			if(o==bt1){
				setTitle("1");
			}//
			else if(o==bt2){ 
				setTitle("2");
			}//
			else if(o==bt3){
				setTitle("3");
				
			}//if
			else if(o==bt4){
				//그걸 bt4를 누르면 card가 뒤접어져서 p3를 보여줌 
				setTitle("4");
				card.show(p3, "C");
				/*setSize(800,600);
				setVisible(true);*/
			}//
			else if(o==bt5){
				setTitle("5");
				card.show(p3, "J");
				/*setSize(800,600);
				setVisible(true);*/
			}//
			else if(o==bt6){
				setTitle("6");
				card.show(p3, "U");
			}//
			else if(o==bt7){
				setTitle("7");
				card.show(p3, "O");
			}//
			else if(o==btBack1){
				card.show(p3,"K");
			}//
			else if(o==btBack2){
				card.show(p3,"K");
			}//
			else if(o==btBack3){
				card.show(p3,"K");
			}//
			else if(o==btBack4){
				card.show(p3,"K");
			}//
	}///
	public static void main(String[] args){
		MainTest h=new MainTest();
		
	}///main
}/////cs

//CardLayout card; card=new CardLayout(); setLayout(card); 
// card.show(this,"mainP"); setBackground(Color.lightGray);
//card.show(this, "loginP");

