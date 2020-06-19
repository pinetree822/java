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


// Frame ���� ����
// BoardLayout : �� �� �� �� ����
// Panel 


public class TestNote extends Frame implements ActionListener {

	// 1�ܰ� ���־�������Ʈ ��ü = ���������� ����
	Panel pan = new Panel();
	Label info = new Label(" �Է� ");
	TextField tf = new TextField();
	Button btnsend = new Button(" ���� ");
	Button btnexit = new Button(" Exit ");
	TextArea ta = new TextArea();
	Font font = new Font("Comic Sans MS", Font.BOLD, 80);
	
	
	public TestNote() {
		
		// 2�ܰ� �ǳڿ� info, tf, bs, be�� �߰� = add()
		this.pan.add(info);
		this.pan.add(tf);
		this.pan.add(btnsend);
		this.pan.add(btnexit);
		this.pan.add(ta);
		
		// 3�ܰ� TestNoteȭ�� ���������߾� add()
		// this.ad("East", "E��");
//		this.add("East", new Label("��"));
//		this.add("West", new Label("��"));
//		this.add("South", new Label("��"));
//		this.add("North", new Label("��"));
		this.add("Center", ta);
		this.add("South", pan);
		
		this.setTitle("�ʰ��� ä��");
		this.setBackground(Color.yellow);
		this.setBounds(600, 200, 400, 500);
		this.setVisible(true);
		this.ta.setFont(new Font("Gulim", Font.PLAIN, 20));
		
		// 5�ܰ� �����ʸ� ���� --> �������ڵ鷯 ListenerHandler
		// �Ǿ�
		this.btnsend.addActionListener(this);
		

		this.btnexit.addActionListener(this);
//		this.btnexit.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				
//			}// actionPerformed()
//			
//		});// this.btnexit.addActionListener()
		
		
		// ������ ����
        this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });// this.btnexit.addWindowListener()
		
	}// TestNote()

	// ����ڰ� ���� ����
	public void sendMessage(){
		String data = this.tf.getText();
		ta.append(data + "\n");
		tf.setText("");
		tf.requestFocus();
	}// sendMessage()
	
	// ����ڰ� ���� ����
	public void sendExit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(1);
	}// sendExit()
	
	
	// ��ư Ŭ��, �Է¶�enter, �޴�Ŭ��, �̹��� Ŭ��
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
		new TestNote();// ��ü�̸� = anonymous
	}// main()


	
	
}// class TestNote
