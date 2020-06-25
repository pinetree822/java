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
	String[] data = {"가족", "친구", "직장"};

	public RegisterLayout() {
		super("::RegisterLayout::");
		//p1.setBorder(new LineBorder(Color.CYAN,3));
		Container cp=getContentPane();
		
		pNorth = new JPanel(new BorderLayout());
		pCenter = new JPanel(new GridLayout(0,1,5,5)){
			@Override
			public Insets getInsets()
			{
				return new Insets(10,50,10,50);  //위 왼 아 오
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
	
		tfName.setBorder(new TitledBorder("이름"));
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
		
		
		////////////////////////////CENTER영역///////////////////////////////
		
		tfPhoneNumber = new JTextField(15);
		tfPhoneNumber.setBorder(new TitledBorder("휴대전화"));
		tfHomeNumber = new JTextField(15);
		tfHomeNumber.setBorder(new TitledBorder("자 택"));
		tfEmail = new JTextField(15);
		tfEmail.setBorder(new TitledBorder("E-mail"));
		tfAddress = new JTextField(15);
		tfAddress.setBorder(new TitledBorder("주소"));
		birth = new JLabel("생년월일을 선택해주세요");
		birth.setBorder(new TitledBorder("생일"));
		taMemo = new JTextArea();
		taMemo.setBorder(new TitledBorder("메모"));
		
		pCenter.add(tfPhoneNumber);
		pCenter.add(tfHomeNumber);
		pCenter.add(tfEmail);
		pCenter.add(tfAddress);
		pCenter.add(birth);
		pCenter.add(taMemo);
		
		complete = new JButton("완료");
		cancel = new JButton("취소");
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
		
		bc = new BirthChoice(":::생년월일을 선택해주세요", "생년월일", "등록");
	
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
		

		}///생성자
	
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

