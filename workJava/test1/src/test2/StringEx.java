package test2;

public class StringEx {

	public static void main(String[] args) {
		String name = "Ja" + "va";
		String str = name + 8.0;

		System.out.println("name = " + name);
		System.out.println("str = " + str);
		System.out.println("7+\" \" = " + 7+" ");
		System.out.println("\" \" + 7 = " + " " + 7);
		System.out.println("7 + \"\" = " + 7 + "");
		System.out.println("\"\" + 7 = " + "" + 7);
		System.out.println("\"\" + \"\" = " + "" + "");
		System.out.println(" 7 + 7 + \"\" = " + 7 + 7 + "");
		System.out.println("\"\" + 7 + 7 = " + "" + 7 + 7);
		
		//System.out.println("8*\" \" = " + 8*" "); // �����Ͽ����� ��
		//System.out.println("8/\" \" = " + 8/" "); // �����Ͽ����� ��
		//System.out.println("8-\" \" = " + 8-" "); // �����Ͽ����� ��

		//System.out.println("9-8+\" \" = " + 9 - 8 + " "); // // �����Ͽ����� ��
		System.out.println("9-8+\" \" = " + (9 - 8) + " "); // ������� : 1
		
		
	}//public static void main(String[] args)

}//public class StringEx 

/*
 * (+) ������
 * 
 * ���ʿ��� ���������� ���
 * 
 * �������� ������ ������ ���ǰ� 
 * �������� ���ڿ� ����Ѵ�.
 * 
 * 1 + 2 +"3"
 * 1 �� ������ ���	-> ���� 1
 * 2 �� ������ ���	-> ���� 3
 * 3 �� ���ڿ� ���	-> ���� "33"
 * 
	name 			= Java
	str 			= Java8.0
	7+" " 			= 7 
	" " + 7 		=  7
	7 + "" 		= 7
	"" + 7 		= 7
	"" + "" 		= 
	 7 + 7 + "" 	= 77
	"" + 7 + 7 	= 77
	9-8+" " = 1 
*/