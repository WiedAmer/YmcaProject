package javawebapplication.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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
import javawebapplication.utility.DataUtility;
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
		user.setUserID((int) curUserID);
		int curProgram = (Integer.parseInt(request.getParameter("registerButton")));
		user.setProgramID(curProgram);
		ProgramBean programnow = RegisteredModel.getProgram(curProgram);
		System.out.println(programnow.getName());
		List programList = RegisteredModel.registeredList((int) curUserID);

		if (programnow.getCapacity() == programnow.getRegistered()) {
			ServletUtility.setErrorMessage("This Class is full", request);
			doGet(request, response);
		} else {
			//Gets all the dates programnow takes place on in list programNowDates
			Date firstDate = (Date) programnow.getStartDate();
			Date secondDate =  (Date) programnow.getEndDate();
			System.out.println(firstDate);
			List datesInRange = DataUtility.getDatesBetween(firstDate, secondDate);
			List programNowDates = new ArrayList();
			for(int lcv2 = 0;lcv2<datesInRange.size();lcv2+=7) {
				programNowDates.add(datesInRange.get(lcv2));
			}
			//--------------------------------------------------------
			boolean canRegister = true;
			for (int lcv = 0; lcv < programList.size(); lcv++) {
				ProgramBean newProg = (ProgramBean) programList.get(lcv);
				if (newProg.getDay().toUpperCase().equals(programnow.getDay().toUpperCase())) {
					List tempDatesInRange = DataUtility.getDatesBetween((Date)newProg.getStartDate(), (Date)newProg.getEndDate());
					List curDatesInRange = new ArrayList<>();
					for(int lcv3 = 0;lcv3<tempDatesInRange.size();lcv3+=7) {
						curDatesInRange.add(tempDatesInRange.get(lcv3));
					}
					//onSameDate == true if the classes take place on the same DATE
					boolean onSameDate = false;
					for(int lcv4 = 0;lcv4<programNowDates.size();lcv4++) {
						for(int lcv5=0;lcv5<curDatesInRange.size();lcv5++) {
							if(programNowDates.get(lcv4).equals(programNowDates.get(lcv5))) {
								onSameDate=true;
							}
						}
					}
					
					if(onSameDate==true) {
						//CHECKS TIME
					}
				}
			}
			long i = RegisteredModel.addUser(user);
			if (i > 0) {
			    ProgramModel.updateUser(programnow);
				ServletUtility.setSuccessMessage("Program register sucessfully", request);
			} else {
				ServletUtility.setErrorMessage("Not intrested", request);
			}
		}

		doGet(request, response);
	}
}