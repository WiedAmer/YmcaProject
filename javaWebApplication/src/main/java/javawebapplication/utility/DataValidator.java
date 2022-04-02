package javawebapplication.utility;

import java.util.Date;

public class DataValidator {
	
  //Validate the name or any text input 
  public static boolean isName(String val) {
    String name = "^[A-Za-z ]*$";
    if (val.matches(name)) {
      return true;
    } else {
      return false;
    }
  }
  
  //Validate the roll number
  public static boolean isRollNO(String val) {
    String passregex = "^([0-9]{2}[A-Z]{2}[0-9]{1,})\\S$";
    if (val.matches(passregex)) {
      return true;
    } else {
      return false;
    }
  }

  //Validate passwords
  public static boolean isPassword(String val) {
    String passregex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12}$";
    if (val.matches(passregex)) {
      return true;
    } else {
      return false;
    }
  }
 
  //Validate Phone numbers
  public static boolean isPhoneNo(String val) {
    String regex = "^[7-9][0-9]{9}$";
    if (val.matches(regex)) {
      return true;
    } else {
      return false;
    }
  }
 
  //validate the null valuse
  public static boolean isNull(String val) {
    if (val == null || val.trim().length() == 0) {
      return true;
    } else {
      return false;
    }
  }
  
  //checks if data is null or not
  public static boolean isNotNull(String val) {
    return !isNull(val);
  }
  
  //checks if the data is an integer
  public static boolean isInteger(String val) {
    if (isNotNull(val)) {
      try {
        int i = Integer.parseInt(val);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    } else {
      return false;
    }
  }
  
  //checks if the data is a long
  public static boolean isLong(String val) {
    if (isNotNull(val)) {
      try {
        long i = Long.parseLong(val);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    } else {
      return false;
    }
  }
  /*public static boolean isIntegerName(String val) {
    String match = "^[0-9]{3}$";
    if (val.matches(match)) {
      return true;
    } else {
      return false;
    }
  }*/
 
  //validates email's
  public static boolean isEmail(String val) {
    String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    if (isNotNull(val)) {
      try {
        return val.matches(emailreg);
      } catch (NumberFormatException e) {
        return false;
      }
    } else {
      return false;
    }
  }
  
  //Checks if date it correct
  public static boolean isDate(String val) {
    Date d = null;
    if (isNotNull(val)) {
      d = DataUtility.getDate(val);
    }
    return d != null;
  }
 
  
}