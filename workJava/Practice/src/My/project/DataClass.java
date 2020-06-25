package My.project;

import java.util.*;
public class DataClass {
  //필요한 저장소
	//상품명, 가격, 이미지, 상품 내용, 카테고리1, 카테고리2
	//댓글, 게시자
	//
	public static final int TOT_MAX= 600;
	public static final int SUB_MAX=200;
	
	public String vProductName = new String("");
	public String vPrice = new String("");
	public String vImage = new String("");
	public String vContents = new String("");
	public String vCat1 = new String("");
	public String vCat2 = new String("");
	public String vComment = new String("");
	public String vSeller = new String("");
	
	public int IDX=0;//각 객체별 상품번호 저장
	
	public Hashtable<String,Integer> hashPage=new Hashtable<String,Integer>();
	
	public void hashInput(){
		hashPage.put("전체", 0);hashPage.put("옷", 0);
		hashPage.put("신발", 0);hashPage.put("잡화", 3);		
		hashPage.put("전자제품", 0);hashPage.put("책", 0);
		hashPage.put("유아용품", 0);
	}
	
	
	//구지 사용하지 않아도 됨.
	public DataClass(){
	}
	public void setData(String PName,String pri,String img, 
			String cont,String cat1,String cat2){
		this.vProductName = PName;
		this.vPrice=pri;
		this.vImage=img;
		this.vContents=cont;
		this.vCat1=cat1;
		this.vCat2=cat2;
	}
	public void setComments(String com){
		this.vComment=com;
	}
}
