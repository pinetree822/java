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
    JFileChooser fileDial = new JFileChooser("E:/Uplaod"); // ���ϼ���E:\����-���� // new JFileChooser("C:/MyJava/"); // ���ϼ���E:\����-����
    private void btFileActionPerformed(java.awt.event.ActionEvent evt) {                                       
        /*
    	// ���� ���̾�α׸� ��� ���ε��� ������ �����Ѵ�.
    	fileDial.showOpenDialog(this);
    	selFile = fileDial.getSelectedFile();
    	tfFile.setText(selFile.getAbsolutePath());
    	filename = selFile.getName();
    	filename = filename.toLowerCase();
    	// ������ �̹��� �����̸� lb�� �̸����⸦ ������.
    	if( filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".gif"))
    	{
    		lb.setIcon(new ImageIcon(selFile.getAbsolutePath()));
    		lb.setText("");
    		lb.setHorizontalAlignment(JLabel.CENTER);
    	}
    	*/
    }                                      

    
    private void btUploadActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	// ������ ������ �����ϴ� ������ ���� �� ����
    	SenderThread tr = new SenderThread();
    	tr.start();
    }          
    
    class SenderThread extends Thread {
    	public void run() {
    		// ftpserver�� ��������.(������, ��Ʈ��ȣ)
    		String serverip = tfHost.getText();
    		final int port=9999;
    		
    		if( serverip==null || serverip.trim().isEmpty() ){
    			JOptionPane.showMessageDialog(lb, "������ ip�ּҸ� �Է��ϼ���.");
    			tfHost.requestFocus();
    		}//if--------
    		
    		try {
    			//Robot r = new Robot();// ���ȭ�� ĸ��
    			
				// ���� ����
    			Socket sock = new Socket(serverip, port);
    			
    			// Ÿ��Ʋ�� ���� ��� ���
    			setTitle("## ������ �����");
    			
    			OutputStream os = sock.getOutputStream();
    			//ObjectOutputStream oos = new ObjectOutputStream(os);



    			Robot r = new Robot();// ���ȭ�� ĸ��
    			int input = 0, count =0;
    			for(int i=0; i<10; i++){
    				BufferedImage bimg = r.createScreenCapture(new Rectangle(1680, 1050));
    				//ImageIO.createImageOutputStream(bimg);
        			ImageIO.write(bimg, "gif", os);
        			bimg.flush();
        			os.flush();
        			//os.flush();
    				count += bimg.getHeight()*bimg.getWidth()/1024/1024;
    				System.out.println(count + "M ������...");
    				Thread.sleep(2000);
    				System.out.println(i + " ĸó��");
    			} 
				System.out.println(count + "M���� ���� �Ϸ�");
    			if(sock != null) sock.close();
    			

    			// close()
			} catch (Exception e) {
				System.out.println("���� : " + e);
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
        setTitle("���Ͼ��ε�");
        setBackground(new java.awt.Color(255, 255, 255));

        tfHost.setText("localhost");
        tfHost.setBorder(javax.swing.BorderFactory.createTitledBorder("���ε��� ���� IP�ּ�"));

        btUpload.setText("���ε�");
        btUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUploadActionPerformed(evt);
            }
        });

        btFile.setText("����ã��");
        btFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFileActionPerformed(evt);
            }
        });

        tfFile.setBorder(javax.swing.BorderFactory.createTitledBorder("���ε��� ���ϸ�"));

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






