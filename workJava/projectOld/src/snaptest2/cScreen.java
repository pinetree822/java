package snaptest2.src;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import static java.lang.System.out;
import java.io.BufferedReader;
import javax.swing.*;


public class cScreen extends javax.swing.JFrame {

    public cScreen() {
        initComponents();
    }

    String filename = "";
    File selFile = null;
    JFileChooser fileDial = new JFileChooser("E:/Uplaod"); // 파일선택E:\모음-사진 // new JFileChooser("C:/MyJava/"); // 파일선택E:\모음-사진
    private void btFileActionPerformed(java.awt.event.ActionEvent evt) {                                       
        /*
    	// 파일 다이얼로그를 띄워 업로드할 파일을 선택한다.
    	fileDial.showOpenDialog(this);
    	selFile = fileDial.getSelectedFile();
    	tfFile.setText(selFile.getAbsolutePath());
    	filename = selFile.getName();
    	filename = filename.toLowerCase();
    	// 파일이 이미지 파일이면 lb에 미리보기를 해주자.
    	if( filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".gif"))
    	{
    		lb.setIcon(new ImageIcon(selFile.getAbsolutePath()));
    		lb.setText("");
    		lb.setHorizontalAlignment(JLabel.CENTER);
    	}
    	*/
    }                                      

    
    private void btUploadActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	// 파일을 서버에 전송하는 스레드 생성 및 동작
    	SenderThread tr = new SenderThread();
    	tr.start();
    }          
    
    class SenderThread extends Thread {
    	public void run() {
    		// ftpserver에 접속하자.(아이피, 포트번호)
    		String serverip = tfHost.getText();
    		final int port=9999;
    		
    		if( serverip==null || serverip.trim().isEmpty() ){
    			JOptionPane.showMessageDialog(lb, "서버의 ip주소를 입력하세요.");
    			tfHost.requestFocus();
    		}//if--------
    		
    		try {
    			//Robot r = new Robot();// 사용화면 캡쳐
    			
				// 소켓 생성
    			Socket sock = new Socket(serverip, port);
    			
    			// 타이틀에 연결 결과 출력
    			setTitle("## 서버와 연결됨");
    			
    			OutputStream os = sock.getOutputStream();
    			//ObjectOutputStream oos = new ObjectOutputStream(os);



    			Robot r = new Robot();// 사용화면 캡쳐
    			int input = 0, count =0;
    			for(int i=0; i<10; i++){
    				BufferedImage bimg = r.createScreenCapture(new Rectangle(1680, 1050));
    				//ImageIO.createImageOutputStream(bimg);
        			ImageIO.write(bimg, "gif", os);
        			bimg.flush();
        			os.flush();
        			//os.flush();
    				count += bimg.getHeight()*bimg.getWidth()/1024/1024;
    				System.out.println(count + "M 전송중...");
    				Thread.sleep(2000);
    				System.out.println(i + " 캡처함");
    			} 
				System.out.println(count + "M파일 전송 완료");
    			if(sock != null) sock.close();
    			

    			// close()
			} catch (Exception e) {
				System.out.println("예외 : " + e);
			}
    	}// public void run() -----------
    	
    	
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfHost = new javax.swing.JTextField();
        btUpload = new javax.swing.JButton();
        btFile = new javax.swing.JButton();
        tfFile = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("파일업로드");
        setBackground(new java.awt.Color(255, 255, 255));

        tfHost.setText("localhost");
        tfHost.setBorder(javax.swing.BorderFactory.createTitledBorder("업로드할 서버 IP주소"));

        btUpload.setText("업로드");
        btUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUploadActionPerformed(evt);
            }
        });

        btFile.setText("파일찾기");
        btFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFileActionPerformed(evt);
            }
        });

        tfFile.setBorder(javax.swing.BorderFactory.createTitledBorder("업로드할 파일명"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfHost)
                    .addComponent(tfFile, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfHost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btUpload, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFile, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lb.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    
    
                              

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btFile;
    private javax.swing.JButton btUpload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb;
    private javax.swing.JTextField tfFile;
    private javax.swing.JTextField tfHost;
    // End of variables declaration                   
}






