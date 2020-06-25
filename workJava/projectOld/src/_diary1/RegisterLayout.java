package _diary1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterLayout extends JFrame implements ActionListener{
	
	JPanel pNorth, pCenter, pSouth, pNorth_west, pNorth_center, pNameAndGroup;
	JLabel photo,birth;
	JTextField tfName, tfPhoneNumber, tfHomeNumber, tfEmail, tfAddress;
	JTextArea taMemo;
	JList groupList;
	JButton complete, cancel;
	JComboBox combo;
	BirthChoice bc;
	String birthInfo,year,month,day;
	String imageName;
	
	DefaultComboBoxModel<String> model;
	String[] data = {"����", "ģ��", "����"};

	public RegisterLayout() {
		super("::RegisterLayout::");
		//p1.setBorder(new LineBorder(Color.CYAN,3));
		Container cp=getContentPane();
		
		pNorth = new JPanel(new BorderLayout());
		pCenter = new JPanel(new GridLayout(0,1,5,5)){
			@Override
			public Insets getInsets()
			{
				return new Insets(10,50,10,50);  //�� �� �� ��
			}
		};
		/*pCenter = new MyPanel(10,10,10,10);
		pCenter.setLayout(new GridLayout(10,10,10,10));*/
		pSouth = new JPanel();
		
		pNorth.setBorder(new LineBorder(Color.CYAN,3));
		pCenter.setBorder(new LineBorder(Color.BLUE,3));
		
		cp.add(pNorth,BorderLayout.NORTH);
		cp.add(pCenter,BorderLayout.CENTER);
		cp.add(pSouth,BorderLayout.SOUTH);
		
		pNorth_west = new JPanel();
		pNorth_center = new JPanel(new GridLayout(0,1,10,10));
		
		pNorth.add(pNorth_west,BorderLayout.WEST);
		pNorth.add(pNorth_center,BorderLayout.CENTER);
		
		pNorth_west.setBorder(new LineBorder(Color.BLACK,3));
		pNorth_center.setBorder(new LineBorder(Color.yellow,3));
		
		photo = new JLabel(new ImageIcon("Images/Human.png"));
		pNorth_west.add(new JScrollPane(photo));
		
		pNameAndGroup = new JPanel(new GridLayout(0,1,5,5));
		pNorth_center.add(pNameAndGroup);
		
		tfName = new JTextField(20);
	
		tfName.setBorder(new TitledBorder("�̸�"));
		pNameAndGroup.add(tfName);
		
		combo = new JComboBox();
	
		
		groupList = new JList();
		model = new DefaultComboBoxModel<String>();
		
		for(String item : data)
		{
			model.addElement(item);
		}
		pNameAndGroup.add(combo);
		combo.setModel(model);
		
		
		////////////////////////////CENTER����///////////////////////////////
		
		tfPhoneNumber = new JTextField(15);
		tfPhoneNumber.setBorder(new TitledBorder("�޴���ȭ"));
		tfHomeNumber = new JTextField(15);
		tfHomeNumber.setBorder(new TitledBorder("�� ��"));
		tfEmail = new JTextField(15);
		tfEmail.setBorder(new TitledBorder("E-mail"));
		tfAddress = new JTextField(15);
		tfAddress.setBorder(new TitledBorder("�ּ�"));
		birth = new JLabel("��������� �������ּ���");
		birth.setBorder(new TitledBorder("����"));
		taMemo = new JTextArea();
		taMemo.setBorder(new TitledBorder("�޸�"));
		
		pCenter.add(tfPhoneNumber);
		pCenter.add(tfHomeNumber);
		pCenter.add(tfEmail);
		pCenter.add(tfAddress);
		pCenter.add(birth);
		pCenter.add(taMemo);
		
		complete = new JButton("�Ϸ�");
		cancel = new JButton("���");
		pSouth.add(complete);
		pSouth.add(cancel);
		
		FileDialog fd = new FileDialog(this);
		photo.addMouseListener(new MouseAdapter(){
			
			public void mousePressed(MouseEvent e)
				{
					fd.setVisible(true);
					imageName = fd.getDirectory();
							imageName += fd.getFile();
					setTitle(imageName);
					//photo = new JLabel(new ImageIcon(imageName));
					photo.setIcon(new ImageIcon(imageName));
					photo.setPreferredSize(new Dimension(50, 50));
				}
		});
		
		bc = new BirthChoice(":::��������� �������ּ���", "�������", "���");
	
		birth.addMouseListener(new MouseAdapter(){
			
			public void mousePressed(MouseEvent e)
			{
				bc.pack();
				bc.setLocation(getWidth(),0);
				bc.setVisible(true);
				
			}
		});
		
		bc.btRegister.addActionListener(this);
		
		cancel.addActionListener(this);
		

		}///������
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object o = e.getSource();
		
		if(o == bc.btRegister)
		{
			birth.setText(bc.birthInfo);
		}
		else if(o == cancel)
		{
			dispose();
		}
	}
	
	
	public static void main(String[] args) {
		new RegisterLayout();
	}//main()---


}/////////////////////

