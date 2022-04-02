package javawebapplication.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javawebapplication.bean.ProgramBean;
import javawebapplication.model.ProgramModel;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class UserCTL
 */
@WebServlet(name = "ProgramCTL", urlPatterns = {"/ProgramCTL"})
public class ProgramCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletUtility.forward(JWAView.ProgramView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProgramBean user = new ProgramBean();
	    user.setActivity(request.getParameter("activity"));
	    user.setName(request.getParameter("name"));
	    user.setDay(request.getParameter("day"));
	    user.setCapacity(Integer.parseInt(request.getParameter("capacity")));
	    user.setRegistered(0);
	    user.setStartDate(DataUtility.getDate(request.getParameter("start-date")));
	    user.setEndDate(DataUtility.getDate(request.getParameter("end-date")));
	    user.setStartTime(request.getParameter("start-time"));
	    user.setEndTime(request.getParameter("end-time"));
	    user.setMemberPrice(request.getParameter("member-price"));
	    user.setNonmemberPrice(request.getParameter("non-member-price"));
	    user.setPrereq(request.getParameter("prereq"));
	    
	    long i = ProgramModel.addUser(user);
	    if(i>0) {
	      ServletUtility.setSuccessMessage("Program register sucessfully", request);
	      
	    }else {
	      ServletUtility.setErrorMessage("Not intrested", request);
	    }
	    request.getRequestDispatcher(JWAView.ProgramView).forward(request, response);
	  }
	

}
