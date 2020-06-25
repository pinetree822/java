package test1;

public class Overloading {
	//m99-922-380
	public static void main(String[] args) {
		Superman s1=new Superman();
		/*s1.name="김슈퍼";//s1.setName("김슈퍼");
		s1.height=177;//s1.setHeight(177);
		s1.power=200;*/
		s1.showInfo();
		
		Superman s2=new Superman();
		s2.showInfo();
		
	}
}/////////////////////////////////
class Superman1{
	String name;
	int height;
	int power;
	//생성자 오버로딩(Constructor Overloading)
	public Superman1()//기본 생성자(default 생성자)
	{	//생성자 역할: 멤버변수 초기화
		name="슈퍼맨";
		height=150;
		power=100;
	}
	public Superman1(String name)//인자 생성자
	{	//멤버변수와 지역변수가 이름이 같은 경우
		//멤버변수 앞에 this.을 붙여 구분해준다.
		this.name=name;	
		height=150;
		power=100;
	}
	public Superman1(String name,int height)
	{
		this.name=name;
		this.height=height;
		power=50;
	}
	
	public void showInfo()
	{
		System.out.println("---슈퍼맨 정보---");
		System.out.println("이  름: "+name);
		System.out.println("키    : "+height);
		System.out.println("초능력: "+power);
	}
	
}////////////////////////////////
class Aquaman1{
	String name;
	int height;
	double speed;
	
}///////////////////////////////////









