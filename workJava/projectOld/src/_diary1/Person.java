package _diary1;

public class Person {
	
	private String imageFile;
	private String name;
	private String group;
	private String phoneNumber;
	private String HomeNumber;
	private String addr;
	private String birth;
	private String email;
	private String memo;
	

	public Person() {
		
	}
	
	
	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	public String getHomeNumber() {
		return HomeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		HomeNumber = homeNumber;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString(){
		return name+" ["+phoneNumber+"]";
	}

}
