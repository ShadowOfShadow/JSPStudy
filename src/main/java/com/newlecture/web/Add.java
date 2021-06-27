package com.newlecture.web;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); // ������ UTF-8 �������� ������
		response.setContentType("text/html; charset=UTF-8"); // Ŭ���̾�Ʈ���� UTF-8 �������� ������� ���
				
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		
		int x = 0;
		int y = 0;
		
		if(!number1.equals("")) x = Integer.parseInt(number1);
		if(!number2.equals("")) y = Integer.parseInt(number2);
		
		int result = x+y;
		
		response.getWriter().printf("result is %d\n", result);
		
	}

}
