package _help5;
import java.sql.*;
import javax.swing.*;
/*
 CREATE OR REPLACE PROCEDURE MEMO_ADD
 (
    PNAME IN MEMO.NAME%TYPE,
    PMSG  IN MEMO.MSG%TYPE    
 )
 IS
 BEGIN
    INSERT INTO MEMO(IDX,NAME,MSG,WDATE)
    VALUES(MEMO_IDX_SEQ.NEXTVAL, PNAME, PMSG, SYSDATE);
    COMMIT;
 END;
 * */
public class CallableStatementTest {

	public static void main(String[] args)
	throws Exception
	{
		String name=JOptionPane.showInputDialog(
				"작성자를 입력하세요");
		String msg=JOptionPane.showInputDialog(
				"메모내용을 입력하세요");
		
		Connection con=DBUtil.getCon();
		//내장된 프로시저를 호출하고자 하려면
		//CallableStatement객체가 필요하다.
		// Statement<---PreparedStatement<---CallableStatement
		String sql="{call MEMO_ADD(?,?)}";
		CallableStatement cstmt
					=con.prepareCall(sql);
		/*프로시저를 호출할 때
		 * [1] 인 파라미터가 있을 경우
		 *     {call 프로시저명(?,?,...)}
		 * [2] 프로시저명만 있을 경우
		 * 	   {call 프로시저명}    
		 * */
		cstmt.setString(1, name);
		cstmt.setString(2, msg);
		boolean b=cstmt.execute();
		System.out.println("memo_add프로시저 실행됨");
		cstmt.close();
		con.close();

	}

}


















