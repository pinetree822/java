/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Beans._14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author kim
 */
public class MyDialog extends JDialog {
    
    private JTextField tf = new JTextField(10);     // 다이얼로그에 삽입할 텍스트 필드
    private JButton okButton = new JButton("OK");   // 다이얼로그에 삽입할 OK 버튼

    public MyDialog(JFrame frame, String title) {
        super(frame, title);
        setLayout(new FlowLayout());
        add(tf);
        add(okButton);
        setSize(200, 100);
        
        // 다이얼로그의 OK버튼에 Action리스너 달기
        // OK버튼이 선택되면 다이얼로그가 화면에서 사라진다.
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);// 다이얼로그 사라짐
            }// actionPerformed()
        });// addActionListener()
        
    }// class MyDialog
    
    
    
    
    
    
}
