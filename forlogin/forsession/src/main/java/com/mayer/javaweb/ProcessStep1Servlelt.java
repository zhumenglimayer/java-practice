package com.mayer.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessStep1Servlelt
 */
public class ProcessStep1Servlelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] books = request.getParameterValues("book");
		request.getSession().setAttribute("books", books);
		response.sendRedirect(request.getContextPath() + "/step-2.jsp");
	}

}
