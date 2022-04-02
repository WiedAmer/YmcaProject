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

import javawebapplication.bean.UserBean;
import javawebapplication.model.UserModel;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class UserCTL
 */
@WebServlet(name = "UserCTL", urlPatterns = {"/UserCTL"})
public class UserCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletUtility.forward(JWAView.UserView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
	    user.setFirstName(request.getParameter("firstName"));
	    user.setLastName(request.getParameter("lastName"));
	    user.setLogin(request.getParameter("login"));
	    user.setPassword(request.getParameter("password"));
	    user.setDob(DataUtility.getDate(request.getParameter("dob")));
	    user.setMobileNo(request.getParameter("mobile"));
	    String isMember = request.getParameter("isMember");
	    if(isMember.equals("member")) {
	    	user.setIsMember(1);
	    }
	    else {
	    	user.setIsMember(0);
	    }
	    user.setIsDeleted(0);

	    long i = UserModel.addUser(user);
	    if(i>0) {
	      ServletUtility.setSuccessMessage("User register sucessfully", request);
	      
	    }else {
	      ServletUtility.setErrorMessage("Not intrested", request);
	    }
	    request.getRequestDispatcher(JWAView.UserView).forward(request, response);
	  }
	

}
