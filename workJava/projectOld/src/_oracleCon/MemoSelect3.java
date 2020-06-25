import java.util.Properties;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.sql.*;
import java.io.*;


// select 관련


class  MemoSelect3
{
	public static void main(String[] args) 
		throws Exception
	{		
		// 데이타베이스 정보 로드
		FileReader fr = new FileReader("DB.properties");
		Properties p = new Properties();
		p.load(fr);
		
		// 데이타정보 초기화
		Class.forName(p.getProperty("dbdriver"));
		String url = p.getProperty("dburl");
		String user = p.getProperty("dbuser");
		String pwd = p.getProperty("dbpwd");
				
		// 데이타베이스 연결
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("db연결성공");

		
/*
		// 메모 테이블의 내용을 수정하자(작성자,메모자,작성일)
		Scanner sc = new Scanner(System.in);

		System.out.println("입력할할 작성자 입력=>");
		String name = sc.next(); // 엔터때문에 nextLine() 넘어간다.
		sc.skip("\r\n");
		
		System.out.println("입력할 메모내용 입력=>");
		String msg = sc.nextLine();
		System.out.println( name + "/" + msg );
		*/
		
		String name = JOptionPane.showInputDialog("검색할 작성자를 입력하세요.");
		
		

		// 1. SQL문 작성 => Insert문 작성
		//String sql = "INSERT INTO  MEMO ( idx ,name, msg, wdate ) VALUES ( ? , ? , ?,  ?  )";
		String sql = "SELECT count(idx) as cnt FROM MEMO WHERE name like ?";
		System.out.println(sql);
		
		
		// PreparedStatement 는 얻기
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// in 파라미터 (?) 값을 세팅
		pstmt.setString(1, name);
		
		// 실행
		ResultSet rs = pstmt.executeQuery();	// 준비된 쿼리 실행 , 결과값 참조 얻기
		
		boolean b = rs.next();// 커서 이동
		if(b){
			//int count = rs.getInt(1);
			int count=rs.getInt("cnt");
			if(count<=0){
				System.out.println("작성한 글이 없어요!");
				return;
			}
			System.out.println(count + "개의 글이 있습니다.");
			
			// 작성자(홍길동)의 글들을 가져와 출력하세요.
			//4. sql문 작성(select문. join문)
			String sql1="SELECT * FROM MEMO "
					+" WHERE name=? ORDER BY idx";
			System.out.println(sql1);
			
			// PreparedStatement 는 얻기
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, name);
						
			//5. 실행-executeXXXX()
			ResultSet rs1=pstmt1.executeQuery();
						
			//6. 실행 결과 데이터 가져와 출력하기
			while(rs1.next()){
				int no1=rs1.getInt(1);					// idx
				String name1=rs1.getString(2);		// name
				String msg1=rs1.getString(2);		// msg
				Date date1=rs.getDate(4);			// date
				System.out.println(no1+"\t"+name1+"\t"+ msg1+"\t"+date1);
			}
			
			pstmt1.close();
			rs1.close();
			
		}// if-----------------------------------------------

		pstmt.close();
		rs.close();
		con.close();
		
		
		
		//System.out.println(str);
		// 홍길동 => 홍길동이 입력한 글이 몇개 있는지 출력하는
		// sql문장을 작성
		// "3건의 글이 있습니다.", "작성한 글이 없습니다."
		//
		
		/*
		 * 
		SQL> select * from memo order by 1;
		
		       IDX NAME                 MSG                                                                                          WDATE
		---------- -------------------- ---------------------------------------------------------------------------------------------------- --------
		         2 김기김길동           ㄱ첫처첫번째 재수정한 글입니다.                                                              16/10/20
		         8 왕조현               홍콩아이돌                                                                                   16/10/18
		         9 테스트99             닷다다시 재수정합니다.                                                                       16/10/20
		        11 홍길동1              홍호홍길동 메모1                                                                             16/10/20

		 * 
		 * select count(idx) from memo where name="홍서방";
		 */
		// 홍길도 => 홍길동이 입력한 글이 몇개 있는지 출력하는
		// sql 문장을 작성
		// "3건의 글이 있습니다.", "작성한 글이 없습니다.";
		
	}
}
		