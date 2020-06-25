package cardDesign;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class cardTest1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cardTest1 frame = new cardTest1();
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
	public cardTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, "name_15904663512650");
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("\uC74C\uC2DD\uC810\uC18C\uAC1C", null, tabbedPane_1, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC5C5\uCCB4\uBA85 : \uB0AD\uD48D");
		lblNewLabel.setBounds(378, 60, 291, 15);
		panel_3.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label = new JLabel("\uC5C5\uC885 - \uD55C\uC2DD\uB2F9");
		label.setBounds(378, 148, 291, 15);
		panel_3.add(label);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_1 = new JLabel("\uC804\uD654\uBC88\uD638 : 02-2631-8025");
		label_1.setBounds(378, 236, 291, 15);
		panel_3.add(label_1);
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_2 = new JLabel("\uC8FC\uC18C - \uC11C\uC6B8 \uC601\uB4F1\uD3EC\uAD6C \uC591\uD3C9\uB3D9 37");
		label_2.setBounds(378, 324, 291, 15);
		panel_3.add(label_2);
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_3 = new JLabel("\uD3C9\uC810 - \u2605\u2605\u2605\u2605\u2606");
		label_3.setBounds(378, 412, 291, 15);
		panel_3.add(label_3);
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_4 = new JLabel(new ImageIcon("E:\\java\\_lecture\\study\\eclipse_home_java_workspace\\eatingHouse\\images\\\uAC04\uD310.PNG"));
		label_4.setPreferredSize(new Dimension(400, 200));/// ΩŒ¿Ã¡Ó ∏¬√ﬂ±‚
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setForeground(Color.BLACK);
		label_4.setBackground(Color.RED);
		label_4.setBounds(35, 38, 331, 443);
		panel_3.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(364, 285, 2, 2);
		panel_3.add(scrollPane);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addTab("\uBA54\uB274", null, tabbedPane_2, null);
		
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("windowBorder"));
		panel.setBackground(SystemColor.menu);
		tabbedPane_2.addTab("\uC81C\uC721\uBCF6\uC74C", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblHead1 = new JLabel("\uB0AD\uD48D");
		lblHead1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead1.setForeground(UIManager.getColor("FormattedTextField.selectionForeground"));
		lblHead1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		lblHead1.setBounds(35, 44, 327, 127);
		panel.add(lblHead1);
		
		JLabel lblHead2 = new JLabel("\uB0AD\uD48D");
		lblHead2.setForeground(UIManager.getColor("scrollbar"));
		lblHead2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		lblHead2.setBounds(35, 44, 328, 128);
		panel.add(lblHead2);
		
		JLabel lblMenu1 = new JLabel("\uC81C\uC721\uBCF6\uC74C");
		lblMenu1.setForeground(UIManager.getColor("ToolBar.highlight"));
		lblMenu1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 32));
		lblMenu1.setBounds(35, 44, 327, 395);
		panel.add(lblMenu1);
		
		JLabel lblMenu2 = new JLabel("\uC81C\uC721\uBCF6\uC74C");
		lblMenu2.setForeground(UIManager.getColor("menuText"));
		lblMenu2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 32));
		lblMenu2.setBounds(35, 44, 327, 397);
		panel.add(lblMenu2);
		
		JLabel lblImg = new JLabel(new ImageIcon("E:\\java\\_lecture\\study\\eclipse_home_java_workspace\\eatingHouse\\images\\\uC81C\uC721\uBCF6\uC74C.PNG"));
		lblImg.setBounds(35, 44, 329, 395);
		lblImg.setBackground(Color.RED);
		lblImg.setForeground(Color.BLACK);
		panel.add(lblImg);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(449, 203, 135, 40);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_2.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_2.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("\uCC3E\uC544\uC624\uC2DC\uB294\uAE38", null, tabbedPane_3, null);
	}
}
