import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class saveHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		PhoneManager manager=PhoneManager.createManagerInst();
		manager.saveObject(); //파일저장
	}
}
