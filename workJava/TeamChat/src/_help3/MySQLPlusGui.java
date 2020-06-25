package _help3;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;


public class MySQLPlusGui extends javax.swing.JFrame {

	Connection con;
	Statement st;
	ResultSet rs;
	
    public MySQLPlusGui() {
        initComponents();
        tfHost.setText("127.0.0.1");
        jTextField1.setText("scott");
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent e){
        		DBUtil.close(rs,st,con);
        		System.exit(0);
        	}
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        tfUser = new javax.swing.JPanel();
        tfHost = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        tfPwd = new javax.swing.JPasswordField();
        btCon = new javax.swing.JButton();
        lbResult = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        tfSql = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(":::MySQLPlusGUI v1.1:::");

        tfHost.setBorder(javax.swing.BorderFactory.createTitledBorder("호스트"));
        tfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHostActionPerformed(evt);
            }
        });

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("사용자"));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        tfPwd.setBorder(javax.swing.BorderFactory.createTitledBorder("비밀번호"));

        btCon.setMnemonic('C');
        btCon.setText("DB연결");
        btCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mysqlplus/MC2.PNG"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout tfUserLayout = new javax.swing.GroupLayout(tfUser);
        tfUser.setLayout(tfUserLayout);
        tfUserLayout.setHorizontalGroup(
            tfUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tfUserLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tfUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tfUserLayout.createSequentialGroup()
                        .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCon, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tfUserLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField1, tfPwd});

        tfUserLayout.setVerticalGroup(
            tfUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tfUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tfUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tfUserLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(tfUserLayout.createSequentialGroup()
                        .addGroup(tfUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tfUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btCon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tfUserLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField1, tfHost, tfPwd});

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        tfSql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSqlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tfUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSql, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfSql, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHostActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConActionPerformed
    	//호스트, 유저,pwd받기
    	String host=tfHost.getText();
    	/*if(host==null||host.trim().isEmpty()){
    		host="localhost";
    	}*/
    	String user=jTextField1.getText();
    	char ch[]=tfPwd.getPassword();
    	String pwd=new String(ch,0,ch.length);
    	String strUrl="jdbc:oracle:thin:@"+host+":1521:ORCL";
    	DBUtil.setUrl(strUrl);
    	DBUtil.setUser(user);
    	DBUtil.setPwd(pwd);
    	try{
    	con=DBUtil.getCon();
    	lbResult.setText("DB연결 성공");
    	}catch(Exception e){
    		lbResult.setText(e.getMessage());    		
    	}

    }//---------------------------------

    private void tfSqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSqlActionPerformed
    	execute();
    }//---------------------------------
    
    private void execute(){
    	//tfSql에 입력받은 sql문을 얻어온다.
    	String sql=tfSql.getText();
    	int index=sql.indexOf(";"); //
    	if(index!=-1){
    		sql=sql.substring(0, index);
    	}
    	if(sql.trim().isEmpty()){
    		return;
    	}
    	try{
    	//st를 얻어
    	st=con.createStatement();
    	//sql문을 실행시킨다.==> boolean execute(String sql)
    	boolean bool=st.execute(sql);
    	if(bool){//SELECT문
    		rs=st.getResultSet();
    		printResultSet(rs);    		
    		if(rs!=null) rs.close();
    	}else{//SELECT가 아닌 문장
    		//SQL문에 의해 영향받은 레코드수를 출력하자
    		int cnt=st.getUpdateCount();
    		lbResult.setText("결과: "+cnt+"개의 레코드가 변경됐어요");
        	lbResult.setForeground(Color.blue);
    	}
    	
    	if(st!=null) st.close();
    	//결과값을 lbResult에 출력해보기
    	}catch(SQLException e){
    		lbResult.setText(e.getMessage());
    		lbResult.setForeground(Color.red);
    	}
    	
    }//------------------------------------


    private void printResultSet(ResultSet rs) 
    throws SQLException
    {
    	//1. 컬럼정보를 얻기 위해 ResultSetMetaData를 얻어온다.
    	ResultSetMetaData rsmd=rs.getMetaData();    	
    	//2. rsmd를 통해 컬럼수를 알아낸다.
    	int colCount=rsmd.getColumnCount();
    	
    	//3. 컬럼명을 담아줄 1차원 배열을 생성하자.
    	String[] colNames=new String[colCount];
    	
    	//4. 반복문 돌면서 컬럼명을 알아내어 배열에 저장하자.
    	for(int i=0;i<colCount;i++){
    		colNames[i]=rsmd.getColumnName(i+1);
    	}
    	
    	DefaultTableModel model=new DefaultTableModel();
    	model.setColumnIdentifiers(colNames);
    	
    	String[] data=new String[colCount];
    	//레코드 데이터를 담을 배열
    	while(rs.next()){
	    	for(int i=0;i<colCount;i++){
	    		String colData=rs.getString(i+1);
	    		data[i]=colData;
	    	}
	    	model.addRow(data);//레코드 추가
    	}//while---------
    	
    	table.setModel(model);
    	lbResult.setText("");
    	
	}//-------------------------------


	public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            	
                if ("Numbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MySQLPlusGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MySQLPlusGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MySQLPlusGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MySQLPlusGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MySQLPlusGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbResult;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfHost;
    private javax.swing.JPasswordField tfPwd;
    private javax.swing.JTextField tfSql;
    private javax.swing.JPanel tfUser;
    // End of variables declaration//GEN-END:variables
}
