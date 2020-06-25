package test1;

/*Overriding(�޼ҵ� ������)
 * : �θ��� �޼ҵ带 �ڽ� Ŭ�������� �ٽ� �����Ͽ�
 *   �����ϴ� ��
 *   ��Ģ*************************************
 *   1) �θ��� �Ͱ� �޼ҵ� �̸��� �����ϰ�
 *   2) �Ű������� �ڷ���,����,���� ��� ���ƾ� �Ѵ�.
 *   3) ��ȯŸ�Ե� �θ��� �Ͱ� �����ϰ�
 *   4) ���������ڴ� �θ��� �Ͱ� �����ϰų� �� ���� ������
 *      ������ ����� �����ϴ�.
 *   5)  Exception�� ��� �θ� Ŭ������ �޼ҵ��
		�����ϰų� �� ��ü���� Exception�� �߻����Ѿ� �Ѵ�
	
	..��� �޼ҵ� �ٵ�� �θ�� �ٸ��� ����	  
 *	******************************************** */
public class Human{
	String name;
	int height;
	
	public Human(String n, int h){
		name=n;
		height=h;
	}
	
	public void showInfo(){
		System.out.println("�̸�: "+name);
		System.out.println("Ű  : "+height);
	}
}///////////////////////////////////////
class Superman extends Human
{
	int power;
	public Superman(){
		//this("���۸�",170,120);
		super("���۸�",170);//�θ��� �⺻�����ڸ� ���������� ȣ����
		
	}
	public Superman(String n, int h, int p){
		super(n,h);		
		power=p;
	}
	
	@Override
	public void showInfo(){
		super.showInfo();
		System.out.println("�ʴɷ�: "+power);
	}
	
	public void showInfo(String title){//Overload
		System.out.println(title);
		this.showInfo();
		/*super.showInfo();
		System.out.println("�ʴɷ�: "+power);*/
	}
	
	public String showInfo(String title, int pw){//Overload
		String str="";
			this.showInfo(title);
			/*str+=title+"\n";
			str+="�̸�: "+name+"\n";
			str+="Ű  : "+height+"\n";
			str+="�ʴɷ�: "+power+"\n";*/
			power+=pw;
			str+=">>>�ʴɷ� UP>>"+power+"<<<\n";
			return str;
	}
	
	
}////////////////////////////////////////
class Aquaman extends Human{
	double speed;
	public Aquaman(String n, int h, double s){
		super(n,h);		
		speed=s;
	}
	//showInfo()�� �������ϼ���
	//@Override������̼��� �����ϸ� �������̵� ���ǿ�
	//����� ��� �����Ϸ��� �̸� �˷��ش�.
	@Override
	public void showInfo()
	{
		super.showInfo();
		System.out.println("���ǵ�: "+speed);
		
	}
	//showInfo()�޼ҵ带 �����ε� �ϱ�
	public void showInfo(String title){
		System.out.println(title);
		showInfo();
	}
	
	
}////////////////////////////////////////






