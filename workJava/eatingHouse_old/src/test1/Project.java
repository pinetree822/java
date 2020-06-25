package test1;
/*
* http://daewoong.egloos.com/
���� �ҽ������Ҷ� DB��ɾ�� ���������ʾҽ��ϴ�.. 
foreignŰ�� primaryŰ�� ����ؼ� ��DB���� table���� ���� ����(?) �̵Ǵ°�ó�� �Ͽ��µ�,, 
�׸�ɾ ���⼭ ǥ���ϰڽ��ϴ�;;
* 
java table������ ��ɾ� : 
create table java (id char(20) not null, pass char(15) not null, name char(10) not null,
birthday char(8) not null, phone char(12),address varchar(30),email varchar(25),money bigint(50), primary key(id));

deposit table������ ��ɾ� : 
create table deposit(account char(30),rate int(3),primary key(account));

investment table������ ��ɾ� : 
create table investment(account char(30),value int(10),number int(10),min int(5),max int(5), primary key(account));

useinvestment table������ ��ɾ� : 
create table useinvestment(id char(20) not null,number int(10) not null,account char(30) not null,constraint foreign key(id) references java(id), constraint foreign key(account) references investment(account));

usedeposit table ������ ��ɾ� : 
create table usedeposit(id char(20) not null,money bigint(30),account char(30) not null, 
constraint foreign key(id) references java(id), constraint foreign key(account) references deposit(account));






ȸ������â. 

ȸ�������� ���������.. DB���� ȸ�������� �о�ɴϴ�. 
�о��ȸ�������� Vector�� �����Ŀ�..
ID �ߺ�Ȯ���� �Ҽ��ְ��Ͽ���..
�ߺ��Ⱦ��̵� ������쿣 �ٽ��ۼ��� �����������̻� ���̵������ ���ϵ����Ͽ����ϴ�.
�׸��� ������ �Ϸ�Ǵ°�� Vector�� ���ڷḦ �־����ϴ�.

�������� : ���� ó���� ���ԿϷ�Ǵ¼��� DB�� �ٷ� �ְ�, 
�ߺ�Ȯ�ε� DB���� ���ͼ� ���Ͽ��µ�,
���͸� ����ϴ� ���� �������ϱ�� �ƴ� �ٷ� DB�� ����ؼ� ���ϴ°� �������,
DB�� ���̻���ϰԵǸ�. 
��� Connector�� Statement�� ����������ϰ� ..
�ҽ��� ������°� ���� ���͸�����ϸ� 
�ҽ��� Ȯ���� �پ��Ͱ��Ƽ� ���͸� ����ϰԵǾ��µ������ҤФ� 
*/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.event.*;


public class Project{   //����ProjectŬ����
	public Project(){
		Title t = new Title();
	} //public Project()
	
	public static void main(String args[]){ //���θ޼ҵ�
		new Project();
	}//public static void main(String args[])

	public static void Message(Component a,String b,String c,int i){   //�޽��� ���� �����ϱ�����..Default�޽���
		if(i==0){
			JOptionPane.showConfirmDialog(a,b,c,JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}
		else if(i==1){
			JOptionPane.showConfirmDialog(a,b,c,JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
		}
	}//public static void Message(Component a,String b,String c,int i)

	public static boolean Message2(Component a,String b,String c){   //�޽��� ���⽱�� �ϱ�����.. static���� �ҷ��ü��հ��Ͽ���.
		int yesno=JOptionPane.showConfirmDialog(a,b,c,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(yesno==JOptionPane.YES_OPTION){
			return true;
		}
		else{
			return false;
		}

	}//public static boolean Message2(Component a,String b,String c)

}//public class Project



class Admin_Date extends JFrame implements ActionListener,Runnable{
	private Choice chi;
	private JButton jb,jb2;
	private Vector invevc,depovc;
	private JTextField jtf;
	private boolean a=true;
	private JLabel jl;
	private float de= 0;
	private Thread thre = new Thread(this);

	public Admin_Date(){
		super("��¥ ���� ���.");
		Container contentPane = getContentPane();
		dateinvestment();datedeposit();
		jl=new JLabel("���ʴ� �Ϸ羿 ������ �Ͻðڽ��ϱ�? �Ҽ�����밡��.");
		jtf = new JTextField(5);
		jb = new JButton("����");jb.addActionListener(this);
		jb2 = new JButton("�ݱ�");jb2.addActionListener(this);
		JPanel jp = new JPanel();
		jp.add(jtf);jp.add(jb);jp.add(jb2);
		contentPane.add(jl,"North");
		contentPane.add(jp,"Center");
		pack();
		setVisible(true);
	}//public Admin_Date()

	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("����")){
			try{   
				de=Float.parseFloat(jtf.getText());
				jb.setText("����");
				jb2.setEnabled(false);
				thre.start();
			}catch(Exception ee){
				Project.Message(this,"���ڸ� �Է��ض�?","�Է¿���",0);
			}
		}
		else if(str.equals("����")){
			thre.stop();
			a=false;
			jtf.setText("");
			jl.setText("���ʴ� �Ϸ羿 ������ �Ͻðڽ��ϱ�? �Ҽ�����밡��.");
			jb.setText("����");
			jb2.setEnabled(true);
		}
		else if(str.equals("�ݱ�")){
			setVisible(false);
			new Admin_frame();
		}
	}//public void actionPerformed(ActionEvent ae)

	public void run(){
		int str=(int)(de*1000)/1;
		int i=1;
		while(a){
			try{
				Thread.sleep(str);
			}catch(Exception ee){}
			jl.setText(i+++"�� �� �������ϴ�.");
			date();
			reSaveAll();
		}
	}//public void run()

	public void dateinvestment(){
		invevc=new Vector();;
		String query = "select account,value,min,max from investment";  
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Investment inve = new Investment(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				invevc.add(inve);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){
			System.out.print("�ֽ�");
		}
	}//public void dateinvestment()

	public void datedeposit(){
		depovc=new Vector();
		String query = "select usedeposit.id,usedeposit.account,usedeposit.money,deposit.rate from usedeposit inner join deposit on usedeposit.account = deposit.account";
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				UserDepo depo = new UserDepo(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				depovc.add(depo);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){
			System.out.print("����");
		}
	}//public void datedeposit()

	public void date(){
		for(int i=0; i<invevc.size();i++){
			Investment inve = (Investment)invevc.get(i);
			inve.dateInve();
			invevc.remove(i);
			invevc.add(i,inve);
		}
		for(int i=0; i<depovc.size();i++){
			UserDepo depo = (UserDepo)depovc.get(i);
			depo.dateDepo();
			depovc.remove(i);
			depovc.add(i,depo);
		} 
	}//public void date()

	public void reSaveAll(){
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		String update;
		String update2;

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			for(int i=0; i<invevc.size(); i++){
				Investment inve = (Investment)invevc.get(i);
				if(inve.delInve()){
					update="delete from investment where account ='"+inve.getAccount()+"'";
				} else{
					update="update investment set value ="+inve.getValue()+" where account ='"+inve.getAccount()+"'";
				}
				stmt.executeUpdate(update);
			}
			for(int i=0; i<depovc.size(); i++){
				UserDepo depo = (UserDepo)depovc.get(i);
				update2="update usedeposit set money ="+depo.getMoney()+" where account ='"+depo.getAccount()+"' and id='"+depo.getID()+"'";
				stmt.executeUpdate(update2);
			}
			stmt.close();
			conn.close();
		}catch(SQLException ee){
			System.out.print("����");
		}//try
	}//public void reSaveAll()

} // class Admin_Date extends JFrame implements ActionListener,Runnable



class Admin_frame extends JFrame implements ActionListener{   //Admin����â
	private JButton b5,b6;
	private JTabbedPane adminjtp;
	private Container contentPane;

	public Admin_frame(){
		setTitle("Administrator");
		contentPane = getContentPane();
		adminjtp = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.WRAP_TAB_LAYOUT);
		adminjtp.add("�ű��ֽ�",new New_Ju());
		adminjtp.add("�űԿ���",new New_Ye());
		adminjtp.add("�ֽĸ���Ʈ",new Ju_List());
		adminjtp.add("���ݸ���Ʈ",new Ye_List());
		b5 = new JButton("�� Login Mode");
		b5.addActionListener(this);
		b6 = new JButton("���ΰ�ħ");
		b6.addActionListener(this);
		JButton b7=new JButton("��¥����");
		b7.addActionListener(this);
		JPanel bp = new JPanel();
		bp.add(b5);
		bp.add(b6);
		bp.add(b7);
		contentPane.add(adminjtp, "Center");
		contentPane.add(bp,"South");
		pack();
		setVisible(true);
	}//public Admin_frame()

	public void restart(){   //���ΰ�ħ�� ��������..����ɳ���
		new Admin_frame();
		setVisible(false);
	}//public void restart()

	public void actionPerformed(ActionEvent ae){ 
		String str=ae.getActionCommand();
		if(str.equals("���ΰ�ħ")){
			restart();
		} else if(str.equals("��¥����")){
			setVisible(false);
			new Admin_Date();
		} else{setVisible(false);new Title();}
	}//public void actionPerformed(ActionEvent ae)

}//class Admin_frame extends JFrame implements ActionListener



class New_Ju extends JInternalFrame implements ActionListener{

	private JLabel lb1, lb2, lb3, lb4, lb5;
	private JPanel jp1, jp2, jp3, jp4, jp5;
	private JPanel jp_total, jbp; // JPanel ����, ��ư ���տ�.
	private JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
	private JButton jbt1; // Ȯ��

	public New_Ju() {
		super("�ű��ֽ�");
		// setTitle("�ű��ֽ�"); // �ֽĸ�,�ֽİ���,�����ְ�,�ּҰ�,�ִ밪

		jp_total = new JPanel();
		jp_total.setLayout(new GridLayout(5, 1)); // �� �߰��Ǿ���.

		jp1 = new JPanel();
		lb1 = new JLabel("�� �� ��       : ");
		jtf1 = new JTextField(10); // �ֽĸ� ���� �ؽ�Ʈ �ʵ�
		jp1.setLayout(new FlowLayout()); // ù��° �г�
		jp1.add(lb1);// �󺧺��̰�
		jp1.add(jtf1); // �гο� �߰� �ؽ�Ʈ�ʵ�

		jp2 = new JPanel();
		lb2 = new JLabel("�� �� �� ��  : ");
		jtf2 = new JTextField(10);
		jp2.setLayout(new FlowLayout());
		jp2.add(lb2);
		jp2.add(jtf2);

		jp3 = new JPanel();
		lb3 = new JLabel("�� �� �� ��  : ");
		jtf3 = new JTextField(10);
		jp3.setLayout(new FlowLayout());
		jp3.add(lb3);
		jp3.add(jtf3);

		jp4 = new JPanel();
		lb4 = new JLabel("�ּҰ�(��) : ");
		jtf4 = new JTextField(10);
		jp4.setLayout(new FlowLayout());
		jp4.add(lb4);
		jp4.add(jtf4);

		jp5 = new JPanel();
		lb5 = new JLabel("�ִ밪(��) : ");
		jtf5 = new JTextField(10);
		jp5.setLayout(new FlowLayout());
		jp5.add(lb5);
		jp5.add(jtf5);

		jbt1 = new JButton("Ȯ��"); // Ȯ�� ���
		jbt1.addActionListener(this);

		jbp = new JPanel(); // ��ư �г�.
		jbp.setLayout(new FlowLayout());
		jbp.add(jbt1);

		jp_total.add(jp1);
		jp_total.add(jp2);
		jp_total.add(jp3);
		jp_total.add(jp4);
		jp_total.add(jp5);

		add(jp_total, "Center");
		add(jbp, "South");

		pack();
		setVisible(true);
	}//public New_Ju()

	public void actionPerformed(ActionEvent ae){
		String str=ae.getActionCommand();
		if(str.equals("Ȯ��")){
			newJuDB();
		}
	}//public void actionPerformed(ActionEvent ae)

	public void newJuDB(){
		String update = "insert into investment values('"+jtf1.getText()+"',"+jtf2.getText()+","+jtf3.getText()+","+jtf4.getText()+","+jtf5.getText()+")";
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		if(!jtf1.getText().replace(" ","").equals("")){
			try{
				Connection conn = DriverManager.getConnection(url,id,pw);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(update);
				conn.close();
				stmt.close();
				clear();
			}catch(SQLException ee){
				if(ee.getSQLState().equals("23000")){
					Project.Message(this,"�ߺ��� �ֽ��� �ֽ��ϴ�.","Error",0);
				} else if(ee.getSQLState().equals("42000")){
					Project.Message(this,"��������� �Է����ֽʽÿ�.","Error",0);
				} else if(ee.getSQLState().equals("42S22")){
					Project.Message(this,"�ֽĸ�ܿ� ���ڸ� �Է����ּ���.","Error",0);
				}
			}//try
		} else{
			Project.Message(this,"�ֽĸ��� �Է����ּ���.","Error",0);
		}// if
	}//public void newJuDB()

	public void clear(){
		jtf1.setText("");
		jtf2.setText("");
		jtf3.setText("");
		jtf4.setText("");
		jtf5.setText("");
	}//public void clear() 

}//class New_Ju extends JInternalFrame implements ActionListener



class New_Ye extends JInternalFrame implements ActionListener{  //����ȭ�� Ŭ����
	private JTextArea jta;
	private JButton jbt1;
	private JPanel jp1, jp_total, jp2, jbp;
	private JLabel lb1, lb2;
	private JTextField jtf1, jtf2;

	public New_Ye() {
		super("�űԿ���"); // ����, ���ݸ�
		lb1 = new JLabel("���ݸ�       : ");
		jtf1 = new JTextField(10);
		jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		jp1.add(lb1);
		jp1.add(jtf1);

		lb2 = new JLabel("������ (%) : ");
		jtf2 = new JTextField(10);
		jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(lb2);
		jp2.add(jtf2);

		jp_total = new JPanel();
		jp_total.setLayout(new GridLayout(3, 1));
		jp_total.add(new JLabel("     �� �����ؼ� �Է��ϼ����"));
		jp_total.add(jp1);
		jp_total.add(jp2);

		jbt1 = new JButton("Ȯ��");
		jbt1.addActionListener(this);
		jbp = new JPanel(); // ��ư �г�.
		jbp.setLayout(new FlowLayout());
		jbp.add(jbt1);
		add(jp_total, "Center");
		add(jbp, "South");
		pack();
		setVisible(true);
	}//public New_Ye()

	public void actionPerformed(ActionEvent ae){
		String str=ae.getActionCommand();
		if(str.equals("Ȯ��")){
			newJuDB();
		}
	}//public void actionPerformed(ActionEvent ae)

	public void newJuDB(){
		String update = "insert into deposit values('"+jtf1.getText()+"',"+jtf2.getText()+")";
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";

		if(!jtf1.getText().replace(" ","").equals("")){
			try{
				Connection conn = DriverManager.getConnection(url,id,pw);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(update);
				conn.close();
				stmt.close();
				clear();
			}catch(SQLException ee){
				Project.Message(this,"�������� �����Է��� �ȵǾ��ų� ���ڰ� �ԷµǾ����ϴ�.","Error",0);
			}//try
		} else{
			Project.Message(this,"���ݸ��� �Է����ּ���.","Error",0);
		}//else
	}//public void newJuDB()

	public void clear(){
		jtf1.setText("");
		jtf2.setText("");
	}//public void clear()

}//class New_Ye extends JInternalFrame implements ActionListener



class Ju_List extends JInternalFrame implements ListSelectionListener,ActionListener{  //�ֽĸ���Ʈ Ŭ����.
	private JList jl;
	private JTextField accounttf,valuetf,numbertf,mintf,maxtf;
	private JButton check,change,del;
	private String listr[]=null;
	private JPanel jp5;

	public Ju_List(){
		super("�ֽĸ���Ʈ");
		check = new JButton("Ȯ��");change = new JButton("����");del = new JButton("����");
		check.setEnabled(false);del.setEnabled(false);change.setEnabled(false);
		check.addActionListener(this);change.addActionListener(this);del.addActionListener(this);
		JPanel jp4 = new JPanel();jp4.add(check);jp4.add(change);jp4.add(del);
		accounttf = new JTextField(10);valuetf= new JTextField(10);numbertf= new JTextField(10);mintf= new JTextField(10);maxtf= new JTextField(10);
		accounttf.setEditable(false);valuetf.setEditable(false);numbertf.setEditable(false);mintf.setEditable(false);maxtf.setEditable(false);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(5,1));
		jp2.add(accounttf);jp2.add(valuetf);jp2.add(numbertf);jp2.add(mintf);jp2.add(maxtf);
		JPanel jp3 = new JPanel();
		jp3.setLayout(new GridLayout(5,1));
		jp3.add(new JLabel("  �� �� ��      : "));jp3.add(new JLabel("  �� �� �� ��:  "));
		jp3.add(new JLabel("  �� �� �� �� : "));jp3.add(new JLabel("  �ּҰ�(��) : "));jp3.add(new JLabel("  �ִ밪(��) : "));
		listr=getVC();
		jl=new JList(listr);
		jl.addListSelectionListener(this);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		jp1.add(new Label("�ֽĸ�"),"North");
		jp1.add(jl,"Center");
		jp5= new JPanel();
		jp5.setLayout(new GridLayout(1,3));
		jp5.add(jp1);jp5.add(jp3);jp5.add(jp2);
		add(jp4,"South");add(jp5,"Center");
		pack();
		setVisible(true);
	}//public Ju_List()

	public String[] getVC(){
		String list = "select *from investment order by account";
		String listr[] = null;
		boolean b=true;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(list);
			rs.last();
			listr = new String[rs.getRow()];
			int i =0;
			rs.first();
			while(b){
				listr[i++]=rs.getString(1);
				b=rs.next();    
			}
		}catch(SQLException ee){}
		return listr;
	}//public String[] getVC()

	public void valueChanged(ListSelectionEvent lse){
		String str = listr[jl.getSelectedIndex()];
		accounttf.setEditable(false);valuetf.setEditable(false);numbertf.setEditable(false);mintf.setEditable(false);maxtf.setEditable(false);
		check.setEnabled(false);del.setEnabled(true);change.setEnabled(true);
		String list = "select *from investment where account='"+str+"'";
		try{
			String url = "jdbc:mysql://localhost:3306/java";
			String id = "root";
			String pw = "dytc1234";
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(list);
			rs.next();
			accounttf.setText(rs.getString(1));
			valuetf.setText(""+rs.getInt(2));
			numbertf.setText(""+rs.getInt(3));
			mintf.setText(""+rs.getInt(4));
			maxtf.setText(""+rs.getInt(5));
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){}
	} // public void valueChanged(ListSelectionEvent lse)

	public void actionPerformed(ActionEvent ae){
		String str=ae.getActionCommand();
		if(str.equals("����")){
			accounttf.setEditable(true);
			valuetf.setEditable(true);
			numbertf.setEditable(true);
			mintf.setEditable(true);
			maxtf.setEditable(true);
			check.setEnabled(true);
			change.setEnabled(false);
			del.setEnabled(false);
		} else if(str.equals("Ȯ��")){
			if(check()){
				check.setEnabled(false);
				change.setEnabled(true);
				del.setEnabled(true);
				accounttf.setEditable(false);
				valuetf.setEditable(false);
				numbertf.setEditable(false);
				mintf.setEditable(false);
				maxtf.setEditable(false);
				Project.Message(this,"���������� ����Ǿ����ϴ�.","����Ϸ�",1);
			} 
		}
		else if(str.equals("����")){
			check.setEnabled(false);
			change.setEnabled(true);
			if(Project.Message2(this,"���� �����Ͻðڽ��ϱ�?","����Ȯ��")){
				del();
				Project.Message(this,"���� �Ǿ����ϴ�","�����Ϸ�",1);
			} else{
				Project.Message(this,"��� �Ǿ����ϴ�","��ҿϷ�",1);
			}
		}
	}//public void actionPerformed(ActionEvent ae)

	public boolean check(){
		String str = listr[jl.getSelectedIndex()];
		String update = "update investment set account='"+accounttf.getText()+"',value="+valuetf.getText()+",number="+numbertf.getText()+",min="+mintf.getText()+",max="+maxtf.getText()+" where account ='"+str+"'"; 
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		boolean b = false;

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			stmt.close();
			conn.close();
			listr[jl.getSelectedIndex()]=accounttf.getText();
			b=true;
		}catch(SQLException ee){
			if(ee.getSQLState().equals("23000")){Project.Message(this,"�ߺ��� �ֽ��� �ֽ��ϴ�.","Error",0);}
			else if(ee.getSQLState().equals("42000")){Project.Message(this,"��������� �Է����ֽʽÿ�.","Error",0);}
			else if(ee.getSQLState().equals("42S22")){Project.Message(this,"�ֽĸ�ܿ� ���ڸ� �Է����ּ���.","Error",0);}
			else{System.out.println(ee.getSQLState());}
		}
		return b;

	}//public boolean check()


	public void del(){
		String str = listr[jl.getSelectedIndex()];
		listr[jl.getSelectedIndex()]=null;
		String remove = "delete from investment where account ='"+str+"'";
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(remove);
			stmt.close();
			conn.close();
		}catch(Exception ee){System.out.println(ee.getMessage());}
	}//public void del()

}//class Ju_List extends JInternalFrame implements ListSelectionListener,ActionListener


class Ye_List extends JInternalFrame implements ActionListener,ListSelectionListener{
	private JList jl;
	private JTextField accounttf,ratetf;
	private JButton check,change,del;
	private String listr[]=null;
	private JPanel jp5;

	public Ye_List(){
		super("���ݸ���Ʈ");
		check = new JButton("Ȯ��");change = new JButton("����");del = new JButton("����");
		check.setEnabled(false);del.setEnabled(false);change.setEnabled(false);
		check.addActionListener(this);change.addActionListener(this);del.addActionListener(this);
		JPanel jp4 = new JPanel();jp4.add(check);jp4.add(change);jp4.add(del);
		accounttf = new JTextField(10);ratetf= new JTextField(10);
		accounttf.setEditable(false);ratetf.setEditable(false);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(5,1));
		jp2.add(accounttf);jp2.add(ratetf);
		JPanel jp3 = new JPanel();
		jp3.setLayout(new GridLayout(5,1));
		jp3.add(new JLabel("���ݸ�       : "));jp3.add(new JLabel("������ (%) : "));
		listr=getVC();
		jl=new JList(listr);
		jl.addListSelectionListener(this);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		jp1.add(new Label("���ݸ�"),"North");
		jp1.add(jl,"Center");
		jp5= new JPanel();
		jp5.setLayout(new GridLayout(1,3));
		jp5.add(jp1);jp5.add(jp3);jp5.add(jp2);
		add(jp4,"South");add(jp5,"Center");
		pack();
		setVisible(true);
	}//public Ye_List()

	public String[] getVC(){
		String list = "select *from deposit order by account";
		String listr[] = null;
		boolean b=true;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(list);
			rs.last();
			listr = new String[rs.getRow()];
			int i =0;
			rs.first();
			while(b){
				listr[i++]=rs.getString(1);
				b=rs.next();    
			}
		}catch(SQLException ee){}
		return listr;
	}//public String[] getVC()

	public void valueChanged(ListSelectionEvent lse){
		String str = listr[jl.getSelectedIndex()];
		String list = "select *from deposit where account='"+str+"'";
		accounttf.setEditable(false);ratetf.setEditable(false);
		check.setEnabled(false);del.setEnabled(true);change.setEnabled(true);
		try{
			String url = "jdbc:mysql://localhost:3306/java";
			String id = "root";
			String pw = "dytc1234";
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(list);
			rs.next();
			accounttf.setText(rs.getString(1));
			ratetf.setText(""+rs.getInt(2));
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){}

	}//public void valueChanged(ListSelectionEvent lse)

	public void actionPerformed(ActionEvent ae){
		String str=ae.getActionCommand();
		if(str.equals("����")){
			accounttf.setEditable(true);
			ratetf.setEditable(true);
			check.setEnabled(true);
			change.setEnabled(false);
			del.setEnabled(false);
		}
		else if(str.equals("Ȯ��")){
			if(check()){
			check.setEnabled(false);
			change.setEnabled(true);
			del.setEnabled(true);
			accounttf.setEditable(false);
			ratetf.setEditable(false);
			Project.Message(this,"���������� ����Ǿ����ϴ�.","����Ϸ�",1);
			}    
		} else if(str.equals("����")){
			check.setEnabled(false);
			change.setEnabled(true);
			if(Project.Message2(this,"���� �����Ͻðڽ��ϱ�?","����Ȯ��")){
				del();
				Project.Message(this,"���� �Ǿ����ϴ�","�����Ϸ�",1);
			} else{
				Project.Message(this,"��� �Ǿ����ϴ�","��ҿϷ�",1);
			}
		}

	}//public void actionPerformed(ActionEvent ae)

	public boolean check(){
		String str = listr[jl.getSelectedIndex()];
		String update = "update deposit set account='"+accounttf.getText()+"',rate="+ratetf.getText()+" where account ='"+str+"'"; 
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		boolean b=false;
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			stmt.close();
			conn.close();
			listr[jl.getSelectedIndex()]=accounttf.getText();
			b=true;   
		}catch(SQLException ee){
			if(ee.getSQLState().equals("23000")){Project.Message(this,"�ߺ��� ������ �ֽ��ϴ�.","Error",0);}
			else if(ee.getSQLState().equals("42000")){Project.Message(this,"��������� �Է����ֽʽÿ�.","Error",0);}
			else if(ee.getSQLState().equals("42S22")){Project.Message(this,"�������� ���ڸ� �Է����ּ���.","Error",0);}
			else{System.out.println(ee.getSQLState());}
		}//try
		return b;

	}//public boolean check()

	public void del(){
		String str = listr[jl.getSelectedIndex()];
		listr[jl.getSelectedIndex()]=null;
		String remove = "delete from deposit where account ='"+str+"'";
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(remove);
			stmt.close();
			conn.close();
		}catch(Exception ee){System.out.println(ee.getMessage());}

	} // public void del()

}//class Ye_List extends JInternalFrame implements ActionListener,ListSelectionListener



class LoginTitle extends JFrame implements ActionListener{   //�α��� Ÿ��Ʋȭ���Դϴ�.
	private UserInfo usif;
	private Container contentPane;

	public LoginTitle(UserInfo usi){
		usif=usi;
		contentPane = getContentPane();
		setTitle("����� ���");
		Label l = new Label(usif.getName()+"���� �����ڻ��� "+usif.getMoney()+"�� �Դϴ�.");
		JButton moneyb = new JButton("�����");moneyb.addActionListener(this);
		JButton depositb = new JButton("���ݰ���");depositb.addActionListener(this);
		JButton investmentb = new JButton("�ֽ�����");investmentb.addActionListener(this);
		JButton deinb = new JButton("���ڳ���");deinb.addActionListener(this);
		JButton logoutb = new JButton("�α׾ƿ�");logoutb.addActionListener(this);
		JPanel jp = new JPanel();
		jp.add(moneyb);jp.add(depositb);jp.add(investmentb);jp.add(deinb);jp.add(logoutb);
		contentPane.setLayout(new GridLayout(2,1));
		contentPane.add(l);
		contentPane.add(jp);
		pack();
		setVisible(true);
	}//public LoginTitle(UserInfo usi)

	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("�����")){
			setVisible(false);
			new InoutMoney(usif);
		} else if(str.equals("���ݰ���")){
			setVisible(false);
			new NewDeposit(usif);
		} else if(str.equals("�ֽ�����")){
			setVisible(false);
			new NewInvestment(usif);
		} else if(str.equals("���ڳ���")){
			setVisible(false);
			new MyMoney(usif,true);
		}
		else if(str.equals("�α׾ƿ�")){
			setVisible(false);
			new Title();
		}
	}// public void actionPerformed(ActionEvent ae)

}//class LoginTitle extends JFrame implements ActionListener




class MyMoney extends JFrame implements ActionListener,ItemListener{
	private Container contentPane;
	private UserInfo usif;
	private Vector invevc,depovc;
	private JRadioButton jr1,jr2;
	private JRadioButton[] depojrb,invejrb;
	private JTextField jtf;
	private JLabel jl1,jl2;
	private JPanel p2;
	private ButtonGroup bg = new ButtonGroup();

	public MyMoney(UserInfo us,boolean b){
		setTitle("�������ڳ���");
		getInvestment(us.getID());
		getDeposit(us.getID());
		p2=new JPanel();
		usif=us;
		contentPane = getContentPane();
		if(b){
			jr1=new JRadioButton("�ֽ�Ȯ��&�Ǹ�",true);jr1.addItemListener(this);
			jr2=new JRadioButton("����Ȯ��&�Ǹ�",false);jr2.addItemListener(this);
			jl1 = new JLabel(" �ֽ��Ǹż� : ");
			jl2 = new JLabel(" �� ");
			p2.add(sellInvestment(us.getID()));
		} else{
			jr1=new JRadioButton("�ֽ�Ȯ��&�Ǹ�",false);jr1.addItemListener(this);
			jr2=new JRadioButton("����Ȯ��&�Ǹ�",true);jr2.addItemListener(this);
			jl1 = new JLabel(" ��ݱݾ� : ");
			jl2 = new JLabel(" �� ");
			p2.add(sellDeposit(us.getID()));
		}
		bg.add(jr1);bg.add(jr2);
		jtf = new JTextField(10);

		JButton sell = new JButton("�Ǹ�");sell.addActionListener(this);
		JButton close = new JButton("�ݱ�");close.addActionListener(this);
		JPanel p1 = new JPanel();JPanel p3 = new JPanel();JPanel p4 = new JPanel();JPanel p5 = new JPanel();
		p1.add(jr1);p1.add(jr2);p3.add(jl1);p3.add(jtf);p3.add(jl2);p4.add(sell);p4.add(close);
		p5.setLayout(new GridLayout(1,2));
		p5.add(p3);p5.add(p4);
		contentPane.add(p1,"North");contentPane.add(p2,"Center");contentPane.add(p5,"South");
		pack();
		setVisible(true);
	}//public MyMoney(UserInfo us,boolean b)

	public void getInvestment(String a){
		invevc=new Vector();;
		String query = "select useinvestment.account,useinvestment.number,investment.value from useinvestment inner join investment on useinvestment.account = investment.account where id='"+a+"'";  
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				UserInve ui = new UserInve(rs.getString(1),rs.getInt(2),rs.getInt(3));
				invevc.add(ui);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){System.out.print("�ֽ�");}
	}//public void getInvestment(String a)

	public JPanel sellInvestment(String a){
		boolean b=true;
		ButtonGroup bg2 = new ButtonGroup();
		invejrb = new JRadioButton[invevc.size()];
		JPanel invep= new JPanel();
		
		if(invevc.size()==0){
			invep.add(new Label("�����Ͻ� �ֽ��� �����ϴ�."));
		} else{
			invep.setLayout(new GridLayout(invevc.size()+1,3));
			invep.add(new Label("�ֽĸ�"));invep.add(new Label("�����ֽļ�"));invep.add(new Label("�����ְ�"));
			for(int i=0;i<invevc.size();i++){
				UserInve ui = (UserInve)invevc.get(i);
				invejrb[i]=new JRadioButton(ui.getAccount(),b);
				bg2.add(invejrb[i]);
				invep.add(invejrb[i]);invep.add(new Label(""+ui.getNumber()+" ��"));invep.add(new Label(""+ui.getValue()+"��"));
				b=false;
			}
		}
		return invep;
	}//public JPanel sellInvestment(String a)

	public JPanel sellDeposit(String a){
		boolean b=true;
		ButtonGroup bg2 = new ButtonGroup();
		depojrb = new JRadioButton[depovc.size()];
		JPanel depop= new JPanel(); 

		if(depovc.size()==0){
			depop.add(new Label("�����Ͻ� ������ �����ϴ�."));
		}
		else{
			depop.setLayout(new GridLayout(depovc.size()+1,3));
			depop.add(new Label("���ݸ�"));depop.add(new Label("�����ڱ�"));depop.add(new Label("������(%)"));
			for(int i=0;i<depovc.size();i++){
				UserDepo ud = (UserDepo)depovc.get(i);
				depojrb[i]=new JRadioButton(ud.getAccount(),b);
				bg2.add(depojrb[i]);
				depop.add(depojrb[i]);depop.add(new Label(""+ud.getMoney()+"��"));depop.add(new Label(""+ud.getRate()+"%"));
				b=false;
			}
		}
		return depop;

	}//public JPanel sellDeposit(String a)

	public void getDeposit(String a){
		depovc=new Vector();
		String query = "select usedeposit.account,usedeposit.money,deposit.rate from usedeposit inner join deposit on usedeposit.account = deposit.account where id='"+a+"'";  
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				UserDepo ud = new UserDepo(rs.getString(1),rs.getInt(2),rs.getInt(3));
				depovc.add(ud);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){System.out.print("����");}
	}//public void getDeposit(String a)

	public void itemStateChanged(ItemEvent ie){
		if(jr1.isSelected()){
			p2.removeAll();
			p2.add(sellInvestment(usif.getID()));
			pack();
			jl1.setText(" �ֽ��Ǹż� : ");
			jl2.setText(" �� ");
		} else if(jr2.isSelected()){
			p2.removeAll();
			p2.add(sellDeposit(usif.getID()));
			pack();
			jl1.setText(" ��ݱݾ� : ");
			jl2.setText(" �� ");
		}
	}//public void itemStateChanged(ItemEvent ie)

	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("�Ǹ�")){
			sell();    
		}
		if(str.equals("�ݱ�")){
			setVisible(false);
			new LoginTitle(usif);
		}
	}//public void actionPerformed(ActionEvent ae)

	public void sell(){
		try{
			int str=Integer.parseInt(jtf.getText());

			if(jr1.isSelected()){
				invesell(str); 
				new MyMoney(usif,true);
				setVisible(false);  
			}
			else{
				deposell(str);
				new MyMoney(usif,false);
				setVisible(false);
			}
		}catch(Exception ee){Project.Message(this,"���ڸ� �Է����ּ���.","�Է¿���",0);}

	}//public void sell()

	public void invesell(int str){
		UserInve uise;

		for(int i=0;i<invejrb.length;i++){
			if(invejrb[i].isSelected()){
				uise = (UserInve)invevc.get(i); 
				invesell2(uise,str);   
				break;
			}
		}  
	}//public void invesell(int str)

	public void invesell2(UserInve usiv,int str){
		int num = str;

		if(usiv.getNumber()>num){ //�ǸŰ���
			usif.inMoney(""+usiv.getMoney(num));
			inveDB(usif.getMoney(),false,usiv,num);
			Project.Message(this,""+num+"���� �ֽ��� �Ǹ��Ͽ����ϴ�.","�Ǹ� �Ϸ�",1);
		}
		else if(usiv.getNumber()==num){   //�ǸŰ���* ���Ƽ� useinvestment�� �մ³�����������
			usif.inMoney(""+usiv.getMoney(num));
			inveDB(usif.getMoney(),true,usiv,num);
			Project.Message(this,usiv.getAccount()+"�� �ֽ��� ����Ǹ� �Ͽ����ϴ�.","��� �Ǹ�",1);
		}
		else{
			Project.Message(this,""+usiv.getNumber()+"�� ���� �Ǹ� �����մϴ�.","�ֽ��ʰ�",0);
		}

	}//public void invesell2(UserInve usiv,int str)

	public void inveDB(long money,boolean del,UserInve usiv,int num){
		String update = "update java set money="+usif.getMoney()+" where id='"+usif.getID()+"'";   //javaDB����
		String update2;
		String update3=null;
		String query = "select number from investment where account='"+usiv.getAccount()+"'";
		
		if(del){update2 = "delete from useinvestment where account='"+usiv.getAccount()+"' and id='"+usif.getID()+"'";}   // useinvestmentDB����
		else{update2= "update useinvestment set number="+usiv.getNumber()+" where id='"+usif.getID()+"' and account='"+usiv.getAccount()+"'";}
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			int rsi=rs.getInt(1);
			num=num+rsi;
			update3 = "update investment set number="+num+" where account='"+usiv.getAccount()+"'";
			stmt.executeUpdate(update);
			stmt.executeUpdate(update2);
			stmt.executeUpdate(update3);
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){System.out.println("����");}
	}//public void inveDB(long money,boolean del,UserInve usiv,int num)

	public void deposell(int str){
		UserDepo udse;
		for(int i=0;i<depojrb.length;i++){
			if(depojrb[i].isSelected()){
				udse=(UserDepo)depovc.get(i);
				deposell2(udse,str);    
				break;
			}
		}//for
	}//public void deposell(int str)

	public void deposell2(UserDepo usdp,int str){
		if(usdp.getMoney()>str){ //�ǸŰ���
			usdp.delMoney(str);
			usif.inMoney(""+usdp.getMoney());
			depoDB(usif.getMoney(),false,usdp,str);
			Project.Message(this,""+str+"���� �ݾ��� ã���̽��ϴ�.","���� �Ϸ�",1);
		}
		else if(usdp.getMoney()==str){   //�ǸŰ���* ���Ƽ� usedeposit�� �մ³�����������
			usdp.delMoney(str);
			usif.inMoney(""+usdp.getMoney());
			depoDB(usif.getMoney(),true,usdp,str);
			Project.Message(this,usdp.getAccount()+"�� ��� �����ϼ̽��ϴ�","���� ����",1);
		} else{
			Project.Message(this,""+usdp.getMoney()+"�� ���� �����մϴ�.","���ݾ��ʰ�",0);
		}
	}//public void deposell2(UserDepo usdp,int str)

	public void depoDB(long mymoney,boolean b,UserDepo usdp,int sellmoney){
		String update = "update java set money="+usif.getMoney()+" where id='"+usif.getID()+"'";   //javaDB����
		String update2;

		if(b){update2 = "delete from usedeposit where account='"+usdp.getAccount()+"' and id='"+usif.getID()+"'";} // useinvestmentDB����
		else{update2= "update usedeposit set money="+usdp.getMoney()+" where id='"+usif.getID()+"' and account='"+usdp.getAccount()+"'";}

		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			stmt.executeUpdate(update2);
			stmt.close();
			conn.close();
		}catch(SQLException ee){System.out.println("����");}
	}//public void depoDB(long mymoney,boolean b,UserDepo usdp,int sellmoney)

}// class MyMoney extends JFrame implements ActionListener,ItemListener



class NewDeposit extends JFrame implements ActionListener{  //���ݰ��� ��� Ŭ����..
	private UserInfo usif;
	private String[][] sdeposit=null;
	private JRadioButton[] jr=null;
	private Container contentPane; 
	private JTextField moneytf;
	private ButtonGroup bg;

	public NewDeposit(UserInfo us){
		setTitle("���ݰ���");
		usif=us;
		contentPane = getContentPane();
		moneytf = new JTextField(10);  
		JPanel jp1 = new JPanel();
		sdeposit=showlist();
		jp1=choicep(sdeposit);
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JButton jb1 = new JButton("���ݰ���");jb1.addActionListener(this);
		JButton jb2 = new JButton("���");jb2.addActionListener(this);
		jp2.setLayout(new GridLayout(1,2));
		jp2.add(jb1);jp2.add(jb2);jp3.add(new Label("�ݾ� : "));jp3.add(moneytf);jp3.add(new Label(" ��"));
		jp4.add(jp3);jp4.add(jp2);
		contentPane.add(jp1,"Center");
		contentPane.add(jp4,"South");
		pack();
		setVisible(true);
	}//public NewDeposit(UserInfo us)

	public String[][] showlist(){
		String deposits[][]=null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		String query = "select *from deposit order by rate";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			rs.last();
			int i =0;
			deposits = new String[2][rs.getRow()];
			rs.first();
			while(true){
				deposits[0][i]=rs.getString(1);
				deposits[1][i++]=""+rs.getInt(2);
				if(!rs.next()){break;}
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){}

		return deposits;
	}//public String[][] showlist()

	public JPanel choicep(String[][] a){
		Boolean b = true;
		JPanel choicep = new JPanel();
		choicep.setLayout(new GridLayout(a[0].length+1,1));
		bg= new ButtonGroup();
		jr= new JRadioButton[a[0].length];

		if(a[0].length!=0){choicep.add(new Label("���ݸ� (������ %)"));}
		else{choicep.add(new Label("������ ������ �����ϴ�."));}
		for(int i=0;i<a[0].length;i++){
			jr[i] = new JRadioButton(a[0][i]+" (������: "+a[1][i]+"%)",b);
			bg.add(jr[i]);
			choicep.add(jr[i]);
			b=false;
		}
		return choicep;
	}//public JPanel choicep(String[][] a)

	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("���ݰ���")){
			useDeposit(choice());
		} else if(str.equals("���")){
			setVisible(false);new LoginTitle(usif);
		}
	}//public void actionPerformed(ActionEvent ae)

	public int choice(){
		int getI = 0;
		for(int i=0;i<jr.length;i++){
			if(jr[i].isSelected()){
				getI=i;
				break;
			}
		}
		return getI;
	}//public int choice()

	public void useDeposit(int i){
		String update;
		String check = "select *from usedeposit where id='"+usif.getID()+"' and account='"+sdeposit[0][i]+"'";
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			if(moneytf.getText().equals("")){Project.Message(this,"���� �Է����ּ���.","����",0);}
			else if(usif.getMoney()>=Long.parseLong(moneytf.getText())){
				try{
					Connection conn = DriverManager.getConnection(url,id,pw);
					Statement stmt = conn.createStatement();
					ResultSet rs=stmt.executeQuery(check);
					long money1=Long.parseLong(moneytf.getText());
				if(rs.next()){
					long money2 = rs.getInt(2);
					long money3 = money1+money2;
					usif.outMoney(moneytf.getText());
					update = "update usedeposit set money="+money3+" where id='"+usif.getID()+"' and account='"+sdeposit[0][i]+"'";
					stmt.executeUpdate(update);
				}
				else if(!rs.next()){
					update = "insert into usedeposit values('"+usif.getID()+"',"+moneytf.getText()+",'"+sdeposit[0][i]+"')";
					usif.outMoney(moneytf.getText());
					stmt.executeUpdate(update);
				}
				Project.Message(this,"���������� �����Ͽ����ϴ�.","���ݼ���",1);
				stmt.close();
				conn.close();
				}catch(Exception ee){Project.Message(this,"�Աݱݾ� �ʰ��Դϴ�.","����",0);}
			} else{
				Project.Message(this,usif.getMoney()+"������ �����մϴ�.","����",0);
			}
		}catch(Exception eee){Project.Message(this,"���ڸ� �Է����ֽʽÿ�.","�����Է�",0);}
		reSave();
	}//public void useDeposit(int i)

	public void reSave(){
		String update="update java set money="+usif.getMoney()+" where id='"+usif.getID()+"'";
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			stmt.close();
			conn.close();
		}catch(SQLException ee){}
	}  // public void reSave()

}//class NewDeposit extends JFrame implements ActionListener


class NewInvestment extends JFrame implements ActionListener,ItemListener,KeyListener {  //�ֽ����� ��� Ŭ����..
	private UserInfo usif;
	private Container contentPane; 
	private JTextField numbertf;
	private JRadioButton jrb[];
	private ButtonGroup bg;
	private JLabel jl;
	private Vector vc;
	private Investment maininve;
	private int chei=0,sum=0;

	public NewInvestment(UserInfo us){
		setTitle("�ֽ�����");
		usif=us;
		contentPane = getContentPane();
		numbertf = new JTextField(8);
		numbertf.addKeyListener(this);
		getDB();  
		JPanel jp1 = new JPanel();
		jp1=choicep();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		jp4.setLayout(new GridLayout(3,1));
		JButton jb1 = new JButton("�ֽ�����");jb1.addActionListener(this);
		JButton jb2 = new JButton("���");jb2.addActionListener(this);
		jl = new JLabel("������ �� "+sum+"�� �Դϴ�.");
		jp2.add(jb1);jp2.add(jb2);jp3.add(new Label("�����Ұ��� : "));jp3.add(numbertf);jp3.add(new Label(" ��"));
		jp4.add(jp3);jp4.add(jl);jp4.add(jp2);
		contentPane.add(jp1,"Center");
		contentPane.add(jp4,"South");
		pack();
		setVisible(true);
	}//public NewInvestment(UserInfo us)

	public void getDB(){
		vc = new Vector();
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		String query = "select *from investment where number!=0 order by value ";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Investment inve = new Investment(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
				vc.add(inve);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){System.out.println("�����ճ�?");}
	}

	public JPanel choicep(){
		JPanel getjp1 = new JPanel();
		JPanel getjp2 = new JPanel();
		JPanel getjp3 = new JPanel();
		JPanel getjp = new JPanel();
		jrb=new JRadioButton[vc.size()];
		Boolean b = true;
		getjp1.setLayout(new GridLayout(jrb.length+1,1));
		getjp2.setLayout(new GridLayout(jrb.length+1,1));
		getjp3.setLayout(new GridLayout(jrb.length+1,1));
		bg= new ButtonGroup();

		if(jrb.length!=0){
			getjp1.add(new Label(" �ֽĸ� "));getjp2.add(new Label(" �ֽİ��� "));getjp3.add(new Label(" �ֽļ� "));
			maininve=(Investment)vc.get(0);
		}
		else{
			getjp.add(new Label("������ �ֽ��� �����ϴ�."));
		}//if

		for(int i=0;i<jrb.length;i++){
			Investment inve = (Investment)vc.get(i);
			jrb[i]=new JRadioButton(inve.getAccount(),b);
			jrb[i].addItemListener(this);
			bg.add(jrb[i]);
			getjp1.add(jrb[i]);
			getjp2.add(new Label(""+inve.getValue()));
			getjp3.add(new Label(""+inve.getNumber()));
			b=false;   
		}
		getjp.add(getjp1);getjp.add(getjp2);getjp.add(getjp3);  
		return getjp;
	}//public JPanel choicep()

	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();

		if(str.equals("�ֽ�����")){

			if(!(numbertf.getText()).replace("0","").equals("")){

				if(usif.outMoney(sum)){

					if(delInvestment(numbertf.getText())){
						useInvestment(numbertf.getText());
						reSave();
						new NewInvestment(usif);
						Project.Message(this,"���������� �����Ͽ����ϴ�.","���ż���",1);
						setVisible(false);
					}//if(delInvestment(numbertf.getText()))

				} else{ // if(usif.outMoney(sum))
					Project.Message(this,"���űݾ� �ʰ��Դϴ�.","�ݾ��ʰ�",0);
				}// if(usif.outMoney(sum))

				numbertf.setText("");
				sum=0;
				jl.setText("������ �� "+sum+"�� �Դϴ�.");

			} else{

				Project.Message(this,"��Ȯ�� �����Է����ּ���","����Ȯ��",0);
			} // //if(!(numbertf.getText()).replace("0","").equals(""))

		} else if(str.equals("���")){
			setVisible(false);new LoginTitle(usif);
		}//if(str.equals("�ֽ�����"))

	}//public void actionPerformed(ActionEvent ae)

	public void keyPressed(KeyEvent e){}

	public void keyReleased(KeyEvent e){   //�̺�Ʈ����,..
		if(numbertf.getText().equals("")){
			sum=0;
			jl.setText("������ �� "+sum+"�� �Դϴ�.");
		} else if(jrb.length!=0){
			Investment inve=(Investment)vc.get(chei);
			try{
				int num=Integer.parseInt(numbertf.getText());
				sum=num*inve.getValue();
				jl.setText("������ �� "+sum+"�� �Դϴ�.");
			}catch(Exception ee){
				Project.Message(this,"���ڸ� �Է��ϼ���","�Է¿���",0);numbertf.setText("");
			}
		}// if

	}//public void keyReleased(KeyEvent e)

	public void keyTyped(KeyEvent te){}

	public void itemStateChanged(ItemEvent ie){    //�̺�Ʈ����
		for(int i=0;i<jrb.length;i++){
			if(jrb[i].isSelected()){
				try{
					maininve=(Investment)vc.get(i);
					int num=Integer.parseInt(numbertf.getText());
					sum=num*maininve.getValue();
				}catch(Exception ee){sum=0;}

				jl.setText("������ �� "+sum+"�� �Դϴ�.");
				chei=i;
				break;
			}
		}
	}//public void itemStateChanged(ItemEvent ie)

	public void useInvestment(String a){   //�����ϴ� �޼ҵ�.
		String update;
		String check = "select *from useinvestment where id='"+usif.getID()+"' and account='"+maininve.getAccount()+"'";
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";

		if(numbertf.getText().equals("")){Project.Message(this,"���� �Է����ּ���.","����",0);}
		else{
			try{
				Connection conn = DriverManager.getConnection(url,id,pw);
				Statement stmt = conn.createStatement();
				ResultSet rs=stmt.executeQuery(check);
				int num1=Integer.parseInt(numbertf.getText());

				if(rs.next()){
					int num2 = rs.getInt(2);
					int num3 = num1+num2;
					update = "update useinvestment set number="+num3+" where id='"+usif.getID()+"' and account='"+maininve.getAccount()+"'";
					stmt.executeUpdate(update);
				} else if(!rs.next()){
					update="insert into useinvestment values('"+usif.getID()+"',"+a+",'"+maininve.getAccount()+"')";
					stmt.executeUpdate(update);
				}// if
				stmt.close();
				conn.close();
			}catch(SQLException ee){}
		}//if

	}//public void useInvestment(String a)

	public boolean delInvestment(String a){   //�������ֽĸ�ŭ ���ֽļ����� �������ϴ� �޼ҵ�
		boolean b = false;
		int j = Integer.parseInt(a);
		String check = "select number from investment where account='"+maininve.getAccount()+"'";
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(check);
			rs.next();
			int i=rs.getInt(1);
			if(j<=i){
				i=i-j;
				String update = "update investment set number="+i+" where account='"+maininve.getAccount()+"'";
				stmt.executeUpdate(update);
				b=true;
			} else{
				Project.Message(this,"�����Ҽ��ִ� ������ �ʰ��Ͽ����ϴ�(�ִ� : "+rs.getInt(1)+"��)","�Է¿���",0);
				numbertf.setText("");
				sum=0;
				jl.setText("������ �� "+sum+"�� �Դϴ�.");
			}//if
		}catch(SQLException ee){System.out.println("����������..");}

		return b;
	}//public boolean delInvestment(String a)

	public void reSave(){   //�ٽ�����..
		String update="update java set money="+usif.getMoney()+" where id='"+usif.getID()+"'";
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			stmt.close();
			conn.close();
		}catch(SQLException ee){}
	}// public void reSave()

}// class NewInvestment extends JFrame implements ActionListener,ItemListener,KeyListener


class InoutMoney extends JFrame implements ActionListener{  //����� ��� Ŭ����..
	private Container contentPane;
	private UserInfo usif;
	private JRadioButton jrb1,jrb2;
	private JTextField jtf;

	public InoutMoney(UserInfo us){   //����ݸ���� ����â
		usif=us;
		setTitle("����ݸ��");
		jtf = new JTextField(10);
		contentPane = getContentPane();  
		jrb1 = new JRadioButton("�Ա�",true);
		jrb2 = new JRadioButton("���",false);
		JButton jb = new JButton("Ȯ��");
		JButton jb2 = new JButton("�ݱ�");
		jb.addActionListener(this);jb2.addActionListener(this);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);bg.add(jrb2);
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(jrb1);jp1.add(jrb2);
		jp2.add(new Label("�ݾ� : "));
		jp2.add(jtf);jp2.add(new Label(" ��"));jp2.add(jb);jp2.add(jb2);
		contentPane.setLayout(new GridLayout(2,1));
		contentPane.add(jp1);contentPane.add(jp2);
		pack();
		setVisible(true);
	}//public InoutMoney(UserInfo us)

	public void actionPerformed(ActionEvent ae){   //�̺�Ʈ..
		String str = ae.getActionCommand();
		if(str.equals("Ȯ��")){
			money();   
		} else if(str.equals("�ݱ�")){
			setVisible(false);
			new LoginTitle(usif);
		}
	}//public void actionPerformed(ActionEvent ae)

	public void money(){
		try{
			if(100000000l<Long.parseLong(jtf.getText())){
				Project.Message(this,"�ѹ��� 1����� ����ݰ����մϴ�.","����ݿ���",0);
			} else if(jrb1.isSelected()){  //�Ա� ��������..(Ȯ�δ����鵿���մϴ�.)
				usif.inMoney(jtf.getText());
				reSave();
				Project.Message(this,jtf.getText()+"���� �ԱݵǾ �� "+usif.getMoney()+"�� �� �Ǿ����ϴ�.","�ԱݿϷ�",1);
			} else if(jrb2.isSelected()){  //��� ��������..
				if(usif.outMoney(jtf.getText())){
					reSave();
					Project.Message(this,jtf.getText()+"���� ��ݵǾ �� "+usif.getMoney()+"�� �� �Ǿ����ϴ�.","��ݿϷ�",1);
				}
				else{Project.Message(this,usif.getMoney()+"�� ���� ����ϽǼ� �ֽ��ϴ�.","��ݺҰ�",0);}
			}// if
		}catch(Exception ee){Project.Message(this,"���ڸ� �Է����ּ���.","����ݿ���",0);}
	}//public void money()

	public void reSave(){   //�ٽ� DB�� �����ϴ� �޼ҵ�
		String update="update java set money="+usif.getMoney()+" where id='"+usif.getID()+"'";
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			stmt.close();
			conn.close();
		}catch(SQLException ee){}
	}//public void reSave()

}//class InoutMoney extends JFrame implements ActionListener


class NewUser extends JFrame implements ActionListener{   //ȸ������ Ŭ����.
	private JTextField newidtf,newnametf,newbirthdaytf,newphonetf,newemailtf,newaddresstf;
	private JButton idcheckb,okb,cancelb,clearb;
	private JPasswordField newpwtf;
	private Boolean blidcheck;
	private JFrame checkjf;

	public NewUser(){
		blidcheck = false;
		setTitle("ȸ������"); 
		Container contentPane = getContentPane();
		idcheckb = new JButton("�ߺ�Ȯ��");
		okb = new JButton("Ȯ��");
		cancelb = new JButton("���");
		clearb = new JButton("�ٽ��ۼ�");
		okb.addActionListener(this);
		cancelb.addActionListener(this);
		clearb.addActionListener(this);
		idcheckb.addActionListener(this);
		newidtf = new JTextField(10);
		newpwtf = new JPasswordField(10);
		newpwtf.setEchoChar('*');
		newnametf = new JTextField(10);
		newbirthdaytf = new JTextField(10);
		newphonetf = new JTextField(10);
		newaddresstf = new JTextField(10);
		newemailtf = new JTextField(10);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(7,1));
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(7,1));
		JPanel jp3 = new JPanel();
		jp3.setLayout(new GridLayout(7,1));
		jp1.add(new JLabel("���̵�"));jp1.add(new JLabel("��й�ȣ"));jp1.add(new JLabel("�̸�"));
		jp1.add(new JLabel("�������"));jp1.add(new JLabel("��ȭ��ȣ"));jp1.add(new JLabel("�ּ�"));jp1.add(new JLabel("E-mail"));
		jp2.add(newidtf);jp2.add(newpwtf);jp2.add(newnametf);jp2.add(newbirthdaytf);
		jp2.add(newphonetf);jp2.add(newaddresstf);jp2.add(newemailtf);
		jp3.add(idcheckb);jp3.add(new JLabel());jp3.add(new JLabel());
		jp3.add(new JLabel("ex)19991225"));jp3.add(new JLabel("ex)0325552222"));jp3.add(new JLabel());jp3.add(new JLabel());
		JPanel jp4 = new JPanel();
		jp4.setLayout(new GridLayout(1,3));
		jp4.add(jp1);jp4.add(jp2);jp4.add(jp3);
		JPanel jp5 = new JPanel();
		jp5.add(okb);jp5.add(cancelb);jp5.add(clearb);
		contentPane.add(jp4,"Center");contentPane.add(jp5,"South");
		pack();
		setVisible(true);
	}//public NewUser()

	public void actionPerformed(ActionEvent ae){  //�̺�Ʈ����..
		String s = ae.getActionCommand();
		if(s.equals("�ߺ�Ȯ��")){
			checkTitle(idcheck());
		} else if(s.equals("Ȯ��")){
			if(blidcheck){
				usercheck();
				Project.Message(this,"ȸ�������� �Ϸ�Ǿ����ϴ�.","���ԿϷ�",1);
				setVisible(false);
				new Title();
			} else{
				Project.Message(this,"�ߺ��� ID�� �ְų� �ߺ�Ȯ���� ���ϼ̽��ϴ�.","���ԺҰ���",0); 
			}//if
			blidcheck=false;
		} else if(s.equals("���")){
			setVisible(false);
			new Title();
		} else if(s.equals("�ٽ��ۼ�")){
			blidcheck=false;
			newidtf.setEditable(true);
			newidtf.setText("");
			newpwtf.setText("");
			newnametf.setText("");
			newbirthdaytf.setText("");
			newphonetf.setText("");
			newaddresstf.setText("");
			newemailtf.setText("");
		} else if(s.equals("�ݱ�")){
			checkjf.setVisible(false);
		}//if

	}//public void actionPerformed(ActionEvent ae)

	public void checkTitle(Boolean b){   //�ߺ�Ȯ���Ŀ� ��ȯ�� Boolean���� �μ��� �����ͼ� JFrameâ�� ���� �޼ҵ�
		blidcheck=b;
		checkjf = new JFrame("�ߺ�Ȯ��");
		checkjf.setSize(200,100);
		JPanel checkjp = new JPanel();
		JButton closejb = new JButton("�ݱ�");
		closejb.addActionListener(this);
		Container checkPane = checkjf.getContentPane();
		JLabel l;
		String staaa = newidtf.getText();
		if(staaa.equals("")){
			l = new JLabel("���̵� �Է��� �ּ���.");
			blidcheck = false; 
		} else if(blidcheck){
			l = new JLabel("ID ����� ���� �մϴ�.");
			newidtf.setEditable(false);   
		} else{
			l = new JLabel("�ߺ��� ID�� �ֽ��ϴ�.");
		}
		checkjp.add(l);
		checkjp.add(closejb);
		checkPane.add(checkjp,"Center");
		checkjf.setVisible(true);
	}//public void checkTitle(Boolean b)

	public void usercheck(){   //ȸ�����ԵǴ°�. DB�� �ٷ�����.
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){System.out.print("ù��°");}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pass = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pass);
			Statement stmt = conn.createStatement();
			String abc = "insert into java values('"+newidtf.getText()+"','"+newpwtf.getText()+"','"+newnametf.getText()+"','"+newbirthdaytf.getText()+"','"+newphonetf.getText()+"','"+newaddresstf.getText()+"','"+newemailtf.getText()+"',"+0+")";
			stmt.executeUpdate(abc);
		}catch(SQLException ee){}
	}//public void usercheck()

	public Boolean idcheck(){ //ID �ߺ�Ȯ�� �ϴ� �޼ҵ�. �׸��� �ߺ��Ȱ��� ������ false, ������ true�� ��ȯ
		String s = null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){System.out.println("���䰡?");}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pass = "dytc1234";
		try{
			Connection conn = DriverManager.getConnection(url,id,pass);
			String str = "select *from java where id='"+newidtf.getText()+"';";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			while(rs.next()){
				s = rs.getString("id");
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){System.out.print("���۾ȵ�");}

		if(s==null){
			return true;
		} else{ return false;}
	}//public Boolean idcheck()

}//class NewUser extends JFrame implements ActionListener



class Search extends JFrame implements ActionListener,ItemListener{   //ID�Ǵ�PW �˻�Ŭ����
	private JButton idb;
	private JRadioButton idsearch,pwsearch;
	private JTextField firsttf,secondtf;
	private JLabel al,bl;
	private ButtonGroup bg;

	public Search(){
		setTitle("ID/PW�˻�");
		Container contentPane = getContentPane();
		idsearch = new JRadioButton("ID �˻�",true);
		pwsearch = new JRadioButton("PW �˻�",false);
		bg = new ButtonGroup();
		idb = new JButton("ID  ã��");
		JButton closeb = new JButton("�ݱ�");
		firsttf = new JTextField(10);
		secondtf = new JTextField(10);
		al = new JLabel("��         �� �Է� : ");
		bl = new JLabel("������� �Է� : ");
		idb.addActionListener(this);
		closeb.addActionListener(this);
		idsearch.addItemListener(this);
		pwsearch.addItemListener(this);
		bg.add(idsearch);
		bg.add(pwsearch);
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp3.setLayout(new GridLayout(2,2));
		jp3.add(al);
		jp3.add(firsttf);
		jp3.add(bl);
		jp3.add(secondtf);
		jp2.add(idb);
		jp2.add(closeb);
		jp.add(idsearch);
		jp.add(pwsearch);
		contentPane.add(jp,"North");
		contentPane.add(jp2,"South");
		contentPane.add(jp3,"Center");
		setSize(200,150);
		setVisible(true);
	}//public Search()

	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("�ݱ�")){
			setVisible(false);
			new Title();
		} else if((firsttf.getText().equals(""))||(secondtf.getText().equals(""))){
			Project.Message(this,"������ �ֽ��ϴ�.","�˻� ����",0);
		} else if(str.equals("ID  ã��")){
			String strid[] = idSearch(firsttf.getText(),secondtf.getText());
			if(strid.length!=0){
				String a="";
				for(int i=0;i<strid.length;i++){
					if(i==0){a=a+strid[i];}
					else{a=a+","+strid[i];}
				}//for
				Project.Message(this,"����� ID�� �� "+strid.length+"�� �Դϴ�. ("+a+")","���̵� Ȯ��",1);
			} else{
				Project.Message(this,"��ġ�ϴ� ������ �������� �ʽ��ϴ�.","ã������",1);
			}
			firsttf.setText("");
			secondtf.setText("");
		} else if(str.equals("PWã��")){
			String strpw = pwSearch(firsttf.getText(),secondtf.getText());
			if(strpw!=null){
				Project.Message(this,"����� PW�� '"+strpw+"' �Դϴ�.","�н����� Ȯ��",1);
			} else{
				Project.Message(this,"��ġ�ϴ� ������ �������� �ʽ��ϴ�.","ã������",1);
			}
			firsttf.setText("");
			secondtf.setText("");
		} else if(str.equals("�ݱ�")){
			setVisible(false);
		}//else if

	}//public void actionPerformed(ActionEvent ae)

	public void itemStateChanged(ItemEvent ie){
		if(idsearch.isSelected()){			//id�˻��� ��������..
			firsttf.setText("");
			secondtf.setText("");
			idb.setText("ID  ã��");
			al.setText("��         �� �Է� : ");
			bl.setText("������� �Է� : ");
		} else if(pwsearch.isSelected()){   //pw�˻��� ��������..
			firsttf.setText("");
			secondtf.setText("");
			idb.setText("PWã��");
			al.setText("  I    D �Է� : ");
			bl.setText("  E-mail �Է� : ");
		}
	}//public void itemStateChanged(ItemEvent ie)

	public String[] idSearch(String a, String b){    //String �迭�� ��ȯ�Ѵ�. ID�� 1���̻��ϼ��� �����Ƿ�..
		String restr[]=null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		String search = "select *from java where name = '"+a+"' and birthday ='"+b+"'";

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(search);
			rs.last();				//ResultSet��ü�� �������̵�
			int i=rs.getRow();		//������ �̵��� ������ġ�� ���������´�.
			restr = new String[i];	//String�迭��ü�� ���缭 �����.
			rs.first();				//�ٽ� ó������ �̵�
			for(int j=0;j<i;j++){  
				restr[j] = rs.getString("id");
				rs.next();
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){}
		return restr;
	}//public String[] idSearch(String a, String b)

	public String pwSearch(String a,String b){     //String���� ��ȯ�Ѵ�. PW�� ������ �ϼ��� ����.
		String restr=null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		String search = "select *from java where id = '"+a+"' and email ='"+b+"'";
		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(search);
			rs.next();
			restr = rs.getString("pass");
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){System.out.println("�����߻�");}

		return restr;
	}//public String pwSearch(String a,String b)

}//class Search extends JFrame implements ActionListener,ItemListener



class Title extends JFrame implements ActionListener{   //TitleŬ����, JFrame Ŭ������ ��ӹް� ActionListener�������̽� ����
	private JTextField idtf;
	private JPasswordField pwtf;
	private JButton adminb,loginb,searchb,newuserb;

	public Title(){ //����ȭ�� â�� �����ش�.
		setTitle("����ȭ��");
		Container contentPane = getContentPane();
		idtf = new JTextField(10);
		pwtf = new JPasswordField(10);
		pwtf.setEchoChar('*');
		adminb = new JButton("�����ڸ��");
		loginb = new JButton("�α���");
		searchb = new JButton("ID/PWã��");
		newuserb = new JButton("ȸ������");
		adminb.addActionListener(this);
		loginb.addActionListener(this);
		searchb.addActionListener(this);
		newuserb.addActionListener(this);
		JLabel idl = new JLabel("ID");
		JLabel pwl = new JLabel("PW");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(jpadd(idl,pwl));
		jp1.add(jpadd(idtf,pwtf));
		jp1.add(jpadd(adminb,loginb));
		jp2.add(searchb);
		jp2.add(newuserb);
		contentPane.add(jp1,"Center");
		contentPane.add(jp2,"South");
		pack();
		setVisible(true);
	}//public Title()

	public boolean adminlogin(String a){  //������ �α��� Ȯ�� !!
		String adminpw="1234";
		if(a.equals(adminpw)){
			return true;
		}
		else{return false;}
	}//public boolean adminlogin(String a)

	public void actionPerformed(ActionEvent ae){  //�̺�Ʈ����, ��ư����� �������Ŀ����� ����
		String s = ae.getActionCommand();
		if(s.equals("�����ڸ��")){
			idtf.setText("");
			pwtf.setText("");
			idtf.setEditable(false);
			adminb.setText("����ڸ��");
			loginb.setText("����������");
			searchb.setEnabled(false);
			newuserb.setEnabled(false);
			pack();
		} else if(s.equals("�α���")){
			UserInfo uif = login(idtf.getText(),pwtf.getText());
			if(null!=uif){
			setVisible(false);
			new LoginTitle(uif);
			}
		} else if(s.equals("ID/PWã��")){
			setVisible(false);
			new Search();
		} else if(s.equals("ȸ������")){
			setVisible(false);
			new NewUser();
		} else if(s.equals("����ڸ��")){
			idtf.setEditable(true);
			adminb.setText("�����ڸ��");
			loginb.setText("�α���");
			searchb.setEnabled(true);
			newuserb.setEnabled(true);
			pack();
		} else if(s.equals("����������")){
			if(adminlogin(pwtf.getText())){
				setVisible(false); 
				new Admin_frame();
			} else{}
		}
	}//public void actionPerformed(ActionEvent ae)

	public JPanel jpadd(Component e,Component f){  //�׳� ������ jpadd�޼ҵ� ����.
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,1));
		p.add(e);
		p.add(f);

		return p;
	}//public JPanel jpadd(Component e,Component f)

	public UserInfo login(String a,String b){   //�α��� �����ÿ� UserInfo��ü�� �������� ���нÿ� null���� �����´�.
		String s = null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException ee){}

		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dytc1234";
		UserInfo usif=null;

		try{
			Connection conn = DriverManager.getConnection(url,id,pw);
			Statement stmt = conn.createStatement();
			String str = "select *from java where id='"+a+"'and pass='"+b+"'";
			ResultSet rs = stmt.executeQuery(str);
			rs.next();
			usif = new UserInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ee){Project.Message(this,"ID�Ǵ�PW�� Ʋ�Ƚ��ϴ�.","���ӺҰ�",0);}

		return usif;
	}//public UserInfo login(String a,String b)

}//class Title extends JFrame implements ActionListener




class UserInfo{   //���� ���� Ŭ����
	private String id,password,name,address,birthday,email,phone;  //���̵� ��й�ȣ �̸� �ּ� ���� �̸��� ��ȭ��ȣ�� ����.
	private long money;

	public UserInfo(String id,String password,String name,String birthday,String phone,String address,String email,long money){
		this.id=id;
		this.password=password;
		this.name=name;
		this.birthday=birthday;
		this.phone=phone;
		this.address=address;
		this.email=email;
		this.money=money;
	}

	public String getID(){return id;}

	public String getPW(){return password;}

	public String getName(){return name;}

	public String getBirthday(){return birthday;}

	public String getPhone(){return phone;}

	public String getAddress(){return address;}

	public String getEmail(){return email;}

	public long getMoney(){return money;}

	public void setID(String id){this.id=id;}

	public void setPW(String password){this.password=password;}

	public void setName(String name){this.name=name;}

	public void setBirthday(String birthday){this.birthday = birthday;}

	public void setPhone(String phone){this.phone=phone;}

	public void setAddress(String address){this.address=address;}

	public void setEmail(String email){this.email=email;}

	public void inMoney(String money){this.money = this.money+Long.parseLong(money);}

	public boolean outMoney(String money){
		long outmoney =Long.parseLong(money);
		if(this.money>=outmoney){
			this.money=this.money-outmoney;
			return true;
		}
		else {return false;}
	}//public boolean outMoney(String money)

	public boolean outMoney(int money){
		long outmoney =money;
		if(this.money>=outmoney){
			this.money=this.money-outmoney;
			return true;
		}
		else {return false;}
	}//public boolean outMoney(int money)
}//class UserInfo


class UserInve{
	private int number;			//������ �ֽİ���
	private String account;		//������ �ֽĸ�
	private int value;

	public UserInve(String account,int number,int value){   //�ٸ��ֽ��� �ֽĻ춧(�ű��ֽ�)
		this.account = account;
		this.number = number;
		this.value=value;
	}//public UserInve(String account,int number,int value)

	public UserInve(String account,String number){   
		this.account = account;
		this.number = Integer.parseInt(number);
	}//public UserInve(String account,String number)

	public String getAccount(){return account;}

	public int getNumber(){return number;}

	public int getValue(){return value;}

	public int getMoney(int a){
		number=number-a;
		return value*a;
	}
}//class UserInve



class UserDepo{
	private float rate;			//����
	private String account;		//������ ���ݸ�
	private int money;			//�����ѵ�
	private String id;

	public UserDepo(String id,String account,int money,int rate){
		this.id=id;
		this.account=account;
		this.money=money;
		this.rate=rate;
	}

	public UserDepo(String account,int money,int rate){  //�ٸ����ݿ� �����Ҷ�(�űԿ���)
		this.account=account;
		this.money=money;
		this.rate=rate;
	}

	public UserDepo(String account,String money){  
		this.account=account;
		this.money=Integer.parseInt(money);
	}

	public String getID(){return id;}

	public String getAccount(){return account;}

	public float getRate(){return rate;}

	public int getMoney(){return money;}

	public void addMoney(String addmoney){money=money+Integer.parseInt(addmoney);}  //�������ݿ� �������Ҷ�..

	public void delMoney(String delmoney){money=money-Integer.parseInt(delmoney);}  //0���� �۾������ʰ� if���־����.(���ݿ��� ��ã����)]

	public void delMoney(int i){money=money-i;}

	public void dateDepo(){
		float year = (rate/100)/365;
		float plus = money*year;
		float total = plus+money;
		money=(int)total/1;
	}//public void dateDepo()
}//class UserDepo



class Investment{
	private int value,min,max,number;	//value(�ְ�),min(������ּҰ�),max(�ִ밪),number(�ֽİ���)
	private String account;				//account(�ֽĸ�)
	private boolean b=false;

	public Investment(String account,int value,int min,int max){
		this.account = account;
		this.value = value;
		this.min = min;
		this.max = max; 
	}

	public Investment(String account,int value,int number,int min,int max){
		this.account = account;
		this.value = value;
		this.number = number;
		this.min = min;
		this.max = max;  
	}

	public String getAccount(){return account;}

	public int getValue(){return value;}

	public int getMin(){return min;}

	public int getMax(){return max;}

	public int getNumber(){return number;}

	public void addNumber(String addnum){number=number+Integer.parseInt(addnum);}  //�����Ұ��

	public void delNumber(String delnum){number=number-Integer.parseInt(delnum);}  //�����Ұ��

	public void dateInve(){
		Random r = new Random();
		int date=r.nextInt(1+min+max)-min;
		value=value+date;
		if(value<=0){b=true;}
	}//public void dateInve()

	public boolean delInve(){
		return b;
	}//public boolean delInve()
}//class Investment



class Deposit{
	private float rate;			//��������
	private String account;		//���ݸ�

	public Deposit(String account,String rate){
		this.rate = Float.parseFloat(rate);
		this.account = account;
	}//public Deposit(String account,String rate)

	public String getAccount(){return account;}

	public float getRate(){return rate;}
}//class Deposit
