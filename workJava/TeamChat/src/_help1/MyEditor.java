package _help1;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyEditor extends JFrame {

	JSplitPane sp;
	JTextField tfDir;
	JTextArea ta;
	JList<String> lst;
	JComboBox<String> comboFont, comboSize;
	JToolBar bar;
	JButton btNew, btSave;
	public MyEditor() {
		super("::MyEditor::");
		Container cp=getContentPane();
		sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		cp.add(sp,"Center");
		JPanel p1=new JPanel(new BorderLayout());
		JPanel p2=new JPanel(new BorderLayout());
		sp.add(p1);
		sp.add(p2);
		sp.setOneTouchExpandable(true);//����ġ Ȯ�� ���
		sp.setDividerLocation(150);//������ ��ġ ����
		
		tfDir=new JTextField();
		p1.add(tfDir,"North");
		tfDir.setBorder(new TitledBorder("���丮��"));
		
		lst=new JList<String>();
		p1.add(new JScrollPane(lst),"Center");
		
		ta=new JTextArea();
		p2.add(new JScrollPane(ta),"Center");
		bar=new JToolBar(JToolBar.HORIZONTAL);
		p2.add(bar,"North");
		btNew=new JButton("New");
		btSave=new JButton("Save");
		bar.add(btNew);
		bar.add(btSave);
		//�ý����� ��ü ������
		GraphicsEnvironment ge
		=GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts=ge.getAvailableFontFamilyNames();
		
		comboFont=new JComboBox<String>(fonts);//View
		bar.add(comboFont);
		//m27-994-508
		
		String[] size={"10","12","14","20","26","30"};
		comboSize=new JComboBox<String>(size);
		bar.add(comboSize);
		
		
		bar.add(Box.createHorizontalGlue());
		bar.add(new JButton("Help"));
		
		//������ ����
		MyEditorEventHandler my
				=new MyEditorEventHandler(this);
		
		tfDir.addActionListener(my);
		btNew.addActionListener(my);
		btSave.addActionListener(my);
		lst.addListSelectionListener(my);

		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------------

	public static void main(String[] args) {
		new MyEditor();
	}

}
