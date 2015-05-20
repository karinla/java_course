package com.lainer.service;

import java.util.Calendar;
import java.util.Date;

import com.lainer.*;
import com.lainer.model.*;

/*
 * class that shows a portfolio manager
 * we use this class to excute diffrent things on the portfolio
 */

public class PortfolioManager {

	public Portfolio getPortfolio(){
	
		Portfolio portfolio = new Portfolio("Exercise 7 portfolio");
		portfolio.updateBalance(10000);
		

		Calendar cal = Calendar.getInstance();
		cal.set(2014,11,15);
		Date date1 = cal.getTime();
		Date date2 = cal.getTime();
		Date date3 = cal.getTime(); 
		
		float ask_PIH = (float)13.1;
		float ask_AAL = (float)5.78;
		float ask_CAAS = (float)32.2;
		
		float bid_PIH = (float)12.4;
		float bid_AAL = (float)5.5;
		float bid_CAAS = (float) 31.5;
		
		Stock PIH = new Stock("PIH",ask_PIH,bid_PIH,date1);
		Stock AAL = new Stock("AAL",ask_AAL,bid_AAL,date2);
		Stock CAAS = new Stock("CAAS",ask_CAAS,bid_CAAS,date3);
		
		portfolio.buyStock(PIH, 20);
		portfolio.buyStock(AAL, 30);
		portfolio.buyStock(CAAS, 40);
		
		portfolio.sellStock("AAL", -1);
		portfolio.removeStock("CAAS");
		
		return portfolio;
}
}
	
	
	