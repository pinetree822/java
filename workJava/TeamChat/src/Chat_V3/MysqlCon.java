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
			
			// Statement 는 정적 SQL문을 실행하고 결과를 반환하기 위한 객체
			// Statement는 하나당 한개의 ResultSet 객체만을 열수 있다.
			java.sql.Statement st = null;
			ResultSet result = null;
			
			st = con.createStatement();
			
			// executeQuery : 쿼리를 실행하고 ResultSet 객체로 변환 
			result = st.executeQuery("Show DATABASES");
			
			// 결과를 하나씩 출력한다.
			while(result.next())
			{
				String str = result.getNString(1);
				System.out.println(str);
			}// while
			
			
			
			
		} catch (SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
			System.out.println("SQLState : " + e.getSQLState());
		} catch (Exception e) {
			System.out.println("에러가 났습니다.");
		}
		
		
	}// main()
}// class MysqlCon
