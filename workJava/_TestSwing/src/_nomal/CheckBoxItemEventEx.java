package _nomal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class CheckBoxItemEventEx extends JFrame{

	private JCheckBox fruits[] = new JCheckBox[3]; // 체크박스 배열
	private String names[] = {"사과", "배", "체리"};// 체크박스 문자열로 사용할 문자열배열
	private JLabel sumLabel;// 계산 합을 출력할 레이블
	
	
	public CheckBoxItemEventEx() {
		
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
		
		// item리스너 구현한 MyItemListener의 인스턴스를 생성한다.
		MyItemListener listener = new MyItemListener();

		// 3개의 체크박스를 생성, 컨텐트 팬에 삽입하고 Item리스너 등록
		for(int i=0; i<fruits.length; i++) {
			// names문자열로 체크박스 생성
			fruits[i] = new JCheckBox(names[i]);
			
			// 체크박스 외곽선 보이도록 설정
			fruits[i].setBorderPainted(true);
			
			// 컨텐트 팬에 체크박스 삽입
			c.add(fruits[i]);
			
			// 체크박스에 Item리스너 등록
			fruits[i].addItemListener(listener);
		}
		
		sumLabel = new JLabel("현재 0 원 입니다.");
		c.add(sumLabel);
		
		setSize(250, 200);
		setVisible(true);
		
	}// CheckBoxItemEventEx()
	
	
	// Item 리스너 구현
	class MyItemListener implements ItemListener
	{
		private int sum=0;// 가격의 합
		
		// 체크박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
		@Override
		public void itemStateChanged(ItemEvent e) {
			// 선택한 경우
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(e.getItem() == fruits[0]) {			// 사과 체크
					sum += 100;	
				} else if(e.getItem() == fruits[1]) {	// 배 체크
					sum += 500;	
				} else {								// 체리 체크	
					sum += 20000;		
				}
				
			// 해제한 경우
			}else {
				if(e.getItem() == fruits[0])			// 사과 체크
					sum -=100;
				else if(e.getItem() == fruits[1])		// 배 체크
					sum -=500;
				else									// 체리 체크
					sum -=20000;
			}
			sumLabel.setText("현재 " + sum + "원 입니다.");// 합출력
		}// itemStateChanged()
		
	}// class MyItemListener
	
	
	public static void main(String[] args) {
		new CheckBoxItemEventEx();
	}//main()
	
	
}// class CheckBoxItemEventEx
