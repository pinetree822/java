package _diary1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DayDetail extends JPanel/* implements MouseListener */{
	
	private JLabel lbTime;
	private JTextArea lbMemo;
	//private Color defaultColor = Color.white;
	//private Color changeColor = new Color(188, 27, 96);
	private String index;

	public DayDetail(String time, String memo) {
		this.setLayout(new BorderLayout(2, 2));
		//this.setBackground(defaultColor);
		//this.addMouseListener(this);
		
		lbTime = new JLabel(time, JLabel.LEFT);
		lbTime.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
		
		lbMemo = new JTextArea(memo, 1, 15);
		lbMemo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
		
		this.add(lbTime, "North");
		this.add(lbMemo, "Center");
	}

	@Override
	public Insets getInsets() {
		return new Insets(3, 3, 3, 3);
	}

	public String getIndex() {
		return index;
	}

	public String getTime() {
		return lbTime.getText();
	}

	public String getMemo() {
		return lbMemo.getText();
	}
	
	
	
	/*
	@Override
	public void mouseClicked(MouseEvent arg0) {		
		Container pan = this.getParent();		//�θ� �����̳ʸ� ������
		Component[] comp = pan.getComponents();	//�θ� �����̳� �ȿ� �ִ� ������Ʈ�� ������
		for(int i = 0; i < comp.length; i++){	//������ ������Ʈ ��ü�� Ȯ��
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
	public void mouseReleased(MouseEvent arg0) {}*/	
}
