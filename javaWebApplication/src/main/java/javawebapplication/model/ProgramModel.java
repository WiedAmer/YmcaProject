package javawebapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javawebapplication.bean.ProgramBean;
import javawebapplication.bean.UserBean;
import javawebapplication.utility.JDBCDataSource;
//import jdk.nashorn.internal.ir.WhileNode;
public class ProgramModel {
  
  public static long nextPk() {
    long pk = 0;
    Connection conn;
    try {
      conn = JDBCDataSource.getConnection();
      PreparedStatement stmt = conn.prepareStatement("select Max(programID) from program");
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
        pk = rs.getLong(1);
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return pk+1;
    
  }
  
  
  public static long addUser(ProgramBean user) {
    int i = 0;
    try {
      Connection conn = JDBCDataSource.getConnection();
      PreparedStatement stmt = conn.prepareStatement("insert into program values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
      stmt.setLong(1, nextPk());
      stmt.setString(2 , user.getActivity() );
      stmt.setString(3 , user.getName() );
      stmt.setString(4 , user.getDay() );
      stmt.setInt(5, user.getCapacity());
      stmt.setInt(6, user.getRegistered());
      stmt.setDate(7 , new java.sql.Date(user.getStartDate().getTime()) );
      stmt.setDate(8 , new java.sql.Date(user.getEndDate().getTime()) );
      stmt.setString(9 , user.getStartTime() );
      stmt.setString(10 , user.getEndTime() );
      stmt.setString(11 , user.getMemberPrice() );
      stmt.setString(12 , user.getNonmemberPrice() );
      stmt.setString(13 , user.getPrereq() );
        i =     stmt.executeUpdate();
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    return i;
  }
  
  public static List list() {
	  ArrayList list=new ArrayList();
	  Connection conn=null;
	  try {
	     conn=JDBCDataSource.getConnection();
	    PreparedStatement pstmt=conn.prepareStatement("Select * from program");
	    ResultSet rs= pstmt.executeQuery();
	    while (rs.next()) {
	    ProgramBean user=new ProgramBean();
	    user.setId(rs.getLong("programID"));
	    user.setActivity(rs.getString("activity"));
	    user.setName(rs.getString("name"));
	    user.setDay(rs.getString("day"));
	    user.setCapacity(rs.getInt("capacity"));
	    user.setRegistered(rs.getInt("registered"));
	    user.setStartDate(rs.getDate("start-date"));
	    user.setEndDate(rs.getDate("end-date"));
	    user.setStartTime(rs.getString("start-time"));
	    user.setEndTime(rs.getString("end-time"));
	    user.setMemberPrice(rs.getString("member-price"));
	    user.setNonmemberPrice(rs.getString("non-member-price"));
	    user.setPrereq(rs.getString("prereq"));
	    list.add(user);
	    }
	  } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	  }finally {
	    JDBCDataSource.closeConnection(conn);
	  }
	  return list;
	}
}