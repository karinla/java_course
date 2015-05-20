package com.lainer;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lainer.model.Stock;

import java.util.*;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				
		resp.setContentType("text/html");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 10, 15);
		
		float ask_PIH = (float)13.1;
		float ask_AAL = (float)5.78;
		float ask_CAAS = (float)32.2;
		
		float bid_PIH = (float)12.4;
		float bid_AAL = (float)5.5;
		float bid_CAAS = (float) 31.5;
		
		Date date1 = cal.getTime();
		Date date2 = cal.getTime();
		Date date3 = cal.getTime();
		
		Stock PIH = new Stock("PIH",ask_PIH,bid_PIH,date1);
		Stock AAL = new Stock("AAL",ask_AAL,bid_AAL,date2);
		Stock CAAS = new Stock("CAAS",ask_CAAS,bid_CAAS,date3);
		
		resp.getWriter().println(PIH.getHtmlDescription());
		resp.getWriter().println(AAL.getHtmlDescription());
		resp.getWriter().println(CAAS.getHtmlDescription());
	}
}
