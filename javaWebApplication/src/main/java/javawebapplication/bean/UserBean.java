package javawebapplication.bean;

import java.util.Date;

public class UserBean {
	 private String firstName;
	  private String lastName;
	  private String login;
	  private String password;
	  private Date dob;
	  private String mobileNo;
	  private int isMember;
	  private int isDeleted;
	  private long id;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getIsMember() {
		return isMember;
	}
	public void setIsMember(int member) {
		this.isMember = member;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int delete) {
		this.isDeleted = delete;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
