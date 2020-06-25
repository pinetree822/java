import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Iterator;

public class registerHandler implements ActionListener
{
	phoneInfo info=null;
	JTextField name;
	JTextField phone;
	JTextField company;
	JTextField univ;
	JRadioButton b1;
	JRadioButton b2;
	JRadioButton b3;
	JTextArea a1;
	String iName;
	String iPhone;
	String iCompany;
	String iUniv;
	
	public registerHandler(JRadioButton b1, JRadioButton b2, JRadioButton b3, 
			JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextArea a1)
	{
		this.b1=b1;
		this.b2=b2;
		this.b3=b3;
		this.a1=a1;
		name=t1;
		phone=t2;
		company=t3;
		univ=t4;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		PhoneManager manager=PhoneManager.createManagerInst();
		boolean isAdded=false;
		
		if(b1.isSelected()){//일반버튼 선택되어졌을때
			iName=name.getText();
			iPhone=phone.getText();
			//iUniv=univ.getText();
			isAdded=manager.personalData.add(new phoneInfo(iName, iPhone));
		}
		else if(b2.isSelected()){ //회사버튼선택
			iName=name.getText();
			iPhone=phone.getText();
			iCompany=company.getText();
			isAdded=manager.personalData.add(new companyInfo(iName, iPhone, iCompany));
		}
		else if(b3.isSelected()){ //학교버튼선택
			iName=name.getText();
			iPhone=phone.getText();
			iUniv=univ.getText();
			isAdded=manager.personalData.add(new univInfo(iName, iPhone, iUniv));
		}
		
		if(isAdded==true){
			a1.setText("");
			a1.append("데이터 입력이 완료되었습니다.");
		}
		else{
			a1.setText("");
			a1.append("이미 저장된 데이터 입니다.");
		}
		
		//manager.saveObject();
	}
}













