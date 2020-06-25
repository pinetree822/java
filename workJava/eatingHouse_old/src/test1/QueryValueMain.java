package test1;

/*�����ϰ� �ڷῡ ���������� �Ǵ��ϴ� ���α׷��̴�.
���߿� swing�� �� ����� ���� ����� �����ϰ� ������������� ����
=================================================================================================================*/
import java.awt.BorderLayout;
 import java.awt.Color;
 import java.awt.Container;
 import java.awt.GridBagConstraints;
 import java.awt.GridBagLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.ArrayList;

import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.JTextArea;
 import javax.swing.JTextPane;
 import javax.swing.text.BadLocationException;
 import javax.swing.text.StyleConstants;
 import javax.swing.text.StyleContext;
 import javax.swing.text.StyledDocument;


 public class QueryValueMain extends JFrame {

		JPanel panel;
		JTextPane answerTextArea;
		JTextArea questionTextArea;
		JButton transformation, cancel, prgExit;
		TestListenr listener;
		StyledDocument sdoc;
		JScrollPane qScrollPane;
		JScrollPane aScrollPane;

		public QueryValueMain() {

			setLayout(null); // Layout�� NULL�� ���� (������Ʈ�� ��ġ�� ����ڰ� �������־�� ��)
			setTitle("TestUI"); // Frame�� Ÿ��Ʋ �̸� �ֱ�
			CreatePanel();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame�� X�� ������� ����
			setSize(400, 500); // Frame�� ũ�� ����
			setVisible(true); // ������ Frame�� �����쿡 �Ѹ���
		}//public QueryValueMain()

		private void CreatePanel() {

			panel = new JPanel(); // �г��� ����
			panel.setLayout(null); // �г��� Layout�� NULL
			panel.setBounds(0, 0, 400, 500); // �г��� ũ�� �� ��ġ ���� (x,y�� ���� ����(width,
			// ����(height))

			questionTextArea = new JTextArea(); // JTextArea ����
			//questionTextArea.setBounds(50, 25, 300, 150); // JTextArea ũ�� �� ��ġ ����
			questionTextArea.setEditable(true); // ����� JtextArea edit ���� (���� �� �� ����)

			qScrollPane = new JScrollPane(); //��ũ�����ο� TextArea���̱�
			qScrollPane.setViewportView(questionTextArea);
			qScrollPane.setBounds(20, 25, 350, 150);

			answerTextArea = new JTextPane();
			answerTextArea.setEditable(false);
			sdoc = answerTextArea.getStyledDocument();
			addStylesToDocument(sdoc); //addStylesToDocument�� ������ ��Ÿ�� �� �޴´�

			aScrollPane = new JScrollPane(); //��ũ�����ο� JTextPane���̱�
			aScrollPane.setViewportView(answerTextArea);
			aScrollPane.setBounds(20, 200, 350, 150);

			transformation = new JButton("��ȯ"); // ��ư ����
			cancel = new JButton("���");
			prgExit = new JButton("����");

			transformation.setBounds(50, 375, 80, 50); // ũ�� ����
			cancel.setBounds(160, 375, 80, 50);
			prgExit.setBounds(270, 375, 80, 50);

			String query = "25, '�ڽ¿�', , '2008-09-05', 12.5, 344 3";
			questionTextArea.append(query);

			panel.add(qScrollPane); //�гο� JScrollPane add
			panel.add(aScrollPane); //�гο� JScrollPane add
			panel.add(transformation); // �гο� ��ư add
			panel.add(cancel);// �гο� ��ư add
			panel.add(prgExit);// �гο� ��ư add

			listener = new TestListenr(); // �Ʒ��� ������Ʈ ������ Ŭ���� ����

			transformation.addActionListener(listener);
			cancel.addActionListener(listener);
			prgExit.addActionListener(listener);

			add(panel); // Frame�� Panel add (JFrame�� ��ӹ޾ұ⿡ this(��������)�� JFrame)

		}// private void CreatePanel()

		protected void addStylesToDocument(StyledDocument sdoc) {
			javax.swing.text.Style style = StyleContext.getDefaultStyleContext()
			.getStyle(StyleContext.DEFAULT_STYLE);

			javax.swing.text.Style regular = sdoc.addStyle("regular", style);
			StyleConstants.setFontFamily(style, "SansSerif");
			StyleConstants.setForeground(style, Color.BLACK);

			javax.swing.text.Style si = sdoc.addStyle("integer", style);
			StyleConstants.setItalic(si, true);
			StyleConstants.setForeground(si, Color.BLUE);
			StyleConstants.setBold(si, true);

			javax.swing.text.Style sd = sdoc.addStyle("double", style);
			StyleConstants.setItalic(sd, true);
			StyleConstants.setForeground(sd, Color.ORANGE);
			StyleConstants.setBold(sd, true);

			javax.swing.text.Style sc = sdoc.addStyle("Character", style);
			StyleConstants.setItalic(sc, true);
			StyleConstants.setForeground(sc, Color.RED);
			StyleConstants.setBold(sc, true);

			javax.swing.text.Style sdt = sdoc.addStyle("Date", style);
			StyleConstants.setItalic(sdt, true);
			StyleConstants.setForeground(sdt, Color.PINK);
			StyleConstants.setBold(sdt, true);

			javax.swing.text.Style su = sdoc.addStyle("Unknown", style);
			StyleConstants.setItalic(su, true);
			StyleConstants.setForeground(su, Color.darkGray);
			StyleConstants.setBold(su, true);

		}//protected void addStylesToDocument(StyledDocument sdoc)


		/**
		* @param args
		*/
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new QueryValueMain();
		}

		class TestListenr implements ActionListener {

			public void actionPerformed(ActionEvent event) {

				String question = questionTextArea.getText();
				IsRightType irt = new IsRightType();
				ArrayList<Value> list = irt.PrintResult(question);
				int listSize = list.size();
				answerTextArea.setText(""); //TextArea�� ����.
				if (event.getSource() == transformation) {
					for (int i = 0; i < listSize; i++) {
						try {
							sdoc.insertString(sdoc.getLength(), list.get(i)
							.getType()
							+ " ", sdoc.getStyle(list.get(i)
							.getType()));//textPane�� ������ ��Ÿ���� �����ؼ� ���δ�.

							sdoc.insertString(sdoc.getLength(), list.get(i)
							.getValue()
							+ " \n", sdoc.getStyle("regular"));

						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				} else if (event.getSource() == cancel) {
					answerTextArea.setText("");
					questionTextArea.setText("");
				} else if (event.getSource() == prgExit) {
					System.exit(1);
				}
			}// public void actionPerformed(ActionEvent event)

		}// class TestListenr implements ActionListener

	}//public class QueryValueMain extends JFrame {