package net.tis.day0609;




public class ImageBoard extends Board implements ImageBoardImp{

	
	public static void main(String[] args) {
		// ���θ޼ҵ� ������ ����
	}// main()
	
	public void mypage() {
		System.out.println("mypage�޼ҵ�");
	}// mypage()

	// { body } �޼ҵ� ���� = �߻�޼ҵ� = abstract method
	@Override	// ��������, ��ӹ޾Ҵٴ°��� �����Ҷ� ����
	public void search(String item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}// class ImageBoard
