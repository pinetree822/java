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
		String name = JOptionPane.showInputDialog("�ۼ��ڸ� �Է��ϼ���.");
		String msg = JOptionPane.showInputDialog("�޸𳻿��� �Է��ϼ���.");
		
		Connection con = DbUtil.getCon();
		// ����� ���ν����� ȣ���ϰ��� �Ϸ���
		// CallableStatement��ü�� �ʿ��ϴ�.
		//	Statement <----- PreparedStatement <-------- CallableStatement
		String sql = "{call memo_add(?,?)}";
		CallableStatement cstmt 	= con.prepareCall(sql);
		/* ���ν����� ȣ���� ��
		 * [1] �� �Ķ���Ͱ� ���� ���
		 * 		{ call ���ν�����(?, ?) }
		 * [2] ���ν����� ���� ���
		 * 		{ call ���ν����� }
		 */
		cstmt.setString(1,	name);
		cstmt.setString(2,	msg);
		boolean b = cstmt.execute();
		System.out.println("memo_add���ν��� �����");
		
		cstmt.close();
		con.close();
		
	}// main ----------------

}// class CallableStatement----------------



/*
 * 
Driver Loading Success..
memo_add���ν��� �����




SQL> select * from memo;

       IDX NAME                 MSG
---------- -------------------- ------------------------------------------
        11 ȫ�浿               ȫȣȫ�浿 �޸�1
        12 ȫ�浿               �������׽�Ʈ1
        13 ȫ�浿               �������׽�Ʈ2
        14 ȫȣȫ�浿           �������׽�Ʈ3
        42 ���۸�               �ڹٽ��࿡�� ����Ŭ���ν����� �̿��� �Է�
        33 ��浿               Batch�׽�Ʈ5
        34 �̱浿               Batch�׽�Ʈ6
        35 �ֱ浿               Batch�׽�Ʈ7
        36 ȫ�浿               Batch�׽�Ʈ8
         9 �׽�Ʈ100            ������մϴ�.
        19 ��浿               Batch�׽�Ʈ1
        20 �̱浿               Batch�׽�Ʈ2
         8 ������               ȫ����̵�
        21 �ֱ浿               Batch�׽�Ʈ3
        22 ȫ�浿               Batch�׽�Ʈ4
        23 ��浿               Batch�׽�Ʈ1
        24 �̱浿               Batch�׽�Ʈ2
        25 �ֱ浿               Batch�׽�Ʈ3
        26 ȫ�浿               Batch�׽�Ʈ4
        17 ��浿               �׽�Ʈ2
        15 sfsad                fsadf
        16 ȫ�浿               �޸𳻿�-2016�� 10�� 21�� �׽�Ʈ1
        18 fasf                 fsadfsaf
        40 ������               ����Ŭ�ȿ��� ���ν����� �����

24 ���� ���õǾ����ϴ�.
 * 
 */
