package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class ListChangeEx extends JFrame{

	private JTextField tf = new JTextField(10);
	private Vector<String> v = new Vector<String>();
	private JList<String> nameList = new JList<String>();
	
	
	
	public ListChangeEx() {
		
		setTitle("리스트 변경 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름 입력 후 <Enter> 키"));
		c.add(tf);
		
		v.add("황기태");
		v.add("이재문");
		
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellWidth(100);
		
		c.add(new JScrollPane(nameList));// JScrollPane에 nameList를 넣고 컨테이너에 추가
		
		nameList.setListData(v);
		setSize(300, 300);
		setVisible(true);
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText());
				t.setText("");
				nameList.setListData(v);
			}// actionPerformed()
		});
		
		
		
		
		
	}// ListChangeEx()
	
	
	public static void main(String[] args) {
		new ListChangeEx();
	}// main()
	
}// class ListChangeEx
