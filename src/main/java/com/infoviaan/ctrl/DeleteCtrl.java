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

/**
 * Servlet implementation class DeleteCtrl
 */
@WebServlet("/DeleteCtrl")
public class DeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobile = request.getParameter("mobile");
		System.out.println("at delete controller get Mobile ---> " + mobile);
		AdminModel model = new AdminModel();
		int i = model.deleteDonor(mobile);
		ArrayList<Donor> list = model.getAllDonors();

		RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
		if (i != 0) {
			request.setAttribute("msg", "Record Deleted");
			request.setAttribute("LIST", list);
		} else {
			request.setAttribute("msg", "Record Not Deleted");
			request.setAttribute("LIST", list);
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
