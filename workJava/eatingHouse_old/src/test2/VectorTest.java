package test2;
import java.util.*;

public class VectorTest{
    
    public static void main(String[] args) {
        
        Vector<Member> shopmem = new Vector<Member>();
        
        System.out.println("shopmem의 크기 : "+ shopmem.size());			// shopmem 싸이즈
        System.out.println("shopmem의 용량 : "+ shopmem.capacity());		// shopmem 메모리크기

        // 제일 첫번째 데이타 들어가는 위치는 0번째  그이후 1,2,3,..
        // Vector 데이타 -> {{0,member}, {1,member}, {2,member}} 순차적으로 데이타가 들어간다.
        
        shopmem.addElement(new Member(1, "슈퍼맨", "1234" ));// shopmem 끝에 추가(데이타 추가)
        shopmem.addElement(new Member(2, "홍길동", "1234" ));
        shopmem.addElement(new Member(3, "마징가", "1234" ));
        shopmem.addElement(new Member(4, "캔디", "1234" ));
        shopmem.addElement(new Member(5, "짱구", "1234" ));
        shopmem.addElement(new Member(6, "짱구아빠", "1234" ));
        shopmem.addElement(new Member(7, "짱구엄마", "1234" ));
        shopmem.addElement(new Member(8, "슛돌이", "1234" ));
        shopmem.addElement(new Member(9, "짱가", "1234" ));
        shopmem.addElement(new Member(10, "왕구", "1234" ));
        shopmem.addElement(new Member(11, "슈퍼맨", "1234" ));
        shopmem.addElement(new Member(12, "홍길동", "1234" ));
        shopmem.addElement(new Member(13, "마징가", "1234" ));
        shopmem.addElement(new Member(14, "캔디", "1234" ));
        shopmem.addElement(new Member(15, "짱구", "1234" ));
        shopmem.addElement(new Member(16, "짱구아빠", "1234" ));
        shopmem.addElement(new Member(17, "짱구엄마", "1234" ));
        shopmem.addElement(new Member(18, "슛돌이", "1234" ));
        shopmem.addElement(new Member(19, "짱가", "1234" ));
        shopmem.addElement(new Member(20, "왕구", "1234" ));
        shopmem.addElement(new Member(21, "백빠지", "1234" ));
        shopmem.addElement(new Member(22, "대가리", "1234" ));

        //  0번째 데이타 읽기
        System.out.println("변경전 shopmem의 첫번째 요소의 id : "+shopmem.elementAt(0).getId()); //  첫번째 회원 아이디
        System.out.println("데이터 삽입 후 shopmem의 크기 : "+ shopmem.size());
        //System.out.println("데이터 삽입 후 shopmem의 용량 : "+ shopmem.capacity());
        System.out.println();

        
        // 0번째 데이타 슈퍼맨 -> 원더우맨 추가 -----------------> 데이타 추가됨
        shopmem.add(0, new Member(1, "원더우먼", "1234" ));
        System.out.println("변경후 shopmem의 0번째 요소의 추가 id : "+shopmem.elementAt(0).getId()); // 0 번째
        System.out.println("변경후 shopmem의 1번째 요소의 추가 id : "+shopmem.elementAt(0).getId()); // 1 번째
        System.out.println("데이터 삽입 후 shopmem의 크기 : "+ shopmem.size());
        //System.out.println("데이터 삽입 후 shopmem의 용량 : "+ shopmem.capacity());
        System.out.println();
        
        
        
        // 1번째 데이타 홍길동 -> 아쿠아맨 변경 ---------------> 데이타가 변하지 않음
        shopmem.elementAt(0).setId("아쿠아맨");
        System.out.println("변경후 shopmem의 0번째 요소의 변경 아이디  : "+shopmem.elementAt(0).getId()); // 0 번째
        System.out.println("변경후 shopmem의 1번째 요소의 변경 아이디  : "+shopmem.elementAt(1).getId()); // 1 번째
        System.out.println("데이터 삽입 후 shopmem의 크기 : "+ shopmem.size());
        //System.out.println("데이터 삽입 후 shopmem의 용량 : "+ shopmem.capacity());
        System.out.println("회원수는 ? : "+ shopmem.size());
        System.out.println();
        
        
        
        
        // page 분류
        int shopcnt = shopmem.size();										// 상점수
        int lineperpage = 10;													// 페이지당 상점수
        int firstpage = 1;														// 첫페이지
        int allpage = shopcnt/lineperpage;									// 총페이지
        int nowpage = 2;														// 현재페이지 0-9, 10-19, 20-29
        int nextpage = (((nowpage+1)>allpage)?allpage:1);				// 다음페이지
        int prevpage = (((nowpage-1)<=firstpage)?(nowpage-1):1);		// 이전페이지
        int lastpage = allpage;													// 끝페이지
        System.out.println("총페이지수는  : "	+	allpage );
        System.out.println("첫페이지는  : "	+	firstpage );
        System.out.println("이전페이지는 : "	+	prevpage);
        System.out.println("현재페이지는  : "	+	nowpage );
        System.out.println("다음페이지는 : "	+	nextpage);
        System.out.println("끝페이지는 : "+ lastpage);
        //System.out.println("데이터 삽입 후 shopmem의 용량 : "+ shopmem.capacity());
        System.out.println("회원수는 ? : "+ shopcnt);
        
        
        
        // 현재 리스트 출력
        for(int i=nowpage*lineperpage; i < (nowpage+1)*lineperpage; i++ ){
    		try{
    			System.out.println( "회원데이타 " + (i+1) + "번째 아이디 :  " + shopmem.elementAt(i).getId() );
    		} catch(ArrayIndexOutOfBoundsException e){
    			//System.out.println("ArrayInexOutOfBoundsException 에러가 났습니다.");
    			//System.out.println();	
    		}
        }



		// shopmem(30) - 31번째 데이타 읽기   ----------> 에러남
		try{
			System.out.println("데이타가 없는 shopmem(30) id : "+shopmem.elementAt(30).getId()); // 
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayInexOutOfBoundsException 에러가 났습니다.");
			System.out.println();	
		}
        
        
        shopmem.removeAllElements();// 데이타 모두 삭제
        System.out.println("회원수는 ? : "+ shopmem.size());
        System.out.println("데이터 삭제 후 shopmem의 용량 : "+ shopmem.capacity());
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
