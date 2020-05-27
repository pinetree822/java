package net.tis.day22;


//http://ehpub.co.kr/java-3-3-5-break-%EB%A0%88%EC%9D%B4%EB%B8%94%EB%AC%B8/



public class exBreakLabel {

		public static void main(String[] args) {
			
//			int sum=0, i=0, j=0;
//			1exit_label :
//			
//				for(i=1;i<10;i++) {
//					for(j=1;j<10;j++) {
//						sum+=i*j;
//						if(sum>=1000) {
//							break exit_label;
//						}
//					}// for
//				}// for
//			
//			// 1*1+1*2+...7*4=1015
//			System.out.println("1*1+1*2+..." + i + "*" + j + "=" + sum);

			

			
			int sum=0, i=0, j=0, k=0;
			// 레이블 아래 일반문이 있으면 에러가 난다.
			exit_label :
			//
			exit2_label :
			//
			exit3_label :
			//
			exit4_label :
			//
				
				for(i=1;i<10;i++) {
					for(j=1;j<10;j++) {
						sum+=i*j;
						if(sum>=1000) {
							break exit_label;
						}
					}// for
				}// for


			// 1*1+1*2+...7*4=1015
			System.out.println("1*1+1*2+..." + i + "*" + j + "=" + sum);

			
			
			
		}// main
}// class exBreakLabel
