import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class MemoInsert {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		// 메모 테이블에 메모 내용을 등록해보자
		String name = JOptionPane.showInputDialog("작성자를 입력하세요.");
		String msg = JOptionPane.showInputDialog("메모내용을 입력하세요.");

		
		// 0. 환경설정
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "scott";
		String pwd = "tiger";
		
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		/*
		 * 1) OracleDriver를 메모리에 로드한다.
		 * 2) OracleDriver객체를 DriverManager에 등록한다.
		 		- DriverManager는 드라이버들을 관리하는 클래스로
		 			여러 드라이버들을 Vector에 저장하여 관리한다.
		 */
		System.out.println("드라이버 로딩완료");
		
		
		// 2. db연결 => Connection 얻기 (DriverManager 통해서)
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB 연결 완료");
		
		// 3. statement얻기 => Connection 통해서
		Statement stmt = con.createStatement();		
		
		

		// 4. SQL문 작성 => Insert문 작성
		String sql = "INSERT INTO ";
		sql += "MEMO";
		sql += "(";
		sql += "idx" + ",";
		sql += "name" + ",";
		sql += "msg" + "";
		sql += ")";
		sql += "VALUES";
		sql += "(";
		sql += "MEMO_IDX_SEQ" +".NEXTVAL" + ",";
		sql += "'" + name + "'" + ",";	//sql += subject + i + ",";
		sql += "'" + msg + "'" + "";	//sql += context + i + ",";
		sql += ")";
		System.out.println(sql);
		/*		String subject = "제목";
		String context = "내용";		
		String sql = "INSERT INTO MEMO(idx, name, msg, wdate)";
		sql+= "VALUES(memo_idx, seq.nextval,'고길동','좋은 하루~', sysdate)";*/
		
		
		
		
		/*
			INSERT INTO MEMO(idx, name, msg)
			VALUES(memo_idx_seq.NEXTVAL, '테스트1', '안녕~');
			--1개 행 이(가) 삽입되었습니다.
			
			시퀀스의 현재값을 보고 싶다면
			SELECT memo_idx_seq.CURRVAL FROM DUAL;
			--   CURRVAL
			------------
			--         7
		*/

		
		
		
		
		
		// 5. execute() 메소드로 작성
		boolean isRs = stmt.execute(sql);	
		System.out.println("isRs = " + isRs);
		System.out.println(sql + " 문장 실행");	
		
		// 6. DB 자원 반납 ==> close()
		stmt.close();
		con.close();
		// 오라클 시퀀스(Sequence) 사용
	}
}


/*
 * 

	드라이버 로딩완료
	DB 연결 완료
	INSERT INTO MEMO(idx,name,msg)VALUES(MEMO_IDX_SEQ.NEXTVAL,'왕조현','홍콩아이돌')
	isRs = false
	INSERT INTO MEMO(idx,name,msg)VALUES(MEMO_IDX_SEQ.NEXTVAL,'왕조현','홍콩아이돌')문장 실행

 * 
 */
