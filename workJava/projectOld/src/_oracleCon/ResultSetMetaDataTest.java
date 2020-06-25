import java.sql.*;
import java.io.*;

/*
 * ResultSetMetaData Ŭ����
 * 	
		- ResultSet�� ���� ������ �� �� �ִ� Ŭ����
		- �÷���, �÷��� �ڷ���, �ڷ��� ũ�� ����� ������ �ʿ��ϴٸ�
		ResultSetMetaDataŬ������ �������.
 * 
 */
public class ResultSetMetaDataTest {

	public static void main(String[] args) 
	throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Select���� �Է��ϼ���.");
		String sql = "";
		Connection con = DbUtil.getCon();
		Statement st = con.createStatement();
		ResultSet rs;
		
		
		while( (sql=br.readLine())!= null ) {
			System.out.println(sql);
			//sql�� ";"�� ���ԵǾ� �ִ��� �˻��غ���
			System.out.println( sql.indexOf(";") );
			
			int index = sql.indexOf(";");// ;�� ã�Ƽ� ������ �ش� �ε��� ��ȣ�� ��ȯ�ϰ� ������ -1�� ��ȯ
			int quit = sql.indexOf("q");// q�� ã�Ƽ� ������ �ش� �ε��� ��ȣ�� ��ȯ�ϰ� ������ -1�� ��ȯ
			if(index != -1) { // ;�� ������ ������ sql�� �־�����.
				sql = sql.substring(0,index);//sql.substring(sql.indexOf(";"), 1);				
			} else if(quit==0){ // ���α׷� ����
				System.exit(0);
			} else {
				continue;
			}
			
			if(sql.trim().isEmpty()){
				System.out.println("SELECT���� �Է��ؾ� �ؿ�.");
				continue;
			}
			
			try {
				rs = st.executeQuery(sql);
				
			} catch (SQLException e) {
				System.out.println("sql���� ������ �ֽ��ϴ�.");
				continue;
			}

			// ��� ���̺� ���� ��Ÿ������ �̾ƺ���.
			ResultSetMetaData rsmd = rs.getMetaData();// ���̺��� �÷� ����
			int colCount = rsmd.getColumnCount();		// ���̺��� �÷� ��
			System.out.println("�÷��� : " + colCount);	//
			
			for(int i=1; i<=colCount; i++){							// ����Ŭ �÷��� 1���� �����Ѵ�.
				String colName = rsmd.getColumnName(i);		// �÷��̸�����
				String colType = rsmd.getColumnTypeName(i);	// �÷�Ÿ�� 
				int colSize = rsmd.getColumnDisplaySize(i);		// �÷�ũ�� 
				int isNull = rsmd.isNullable(i);						// �� ��� ����
				// 0 : not null, 1: null ���
				String nn = (isNull==0) ? "NOT NULL" : "NULLABLE";
				
				System.out.println("�÷��� : " + colName + "[" + colType+ " (" + colSize + ") " + "]" + "\t" + nn);
			}
			rs.close();
		}// while
		st.close();
		con.close();
		
	}//public static void main(String[] args)

}//public class ResultSetMetaDataTest
