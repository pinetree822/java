
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



	public View_1(View_Box win) {					// View_1 생성자의 인자로 온 Win_Box win
		this.win = win;									// View_Box 객체를 View_1 JPanel의 win 변수에 저장
		win.setTitle("당산동맛집-손님메인화면(View_1)");	// View_Box 객체에서 전체레이아웃의 제목 변경		
		setLayout(null);									// View_1 객체 JPanel내 레이아웃 제거후 초기화
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



	
	// View_Box win 의 change() 함수에 패널교환 대상 문자열"view_2" 을 전달한다.
	class MyActionListener implements ActionListener {	// 리스너의 ActionListener를 구현한 MyActionListener핸들러 정의 
		@Override
		public void actionPerformed(ActionEvent e) { 		// ActionListener에서 이벤트 발생하면 자동호출되는 ActionEvent 인자값을 갖는 actionPerformed함수
			Object o=e.getSource(); 							// ActionEvent o에 대한 getSource()으로 부터 Object o에 값을 할당한다.
			if(o==jB1){											// 관리자화면 버튼 									//win.setTitle("당산동맛집-관리자메인화면(View_2)");	// View_Box 객체인 win에서 Frame 제목을 바꾼다.
				win.change("view_2");							// 패널을 교체하기 위해서 View_Box Frame win 의 change함수에 "view_2"패널명(관리자메인화면)을 전달한다.
			} else if(o==jB2){ 									// 로그인화면 버튼
				win.change("view_1_1");
			}
		} // public void actionPerformed(ActionEvent e)
	}// class MyActionListener implements ActionListener	
	
	
}// public class View_1 extends JPanel 
