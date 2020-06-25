package _help2;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FileUploadGUI extends javax.swing.JFrame {

  
    public FileUploadGUI() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfHost = new javax.swing.JTextField();
        tfFile = new javax.swing.JTextField();
        btFile = new javax.swing.JButton();
        btUpload = new javax.swing.JButton();
        lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(":::FileUPload:::");

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        tfHost.setText("localhost");
        tfHost.setBorder(javax.swing.BorderFactory.createTitledBorder("업로드할 서버 IP주소"));
        tfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHostActionPerformed(evt);
            }
        });

        tfFile.setBorder(javax.swing.BorderFactory.createTitledBorder("업로드할 파일명"));

        btFile.setText("파일찾기");
        btFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFileActionPerformed(evt);
            }
        });

        btUpload.setText("Upload");
        btUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfFile)
                    .addComponent(tfHost, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btFile)
                    .addComponent(btUpload))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btFile, btUpload});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfHost)
                    .addComponent(btUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btFile, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFile))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btFile, btUpload});

        lb.setText("jLabel1");
        lb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void tfHostActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    JFileChooser fileDial=new JFileChooser("C:/MyJava/");
    String filename="";
    private void btFileActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	//파일 다이얼로그를 띄워 업로드할 파일을 선택한다.
    	fileDial.showOpenDialog(this);
    	File selFile=fileDial.getSelectedFile();
    	tfFile.setText(selFile.getAbsolutePath());
    	filename=selFile.getName();
    	//파일이 이미지 파일이면 lb에 미리보기를 해주자.
    	filename=filename.toLowerCase();
    	if(filename.endsWith(".jpg")||filename.endsWith(".png")
    			||filename.endsWith(".gif")){
    		lb.setIcon(new ImageIcon(selFile.getAbsolutePath()));
    		lb.setText("");
    		lb.setHorizontalAlignment(JLabel.CENTER);
    	}
    	
    }                                      

    private void btUploadActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //파일을 서버에 전송하는 스레드 생성 및 동작
    	SenderThread tr=new SenderThread();
    	tr.start();
    }                                        

    class SenderThread extends Thread{
    	
    	public void run(){
    		//ftpserver에 접속하자 (아이피,포트번호)
    		String serverip=tfHost.getText();
    		final int port=7788;
    		if(serverip==null||serverip.trim().isEmpty()){
    			JOptionPane.showMessageDialog(lb, 
    					"서버의 IP주소를 입력하세요");
    			tfHost.requestFocus();
    			return;
    		}//if-----------
    		try {
    			//소켓 생성
    			Socket sock=new Socket(serverip,port);
    			//타이틀에 연결 결과 출력
    			setTitle("##서버와 연결됨##");
    			//소켓 출력스트림=> ObjectOutputStream필터링
    			OutputStream os=sock.getOutputStream();
    			ObjectOutputStream oos=new ObjectOutputStream(os);
    			
    			//파일 입력 스트림=> FileInputStream
    			FileInputStream fis
    			=new FileInputStream(tfFile.getText());
    			
    			//파일명을 서버에 전송한다.
    			oos.writeUTF(filename);
    			oos.flush();
    			
    			//파일을 읽으면서 소켓출력 스트림을 통해
    			//파일 데이터를 내보낸다.
    			byte[] data=new byte[1024];
    			int input=0, count=0;
    			while((input=fis.read(data))!=-1){
    				oos.write(data,0,input);
    				oos.flush();
    				count+=input;
    				System.out.println(count+"바이트 전송중...");
    			}
    			
    			if(oos!=null) oos.close();
    			if(fis!=null) fis.close();
    			if(sock!=null) sock.close();
    			JOptionPane.showMessageDialog(lb, "업로드 완료!");
			} catch (Exception e) {
				System.out.println("예외: "+e);
			}
    		
    	}//run()----------------
    	
    }////////////////////////////////
   
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileUploadGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileUploadGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileUploadGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileUploadGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileUploadGUI().setVisible(true);
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
