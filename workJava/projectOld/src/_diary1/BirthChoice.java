package _diary1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class BirthChoice extends JFrame implements ActionListener{
	
	JPanel pNorth, pCenter, pSouth, pYear, pMonth, pDay;
	JLabel lbBirth;
	JButton btRegister,btYearUp,btYearDown,btMonthUp,btMonthDown,btDayUp,btDayDown;
	JTextField tfYear, tfMonth, tfDay;

	int year,month,day;
	String sYear, sMonth, sDay, birthInfo;
	
	public BirthChoice(String title, String lbName, String btName)
	{
		super(title);
		Container cp = this.getContentPane();
		
		pNorth = new JPanel();
		pNorth.setBorder(new LineBorder(Color.red,3));
		pCenter = new JPanel(new GridLayout(0,3,5,5));
		pCenter.setBorder(new LineBorder(Color.green,3));
		pSouth = new JPanel();
		pSouth.setBorder(new LineBorder(Color.blue,3));
		
		cp.add(pNorth,BorderLayout.NORTH);
		cp.add(pCenter,BorderLayout.CENTER);
		cp.add(pSouth,BorderLayout.SOUTH);
		
		lbBirth = new JLabel(lbName);
		pNorth.add(lbBirth);
		
		btRegister = new JButton(btName);
		pSouth.add(btRegister);
		
		/////Center 영역////////
		
		pYear = new JPanel(new GridLayout(3,0,5,5));
		pYear.setBorder(new LineBorder(Color.red,3));
		pMonth = new JPanel(new GridLayout(3,0,5,5));
		pMonth.setBorder(new LineBorder(Color.red,3));
		pDay = new JPanel(new GridLayout(3,0,5,5));
		pDay.setBorder(new LineBorder(Color.red,3));
		
		pCenter.add(pYear);
		pCenter.add(pMonth);
		pCenter.add(pDay);
		
		Calendar oCalendar = Calendar.getInstance( );
		Font font = new Font("arian", Font.BOLD, 25);
		
		year = oCalendar.get(Calendar.YEAR);
		month = oCalendar.get(Calendar.MONTH) + 1;
		day = oCalendar.get(Calendar.DAY_OF_MONTH);
		
		sYear = String.valueOf(year);
		sMonth = String.valueOf(month);
		sDay = String.valueOf(day);
		
		btYearUp = new JButton(new ImageIcon("Images/plus2.PNG"));
		btYearDown = new JButton(new ImageIcon("Images/minus.PNG"));
		tfYear = new JTextField(20);
		tfYear.setText(sYear);
		tfYear.setFont(font);
		tfYear.setHorizontalAlignment(JTextField.CENTER);
		
		pYear.add(btYearUp);
		pYear.add(tfYear);
		pYear.add(btYearDown);
		
		btMonthUp = new JButton(new ImageIcon("Images/plus2.PNG"));
		btMonthDown = new JButton(new ImageIcon("Images/minus.PNG"));
		tfMonth = new JTextField(20);
		tfMonth.setText(sMonth);
		tfMonth.setFont(font);
		tfMonth.setHorizontalAlignment(JTextField.CENTER);
		
		pMonth.add(btMonthUp);
		pMonth.add(tfMonth);
		pMonth.add(btMonthDown);		
		
		btDayUp = new JButton(new ImageIcon("Images/plus2.PNG"));
		btDayDown = new JButton(new ImageIcon("Images/minus.PNG"));
		tfDay = new JTextField(20);
		tfDay.setText(sDay);
		tfDay.setFont(font);
		tfDay.setHorizontalAlignment(JTextField.CENTER);
		
		pDay.add(btDayUp);
		pDay.add(tfDay);
		pDay.add(btDayDown);
		
		birthInfo = sYear +"년"+ sMonth + "월" + sDay + "일";
		
		btYearUp.addActionListener(this);
		btYearDown.addActionListener(this);
		btMonthUp.addActionListener(this);
		btMonthDown.addActionListener(this);
		btDayUp.addActionListener(this);
		btDayDown.addActionListener(this);
		btRegister.addActionListener(this);
	}////생성자
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object o = e.getSource();
		
		if(o == btYearUp)
		{
			year++;
			sYear = String.valueOf(year);
			tfYear.setText(sYear);
			birthInfo = sYear +"년"+ sMonth + "월" + sDay + "일";
		}
		else if(o == btYearDown)
		{
			year--;
			sYear = String.valueOf(year);
			tfYear.setText(sYear);
			birthInfo = sYear +"년"+ sMonth + "월" + sDay + "일";
		}
		else if(o == btMonthUp)
		{
			month++;
			sMonth = String.valueOf(month);
			tfMonth.setText(sMonth);
			birthInfo = sYear +"년"+ sMonth + "월" + sDay + "일";
		}
		else if(o == btMonthDown)
		{
			month--;
			sMonth = String.valueOf(month);
			tfMonth.setText(sMonth);
			birthInfo = sYear +"년"+ sMonth + "월" + sDay + "일";
		}
		else if(o == btDayUp)
		{
			day++;
			sDay = String.valueOf(day);
			tfDay.setText(sDay);
			birthInfo = sYear +"년"+ sMonth + "월" + sDay + "일";
		}
		else if(o == btDayDown)
		{
			day--;
			sDay = String.valueOf(day);
			tfDay.setText(sDay);
			birthInfo = sYear +"년"+ sMonth + "월" + sDay + "일";
		}
		else if(o == btRegister)
		{
			birthInfo = tfYear.getText() + "년" + tfMonth.getText() + "월" + tfDay.getText() + "일";
			dispose();
		}
	}
}///////////////////////
