import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DeleteHandler implements ActionListener
{
	JTextField t1;
	JTextArea t2;
	
	public DeleteHandler(JTextField t1, JTextArea t2)
	{
		this.t1=t1;
		this.t2=t2;
	}
	public void actionPerformed(ActionEvent e)
	{
		PhoneManager manager=PhoneManager.createManagerInst();
		String name=t1.getText();
		boolean info=manager.delName(name);
		
		if(info==false){
			t2.setText("");
			t2.append("�����Ͱ� �������� �ʽ��ϴ�.");
		}
		else{
			t2.setText("");
			t2.append("�����Ͱ� �����Ǿ����ϴ�.");
		}
	}
}