/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _javaChat5;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import javax.swing.ButtonModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import java.awt.Event;
import javax.swing.*;

public class MyChatGui extends javax.swing.JFrame implements Runnable{
    
    private User user=new User();
    private Socket sock;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private DefaultTableModel userModel;
    private StyledDocument doc;
    private boolean isStart=false;
    private JButton bsm = new JButton("�쟾�넚");
    private JButton bsf = new JButton("�뙆�씪");
    
    int wis=0;
    int btt=0;
    
    //�뙆�씪 �쟾�넚 愿��젴
    String ip = "192.168.10.75";
    File path;
    String toChatName;//�뙆�씪 諛쏆쓣 �궗�엺 ���솕紐�
    int port=7777;
    
    int select=0;
    
    
    
    private int foreColor=Color.black.getRGB();//湲��옄�깋
    
    public MyChatGui() {
        initComponents();
        doc=this.tpMsg.getStyledDocument();
        this.jTabbedPane1.setEnabledAt(1, false);
        //���솕諛⑹뿉 濡쒓렇�씤 �븯吏� �븡�쑝硫� 紐삳뱾�뼱 媛��룄濡�
        //濡쒓렇�씤(0), ���솕諛�(1)
    addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            exitCheck();
        }
    });
    }
    /*�꽌踰꾧� 蹂대궡�삤�뒗 硫붿떆吏�瑜� 怨꾩냽 �뱽�뒗�떎.*/
    @Override
    public void run(){
        String serverMsg="";
        while(isStart){
            try{
            serverMsg=ois.readUTF();
            if(serverMsg==null){
                out.println("run() serverMsg媛� �꼸");
                return;
            }
            //100/�븘�씠�뵒/���솕紐�/�꽦蹂�
            process(serverMsg);            
            }catch(Exception e){
                out.println("run()�뿉�꽌 �삁�쇅: "+e);
                
            }
        }
    }//---------------------------------------
    /**�꽌踰꾧� 蹂대궡�삤�뒗 硫붿떆吏�瑜� 遺꾩꽍�븳�떎.*/
    public void process(String msg){
        
        String[] tokens=msg.split("\\|");
        
//        for(String t:tokens){
//            out.println(t);
//        }

        int protocol=Integer.parseInt(tokens[0].trim());//100
        //100/�븘�씠�뵒/���솕紐�/�꽦蹂�
        switch(protocol){
            case 100:{
                String[]data={ tokens[1], tokens[2], tokens[3]};
                                //�븘�씠�뵒,   ���솕紐�,    �꽦蹂�
                userModel=(DefaultTableModel)this.userTable.getModel();
                userModel.addRow(data);
            }break;
            case 400:{
                //�꽌踰꾩뿉�꽌 400|���솕紐�|湲�瑗댁깋|硫붿떆吏�
                String cname=tokens[1];
                String cr=tokens[2];
                String cmsg=tokens[3];
                //�뀓�뒪�듃�럹�씤�뿉 �뒪���씪�쓣 �쟻�슜�빐�꽌 ���솕�궡�슜�쓣 異쒕젰�븯�뒗 硫붿냼�뱶
                showGui(cname,cr,cmsg);                
                
            }break;
            case 500:{//洹볦냽留�
                
                String cname=tokens[1];
                String toname=tokens[2];
                String cmsg=tokens[3];
                
                showGui(cname,toname, cmsg);
                
            }break;
            
            case 700:{
                //700|蹂대궡�뒗 �궗�엺|�뙆�씪紐�
                String fromChatName=tokens[1];
                String fname=tokens[2];
                
                String msg2=fromChatName+"�떂�씠 "+fname+"�뙆�씪�쓣 �쟾�넚�븯�젮 �빀�땲�떎. �닔�씫�븯�떆寃좎뒿�땲源�?";
                int yn=JOptionPane.showConfirmDialog(this, msg2);
                try{
                if(yn==JOptionPane.YES_OPTION){
                    System.out.println("oos=="+oos);
                    oos.writeUTF("710|YES|"+user.getChatName()+"|"+fname);
                    oos.flush();
                    
                    new FTPServer().start();
                }else{
                    oos.writeUTF("710|NO|"+toChatName+"|"+fname);
                    oos.flush();
                }
                }catch(Exception e){
                    System.out.println("e: "+e);
                    e.printStackTrace();
                }
                
            }break;
            case 720:{
                
                new MySenderThread().start();
            }break;
            
            
            //泥섏쓬 �젒�냽�떆 �룞�씪�븳 ���솕紐낆쑝濡� �젒�냽�맂 寃쎌슦            
            
            case 800:{
                out.println("�룞�씪�븳 ���솕紐낆쑝濡� �젒�냽 硫붿떆吏�: "+msg);
                JOptionPane.showMessageDialog(this, 
                        "�룞�씪�븳 ���솕紐낆씠 �씠誘� �엳�뒿�땲�떎.\n �떎瑜� ���솕紐낆쑝濡� "
                        +"�옱�젒�냽�븯�꽭�슂!!");
                isStart=false;
                this.jTabbedPane1.setSelectedIndex(0);//濡쒓렇�씤 �뙣�꼸 �꽑�깮
                this.jTabbedPane1.setEnabledAt(0, true);
                this.jTabbedPane1.setEnabledAt(1, false);
                //dispose();
                try {
                    if(oos!=null){
                        oos.close();
                        oos=null;
                    }
                    if(ois!=null){
                        ois.close();
                        ois=null;
                    }
                    if(sock!=null){
                        sock.close();
                        sock=null;
                    }
                    
                } catch (Exception e) {                    
                }
                
            }break;
            
            
            case 810:{//�꽌踰꾩뿉�꽌 "810|�눜�옣�븯�뒗 �궗�엺�쓽 ���솕紐�"
                String exitChatName=tokens[1];
                exitProc(exitChatName, 0);//�눜�옣: 0媛�
                
            }break;
            case 900:{// "900|醫낅즺�븯�뒗 �궗�엺 ���솕紐�"
                String exitChatName=tokens[1];
                exitProc(exitChatName, 1);//醫낅즺: 1媛�
                
            }break;
            case 950:{//"900�씠 醫낅즺�븯�뒗 �궗�엺 ���솕紐�
                  //�꽌踰꾩뿉�꽌 400|���솕紐�|湲�瑗댁깋|硫붿꽭吏�
                String cname=tokens[1];         
                           
                //�뀓�뒪�듃 �럹�씤�뿉 �뒪���씪�쓣 �쟻�슜�빐�꽌 ���솕�궡�슜�쓣 異쒕젰�븯�뒗 硫붿냼�뱶
                banProc(cname,0);
                //showGui(cname,cr,cmsg);
            
             }break;
        }//switch-----------------------------        
    }//process()--------------------------
    public void banProc(String exitChatName,int exitMode){
        //�눜�옣|醫낅즺瑜� 蹂몄씤�씠 �븯�뒗 寃껋씠 �븘�땺 寃쎌슦
        String tmpName="",tmpId="";
        for(int i=0;i<userModel.getRowCount();i++){            
                tmpId=userModel.getValueAt(i, 0).toString();
                tmpName=userModel.getValueAt(i, 1).toString();
                
                if(tmpName.equals(exitChatName)){
                    //紐⑤뜽�뿉�꽌 �눜�옣�븯�뒗 �궗�엺�쓣 �궘�젣
                   
                    userModel.removeRow(userTable.getSelectedRow());
                    break;
                
                }//if
            }//for            
    String exitMsg=(exitMode==0)? tmpId+"["+exitChatName+"]�떂�씠 媛뺥눜�릺�뿀�뒿�땲�떎..\n":
            tmpId+"["+exitChatName+"]�떂�씠 �젒�냽�쓣 �걡�뿀�뒿�땲�떎.\n";
      
    showGui(Color.red ,Color.yellow ,exitMsg);
        
        //�눜�옣|醫낅즺�븯�뒗 �겢�씠 蹂몄씤�씪 寃쎌슦
         if(exitChatName.equals(user.getChatName())){
             isStart=false;
             exitChat(0);//�눜�옣:0,醫낅즺:1
        out.println(userModel.getRowCount()+"<==�뻾�닔");
           
                for(int i=userModel.getRowCount()-1;i>=0;i--){
                   // userModel.removeRow(i);
                      userModel.removeRow(userTable.getSelectedRow());
                }
            tpMsg.setText("");
            }
    }
    class MySenderThread extends Thread{
		
		public void run(){
			//ftpserver�뿉 �젒�냽(�븘�씠�뵾,�룷�듃)
			try{
				Socket so=new Socket(ip,7788);
                                System.out.println("ip=="+ip);
				setTitle("##�꽌踰꾩� �뿰寃곕맖##");
				ObjectOutputStream foos
				=new ObjectOutputStream(so.getOutputStream());
				System.out.println("foos=="+foos);
				//�뙆�씪紐낆쓣 �꽌踰꾩뿉 �쟾�넚
				foos.writeUTF(path.getName());
				foos.flush();
				//�뙆�씪�쓣 �씫�뼱�꽌 �꽌踰꾩뿉 �쟾�넚�븯�옄.
				FileInputStream fis
					=new FileInputStream(path);
				byte[] data=new byte[1024];
				
				int input=0;
				while((input=fis.read(data))!=-1){
					foos.write(data,0,input);
					foos.flush();
				}
				foos.close(); fis.close();
				so.close();
				JOptionPane.showMessageDialog(MyChatGui.this,ip+" �뙆�씪 �쟾�넚 �셿猷�!!");
			}catch(IOException e){
				System.out.println(e);
			}			
			
		}
	}

    
    public void exitProc(String exitChatName, int exitMode){
        //�눜�옣|醫낅즺瑜� 蹂몄씤�씠 �븯�뒗 寃껋씠 �븘�땺 寃쎌슦
        String tmpName="", tmpId="";
        for(int i=0;i<userModel.getRowCount();i++){
            tmpId=userModel.getValueAt(i, 0).toString();
            tmpName=userModel.getValueAt(i, 1).toString();
            if(tmpName.equals(exitChatName)){
                //紐⑤뜽�뿉�꽌 �눜�옣�븯�뒗 �궗�엺�쓣 �궘�젣
                userModel.removeRow(i);                
                break;
            }//if--------------------------
        }//for-------------------------------------
        String exitMsg=(exitMode==0)? tmpId+"["+exitChatName+"]�떂�씠 �눜�옣�빀�땲�떎.\n":
                tmpId+"["+exitChatName+"�떂�씠 �젒�냽�쓣 �걡�뿀�뒿�땲�떎.\n";
        showGui(Color.red, Color.yellow, exitMsg);
        
        //�눜�옣|醫낅즺�븯�뒗 �겢�씠 蹂몄씤�씪 寃쎌슦
        if(exitChatName.equals(user.getChatName())){
            isStart=false;
            exitChat(exitMode); //�눜�옣:0 , 醫낅즺:1
            userModel=(DefaultTableModel)this.userTable.getModel();
            out.println(userModel.getRowCount()+"<==�뻾�닔");
            for(int i=userModel.getRowCount()-1;i>=0;i--){
                userModel.removeRow(i);
            }
            tpMsg.setText("");
        }
        
    }//-------------------------------------

    public void showGui(Color foCr,Color bgCr, String msg){
        SimpleAttributeSet attr=new SimpleAttributeSet();
        StyleConstants.setForeground(attr, foCr);
        StyleConstants.setBackground(attr, bgCr);
        tpMsg.setCaretPosition(doc.getEndPosition().getOffset()-1);
        int end=tpMsg.getCaretPosition();
        try {
            doc.insertString(end, msg, attr);
        } catch (Exception e) {
        }
        
        
    }//--------------------------------
    
    /*�룞湲고솕 硫붿냼�뱶: 硫붿떆吏�瑜� �닚李⑥쟻�쑝濡� 蹂댁뿬以섏빞 �븯誘�濡�
    �뀓�뒪�듃�럹�씤�뿉 �뒪���씪�쓣 �쟻�슜�빐�꽌 ���솕�궡�슜�쓣 異쒕젰�븯�뒗 硫붿냼�뱶*/
    public synchronized void showGui(String chatName, String foColor, String msg){
        
        int foRGB=Integer.parseInt(foColor.trim());
        SimpleAttributeSet attr=new SimpleAttributeSet();
        StyleConstants.setForeground(attr, new Color(foRGB));
        //int end=tpMsg.getText().length();
        tpMsg.setCaretPosition(doc.getEndPosition().getOffset()-1);
        int end=tpMsg.getCaretPosition();
        
        String msg2="["+chatName+"]�떂>>"+msg+"\n";
        try{
            doc.insertString(end, msg2, attr);
        }catch(Exception e){}    
        
    }//----------------------------------
    
    public void exitChat(int mode){
        try {
            if(oos!=null) {
                oos.close();
                oos=null;
            }
            if(ois!=null){
                ois.close();
                ois=null;
            }
            if(sock!=null){
                sock.close();
                sock=null;
            }
        } catch (Exception e) {
        }
        if(mode==0){//�눜�옣-濡쒓렇�븘�썐
            this.jTabbedPane1.setEnabledAt(0, true);
            this.jTabbedPane1.setEnabledAt(1, false);
            this.jTabbedPane1.setSelectedIndex(0);
            
        }else if(mode==1){//醫낅즺-�떆�뒪�뀥 醫낅즺
            this.dispose();
            System.exit(0);//�봽濡쒓렇�옩 醫낅즺
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfChatName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rm = new javax.swing.JRadioButton();
        rf = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        tfHost = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpMsg = new javax.swing.JTextPane();
        tfChat = new javax.swing.JTextField();
        chk = new javax.swing.JCheckBox();
        comboFntCr = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        fileb = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbid = new javax.swing.JLabel();
        lbChatName = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        btLogout = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        btRename = new javax.swing.JButton();
        btban = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":::源�以��뼵 Chating v1.1:::");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("�쉶�썝 �븘�씠�뵒");

        jLabel2.setText("�쉶�썝 ���솕紐�");

        jLabel3.setText("�쉶�썝 �꽦蹂�");

        rm.setBackground(new java.awt.Color(51, 255, 255));
        buttonGroup1.add(rm);
        rm.setSelected(true);
        rm.setText("�궓�옄");

        rf.setBackground(new java.awt.Color(51, 255, 255));
        buttonGroup1.add(rf);
        rf.setText("�뿬�옄");

        jLabel4.setText("�샇 �뒪 �듃");

        tfHost.setText("localhost");
        tfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHostActionPerformed(evt);
            }
        });

        btLogin.setBackground(new java.awt.Color(102, 255, 51));
        btLogin.setText("�뿰 寃�");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btCancel.setBackground(new java.awt.Color(255, 0, 51));
        btCancel.setText("痍� �냼");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfChatName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rm)
                                .addGap(31, 31, 31)
                                .addComponent(rf))
                            .addComponent(tfHost)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btLogin)
                        .addGap(45, 45, 45)
                        .addComponent(btCancel)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfChatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rm)
                    .addComponent(rf))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin)
                    .addComponent(btCancel))
                .addGap(52, 52, 52))
        );

        jLabel5.setFont(new java.awt.Font("�븿珥덈＼諛뷀깢", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setText("�븞�뀞�븯�꽭�슂");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("濡쒓렇�씤", jPanel1);

        tpMsg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));
        jScrollPane2.setViewportView(tpMsg);

        tfChat.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        tfChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChatActionPerformed(evt);
            }
        });

        chk.setFont(new java.awt.Font("諛뷀깢", 0, 12)); // NOI18N
        chk.setText("洹볦냽留�");
        chk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkItemStateChanged(evt);
            }
        });
        chk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkActionPerformed(evt);
            }
        });

        comboFntCr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "寃��젙�깋", "�뙆���깋", "鍮④컯�깋", "�븨�겕�깋", "珥덈줉�깋" }));
        comboFntCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFntCrActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("援대┝", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("媛�");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fileb.setText("�뙆�씪 �쟾�넚");
        fileb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filebActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chk)
                        .addGap(28, 28, 28)
                        .addComponent(comboFntCr, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileb, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(tfChat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfChat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk)
                    .addComponent(comboFntCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(fileb))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("梨꾪똿諛�", jPanel2);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "�븘�씠�뵒", "���솕紐�", "�꽦   蹂�"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userTable);

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(":::�굹�쓽 �젙蹂�:::"));

        jLabel6.setText("[�븘�씠�뵒]");

        jLabel7.setText("[���솕紐�]");

        jLabel8.setText("[�꽦   蹂�]");

        lbid.setForeground(new java.awt.Color(255, 0, 0));
        lbid.setText("jLabel9");

        lbChatName.setForeground(new java.awt.Color(255, 0, 0));
        lbChatName.setText("jLabel10");

        lbGender.setForeground(new java.awt.Color(255, 0, 0));
        lbGender.setText("jLabel11");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbGender, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbChatName, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbid))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbChatName))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbGender))
                .addContainerGap())
        );

        btLogout.setText("�눜 �옣");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        btExit.setText("醫� 猷�");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        btRename.setText("���솕紐� 蹂�寃�");
        btRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRenameActionPerformed(evt);
            }
        });

        btban.setText("媛뺥눜");
        btban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btRename)
                                .addGap(18, 18, 18)
                                .addComponent(btExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btban)
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btRename, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btban)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHostActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"痍⑥냼踰꾪듉 �닃��援곗슂");
    }//GEN-LAST:event_btCancelActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // �궗�슜�옄媛� �엯�젰�븳 媛믪쓣 �뼸�뒗�떎.
        String host=tfHost.getText();
        String id=tfid.getText();
        String chatName=tfChatName.getText();
        ButtonModel btnModel=this.buttonGroup1.getSelection();
        String gender="";
        if(btnModel==rm.getModel()){
            gender="�궓�옄";
        }else{
            gender="�뿬�옄";
        }
        //�쑀�슚�꽦 泥댄겕 -�엯�젰媛믪씠 �뾾�쓣 寃쎌슦//////////////
        if(id==null || chatName==null ||
                id.trim().isEmpty() || chatName.trim().isEmpty()
                        ||gender.trim().isEmpty()){
            showMsg("�엯�젰媛믪쓣 紐⑤몢 �꽔�뼱�빞 �빐�슂");
            return;
        }
        ///////////////////////////////////////////////
        
        user.setChatName(chatName);
        user.setId(id);
        user.setGender(gender);
        
        
        
        //�엯�옣�븯硫� 梨꾪똿 �떆�옉�븯�뒗 �궗�슜�옄 �젙�쓽 硫붿냼�뱶 �샇異�
        try{
        startChat(host);    
        } catch (Exception e) {
            String msg="梨꾪똿 �꽌踰� �뿰寃곗뿉 �떎�뙣�뻽�뼱�슂\n"
                    +"�샇�뒪�듃瑜� �솗�씤�븯�꽭�슂!";
            showMsg(msg);
            return;
        }
        this.jTabbedPane1.setEnabledAt(1, true);//���솕諛� �솢�꽦�솕
        this.jTabbedPane1.setEnabledAt(0, false);//濡쒓렇�씤 鍮꾪솢�꽦�솕
        this.jTabbedPane1.setSelectedIndex(1);//���솕諛� �꽑�깮
        this.tpMsg.setEditable(false);//硫붿떆吏� 蹂댁뿬二쇰뒗 �꺆�럹�씤 �렪吏� 紐삵븯�룄濡�
        tfChat.requestFocus();//�엯�젰 �룷而ㅼ뒪 二쇨린
        
        //�굹�쓽 �젙蹂� �뀑�똿
        lbid.setText(id);
        lbChatName.setText(chatName);
        lbGender.setText(gender);
    }//GEN-LAST:event_btLoginActionPerformed
    
    /**�꽌踰꾩� �냼耳� �뿰寃고븯�뿬 �뒪�듃由쇱쓣 �븷�떦諛쏄퀬 �뒪�젅�뱶瑜� �룞�옉�떆�궓�떎.
     */
    public void startChat(String host) throws Exception{
            
            isStart=true;
            sock=new Socket(host,7777);
            setTitle("##�꽌踰꾩뿉 �뿰寃곕맖##["+user.getId()+"]");
            oos=new ObjectOutputStream(sock.getOutputStream());
            ois=new ObjectInputStream(sock.getInputStream());
            //�젒�냽�븯�옄 留덉옄 蹂몄씤�쓽 �젙蹂대�� �꽌踰꾩뿉 蹂대궦�떎.(User媛앹껜 �쟾�넚)
            oos.writeObject(user);
            oos.flush();
            //�뒪�젅�뱶媛� �룞�옉(�꽌踰꾧� 蹂대궡�삤�뒗 硫붿떆吏�瑜� �뱽�뒗 �뒪�젅�뱶)
            new Thread(this).start();
                    
    }
    public void showMsg(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
    
    
    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        
        int yn=JOptionPane.showConfirmDialog(this, "�눜�옣 �븷源뚯슂?","�눜�옣 �솗�씤",
                    JOptionPane.YES_NO_OPTION);
        if(yn==JOptionPane.YES_OPTION){
            try{
                oos.writeUTF("810|");
                oos.flush();
            }catch(IOException e){
                out.println("�눜�옣 泥섎━�떆 �삁�쇅: "+e);
            }           
        }//if----------------------
        
        
        
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRenameActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        int yn=JOptionPane.showConfirmDialog(this,"梨꾪똿�쓣 醫낅즺�븷源뚯슂?","醫낅즺 �솗�씤",
                JOptionPane.YES_NO_OPTION);
         if(yn==JOptionPane.YES_OPTION){
             //�꽌踰꾩뿉 �젒�냽�븯怨� 醫낅즺�븯�뒗 寃쎌슦
             out.println("oos=="+oos);
             if(oos!=null){
                 try{
                 oos.writeUTF("900|");
                 oos.flush();
                 }catch(IOException e){
                     out.println("�젒�냽 醫낅즺 以� �삁�쇅: "+e);
                 }
             }else{
                             
             //�젒�냽(濡쒓렇�씤) �븞�븯怨� 醫낅즺�븯�뒗 寃쎌슦
                System.exit(0);
             }
         }
        
    }//GEN-LAST:event_btExitActionPerformed

    public void exitCheck(){
         if(oos!=null){
                 try{
                 oos.writeUTF("900|");
                 oos.flush();
                 }catch(IOException e){
                     out.println("�젒�냽 醫낅즺 以� �삁�쇅: "+e);
                 }
         }
    }
    
    private void tfChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChatActionPerformed
        String mymsg=tfChat.getText();
        //���솕�궡�슜 蹂대궡湲�
        sendMyMessage(mymsg);
        tfChat.setText("");
    }//GEN-LAST:event_tfChatActionPerformed

    private void filebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filebActionPerformed
        if(evt.getSource()==fileb){
            //�쟾�넚�븷 �궗�엺�쓣 �뀒�씠釉붿뿉�꽌 �꽑�깮�븳�떎.
            int row=userTable.getSelectedRow();
            if(row<0){
                setTitle("�쟾�넚�븷 �궗�엺�쓣 �꽑�깮�븯�꽭�슂");
                return;
            }
            toChatName=userModel.getValueAt(row, 1).toString();
            
            
            
            
            JFileChooser filesend=new JFileChooser("C://");
            filesend.setDialogTitle("�뙆�씪 �꽑�깮");
            filesend.setMultiSelectionEnabled(true);
            filesend.setApproveButtonToolTipText("�쟾�넚�븷 �뙆�씪�쓣 �꽑�깮�븯�꽭�슂");
            filesend.showDialog(this, "�뿴湲�");
           path = filesend.getSelectedFile();
            System.out.println("path="+path+", "+path.getName());
            if(path != null){
                //700|諛쏆쓣�궗�엺|�뙆�씪紐�
                //�뙆�씪 �씤�뭼�뒪�듃由쇳븯怨� �뿰寃� 諛쏆쓣�궗�엺ip二쇱냼瑜� �븣�븘�꽌 蹂대궦�떎.
           
           
           
           Socket socket_tmp;
                try {
                    oos.writeUTF ("700|"+toChatName+"|"+path.getName());
                    oos.flush();
                    socket_tmp = new Socket(ip, port+1);
                    FileSender fs= new FileSender(socket_tmp,path);
                    fs.start();
                } catch (UnknownHostException e) {}
                  catch(IOException e){}
            }
            
        }
        
    }//GEN-LAST:event_filebActionPerformed

    private void chkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActionPerformed
        
        
    }//GEN-LAST:event_chkActionPerformed

    private void chkItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkItemStateChanged
        
    }//GEN-LAST:event_chkItemStateChanged

    private void comboFntCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFntCrActionPerformed
        SimpleAttributeSet attr = new SimpleAttributeSet();

        attr = new SimpleAttributeSet();

        if (comboFntCr.getSelectedIndex() == 0) {
            this.foreColor = Color.black.getRGB();

        } else if (comboFntCr.getSelectedIndex() == 1) {
            this.foreColor = Color.blue.getRGB();

        } else if (comboFntCr.getSelectedIndex() == 2) {
            this.foreColor = Color.red.getRGB();

        } else if (comboFntCr.getSelectedIndex() == 3) {
            this.foreColor = Color.pink.getRGB();

        } else {

        }
    }//GEN-LAST:event_comboFntCrActionPerformed

    private void btbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbanActionPerformed
        Object obj=evt.getSource();
        
       //String mymsg=this.sendMyMessage(sendMsg);     
        //String sendMsg = "400|" + foreColor + "|" + mymsg;
        int yn=JOptionPane.showConfirmDialog(this, "媛뺥눜 �븷源뚯슂?","媛뺥눜�솗�씤",
                JOptionPane.YES_NO_OPTION);
            if(yn==JOptionPane.YES_OPTION){               
                btt=this.userTable.getSelectedRow(); 
                
                if(obj==btban){
                    if(btt==-1){
            JOptionPane.showMessageDialog(null, "���긽�쓣 �꽑�깮�븯�꽭�슂!!");
                return;
            }else if(lbChatName.getText().equals(userModel.getValueAt(btt, 1)))
            {
                JOptionPane.showMessageDialog(null, "�옄湲� �옄�떊�� �꽑�깮�븷 �닔 �뾾�뼱�슂!!");
                return;
            }
            //        
            //      
                    
             try{
                 oos.writeUTF("950|");
                 oos.flush();
             }catch(IOException e){
                 
             
                 out.println("userbanshow�삁�쇅泥섎━" +e);
             }
                }
            }                
    }//GEN-LAST:event_btbanActionPerformed

    public void sendMyMessage(String mymsg){
        if(mymsg==null||mymsg.trim().isEmpty()){
            showMsg("���솕�궡�슜�쓣 �엯�젰�븯�꽭�슂");
            return;
        }
        //'|' => �봽濡쒗넗肄� 援щ텇�옄
        //�샊�떆�씪�룄 ���솕 �궡�슜 以묒뿉 �겢�씪�씠�뼵�듃媛� '|' �쓣 �엯�젰�븯硫�
        //�씠瑜� '/'濡� 諛붽퓭二쇱옄. �븞洹몃윭硫� �봽濡쒗넗肄쒖씠 �뿁留앹씠 �맂�떎.
        mymsg=mymsg.replace('|', '/');
        
        //洹볦냽留먯씠 �븘�땲�씪硫�
        //"400|湲��옄�깋|硫붿떆吏�" ==> �꽌踰꾩뿉 �쟾�넚
        String sendMsg="400|"+foreColor+"|"+mymsg;
        
        select=this.userTable.getSelectedRow();
        
        //洹볦냽留먯씤 寃쎌슦
        if (chk.isSelected()) {
            //�뀒�씠釉� no �꽑�깮
            if(select==-1)
            {
                JOptionPane.showMessageDialog(null, "���긽�쓣 �꽑�깮�븯�꽭�슂");
                return;
            }else if(lbChatName.getText().equals(userModel.getValueAt(select, 1)))
            {
                JOptionPane.showMessageDialog(null, "�븞�맖");
                return;
            }
            //500|洹볥쭚蹂대궡�뒗�궗�엺|洹볥쭚諛쏅뒗�궗�엺|硫붿떆吏�
            sendMsg="500|"+lbChatName.getText()+"|"+
                    userModel.getValueAt(select, 1)+"|"+mymsg;      
            
        }
        try {
            oos.writeUTF(sendMsg);
            oos.flush();
            

        } catch (IOException e) {
            out.println("sendMyMessage()�뿉�꽌 �삁�쇅: " + e);
        }
        
    }//sendMyMessage()---------------------------
    
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
            java.util.logging.Logger.getLogger(MyChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyChatGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btRename;
    private javax.swing.JButton btban;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chk;
    private javax.swing.JComboBox<String> comboFntCr;
    private javax.swing.JButton fileb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbChatName;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbid;
    private javax.swing.JRadioButton rf;
    private javax.swing.JRadioButton rm;
    private javax.swing.JTextField tfChat;
    private javax.swing.JTextField tfChatName;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextPane tpMsg;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

  
}
