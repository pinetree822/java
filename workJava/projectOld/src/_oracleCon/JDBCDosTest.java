import java.sql.*;

class JDBCDosTest
{
	public static void main(String[] args) throws SQLSyntaxErrorException
	{
		try
		{
			// 1. ����̹� �ε� - ojdbc7.jar
			// => Class.forName("��Ű����.����̹���")�޼ҵ带 �̿�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success~~");

			// 2. DB�� ���� : DriverManager.getConnection()
			// DriverManager Ŭ�����̴�
			// => Connection con=DriverManager.getConnection(url, user, pwd)

			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			// jdbc,���Ÿ��,����̹�Ÿ��,ip,port,��������Ÿ���̽�
			// ��������:oracle:����̹�Ÿ��:@ȣ��Ʈ:��Ʈ��ȣ:SID
			// url�� DBMS�縶�� �ٸ���.

			String user="scott";
			String pwd ="tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB Connected..");

			// 3. DB�� SQL���� �����ϱ� ���� Statment��ü�� ���´�.
			// Connection�� createStatement()�� �̿�
			Statement stmt = con.createStatement();
			
			// 4. SQL�� �ۼ�
			String sql = "CREATE TABLE memo1";
					sql += "(";
					sql += "idx number(4) primary key,";
					sql += "name varchar2(20) not null,";
					sql += "msg varchar2(100),";
					sql += "wdate date default sysdate";
					sql += ")";

			// 5. SQL���� DB�� ����(����)
			// => Statement�� executeXXX() �޼ҵ带 ����
			// boolean execute(String sql) : 
			//		sql���� [ select�� ]�� ���� true�� ��ȯ�ϰ�,
			//				[ �� �� ���� ]�� ���� false�� ��ȯ

			boolean isRs = stmt.execute(sql);		// sql�� ���� - �����ϸ� exception �Ͼ
			System.out.println("isRs = " + isRs);	// ����Ȯ��, �����ص� false�� ���.
			
			// 6. DB�ڿ� �ݳ�
			stmt.close();	// sql �ڿ��ݳ�
			con.close();	// con �ڿ��ݳ�

			/*
			Driver Loading Success~~
			DB Connected..
			isRs = false
			����̹� �ε� ����
			*/
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB���� ����");
			e.printStackTrace();
		}
		System.out.println("����̹� �ε� ����");

	}//public static void main(String[] args)
}// class JDBCTest




/*
CREATE TABLE memo1 (
  idx number(4) primary key,
  name varchar2(20) not null,
  msg varchar2(100),
  wdate date default sysdate
)
 */