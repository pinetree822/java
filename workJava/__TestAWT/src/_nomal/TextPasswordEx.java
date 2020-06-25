package _nomal;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class TextPasswordEx {

	public static void main(String[] args) {
		
		// 프레임 생성
		Frame f = new Frame("텍스트필드 테스트");
		
		// 패널 생성
		Panel p = new Panel();
		
		// 텍스트필드 생성(텍스트,크기)
		// https://m.blog.naver.com/PostView.nhn?blogId=bestheroz&logNo=103730014&proxyReferer=https:%2F%2Fwww.google.com%2F
		TextField tf1 = new TextField("아이디 입력", 12);
		TextField tf2 = new TextField("암호 입력", 10); 
		
		// 모든 text를 선택된 상태
		tf1.selectAll();
		tf2.selectAll();
		
		// 문자가 *로 보이게 하는 옵션
		tf2.setEchoChar('*');
		
		// 패널에 텍스트필드 삽입
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);// 프레임에 패널 넣기
		f.setSize(300, 100);// 프레임 크기
		f.setVisible(true);// 생성(보이기)
		
		
	}// main
}// class TextPasswordEx
