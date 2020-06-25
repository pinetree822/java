package net.tis.day0604;

import java.util.Date;

public class GuestDTO {

	// Data Transfer Object=객체
	
	private int sabun;
	private String title;
	private String email;
	private int pay;
	private Date wdate;
	
	String keyword="티볼리";
	// this키워드는 static상극
	// this키워드는 non-static접근
	// this키워드는 현재클래스 non-static
	
	/**
	 * @param keyword
	 */
	
	public void search(String keyword) {
		System.out.println("괄호 keyword " + keyword);
		System.out.println("필드 keyword " + keyword);
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
