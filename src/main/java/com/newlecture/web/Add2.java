package com.newlecture.web;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); // 서버가 UTF-8 형식으로 보낸다
		response.setContentType("text/html; charset=UTF-8"); // 클라이언트에게 UTF-8 형식으로 읽으라고 명시
				
		String[] num_ = request.getParameterValues("num");
		
		int result = 0;
		
		for(int i=0; i<num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result+=num;
		}		
		
		response.getWriter().printf("result is %d\n", result);
		
	}

}
