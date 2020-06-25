package memo_jdbc;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MemoGUI extends javax.swing.JFrame {

    /**
     * Creates new form MemoGUI
     */
    private MemoDAO dao;
    
    public MemoGUI() {
        initComponents();
        this.dao = new MemoDAO();
        all();// ����Ʈ �ҷ�����
        
        // ������ �̺�Ʈ ó��
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dao.dbClose();
                System.exit(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tp = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        tfMsg = new javax.swing.JTextField();
        lbWdate = new javax.swing.JLabel();
        btInsert = new javax.swing.JButton();
        btList = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btUpdateOk = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        lbIdx = new javax.swing.JLabel();
        btFindMove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taList = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        comboType = new javax.swing.JComboBox<>();
        tfFind = new javax.swing.JTextField();
        btFind = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::: ���� �޸��� :::");

        jLabel1.setFont(new java.awt.Font("���� ����", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("::: ���� �޸��� :::");

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        tfName.setBorder(javax.swing.BorderFactory.createTitledBorder("�ۼ���"));
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        tfMsg.setBorder(javax.swing.BorderFactory.createTitledBorder("�޸� ����"));

        lbWdate.setText("2016�� 10�� 20��");
        lbWdate.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "�ۼ���"));

        btInsert.setMnemonic('I');
        btInsert.setText("�۾���");
        btInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertActionPerformed(evt);
            }
        });

        btList.setMnemonic('L');
        btList.setText("�۸��");
        btList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListActionPerformed(evt);
            }
        });

        btDelete.setText("�ۻ���");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdateOk.setText("����");
        btUpdateOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateOkActionPerformed(evt);
            }
        });

        btUpdate.setText("�ۼ���");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        lbIdx.setBorder(javax.swing.BorderFactory.createTitledBorder("��ȣ"));

        btFindMove.setText("�˻�");
        btFindMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindMoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMsg)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbIdx, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbWdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btUpdateOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFindMove)
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbWdate, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(tfName))
                    .addComponent(lbIdx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                .addComponent(tfMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInsert)
                    .addComponent(btList)
                    .addComponent(btDelete)
                    .addComponent(btUpdateOk)
                    .addComponent(btUpdate)
                    .addComponent(btFindMove))
                .addContainerGap())
        );

        tfName.getAccessibleContext().setAccessibleDescription("");
        btDelete.getAccessibleContext().setAccessibleName("btDelete");
        lbIdx.getAccessibleContext().setAccessibleName("��ȣ");

        taList.setEditable(false);
        taList.setColumns(20);
        taList.setRows(5);
        taList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jScrollPane1.setViewportView(taList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp.addTab("�޸���", jPanel2);

        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "�ۼ���", "�޸𳻿�", "�۹�ȣ" }));
        comboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeActionPerformed(evt);
            }
        });

        btFind.setText("�۰˻�");
        btFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "�۹�ȣ", "�ۼ���", "�޸𳻿�", "�ۼ���"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton2.setText("�۾���");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btAll.setText("��ü��");
        btAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAll)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFind)
                    .addComponent(btAll))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfFind.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tp.addTab("�޸�˻�", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tp)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // �۸���Ʈ ��ư
    private void btListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListActionPerformed
        showMsg("�۸�� ������ ��������.!"); 
        all();// ����Ʈ ����
    }//GEN-LAST:event_btListActionPerformed

    
    // �۾��� ��ư
    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {
        // 1.�ۼ���.�Ÿ𳻿밪 �޾ƿ���(tfName, tfMsg);
        // 2.��ȿ�� üũ(���ڿ�)
        // 3.dao�� insertMemo()�޼ҵ忡 �ۼ���, �޸𳻿밪 �ѱ��
        // 4.��ȯ�� �޾Ƽ� true�� ��ȯ�Ǹ� "�� ��� ����" �޽��� �����ֱ�  
        String name = tfName.getText();
        String msg = tfMsg.getText();
        
        if(name==null || name.trim().equals("")){                                   
            showMsg("�ۼ��ڸ� �Է��ϼ���.");
            tfName.requestFocus();
            return;
        }
        if( msg==null || msg.length()>100 ){                                   
            showMsg("�޸𳻿��� 0~100�� �̳����� �ؿ�.");
            tfMsg.requestFocus();
            return;
        }        
        
        MemoDTO memo = new MemoDTO();
        memo.setName(name);
        memo.setMsg(msg);
        boolean bool = dao.insertMemo2(memo);								// ����Ŭ ���ν��� �̿��� �޸𾲱�
        //String str = dao.insertMemo(memo) ? "��ϼ���" : "��Ͻ���";		// �����ڹ� �̿��� �޸𾲱�
        //showMsg(str);
        clearTf();
        
        all();// ����Ʈ ����
    }
    
    public void all(){
        Vector<MemoDTO> allV = dao.selectAllMemo();
        if( allV != null )
        {
            taList.setText(allV.size() + "���� ���� �־��.");
            // ���� allV�� �ݺ��� ���鼭 MemoDTO�� ������
            // �۹�ȣ, �ۼ���, �޸�, �ۼ��� ���� taList�� �����̱�
            String str = "";
            for(MemoDTO m:allV){
                str += m.getIdx() +"\t" + m.getName() +"\t" + m.getMsg() +"\t" + m.getWdate() ;                
                str += "\r\n";
            }
            taList.setText(str);
        }
    }

    /// ������ ������ ������ jtable�� �����ִ� �޼���
    private void showTable(Vector<MemoDTO> mv){
        // ������ => �� DefaultTableModel
        Object[][] data = new Object[mv.size()][4];
        for(int i=0; i<data.length; i++)
        {
            MemoDTO m = mv.get(i);
            data[i][0] = m.getIdx();
            data[i][1]=m.getName();
            data[i][2]=m.getMsg();
            data[i][3]=m.getWdate();
        }
        String[] colNames = {"�۹�ȣ", "�ۼ���", "�޸𳻿�", "�ۼ���"};
        
        // �𵨱��� Ʋ�� ����ֱ�
        DefaultTableModel model = new DefaultTableModel(data, colNames);// data 2�����迭 ����Ʈ, colNames 1�����迭 ����
        
        // View�� Model�� ����
        table.setModel(model);
        
    }
    // �˻����� ��ü�� ��ư ������ ��ü �� ��������
    private void allTable() {
        Vector<MemoDTO> allV = dao.selectAllMemo();
        showTable(allV);
    }
    
    // �ؽ�Ʈ �ڽ� ����� �̸��� ���콺 �ø���
    public void clearTf(){
        tfName.setText("");
        tfMsg.setText("");
        tfName.requestFocus();
    }
    
    // �޼��� ����
    public void showMsg(String msg){                                   
            JOptionPane.showMessageDialog(this,msg);
    }
    
    /*
    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertActionPerformed

        //Object o= evt.getSource();
        String name = tfName.getText().trim();
        String msg = tfMsg.getText().trim();
        
        JOptionPane.showMessageDialog(this,"tfName = " + name + ",tfMsg = " + msg);
        try {
            boolean isRs = this.dao.insertMemo(name, msg);            
            JOptionPane.showMessageDialog(this,"isRs = " + isRs);   
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MemoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MemoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btInsertActionPerformed
    */
    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
    }//GEN-LAST:event_tfNameActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
         // 1. ������ �� ��ȣ�� �Է¹޴´�.
         String strIdx;
         strIdx = JOptionPane.showInputDialog("������ �� ��ȣ�� �Է��ϼ���.");
         if(strIdx==null) return;
         
         // 2. dao�� ���� ó�� �޼ҵ� ȣ��
         boolean bool = dao.deleteMemo(Integer.parseInt(strIdx.trim()));
         if(bool == true) showMsg("�� "+ strIdx +"��ȣ�� ������ �Ͽ����ϴ�.");
         else showMsg("�� "+ strIdx +"��ȣ�� ���� ���Ͽ����ϴ�.");
         
         
         all();// ����Ʈ ����
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        // 1. ������ �� ��ȣ�� �Է¹޴´�.
        String strIdx = JOptionPane.showInputDialog("������ �۹�ȣ�� �Է��ϼ���.");
        if(strIdx==null) return ;
        
        // 2. �ش� �� ������ dao���� �޾ƿ´�.
        MemoDTO m = dao.selectMemoByIdx(Integer.parseInt(strIdx.trim()));
        
        // 3. tfName, tfMsg�� �ش� ������ �����ش�.
        if(m!=null) {
            lbIdx.setText(String.valueOf(m.getIdx()));   // ��ȣ
            tfName.setText(m.getName());// �ۼ���
            tfMsg.setText(m.getMsg());// �޸𳻿�
            lbWdate.setText(m.getWdate().toString());// �ۼ���
        } else {
            showMsg(strIdx + "�� ���� �������� �ʾƿ�.");
        }
        all();
    }//GEN-LAST:event_btUpdateActionPerformed
    
    private void btUpdateOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateOkActionPerformed
        // ������ �� �޾ƿ���(�ۼ���, �޸𳻿�)
        // 2.��ȿ�� üũ(���ڿ�)
        // 3.dao�� insertMemo()�޼ҵ忡 �ۼ���, �޸𳻿밪 �ѱ��
        // 4.��ȯ�� �޾Ƽ� true�� ��ȯ�Ǹ� "�� ��� ����" �޽��� �����ֱ�  
        
        try {
                    
            // 1.������ �� �޾ƿ���(tfName, tfMsg);
            int idx = Integer.parseInt(lbIdx.getText().trim());
            String name = tfName.getText();
            String msg = tfMsg.getText();
        
            // 2. MemoDTO��ü�� ������ �� ��ƿ���
            MemoDTO memo = new MemoDTO(idx, name, msg, null);
        
        // 3. dao�� updateMemo(memo)ȣ��
            boolean bool = dao.updateMemo(memo);
            String str = (bool)?"��������":"��������";
            showMsg(str);
            clearTf();

            all();// ����Ʈ ����
        } catch (NumberFormatException e){
             showMsg("�۹�ȣ�� �Է��ϼ���.");
        }
        
//
//        if(lbIdx.getText()==null || lbIdx.getText().trim().equals("")){                                   
//            showMsg("�ۼ��ڸ� �Է��ϼ���.");
//            tfName.requestFocus();
//            return;
//        }        
//        if(name==null || name.trim().equals("")){                                   
//            showMsg("�ۼ��ڸ� �Է��ϼ���.");
//            tfName.requestFocus();
//            return;
//        }
//        if( msg==null || msg.length()>100 ){                                   
//            showMsg("�޸𳻿��� 0~100�� �̳����� �ؿ�.");
//            tfMsg.requestFocus();
//            return;
//        }        
//        
//        MemoDTO memo = new MemoDTO();
//        memo.setIdx(idx);
//        memo.setName(name);
//        memo.setMsg(msg);
//        //boolean bool = dao.insertMemo(name, msg);
//        String str = dao.updateMemo(memo) ? "���漺��" : "�������";




    }//GEN-LAST:event_btUpdateOkActionPerformed

    private void comboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeActionPerformed
        // �˻��з���
    }//GEN-LAST:event_comboTypeActionPerformed

    private void btFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindActionPerformed
        // �۰˻�
        find();
    }//GEN-LAST:event_btFindActionPerformed
    public void find() {
        // 1. �˻� ������ ������ => comboType���� ����
        int index = comboType.getSelectedIndex();       
        if( index<0 ) return;                           // �ۼ��� => 0 �޽���=>1 �۹�ȣ=>2
            
        // 2. �˻��� ������
        String keyword = this.tfFind.getText();
        if(keyword==null || keyword.trim().equals("")){
            showMsg("�˻�� �Է��ϼ���.");
            tfFind.requestFocus();
            return;
        }
        
        // 3. dao�� findMemo(�˻�����, �˻���) ȣ��
        Vector<MemoDTO> mv=dao.findMemo(index, keyword);//********findMemo()
        
        // 4. ����� �޾Ƽ� table�� ȣ��
        if(mv!=null){
            showTable(mv);/// showTable()
        }
        
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // �۾��� �̵�
        tp.setSelectedIndex(0);//
        tfName.requestFocus();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btFindMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindMoveActionPerformed
        // �˻� �̵�
        tp.setSelectedIndex(1);//
        tfFind.requestFocus();// ��Ŀ�� �����̵�
    }//GEN-LAST:event_btFindMoveActionPerformed

    private void btAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAllActionPerformed
        // �۰˻����� ��ü�� ����
        allTable();
    }//GEN-LAST:event_btAllActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(MemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAll;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btFind;
    private javax.swing.JButton btFindMove;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btList;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btUpdateOk;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbIdx;
    private javax.swing.JLabel lbWdate;
    private javax.swing.JTextArea taList;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfFind;
    private javax.swing.JTextField tfMsg;
    private javax.swing.JTextField tfName;
    private javax.swing.JTabbedPane tp;
    // End of variables declaration//GEN-END:variables

}