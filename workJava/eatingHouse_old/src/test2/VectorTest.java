package test2;
import java.util.*;

public class VectorTest{
    
    public static void main(String[] args) {
        
        Vector<Member> shopmem = new Vector<Member>();
        
        System.out.println("shopmem�� ũ�� : "+ shopmem.size());			// shopmem ������
        System.out.println("shopmem�� �뷮 : "+ shopmem.capacity());		// shopmem �޸�ũ��

        // ���� ù��° ����Ÿ ���� ��ġ�� 0��°  ������ 1,2,3,..
        // Vector ����Ÿ -> {{0,member}, {1,member}, {2,member}} ���������� ����Ÿ�� ����.
        
        shopmem.addElement(new Member(1, "���۸�", "1234" ));// shopmem ���� �߰�(����Ÿ �߰�)
        shopmem.addElement(new Member(2, "ȫ�浿", "1234" ));
        shopmem.addElement(new Member(3, "��¡��", "1234" ));
        shopmem.addElement(new Member(4, "ĵ��", "1234" ));
        shopmem.addElement(new Member(5, "¯��", "1234" ));
        shopmem.addElement(new Member(6, "¯���ƺ�", "1234" ));
        shopmem.addElement(new Member(7, "¯������", "1234" ));
        shopmem.addElement(new Member(8, "������", "1234" ));
        shopmem.addElement(new Member(9, "¯��", "1234" ));
        shopmem.addElement(new Member(10, "�ձ�", "1234" ));
        shopmem.addElement(new Member(11, "���۸�", "1234" ));
        shopmem.addElement(new Member(12, "ȫ�浿", "1234" ));
        shopmem.addElement(new Member(13, "��¡��", "1234" ));
        shopmem.addElement(new Member(14, "ĵ��", "1234" ));
        shopmem.addElement(new Member(15, "¯��", "1234" ));
        shopmem.addElement(new Member(16, "¯���ƺ�", "1234" ));
        shopmem.addElement(new Member(17, "¯������", "1234" ));
        shopmem.addElement(new Member(18, "������", "1234" ));
        shopmem.addElement(new Member(19, "¯��", "1234" ));
        shopmem.addElement(new Member(20, "�ձ�", "1234" ));
        shopmem.addElement(new Member(21, "�����", "1234" ));
        shopmem.addElement(new Member(22, "�밡��", "1234" ));

        //  0��° ����Ÿ �б�
        System.out.println("������ shopmem�� ù��° ����� id : "+shopmem.elementAt(0).getId()); //  ù��° ȸ�� ���̵�
        System.out.println("������ ���� �� shopmem�� ũ�� : "+ shopmem.size());
        //System.out.println("������ ���� �� shopmem�� �뷮 : "+ shopmem.capacity());
        System.out.println();

        
        // 0��° ����Ÿ ���۸� -> ������� �߰� -----------------> ����Ÿ �߰���
        shopmem.add(0, new Member(1, "�������", "1234" ));
        System.out.println("������ shopmem�� 0��° ����� �߰� id : "+shopmem.elementAt(0).getId()); // 0 ��°
        System.out.println("������ shopmem�� 1��° ����� �߰� id : "+shopmem.elementAt(0).getId()); // 1 ��°
        System.out.println("������ ���� �� shopmem�� ũ�� : "+ shopmem.size());
        //System.out.println("������ ���� �� shopmem�� �뷮 : "+ shopmem.capacity());
        System.out.println();
        
        
        
        // 1��° ����Ÿ ȫ�浿 -> ����Ƹ� ���� ---------------> ����Ÿ�� ������ ����
        shopmem.elementAt(0).setId("����Ƹ�");
        System.out.println("������ shopmem�� 0��° ����� ���� ���̵�  : "+shopmem.elementAt(0).getId()); // 0 ��°
        System.out.println("������ shopmem�� 1��° ����� ���� ���̵�  : "+shopmem.elementAt(1).getId()); // 1 ��°
        System.out.println("������ ���� �� shopmem�� ũ�� : "+ shopmem.size());
        //System.out.println("������ ���� �� shopmem�� �뷮 : "+ shopmem.capacity());
        System.out.println("ȸ������ ? : "+ shopmem.size());
        System.out.println();
        
        
        
        
        // page �з�
        int shopcnt = shopmem.size();										// ������
        int lineperpage = 10;													// �������� ������
        int firstpage = 1;														// ù������
        int allpage = shopcnt/lineperpage;									// ��������
        int nowpage = 2;														// ���������� 0-9, 10-19, 20-29
        int nextpage = (((nowpage+1)>allpage)?allpage:1);				// ����������
        int prevpage = (((nowpage-1)<=firstpage)?(nowpage-1):1);		// ����������
        int lastpage = allpage;													// ��������
        System.out.println("������������  : "	+	allpage );
        System.out.println("ù��������  : "	+	firstpage );
        System.out.println("������������ : "	+	prevpage);
        System.out.println("������������  : "	+	nowpage );
        System.out.println("������������ : "	+	nextpage);
        System.out.println("���������� : "+ lastpage);
        //System.out.println("������ ���� �� shopmem�� �뷮 : "+ shopmem.capacity());
        System.out.println("ȸ������ ? : "+ shopcnt);
        
        
        
        // ���� ����Ʈ ���
        for(int i=nowpage*lineperpage; i < (nowpage+1)*lineperpage; i++ ){
    		try{
    			System.out.println( "ȸ������Ÿ " + (i+1) + "��° ���̵� :  " + shopmem.elementAt(i).getId() );
    		} catch(ArrayIndexOutOfBoundsException e){
    			//System.out.println("ArrayInexOutOfBoundsException ������ �����ϴ�.");
    			//System.out.println();	
    		}
        }



		// shopmem(30) - 31��° ����Ÿ �б�   ----------> ������
		try{
			System.out.println("����Ÿ�� ���� shopmem(30) id : "+shopmem.elementAt(30).getId()); // 
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayInexOutOfBoundsException ������ �����ϴ�.");
			System.out.println();	
		}
        
        
        shopmem.removeAllElements();// ����Ÿ ��� ����
        System.out.println("ȸ������ ? : "+ shopmem.size());
        System.out.println("������ ���� �� shopmem�� �뷮 : "+ shopmem.capacity());
        System.out.println();
    }
}



/*class shopMember extends Member {

	public shopMember(int num, String id, String pass) {
		super(num, id, pass);
		// TODO Auto-generated constructor stub
	}
	
}*/
class Member {
	public int num;
	public String id;
	public String pass;
	
	public Member(int num, String id, String pass) {
		setNum(num);
		setId(id);
		setPass(pass);
	}
	public int getNum(){
		return this.num;
	}
	public void setNum(int num){
		this.num = num;
	}
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getPass(){
		return pass;
	}
	public void setPass(String pass){
		this.pass = pass;
		
	}
	public String allPrint(){
		return new String(getNum() + "," + getId() + "," + getPass());
	}
}
/*
public class Member {
	protected int num;
	protected String id;
	protected String pass;
	protected String name;
	protected String photo;
	protected String type;
	protected String tel;
	protected String addr;
	protected String addinfo;
	protected int rating;
	protected String menu;
	protected String regday;
	
	public void Member() {
	}
}
*/
