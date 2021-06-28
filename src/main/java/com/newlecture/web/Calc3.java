package com.newlecture.web;
import java.io.PrintWriter;
import java.io.IOException;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Cookie[] cookies = request.getCookies(); // 쿠키값들 받기		
				
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp = ""; 
		//쿠키 가져오기
		if(cookies !=null)
			for(Cookie c : cookies) 
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		
		//계산
		if(operator != null && operator.equals("=")) {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operator != null && operator.equals("C")) {
			exp = "";
		}		
		else { //누적		
			exp += (value == null) ?"":value;
			exp += (operator == null) ?"":operator;
			exp += (dot == null) ?"":dot;
		}		
		
		Cookie expCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C"))
			expCookie.setMaxAge(0);
		response.addCookie(expCookie);
		response.sendRedirect("calcpage");
		
		
		
		
	}

}
