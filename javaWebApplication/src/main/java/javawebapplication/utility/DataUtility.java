package javawebapplication.utility;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtility {
  
  public static final String APP_DATE_FORMAT = "MM/dd/yyyy";
    //    public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
  /**
   * Date formatter
   */
  private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);
  //private static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);
 
  
  public static String getString(String val) {
    if (DataValidator.isNotNull(val)) {
      return val.trim();
    } else {
      return val;
    }
  }
 
  
  public static String getStringData(Object val) {
    
    if (val != null) {
      return val.toString();
    } else {
      return "";
    }
  }

  
  public static int getInt(String val) {
    if (DataValidator.isInteger(val)) {
      return Integer.parseInt(val);
    } else {
      return 0;
    }
  }
 
  
  public static long getLong(String val) {
    if (DataValidator.isLong(val)) {
      return Long.parseLong(val);
    } else {
      return 0;
    }
  }
  
  
   public static Date getDate(String val) {
          Date date = null;
          try {
              date = formatter.parse(val);
          } catch (Exception e) {
          }
          return date;
      }
  public static Date getDate1(String val) {
    Date date = null;
    
    try {
      date = formatter.parse(val);
      
    }catch(Exception e){}
    return date;
  }
  
  
  public static String getDateString(Date date) {
    
    try {
       if(date!=null) {
        return formatter.format(date);
      }
      else{
        return "";
      }
    } catch (Exception e) {
      return "";
    }
    
  }
  
  
  public static Date getDate(Date date, int day) {
    return null;
  }
  
  
  public static Timestamp getTimestamp(long l) {
    Timestamp timeStamp = null;
    try {
      timeStamp = new Timestamp(l);
    } catch (Exception e) {
      return null;
    }
    return timeStamp;
  }
  
  
  public static Timestamp getTimestamp(String cdt) {
    Timestamp timeStamp = null;
    try {
    //    timeStamp = new Timestamp((timeFormatter.parse(cdt)).getTime());
    } catch (Exception e) {
      return null;
    }
    return timeStamp;
  }
  
  
  public static long getTimestamp(Timestamp tm) {
    try {
      return tm.getTime();
    } catch (Exception e) {
      return 0;
    }
  }
  
  
  public static Timestamp getCurrentTimestamp() {
    Timestamp timeStamp = null;
    try {
      timeStamp = new Timestamp(new Date().getTime());
    } catch (Exception e) {
    }
    return timeStamp;
  }
}
