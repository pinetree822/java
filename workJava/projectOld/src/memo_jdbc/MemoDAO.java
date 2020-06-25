package memo_jdbc;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;

/* DAO : Data Access Object
: 데이터베이스에 접근하여 biz로직 (insert, delete, update, select 등)
을 수행하는 클래스


CRUD 작업 수행
c : create => create문, insert문
r : read => select문
u : update => update문
d : delete => delete문
*/

public class MemoDAO {
    // 0. 환경설정
    private String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private String user="scott", pwd="tiger";
    private Connection con;
    private PreparedStatement ps;
    
    
    
    
    public MemoDAO() {
        try {
		// 1. 드라이버 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. db연결 => Connection 얻기 (DriverManager 통해서)
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("드라이버 로딩완료");
            /*
             * 1) OracleDriver를 메모리에 로드한다.
             * 2) OracleDriver객체를 DriverManager에 등록한다.
                            - DriverManager는 드라이버들을 관리하는 클래스로
                                    여러 드라이버들을 Vector에 저장하여 관리한다.
             */
        } catch (Exception e){
            e.printStackTrace();
        }
    }// 생성자 public MemoDAO()~~~~~~~~~~~~~~~~~~~~~
    /** 메모 내용을 등록하는 메소드 => insert문을 수행 */
    
    
     
     
     
     /** 글 번호(pk)로 특정 글을 가져오는 메소드 */
     public MemoDTO selectMemoByIdx(int idx)
     {
         try {
             
             // select 문 where절
             String sql = "SELECT idx, name, msg, wdate FROM MEMO WHERE idx=?";
             
             // ? 셋팅
             ps = con.prepareStatement(sql);
             ps.setInt(1, idx);
             
             // 실행 => rs
             // 반복문 돌면서 db 컬럼 데이터 꺼내기
             ResultSet rs = ps.executeQuery();
             MemoDTO m=null;
             while(rs.next())
             {
                 int idx2 = rs.getInt(1);
                 String name = rs.getString(2);
                 String msg = rs.getString(3);
                 java.sql.Date wdate = rs.getDate(4);
                 
                 m = new MemoDTO(idx2, name, msg, wdate); 
             }
             // MemoDTO에 담아서 반환
             return m;
         } catch(Exception e) {
             e.printStackTrace();
             return null;
         }
     }
     
     
    
     
    
     
     /// 모든 목록을 가져오는 메소드 - select문을 수행
     public Vector<MemoDTO> selectAllMemo()
     {
         try {

            // 1. SELECT 문 작성
            //String sql = "SELECT * FROM MEMO ORDER BY 1";
            String sql = "SELECT idx, name, rpad(msg, 30, ' ') as msg, wdate FROM MEMO ORDER BY 1";
             
            // 2. ps 얻어오기
            ps = con.prepareStatement(sql);
             
            // 3. 실행-executeXXXX()
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            
            // 4. 반복문 돌면서 컬럼데이터 꺼내기
            // => MemoDTO를 생성해서 데이터를 setting
            Vector<MemoDTO> v = makeVector(rs);
               
             // 실행결과 성공이면 return true, 실패면 false 반환
             //boolean bool = (cnt>0)? true:false;
             if(rs!=null) rs.close();
             if(ps!=null) ps.close();
             return v;
             
         } catch(Exception e) {
             e.printStackTrace();
             return null;
         }
     }//  public Vector<MemoDTO> selectAllMemo()
     



    

//    
//    public boolean insertMemo( String name, String msg )
//	throws ClassNotFoundException, SQLException
//    {
//        try {
//			
//                // 1. insert문을 작성// 4. SQL문 작성 => Insert문 작성
//		String sql = "INSERT INTO ";
//		sql += "MEMO";
//		sql += "(";
//		sql += "idx" + ",";
//		sql += "name" + ",";
//		sql += "msg" + ",";
//		sql += "wdate" + "";
//		sql += ") ";
//		sql += "VALUES";
//		sql += "(";
//		sql += "MEMO_IDX_SEQ.NEXTVAL" + ",";
//		sql += "'" + name + "'" + ",";
//		sql += "'" + msg + "'" + ",";
//		sql += "sysdate";
//		sql += ")";
//                System.out.println("sql = " + sql);
//                
//                // 2. ps 얻어오기	
//                // 3. statement얻기 => Connection 통해서
//                Statement stmt = con.createStatement();
//                if(stmt == null) System.out.println("Statement Init Success : sql = " + sql);
//                else  System.out.println("Statement Init Fail : sql = " + sql);
//
//                
//                // 3. db에 전송 ==> executeXXX(); // 5. execute() 메소드로 작성
//                boolean isRs = stmt.execute(sql);
//                if(stmt == null) System.out.println("Statement Exec Success : isRs = " + isRs);
//                else  System.out.println("Statement Exec Fail : isRs = " + isRs);
//                
//                //JOptionPane.showMessageDialog(null,"isRs = " + isRs);
//                // 6. DB 자원 반납 ==> close()
//		con.close();
//            
//                return true;
//            
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }//public boolean insertMemo( String name, String msg )
    
    // 1.작성자.매모내용값 받아오기(tfName, tfMsg);
    // 2.유효성 체크(빈문자열)
    // 3.dao의 insertMemo()메소드에 작성자, 메모내용값 넘기기
    // 4.반환값 받아서 true가 반환되면 "글 등록 성공" 메시지 보여주기  

     public boolean insertMemo2( MemoDTO memo )
     {
         try{
             // Insert문 작성
             String sql = "{call MEMO_ADD(?,?)}";
             CallableStatement cs = con.prepareCall(sql);

             cs.setString(1,memo.getName());//MemoDTO 객체
             cs.setString(2,memo.getMsg());//MemoDTO 객체
             cs.execute();
             
             return true;
             
         } catch(Exception e){
             e.printStackTrace();
             return false;
         }
     }
    



     public boolean insertMemo( MemoDTO memo )
     {
         try{
             // Insert문 작성
             String sql = "INSERT INTO memo(idx, name, msg, wdate)";
             sql += " VALUES(memo_idx_seq.nextval,?,?,sysdate)";
             
             // ps 얻어오기
             ps = con.prepareStatement(sql);
             //ps.setString(1,name);
             //ps.setString(2,msg);
             ps.setString(1,memo.getName());//MemoDTO 객체
             ps.setString(2,memo.getMsg());//MemoDTO 객체
             
             // db에 전송 => executeXXX()
             int cnt = ps.executeUpdate();
             
             // 실행결과 성공이면 return true, 실패면 false 반환
             boolean bool = (cnt>0)? true:false;
             if(ps!=null) ps.close();
             return bool;
             
         } catch(Exception e){
             e.printStackTrace();
             return false;
         }
     }
    


     
     
     /** 글번호(PK)로 특정 글을 삭제하는 메소드-delete문 수행 */
     public boolean deleteMemo(int index)
     {

         try {
             String sql = "DELETE FROM memo WHERE idx = ?";
             
             ps=con.prepareStatement(sql);
             ps.setInt(1, index);
             
             int cnt=ps.executeUpdate();
             if(ps!=null) ps.close();
             
             if(cnt > 0) return true;
             else return false;
             
         } catch(Exception e){
             e.printStackTrace();
             return false;
         }

     }// deleteMomo
     
     
     
     
     /** 특정 글을 수정하는 메소드 update문을 수행한다. */
     public boolean updateMemo(MemoDTO memo){
             // ps 얻어오기
             // ? 값 세팅
             // 실행
             // 그 결과 반환값 처리
             
         try{
//             // update문 작성 where절
//             String sql = "UPDATE MEMO SET name=?, msg=? WHERE idx=?";
//             
//             // ps 얻어오기
//             ps = con.prepareStatement(sql);
//             ps.setString(1,memo.getName());//MemoDTO 객체
//             ps.setString(2,memo.getMsg());//MemoDTO 객체
//             ps.setString(3,String.valueOf(memo.getIdx()));//MemoDTO 객체
//             
//             // db에 전송 => executeXXX()
//             int cnt = ps.executeUpdate();

             // update문 작성 where절
             String sql = "UPDATE MEMO SET name=?, msg=?, wdate=sysdate ";
             sql += "WHERE idx=?";
             
             // ps 얻어오기
             ps = con.prepareStatement(sql);
             System.out.println(memo.getName() + "," +memo.getMsg() + "," +memo.getIdx());
             // ? 값 세팅             
             ps.setString(1,memo.getName());//MemoDTO 객체
             ps.setString(2,memo.getMsg());//MemoDTO 객체
             ps.setInt(3,memo.getIdx());//MemoDTO 객체
             
             // db에 전송 => executeXXX()// 실행
             int cnt = ps.executeUpdate();

             // 실행결과 성공이면 return true, 실패면 false 반환
             boolean bool = (cnt>0)? true:false;
            /// if(ps!=null) ps.close();
             return bool;
             
         } catch(Exception e){
             e.printStackTrace();
             return false;
         }
     }

    /** 검색어로 메모내용을 검색하는 메소드 */
    Vector<MemoDTO> findMemo(int index, String keyword) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       try {    
           // 0 => 작성자(name), 1=>메모내용(msg), 2=> 글번호=>idx
           // Select문 작성 Where절 =

          String colName = "";
          switch(index){
              case 0 : colName="name"; break;
              case 1 : colName="msg"; break;
              case 2 : colName="idx"; break;
          }
          
          String sql="SELECT idx, name, msg, wdate From memo WHERE "+ colName+" LIKE ?";
         // String sql="SELECT idx, name, msg, wdate From memo WHERE "+ colName+"=?";
          System.out.println("sql = " + sql);
          
          // PS얻어오기
          ps=con.prepareStatement(sql);
          ps.setString(1, "%" +keyword+ "%");
           // 실행해서 RS받기
          ResultSet rs = ps.executeQuery();
          //  반복문 돌면서 데이터 꺼내기와 MEMODTO에 담기
          //  VECTOR에 저장후 반환
          Vector<MemoDTO> v=makeVector(rs);
          
          if(rs!=null) rs.close();
          if(ps!=null) ps.close();
          return v;
           // PS얻어오기
          // ps = con.prepareCall(sql);

           
           // ?값 세팅
           
           // 실행해서 RS받기
           
           // 반복문 돌면서 데이터 꺼내와 MEMODTO에 담기
           
           // VECTOR에 저장후 반환
           
       } catch(Exception e){
           e.printStackTrace();
           return null;
       }
    }

    private Vector<MemoDTO> makeVector(ResultSet rs) 
    throws SQLException
    {
            Vector<MemoDTO> v = new Vector<MemoDTO>();
            while(rs.next()){
                 int idx=rs.getInt("idx");                      //int idx=rs.getInt(1);
                 String name=rs.getString("name");              //String name=rs.getString(2);
                 String msg=rs.getString("msg");                //String msg=rs.getString(3);
                 java.sql.Date wdate = rs.getDate("wdate");     //iava.sql.Date wdate=rs.getDate(4);
                 MemoDTO record = new MemoDTO(idx, name, msg, wdate);
                 v.add(record);
                 //System.out.println(idx+"\t"+user+"\t"+msg+"\t"+wdate);
            }
            return v;
    }

    // 전체 닫기
    public void dbClose() {
        try {
            System.out.println("db disconnect...");
            if(ps!=null) ps.close();
            if(con!=null) con.close();
            
        } catch(SQLException e) {
            
            
        }
    }
     
     
     
     
     
     
     
}//public class MemoDAO
