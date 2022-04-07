package javawebapplication.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javawebapplication.model.ProgramModel;
import javawebapplication.model.RegisteredModel;
import javawebapplication.bean.RegisterBean;
import javawebapplication.bean.ProgramBean;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class UserListCtl
 */
@WebServlet(name = "MemberProgramListCTL", urlPatterns = { "/MemberProgramListCTL" })
public class MemberProgramListCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberProgramListCTL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProgramModel model = new ProgramModel();
		List list = null;
		list = model.list();
		System.out.println(list.size());

		if (list == null && list.size() == 0) {
			ServletUtility.setErrorMessage("Record Not Found", request);
		}

		ServletUtility.setList(list, request);
		ServletUtility.forward("jsp/MemberProgramList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterBean user = new RegisterBean();
		HttpSession session = request.getSession();
		long curUserID = (long)session.getAttribute("userID");
		user.setUserID((int)curUserID);
		int curProgram = (Integer.parseInt(request.getParameter("registerButton")));
		user.setProgramID(curProgram);
		ProgramBean programnow = RegisteredModel.getProgram(curProgram);
		System.out.println(programnow.getName());
		long i = RegisteredModel.addUser(user);
		if (i > 0) {
			ServletUtility.setSuccessMessage("Program register sucessfully", request);
		} else {
			ServletUtility.setErrorMessage("Not intrested", request);
		}
		doGet(request, response);
	}
}