package net.tis.day0604;

import java.util.Scanner;


public class Gabb {
	// �迭����, ������x, �ʵ����x, �޼ҵ�и�x
	// try~catch��������, ����ó��, �޼������, equals()
	
	
	public static void main(String[] args) {

		System.out.println("[ Bllizard Entertainment Development Office ]");
		System.out.println();
//		Gabb gg=new Gabb();// gg������Ʈ=gg��ü=gg�ν��Ͻ�
		new Gabb();// ��ü�̸��� ������ �͸��� ��ü=anonymous
	}// main()
	
	
	public Gabb() {
		
		int com=0, my=0;// com�� ���̻����� ����, my�� ���� ���� ����,
		int win=0, lose=0, Gtotal=0;//�̱�,��,��
		String com_msg="", my_msg="", msg="";// com_msg=�ָ�, my_msg=���ڱ�
		boolean flag=true;
		Scanner sc = new Scanner(System.in);
		int sel=0;// ���� �Է°�
		
		while(flag)
		{
			// �ȳ���
			System.out.println("1.���� 2.���� 3.�� 9.���� >>> ");
			try {
				// ����.����.�� ����
				// ���ڷ� �ý�
				if(sc.hasNextInt()) {// **����ó���� �ʵǾ��ִ�.
					my=Integer.parseInt(sc.nextLine());// �Է¹޾Ƽ� ����ȭ ����
				} else {
					String myTmp=sc.nextLine();// �Է¹޾Ƽ� ���ڿ� ����
					my=myTmp.equals("����")?1:myTmp.equals("����")?2:myTmp.equals("��")?3:myTmp.equals("����")?9:myTmp.equals("")?9:4;
				}
			} catch (Exception e) {}// try
			
			if(my<4 && my > 0) {
//				com = ((int)(Math.random()*100)%3+1);
				com = ((int)(Math.random()*3)+1);
				
				com++;		// �ļ���
				my++;		// ����ڼ���
				Gtotal++;	// ����� Ƚ��

				// ���ڷ� ǥ��
				com_msg = com==2?"����":com==3?"����":com==4?"��":"";
				my_msg  = my==2?"����":my==3?"����":my==4?"��":"";
				System.out.println("com = " + com_msg + ", my = " + my_msg);
				
				// -1 < 0 < 1 :�̱��<����<����
				if(com-my == -1) {
					win++;
					msg="�̰���ϴ�.";
				}else if(com-my == 1) {
					lose++;
					msg="�����ϴ�.";
				} else {
					msg="�����ϴ�.";
				}
				System.out.println(msg);
				
			} else {
				if(my==9) flag=false;
				else {
					System.out.println("------------------");
					System.out.println("1���� 3���� �Է����ּ���.");
					System.out.println("------------------");
					continue;
				}
			}// else
		}// while


//		// ����޼��� ���
		System.out.println("====================");
		System.out.println("���������� ������ �����մϴ�.");
		System.out.println("��="+Gtotal+"ȸ ��="+win+" ��="+lose+" ���º�="+(Gtotal-(win+lose)));
		
		
	}// Gabb()
	
}// class Gabb









// ����.����.�� ���Ȯ��
// ���º�
// �̱� / ����<����, ����<��, ��<���� = 
// ��				

//System.out.println(((int)(Math.random()*100)%3+1));
//System.out.println(((int)Math.random()%3*10)+1);
//if(9==9) break;
//
//switch (({1,2,3}))
//{
//	case 1 :
//		break;
//	case 2 :
//		break;
//	case 3:
//		break;
//	default :
//		break;
//}
//// ��������
//
//// ����޼��� ���
//if(sel==9) {
//	System.out.println("���������� ������ �����մϴ�.");
//	flag=false; break;
//}
//
//if(sel==1) {}




//0010-0011=0001-  : �� - �̱�
//0011-0100=0001-	 : �� - �̱�
//0100-0011=0001-  : �� - �̱�

//0100-0011=0001  : �̱� - �� 
//0011-0010=0001  : �̱� - ��
//0010-0001=0001  : �̱� - ��


//Jsp ����������
//https://itstudyroom.tistory.com/128

//php ����������
//https://zetawiki.com/wiki/PHP_%EA%B0%80%EC%9C%84%EB%B0%94%EC%9C%84%EB%B3%B4_%EA%B2%BD%EC%9A%B0%EC%9D%98_%EC%88%98_%EC%B6%9C%EB%A0%A5

//�ڹٽ�ũ��Ʈ ����������
//https://2boki.tistory.com/97
//
//���̽� ����������
//https://thrillfighter.tistory.com/448

// C��� ����������
// http://cafe.daum.net/skycic/PYid/69?q=c%20and%20or%20%EA%B0%80%EC%9C%84%EB%B0%94%EC%9C%84%EB%B3%B4
//
//
//c���� Ǭ ����������
//
//
//#include <stdio.h>
//
//
//int main(void)
//
//{
//
//   int user, computer, i = 0;  // ���� ����
//
//
//
//   while (i< 5)   // while�� 5�� �ݺ�
//
//   {
//
//      printf("����, ����, �� ���ӿ� ���� ���� ȯ���մϴ�. \n");  // �ȳ��� ���
//
//      printf("�ϳ��� �����ϼ���(����-0, ����-1, ��-2): ");
//
//      scanf("%d", &user);  // ����ڷκ��� ������������ �����Ǵ� ���� �Է¹޾� user ������ ����
//
//
//
//      i++;  // i��(����Ƚ��) 1����
//
//      computer = rand() % 3;  // ���� computer�� 0~2 ������ ������ ����
//
//      printf("�����=%d\n", user);  // ������� ���� ���
//
//      printf("��ǻ��=%d\n", computer); // ��ǻ���� ���� ���
//
//
//
//      if ((user + 1) % 3 == computer)  // ������ �������� ���������� �󼺰��� �����Ͽ� ��ǻ���� �¸��� ���
//
//         printf("��ǻ�� �¸� \n");
//
//      else if (computer == user) // ���º��� ���
//
//         printf("����� \n");
//
//      else   // �� ���� ��� ����� �¸�
//
//         printf("����� �¸� \n");
//
//   }
//
//   return 0;
//
//}








