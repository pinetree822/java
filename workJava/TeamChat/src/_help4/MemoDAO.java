package _help4;
import java.sql.*;
import java.util.Vector;
/* DAO : Data Access Object
: �����ͺ��̽��� �����Ͽ� biz���� (insert, delete, udate, select ��)
  �� �����ϴ� Ŭ����

CRUD �۾� ����========>biz logic
c : create=> insert��
r : read  => select��
u : update=> update��
d : delete => delete��
*/
public class MemoDAO {
    private String url="jdbc:oracle:thin:@192.168.10.150:1521:ORCL";
    private String user="james", pwd="tiger";
    private Connection con;
    private PreparedStatement ps;
    
    public MemoDAO(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url,user,pwd);
            System.out.println("db connected...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//������-----------------------
    public boolean insertMemo2(MemoDTO memo){
    	try {
    		String sql="{call MEMO_ADD(?,?)}";
    		CallableStatement cs=con.prepareCall(sql);
    		cs.setString(1,memo.getName());
    		cs.setString(2, memo.getMsg());
    		cs.execute();
    		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}    	
    }//---------------------------
    
    /**�޸� ������ ����ϴ� �޼ҵ�=>insert���� ����*/
    public boolean insertMemo(MemoDTO memo){
        try {
            //1. INSERT���� �ۼ�
            String sql="INSERT INTO memo(idx, name, msg, wdate)";
            sql+=" VALUES(memo_idx_seq.nextval,?,?, sysdate)";
            //2. ps ������
            ps=con.prepareStatement(sql);
            ps.setString(1, memo.getName());
            ps.setString(2,memo.getMsg());
            //3. db�� ����=> executeXXX()
            int cnt=ps.executeUpdate();
            //4. ������ �����̸� return true, ���и� false��ȯ
            boolean bool=(cnt>0)? true:false;
            if(ps!=null) ps.close();
            return bool;
            
        } catch (Exception e) {
            e.printStackTrace();
             return false;
        }
    }
    
    /**�۹�ȣ(pk)�� Ư�� ���� �������� �޼ҵ�*/
    public MemoDTO selectMemoByIdx(int idx){
        try {
            //select�� where��
            String sql="SELECT idx,name,msg,wdate FROM memo WHERE idx=?";
            ps=con.prepareStatement(sql);
            //? ����
            ps.setInt(1, idx);
            //����=> rs
            ResultSet rs=ps.executeQuery();
            MemoDTO m=null;
            while(rs.next()){
                int idx2=rs.getInt(1);
                String name=rs.getString(2);
                String msg=rs.getString(3);
                java.sql.Date wdate=rs.getDate(4);
                m=new MemoDTO(idx2,name,msg,wdate);                            
            }
            return m;              
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
       
    
    /**��� �޸� ����� �������� �޼ҵ� - select���� ����*/
    public Vector<MemoDTO> selectAllMemo(){
        try {
            //1.  SELECT�� �ۼ� ORDER BY IDX DESC
            String sql="SELECT idx,name,rpad(msg,50,' ') msg,wdate FROM memo ORDER BY 1 DESC";            
            //2. PS ������
            ps=con.prepareStatement(sql);
            
            //3. EXECUTExxx()�޼ҵ�� RS�ޱ�
            ResultSet rs=ps.executeQuery();
            
            //4. �ݺ��� ���鼭 �÷������� ������
            //=> MemoDTO�� �����ؼ� �����͸� setting
            Vector<MemoDTO> v=makeVector(rs);
           
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }//----------------------------------
    
    
    
    /**�۹�ȣ(PK)�� Ư�� ���� �����ϴ� �޼ҵ�-delete�� ����*/
    public boolean deleteMemo(int idx)
    {
        try {
            //1. sql�� �ۼ�
            String sql="DELETE FROM memo WHERE idx=?";
            //2. ps ���
            ps=con.prepareStatement(sql);
            
            //3. ? �� ����
            ps.setInt(1, idx);
            
            //4. ����
            int cnt=ps.executeUpdate();
            if(ps!=null) ps.close();
            
            //5. �� ��� ��ȯ
            if(cnt>0) return true;
            else return false;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }       
    }//----------------------------------
    
    /** Ư�� ���� �����ϴ� �޼ҵ� update���� �����Ѵ�.*/
    public boolean updateMemo(MemoDTO memo){
        try {
            //update�� �ۼ� where��
            String sql="UPDATE memo SET name=?, msg=?, wdate=sysdate";
                sql+=" WHERE idx=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,memo.getName());
            ps.setString(2, memo.getMsg());
            ps.setInt(3, memo.getIdx());
            int cnt=ps.executeUpdate();
            if(cnt>0) return true;
            
            else  return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }//----------------------------------

    /** �˻���� �޸� ������ �˻��ϴ� �޼ҵ�*/
    public Vector<MemoDTO> findMemo(int index, String keyword) {
        try {
            //0 => �ۼ���(name), 1=>�޸𳻿�(msg)  2=> �۹�ȣ=> idx
            String colName="";
            switch(index){
                case 0: colName="name"; break;
                case 1: colName="msg";break;
                case 2: colName="idx"; break;
            }//switch----------
            //SELECT�� �ۼ� WHERE��  = 
            //String sql="SELECT idx,name,msg,wdate FROM memo WHERE "+colName+"=?";
            //SELECT��  WHERE���� LIKE ������ ����غ�����.
            String sql="SELECT * FROM memo WHERE "+colName+" LIKE ?";
            
            System.out.println("sql="+sql);
            //PS������
            ps=con.prepareStatement(sql);
            ps.setString(1, "%"+keyword+"%");                        
            //�����ؼ� RS�ޱ�
            ResultSet rs=ps.executeQuery();
            //�ݺ��� ���鼭 �����Ͳ����� MEMODTO�� ���
            //vECTOR�� ������ ��ȯ
            Vector<MemoDTO> v=makeVector(rs);
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }//----------------------------------

    private Vector<MemoDTO> makeVector(ResultSet rs) 
    throws SQLException
    {
         Vector<MemoDTO> v=new Vector<MemoDTO>();
            while(rs.next()){
                int idx=rs.getInt("idx");
                String name=rs.getString("name");
                String msg=rs.getString("msg");
                java.sql.Date wdate=rs.getDate("wdate");
                MemoDTO record=new MemoDTO(idx,name,msg,wdate);
                v.add(record);
            }//while-------------
            return v;
    }//------------------------------------

    public void dbClose() {
        try{
            System.out.println("db disconnect...");
            if(ps!=null) ps.close();
            if(con!=null) con.close();
        }catch(SQLException e){
            
        }
        
    }//--------------------------
    
}//////////////////////////////////////////////////







