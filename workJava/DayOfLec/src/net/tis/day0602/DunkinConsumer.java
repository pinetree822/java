package net.tis.day0602;


// Dunkin Class
class Dunkin
{
	public Dunkin() {}
	public Dunkin(String place) {}
	public void coffee() { 
		//"맛있는 커피";
		
	}
}

// 소비자 클래스
public class DunkinConsumer
{
//	coffee();// error
//	Dunkin.coffee();// error
	Dunkin dk1 = new Dunkin("광화문");
	Dunkin dk2 = new Dunkin();
//	dk2.coffee();

}
