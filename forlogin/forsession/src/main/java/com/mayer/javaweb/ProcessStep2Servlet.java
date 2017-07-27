package com.mayer.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessStep2Servlet
 */
public class ProcessStep2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String cardType = request.getParameter("cardType");
		String cardNum = request.getParameter("cardNum");
		
		Customer customer = new Customer(name, address, cardType, cardNum);
		
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		
		response.sendRedirect(request.getContextPath() + "/confirm.jsp");
		
	}

}
