package com.infoviaan.ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoviaan.dao.AdminModel;
import com.infoviaan.dto.Donor;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobile = request.getParameter("mobile");
		AdminModel model = new AdminModel();
		Donor dd = model.getDonorRecord(mobile);

		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		request.setAttribute("DONOR", dd);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String bloodgroup = request.getParameter("bloodgroup");
		boolean diseas = Boolean.parseBoolean(request.getParameter("diseas"));
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("mobile");

		Donor dd = new Donor(name, age, bloodgroup, diseas, gender, mobile);
		AdminModel model = new AdminModel();
		int i = model.updateDonorDetails(dd);
		ArrayList<Donor> al = model.getAllDonors();

		RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
		if (i != 0) {
			request.setAttribute("msg", "Record Successfully Updated");
			request.setAttribute("LIST", al);
		} else {
			request.setAttribute("msg", "Record Not Updated");
			request.setAttribute("LIST", al);
		}
		rd.forward(request, response);

	}
}
