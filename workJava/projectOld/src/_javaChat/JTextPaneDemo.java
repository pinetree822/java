package _javaChat;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.*;
/*
 * JTextPane�� ����ϸ� ��Ʈ, ����, �����, ���İ���
 * �پ��� ������ ����� �� �ִ�.
 * 
 * [�������]
 * 1) SimpleAttributeSet ��ü�� �����Ѵ�.
 * 2) StyleConstantsŬ������ static�޼ҵ带 ���� 1�� ��ü��
 * �Ӽ��� �����Ѵ�.
 * 3) �̵� Ư���� ��ü ������ ������ ���
 * StyledDocument(������)�� ����
 * �������� �޼ҵ带 ���� ���ϴ� ������ �����Ѵ�.
 * [a] ����Ư��(CharacterAttributes) : ��Ʈ�� ���� Ư��,
 * �����, ����, ����, ���ڻ� ���� Ư��
 * [b] ����Ư��(Color Attributes) : ���ڻ�, ���� ���� Ư��
 * [c] ��ƮƯ��(Font Attributes) : ��ü, ��üũ�� ����
 * [d] ����Ư��(Paragraph Attributes) :
 * ���� ����, �鿩����, ���ܻ��� ���� ���� Ư��
 * 
 */

public class JTextPaneDemo extends JFrame {

	JTextPane tp;
	
	public JTextPaneDemo() {
		super("::JTextPaneDemo::");
		Container cp = this.getContentPane();
		tp = new JTextPane();
		cp.add(new JScrollPane(tp), "Center");
		
		tp.setText("31�� ���� ��õ�� �� ī�信�� ���� �� �� �ǿ��� �ֱ� ������ �ǰ� �ִ� �ּ��Ǿ��� ������� ���¿� ���� ����ɻӸ� �ƴ϶� ģ�� ��ġ�ε鿡�Ե� å���� �ִٰ� �����ߴ�.");
		
		// 1. �������� ������
		StyledDocument doc = tp.getStyledDocument();
		
		// 2. SimpleAttributeSet ��ü�� ����
		SimpleAttributeSet attr = new SimpleAttributeSet();
		
		// 3. attr�� �Ӽ��� �ο� => StyleConstants�� �޼ҵ� ����
		StyleConstants.setFontFamily(attr, "�ü�ü");	// �ü�ü
		StyleConstants.setFontSize(attr, 20);			// ũ��
		
		// 4. ���� ���� �̿��� attr�Ӽ��� �����Ѵ�.
		doc.setCharacterAttributes(0, 20, attr, true);
		
		
		attr = new SimpleAttributeSet();
		StyleConstants.setUnderline(attr, true);				// ����
		StyleConstants.setItalic(attr, true);
		StyleConstants.setForeground(attr, Color.blue); 		// ���ڻ�
		StyleConstants.setBackground(attr, Color.yellow);	// ���ڹ���
		StyleConstants.setBold(attr, true);
		StyleConstants.setFontSize(attr, 22);
		doc.setCharacterAttributes(20, 30, attr, true);/// ����Ư��
		
		
		// �߾����� Ư���� ���� ���� Ư���� �����غ���
		attr = new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, tp.getText().length(), attr, true);
		
		
		// ���� �P�� ���ڿ��� �߰�
		// ta.append(str);
		String str = "\n��ſ� �Ϸ� �Ǽ���~~\n";
		
		try {
			doc.insertString(tp.getText().length(), str, attr);
			
		} catch (BadLocationException e) { // ���� �߸������Ҷ� ����
			e.printStackTrace();
		}// ���ڱ���, ���ڿ�, ���ڿ��Ӽ�
		
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JTextPaneDemo();
	}

}
