package net.tis.day0602;


// Dunkin Class
class Dunkin
{
	public Dunkin() {}
	public Dunkin(String place) {}
	public void coffee() { 
		//"���ִ� Ŀ��";
		
	}
}

// �Һ��� Ŭ����
public class DunkinConsumer
{
//	coffee();// error
//	Dunkin.coffee();// error
	Dunkin dk1 = new Dunkin("��ȭ��");
	Dunkin dk2 = new Dunkin();
//	dk2.coffee();

}
