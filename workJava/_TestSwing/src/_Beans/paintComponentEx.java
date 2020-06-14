/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Beans;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author kim
 */
public class paintComponentEx extends javax.swing.JFrame {
    
    class MyButton extends JButton {
        public MyButton(String s) {
            super(s);// JButton의 생성자 호출
        }// MyButton()

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth()-1, getHeight()-1);
//            g.drawOval(TOP, TOP, WIDTH, HEIGHT);
        }// paintComponent()
    }// class MyButton
    
    
    
    /**
     * Creates new form paintComponentEx
     */
    public paintComponentEx() {
        initComponents();
        MyButton b = new MyButton("New Button");
        //b.setOpaque(rootPaneCheckingEnabled);
        b.setOpaque(true);// 투명화
        b.setBackground(Color.CYAN);// 배경색
        
        Container c = getContentPane();// 현재 컨테이나 객체 얻어오기
        c.add(b);// 컨테이너에 버튼 추가
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("새로운 버튼 만들기");
        setMinimumSize(new java.awt.Dimension(250, 200));
        setPreferredSize(new java.awt.Dimension(250, 200));
        setSize(new java.awt.Dimension(250, 200));
        getContentPane().setLayout(new java.awt.FlowLayout());

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
            java.util.logging.Logger.getLogger(paintComponentEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paintComponentEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paintComponentEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paintComponentEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new paintComponentEx().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
