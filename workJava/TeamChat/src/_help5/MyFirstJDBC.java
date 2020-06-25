package _help5;
import java.sql.*;

public class MyFirstJDBC {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		//1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����!");
		
		//2. DB ����
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user="james", pwd="tiger";
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB���� ����!");
		
		//3. Statement������
		Statement stmt=con.createStatement();
		
		//4. ������ ������(SQL��) �ۼ�
		String sql="INSERT INTO memo(idx,name,msg)";
			   sql+=" VALUES(3,'�ֱ浿','�ι�° ���Դϴ�.*^^*')";
		System.out.println(sql);	   
		
		//5. execute()�޼ҵ�� ����
		boolean b=stmt.execute(sql);
		System.out.println("b="+b);	
		//�ڵ����� commit��
		
		//6. close()
		stmt.close();
		con.close();
	}

}





