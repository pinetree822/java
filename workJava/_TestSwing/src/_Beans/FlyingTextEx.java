/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Beans;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author kim
 */
public class FlyingTextEx extends javax.swing.JFrame {

    private final int FLYING_UNIT = 10;// 키보드 방향키 한번 누를때의 이동거리
    private JLabel la = new JLabel("HELLO");// 레이블 제목
    
    /**
     * Creates new form FlyingTextEx
     */
    public FlyingTextEx() {
        initComponents();
        
        Container c = getContentPane();
        c.setLayout(null);
        c.addKeyListener(new MyKeyListener());
        
        la.setLocation(50, 50);
        la.setSize(100, 20);
        c.add(la);
        
        setSize(300, 300);
        setVisible(true);
        
        c.setFocusable(true);
        c.requestFocus();
        
        // 컨텐트팬에서 포커를 잃어서 
        // 다시 마우스를 클릭햇을때 해당하는 컴포넌트종류들 중 한개에게
        // 포커스를 주어야 할 경우
        c.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                Component c = (Component)e.getSource();// 마우스가 클릭된 컴포넌트
                c.setFocusable(true);
                c.requestFocus();// 컴포넌트에게 포커스 설정
            }// mouseClicked()
        });// addMouseListener()
        //        
    }// FlyingTextEx()
    
    
    // 키보드 입력에 대한
    // KeyAdapter 상속 확장하여 키누름에 대한 것만 처리
    // keyPressed처리만
    class MyKeyListener extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e) {
            // 입력된 키의 키코드를 알아낸다.
            int keyCode = e.getKeyCode();
            
            // 키 코드 값(keyCode)에 따라 상,하,좌,우 키를 판별하고
            // la의 위치를 이동시킨다.
            switch(keyCode)
            {
                case KeyEvent.VK_UP:
                    la.setLocation(la.getX(), la.getY()-FLYING_UNIT); break;
                case KeyEvent.VK_DOWN:
                    la.setLocation(la.getX(), la.getY()+FLYING_UNIT); break;
                case KeyEvent.VK_LEFT:
                    la.setLocation(la.getX()-FLYING_UNIT, la.getY()); break;
                case KeyEvent.VK_RIGHT:
                    la.setLocation(la.getX()+FLYING_UNIT, la.getY()); break;
            }// switch
        }// keyPressed
    }// MyKeyListener
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("상,하,좌,우 키를이용하여 텍스트 움직이기");
        setMinimumSize(new java.awt.Dimension(300, 300));
        setSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(FlyingTextEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlyingTextEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlyingTextEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlyingTextEx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlyingTextEx().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
