package backup;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


// Frame 부착 순서
// BoardLayout : 동 서 남 북 센터
// Panel 


public class TestNote extends Frame implements ActionListener {

	// 1단계 비주얼컴포넌트 객체 = 전역변수로 선언
	Panel pan = new Panel();
	Label info = new Label(" 입력 ");
	TextField tf = new TextField();
	Button btnsend = new Button(" 전송 ");
	Button btnexit = new Button(" Exit ");
	TextArea ta = new TextArea();
	Font font = new Font("Comic Sans MS", Font.BOLD, 80);
	
	
	public TestNote() {
		
		// 2단계 판넬에 info, tf, bs, be를 추가 = add()
		this.pan.add(info);
		this.pan.add(tf);
		this.pan.add(btnsend);
		this.pan.add(btnexit);
		this.pan.add(ta);
		
		// 3단계 TestNote화면 동서남북중앙 add()
		// this.ad("East", "E동");
//		this.add("East", new Label("동"));
//		this.add("West", new Label("서"));
//		this.add("South", new Label("남"));
//		this.add("North", new Label("북"));
		this.add("Center", ta);
		this.add("South", pan);
		
		this.setTitle("초간단 채팅");
		this.setBackground(Color.yellow);
		this.setBounds(600, 200, 400, 500);
		this.setVisible(true);
		this.ta.setFont(new Font("Gulim", Font.PLAIN, 20));
		
		// 5단계 리스너를 연결 --> 리스너핸들러 ListenerHandler
		// 맨앞
		this.btnsend.addActionListener(this);
		

		this.btnexit.addActionListener(this);
//		this.btnexit.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				
//			}// actionPerformed()
//			
//		});// this.btnexit.addActionListener()
		
		
		// 윈도우 종료
        this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });// this.btnexit.addWindowListener()
		
	}// TestNote()

	// 사용자가 새로 생성
	public void sendMessage(){
		String data = this.tf.getText();
		ta.append(data + "\n");
		tf.setText("");
		tf.requestFocus();
	}// sendMessage()
	
	// 사용자가 새로 생성
	public void sendExit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(1);
	}// sendExit()
	
	
	// 버튼 클릭, 입력란enter, 메뉴클릭, 이미지 클릭
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(ob==this.tf) {
			
		}else if(ob==this.btnsend) {
			this.sendMessage();
		}else if(ob==this.btnexit) {
			this.sendExit();
		}else {
			
		}
		
	}// actionPerformed()
	
	
	
	
	public static void main(String[] args) {
		new TestNote();// 객체이름 = anonymous
	}// main()


	
	
}// class TestNote
