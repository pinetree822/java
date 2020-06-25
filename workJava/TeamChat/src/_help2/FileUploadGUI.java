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
        tfHost.setBorder(javax.swing.BorderFactory.createTitledBorder("���ε��� ���� IP�ּ�"));
        tfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHostActionPerformed(evt);
            }
        });

        tfFile.setBorder(javax.swing.BorderFactory.createTitledBorder("���ε��� ���ϸ�"));

        btFile.setText("����ã��");
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
    	//���� ���̾�α׸� ��� ���ε��� ������ �����Ѵ�.
    	fileDial.showOpenDialog(this);
    	File selFile=fileDial.getSelectedFile();
    	tfFile.setText(selFile.getAbsolutePath());
    	filename=selFile.getName();
    	//������ �̹��� �����̸� lb�� �̸����⸦ ������.
    	filename=filename.toLowerCase();
    	if(filename.endsWith(".jpg")||filename.endsWith(".png")
    			||filename.endsWith(".gif")){
    		lb.setIcon(new ImageIcon(selFile.getAbsolutePath()));
    		lb.setText("");
    		lb.setHorizontalAlignment(JLabel.CENTER);
    	}
    	
    }                                      

    private void btUploadActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //������ ������ �����ϴ� ������ ���� �� ����
    	SenderThread tr=new SenderThread();
    	tr.start();
    }                                        

    class SenderThread extends Thread{
    	
    	public void run(){
    		//ftpserver�� �������� (������,��Ʈ��ȣ)
    		String serverip=tfHost.getText();
    		final int port=7788;
    		if(serverip==null||serverip.trim().isEmpty()){
    			JOptionPane.showMessageDialog(lb, 
    					"������ IP�ּҸ� �Է��ϼ���");
    			tfHost.requestFocus();
    			return;
    		}//if-----------
    		try {
    			//���� ����
    			Socket sock=new Socket(serverip,port);
    			//Ÿ��Ʋ�� ���� ��� ���
    			setTitle("##������ �����##");
    			//���� ��½�Ʈ��=> ObjectOutputStream���͸�
    			OutputStream os=sock.getOutputStream();
    			ObjectOutputStream oos=new ObjectOutputStream(os);
    			
    			//���� �Է� ��Ʈ��=> FileInputStream
    			FileInputStream fis
    			=new FileInputStream(tfFile.getText());
    			
    			//���ϸ��� ������ �����Ѵ�.
    			oos.writeUTF(filename);
    			oos.flush();
    			
    			//������ �����鼭 ������� ��Ʈ���� ����
    			//���� �����͸� ��������.
    			byte[] data=new byte[1024];
    			int input=0, count=0;
    			while((input=fis.read(data))!=-1){
    				oos.write(data,0,input);
    				oos.flush();
    				count+=input;
    				System.out.println(count+"����Ʈ ������...");
    			}
    			
    			if(oos!=null) oos.close();
    			if(fis!=null) fis.close();
    			if(sock!=null) sock.close();
    			JOptionPane.showMessageDialog(lb, "���ε� �Ϸ�!");
			} catch (Exception e) {
				System.out.println("����: "+e);
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
