package memo_jdbc;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;

/* DAO : Data Access Object
: �����ͺ��̽��� �����Ͽ� biz���� (insert, delete, update, select ��)
�� �����ϴ� Ŭ����


CRUD �۾� ����
c : create => create��, insert��
r : read => select��
u : update => update��
d : delete => delete��
*/

public class MemoDAO {
    // 0. ȯ�漳��
    private String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private String user="scott", pwd="tiger";
    private Connection con;
    private PreparedStatement ps;
    
    
    
    
    public MemoDAO() {
        try {
		// 1. ����̹� �ε�
            Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. db���� => Connection ��� (DriverManager ���ؼ�)
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("����̹� �ε��Ϸ�");
            /*
             * 1) OracleDriver�� �޸𸮿� �ε��Ѵ�.
             * 2) OracleDriver��ü�� DriverManager�� ����Ѵ�.
                            - DriverManager�� ����̹����� �����ϴ� Ŭ������
                                    ���� ����̹����� Vector�� �����Ͽ� �����Ѵ�.
             */
        } catch (Exception e){
            e.printStackTrace();
        }
    }// ������ public MemoDAO()~~~~~~~~~~~~~~~~~~~~~
    /** �޸� ������ ����ϴ� �޼ҵ� => insert���� ���� */
    
    
     
     
     
     /** �� ��ȣ(pk)�� Ư�� ���� �������� �޼ҵ� */
     public MemoDTO selectMemoByIdx(int idx)
     {
         try {
             
             // select �� where��
             String sql = "SELECT idx, name, msg, wdate FROM MEMO WHERE idx=?";
             
             // ? ����
             ps = con.prepareStatement(sql);
             ps.setInt(1, idx);
             
             // ���� => rs
             // �ݺ��� ���鼭 db �÷� ������ ������
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
             // MemoDTO�� ��Ƽ� ��ȯ
             return m;
         } catch(Exception e) {
             e.printStackTrace();
             return null;
         }
     }
     
     
    
     
    
     
     /// ��� ����� �������� �޼ҵ� - select���� ����
     public Vector<MemoDTO> selectAllMemo()
     {
         try {

            // 1. SELECT �� �ۼ�
            //String sql = "SELECT * FROM MEMO ORDER BY 1";
            String sql = "SELECT idx, name, rpad(msg, 30, ' ') as msg, wdate FROM MEMO ORDER BY 1";
             
            // 2. ps ������
            ps = con.prepareStatement(sql);
             
            // 3. ����-executeXXXX()
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            
            // 4. �ݺ��� ���鼭 �÷������� ������
            // => MemoDTO�� �����ؼ� �����͸� setting
            Vector<MemoDTO> v = makeVector(rs);
               
             // ������ �����̸� return true, ���и� false ��ȯ
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
//                // 1. insert���� �ۼ�// 4. SQL�� �ۼ� => Insert�� �ۼ�
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
//                // 2. ps ������	
//                // 3. statement��� => Connection ���ؼ�
//                Statement stmt = con.createStatement();
//                if(stmt == null) System.out.println("Statement Init Success : sql = " + sql);
//                else  System.out.println("Statement Init Fail : sql = " + sql);
//
//                
//                // 3. db�� ���� ==> executeXXX(); // 5. execute() �޼ҵ�� �ۼ�
//                boolean isRs = stmt.execute(sql);
//                if(stmt == null) System.out.println("Statement Exec Success : isRs = " + isRs);
//                else  System.out.println("Statement Exec Fail : isRs = " + isRs);
//                
//                //JOptionPane.showMessageDialog(null,"isRs = " + isRs);
//                // 6. DB �ڿ� �ݳ� ==> close()
//		con.close();
//            
//                return true;
//            
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }//public boolean insertMemo( String name, String msg )
    
    // 1.�ۼ���.�Ÿ𳻿밪 �޾ƿ���(tfName, tfMsg);
    // 2.��ȿ�� üũ(���ڿ�)
    // 3.dao�� insertMemo()�޼ҵ忡 �ۼ���, �޸𳻿밪 �ѱ��
    // 4.��ȯ�� �޾Ƽ� true�� ��ȯ�Ǹ� "�� ��� ����" �޽��� �����ֱ�  

     public boolean insertMemo2( MemoDTO memo )
     {
         try{
             // Insert�� �ۼ�
             String sql = "{call MEMO_ADD(?,?)}";
             CallableStatement cs = con.prepareCall(sql);

             cs.setString(1,memo.getName());//MemoDTO ��ü
             cs.setString(2,memo.getMsg());//MemoDTO ��ü
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
             // Insert�� �ۼ�
             String sql = "INSERT INTO memo(idx, name, msg, wdate)";
             sql += " VALUES(memo_idx_seq.nextval,?,?,sysdate)";
             
             // ps ������
             ps = con.prepareStatement(sql);
             //ps.setString(1,name);
             //ps.setString(2,msg);
             ps.setString(1,memo.getName());//MemoDTO ��ü
             ps.setString(2,memo.getMsg());//MemoDTO ��ü
             
             // db�� ���� => executeXXX()
             int cnt = ps.executeUpdate();
             
             // ������ �����̸� return true, ���и� false ��ȯ
             boolean bool = (cnt>0)? true:false;
             if(ps!=null) ps.close();
             return bool;
             
         } catch(Exception e){
             e.printStackTrace();
             return false;
         }
     }
    


     
     
     /** �۹�ȣ(PK)�� Ư�� ���� �����ϴ� �޼ҵ�-delete�� ���� */
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
     
     
     
     
     /** Ư�� ���� �����ϴ� �޼ҵ� update���� �����Ѵ�. */
     public boolean updateMemo(MemoDTO memo){
             // ps ������
             // ? �� ����
             // ����
             // �� ��� ��ȯ�� ó��
             
         try{
//             // update�� �ۼ� where��
//             String sql = "UPDATE MEMO SET name=?, msg=? WHERE idx=?";
//             
//             // ps ������
//             ps = con.prepareStatement(sql);
//             ps.setString(1,memo.getName());//MemoDTO ��ü
//             ps.setString(2,memo.getMsg());//MemoDTO ��ü
//             ps.setString(3,String.valueOf(memo.getIdx()));//MemoDTO ��ü
//             
//             // db�� ���� => executeXXX()
//             int cnt = ps.executeUpdate();

             // update�� �ۼ� where��
             String sql = "UPDATE MEMO SET name=?, msg=?, wdate=sysdate ";
             sql += "WHERE idx=?";
             
             // ps ������
             ps = con.prepareStatement(sql);
             System.out.println(memo.getName() + "," +memo.getMsg() + "," +memo.getIdx());
             // ? �� ����             
             ps.setString(1,memo.getName());//MemoDTO ��ü
             ps.setString(2,memo.getMsg());//MemoDTO ��ü
             ps.setInt(3,memo.getIdx());//MemoDTO ��ü
             
             // db�� ���� => executeXXX()// ����
             int cnt = ps.executeUpdate();

             // ������ �����̸� return true, ���и� false ��ȯ
             boolean bool = (cnt>0)? true:false;
            /// if(ps!=null) ps.close();
             return bool;
             
         } catch(Exception e){
             e.printStackTrace();
             return false;
         }
     }

    /** �˻���� �޸𳻿��� �˻��ϴ� �޼ҵ� */
    Vector<MemoDTO> findMemo(int index, String keyword) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       try {    
           // 0 => �ۼ���(name), 1=>�޸𳻿�(msg), 2=> �۹�ȣ=>idx
           // Select�� �ۼ� Where�� =

          String colName = "";
          switch(index){
              case 0 : colName="name"; break;
              case 1 : colName="msg"; break;
              case 2 : colName="idx"; break;
          }
          
          String sql="SELECT idx, name, msg, wdate From memo WHERE "+ colName+" LIKE ?";
         // String sql="SELECT idx, name, msg, wdate From memo WHERE "+ colName+"=?";
          System.out.println("sql = " + sql);
          
          // PS������
          ps=con.prepareStatement(sql);
          ps.setString(1, "%" +keyword+ "%");
           // �����ؼ� RS�ޱ�
          ResultSet rs = ps.executeQuery();
          //  �ݺ��� ���鼭 ������ ������� MEMODTO�� ���
          //  VECTOR�� ������ ��ȯ
          Vector<MemoDTO> v=makeVector(rs);
          
          if(rs!=null) rs.close();
          if(ps!=null) ps.close();
          return v;
           // PS������
          // ps = con.prepareCall(sql);

           
           // ?�� ����
           
           // �����ؼ� RS�ޱ�
           
           // �ݺ��� ���鼭 ������ ������ MEMODTO�� ���
           
           // VECTOR�� ������ ��ȯ
           
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

    // ��ü �ݱ�
    public void dbClose() {
        try {
            System.out.println("db disconnect...");
            if(ps!=null) ps.close();
            if(con!=null) con.close();
            
        } catch(SQLException e) {
            
            
        }
    }
     
     
     
     
     
     
     
}//public class MemoDAO
