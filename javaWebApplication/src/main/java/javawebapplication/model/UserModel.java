package javawebapplication.model;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javawebapplication.bean.UserBean;
import javawebapplication.utility.JDBCDataSource;


public class UserModel {

	public static long nextPk() {
	    long pk = 0;
	    Connection conn;
	    try {
	      conn = JDBCDataSource.getConnection();
	      PreparedStatement stmt = conn.prepareStatement("select Max(userID) from user");
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
	  
	  
	  public static long addUser(UserBean user) {
	    int i = 0;
	    try {
	      Connection conn = JDBCDataSource.getConnection();
	      PreparedStatement stmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");
	      stmt.setLong(1, nextPk());
	      stmt.setString(2 , user.getFirstName() );
	      stmt.setString(3 , user.getLastName() );
	      stmt.setString(4 , user.getLogin() );
	      stmt.setString(5 , user.getPassword() );
	      stmt.setDate(6 , new java.sql.Date(user.getDob().getTime()) );
	      stmt.setString(7 , user.getMobileNo() );
	      stmt.setInt(8, user.getIsMember());
	      stmt.setInt(9,user.getIsDeleted());
	      
	      i = stmt.executeUpdate();
	      
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    
	    return i;
	  }
	
	  public static UserBean  getUser(int userID) {
		    Connection con;
		    UserBean user = null;
		    try {
		      con = JDBCDataSource.getConnection();
		      PreparedStatement stmt = con.prepareStatement("Select * from user where userid=?");
		      stmt.setInt(1,userID);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) {
		        user = new UserBean();
		        System.out.println("ID: "+rs.getLong("userID"));
		        user.setId(rs.getLong("userID"));
		        user.setFirstName(rs.getString("fname"));
		        user.setLastName(rs.getString("lname"));
		        user.setLogin(rs.getString("login"));
		        user.setPassword(rs.getString("password"));
		        user.setDob(rs.getDate("dob"));
		        user.setMobileNo(rs.getString("mobile"));    
		        user.setIsMember(rs.getInt("isMember"));
		        user.setIsDeleted(rs.getInt("isDeleted"));
		      }
		      
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    
		    return user;
		  }
	  
	  public static UserBean  UserLogin(String login, String password) {
		    Connection con;
		    UserBean user = null;
		    try {
		      con = JDBCDataSource.getConnection();
		      PreparedStatement stmt = con.prepareStatement("Select * from user where login=? and password=?");
		      stmt.setString(1,login);
		      stmt.setString(2,password);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) {
		        user = new UserBean();
		        user.setId(rs.getLong("userID"));
		        user.setFirstName(rs.getString("fname"));
		        user.setLastName(rs.getString("lname"));
		        user.setLogin(rs.getString("login"));
		        user.setPassword(rs.getString("password"));
		        user.setDob(rs.getDate("dob"));
		        user.setMobileNo(rs.getString("mobile"));    
		        user.setIsMember(rs.getInt("isMember"));
		        user.setIsDeleted(rs.getInt("isDeleted"));
		      }
		      
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    
		    return user;
	  }
	  
	  
	  
	  
}
