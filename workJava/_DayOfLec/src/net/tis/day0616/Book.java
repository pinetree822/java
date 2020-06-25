package net.tis.day0616;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



// Component > Container > Window > Frame > JFrame
public class Book extends Frame {

	private int pwd;
	private String title;
	private Button btnSave;
	
	
	public Book() {
		this.title = "Book 기본 생성자";
		System.out.println(title);
	}// Book()
	
	
	public void sendMessage() {

		System.out.println("sendMessage 메소드");
		this.setTitle(title);
		this.setLayout(getLayout());
//		this.sendMessage();
		this.pwd=1234;
		this.setSize(400, 500);
		this.setBounds(300, 350, 400, 400);
		this.setBackground(Color.YELLOW);
		this.setVisible(true);
		
		// 윈도우 종료
        this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });
		
//		int a=3,b=4,hap=0,gob=0;
//		hap=a+b;
//		gob=a*b;
//		
//		System.out.println(hap);
//		System.out.println(gob);
//		System.out.println(this.pwd);
		
	}// sendMessage()
	
	public static void main(String[] args) {
		
		Book bk = new Book();
		bk.sendMessage();
		
	}// main()
	
	
}// class Book
