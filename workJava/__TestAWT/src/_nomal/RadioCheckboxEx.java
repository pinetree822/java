package _nomal;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Panel;

public class RadioCheckboxEx {

	public static void main(String[] args) {
		
		// ������ ����
		Frame f = new Frame("������ üũ�ڽ� �׽�Ʈ"); 
		Panel p = new Panel();// �г� ����
		
		// üũ�ڽ� �׷�
		CheckboxGroup group = new CheckboxGroup();

		// ������ư üũ�ڽ�
		Checkbox radio1 = new Checkbox("����", group, false);
		Checkbox radio2 = new Checkbox("��������", group, false);
		Checkbox radio3 = new Checkbox("����", group, true);

		// �гο� ������ư ���̱�
		p.add(radio1);
		p.add(radio2);
		p.add(radio3);
		
		f.add(p);// �����ӿ� �г� ���̱�
		f.setSize(300, 100);// ũ�� ����
		f.setVisible(true);// �����ӻ���(���̱�)
		
	}//main
	
}// class RadioCheckboxEx
