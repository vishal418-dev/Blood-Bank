package com.infoviaan.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoviaan.dao.AdminModel;

@WebServlet("/loginCheck")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String user = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		AdminModel model = new AdminModel();
		int i = 0;

		i = model.checkLogin(user, pass);
		
		if (i != 0) {
			response.sendRedirect("adminHome.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
			request.setAttribute("msg", "Incorrect User Name or Password");
			rd.forward(request, response);
		}
	}
}