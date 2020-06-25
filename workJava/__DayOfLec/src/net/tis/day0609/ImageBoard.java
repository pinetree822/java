package net.tis.day0609;




public class ImageBoard extends Board implements ImageBoardImp{

	
	public static void main(String[] args) {
		// 메인메소드 내용기술 않함
	}// main()
	
	public void mypage() {
		System.out.println("mypage메소드");
	}// mypage()

	// { body } 메소드 선언만 = 추상메소드 = abstract method
	@Override	// 삭제가능, 상속받았다는것을 설명할때 쓰임
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
