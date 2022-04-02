package javawebapplication.bean;

import java.util.Date;

public class RegisterBean {
	 private int userID;
	 private int programID;
	 
	 public int getUserID() {
		 return userID;
	 }
	 
	 public void setUserID(int newID) {
		 this.userID = newID;
	 }
	 
	 public int getProgramID() {
		 return programID;
	 }
	 
	 public void setProgramID(int newID) {
		 this.programID = newID;
	 }
}