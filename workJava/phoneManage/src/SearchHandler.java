import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchHandler implements ActionListener
{
	JTextField t1;
	JTextArea t2;
	
	public SearchHandler(JTextField t1, JTextArea t2)
	{
		this.t1=t1;
		this.t2=t2;
	}
	public void actionPerformed(ActionEvent e)
	{
		PhoneManager manager=PhoneManager.createManagerInst();
		String name=t1.getText();
		String info=manager.searchName(name);
		
		if(info==null){
			t2.setText("");
			t2.append("찾는 데이터 없음");
		}
		else{
			t2.setText("");
			t2.append(info);
		}
	}
}
