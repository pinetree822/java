package Chat_V3;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.*;

public class MysqlCon {

	public static void main(String[] args) {
		
		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul", "root", "");
			
			// Statement �� ���� SQL���� �����ϰ� ����� ��ȯ�ϱ� ���� ��ü
			// Statement�� �ϳ��� �Ѱ��� ResultSet ��ü���� ���� �ִ�.
			java.sql.Statement st = null;
			ResultSet result = null;
			
			st = con.createStatement();
			
			// executeQuery : ������ �����ϰ� ResultSet ��ü�� ��ȯ 
			result = st.executeQuery("Show DATABASES");
			
			// ����� �ϳ��� ����Ѵ�.
			while(result.next())
			{
				String str = result.getNString(1);
				System.out.println(str);
			}// while
			
			
			
			
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
		} catch (Exception e) {
			System.out.println("������ �����ϴ�.");
		}
		
		
	}// main()
}// class MysqlCon
