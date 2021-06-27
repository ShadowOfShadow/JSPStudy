package com.newlecture.web;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletContext application = request.getServletContext(); //상태값 저장하기 위한 서블릿컨텍스트
		HttpSession session = request.getSession(); // 세션
		
		response.setCharacterEncoding("UTF-8"); // 서버가 UTF-8 형식으로 보낸다
		response.setContentType("text/html; charset=UTF-8"); // 클라이언트에게 UTF-8 형식으로 읽으라고 명시
				
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;		
		if(!v_.equals("")) v = Integer.parseInt(v_); // 들어온 값 예외처리
		
		//계산
		if(op.equals("=")) {
			
			//int x = (Integer)application.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v;
			//String operator =(String)application.getAttribute("op");
			String operator =(String)session.getAttribute("op");
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			response.getWriter().printf("result is %d\n", result); // 계산
		}		
		// 값을 저장
		else {
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
			session.setAttribute("value", v);
			session.setAttribute("op", op);
		}		
		
	}

}
