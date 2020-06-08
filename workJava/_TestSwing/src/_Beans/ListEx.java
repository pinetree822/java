/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Beans;

import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author kim
 */
public class ListEx extends javax.swing.JFrame {

    private String fruits[]= {
        "apple","banana","kiwi","mango","pear",
        "peach","berry","strawberry","blackberry"};
    
    private ImageIcon images[] = {
        new ImageIcon("images/icon1.png"),
        new ImageIcon("images/icon2.png"),
        new ImageIcon("images/icon3.png"),
        new ImageIcon("images/icon4.png")
    };
    
    /**
     * Creates new form ListEx
     */
    public ListEx() {
        initComponents();
        
        
        
    }

    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        strList = new JList<String>(fruits);
        imageList = new JList<ImageIcon>();
        imageList.setListData(images);
        jScrollPane3 = new javax.swing.JScrollPane();
        scrollList = new JList<String>(fruits);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("����Ʈ ����� ����");
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));
        setSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(new java.awt.FlowLayout());
        getContentPane().add(strList);
        getContentPane().add(imageList);

        jScrollPane3.setViewportView(scrollList);

        getContentPane().add(jScrollPane3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ListEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEx().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<ImageIcon> imageList;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> scrollList;
    private javax.swing.JList<String> strList;
    // End of variables declaration//GEN-END:variables
}