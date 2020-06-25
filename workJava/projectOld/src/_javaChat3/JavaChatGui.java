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
	boolean isStart;// 쓰레드 처리
	private boolean isSendOne = false;// 귓속말 보내기에 사용
	private float foreColor = Color.BLACK.getRGB();

    public JavaChatGui() {
        initComponents();
        
        // 로그인 하지 않으면 채팅방에 못들어오도록
        tabP.setEnabledAt(1, false);// 탭패널의 순서는 0, 1, 2
        
        // 창닫기 이벤트 처리 ---
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
       jScrollPane2.setAutoscrolls(true);// 채팅창 보낼때 자동 스크롤

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("아이디");

        jLabel3.setText("대화명");

        jLabel4.setText("성별");

        jLabel5.setText("호스트");

        raM.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(raM);
        raM.setSelected(true);
        raM.setText("남자");

        raF.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(raF);
        raF.setText("여자");

        tfHost.setText("localhost");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("::: Cacao Chatting App :::");

        btLogin.setText("연결");
        btLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btCancel.setText("취소");
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

        tabP.addTab("로그인", jPanel1);

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

        chk.setText("귓속말");

        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "검정색", "파란색", "빨강색", "초록색", "핑크색", "오렌지색" }));
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

        lbView.setFont(new java.awt.Font("굴림", 1, 16)); // NOI18N
        lbView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbView.setText("가");
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

        tabP.addTab("채팅방", jPanel2);

        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\모음-사진\\20161031_093620.png")); // NOI18N
        jLabel6.setText("jLabel6");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("MyInfo"));

        jLabel7.setText("아이디");

        jLabel8.setText("대화명");

        jLabel9.setText("성   별");

        lbId.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        lbId.setForeground(new java.awt.Color(255, 0, 51));
        lbId.setText("lbId");

        lbChatName.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        lbChatName.setForeground(new java.awt.Color(255, 0, 153));
        lbChatName.setText("lbChatName");

        lbGender.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
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
                "아이디", "대화명", "성별"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        btLogout.setText("퇴 장");
        btLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        btRename.setText("대화명 변경");
        btRename.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btRenameActionPerformed(evt);
            }
        });

        btExit.setText("종 료");
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
    	sendMsg();// 메세지 보낸다
    	tfChat.setText("");// 메세지 박스 공란
    	tfChat.requestFocus();// 메세지 박스 포커스 이동
    }//
    private void sendMsg(){
		//메세지를 2개로 분류 (귓속말 ,일반말)
    	try {
	    	String msg = tfChat.getText();
	    	msg = msg.replace('|', 'l'); // 
	    	//msg = msg.replace("|", "&#124"); // 
	    	// msg에 혹시 '|' 문자가 포함되어 있다면
	    	// '|'문자를 'l'로 바꾸자.
	    	
	    	if(!isSendOne) { // 귓속말 보내기가 아니라면
		    	String sendMsg = "400|" + foreColor + "|" + msg;
				oos.writeUTF(sendMsg);
				oos.flush();
	    	} else {	// 귓속말 보내기라면
	    		
	    	}
		} catch (IOException e) {
			//e.printStackTrace();
			out.println("sendMsg()에서 예외" + e);
		}
    }

//    private void tfChatActionPerformed(ActionEvent evt) {//
//    }//

    private void btRenameActionPerformed(ActionEvent evt) {
    }
    
    //jmf - 동영상채팅 api지원
    // 버튼 btLogin
    private void btLoginActionPerformed(ActionEvent evt) {
    	// 1. 사용자가 입력한 값 받기 (아이디, 대화명, 성별)
    	id = tfId.getText();
    	chatName = tfChatName.getText();
    	
    	ButtonModel bm = this.buttonGroup1.getSelection();
    	if( bm == raM.getModel() ) {
    		gender = "남자";
    	} else {
    		gender = "여자";
    	}
    	host = tfHost.getText();
    	
    	// 2. 유효성 체크
    	if( id==null || chatName==null || gender==null || host ==null || id.trim().isEmpty()
    			|| id.trim().isEmpty() || chatName.trim().isEmpty()
    			|| gender.trim().isEmpty() || host.trim().isEmpty()
    	)
    	{
    		showMsg("입력 박스에 값을 모두 입력하세요.");
    		tfId.requestFocus();
    		return;
    	}
    		
    	
    	// 3. 값이 유효하다면 채팅방 패널을 보여준다.
    	tabP.setEnabledAt(1, true);
    	tabP.setEnabledAt(0, false);
    	tabP.setSelectedIndex(1);// 대화방 패널 선택
    	this.setTitle(id + "님 입장하셧습니다.\n");
    	
    	
    	// 4. 서버와 채팅하는 스레드를 동작시키자.
    	startChat(); // 채팅시작
    	
    }// private void btLoginActionPerformed-------------
    
    
    
    /*
     * 서버가 보내주는 메시지를 받아서 
     * 각 프로토콜 별로 해석해서 로직을 수행하는 
     * 메소드(parsing)을 호출한다.
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
    			parsing(serverMsg);// 오는메세지 해석용동
    			
    		} catch(Exception e){
    			//out.println( "run()에서 예외 : " + e );
    		}
    	}// while ----------
    }// public void run() ---------------------

    
    
    
    private void parsing(String serverMsg) {
    	// '|' 를 기준으로 serverMsg를 토큰으로 분해하자
    	// 규칙

    	StringTokenizer st= new StringTokenizer(serverMsg, "|");
    	
    	// 첫번째 토큰은 항상 숫자로 시작(규칙)
    	int protocol = Integer.parseInt(st.nextToken()); // 숫자확인 필요

    	switch(protocol){
			// 입장할 때 "100|대화명|아이디|성별"
	    	case 100 : {
	    		String cn = st.nextToken();
	    		String cid = st.nextToken();
	    		String cgen = st.nextToken();
	    		String data[] = {cn, cid, cgen}; // 일차형 배열 // 테이블에 넣기 위해서 배열을 만든다.
	    		DefaultTableModel userModel = (DefaultTableModel)this.userTable.getModel(); // 반환타입이 부모타입이라 (DefaultTableModel)
	    		userModel.addRow(data);
	    		userTable.setModel(userModel);
	    	}
	    	break;
	    	case 400 : {
	    		// 대화내용을 모두에게 보낼때
	    		String fromChat = st.nextToken();
	    		String fontColor = st.nextToken();
	    		String message = st.nextToken();
	    			    		
	    		showTaMsg( fromChat + ">>" + message);
	    	}
	    	break;
	    	case 800 : {
	    		showMsg("대화명이 중복됩니다.\n다시 로그인하세요.");
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
	    	case 810 : {// 로그 아웃. 퇴장 처리
	    		//서버에서 "8100|퇴장하는 사람 id"
	    		String logoutId = st.nextToken();
	    		removeUserList(logoutId, 1);// 사용자테이블에서 사용자 제거
	    	}
	    	break;
	    	case 900 : {// 로그 아웃. 종료 처리
	    		String exitId = st.nextToken();
	    		removeUserList(exitId, 0);// 사용자테이블에서 사용자 제거
	    		
	    	}
	    	break;
    	}
    	
    	// 대화내용을 모두에게 보낼때
    	// "400|대화명|글꼴색|메세지"
	}// private void parsing(String serverMsg)

    
    //
    public void removeUserList(String logoutId, int mode) {
		// userModel에서 삭제하기 위해서 테이블에서 정보 가져오기
		DefaultTableModel userModel = (DefaultTableModel)userTable.getModel();
		
		String tmpChatName="";// 대화명
		for(int i=0; i<userModel.getRowCount(); i++){
			String tmpId = (String)userModel.getValueAt(i, 0);//테이블에서 id위치가 0인곳에서 값 얻어오기
			tmpChatName = (String)userModel.getValueAt(i, 1);
			if( logoutId.equals(tmpId) ){// id찾아 삭제
				userModel.removeRow(i);
				break;
			}
		}//for--------------
		
		
		userTable.setModel(userModel);
		
		String sendMsg = logoutId + " [ " + tmpChatName +" ]님이 퇴장하였습니다.";
		showMsg(sendMsg);
		
		// 퇴장하는 사람이 본인일 경우
		// 채팅방에서 나와 로그인 화면으로 전환처리하자.
		if( logoutId.equals(id) ){
			isStart=false;// 쓰레드 처리
			exitChat(mode);
			// 채팅을 퇴장 또는 종료 처리하는 메소드
			// mode값 1번을 넘기면 퇴장, 0을 넘기면 종료처리
			
			// 퇴장 또는 종료할 경우 채팅방에 입장해 있는
			// User목록을 테이블에서 삭제해주자.
			for( int i=userModel.getRowCount()-1; i>=0; i-- )
			{
				userModel.removeRow(i);// 주의: 삭제시 레코드열을 뒤에서부터 해야된다.(안그럼 에러)
			}
			taMsg.setText("");// 대화내용박스 지우기
		}
//		tabP.setSelectedIndex(0);
//		tabP.setEnabledAt(0, true);
//		tabP.setEnabledAt(1, false);
    }
    
    
    
    
    
    // 채팅을 퇴장 또는 종료 처리하는 메소드
	private void exitChat(int mode) {
			try {
				if( oos!=null ) oos.close();
				if( ois!=null ) ois.close();
				if( sock!=null ) {
					sock.close();
					sock=null;	// 종료할때 소켓여부로 종료하는 코드로 
				}
			} catch (IOException e) {
				out.println("exitChat에서 예외 : " + e); 
				e.printStackTrace();
			}
			
			if(mode==1){// 로그아웃
				tabP.setSelectedIndex(0);// 로그인 패널을 선택
				tabP.setEnabledAt(0, true);// 로그인 패널을 활성화
				tabP.setEnabledAt(1, false);// 대화 패널을 활성화
			} else if(mode==0){// 종료
				this.dispose();
				System.exit(0); // 프로세스 종료
			}
	}//-------------------


	private void startChat() {
		isStart = true;
    	// 내 정보 라벨값 세팅
    	lbId.setText(id);
    	lbChatName.setText(chatName);
    	lbGender.setText(gender);
    	
    	// 소켓연결
    	try {
    		sock = new Socket(host,9999);
    		taMsg.setText("## 서버와 연결됨 ##\n");
    		
    		// oos먼저 생성 => 서버쪽에서는 ois를 먼저 생성했으므로 
    		/// 클에서는 oos를 먼저 생성한다. 안그러면 먹통이 된다.
    		// 서버에서는 1. ObjectInputStream()을 구성 2.ObjectInputStream()
    		oos = new ObjectOutputStream(sock.getOutputStream());// oos먼저 생성
    		ois = new ObjectInputStream(sock.getInputStream());// ois생성
    		
    		oos.writeUTF(id + "|" + chatName + "|" + gender);
    		oos.flush();
    		
    		// 서버의 메시지를 리스닝하는 스레드 동작
    		Thread tr = new Thread(this);
    		tr.start();
    		
    	} catch(Exception e){
    		String msg = "챗서버 연결에 실패했어요.\n";
    		msg += "호스트를 확인하세요.";
    		showMsg(msg);
    		return ;
    	}// try ----------------------
	}// private void startChat() -----------------


	// 스크롤바가 따라 내려가도록
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
    	String message = "퇴장할까요?";
    	 int yn = JOptionPane.showConfirmDialog(this, message, "퇴장확인", JOptionPane.YES_NO_OPTION);
    	 if( yn == JOptionPane.YES_OPTION){
    		 try {
				oos.writeUTF("810|" + id);
				oos.flush();
			} catch (IOException e) {
				out.println("로그아웃 중 예외 : " + e);
				//e.printStackTrace();
			}
    	 }
    }

    
    private void btExitActionPerformed(ActionEvent evt) {
    	exitProc();
    }// btExitActionPerformed ----------------

    
    
    
    private void exitProc() {
    	String message = "채팅을 종료할까요?";
    	int yn = JOptionPane.showConfirmDialog(this, message,
    			"종료확인", JOptionPane.YES_NO_OPTION);
    	if( yn==JOptionPane.YES_OPTION ){
    		
    		out.println("sock==" + sock);
    		if( sock!=null ) {// 접속 하고 종료
    			try {
    				oos.writeUTF("900|");
    				oos.flush();
    			} catch(IOException e){
    				out.println("접속 종료 중 예외 : " + e);
    			}
    		} else { // 접속 안하고 종료
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
