package s4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private login frame;
	private JPanel log_main;
	private JTextField tf_log;
	private JTextField tf_pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("\uB2F9\uC0B0\uB3D9\uB9DB\uC9D1-\uB85C\uADF8\uC778\uD654\uBA74");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 274);
		
		
		
		log_main = new JPanel();
		log_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(log_main);
		log_main.setLayout(null);

		
		
		JButton bt_login_submit = new JButton("\uD68C\uC6D0\uC811\uC18D");
		JButton bt_login_cancel = new JButton("\uCDE8\uC18C");
		JButton bt_login_out = new JButton("\uD68C\uC6D0\uC811\uC18D");// 로그아웃 테스트 하기 위해 만든 객체

		bt_login_submit.setBounds(53, 154, 97, 23);
		bt_login_cancel.setBounds(175, 154, 97, 23);
		//bt_login_out.setBounds(175, 154, 97, 23);
		log_main.add(bt_login_submit);
		log_main.add(bt_login_cancel);
		//log_main.add(bt_login_out);
		

		bt_login_submit.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Object obj=e.getSource();
				// 아이디와 비밀번호가 맞으면 
		        JOptionPane.showMessageDialog(null,"로그인 되었습니다.");// 취소확인 버튼
		        
		        // 아이디와 비밀번호가 틀리면
		        
		        // 창 닫기
				
			}//public void actionPerformed(ActionEvent e)
			
		});
		
		bt_login_cancel.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				// http://programmingsummaries.tistory.com/61
				//jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Object obj=e.getSource();
		        // 취소 버튼
		        JOptionPane.showMessageDialog(frame,"로그인취소가 되었습니다.","로그인취소", JOptionPane.INFORMATION_MESSAGE, null);
		        //frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		        ///System.exit(0);// 창 닫기 frame.EXIT_ON_CLOSE, 
		        // frame.setVisible(false);
		        // frame.DISPOSE_ON_CLOSE
		        
			}//public void actionPerformed(ActionEvent e)
			
		});
		
		bt_login_out.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {

				Object obj=e.getSource();
		        JOptionPane.showMessageDialog(null,"로그아웃 되었습니다.");// 취소확인 버튼 
		        // 창 닫기
		        // 메뉴이동
		        /*
				if(obj==bt_login_submit){
				} else if(obj==bt_login_cancel){
				} else if(obj==bt_login_out){
				}
				*/
				
			}//public void actionPerformed(ActionEvent e)
			
		});		
		
		
		tf_log = new JTextField();
		tf_log.setBounds(156, 56, 116, 21);
		log_main.add(tf_log);
		tf_log.setColumns(10);
		
		tf_pwd = new JTextField();
		tf_pwd.setBounds(156, 99, 116, 21);
		log_main.add(tf_pwd);
		tf_pwd.setColumns(10);
		
		JLabel lbl_log = new JLabel("\uC544\uC774\uB514");
		lbl_log.setBounds(74, 59, 57, 15);
		log_main.add(lbl_log);
		
		JLabel lbl_pwd = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_pwd.setBounds(74, 102, 57, 15);
		log_main.add(lbl_pwd);
	}
}


/*
	//ConfirmDialog띄워서 "종료할까요?"
	//"예","아니오" 버튼만 나오도록
	//"예"를 누르면 종료시키기
	int yn=JOptionPane.showConfirmDialog(b4,// 상위컴포넌트
			"종료할까요?","확인",				// 설명텍스트, 확인버튼
			JOptionPane.YES_NO_OPTION);		// 버튼종류 옵션
	setTitle("yn="+yn);						// 타이틀내용
	if(yn==JOptionPane.YES_OPTION){			// 질문에 대한 값(yn)에 대한게 yes_option이면
		System.exit(0);
	}
}

// Output
JOptionPane.showMessageDialog(null,
    hour + "시 " + min + "분이 이루는 내각: " + innerDegree + '\n' +
    "시침의 각: " + hourDegree + '\n' +
    "분침의 각: " + minDegree);

*/