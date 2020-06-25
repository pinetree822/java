package net.tis.day0609;




public interface ImageBoardImp {

	// { body } 메소드 선언만 = 추상메소드 = abstract method
	public void search(String item);
	public boolean delete(int id);
	public int getTotal();
	
}
