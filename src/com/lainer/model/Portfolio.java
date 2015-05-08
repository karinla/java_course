package com.lainer.model;
import com.lainer.*;


/*
  class of portfolio stock */

public class Portfolio {

	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private int sizeOfPortfolio;
	private String title;
	private Stock[] stocks;
	
	
	/*
	 * ctor of portfolio
	 * arrange the portfolio and sets hos maxSize
	 */
	
	public Portfolio(String string) {
		this.title = string;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.sizeOfPortfolio = 0;
	}
	
	/*
	 * copy ctor of of portfolio
	 */
	
	public Portfolio (Portfolio oldPortfolio){
		
		this(oldPortfolio.gettitle());	
		this.sizeOfPortfolio  = oldPortfolio.getSizeOfPortfolio();
		
		copyStocks(oldPortfolio.getStocks(), this.getStocks());	
	}

	/*
	 * copy old stock arry to new one 
	 */
	
	private void copyStocks(Stock[] oldStocks, Stock[] newStocks){ 
		
		for (int i = 0; i < this.sizeOfPortfolio; i++){
			newStocks[i]= new Stock (oldStocks[i]);
		
		}
	}
	
	/*
	 * adds stock to the portfolio arry
	 */
	
	public void addStock(Stock stock){
		
		if(sizeOfPortfolio < MAX_PORTFOLIO_SIZE && stock!=null ){
			stocks[this.sizeOfPortfolio] = stock;
			sizeOfPortfolio++;	
		}
		
		else {
			System.out.println(" Portfolio is Full or stock in NULL ");
		}
	}
	
	/*
	 * removes stock from portfolio arry
	 */
	
	public void removeStock(String stockName){
		
		if (stockName == null)
		{
			System.out.println("The stock is invalid");
			return;
		}
	
		for (int i = 0; i< MAX_PORTFOLIO_SIZE; i++)
		{
			if((this.stocks[i].getSymbol().equals(stockName) == true && stocks[i] != null)){
				if (sizeOfPortfolio != 1){
				stocks[i] = stocks[sizeOfPortfolio-1];
				}else  if (sizeOfPortfolio == 1){
					stocks[i]=null;
				}
				sizeOfPortfolio--;
				System.out.println("Stock deleted");
				return;
			}
		}
		System.out.println("Stock not exist in this Portfolio");
		return;
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
		htmlString = htmlString+"<h1>"+this.gettitle()+"</h1> <br>";
		
		for(int i = 0 ; i < sizeOfPortfolio ; i++)
		{
			Stock current = stocks[i];
			htmlString = htmlString + current.getHtmlDescription()+"<br>";
		}
		
		return htmlString;	
	}
}
