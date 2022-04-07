package javawebapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javawebapplication.bean.ProgramBean;
import javawebapplication.bean.RegisterBean;
import javawebapplication.bean.UserBean;
import javawebapplication.utility.JDBCDataSource;

//import jdk.nashorn.internal.ir.WhileNode;
public class RegisteredModel {

	public static long addUser(RegisterBean user) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into registered_for values(?,?)");
			stmt.setInt(1, user.getUserID());
			stmt.setInt(2, user.getProgramID());
			i = stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static ProgramBean getProgram(int programID) {
		Connection conn = null;
		ProgramBean program = new ProgramBean();
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("Select * from program where programID = ?");
			pstmt.setInt(1, programID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				program.setId(rs.getLong("programID"));
				program.setActivity(rs.getString("activity"));
				program.setName(rs.getString("name"));
				program.setDay(rs.getString("day"));
				program.setCapacity(rs.getInt("capacity"));
				program.setRegistered(rs.getInt("registered"));
				program.setStartDate(rs.getDate("start-date"));
				program.setEndDate(rs.getDate("end-date"));
				program.setStartTime(rs.getString("start-time"));
				program.setEndTime(rs.getString("end-time"));
				program.setMemberPrice(rs.getString("member-price"));
				program.setNonmemberPrice(rs.getString("non-member-price"));
				program.setPrereq(rs.getString("prereq"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return program;
	}

	public static List registeredList(int userID) {
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			// statement to return all program IDs that a user is currently registered for
			PreparedStatement pstmt = conn.prepareStatement("select programID from registered_for where userID = ?");
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery(); // this will be a result set with all program IDs

			while (rs.next()) {
				ProgramBean program = (getProgram(rs.getInt("programID")));
				list.add(program);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}

	public static List registeredUserList(int programID) {
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			// statement to return all program IDs that a user is currently registered for
			PreparedStatement pstmt = conn.prepareStatement("select userID from registered_for where programID = ?");
			pstmt.setInt(1, programID);
			ResultSet rs = pstmt.executeQuery(); // this will be a result set with all program IDs

			while (rs.next()) {
				UserBean user = (UserModel.getUser(rs.getInt("userID")));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}

	public static void removeRegistration(int userID, int programID) {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("delete from registered_for where userID = ? and programId = ?");
			stmt.setInt(1, userID);
			stmt.setInt(2, programID);
			stmt.execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return;
	}

}