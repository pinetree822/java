package test1;

/*간단하게 자료에 데이터형을 판단하는 프로그램이다.
나중에 swing을 더 써먹을 일이 생기면 유용하게 써먹을수있을꺼 같다
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

			setLayout(null); // Layout을 NULL로 설정 (컴포넌트의 위치를 사용자가 설정해주어야 함)
			setTitle("TestUI"); // Frame의 타이틀 이름 주기
			CreatePanel();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame의 X를 누를경우 종료
			setSize(400, 500); // Frame의 크기 설정
			setVisible(true); // 생성한 Frame을 윈도우에 뿌리기
		}//public QueryValueMain()

		private void CreatePanel() {

			panel = new JPanel(); // 패널을 생성
			panel.setLayout(null); // 패널의 Layout을 NULL
			panel.setBounds(0, 0, 400, 500); // 패널의 크기 및 위치 지정 (x,y로 부터 넓이(width,
			// 높이(height))

			questionTextArea = new JTextArea(); // JTextArea 생성
			//questionTextArea.setBounds(50, 25, 300, 150); // JTextArea 크기 및 위치 지정
			questionTextArea.setEditable(true); // 실행시 JtextArea edit 금지 (글을 쓸 수 없음)

			qScrollPane = new JScrollPane(); //스크롤패인에 TextArea붙이기
			qScrollPane.setViewportView(questionTextArea);
			qScrollPane.setBounds(20, 25, 350, 150);

			answerTextArea = new JTextPane();
			answerTextArea.setEditable(false);
			sdoc = answerTextArea.getStyledDocument();
			addStylesToDocument(sdoc); //addStylesToDocument에 지정된 스타일 을 받는다

			aScrollPane = new JScrollPane(); //스크롤패인에 JTextPane붙이기
			aScrollPane.setViewportView(answerTextArea);
			aScrollPane.setBounds(20, 200, 350, 150);

			transformation = new JButton("변환"); // 버튼 생성
			cancel = new JButton("취소");
			prgExit = new JButton("종료");

			transformation.setBounds(50, 375, 80, 50); // 크기 지정
			cancel.setBounds(160, 375, 80, 50);
			prgExit.setBounds(270, 375, 80, 50);

			String query = "25, '박승원', , '2008-09-05', 12.5, 344 3";
			questionTextArea.append(query);

			panel.add(qScrollPane); //패널에 JScrollPane add
			panel.add(aScrollPane); //패널에 JScrollPane add
			panel.add(transformation); // 패널에 버튼 add
			panel.add(cancel);// 패널에 버튼 add
			panel.add(prgExit);// 패널에 버튼 add

			listener = new TestListenr(); // 아래의 컴포넌트 리스너 클래스 생성

			transformation.addActionListener(listener);
			cancel.addActionListener(listener);
			prgExit.addActionListener(listener);

			add(panel); // Frame에 Panel add (JFrame을 상속받았기에 this(생략가능)가 JFrame)

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
				answerTextArea.setText(""); //TextArea를 비운다.
				if (event.getSource() == transformation) {
					for (int i = 0; i < listSize; i++) {
						try {
							sdoc.insertString(sdoc.getLength(), list.get(i)
							.getType()
							+ " ", sdoc.getStyle(list.get(i)
							.getType()));//textPane에 지정된 스타일을 지정해서 붙인다.

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