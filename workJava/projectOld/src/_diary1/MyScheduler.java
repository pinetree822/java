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
		//super("�޷�");
		super(title, resizable, closable, maximizable, iconifiable);
		Container cp = this.getContentPane();
		
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH); //ȭ�� ǥ���� �� +1
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
	 * ���� ���̾ƿ� : �޷� �̵� ��ư�� �޷��� ����
	 */
	public void makeLayoutLeft() {
		pLeft = new JPanel(new BorderLayout(5, 5)); //Panel�� �⺻ ���̾ƿ��� FlowLayout
		pLeft.setBackground(Color.red);
		
		makeLayoutLeftTop();
		makeLayoutLeftBottom();
		
		pLeft.add(pLeftTop, BorderLayout.NORTH);
		pLeft.add(pLeftBottom, BorderLayout.CENTER);
	}
	
	/**
	 * ���� ���̾ƿ� �� : �޷� �̵� ��ư�� ����
	 */
	public void makeLayoutLeftTop() {
		bc = new BirthChoice("��¥�� �������ּ���", "��¥ �̵�", "�̵�");
		
		Font lbFont = new Font(Font.DIALOG, Font.BOLD, 20);
		
		pLeftTop = new JPanel();
		pLeftTop.setBackground(new Color(0, 84, 255));
		
		btMoveCal = new JButton("��¥ �̵�");		
		btToday = new JButton("����");
		
		btPrev = new JButton("��");
		btNext = new JButton("��");
		
		lbYear = new JLabel(String.valueOf(year));
		lbYear.setForeground(Color.white);
		lbYear.setFont(lbFont);
		JLabel lbYearStr = new JLabel("��");		
		lbYearStr.setForeground(Color.white);
		lbYearStr.setFont(lbFont);
		
		lbMonth = new JLabel(String.valueOf(month + 1));		
		lbMonth.setForeground(Color.white);
		lbMonth.setFont(lbFont);
		JLabel lbMonthStr = new JLabel("��");
		lbMonthStr.setForeground(Color.white);
		lbMonthStr.setFont(lbFont);
		
		btInsert = new JButton("���");		
		
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
	 * ���� ���̾ƿ� �Ʒ� : �޷��� ����
	 */
	public void makeLayoutLeftBottom() {
		String[] week = {"��", "��", "ȭ", "��", "��", "��", "��"};
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
	 * ������ ���̾ƿ� : ������ ������ ������ ���� ����Ʈ
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
	 * ������ ���̾ƿ� �� : ������ ����, ��� ��ư�� �ִ� JPanel 
	 */
	public void makeLayoutRightTop() {
		pRightTop = new JPanel();
		pRightTop.setBackground(Color.cyan);
		
		btUpdate = new JButton("����");
		btDelete = new JButton("����");
		
		pRightTop.add(btUpdate);
		pRightTop.add(btDelete);
		
		btUpdate.addActionListener(my);
		btDelete.addActionListener(my);
	}
	
	/**
	 * ������ ���̾ƿ� �Ʒ� : �޷¿��� ������ ������ ������ �� ������ �����ִ� ����Ʈ�� �ִ� JPanel
	 */
	public void makeLayoutRightBottom() {
		pRightBottom = new JPanel(new BorderLayout(5, 5)){
			@Override
			public Insets getInsets() {
				return new Insets(10, 5, 10, 5);
			}
		};
		pRightBottom.setBackground(Color.magenta);		
		
		
		vDayDetail.add(new DayDetail("���� 09��30��", "�Ｚ�� �ڿ��� ����ȸ / �Ｚ�� �ڿ��� ����ȸ"));
		vDayDetail.add(new DayDetail("���� 01��30��", "����-������ OO������"));
		vDayDetail.add(new DayDetail("���� 03��00��", "�湫�� ���ѱ���"));
		vDayDetail.add(new DayDetail("���� 07��30��", "������"));
		
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
	 * �޷��� ������ִ� �޼ҵ�
	 * @param year : ��
	 * @param month : ��
	 */
	public void makeCalendar(int year, int month) {
		int calDay;
		Color color;

		pLeftBottomBottom.removeAll();
		
		cal.set(year, month, 1);	//�ش� ���� 1�Ϸ� ����
		cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) + 1);		//���� �޷� �̵�		
		
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
			//TODO ������ �ҷ�����
			DayShort dayS = new DayShort(Integer.toString(calDay), color, "", "" ,"");			
			pLeftBottomBottom.add(dayS);			
			
			cal.add(Calendar.DATE, 1);
		}
		
		lbYear.setText(String.valueOf(year));
		lbMonth.setText(String.valueOf(month + 1));
		
		pLeftBottomBottom.revalidate();
		
		
		//int year = cal.get(Calendar.YEAR);			//��
		//int month = cal.get(Calendar.MONTH);		//�� (ȭ�鿡 ǥ�ý� +1)
		//int day = cal.get(Calendar.DAY_OF_MONTH);	//��
		//int am = cal.get(Calendar.AM_PM);			//����:0, ����:1	
		//int hour = cal.get(Calendar.HOUR);			//��
		//int minute = cal.get(Calendar.MINUTE);		//��
		//int second = cal.get(Calendar.SECOND);		//��		
		
		//int maxMonthDay = cal.getActualMaximum(Calendar.DATE);	//���� ��������
	}
	
	/**
	 * ��ư �׼� ������
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
				month = cal.get(Calendar.MONTH); //ȭ�� ǥ���� �� +1
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
					
					int result = JOptionPane.showConfirmDialog(MyScheduler.this, "[" + detail.getTime() + "] �� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
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


