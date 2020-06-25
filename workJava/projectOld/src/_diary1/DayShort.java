package _diary1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DayShort extends JPanel implements MouseListener {
	
	private JLabel lbDay, lbMemo_1, lbMemo_2, lbMemo_3;	
	private Color defaultColor = Color.white;
	private Color changeColor = new Color(255, 224, 150);
	
	public DayShort(String day, Color color, String schedul_1, String schedul_2, String schedul_3) {		
		this.setLayout(new GridLayout(4, 1, 1, 1));
		this.setBackground(defaultColor);
		this.addMouseListener(this);
		
		lbDay = new JLabel(day, JLabel.LEFT);
		lbDay.setForeground(color);
		lbDay.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		
		lbMemo_1 = new JLabel(schedul_1, JLabel.LEFT);
		lbMemo_2 = new JLabel(schedul_2, JLabel.LEFT);
		lbMemo_3 = new JLabel(schedul_3, JLabel.LEFT);
		
		this.add(lbDay);
		this.add(lbMemo_1);
		this.add(lbMemo_2);
		this.add(lbMemo_3);		
	}	

	@Override
	public Insets getInsets() {
		return new Insets(5, 5, 5, 5);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Container pan = this.getParent();		//�θ� �����̳ʸ� ������
		Component[] comp = pan.getComponents();	//�θ� �����̳� �ȿ� �ִ� ������Ʈ�� ������
		for(int i = 0; i < comp.length; i++){	//������ ������Ʈ ��ü�� Ȯ��(���� �޷��� ��,��,ȭ,��,��,��,�� ���ĺ��� ����)
			comp[i].setBackground(defaultColor);//������Ʈ�� ������ �ٲ�
		}
		
		this.setBackground(changeColor);	//������ ������Ʈ�� ������ �ٲ�
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	

	public String getDay() {
		return lbDay.getText().trim();
	}
	
}
