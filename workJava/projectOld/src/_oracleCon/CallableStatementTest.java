import java.sql.*;

import javax.swing.JOptionPane;
//import DbUtil.java


/*
 * 
	create or replace procedure memo_add
	(
	  pname in memo.name%type,
	  pmsg in memo.msg%type
	)
	is
	begin
	  insert into memo(idx, name, msg, wdate)
	  values(memo_idx_seq.nextval, pname, pmsg, sysdate);
	  commit;
	end;
 * 	
 */
public class CallableStatementTest {
	
	public static void main(String[] args) 
	throws Exception
	{
		String name = JOptionPane.showInputDialog("작성자를 입력하세요.");
		String msg = JOptionPane.showInputDialog("메모내용을 입력하세요.");
		
		Connection con = DbUtil.getCon();
		// 내장된 프로시저를 호출하고자 하려면
		// CallableStatement객체가 필요하다.
		//	Statement <----- PreparedStatement <-------- CallableStatement
		String sql = "{call memo_add(?,?)}";
		CallableStatement cstmt 	= con.prepareCall(sql);
		/* 프로시저를 호출할 때
		 * [1] 인 파라미터가 있을 경우
		 * 		{ call 프로시저명(?, ?) }
		 * [2] 프로시저명만 있을 경우
		 * 		{ call 프로시저명 }
		 */
		cstmt.setString(1,	name);
		cstmt.setString(2,	msg);
		boolean b = cstmt.execute();
		System.out.println("memo_add프로시저 실행됨");
		
		cstmt.close();
		con.close();
		
	}// main ----------------

}// class CallableStatement----------------



/*
 * 
Driver Loading Success..
memo_add프로시저 실행됨




SQL> select * from memo;

       IDX NAME                 MSG
---------- -------------------- ------------------------------------------
        11 홍길동               홍호홍길동 메모1
        12 홍길동               ㅎ텟테테스트1
        13 홍길동               ㅎ텟테테스트2
        14 홍호홍길동           ㅎ텟테테스트3
        42 슈퍼맨               자바실행에서 오라클프로시저를 이용한 입력
        33 김길동               Batch테스트5
        34 이길동               Batch테스트6
        35 최길동               Batch테스트7
        36 홍길동               Batch테스트8
         9 테스트100            재수정합니다.
        19 김길동               Batch테스트1
        20 이길동               Batch테스트2
         8 왕조현               홍콩아이돌
        21 최길동               Batch테스트3
        22 홍길동               Batch테스트4
        23 김길동               Batch테스트1
        24 이길동               Batch테스트2
        25 최길동               Batch테스트3
        26 홍길동               Batch테스트4
        17 김길동               테스트2
        15 sfsad                fsadf
        16 홍길동               메모내용-2016년 10월 21일 테스트1
        18 fasf                 fsadfsaf
        40 김프로               오라클안에서 프로시저로 썻어요

24 행이 선택되었습니다.
 * 
 */
