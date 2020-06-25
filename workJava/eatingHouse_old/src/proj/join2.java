package proj;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

class Person{
	String id;
	String psw1;
	String psw2;
	String name;
	String gender;
	int bi;
	int tel;
	  
	  
	  public Person(){
	  
	  }
	  
	  
	  public Person(String id, String psw1, String psw2,String name,String gender, int bi, int tel){
		  this.id=id;
		  this.psw1=psw1;
		  this.psw2=psw2;
		  this.name=name;
		  this.gender=gender;
		  this.bi=bi;
		  this.tel=tel;
		  
	  }
	  public void setpsw1(String psw1){
		  this.psw1=psw1;
	  }
	  public void setpsw2(String psw2){
		  this.psw2=psw2;
	  }
	  public void setname(String name){
		  this.name=name;
	  }
	  public void setgender(String gender){
		  this.gender=gender;
	  }
	  public void setbi(int bi){
		  this.bi=bi;
	  }
	  public void settel(int tel){
		  this.tel=tel;
	  }
	  
	  public String getid(){
		  return id;
	  }
	  public String getpsw1(){
		  return psw1;
	  }
	  public String getpsw2(){
		  return psw2;
	  }
	  public String getgender(){
		  return gender;
	  }
	  public int getbi(){
		  return bi;
	  }
	  public int gettel(){
		  return tel;
	  }
	  
	  
}



public class join2 extends JFrame  {
	

	
	Label lb1, lb2, lb3;
	Label lb4, lb5,lb6, lb7;
	TextField tf1,tf2,tf3;
	TextField tf5,tf4,tf6, tf7;
	Button bt1, bt2, bt3;
	Checkbox cm,cf;
	Choice ch1,ch2,ch3;
	
	
	
	public join2() {
		super("회원가입2");
		GridLayout g1=new GridLayout(8,0);
		setLayout(g1);
		
		
		
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(p1);
		lb1=new Label("아     이     디"); this.add(lb1); 
		tf1=new TextField(10); this.add(tf1);
		bt3=new Button("중복확인");
		p1.add(lb1);
		p1.add(tf1);
		p1.add(bt3);
		
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(p2);
		lb2=new Label("비  밀  번  호"); 
		tf2=new TextField(5); 
		tf2.setEchoChar('*');
		p2.add(lb2);
		p2.add(tf2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(p3);
		lb3=new Label("비밀번호확인");
		tf3=new TextField(5); 
		tf3.setEchoChar('*');
		p3.add(lb3);
		p3.add(tf3);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(p4);
		lb4=new Label("이        름");
		tf4=new TextField(10); 
		p4.add(lb4);
		p4.add(tf4);
		
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(p5);

		lb5=new Label("성        별"); 
		CheckboxGroup gr=new CheckboxGroup();
		cm=new Checkbox("남자",true,gr);
		cf=new Checkbox("여자",false,gr);
		p5.add(lb5);
		p5.add(cm);
		p5.add(cf);
		
		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(p6);
		

		lb6=new Label("생년월일"); 
		ch1=new Choice();ch2=new Choice(); ch3=new Choice(); 
		p6.add(lb6);
		p6.add(ch1);p6.add(ch2);p6.add(ch3);
		ch1.add("2000");ch1.add("1999");ch1.add("1998");ch1.add("1997");ch1.add("1996");ch1.add("1995");ch1.add("1994");ch1.add("1993");ch1.add("1992");ch1.add("1991");
		ch1.add("1990");ch1.add("1989");ch1.add("1988");ch1.add("1987");ch1.add("1986");ch1.add("1985");ch1.add("1984");ch1.add("1983");ch1.add("1982");ch1.add("1981");
		ch1.add("1980");ch1.add("1979");ch1.add("1978");ch1.add("1977");ch1.add("1976");ch1.add("1975");ch1.add("1974");ch1.add("1973");ch1.add("1972");ch1.add("1971");
		ch2.add("1");ch2.add("2");ch2.add("3");ch2.add("4");ch2.add("5");ch2.add("6");ch2.add("7");ch2.add("8");ch2.add("9");ch2.add("10");ch2.add("11");ch2.add("12");
		ch3.add("1");ch3.add("2");ch3.add("3");ch3.add("4");ch3.add("5");ch3.add("6");ch3.add("7");ch3.add("8");ch3.add("9");ch3.add("10");ch3.add("11");ch3.add("12");ch3.add("13");ch3.add("14");ch3.add("15");ch3.add("16");ch3.add("17");ch3.add("18");ch3.add("19");ch3.add("20");ch3.add("21");ch3.add("22");ch3.add("23");ch3.add("24");ch3.add("25");ch3.add("26");ch3.add("27");ch3.add("28");ch3.add("29");ch3.add("30");ch3.add("31");
		
		JPanel p7 = new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(p7);
		
		lb7=new Label("연  락  처");  
		tf5=new TextField(5);
		tf6=new TextField(5);
		tf7=new TextField(5);
		p7.add(lb7);
		Label lb8=new Label("-");
		Label lb9=new Label("-");

		p7.add(tf5);
		p7.add(lb8);
		p7.add(tf6);
		p7.add(lb9);
		p7.add(tf7);
		
		
		Panel p8=new Panel();
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(p8);
		bt1=new Button("확인");
		bt2=new Button("취소");
		p8.add(bt1);
		p8.add(bt2);
		p8.setBackground(Color.PINK);
		
		MyHandler a = new MyHandler();
		bt1.addActionListener(a);
		bt2.addActionListener(a);
		tf5.addActionListener(a);
		tf6.addActionListener(a);
		tf7.addActionListener(a);
		
	}
	
	class MyHandler implements ActionListener{
		@Override
	
			public void actionPerformed(ActionEvent e){
			Object obj=e.getSource();
			if(obj==bt1){
			String str5=tf5.getText();
			String str6=tf6.getText();
			String str7=tf7.getText();
			try{
				int num5=Integer.parseInt(str5);
				int num6=Integer.parseInt(str6);
				int num7=Integer.parseInt(str7);
			}
			catch(Exception a){
				
				JOptionPane.showMessageDialog(tf5,"전화번호를 제대로 입력하세요.");
			
			return;
			}
			
			finally{
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
			}			
			}	
		
			}//--ActionEvent e
		
		
		}//--class MyHandler implements ActionListener{
	
	
	 class input{
			Person p1=new Person();
	
			
			
			
	}

		

			//--ActionEvent e
		//--class MyHandler implements ActionListener{
	public static void main(String[] args) {
		
		
		
		
		
		join jjoin=new join();
		jjoin.setSize(350, 400);
		jjoin.setVisible(true);
	}	//--main
	

}//---join



