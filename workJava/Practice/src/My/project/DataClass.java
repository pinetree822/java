package My.project;

import java.util.*;
public class DataClass {
  //�ʿ��� �����
	//��ǰ��, ����, �̹���, ��ǰ ����, ī�װ�1, ī�װ�2
	//���, �Խ���
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
	
	public int IDX=0;//�� ��ü�� ��ǰ��ȣ ����
	
	public Hashtable<String,Integer> hashPage=new Hashtable<String,Integer>();
	
	public void hashInput(){
		hashPage.put("��ü", 0);hashPage.put("��", 0);
		hashPage.put("�Ź�", 0);hashPage.put("��ȭ", 3);		
		hashPage.put("������ǰ", 0);hashPage.put("å", 0);
		hashPage.put("���ƿ�ǰ", 0);
	}
	
	
	//���� ������� �ʾƵ� ��.
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
