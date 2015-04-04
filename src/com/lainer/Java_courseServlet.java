package com.lainer;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Java_courseServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		int Num1 = 4;
		int Num2 = 3;
		int Num3 = 7;
		int result = (Num1*Num3) + (Num2*Num3);
		
		String resultStr = new String ("<h1> result of (Num1*Num3) + (Num2*Num3) = "+result+ "</h1>");
	
			resp.getWriter().println(resultStr);
		
			}
	
	
}
