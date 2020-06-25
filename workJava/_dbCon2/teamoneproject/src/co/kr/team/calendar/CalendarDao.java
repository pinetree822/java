package co.kr.team.calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalendarDao {

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
	}
	
	public static CalendarDto selectId(String date, String b) {
		CalendarDto dto = null;
		String sql = "select * from pi where h_day=? and id =?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, date);
			ps.setString(2, b);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new CalendarDto();
				dto.setH_day(rs.getString("h_day"));
				dto.setWeight_e(rs.getDouble("weight_e"));
				dto.setFood(rs.getDouble("food"));
				dto.setSport(rs.getDouble("sports"));
				dto.setBiman_e(rs.getDouble("biman_e"));
				dto.setBiman_r(rs.getString("biman_r"));
			}// if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbclose(con, ps, rs);
		}// finally
		return dto;
	}

	private static void dbclose(Connection con, PreparedStatement ps,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// if
		dbclose(con, ps);
	}

	private static void dbclose(Connection con, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// if
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// if
	}

	public static CalendarDto selectMonth(String g, String b) {
		CalendarDto dto = null;
		String sql = "select * from pi where h_day=? and id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, g);
			ps.setString(2, b);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new CalendarDto();
				dto.setH_day(rs.getString("h_day"));
				dto.setWeight_e(rs.getDouble("weight_e"));
				dto.setFood(rs.getDouble("food"));
				dto.setSport(rs.getDouble("sports"));
				dto.setBiman_e(rs.getDouble("biman_e"));
				dto.setBiman_r(rs.getString("biman_r"));
			}// if
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			dbclose(con, ps, rs);
		}// finally
		return dto;
	}
	
}
