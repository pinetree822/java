package _nomal;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Panel;

public class RadioCheckboxEx {

	public static void main(String[] args) {
		
		// 프레임 생성
		Frame f = new Frame("라디오형 체크박스 테스트"); 
		Panel p = new Panel();// 패널 생성
		
		// 체크박스 그룹
		CheckboxGroup group = new CheckboxGroup();

		// 라디오버튼 체크박스
		Checkbox radio1 = new Checkbox("고졸", group, false);
		Checkbox radio2 = new Checkbox("전문대졸", group, false);
		Checkbox radio3 = new Checkbox("대졸", group, true);

		// 패널에 라디오버튼 붙이기
		p.add(radio1);
		p.add(radio2);
		p.add(radio3);
		
		f.add(p);// 프레임에 패널 붙이기
		f.setSize(300, 100);// 크기 조절
		f.setVisible(true);// 프레임생성(보이기)
		
	}//main
	
}// class RadioCheckboxEx
