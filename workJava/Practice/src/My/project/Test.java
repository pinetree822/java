package My.project;

public class Test {

	public static void main(String[] args) {
		DataClass []dc=new DataClass[200];
		dc[0].setData("�ٶ����̾߱�","200","images/a.jpg","������ ��ȭ�� �ݴϴ�.","å","��������");
		dc[1].setData("�ֱ��","6000","images/b.jpg","�۾ƿ�","���ƿ�ǰ","������");
		dc[2].setData("����","5000","images/c.jpg","�������̿���","��ȭ","���ϱ�");
		dc[3].setData("��ĿƮ","300","images/d.jpg","ª�ƿ�","��","������");
		dc[4].setData("�ڵ���","200000","images/e.jpg","3����","������ǰ","�Ż籸");
		
		
		String str = dc[0].vPrice;
	}

}
