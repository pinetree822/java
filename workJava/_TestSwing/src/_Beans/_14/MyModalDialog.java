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
public class MyModalDialog extends JDialog {
    private JTextField tf = new JTextField(10);
    private JButton okButton = new JButton("OK");

    public MyModalDialog(JFrame frame, String title) {
        super(frame, title, true);
        setLayout(new FlowLayout());
        add(tf);
        add(okButton);
        setSize(200, 100);
        
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }// MyModalDialog()
    
    // �ؽ�Ʈ�ʵ� â�� ����ڰ� �Է��� ���ڿ��� �����Ѵ�.
    // �Էµ� ������ ������ null�� �����Ѵ�.
    public String getInput(){
        if(tf.getText().length()==0) return null;
        else return tf.getText();
    }// getInput()
    
}// class MyModalDialog
