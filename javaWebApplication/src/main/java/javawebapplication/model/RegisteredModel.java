package javawebapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javawebapplication.bean.RegisterBean;
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
      i =     stmt.executeUpdate();
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    return i;
  }
}