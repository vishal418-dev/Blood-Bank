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

@WebServlet("/DetailsController")
public class DetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminModel model = new AdminModel();
		ArrayList<Donor> list = model.getAllDonors();
	
		RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
		request.setAttribute("LIST", list);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
