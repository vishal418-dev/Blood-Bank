package com.infoviaan.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoviaan.dao.AdminModel;
import com.infoviaan.dto.Donor;

@WebServlet({ "/RegisterController", "/registerController" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String bloodgroup = request.getParameter("bloodgroup");
		boolean diseas = Boolean.parseBoolean(request.getParameter("diseas"));
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("mobile");

		Donor d = new Donor(name, age, bloodgroup, diseas, gender, mobile);

		AdminModel model = new AdminModel();
		int i = model.registerDonor(d);

		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		if (i != 0) {
			request.setAttribute("msg", "Record Inserted Successfully");
		} else {
			request.setAttribute("msg", "Record Not Inserted");
		}
		rd.forward(request, response);
	}
}