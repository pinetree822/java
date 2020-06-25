import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BoxHandler implements ItemListener
{
	JTextField companyText;
	JTextField univText;
	JRadioButton companyRadio;
	JRadioButton univRadio;
	JRadioButton generalRadio;
	
	public BoxHandler(JRadioButton radio1, JRadioButton radio2, JRadioButton radio3,
			JTextField t1, JTextField t2)
	{
		generalRadio=radio1;
		companyRadio=radio2;
		univRadio=radio3;
		companyText=t1;
		univText=t2;
		//text3=t3;
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getStateChange()==ItemEvent.SELECTED)
		{
			if(e.getSource() == generalRadio){
				companyText.setEditable(false);
				univText.setEditable(false);
			}
			else if(e.getSource() == companyRadio){
				companyText.setEditable(true);
				univText.setEditable(false);
			}
			else if(e.getSource() == univRadio){
				companyText.setEditable(false);
				univText.setEditable(true);
			}
		}
	}
	
}