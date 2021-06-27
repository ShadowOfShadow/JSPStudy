package com.newlecture.web;
import java.io.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); // 서버가 UTF-8 형식으로 보낸다
		response.setContentType("text/html; charset=UTF-8"); // 클라이언트에게 UTF-8 형식으로 읽으라고 명시
		
		PrintWriter out = response.getWriter();
		
		String temp = request.getParameter("cnt");
		int cnt = 0;
		if(temp != null && !temp.equals(""))
			cnt = Integer.parseInt(temp);				
		
		for(int i =0; i<cnt; i++) {
			out.println((i+1)+": 안녕 Servlet!!<br >");
		}
		
	}

}
