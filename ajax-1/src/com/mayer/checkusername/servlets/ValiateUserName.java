package com.mayer.checkusername.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValiateUserName
 */
@WebServlet("/valiateUserName")
public class ValiateUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> userNames = Arrays.asList("AA","BB","CC");
		String userName = request.getParameter("userName");
		String result = null;
		if(userNames.contains(userName)){
			result = "<font color='red'>该用户已经被使用</font>";
		}else{
			result = "<font color='green'>该用户可以使用</font>";
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
