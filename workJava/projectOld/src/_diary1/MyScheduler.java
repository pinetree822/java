package _diary1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyScheduler extends JInternalFrame {
	
	private JButton btMoveCal, btToday, btPrev, btNext, btInsert, btUpdate, btDelete;
	private JLabel lbYear, lbMonth;
	private JPanel pLeft, pRight, pLeftTop, pLeftBottom, pLeftBottomTop, pLeftBottomBottom, pRightTop, pRightBottom;
	
	private MyHandler my;
	
	private JList lst; //View
	//private DefaultListModel model;
	private Vector<DayDetail> vDayDetail;
	private int idx = -1;
	
	private Calendar cal;
	private int year, month, day;
	BirthChoice bc;
	
	public MyScheduler(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		//super("달력");
		super(title, resizable, closable, maximizable, iconifiable);
		Container cp = this.getContentPane();
		
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH); //화면 표시할 땐 +1
		day = cal.get(Calendar.DAY_OF_MONTH);		
		
		vDayDetail = new Vector<DayDetail>();
		my = new MyHandler();
		
		makeLayoutLeft();
		makeLayoutRight();
		
		cp.add(pLeft, BorderLayout.CENTER);
		cp.add(pRight, BorderLayout.EAST);
		
		setSize(800,650);
		
		//setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*public static void main(String[] args) {
		new MyScheduler();
		
	}*/
	
	/**
	 * 왼쪽 레이아웃 : 달력 이동 버튼과 달력이 있음
	 */
	public void makeLayoutLeft() {
		pLeft = new JPanel(new BorderLayout(5, 5)); //Panel의 기본 레이아웃은 FlowLayout
		pLeft.setBackground(Color.red);
		
		makeLayoutLeftTop();
		makeLayoutLeftBottom();
		
		pLeft.add(pLeftTop, BorderLayout.NORTH);
		pLeft.add(pLeftBottom, BorderLayout.CENTER);
	}
	
	/**
	 * 왼쪽 레이아웃 위 : 달력 이동 버튼이 있음
	 */
	public void makeLayoutLeftTop() {
		bc = new BirthChoice("날짜를 선택해주세요", "날짜 이동", "이동");
		
		Font lbFont = new Font(Font.DIALOG, Font.BOLD, 20);
		
		pLeftTop = new JPanel();
		pLeftTop.setBackground(new Color(0, 84, 255));
		
		btMoveCal = new JButton("날짜 이동");		
		btToday = new JButton("오늘");
		
		btPrev = new JButton("◀");
		btNext = new JButton("▶");
		
		lbYear = new JLabel(String.valueOf(year));
		lbYear.setForeground(Color.white);
		lbYear.setFont(lbFont);
		JLabel lbYearStr = new JLabel("년");		
		lbYearStr.setForeground(Color.white);
		lbYearStr.setFont(lbFont);
		
		lbMonth = new JLabel(String.valueOf(month + 1));		
		lbMonth.setForeground(Color.white);
		lbMonth.setFont(lbFont);
		JLabel lbMonthStr = new JLabel("월");
		lbMonthStr.setForeground(Color.white);
		lbMonthStr.setFont(lbFont);
		
		btInsert = new JButton("등록");		
		
		pLeftTop.add(btMoveCal);
		pLeftTop.add(btToday);
		pLeftTop.add(btPrev);
		pLeftTop.add(lbYear);
		pLeftTop.add(lbYearStr);
		pLeftTop.add(lbMonth);
		pLeftTop.add(lbMonthStr);
		pLeftTop.add(btNext);
		pLeftTop.add(btInsert);		
		
		btMoveCal.addActionListener(my);
		btToday.addActionListener(my);
		btPrev.addActionListener(my);
		btNext.addActionListener(my);
		btInsert.addActionListener(my);
		bc.btRegister.addActionListener(my);
	}
	
	/**
	 * 왼쪽 레이아웃 아래 : 달력이 있음
	 */
	public void makeLayoutLeftBottom() {
		String[] week = {"일", "월", "화", "수", "목", "금", "토"};
		Color[] colorA = {Color.red, Color.black, Color.black, Color.black, Color.black, Color.black, Color.blue};
		Color backColor = new Color(178, 235, 244);
		
		pLeftBottom = new JPanel(new BorderLayout(5, 5));
		pLeftBottom.setBackground(backColor);
		
		pLeftBottomTop = new JPanel(new GridLayout(1, 7, 5, 5)){
			@Override
			public Insets getInsets() {
				return new Insets(10, 10, 0, 10);
			}
		};
		pLeftBottomTop.setBackground(backColor);
		
		for(int i = 0; i < 7; i++) {			
			JLabel lb = new JLabel(week[i]);
			lb.setForeground(colorA[i]);
			lb.setHorizontalAlignment(JLabel.CENTER);
			lb.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
			pLeftBottomTop.add(lb);
		}
		
		pLeftBottomBottom = new JPanel(new GridLayout(6, 7, 5, 5), true){
			@Override
			public Insets getInsets() {
				return new Insets(0, 10, 10, 10);
			}
		};
		pLeftBottomBottom.setBackground(backColor);
		
		pLeftBottom.add(pLeftBottomTop, "North");
		pLeftBottom.add(pLeftBottomBottom, "Center");
		
		makeCalendar(year, month);
	}
	
	/**
	 * 오른쪽 레이아웃 : 선택한 요일의 스케줄 정보 리스트
	 */
	public void makeLayoutRight() {
		pRight = new JPanel(new BorderLayout(5, 5));
		pRight.setBackground(Color.yellow);
		
		makeLayoutRightTop();
		makeLayoutRightBottom();
		
		pRight.add(pRightTop, "North");
		pRight.add(pRightBottom, "Center");
	}
	
	/**
	 * 오른쪽 레이아웃 위 : 스케줄 수정, 등록 버튼이 있는 JPanel 
	 */
	public void makeLayoutRightTop() {
		pRightTop = new JPanel();
		pRightTop.setBackground(Color.cyan);
		
		btUpdate = new JButton("수정");
		btDelete = new JButton("삭제");
		
		pRightTop.add(btUpdate);
		pRightTop.add(btDelete);
		
		btUpdate.addActionListener(my);
		btDelete.addActionListener(my);
	}
	
	/**
	 * 오른쪽 레이아웃 아래 : 달력에서 선택한 요일의 스케줄 상세 내용을 보여주는 리스트가 있는 JPanel
	 */
	public void makeLayoutRightBottom() {
		pRightBottom = new JPanel(new BorderLayout(5, 5)){
			@Override
			public Insets getInsets() {
				return new Insets(10, 5, 10, 5);
			}
		};
		pRightBottom.setBackground(Color.magenta);		
		
		
		vDayDetail.add(new DayDetail("오전 09시30분", "삼성동 코엑스 전시회 / 삼성동 코엑스 전시회"));
		vDayDetail.add(new DayDetail("오후 01시30분", "점심-강남역 OO감자탕"));
		vDayDetail.add(new DayDetail("오후 03시00분", "충무로 대한극장"));
		vDayDetail.add(new DayDetail("오후 07시30분", "종각역"));
		
		lst = new JList(vDayDetail);		
		
		ListCellRenderer d = new ListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, 
					boolean isSelected, boolean cellHasFocus) {
				
				Component comp = (Component)value;				
				
				Color background;
				Color foreground;

		        // check if this cell represents the current DnD drop location
				JList.DropLocation dropLocation = list.getDropLocation();
	        	if (dropLocation != null
		                && !dropLocation.isInsert()
		                && dropLocation.getIndex() == index) {
	        		//System.out.println("dropLocation");
	        		background = Color.BLUE;
	        		foreground = Color.WHITE;

        		// check if this cell is selected
	        	} else if (isSelected) {
	        		//System.out.println("isSelected");	        		
	        		background = new Color(183, 240, 177);
	        		foreground = Color.red;	        		
	        		idx = index;
        		// unselected, and not the DnD drop location
	        	} else {
	        		//System.out.println("other");
	        		background = Color.WHITE;
	        		foreground = Color.BLACK;
	        	};

	        	comp.setBackground(background);
	        	comp.setForeground(foreground);
				
				return comp;
			}

		};

	  	lst.setCellRenderer(d);
		
		pRightBottom.add(new JScrollPane(lst), "Center");
	}
	
	/**
	 * 달력을 만들어주는 메소드
	 * @param year : 년
	 * @param month : 월
	 */
	public void makeCalendar(int year, int month) {
		int calDay;
		Color color;

		pLeftBottomBottom.removeAll();
		
		cal.set(year, month, 1);	//해당 월의 1일로 셋팅
		cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) + 1);		//이전 달로 이동		
		
		for(int i = 0; i < 42; i++) {
			calDay = cal.get(Calendar.DATE);
			
			if(cal.get(Calendar.MONTH) != month) {
				color = Color.GRAY;
			} else {
				color = Color.BLACK;
				
				if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					color = Color.RED;
				} else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
					color = Color.BLUE;
				}
			}			
			//TODO 스케줄 불러오기
			DayShort dayS = new DayShort(Integer.toString(calDay), color, "", "" ,"");			
			pLeftBottomBottom.add(dayS);			
			
			cal.add(Calendar.DATE, 1);
		}
		
		lbYear.setText(String.valueOf(year));
		lbMonth.setText(String.valueOf(month + 1));
		
		pLeftBottomBottom.revalidate();
		
		
		//int year = cal.get(Calendar.YEAR);			//년
		//int month = cal.get(Calendar.MONTH);		//월 (화면에 표시시 +1)
		//int day = cal.get(Calendar.DAY_OF_MONTH);	//일
		//int am = cal.get(Calendar.AM_PM);			//오전:0, 오후:1	
		//int hour = cal.get(Calendar.HOUR);			//시
		//int minute = cal.get(Calendar.MINUTE);		//분
		//int second = cal.get(Calendar.SECOND);		//초		
		
		//int maxMonthDay = cal.getActualMaximum(Calendar.DATE);	//월의 마지막날
	}
	
	/**
	 * 버튼 액션 리스너
	 */
	class MyHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if (obj == btMoveCal) {
				bc.setSize(400, 250);
				bc.setVisible(true);				
				
			} else if(obj == btToday) {				
				cal = Calendar.getInstance();
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH); //화면 표시할 땐 +1
				day = cal.get(Calendar.DAY_OF_MONTH);
				
				makeCalendar(year, month);
				
			} else if(obj == btPrev) {				
				year = Integer.parseInt(lbYear.getText());
				month = Integer.parseInt(lbMonth.getText()) - 1;
				
				if(month < 1) {
					year -= 1;
					month = 12;
				}
				
				makeCalendar(year, month - 1);
				
			} else if(obj == btNext) {				
				year = Integer.parseInt(lbYear.getText());
				month = Integer.parseInt(lbMonth.getText()) + 1;
				
				if(month > 12) {
					year += 1;
					month = 1;
				}
				
				makeCalendar(year, month - 1);
				
			} else if(obj == btInsert) {
			
			} else if(obj == btUpdate) {
				
			} else if(obj == btDelete) {
				if(idx != -1) {
					DayDetail detail = vDayDetail.get(idx);
					
					int result = JOptionPane.showConfirmDialog(MyScheduler.this, "[" + detail.getTime() + "] 를 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {
						vDayDetail.remove(idx);
						lst.repaint();
					}
				}
			} else if(obj == bc.btRegister) {				
				int gYear = bc.year;
				int gMonth = bc.month;
				makeCalendar(gYear, gMonth - 1);
			}			
		}
	}

}


