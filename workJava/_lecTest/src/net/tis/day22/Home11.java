package net.tis.day22;

public class Home11 {

//	 int su1=5;
//	 int su2=7;
//	 int su3=6;
//	 int temp=0; //ºóÄÅ¿ªÇÒ
//	 ÃÖ´ë°ª = 7 
	
	public static void main(String[] args) {
		 int su1=5;
		 int su2=7;
		 int su3=6;
		 int temp=0; //ºóÄÅ¿ªÇÒ

//		 if(su1>temp) { temp = su1; }
//		 if(su2>temp) { temp = su2; }
//		 if(su3>temp) { temp = su3; }
		 
		 temp = sort1(su1,temp);
		 temp = sort1(su2,temp);
		 temp = sort1(su3,temp);
		 System.out.printf("ÃÖ´ë°ª %d", temp);
	}// main
	
	static int sort1(int a, int b) {
		if(a<b) a=b;
		return a;
	}
}
