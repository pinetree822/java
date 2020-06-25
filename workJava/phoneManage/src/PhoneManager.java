import java.util.HashSet;
import java.util.Iterator;
import java.io.*; 

 public class PhoneManager {
	HashSet<phoneInfo> personalData=new HashSet<phoneInfo>();
	
	static PhoneManager inst=null;
	
	public static PhoneManager createManagerInst()
	{
		if(inst==null)
			inst=new PhoneManager();
		
		return inst;
	}
	
	public String searchName(String name)
	{
		phoneInfo info=search(name);
		if(info==null)
			return null;
		else
			return info.toString();
	}
	
	public phoneInfo search(String name)
	{
		PhoneManager manager=PhoneManager.createManagerInst();
		Iterator<phoneInfo> itr=manager.personalData.iterator();
		
		while(itr.hasNext())
		{
			phoneInfo info=itr.next();
			if(info.name.equals(name))
				return info;
		}

			return null;	
	}
	public void saveObject()
	{
		PhoneManager manager=PhoneManager.createManagerInst();
		Iterator<phoneInfo> itr=manager.personalData.iterator();
		
		try{
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("object.ser"));
			while(itr.hasNext())
			{
				phoneInfo info=itr.next();
				out.writeObject(info);
			}
		}
		catch(IOException io)
		{
			return;
		}
	}
	
	public void loadObject()
	{
		PhoneManager manager=PhoneManager.createManagerInst();
		Iterator<phoneInfo> itr=manager.personalData.iterator();
		
		try{
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("object.ser"));
			while(true)
			{
				phoneInfo info=(phoneInfo)in.readObject();
				if(info==null)
					break;
				manager.personalData.add(info);
			}
			in.close();
		}
		catch(IOException i1)
		{
			return;
		}
		catch(ClassNotFoundException i2)
		{
			return;
		}
	}
	
	public boolean delName(String name)
	{
		PhoneManager manager=PhoneManager.createManagerInst();
		Iterator<phoneInfo> itr=manager.personalData.iterator();
	
		while(itr.hasNext())
		{
			phoneInfo info=itr.next();
			if(info.name.equals(name)){
				itr.remove();
				return true;
			}
		}
		return false;
	}
}
