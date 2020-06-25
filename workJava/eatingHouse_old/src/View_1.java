
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
import project1.View_Box;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class View_1 extends JPanel {

	private JPanel mPane;
	private JTextField txt1;



	public View_1(View_Box win) {					// View_1 �������� ���ڷ� �� Win_Box win
		this.win = win;									// View_Box ��ü�� View_1 JPanel�� win ������ ����
		win.setTitle("��굿����-�մԸ���ȭ��(View_1)");	// View_Box ��ü���� ��ü���̾ƿ��� ���� ����		
		setLayout(null);									// View_1 ��ü JPanel�� ���̾ƿ� ������ �ʱ�ȭ
		setBounds(100, 100, 800, 600);

		
		mPane = new JPanel();
		mPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mPane);
		mPane.setLayout(new BorderLayout(0, 0));
		
		JPanel sPanel_1 = new JPanel();
		mPane.add(sPanel_1, BorderLayout.NORTH);
		sPanel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel sPanel_1_1 = new JPanel();
		sPanel_1.add(sPanel_1_1, BorderLayout.NORTH);
		FlowLayout fl_sPanel_1_1 = (FlowLayout) sPanel_1_1.getLayout();
		fl_sPanel_1_1.setAlignment(FlowLayout.RIGHT);
		
		JButton btn1 = new JButton("\uB85C\uADF8\uC778");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lbl1 = new JLabel("\uC190\uB2D8 \uBA54\uC778\uD654\uBA74");
		sPanel_1_1.add(lbl1);
		
		txt1 = new JTextField();
		txt1.setToolTipText("");
		sPanel_1_1.add(txt1);
		txt1.setColumns(15);
		
		JButton btn2 = new JButton("\uAC80\uC0C9");
		sPanel_1_1.add(btn2);
		sPanel_1_1.add(btn1);
		
		JPanel sPanel_1_2 = new JPanel();
		sPanel_1.add(sPanel_1_2, BorderLayout.SOUTH);
		sPanel_1_2.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton menu1 = new JButton("\uD55C\uC2DD");
		sPanel_1_2.add(menu1);
		
		JButton menu2 = new JButton("\uC591\uC2DD");
		sPanel_1_2.add(menu2);
		
		JButton menu3 = new JButton("\uC911\uC2DD");
		sPanel_1_2.add(menu3);
		
		JButton menu4 = new JButton("\uC77C\uC2DD");
		menu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		sPanel_1_2.add(menu4);
		
		JButton menu5 = new JButton("\uAE30\uD0C0");
		sPanel_1_2.add(menu5);
		
		JPanel sPanel_2 = new JPanel();
		mPane.add(sPanel_2, BorderLayout.CENTER);
		sPanel_2.setLayout(new BorderLayout(0, 0));
		///////////////////////////////////////////////////////////////////////////
		JPanel sPanel_2_1 = new JPanel(){
			public Insets getInsets(){
				return new Insets(100,0,0,0);
			}
		};
		sPanel_2.add(sPanel_2_1, BorderLayout.NORTH);
		
		JButton list1 = new JButton("1 \uC0C1\uC810\uC774\uB984 | \uC804\uD654\uBC88\uD638 | \uD3C9\uC810");
		list1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		list1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton list2 = new JButton("2 \uC0C1\uC810\uC774\uB984 | \uC804\uD654\uBC88\uD638 | \uD3C9\uC810");
		list2.setHorizontalAlignment(SwingConstants.LEFT);
		sPanel_2_1.setLayout(new GridLayout(0, 1, 800, 0));
		sPanel_2_1.add(list1);
		sPanel_2_1.add(list2);
		
		JButton list3 = new JButton("3 \uC0C1\uC810\uC774\uB984 | \uC804\uD654\uBC88\uD638 | \uD3C9\uC810");
		list3.setHorizontalAlignment(SwingConstants.LEFT);
		sPanel_2_1.add(list3);
		
		JButton list4 = new JButton("4 \uC0C1\uC810\uC774\uB984 | \uC804\uD654\uBC88\uD638 | \uD3C9\uC810");
		list4.setHorizontalAlignment(SwingConstants.LEFT);
		sPanel_2_1.add(list4);
		
		JPanel sPanel_2_2 = new JPanel();
		sPanel_2.add(sPanel_2_2, BorderLayout.SOUTH);
		
		JButton lbtn2 = new JButton("\uC774\uC804");
		lbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton lbtn1 = new JButton("\uCC98\uC74C");
		sPanel_2_2.add(lbtn1);
		sPanel_2_2.add(lbtn2);
		
		JButton lbtn3 = new JButton("\uB2E4\uC74C");
		sPanel_2_2.add(lbtn3);
		
		JButton lbtn4 = new JButton("\uB05D");
		sPanel_2_2.add(lbtn4);
	}//	public View_1(View_Box win)



	
	// View_Box win �� change() �Լ��� �гα�ȯ ��� ���ڿ�"view_2" �� �����Ѵ�.
	class MyActionListener implements ActionListener {	// �������� ActionListener�� ������ MyActionListener�ڵ鷯 ���� 
		@Override
		public void actionPerformed(ActionEvent e) { 		// ActionListener���� �̺�Ʈ �߻��ϸ� �ڵ�ȣ��Ǵ� ActionEvent ���ڰ��� ���� actionPerformed�Լ�
			Object o=e.getSource(); 							// ActionEvent o�� ���� getSource()���� ���� Object o�� ���� �Ҵ��Ѵ�.
			if(o==jB1){											// ������ȭ�� ��ư 									//win.setTitle("��굿����-�����ڸ���ȭ��(View_2)");	// View_Box ��ü�� win���� Frame ������ �ٲ۴�.
				win.change("view_2");							// �г��� ��ü�ϱ� ���ؼ� View_Box Frame win �� change�Լ��� "view_2"�гθ�(�����ڸ���ȭ��)�� �����Ѵ�.
			} else if(o==jB2){ 									// �α���ȭ�� ��ư
				win.change("view_1_1");
			}
		} // public void actionPerformed(ActionEvent e)
	}// class MyActionListener implements ActionListener	
	
	
}// public class View_1 extends JPanel 
