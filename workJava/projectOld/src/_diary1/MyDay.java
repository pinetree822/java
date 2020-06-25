package _diary1;

public class MyDay {

	private String memo;
	
	private String yearS;
	private String monthS;
	private String dayS;
	private String amS;
	private String hourS;
	private String minuteS;
	
	private String yearE;
	private String monthE;
	private String dayE;
	private String amE;
	private String hourE;
	private String minuteE;
	
	private boolean isAlarm;
	private int time;
	
	public MyDay(String memo, String yearS, String monthS, String dayS, String amS, String hourS, String minuteS,
			String yearE, String monthE, String dayE, String amE, String hourE, String minuteE, boolean isAlarm,
			int time) {
		this.memo = memo;
		this.yearS = yearS;
		this.monthS = monthS;
		this.dayS = dayS;
		this.amS = amS;
		this.hourS = hourS;
		this.minuteS = minuteS;
		this.yearE = yearE;
		this.monthE = monthE;
		this.dayE = dayE;
		this.amE = amE;
		this.hourE = hourE;
		this.minuteE = minuteE;
		this.isAlarm = isAlarm;
		this.time = time;
	}	

	public String getMemo() { return memo; }	
	public void setMemo(String memo) { this.memo = memo; }

	public String getYearS() { return yearS; }
	public void setYearS(String yearS) { this.yearS = yearS; }

	public String getMonthS() { return monthS; }
	public void setMonthS(String monthS) { this.monthS = monthS; }

	public String getDayS() { return dayS; }
	public void setDayS(String dayS) { this.dayS = dayS; }

	public String getAmS() { return amS; }
	public void setAmS(String amS) { this.amS = amS; }

	public String getHourS() { return hourS; }
	public void setHourS(String hourS) { this.hourS = hourS; }

	public String getMinuteS() { return minuteS; }
	public void setMinuteS(String minuteS) { this.minuteS = minuteS; }

	public String getYearE() { return yearE; }
	public void setYearE(String yearE) { this.yearE = yearE; }

	public String getMonthE() { return monthE; }
	public void setMonthE(String monthE) { this.monthE = monthE; }

	public String getDayE() { return dayE; }
	public void setDayE(String dayE) { this.dayE = dayE; }

	public String getAmE() { return amE; }
	public void setAmE(String amE) { this.amE = amE; }

	public String getHourE() { return hourE; }
	public void setHourE(String hourE) { this.hourE = hourE; }

	public String getMinuteE() { return minuteE; }
	public void setMinuteE(String minuteE) { this.minuteE = minuteE; }

	public boolean isAlarm() { return isAlarm; }
	public void setAlarm(boolean isAlarm) { this.isAlarm = isAlarm; }

	public int getTime() { return time; }
	public void setTime(int time) { this.time = time; }	
	
}
