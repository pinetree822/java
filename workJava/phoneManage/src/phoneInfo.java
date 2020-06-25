import java.io.*;

class phoneInfo implements Serializable
{
	String name;
	String phone;
	
	public phoneInfo(String name, String phone)
	{
		this.name=name;
		this.phone=phone;
	}
	public String toString()
	{
		return "이름: " + name + '\n' + "전화번호: " + phone + '\n';
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public boolean equals(Object obj)
	{
		phoneInfo comp=(phoneInfo)obj;
		if(comp.name.equals(name))
			return true;
		else 
			return false;
	}
}

class companyInfo extends phoneInfo
{
	String company;

	public companyInfo(String name, String phone, String company)
	{
		super(name, phone);
		this.company=company;
	}
	
	public String toString()
	{
		return super.toString()+ "회사: "+company;
	}
}

class univInfo extends phoneInfo 
{
	String univName;
	
	public univInfo(String name, String phone, String univName)
	{
		super(name, phone);
		this.univName=univName;
	}
	
	public String toString()
	{
		return super.toString()+ "학교: "+univName;
	}
}
