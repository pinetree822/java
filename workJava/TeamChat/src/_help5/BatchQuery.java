package _help5;
import java.sql.*;
/*여러 개의 sql문을 한꺼번에 전송하는 일괄 처리 방식을 살펴보자.
 * 여러 개의 sql문을 작성하여 Statement의 addBatcvh(sql),
 * executeBatch()메소드로 일괄 처리한다.
 * */

public class BatchQuery {
	
	public static void main(String[] args)
	throws Exception
	{
		Connection con=DBUtil.getCon();
		con.setAutoCommit(false);//자동 커밋 취소
		boolean isCommit=false;
		Statement st=con.createStatement();
		st.addBatch("INSERT INTO memo VALUES(memo_idx_seq.nextval,"
				+"'김길동','Batch테스트5',sysdate)");
		st.addBatch("INSERT INTO memo VALUES(memo_idx_seq.nextval,"
				+"'임길동','Batch테스트6',sysdate)");
		st.addBatch("INSERT INTO memo VALUES(memo_idx_seq.nextval,"
				+"'최길동','Batch테스트7',sysdate)");
		st.addBatch("INSERT INTO memo VALUES(memo_idx_seq.nextval,"
				+"'홍길동','Batch테스트8',sysdate)");
		try{
			int[] cnt=st.executeBatch();
			isCommit=true;
		}catch(SQLException e){
			isCommit=false;
			e.printStackTrace();
		}
		if(isCommit){
			con.commit();
			System.out.println("배치 실행 성공");
		}else{
			con.rollback();
			System.out.println("배치 실행 실패");
		}
		con.setAutoCommit(true);//자동커밋 상태로 복원

		//select문으로 memo내용 가져와 출력하세요
		
		
	}

}









