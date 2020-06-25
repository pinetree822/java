import java.sql.*;
import java.io.*;

/*
 * ResultSetMetaData 클래스
 * 	
		- ResultSet에 대한 정보를 알 수 있는 클래스
		- 컬럼명, 컬럼의 자료형, 자료형 크기 등등의 정보가 필요하다면
		ResultSetMetaData클래스를 사용하자.
 * 
 */
public class ResultSetMetaDataTest {

	public static void main(String[] args) 
	throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Select문을 입력하세요.");
		String sql = "";
		Connection con = DbUtil.getCon();
		Statement st = con.createStatement();
		ResultSet rs;
		
		
		while( (sql=br.readLine())!= null ) {
			System.out.println(sql);
			//sql에 ";"이 포함되어 있는지 검색해보자
			System.out.println( sql.indexOf(";") );
			
			int index = sql.indexOf(";");// ;을 찾아서 있으면 해당 인덱스 번호를 반환하고 없으면 -1을 반환
			int quit = sql.indexOf("q");// q을 찾아서 있으면 해당 인덱스 번호를 반환하고 없으면 -1을 반환
			if(index != -1) { // ;를 제외한 문장을 sql에 넣어주자.
				sql = sql.substring(0,index);//sql.substring(sql.indexOf(";"), 1);				
			} else if(quit==0){ // 프로그램 종료
				System.exit(0);
			} else {
				continue;
			}
			
			if(sql.trim().isEmpty()){
				System.out.println("SELECT문을 입력해야 해요.");
				continue;
			}
			
			try {
				rs = st.executeQuery(sql);
				
			} catch (SQLException e) {
				System.out.println("sql문이 문제가 있습니다.");
				continue;
			}

			// 결과 테이블에 대한 메타정보를 뽑아보자.
			ResultSetMetaData rsmd = rs.getMetaData();// 테이블의 컬럼 정보
			int colCount = rsmd.getColumnCount();		// 테이블의 컬럼 수
			System.out.println("컬럼수 : " + colCount);	//
			
			for(int i=1; i<=colCount; i++){							// 오라클 컬럼은 1부터 시작한다.
				String colName = rsmd.getColumnName(i);		// 컬럼이름정보
				String colType = rsmd.getColumnTypeName(i);	// 컬럼타입 
				int colSize = rsmd.getColumnDisplaySize(i);		// 컬럼크기 
				int isNull = rsmd.isNullable(i);						// 널 허용 여부
				// 0 : not null, 1: null 허용
				String nn = (isNull==0) ? "NOT NULL" : "NULLABLE";
				
				System.out.println("컬럼명 : " + colName + "[" + colType+ " (" + colSize + ") " + "]" + "\t" + nn);
			}
			rs.close();
		}// while
		st.close();
		con.close();
		
	}//public static void main(String[] args)

}//public class ResultSetMetaDataTest
