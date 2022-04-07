package javawebapplication.controller;

public interface JWAView {

	public String APP_CONTEXT = "/javaWebApplication";
	public String PAGE_FOLDER = "/jsp";
	
	public String LoginView = PAGE_FOLDER+"/LoginView.jsp";
	public String LoginCTL = APP_CONTEXT + "/LoginCTL";
	
	public String UserView = PAGE_FOLDER+"/UserView.jsp";
	public String UserCTL = APP_CONTEXT + "/UserCTL";
	
	public String WelcomeCTL = APP_CONTEXT + "/WelcomeCTL";
	public String WelcomeView = PAGE_FOLDER + "/WelcomeView.jsp";
	
	public String ProgramListCTL = APP_CONTEXT + "/ProgramListCTL";
	public String ProgramListView = PAGE_FOLDER + "/ProgramListView.jsp";
	
	public String ProgramCTL = APP_CONTEXT + "/ProgramCTL";
	public String ProgramView = PAGE_FOLDER + "/ProgramView.jsp";
	
	public String MemberPLCTL = APP_CONTEXT +"/MemberProgramListCTL";
	public String MemberPLView = PAGE_FOLDER +"/MemberProgramList.jsp";
	 
	public String NonMemberPLCTL = APP_CONTEXT + "/NonMemberPLCTL";
	public String NonMemberPLView = PAGE_FOLDER +"/NonMemberPL.jsp";
	
	public String StaffPLCTL = APP_CONTEXT +"/StaffProgramListCTL";
	public String StaffPLView = PAGE_FOLDER +"/StaffProgramList.jsp";
	
	public String RegisteredUserCTL = APP_CONTEXT +"/RegisteredUserCTL";
	public String RegisteredUserView = PAGE_FOLDER +"/RegisteredUser.jsp";
}
