package com.newlecture.web;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calcpage")
public class CalcPage extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Cookie[] cookies = request.getCookies(); // 쿠키값 가져오기
		String exp ="0";
		if(cookies !=null)
			for(Cookie c : cookies) 
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		
		response.setCharacterEncoding("UTF-8"); // 서버가 UTF-8 형식으로 보낸다
		response.setContentType("text/html; charset=UTF-8"); // 클라이언트에게 UTF-8 형식으로 읽으라고 명시
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>hello</title>");
		out.write("<style>");
		out.write("input{");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("}");
		out.write(".output{");
		out.write("height: 50px;");
		out.write("background: #e9e9e9;");
		out.write("font-size:24px;");
		out.write("font-weight: bold;");
		out.write("text-align: right;");
		out.write("padding:0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div>");
		out.write("<form action=\"calc3\" method=\"post\">");
		out.write("					<table>");
		out.write("<tr>");
		out.printf("<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("</tr>");		
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"/\" /></td>");
		out.write("</tr>");				
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"7\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"8\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"9\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"*\" /></td>");
		out.write("</tr>");			
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"4\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"5\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"6\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"－\" /></td>");
		out.write("</tr>");				
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"1\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"2\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"3\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"＋\" /></td>");
		out.write("</tr>");							
		out.write("<tr>");
		out.write("<td></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"0\" /></td>");
		out.write("<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\" /></td>");
		out.write("</tr>");							
		out.write("					</table>");				
		out.write("</form>");	
		out.write("</div>");
					
		out.write("</body>");
		out.write("</html>");	
		
		
		
	}

}
