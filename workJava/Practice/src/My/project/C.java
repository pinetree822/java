package My.project;

import static My.project.A.*;
import static My.project.MyPart.*;

public class C {
	public static void temporalSave(){		
		//1---------------------------------------
		String str="안녕하세요 저는 강서구에 사는 29살 누구 입니다..\n 1년전에 자라에서 구매했는데 몇번 못입고 살이 너무 쩌버려서 팔게되었네요 ㅠㅜ\n 정말 아낀느 옷이라 좋은 분이 가져가셨으면 좋겠구요 \n택배비는 착불이에요..요즘 5천원 정도하더라구요 감안하시고 연락주세요 댓글로 남겨주세요~~~";
		String str1="안녕하세요 저는 강서구에 사는 29살 누구 입니다..\n 1년전에 자라에서 구매했는데 이제 그만 쓸래 ㅜㅜ \n 정말 좋은거라 좋은 분이 가져가셨으면 좋겠구요 \n택배비는 착불이에요..요즘 5천원 정도하더라구요 감안하시고 연락주세요 댓글로 남겨주세요~~~";
		dc1[0].setData("빨간코트","300","images/빨간코트.jpg",str,"옷","영등포구");
		dc1[1].setData("애기옷","300","images/애기옷.jpg",str,"옷","신사구");
		dc1[2].setData("한복","300","images/한복.jpg",str,"옷","강서구");
		dc1[3].setData("회색티","300","images/회색티.jpg",str,"옷","신사구");
		dc1[4].setData("흰셔츠","300","images/흰셔츠.jpg",str,"옷","강서구");
		//2---------------------------------------
		dc2[0].setData("갈색운동화","300","images/갈색운동화.jpg",str,"신발","강서구");
		dc2[1].setData("검정운동화","300","images/검정운동화.jpg",str,"신발","신사구");
		dc2[2].setData("네이비구두","300","images/네이비구두.jpg",str,"신발","강북구");
		dc2[3].setData("미니언운동화","300","images/미니언운동화.jpg",str,"신발","강북구");
		dc2[4].setData("베이지색워커","300","images/베이지색워커.jpg",str,"신발","강서구");
		dc2[5].setData("빨간운동화","300","images/빨간운동화.jpg",str,"신발","강서구");
		dc2[6].setData("하얀운동화","300","images/하얀운동화.jpg",str,"신발","강서구");
		//3---------------------------------------
		dc3[0].setData("네이비","5000","images/네이비.jpg",str,"잡화","강북구");
		dc3[1].setData("머리끈","5000","images/머리끈.jpg",str,"잡화","강북구");
		dc3[2].setData("빨강","5000","images/빨강.jpg",str,"잡화","영등포구");
		dc3[3].setData("파랑","5000","images/파랑.jpg",str,"잡화","강북구");
		dc3[4].setData("팔찌","5000","images/팔찌.jpg",str,"잡화","강서구");
		dc3[5].setData("휴대폰고리","5000","images/휴대폰고리.jpg",str,"잡화","강서구");
		//4---------------------------------------
		dc4[0].setData("가습기","200000","images/가습기.jpg",str1,"전자제품","신사구");
		dc4[1].setData("노트북","200000","images/노트북.jpg",str1,"전자제품","강서구");
		dc4[2].setData("디카","200000","images/디카.jpg",str1,"전자제품","신사구");
		dc4[3].setData("커피포트","200000","images/커피포트.jpg",str1,"전자제품","신사구");
		//5---------------------------------------
		dc5[0].setData("그림의힘","200","images/그림의힘.jpg",str1,"책","영등포구");
		dc5[1].setData("마시멜로이야기","200","images/마시멜로이야기.jpg",str1,"책","영등포구");
		dc5[2].setData("습관의힘","200","images/습관의힘.jpg",str1,"책","영등포구");
		dc5[3].setData("어떤하루","200","images/어떤하루.jpg",str1,"책","영등포구");
		//6---------------------------------------
		dc6[0].setData("오리","2000","images/오리.jpg",str1,"유아용품","신사구");
		dc6[1].setData("의자","6000","images/의자.jpg",str1,"유아용품","강남구");
		dc6[2].setData("젖꼭지","6000","images/젖꼭지.jpg",str1,"유아용품","영등포구");
		dc6[3].setData("젖병","6000","images/젖병.jpg",str1,"유아용품","강남구");
		dc6[4].setData("턱받침","6000","images/턱받침.jpg",str1,"유아용품","강남구");
		int j=0;
		for(int k=1;k<=6;k++){
			System.out.println("************>>>"+k+"<<<<num="+num[k-1]);
			for(int i=0; i<num[k-1];i++){
				System.out.println("************###"+i+", num="+num[k-1]);
				dc[j]=hDC.get(k)[i];
				System.out.println(dc[j]+"<<<<<<<<<<<<<<");
				j++;
			}
		  }
		
		
		
	}
}

