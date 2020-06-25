package co.kr.team.food;


import java.sql.*;
import java.util.Vector;
public class TodayDao {
	
	public static Vector todayList() {
		Vector vRows = new Vector();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from foodtoday  ";
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Vector v = new Vector();
				v.add(rs.getInt("no"));
				v.add(rs.getString("mFname"));
				v.add(rs.getInt("mkcal"));
				v.add(rs.getString("lFname"));
				v.add(rs.getInt("lkcal"));
				v.add(rs.getString("efname"));
				v.add(rs.getInt("ekcal"));
				v.add(rs.getInt("totalkcal"));
				vRows.add(v); // <= �������� �ȵȴ�.
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose(con, ps, rs);
		}//finally
		return vRows;
	}
	
//������ ��õ�޴�

	public static TodayDto selectTno(int x) {
		TodayDto dto = null;
		String sql = "select * from foodtoday where no=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, x);
			rs = ps.executeQuery();
			//NO, MFNAME, MKCAL, LFNAME, LKCAL, EFNAME, EKCAL, TOTALKCAL
			if(rs.next()) {
				dto = new TodayDto();
				dto.setFNo(rs.getInt("no"));
				dto.setMname(rs.getString("mfname"));
				dto.setMKcal(rs.getInt("mkcal"));
				dto.setLname(rs.getString("lfname"));
				dto.setLKcal(rs.getInt("lkcal"));
				dto.setEname(rs.getString("efname"));
				dto.setEKcal(rs.getInt("ekcal"));
				dto.setTotalKcal(rs.getInt("totalkcal"));
			}//if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose(con, ps, rs);
		}//finally
		return dto;
	}//selectId

	

	private static void dbclose(Connection con, PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//if
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//if
	}//dbclose

	private static void dbclose(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//if
		dbclose(con, ps);
	}//dbclose
	
	public static Connection getCon() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "";
		String user = "";
		String password = "";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}//getCon
}