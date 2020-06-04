/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Beans;

//import javax.swing.JFrame;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author USER
 */
public class ToolBar extends JFrame {

    JToolBar tb;
    JButton exit;
    
    
    public ToolBar() throws HeadlessException {
        setSize(400, 400);
        setTitle("ToolBar test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tb = new JToolBar();
        exit = new JButton("Exit");
        
        tb.add(exit);
        tb.setFloatable(false);
        add(tb, BorderLayout.NORTH);
        
        
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ToolBar t = new ToolBar();
        t.setVisible(true);
        
    }// main()
    
}// class ToolBar
