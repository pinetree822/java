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
				"�ۼ��ڸ� �Է��ϼ���");
		String msg=JOptionPane.showInputDialog(
				"�޸𳻿��� �Է��ϼ���");
		
		Connection con=DBUtil.getCon();
		//����� ���ν����� ȣ���ϰ��� �Ϸ���
		//CallableStatement��ü�� �ʿ��ϴ�.
		// Statement<---PreparedStatement<---CallableStatement
		String sql="{call MEMO_ADD(?,?)}";
		CallableStatement cstmt
					=con.prepareCall(sql);
		/*���ν����� ȣ���� ��
		 * [1] �� �Ķ���Ͱ� ���� ���
		 *     {call ���ν�����(?,?,...)}
		 * [2] ���ν����� ���� ���
		 * 	   {call ���ν�����}    
		 * */
		cstmt.setString(1, name);
		cstmt.setString(2, msg);
		boolean b=cstmt.execute();
		System.out.println("memo_add���ν��� �����");
		cstmt.close();
		con.close();

	}

}


















