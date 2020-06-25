/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _javaChat3;
import java.net.*;

import java.io.*;
import java.util.*;
import javax.swing.table.*;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;
import static java.lang.System.out;


public class JavaChatGui extends JFrame 
implements Runnable {

	private Socket sock;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	String id, chatName, gender, host;
	boolean isStart;// ������ ó��
	private boolean isSendOne = false;// �ӼӸ� �����⿡ ���
	private float foreColor = Color.BLACK.getRGB();

    public JavaChatGui() {
        initComponents();
        
        // �α��� ���� ������ ä�ù濡 ����������
        tabP.setEnabledAt(1, false);// ���г��� ������ 0, 1, 2
        
        // â�ݱ� �̺�Ʈ ó�� ---
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent e){
        		exitProc();
        	}
        });
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        tabP = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfChatName = new javax.swing.JTextField();
        raM = new javax.swing.JRadioButton();
        raF = new javax.swing.JRadioButton();
        tfHost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMsg = new javax.swing.JTextArea();
        tfChat = new javax.swing.JTextField();
        chk = new javax.swing.JCheckBox();
        comboColor = new javax.swing.JComboBox<>();
        lbView = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        lbChatName = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        btLogout = new javax.swing.JButton();
        btRename = new javax.swing.JButton();
        btExit = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("::Cacao Chatting V1.1 ::");
        setBounds(new java.awt.Rectangle(150, 50, 0, 0));
        setResizable(false);
//////////////////////////////////////////////////////////////////////////
       jScrollPane2.setAutoscrolls(true);// ä��â ������ �ڵ� ��ũ��

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("���̵�");

        jLabel3.setText("��ȭ��");

        jLabel4.setText("����");

        jLabel5.setText("ȣ��Ʈ");

        raM.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(raM);
        raM.setSelected(true);
        raM.setText("����");

        raF.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(raF);
        raF.setText("����");

        tfHost.setText("localhost");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("::: Cacao Chatting App :::");

        btLogin.setText("����");
        btLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btCancel.setText("���");
        btCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(raM)
                                .addGap(18, 18, 18)
                                .addComponent(raF))
                            .addComponent(tfChatName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btCancel)
                                .addGap(51, 51, 51))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfChatName, tfHost, tfId});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancel, btLogin});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfId, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tfChatName, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(raM)
                            .addComponent(raF)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfHost, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin)
                    .addComponent(btCancel))
                .addGap(43, 43, 43))
        );

        tabP.addTab("�α���", jPanel1);

        taMsg.setEditable(false);
        taMsg.setColumns(20);
        taMsg.setRows(5);
        taMsg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jScrollPane2.setViewportView(taMsg);

        tfChat.setText("tfChat");
        tfChat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tfChatActionPerformed(evt);
            }
        });

        chk.setText("�ӼӸ�");

        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "������", "�Ķ���", "������", "�ʷϻ�", "��ũ��", "��������" }));
        comboColor.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                comboColorItemStateChanged(evt);
            }
        });
        comboColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboColorActionPerformed(evt);
            }
        });

        lbView.setFont(new java.awt.Font("����", 1, 16)); // NOI18N
        lbView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbView.setText("��");
        lbView.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbView, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 143, Short.MAX_VALUE))
                    .addComponent(tfChat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk)
                    .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbView))
                .addContainerGap())
        );

        tabP.addTab("ä�ù�", jPanel2);

        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\����-����\\20161031_093620.png")); // NOI18N
        jLabel6.setText("jLabel6");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("MyInfo"));

        jLabel7.setText("���̵�");

        jLabel8.setText("��ȭ��");

        jLabel9.setText("��   ��");

        lbId.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        lbId.setForeground(new java.awt.Color(255, 0, 51));
        lbId.setText("lbId");

        lbChatName.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        lbChatName.setForeground(new java.awt.Color(255, 0, 153));
        lbChatName.setText("lbChatName");

        lbGender.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        lbGender.setForeground(new java.awt.Color(0, 0, 204));
        lbGender.setText("lbGender");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(lbChatName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lbGender)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbChatName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbGender)))
        );

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "���̵�", "��ȭ��", "����"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        btLogout.setText("�� ��");
        btLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        btRename.setText("��ȭ�� ����");
        btRename.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btRenameActionPerformed(evt);
            }
        });

        btExit.setText("�� ��");
        btExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btLogout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btRename)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btExit))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tabP, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btExit, btLogout, btRename});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabP, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btLogout)
                            .addComponent(btRename)
                            .addComponent(btExit))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void tfChatActionPerformed(ActionEvent evt) {//
    	sendMsg();// �޼��� ������
    	tfChat.setText("");// �޼��� �ڽ� ����
    	tfChat.requestFocus();// �޼��� �ڽ� ��Ŀ�� �̵�
    }//
    private void sendMsg(){
		//�޼����� 2���� �з� (�ӼӸ� ,�Ϲݸ�)
    	try {
	    	String msg = tfChat.getText();
	    	msg = msg.replace('|', 'l'); // 
	    	//msg = msg.replace("|", "&#124"); // 
	    	// msg�� Ȥ�� '|' ���ڰ� ���ԵǾ� �ִٸ�
	    	// '|'���ڸ� 'l'�� �ٲ���.
	    	
	    	if(!isSendOne) { // �ӼӸ� �����Ⱑ �ƴ϶��
		    	String sendMsg = "400|" + foreColor + "|" + msg;
				oos.writeUTF(sendMsg);
				oos.flush();
	    	} else {	// �ӼӸ� ��������
	    		
	    	}
		} catch (IOException e) {
			//e.printStackTrace();
			out.println("sendMsg()���� ����" + e);
		}
    }

//    private void tfChatActionPerformed(ActionEvent evt) {//
//    }//

    private void btRenameActionPerformed(ActionEvent evt) {
    }
    
    //jmf - ������ä�� api����
    // ��ư btLogin
    private void btLoginActionPerformed(ActionEvent evt) {
    	// 1. ����ڰ� �Է��� �� �ޱ� (���̵�, ��ȭ��, ����)
    	id = tfId.getText();
    	chatName = tfChatName.getText();
    	
    	ButtonModel bm = this.buttonGroup1.getSelection();
    	if( bm == raM.getModel() ) {
    		gender = "����";
    	} else {
    		gender = "����";
    	}
    	host = tfHost.getText();
    	
    	// 2. ��ȿ�� üũ
    	if( id==null || chatName==null || gender==null || host ==null || id.trim().isEmpty()
    			|| id.trim().isEmpty() || chatName.trim().isEmpty()
    			|| gender.trim().isEmpty() || host.trim().isEmpty()
    	)
    	{
    		showMsg("�Է� �ڽ��� ���� ��� �Է��ϼ���.");
    		tfId.requestFocus();
    		return;
    	}
    		
    	
    	// 3. ���� ��ȿ�ϴٸ� ä�ù� �г��� �����ش�.
    	tabP.setEnabledAt(1, true);
    	tabP.setEnabledAt(0, false);
    	tabP.setSelectedIndex(1);// ��ȭ�� �г� ����
    	this.setTitle(id + "�� �����ϼ˽��ϴ�.\n");
    	
    	
    	// 4. ������ ä���ϴ� �����带 ���۽�Ű��.
    	startChat(); // ä�ý���
    	
    }// private void btLoginActionPerformed-------------
    
    
    
    /*
     * ������ �����ִ� �޽����� �޾Ƽ� 
     * �� �������� ���� �ؼ��ؼ� ������ �����ϴ� 
     * �޼ҵ�(parsing)�� ȣ���Ѵ�.
     */
    @Override
    public void run(){
    	//
    	//while(true){
        while(isStart){
    		try {
    			String serverMsg = ois.readUTF();
    			out.println("run() serverMsg = " + serverMsg);
    			if(serverMsg==null) return;
    			parsing(serverMsg);// ���¸޼��� �ؼ��뵿
    			
    		} catch(Exception e){
    			//out.println( "run()���� ���� : " + e );
    		}
    	}// while ----------
    }// public void run() ---------------------

    
    
    
    private void parsing(String serverMsg) {
    	// '|' �� �������� serverMsg�� ��ū���� ��������
    	// ��Ģ

    	StringTokenizer st= new StringTokenizer(serverMsg, "|");
    	
    	// ù��° ��ū�� �׻� ���ڷ� ����(��Ģ)
    	int protocol = Integer.parseInt(st.nextToken()); // ����Ȯ�� �ʿ�

    	switch(protocol){
			// ������ �� "100|��ȭ��|���̵�|����"
	    	case 100 : {
	    		String cn = st.nextToken();
	    		String cid = st.nextToken();
	    		String cgen = st.nextToken();
	    		String data[] = {cn, cid, cgen}; // ������ �迭 // ���̺� �ֱ� ���ؼ� �迭�� �����.
	    		DefaultTableModel userModel = (DefaultTableModel)this.userTable.getModel(); // ��ȯŸ���� �θ�Ÿ���̶� (DefaultTableModel)
	    		userModel.addRow(data);
	    		userTable.setModel(userModel);
	    	}
	    	break;
	    	case 400 : {
	    		// ��ȭ������ ��ο��� ������
	    		String fromChat = st.nextToken();
	    		String fontColor = st.nextToken();
	    		String message = st.nextToken();
	    			    		
	    		showTaMsg( fromChat + ">>" + message);
	    	}
	    	break;
	    	case 800 : {
	    		showMsg("��ȭ���� �ߺ��˴ϴ�.\n�ٽ� �α����ϼ���.");
	    		tabP.setSelectedIndex(0);
	    		tabP.setEnabledAt(0, true);
	    		tabP.setEnabledAt(1, false);
	    		isStart=false;
	    		try {
	    			if( oos!=null ) oos.close();
	    			if( ois!=null ) ois.close();
	    			if( sock!=null ){
	    				sock.close();
	    				sock=null;
	    			}
	    		} catch(Exception e){}
	    	}
	    	break;
	    	case 810 : {// �α� �ƿ�. ���� ó��
	    		//�������� "8100|�����ϴ� ��� id"
	    		String logoutId = st.nextToken();
	    		removeUserList(logoutId, 1);// ��������̺��� ����� ����
	    	}
	    	break;
	    	case 900 : {// �α� �ƿ�. ���� ó��
	    		String exitId = st.nextToken();
	    		removeUserList(exitId, 0);// ��������̺��� ����� ����
	    		
	    	}
	    	break;
    	}
    	
    	// ��ȭ������ ��ο��� ������
    	// "400|��ȭ��|�۲û�|�޼���"
	}// private void parsing(String serverMsg)

    
    //
    public void removeUserList(String logoutId, int mode) {
		// userModel���� �����ϱ� ���ؼ� ���̺��� ���� ��������
		DefaultTableModel userModel = (DefaultTableModel)userTable.getModel();
		
		String tmpChatName="";// ��ȭ��
		for(int i=0; i<userModel.getRowCount(); i++){
			String tmpId = (String)userModel.getValueAt(i, 0);//���̺��� id��ġ�� 0�ΰ����� �� ������
			tmpChatName = (String)userModel.getValueAt(i, 1);
			if( logoutId.equals(tmpId) ){// idã�� ����
				userModel.removeRow(i);
				break;
			}
		}//for--------------
		
		
		userTable.setModel(userModel);
		
		String sendMsg = logoutId + " [ " + tmpChatName +" ]���� �����Ͽ����ϴ�.";
		showMsg(sendMsg);
		
		// �����ϴ� ����� ������ ���
		// ä�ù濡�� ���� �α��� ȭ������ ��ȯó������.
		if( logoutId.equals(id) ){
			isStart=false;// ������ ó��
			exitChat(mode);
			// ä���� ���� �Ǵ� ���� ó���ϴ� �޼ҵ�
			// mode�� 1���� �ѱ�� ����, 0�� �ѱ�� ����ó��
			
			// ���� �Ǵ� ������ ��� ä�ù濡 ������ �ִ�
			// User����� ���̺��� ����������.
			for( int i=userModel.getRowCount()-1; i>=0; i-- )
			{
				userModel.removeRow(i);// ����: ������ ���ڵ忭�� �ڿ������� �ؾߵȴ�.(�ȱ׷� ����)
			}
			taMsg.setText("");// ��ȭ����ڽ� �����
		}
//		tabP.setSelectedIndex(0);
//		tabP.setEnabledAt(0, true);
//		tabP.setEnabledAt(1, false);
    }
    
    
    
    
    
    // ä���� ���� �Ǵ� ���� ó���ϴ� �޼ҵ�
	private void exitChat(int mode) {
			try {
				if( oos!=null ) oos.close();
				if( ois!=null ) ois.close();
				if( sock!=null ) {
					sock.close();
					sock=null;	// �����Ҷ� ���Ͽ��η� �����ϴ� �ڵ�� 
				}
			} catch (IOException e) {
				out.println("exitChat���� ���� : " + e); 
				e.printStackTrace();
			}
			
			if(mode==1){// �α׾ƿ�
				tabP.setSelectedIndex(0);// �α��� �г��� ����
				tabP.setEnabledAt(0, true);// �α��� �г��� Ȱ��ȭ
				tabP.setEnabledAt(1, false);// ��ȭ �г��� Ȱ��ȭ
			} else if(mode==0){// ����
				this.dispose();
				System.exit(0); // ���μ��� ����
			}
	}//-------------------


	private void startChat() {
		isStart = true;
    	// �� ���� �󺧰� ����
    	lbId.setText(id);
    	lbChatName.setText(chatName);
    	lbGender.setText(gender);
    	
    	// ���Ͽ���
    	try {
    		sock = new Socket(host,9999);
    		taMsg.setText("## ������ ����� ##\n");
    		
    		// oos���� ���� => �����ʿ����� ois�� ���� ���������Ƿ� 
    		/// Ŭ������ oos�� ���� �����Ѵ�. �ȱ׷��� ������ �ȴ�.
    		// ���������� 1. ObjectInputStream()�� ���� 2.ObjectInputStream()
    		oos = new ObjectOutputStream(sock.getOutputStream());// oos���� ����
    		ois = new ObjectInputStream(sock.getInputStream());// ois����
    		
    		oos.writeUTF(id + "|" + chatName + "|" + gender);
    		oos.flush();
    		
    		// ������ �޽����� �������ϴ� ������ ����
    		Thread tr = new Thread(this);
    		tr.start();
    		
    	} catch(Exception e){
    		String msg = "ê���� ���ῡ �����߾��.\n";
    		msg += "ȣ��Ʈ�� Ȯ���ϼ���.";
    		showMsg(msg);
    		return ;
    	}// try ----------------------
	}// private void startChat() -----------------


	// ��ũ�ѹٰ� ���� ����������
	private void showTaMsg(String msg) {
		taMsg.append(msg+"\n");
		taMsg.setCaretPosition(taMsg.getText().length());
		//JOptionPane.showMessageDialog(this, msg);
	}// private void showMsg(String msg)-------------
    
	
	
	public void showMsg(String msg) {
		taMsg.append(msg);
		JOptionPane.showMessageDialog(this, msg);
		///JOptionPane.showMessageDialog(this, msg);
	}// private void showMsg(String msg)-------------

	
	
	
	private void btCancelActionPerformed(ActionEvent evt) {
    }


	
	
    private void btLogoutActionPerformed(ActionEvent evt) {
    	String message = "�����ұ��?";
    	 int yn = JOptionPane.showConfirmDialog(this, message, "����Ȯ��", JOptionPane.YES_NO_OPTION);
    	 if( yn == JOptionPane.YES_OPTION){
    		 try {
				oos.writeUTF("810|" + id);
				oos.flush();
			} catch (IOException e) {
				out.println("�α׾ƿ� �� ���� : " + e);
				//e.printStackTrace();
			}
    	 }
    }

    
    private void btExitActionPerformed(ActionEvent evt) {
    	exitProc();
    }// btExitActionPerformed ----------------

    
    
    
    private void exitProc() {
    	String message = "ä���� �����ұ��?";
    	int yn = JOptionPane.showConfirmDialog(this, message,
    			"����Ȯ��", JOptionPane.YES_NO_OPTION);
    	if( yn==JOptionPane.YES_OPTION ){
    		
    		out.println("sock==" + sock);
    		if( sock!=null ) {// ���� �ϰ� ����
    			try {
    				oos.writeUTF("900|");
    				oos.flush();
    			} catch(IOException e){
    				out.println("���� ���� �� ���� : " + e);
    			}
    		} else { // ���� ���ϰ� ����
    			exitChat(0);
    		}// if----------------
    	}// if-----------------
	}// exitProc -------------------


	private void comboColorActionPerformed(ActionEvent evt) {

    }

    
    
    private void comboColorItemStateChanged(ItemEvent evt) {

    }

    

    
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JavaChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaChatGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btRename;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chk;
    private javax.swing.JComboBox<String> comboColor;
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
    private javax.swing.JLabel lbChatName;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbView;
    private javax.swing.JRadioButton raF;
    private javax.swing.JRadioButton raM;
    private javax.swing.JTextArea taMsg;
    private javax.swing.JTabbedPane tabP;
    private javax.swing.JTextField tfChatName;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfChat;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
