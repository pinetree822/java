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
    
    private JTextField tf = new JTextField(10);     // ���̾�α׿� ������ �ؽ�Ʈ �ʵ�
    private JButton okButton = new JButton("OK");   // ���̾�α׿� ������ OK ��ư

    public MyDialog(JFrame frame, String title) {
        super(frame, title);
        setLayout(new FlowLayout());
        add(tf);
        add(okButton);
        setSize(200, 100);
        
        // ���̾�α��� OK��ư�� Action������ �ޱ�
        // OK��ư�� ���õǸ� ���̾�αװ� ȭ�鿡�� �������.
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);// ���̾�α� �����
            }// actionPerformed()
        });// addActionListener()
        
    }// class MyDialog
    
    
    
    
    
    
}
