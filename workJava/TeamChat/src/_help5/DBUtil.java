package _help5;
import java.sql.*;
/** ����̹� �ε��ϰ� Ŀ�ؼ��� �ϴ� Ŭ����*/
public class DBUtil {
	
	private static String host="192.168.10.150";
	
	private static String url
	="jdbc:oracle:thin:@"+host+":1521:ORCL";
	private static String user="james", pwd="tiger";
	private static String driver
	="oracle.jdbc.driver.OracleDriver";
	
	static{
		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//static initializer -�޸𸮿� ���� ���� �ö󰡴� ��
	//main()���ٵ� ���� �����
	
	public static synchronized Connection
				getCon() throws SQLException{
		System.out.println(url);
		Connection con
		=DriverManager.getConnection(url,user,pwd);
		return con;
	}
	//setter, getter----
    
	public static String getUrl() {
		return url;
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		DBUtil.host = host;
		System.out.println("host=="+host);
	}

	public static void setUrl(String url) {
		DBUtil.url = url;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		DBUtil.user = user;
	}

	public static String getPwd() {
		return pwd;
	}

	public static void setPwd(String pwd) {
		DBUtil.pwd = pwd;
	}

	public static String getDriver() {
		return driver;
	}

	public static void setDriver(String driver) {
		DBUtil.driver = driver;
	}

	public static void close(ResultSet rs, Statement st, Connection con) {
		try{
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
			System.out.println("DB���� ����");
		}catch(SQLException e){
			
		}
		
	}
	
	
	

}////////////////////////////////





