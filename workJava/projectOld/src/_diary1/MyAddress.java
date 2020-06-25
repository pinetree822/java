package _diary1;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class MyAddress extends JInternalFrame implements ActionListener,ListSelectionListener{

	JPanel p1,p2,p1_1,p1_2,p3,p4,p5;
	JButton bt1,bt2,bt3,btSearch;
	JTextArea ta1;
	JTabbedPane tp;
	JLabel lb1,lb2;
	JList lst1;
	DefaultComboBoxModel model;
	JTextField txf,txf2;
	String[] data={"전체","가족","친구","직장"};
	Vector<String> v=new Vector<String>();
	JComboBox combo1;
	
	RegisterLayout rl;
	RegisterLayoutEdit rlEdit;
	Person p;
	PhoneBookManager manager;
	int index;
	

	
	public MyAddress(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		//super(":::Test2:::");
		super(title, resizable, closable, maximizable, iconifiable);
		
		Container cp = this.getContentPane();//ContentPane
		cp.setLayout(new GridLayout(1,2));
		p1=new JPanel(){
			public Insets getInsets(){
				return new Insets(20,20,10,10);
			}
		};
		p2=new JPanel(){
			public Insets getInsets(){
				return new Insets(20,20,10,10);
			}
		};
		JPanel p2_1=new JPanel();
		JPanel p2_2=new JPanel(new BorderLayout());
		p1_2=new JPanel(new BorderLayout());
		p1_1=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		cp.add(p1);
		cp.add(p2);
		p1.setBackground(Color.BLACK);
		p2.setBackground(Color.gray);
		p1.setLayout(new BorderLayout(10,20));
		p2.setLayout(new BorderLayout(10,20));
	
		lst1=new JList(){
			public Insets getInsets(){
				return new Insets(10,10,10,10);
			}
		};
		
		
		
		
		p1.add(p1_1,"North");
		p1.add(p1_2,"Center");
		
		p1_1.setLayout(new GridLayout(1,2));
		combo1=new JComboBox();//View
		p1_1.add(combo1);
		txf=new JTextField(10);
		btSearch = new JButton("검색");
		p1_1.add(txf);
		p1_1.add(btSearch);
		model=new DefaultComboBoxModel(data);//Model
		combo1.setModel(model);
		
		p1_2.add(new JScrollPane(lst1),"Center");
		lst1.setBorder(new LineBorder(Color.blue,3));
		
		bt1=new JButton("등록");
		bt2=new JButton("수정");
		bt3=new JButton("삭제");


		p2.add(p2_1,"North");
		p2.add(p2_2,"Center");
		p2_1.add(bt1);
		p2_1.add(bt2);
		p2_1.add(bt3);
		
		rlEdit=new RegisterLayoutEdit();
		p2_2.add(rlEdit);
		rlEdit.setVisible(false);
		
		rl = new RegisterLayout();
		manager = new PhoneBookManager();
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		btSearch.addActionListener(this);
		rl.complete.addActionListener(this);
		lst1.addListSelectionListener(this);
		combo1.addActionListener(this);
		
		setSize(500, 500);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object o = e.getSource();
		
		if(o == bt1)
		{
			rl.setSize(700, 700);
			rl.setVisible(true);
		}
		else if(o == rl.complete)
		{
			p = new Person();
			
			String imageName = rl.imageName;
			String name = rl.tfName.getText();
			String phoneNumber = rl.tfPhoneNumber.getText();
			String homeNumber = rl.tfHomeNumber.getText();
			String email = rl.tfEmail.getText();
			String address = rl.tfAddress.getText();
			String birth = rl.birth.getText();
			String memo = rl.taMemo.getText();
			
			String group = rl.combo.getSelectedItem().toString();
			
			p.setImageFile(imageName);
			p.setName(name);
			p.setPhoneNumber(phoneNumber);
			p.setHomeNumber(homeNumber);
			p.setEmail(email);
			p.setAddr(address);
			p.setBirth(birth);
			p.setMemo(memo);
			p.setGroup(group);
			
			manager.InputData(p);
			lst1.setListData(manager.myPerson);
			rl.dispose();
		}
		
		else if(o == bt2)
		{
			Person p = new Person();
			p.setName(rlEdit.tfName.getText());
			p.setPhoneNumber(rlEdit.tfPhoneNumber.getText());
			p.setHomeNumber(rlEdit.tfHomeNumber.getText());
			p.setAddr(rlEdit.tfAddress.getText());
			p.setEmail(rlEdit.tfEmail.getText());
			p.setBirth(rlEdit.birth.getText());
			p.setMemo(rlEdit.taMemo.getText());
			
			p.setGroup(rlEdit.combo.getSelectedItem().toString());
			
			manager.myPerson.add(index, p);
			manager.delteData(index+1);
			lst1.setListData(manager.myPerson);
		}
		
		else if(o == bt3)
		{
			manager.delteData(index);
			lst1.setListData(manager.myPerson);
			rlEdit.setVisible(false);
		}
		
		else if(o == btSearch)
		{
			String name = txf.getText().trim();
			
			if(name != null)
			{
				int search = manager.searchData(name);
			
				if(search == -1)
					JOptionPane.showMessageDialog(this, "찾으시는 데이터가 없습니다");
				else
				{
					Person p =manager.myPerson.get(search);
					
					Vector<Person> ps = new Vector<>();
					ps.add(p);
					lst1.setListData(ps);
				}
			}
			else if(name.length()==0)
			{
				JOptionPane.showMessageDialog(this, "찾으실 이름을 입력해주세요");
			}
		}
		
		else if(o == combo1)
		{
			String z = combo1.getSelectedItem().toString();
			Vector<Person> v = new Vector<>();
			//setTitle("z : " + z);
			
			for(int i = 0; i < manager.myPerson.size(); i++)
			{
				if(z.compareTo(manager.myPerson.get(i).getGroup())==0)
				{
					//setTitle(manager.myPerson.get(i).getGroup() + i);
					Person p = manager.myPerson.get(i);
					v.add(p);
					lst1.setListData(v);
				}
				
				else if(z.compareTo("전체") == 0)
				{
					lst1.setListData(manager.myPerson);
				}
			}
		}
		
	}///////actionperformed()------------
	
	public void valueChanged(ListSelectionEvent e){
		if(e.getSource()==lst1 && e.getValueIsAdjusting())
		{
			Person str = (Person)lst1.getSelectedValue();
			JLabel lb = new JLabel();
			this.rlEdit.setVisible(true);
			
			rlEdit.tfName.setText(str.getName());
			rlEdit.tfPhoneNumber.setText(str.getPhoneNumber());
			rlEdit.tfHomeNumber.setText(str.getHomeNumber());
			rlEdit.tfEmail.setText(str.getEmail());
			rlEdit.birth.setText(str.getBirth());
			rlEdit.taMemo.setText(str.getMemo());
			rlEdit.tfAddress.setText(str.getAddr());
			
			if(str.getGroup().compareTo("가족") == 0)
				rlEdit.combo.setSelectedIndex(0);
			else if(str.getGroup().compareTo("친구") == 0)
				rlEdit.combo.setSelectedIndex(1);
			else if(str.getGroup().compareTo("직장") == 0)
				rlEdit.combo.setSelectedIndex(2);
			
			
			index = lst1.getSelectedIndex();
		}
	}
}
