package javawebapplication.bean;

import java.util.Date;

public class ProgramBean {
	 private String activity;
	 private String name;
	 private String day;
	 private int capacity;
	 private int registered;
	 private Date startDate;
	 private Date endDate;
     private String startTime;
	 private String endTime;
	 private String memberPrice;
	 private String nonmemberPrice;
	 private String prereq;
	 private long id;
	 
	 public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int newCap) {
		this.capacity = newCap;
	}
	
	public int getRegistered() {
		return registered;
	}
	
	public void setRegistered(int newRegistered) {
		this.registered = newRegistered;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(String memberPrice) {
		this.memberPrice = memberPrice;
	}
	public String getNonmemberPrice() {
		return nonmemberPrice;
	}
	public void setNonmemberPrice(String nonmemberPrice) {
		this.nonmemberPrice = nonmemberPrice;
	}
	public String getPrereq() {
		return prereq;
	}
	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}


	