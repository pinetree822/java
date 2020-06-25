package _TeamView3;

import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
//import javax.swing.*;

//  쓰레드를 구현하고 JFrame을 상속한 TeamViewServer 클래스
public class TeamViewServer extends JFrame implements Runnable {
	JLabel label;				// 화상출력
	boolean running = false; 	// 쓰레드 확인
	ServerSocket socket;		// 서버소켓
	private int index = 0;		// 동기화변수// 동기화******
	
	
	public TeamViewServer(){
		
		initComponents();// 디자인모드
		setVisible(true);// 디자인모드
		 
		try {
			socket = new ServerSocket(9000);// 서버 9000포트로 연결 객체 생성
			start();	// 쓰레드 시작
			System.out.println("TeamView Thread 생성자------ index = " + index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// TeamView----------------

	
	// 디자인 initComponents();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">   
    private void initComponents() {
   	
        jPanel1 = new javax.swing.JPanel();
        vScreen = new javax.swing.JLabel();
        vHost = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TeamView");

        vScreen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        vHost.setBorder(javax.swing.BorderFactory.createTitledBorder("호스트"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vHost)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vHost, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();    	
    }
	
	
	
	
	
	// 스레드 시작(종료방지) , 채팅과 같이 구현
	private void start() {
		Thread team = new Thread(this);
		running = true;
		System.out.println("TeamView Thread start()------ index = " + index);
		team.start();
	}//start --------------
	
	
	
	
	
	@Override
	public void run() {
		while( running ) {
			try {
				
				System.out.println("TeamView Thread run() - running------ index = " + index);
				Random r = new Random(System.currentTimeMillis());
				long s = r.nextInt(100); 
				Thread.sleep(s);// 네트웍 딜레이
				
				ObjectInputStream  ois = new ObjectInputStream(socket.accept().getInputStream()); // 소켓 인풋스트림기반으로 객체스트림사용
			
				Object obj = ois.readObject();						// 객체별로 읽어낸다.
				if( obj instanceof ImageIcon ) {					// ImageIcon객체만 따로 때낸다.
					ImageIcon snapshot = new ImageIcon( ((ImageIcon) obj).getImage().getScaledInstance(836, 581, Image.SCALE_SMOOTH) );	// ClassNotFoundException
					//ImageIcon snapshot = new ImageIcon( ((ImageIcon) obj).getImage().getScaledInstance((int)vScreen.getWidth()*1, (int)vScreen.getHeight()*1, Image.SCALE_SMOOTH) );	// 동적싸이즈 조정 Height bug
					vScreen.setIcon(snapshot);	// vScreen
					revalidate();				// 화면검증
					repaint();					// 화면다시그리기
				} else { // else if ( obj instanceof Object ) // 					
				}
				
			} catch ( SocketTimeoutException e) {	// 소켓타임아웃
				stop();// 동기화******
				e.printStackTrace();
				
			} catch (InterruptedException e) {
				stop();// 동기화******
				e.printStackTrace();
				
			} catch (IOException | ClassNotFoundException e) {
				stop();
				System.out.println("SocketTimeout IOException | ClassNotFoundException-----------index = ");
				e.printStackTrace();
				
			} catch ( Exception e) {
				stop();
				System.out.println("SocketTimeout Exception-----------index = ");
				e.printStackTrace();
				
			}// try --------------
		}// while --------------- Thread Check
		addIndex();// 동기화******
	}// run -----------------
	
	
	
	
	public void stop() {
		index--;
		System.out.println("TeamView Thread Stop()-----------index = " + index);
		running = false;
	} // stop -----------
	
	
	
	
	// 동기화구문// 동기화******
	synchronized void addIndex(){
		index++;
		System.out.println("current index value: -----------index = " + index);
	}
	
	
	
	
	public static void main( String[] arg ) {
		System.out.println("TeamView main() -----------");
		new TeamViewServer();
	}// main ----------------

	
    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField vHost;
    private javax.swing.JLabel vScreen;
    // End of variables declaration         
	
	
	
}// TeamView class-------------------



/*
	TeamView main() -----------
	TeamView Thread start()------ index = 0
	TeamView Thread 생성자------ index = 0
	TeamView Thread run() - running------ index = 0
*/