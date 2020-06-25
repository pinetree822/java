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
 * JTextPane을 사용하면 폰트, 굵기, 기울임, 정렬같은
 * 다양한 서식을 사용할 수 있다.
 * 
 * [사용절차]
 * 1) SimpleAttributeSet 객체를 생성한다.
 * 2) StyleConstants클래스의 static메소드를 통해 1번 객체의
 * 속성을 설정한다.
 * 3) 이들 특성을 전체 문서에 적용할 경우
 * StyledDocument(문서모델)을 얻어와
 * 문서모델의 메소드를 통해 원하는 영역에 적용한다.
 * [a] 문자특성(CharacterAttributes) : 폰트에 관한 특성,
 * 기울임, 강조, 밑줄, 문자색 같은 특성
 * [b] 색상특성(Color Attributes) : 글자색, 배경색 관련 특성
 * [c] 폰트특성(Font Attributes) : 서체, 서체크기 관련
 * [d] 문단특성(Paragraph Attributes) :
 * 문단 정렬, 들여쓰기, 문단사이 간격 같은 특성
 * 
 */

public class JTextPaneDemo extends JFrame {

	JTextPane tp;
	
	public JTextPaneDemo() {
		super("::JTextPaneDemo::");
		Container cp = this.getContentPane();
		tp = new JTextPane();
		cp.add(new JScrollPane(tp), "Center");
		
		tp.setText("31일 서울 양천구 한 카페에서 만난 전 전 의원은 최근 문제가 되고 있는 최순실씨의 국정농단 사태에 대해 대통령뿐만 아니라 친박 정치인들에게도 책임이 있다고 주장했다.");
		
		// 1. 문서모델을 얻어오자
		StyledDocument doc = tp.getStyledDocument();
		
		// 2. SimpleAttributeSet 객체를 생성
		SimpleAttributeSet attr = new SimpleAttributeSet();
		
		// 3. attr에 속성을 부여 => StyleConstants의 메소드 통해
		StyleConstants.setFontFamily(attr, "궁서체");	// 궁서체
		StyleConstants.setFontSize(attr, 20);			// 크기
		
		// 4. 문서 모델을 이용해 attr속성을 적용한다.
		doc.setCharacterAttributes(0, 20, attr, true);
		
		
		attr = new SimpleAttributeSet();
		StyleConstants.setUnderline(attr, true);				// 밑줄
		StyleConstants.setItalic(attr, true);
		StyleConstants.setForeground(attr, Color.blue); 		// 글자색
		StyleConstants.setBackground(attr, Color.yellow);	// 글자배경색
		StyleConstants.setBold(attr, true);
		StyleConstants.setFontSize(attr, 22);
		doc.setCharacterAttributes(20, 30, attr, true);/// 문자특성
		
		
		// 중앙정렬 특성을 갖는 문단 특성을 적용해보자
		attr = new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, tp.getText().length(), attr, true);
		
		
		// 문서 긑에 문자열을 추가
		// ta.append(str);
		String str = "\n즐거운 하루 되세요~~\n";
		
		try {
			doc.insertString(tp.getText().length(), str, attr);
			
		} catch (BadLocationException e) { // 범위 잘못지정할때 에러
			e.printStackTrace();
		}// 문자길이, 문자열, 문자열속성
		
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JTextPaneDemo();
	}

}
