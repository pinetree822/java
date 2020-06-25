/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _javachat;
import static java.lang.System.out;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JavaChatGui extends javax.swing.JFrame 
implements Runnable{

	private Socket sock;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	private String id,chatName,gender, host;
	private boolean isSendOne=false;//귓속말 보내기에 사용
	private int foreColor=Color.black.getRGB();

    public JavaChatGui() {
        initComponents();
        //로그인 하지 않으면 채팅방에 못들어오도록
        tabP.setEnabledAt(1, false);
        
        //창닫기 이벤트 처리---
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent e){
        		exitProc();
        	}
        });
        
    }//생성자--------------------

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        tabP = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfChatName = new javax.swing.JTextField();
        raM = new javax.swing.JRadioButton();
        raF = new javax.swing.JRadioButton();
        tfHost = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMsg = new javax.swing.JTextArea();
        tfChat = new javax.swing.JTextField();
        chk = new javax.swing.JCheckBox();
        comboColor = new javax.swing.JComboBox<>();
        lbView = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        lbChatName = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        btLogout = new javax.swing.JButton();
        btRename = new javax.swing.JButton();
        btExit = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("::Cacao Chatting V1.1:::");
        setBounds(new java.awt.Rectangle(150, 50, 0, 0));
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Plantagenet Cherokee", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(":::Cacao Chatting App :::");

        jPanel4.setBackground(new java.awt.Color(153, 204, 0));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("아이디");

        jLabel3.setText("대화명");

        jLabel4.setText("성   별");

        jLabel5.setText("호스트");

        raM.setBackground(new java.awt.Color(153, 204, 0));
        buttonGroup1.add(raM);
        raM.setSelected(true);
        raM.setText("남자");

        raF.setBackground(new java.awt.Color(153, 204, 0));
        buttonGroup1.add(raF);
        raF.setText("여자");

        tfHost.setText("localhost");

        btLogin.setBackground(new java.awt.Color(204, 153, 255));
        btLogin.setText("연  결");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btCancel.setBackground(new java.awt.Color(153, 0, 153));
        btCancel.setText("취   소");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfId)
                    .addComponent(tfChatName)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(raM)
                        .addGap(28, 28, 28)
                        .addComponent(raF))
                    .addComponent(tfHost, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btLogin)
                        .addGap(29, 29, 29)
                        .addComponent(btCancel)))
                .addGap(21, 21, 21))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfChatName, tfHost, tfId});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancel, btLogin});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfChatName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(raM)
                        .addComponent(raF)))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancel)
                    .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfChatName, tfHost, tfId});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancel, btLogin});

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Desktop\\banner.JPG")); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabP.addTab("로그인", jPanel1);

        taMsg.setEditable(false);
        taMsg.setColumns(20);
        taMsg.setRows(5);
        taMsg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 4, true));
        jScrollPane2.setViewportView(taMsg);

        tfChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChatActionPerformed(evt);
            }
        });

        chk.setText("귓속말");

        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "검정색", "파랑색", "빨강색", "초록색", "핑크색", "오렌지색", " " }));
        comboColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboColorItemStateChanged(evt);
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
                        .addGap(21, 21, 21)
                        .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbView, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 155, Short.MAX_VALUE))
                    .addComponent(tfChat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfChat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chk)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbView, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tabP.addTab("채팅방", jPanel2);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "아이디", "대화명", "성   별"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("My Info"));

        jLabel7.setText("아  이  디");

        jLabel8.setText("대  화  명");

        jLabel9.setText("성       별");

        lbId.setForeground(new java.awt.Color(204, 0, 51));

        lbChatName.setForeground(new java.awt.Color(204, 0, 102));

        lbGender.setForeground(new java.awt.Color(204, 0, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbChatName)
                    .addComponent(lbId)
                    .addComponent(lbGender))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addGap(21, 21, 21)
                .addComponent(lbChatName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(20, 20, 20)
                .addComponent(lbGender))
        );

        btLogout.setText("퇴   장");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        btRename.setText("대화명 변경");
        btRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRenameActionPerformed(evt);
            }
        });

        btExit.setText("종    료");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabP, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btRename)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExit)
                        .addGap(0, 35, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabP))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btRename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
    	//1. 사용자가 입력한 값 받기 (아이디, 대화명, 성별)
    	id=tfId.getText();
    	chatName=tfChatName.getText();
    	ButtonModel bm=this.buttonGroup1.getSelection();
    	if(bm==raM.getModel()){
    		gender="남자";
    	}else{
    		gender="여자";
    	}
    	host=tfHost.getText();
    	//2. 유효성 체크
    	if(id==null||chatName==null||gender==null||host==null
    			||id.trim().isEmpty()||chatName.trim().isEmpty()
    			||gender.trim().isEmpty()
    			||host.trim().isEmpty())
    	{
    		showMsg("입력 박스에 값을 모두 입력하세요");
    		tfId.requestFocus();
    		return;
    	}
    	
    	
    	//3. 값이 유효하다면 채팅방 패널을 보여준다.
    	tabP.setEnabledAt(1, true);
    	tabP.setEnabledAt(0, false);
    	tabP.setSelectedIndex(1);
    	this.setTitle(id+"님 ["+chatName+"]");
    	
    	//4. 서버와 채팅하는 스레드를 동작시키자.
    	startChat();//채팅 시작

    }//--------------------------------------
    
    public void startChat(){
    	//내 정보 라벨값 세팅
    	lbId.setText(id);
    	lbChatName.setText(chatName);
    	lbGender.setText(gender);
    	try {
    		sock=new Socket(host,9999);
    		taMsg.setText("##서버와 연결됨###");
    		//oos먼저 생성=> 서버쪽에서 ois를 먼저 생성했으므로
    		//클에서는 oos를 먼저 생성한다. 안그러면 먹통이 됨
    		
    		oos=new ObjectOutputStream(sock.getOutputStream());
    		//ois생성
    		ois=new ObjectInputStream(sock.getInputStream());
    		
    		oos.writeUTF(id+"|"+chatName+"|"+gender);
    		oos.flush();
    		//서버의 메시지를 리스닝하는 스레드 동작
    		Thread tr=new Thread(this);
    		tr.start();
    		
		} catch (Exception e) {
			String msg="챗서버 연결에 실패했어요\n";
			msg+="호스트를 확인하세요";
			showMsg(msg);
			return;
		}
    }//--------------------------------------
    
    /**서버가 보내주는 메시지를 받아서
     * 각 프로토콜 별로 해석해서 로직을 수행하는
     * 메소드(parsing)을 호출한다.
     * */
    @Override
    public void run(){
    	while(true){
    		try {
    			String serverMsg=ois.readUTF();
    			out.println("run() serverMsg="+serverMsg);
    			if(serverMsg==null) return;
				parsing(serverMsg);
			} catch (Exception e) {
				out.println("run()에서 예외: "+e);
			}
    	}//while----------
    }//--------------------------------------
    private void parsing(String serverMsg) {
    	//'|' 를 기준으로 serverMsg를 토큰으로 분해하자
    	
    	StringTokenizer st
    	=new StringTokenizer(serverMsg,"|");
    	int protocol=Integer.parseInt(st.nextToken());
    	//첫번째 토큰은 항상 숫자로 시작(규칙)
    	switch(protocol){
	    	// 입장할 때 "100|대화명|아이디|성별"
	    	case 100:{
	    		String cn=st.nextToken();
	    		String cid=st.nextToken();
	    		String cgen=st.nextToken();
	    		String data[]={cn,cid,cgen};
	    		DefaultTableModel userModel
	    		=(DefaultTableModel)this.userTable.getModel();
	    		userModel.addRow(data);
	    		userTable.setModel(userModel);
	    	}break;
	    	
	    	case 400:{
	    	// 대화내용을 모두에게 보낼때
	    	// "400|대화명|글꼴색|메시지"
	    		String fromChat=st.nextToken();
	    		String fontColor=st.nextToken();
	    		String message=st.nextToken();
	    	
	    		showTaMsg("\n"+fromChat+">>"+message);
	    		
	    	}break;
	    	case 800:{
	    		showMsg("대화명이 중복됩니다.\n다시 로그인하세요");	 
	    		tabP.setSelectedIndex(0);
	    		tabP.setEnabledAt(0, true);
	    		tabP.setEnabledAt(1, false);
	    	}break;
	    	case 810:{//로그아웃-퇴장 처리
	    		//서버에서 "810|퇴장하는사람id"
	    		String logoutId=st.nextToken();
	    		removeUserList(logoutId,1);
	    	}break;
	    	case 900:{
	    		String exitId=st.nextToken();
	    		removeUserList(exitId,0);
	    	}
    	}//switch-----------
	}//--------------------------------
    
    public void removeUserList(String logoutId, int mode){
    	//userModel에서 삭제
		DefaultTableModel userModel
		=(DefaultTableModel)userTable.getModel();
		String tmpChatName="";//대화명
		for(int i=0;i<userModel.getRowCount();i++){
			String tmpId=(String)userModel.getValueAt(i, 0);
			tmpChatName=(String)userModel.getValueAt(i, 1);
			if(logoutId.equals(tmpId)){
				userModel.removeRow(i);
				break;
			}
		}//for-----------
		userTable.setModel(userModel);
		
		String sendMsg
		=logoutId+" ["+tmpChatName+"]님이 퇴장하였습니다.";
		showTaMsg(sendMsg);
		//퇴장하는 사람이 본인일 경우
		//채팅방에서 나와 로그인 화면으로 전환처리하자.
		if(logoutId.equals(id)){
			exitChat(mode);
			//채팅을 퇴장 또는 종료 처리하는 메소드
			//mode값 1번을 넘기면 퇴장, 0을 넘기면 종료처리
		}
    }

    /**채팅을 퇴장 또는 종료 처리하는 메소드*/
	private void exitChat(int mode) {
		try{
			if(oos!=null) oos.close();
			if(ois!=null) ois.close();
			if(sock!=null){
				sock.close();
				sock=null;
			}
		}catch(IOException e){
			out.println("exitChat()에서 예외: "+e);
		}
		if(mode==1){//로그아웃
			tabP.setSelectedIndex(0);//로그인 패널을 선택
			tabP.setEnabledAt(0, true);//로그인 패널 활성화
			tabP.setEnabledAt(1, false);//대화 패널 비활성화
		}else if(mode==0){//종료
			this.dispose();
			System.exit(0);//프로세스 종료
		}
	}//--------------------------------


	private void showTaMsg(String msg) {
		taMsg.append(msg);
		//스크롤바가 따라 내려가도록
		taMsg.setCaretPosition(taMsg.getText().length());
	}


	private void showMsg(String msg) {
    	JOptionPane.showMessageDialog(this, msg);
	}//--------------------------------------

	private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed

    }//--------------------------------------

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {
    	String message="퇴장할까요?";
    	int yn
    	=JOptionPane.showConfirmDialog(this, message,
    			"퇴장확인",JOptionPane.YES_NO_OPTION);
    	if(yn==JOptionPane.YES_OPTION){
    		try{
    		oos.writeUTF("810|"+id);
    		oos.flush();
    		}catch(IOException e){
    			out.println("로그아웃 중 예외: "+e);
    		}
    	}

    }//--------------------------------------

    private void btRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRenameActionPerformed

    }//--------------------------------------

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
    	exitProc();
    }//--------------------------------------
    public void exitProc(){
    	String message="채팅을 종료할까요?";
    	int yn=JOptionPane.showConfirmDialog(this, message,
    			"종료확인", JOptionPane.YES_NO_OPTION);
    	if(yn==JOptionPane.YES_OPTION){
    			out.println("sock=="+sock);
    			//접속 하고 종료
    			if(sock!=null){
    				try{
    				oos.writeUTF("900|");
    				oos.flush();
    				}catch(IOException e){
    					out.println("접속 종료 중 예외: "+e);
    				}
    			}else{    			
    			//접속 안하고 종료
    				exitChat(0);
    			}
    	}
    }//----------------------------------------
    
    private void tfChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChatActionPerformed
    	sendMsg();
    	tfChat.setText("");
    	tfChat.requestFocus();
    }//--------------------------------------    
    private void sendMsg(){
    	try {
    		String msg=tfChat.getText();
    		//msg 에 혹시 '|' 문자가 포함되어 있다면
    		//'|'문자를 'l'로 바꾸자.    		
    		msg=msg.replace('|', 'l');
    		setTitle(msg);
    		
    		if(!isSendOne){
	    		//귓속말 보내기가 아니라면
	        	String sendMsg="400|"+foreColor+"|"+msg;
	        	oos.writeUTF(sendMsg);
	        	oos.flush();
    		}else{
    			//귓속말 보내기라면
    		}
        	
		} catch (Exception e) {
			out.println("sendMsg()에서 예외: "+e);
		}
    }//-----------------------------------

    private void comboColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboColorItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboColorItemStateChanged

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
            java.util.logging.Logger.getLogger(JavaChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JTextField tfChat;
    private javax.swing.JTextField tfChatName;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfId;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
