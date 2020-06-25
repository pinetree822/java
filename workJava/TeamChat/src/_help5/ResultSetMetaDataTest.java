package _help5;

import java.sql.*;
import java.io.*;
/*ResultSetMetaDataŬ����
 * - ResultSet�� ���� ������ �� �� �ִ� Ŭ����
 * - �÷���, �÷��� �ڷ���, �ڷ��� ũ�� ����� ������ �ʿ��ϴٸ�
 * 		ResultSetMetaDataŬ������ �������.
 * */

public class ResultSetMetaDataTest {

	public static void main(String[] args) 
	throws Exception
	{
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.println("SELECT���� �Է��ϼ���=>");
		String sql="";
		Connection con=DBUtil.getCon();
		Statement st=con.createStatement();
		ResultSet rs=null;
		while((sql=br.readLine())!=null){
			//System.out.println(sql);
			//sql�� ";"�� ���ԵǾ� �ִ��� �˻��غ���.
			int index=sql.indexOf(";");
			//;�� ã�Ƽ� ������ �ش� �ε��� ��ȣ�� ��ȯ�ϰ�
			//������ -1�� ��ȯ�Ѵ�.
			if(index!=-1){
				//;�� ������ ������ sql�� �־�����.
				sql=sql.substring(0, index);
				System.out.println(sql);
			}//if------
			if(sql.trim().isEmpty()){//���ڿ�
				System.out.println("SELECT���� �Է��ؾ� �ؿ�");
				continue;
			}
			
			rs=st.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			//��� ���̺� ���� ��Ÿ ������ �̾ƺ���.
			int colCount=rsmd.getColumnCount();
			System.out.println("�÷���: "+colCount);
			for(int i=1;i<=colCount;i++)
			{
				String colName=rsmd.getColumnName(i);
				String colType=rsmd.getColumnTypeName(i);
				int colSize=rsmd.getColumnDisplaySize(i);
				int isNull=rsmd.isNullable(i);//�� ��� ����
				//0 : not null  1: null�� ���
				String nn=(isNull==0)?"NOT NULL":"";				
System.out.println("�÷���: "+colName+"["+colType+"("+colSize+")]"
					+"\t"+nn);
			}
			rs.close();			
		}//while--------------
		st.close();
		con.close();
	}

}





