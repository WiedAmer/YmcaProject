<%@page import="javawebapplication.utility.DataUtility"%>
<%@page import="javawebapplication.bean.ProgramBean"%>
<%@page import="javawebapplication.bean.RegisterBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="javawebapplication.utility.ServletUtility"%>
<%@ include file="Header.jsp"%>
<br>
<h2>Program List</h2>
<br>
<h4 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
<h4 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>
<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Activity</th>
			<th scope="col">Location</th>
			<th scope="col">Day</th>
			<th scope="col">Capacity</th>
			<th scope="col">Current # Enrolled</th>
			<th scope="col">Start-Date</th>
			<th scope="col">End-Date</th>
			<th scope="col">Start-Time</th>
			<th scope="col">End-Time</th>
			<th scope="col">Member-Price</th>
			<th scope="col">Prereq</th>
			<th scope="col">Register</th>
		</tr>
	</thead>
	<tbody>
		<%
		int index = 1;
		List list = ServletUtility.getList(request);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			ProgramBean user = (ProgramBean) it.next();
		%>
		<tr>
			<th scope="row"><%=index++%></th>
			<td><%=user.getActivity()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getDay()%></td>
			<td><%=user.getCapacity()%></td>
			<td><%=user.getRegistered()%></td>
			<td><%=DataUtility.getDateString(user.getStartDate())%></td>
			<td><%=DataUtility.getDateString(user.getEndDate())%></td>
			<td><%=user.getStartTime()%></td>
			<td><%=user.getEndTime()%></td>
			<td><%=user.getMemberPrice()%></td>
			<td><%=user.getPrereq()%></td>
			<td><form action="<%=JWAView.MemberPLCTL%>" method="post">
					<input type="submit" class="btn btn-primary" name="registerButton"
						value=<%=user.getId()%>>
				</form></td>
		</tr>

		<%
		}
		%>
	</tbody>
</table>
<%@ include file="Footer.jsp"%>