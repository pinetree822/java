package test1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Enumeration;
import java.util.Iterator;


public class ManagerTest extends JFrame implements ActionListener{


	JPanel p,p1,p2,p3/*card*/,p4,p5,p6;
	JPanel pS1;
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JTextArea ta1,ta2;
	
	JLabel lS1;
	JTextField tfS1;
	
	CardLayout card=new CardLayout();
	Vector<String> v=new Vector<String>();
	
	
	public ManagerTest() {
		setTitle("★식당 등록 페이지★");
		Container ct=this.getContentPane();

		
		
		
		
		p=new JPanel(new GridLayout(2,1));
		ct.add(p,"North");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel(card);
		p4=new JPanel(new GridLayout(0,2));				
		p5=new JPanel();
		p6=new JPanel();
		
		pS1=new JPanel();
		
		p.add(p1); p.add(p2);
		ct.add(p3,"Center"); 
		
		
		p1.setBackground(Color.red);
		p2.setBackground(Color.orange);
		p3.setBackground(Color.yellow); //yellow 안뜨는것보니 card로 바뀜.
		p4.setBackground(Color.green);
		p5.setBackground(Color.magenta);
		p6.setBackground(Color.cyan);
		pS1.setBackground(Color.pink);
		
		ta1=new JTextArea(20,40);
		ta2=new JTextArea(20,40);
		
/*		ta2.setEditable(false);*/
		
		b1=new JButton("로그아웃");
		b2=new JButton("식당 등록");
		b3=new JButton("식당 검색");
		b4=new JButton("수       정");
		
		
		p1.add(b1); p2.add(b2);
		p2.add(b3);p2.add(b4);
		
		GridLayout gg=new GridLayout(0,1);
		pS1.setLayout(gg);
		pS1.add(new JScrollPane(ta1));
		
		
		p6.add(ta2);
		
		
		/*FlowLayout f=new FlowLayout(); 
		p4.setLayout(f);*/
		l1=new JLabel("식당 이름");
		l2=new JLabel("대표 메뉴");
		l3=new JLabel("전화번호");
		l4=new JLabel("위     치");
		l5=new JLabel("주     소");
		l6=new JLabel("운영 시간");
		
		lS1=new JLabel("식당이름");
		
		tf1=new JTextField(5);
		tf2=new JTextField(5);
		tf3=new JTextField(5);
		tf4=new JTextField(5);
		tf5=new JTextField(5);
		tf6=new JTextField(5);
		/*ptf.setLocation(getWidth(),0);*/
		tfS1=new JTextField(30);
		
		p4.add(l1); p4.add(tf1);
		p4.add(l2); p4.add(tf2);
		p4.add(l3); p4.add(tf3);
		p4.add(l4); p4.add(tf4);
		p4.add(l5); p4.add(tf5);
		p4.add(l6); p4.add(tf6);
		
		p5.add(lS1); p5.add(tfS1);
		
		p3.add(p4,"poo"); //등록
		p3.add(p5,"foo"); //검색
		p3.add(p6,"coo"); //수정
		p3.add(pS1,"zoo");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		setSize(800,600);		
		setVisible(true);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		/*setSize(800,600);		
		setVisible(true);	
		ptf.setLocation(getWidth(),0);
		
		tfPwd.setEchoChar('*');
		*/
		
	}///con
	
	

	@Override
	public void actionPerformed(ActionEvent ex){
		Object o=ex.getSource();
		
		String a=tf1.getText();
		String b=tf2.getText();
		String c=tf3.getText();
		String d=tf4.getText();
		String e=tf5.getText();
		String f=tf6.getText();
		
		
		
		
		
		
		String Sname=tfS1.getText();
		
		if(o==b1){
			JOptionPane.showMessageDialog(b1, "로그아웃 되셨습니다.");
			
		}//
		//---------------------------------------------------------------
		else if(o==b2){
			 // <==여기 수정 ,, else if 하나 더 추가해야 됌
			JOptionPane.showMessageDialog(tf1, "등록완료");	 //공백일 때 오류메시지 아직 못함 , 누를 때마다 실행됨
			tf1.setText("");tf2.setText("");
			tf3.setText("");tf4.setText("");
			tf5.setText("");tf6.setText("");
			

			card.show(p3,"poo");
			tf1.requestFocus();
			v.add(a); v.add(b); v.add(c);
			v.add(d); v.add(e); v.add(f);
			
		}
		//-----------------------------------------------
		else if(o==b3){
			setTitle("●식당 검색 페이지●");
			card.show(p3,"foo");
				
			if(Sname.equals("가")){
				JOptionPane.showMessageDialog(tfS1, "검색");
				card.show(p3,"zoo");
				/*setResizable(false);*/
				
			}//if
		}//
		//-----------------------------------------------
		else if(o==b4){
			setTitle("◆수    정  페이지◆");
			
			Iterator<String> it=v.iterator();
			while(it.hasNext()){
				String str=it.next();
				ta2.setText(str);
			}//
				
				
			
				
			
			card.show(p3,"coo");
		}//
		
	}///
	
	public static void main(String[] args) {
		ManagerTest mt=new ManagerTest();
		
		
	}///main
	
	
}////cs

//벡터 v의 현재크기3: "+v.size());
//벡터의 용량3 : "+v.capacity());