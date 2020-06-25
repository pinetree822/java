package _help5;

import java.sql.*;
import java.io.*;
/*ResultSetMetaData클래스
 * - ResultSet에 대한 정보를 알 수 있는 클래스
 * - 컬럼명, 컬럼의 자료형, 자료형 크기 등등의 정보가 필요하다면
 * 		ResultSetMetaData클래스를 사용하자.
 * */

public class ResultSetMetaDataTest {

	public static void main(String[] args) 
	throws Exception
	{
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.println("SELECT문을 입력하세요=>");
		String sql="";
		Connection con=DBUtil.getCon();
		Statement st=con.createStatement();
		ResultSet rs=null;
		while((sql=br.readLine())!=null){
			//System.out.println(sql);
			//sql에 ";"이 포함되어 있는지 검색해보자.
			int index=sql.indexOf(";");
			//;을 찾아서 있으면 해당 인덱스 번호를 반환하고
			//없으면 -1을 반환한다.
			if(index!=-1){
				//;를 제외한 문장을 sql에 넣어주자.
				sql=sql.substring(0, index);
				System.out.println(sql);
			}//if------
			if(sql.trim().isEmpty()){//빈문자열
				System.out.println("SELECT문을 입력해야 해요");
				continue;
			}
			
			rs=st.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			//결과 테이블에 대한 메타 정보를 뽑아보자.
			int colCount=rsmd.getColumnCount();
			System.out.println("컬럼수: "+colCount);
			for(int i=1;i<=colCount;i++)
			{
				String colName=rsmd.getColumnName(i);
				String colType=rsmd.getColumnTypeName(i);
				int colSize=rsmd.getColumnDisplaySize(i);
				int isNull=rsmd.isNullable(i);//널 허용 여부
				//0 : not null  1: null을 허용
				String nn=(isNull==0)?"NOT NULL":"";				
System.out.println("컬럼명: "+colName+"["+colType+"("+colSize+")]"
					+"\t"+nn);
			}
			rs.close();			
		}//while--------------
		st.close();
		con.close();
	}

}





