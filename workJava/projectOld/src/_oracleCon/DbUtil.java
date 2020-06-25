import java.sql.*;
/**
 * 
 * 드라이버 로딩하고 커넥션을 하는 클래스
 *
 
 */
public class DbUtil {

	private static String host = "localhost";
	private static String url = "jdbc:oracle:thin:@" + host + ":1521:ORCL";
	//private static String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static String user = "scott", pwd = "tiger";
	private static String driver = "oracle.jdbc.driver.OracleDriver";

	static 	{
		 try {
			Class.forName(driver);
			System.out.println("Driver Loading Success..");
			//Connection getCon()
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// static initializer - 메모리에 가장 먼저 올라가는 블럭
	// main()보다도 먼저 실행됨
	
	
	
	
	public DbUtil() {
		//
	}
	public static void close(ResultSet rs, Statement st, Connection con){
		try{
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
			System.out.println("DB연결 종료");
		} catch(SQLException e){
			
		}
	}
	static synchronized Connection getCon() throws SQLException {
		Connection con = DriverManager.getConnection(url, user, pwd);
		return con;
	}
	// setter, getter
	public static String getHost() {
		return host;
	}
	public static void setHost(String host) {
		DbUtil.host = host;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		DbUtil.url = url;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		DbUtil.user = user;
	}
	public static String getPwd() {
		return pwd;
	}
	public static void setPwd(String pwd) {
		DbUtil.pwd = pwd;
	}
	public static String getDriver() {
		return driver;
	}
	public static void setDriver(String driver) {
		DbUtil.driver = driver;
	}

}
