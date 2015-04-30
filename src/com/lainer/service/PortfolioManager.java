package com.lainer.service;

import java.util.Calendar;
import java.util.Date;

import com.lainer.*;
import com.lainer.model.*;

public class PortfolioManager {

	public Portfolio getPortfolio(){
	
		Portfolio portfolio = new Portfolio();
		portfolio.setTitle("Show Portfolio Ex.5");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014,10,15);
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
		
		portfolio.addStock(PIH);
		portfolio.addStock(AAL);
		portfolio.addStock(CAAS);
		
		return portfolio;
}
}
	
	
	