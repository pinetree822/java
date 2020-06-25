package main_design2;
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

public class main1 extends JFrame {

	private JPanel mPane;
	private JTextField txt1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main1 frame = new main1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\uBAA8\uC74C-\uC0AC\uC9C4\\0e838bf6a00b4c8fa265690e3e441402.jpg"));
		setTitle("\uC74C\uC2DD\uC810\uAC80\uC0C9\uD504\uB85C\uC81D\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 511);
		mPane = new JPanel();
		mPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mPane);
		mPane.setLayout(new BorderLayout(0, 0));
		
		JPanel sPane1 = new JPanel();
		FlowLayout fl_sPane1 = (FlowLayout) sPane1.getLayout();
		fl_sPane1.setAlignment(FlowLayout.RIGHT);
		mPane.add(sPane1, BorderLayout.NORTH);
		
		JButton btn1 = new JButton("\uB85C\uADF8\uC778");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("\uBA54\uC778\uD654\uBA74");
		sPane1.add(lblNewLabel);
		
		txt1 = new JTextField();
		txt1.setToolTipText("");
		sPane1.add(txt1);
		txt1.setColumns(15);
		
		JButton btn2 = new JButton("\uAC80\uC0C9");
		sPane1.add(btn2);
		sPane1.add(btn1);
		
		JPanel sPane2 = new JPanel();
		FlowLayout fl_sPane2 = (FlowLayout) sPane2.getLayout();
		fl_sPane2.setAlignment(FlowLayout.LEFT);
		mPane.add(sPane2, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"번호", "음식점이름", "전화번호", "평점"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC774\uB984", "\uC885\uB958", "\uC804\uD654"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(62);
		table.getColumnModel().getColumn(1).setPreferredWidth(380);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		sPane2.add(table);
		
		JPanel sPane3 = new JPanel();
		mPane.add(sPane3, BorderLayout.SOUTH);
		
		JButton btn4 = new JButton("\uC774\uC804");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btn3 = new JButton("\uCC98\uC74C");
		sPane3.add(btn3);
		sPane3.add(btn4);
		
		JButton btn5 = new JButton("\uB2E4\uC74C");
		sPane3.add(btn5);
		
		JButton btn6 = new JButton("\uB05D");
		sPane3.add(btn6);
	}

}
