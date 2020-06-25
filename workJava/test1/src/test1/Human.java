package test1;

/*Overriding(메소드 재정의)
 * : 부모의 메소드를 자식 클래스에서 다시 정의하여
 *   구성하는 것
 *   규칙*************************************
 *   1) 부모의 것과 메소드 이름은 동일하게
 *   2) 매개변수의 자료형,갯수,순서 모두 같아야 한다.
 *   3) 반환타입도 부모의 것과 동일하게
 *   4) 접근지정자는 부모의 것과 동일하거나 더 넓은 범위의
 *      지정자 사용이 가능하다.
 *   5)  Exception의 경우 부모 클래스의 메소드와
		동일하거나 더 구체적인 Exception을 발생시켜야 한다
	
	..대신 메소드 바디는 부모와 다르게 구성	  
 *	******************************************** */
public class Human{
	String name;
	int height;
	
	public Human(String n, int h){
		name=n;
		height=h;
	}
	
	public void showInfo(){
		System.out.println("이름: "+name);
		System.out.println("키  : "+height);
	}
}///////////////////////////////////////
class Superman extends Human
{
	int power;
	public Superman(){
		//this("슈퍼맨",170,120);
		super("슈퍼맨",170);//부모의 기본생성자를 묵시적으로 호출함
		
	}
	public Superman(String n, int h, int p){
		super(n,h);		
		power=p;
	}
	
	@Override
	public void showInfo(){
		super.showInfo();
		System.out.println("초능력: "+power);
	}
	
	public void showInfo(String title){//Overload
		System.out.println(title);
		this.showInfo();
		/*super.showInfo();
		System.out.println("초능력: "+power);*/
	}
	
	public String showInfo(String title, int pw){//Overload
		String str="";
			this.showInfo(title);
			/*str+=title+"\n";
			str+="이름: "+name+"\n";
			str+="키  : "+height+"\n";
			str+="초능력: "+power+"\n";*/
			power+=pw;
			str+=">>>초능력 UP>>"+power+"<<<\n";
			return str;
	}
	
	
}////////////////////////////////////////
class Aquaman extends Human{
	double speed;
	public Aquaman(String n, int h, double s){
		super(n,h);		
		speed=s;
	}
	//showInfo()를 재정의하세요
	//@Override어노테이션을 지정하면 오버라이딩 조건에
	//위배될 경우 컴파일러가 이를 알려준다.
	@Override
	public void showInfo()
	{
		super.showInfo();
		System.out.println("스피드: "+speed);
		
	}
	//showInfo()메소드를 오버로드 하기
	public void showInfo(String title){
		System.out.println(title);
		showInfo();
	}
	
	
}////////////////////////////////////////






