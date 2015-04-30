package com.lainer.model;
import com.lainer.Stock;



public class Portfolio {

	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private int sizeOfPortfolio;
	private String title;
	private Stock[] stocks;
	
	public Portfolio() {
		this.title = new String("");
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.sizeOfPortfolio = 0;
	}

	public void addStock(Stock stock){
		
		if(sizeOfPortfolio < MAX_PORTFOLIO_SIZE && stock!=null ){
			stocks[this.sizeOfPortfolio] = stock;
			sizeOfPortfolio++;	
		}
		
		else {
			System.out.println(" Portfolio is Full or stock in NULL ");
		}
	}
	
	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}
	
	public int getSizeOfPortfolio() {
		return sizeOfPortfolio;
	}

	public void setSizeOfPortfolio(int sizeOfPortfolio) {
		this.sizeOfPortfolio = sizeOfPortfolio;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Stock[] getStocks() {
		return stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	
	public Stock[] getstocks() {
		return stocks;
	}
	public void setstocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public String getHtmlString(){
		
		String htmlString = new String();
		htmlString = htmlString+"<h1>"+this.getTitle()+"</h1> <br>";
		
		for(int i = 0 ; i < sizeOfPortfolio ; i++)
		{
			Stock current = stocks[i];
			htmlString = htmlString + current.getHtmlDescription()+"<br>";
		}
		
		return htmlString;	
	}
}
