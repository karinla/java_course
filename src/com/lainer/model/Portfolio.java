package com.lainer.model;
import com.lainer.*;

import java.text.DecimalFormat;



/*
  class of portfolio stock */

public class Portfolio {

	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	public enum ALGO_RECOMMENDATION {
		BUY, SELL, REMOVE, HOLD 
	}
	
	private int sizeOfPortfolio;
	private String title;
	private Stock[] stocks;
	private float balance;

	
	/*
	 * ctor of portfolio
	 * arrange the portfolio and sets hos maxSize
	 */
	
	public Portfolio(String string) {
		this.title = string;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.sizeOfPortfolio = 0;
		this.balance = 0;
	}
	
	/*
	 * copy ctor of of portfolio
	 */
	
	public Portfolio (Portfolio oldPortfolio){
		
		this(oldPortfolio.gettitle());	
		this.sizeOfPortfolio  = oldPortfolio.getSizeOfPortfolio();
		this.updateBalance(oldPortfolio.getBalance());
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
		
		if(sizeOfPortfolio == MAX_PORTFOLIO_SIZE ){
			System.out.println("Can’t add new stock, portfolio can have only "+this.sizeOfPortfolio+" stocks”");
			return;		
		} 
		else if (stock == null){
			System.out.println("There is an error with the stock you enter!");
			return;
		}
		else { 
			for(int i = 0; i < this.sizeOfPortfolio; i++){
				if(stock.getSymbol().equals(this.stocks[i].getSymbol())){
					System.out.println("Stock already exists in portfolio");
					return;
			}
		}		
	}
			
			
			stocks[this.sizeOfPortfolio] = stock;
			stocks[this.sizeOfPortfolio].setStockQuantity(0);
			this.sizeOfPortfolio++;
			return;
		}
		
	
	/*
	 * removes stock from portfolio arry
	 */
	
	public boolean removeStock(String stockName){
		
		if (stockName == null)
		{
			System.out.println("The stock is invalid");
			return false;
		}
	
for(int i = 0; i< this.sizeOfPortfolio; i++){
			
			if((this.stocks[i].getSymbol().equals(stockName) == true)){
				if (sizeOfPortfolio > 1){
					this.sellStock(stocks[i].getSymbol(), -1);
					stocks[i] = stocks[this.sizeOfPortfolio-1];
					stocks[this.sizeOfPortfolio-1]=null;
					
				}else  if (this.sizeOfPortfolio == 1){
					this.sellStock(stocks[i].getSymbol(), -1);
					stocks[i]=null;
				}
				sizeOfPortfolio--;
				System.out.println("Stock "+stockName+" was deleted as per request");
				return true;
			}
		}
		
		System.out.println("Stock not exist in this Portfolio");
		return false;
	}
	
	
	public boolean sellStock(String symbol, int quantity){
		
		if(symbol == null || quantity < -1){
			System.out.println("There is an error! Please check your stock symbol or stock quntity.");
			return false;
		}
		
		for(int i = 0; i< this.sizeOfPortfolio; i++){

			if(this.stocks[i].getSymbol().equals(symbol) == true){

				if(this.stocks[i].getStockQuantity() - quantity < 0)
				{
					System.out.println("Not enough stocks to sell");
					return false;	}
				
				else if(quantity == -1)
				{
					this.updateBalance(this.stocks[i].getStockQuantity()*this.stocks[i].getBid());
					this.stocks[i].setStockQuantity(0);
					System.out.println("Entire stock ("+symbol+") holdings was sold succefully");
					return true;

				}else {
					this.updateBalance(quantity*this.stocks[i].getBid());
					this.stocks[i].setStockQuantity(stocks[i].getStockQuantity()-quantity);
					System.out.println("An amount of "+quantity+" of stock ("+symbol+") was sold succefully");
					return true;
				}
			}

		}
		System.out.println("Stock was not found in this Portfolio");
		return false; 
	}
	
	
	public boolean buyStock(Stock stock, int quantity){
		int i = 0;
		if(stock == null || quantity < -1){
			System.out.println(" error, Please check your stock symbol or stock quntity.");
			return false;
		}
		if(quantity*stock.getAsk() > this.balance){
			System.out.println("Not enough balance to complete purchase.");
			return false;
		}
		for(i = 0; i< this.sizeOfPortfolio; i++){
			
			if(this.stocks[i].getSymbol().equals(stock.getSymbol()) == true){
				
				if(quantity == -1){
					int numOfStockToBuy = (int)this.balance/(int)this.stocks[i].getAsk();
					this.updateBalance(-numOfStockToBuy*this.stocks[i].getAsk());
					this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity()+numOfStockToBuy);
					System.out.println( "was bought succefully.");
					return true;

				}else {
					this.updateBalance(-quantity*this.stocks[i].getAsk());
					this.stocks[i].setStockQuantity(stocks[i].getStockQuantity()+quantity);
					System.out.println("An amount of "+quantity+" stock ("+stock.getSymbol()+") was bought succefully");
					return true;
				}
			}

		}
		
		if(i == MAX_PORTFOLIO_SIZE){
			System.out.println("The portfolio has reached it's maximum stock capacity.");
			return false;
		}

		if (quantity == -1){
			this.addStock(stock);
			int howManyToBuy = (int)this.balance/(int)this.stocks[i].getAsk();
			this.updateBalance(-(howManyToBuy*this.stocks[this.sizeOfPortfolio-1].getAsk()));
			this.stocks[i].setStockQuantity(this.stocks[this.sizeOfPortfolio-1].getStockQuantity()+howManyToBuy);
			System.out.println( "was bought succefully.");
			return true;
		} else {
			this.addStock(stock); 
			this.updateBalance(-quantity*this.stocks[sizeOfPortfolio -1].getAsk());
			this.stocks[this.sizeOfPortfolio -1].setStockQuantity(quantity);
			System.out.println("Stock "+stock.getSymbol()+" was added successfuly to the portfolio. With quantity of "
					+ quantity+" stocks.");
			return true;

		}
	}	

	public float getStocksValue(){
		float totalValue =0;
		for(int i = 0; i<this.sizeOfPortfolio ;i++){
			totalValue += this.stocks[i].getStockQuantity()*this.stocks[i].getBid();
		}
		return totalValue;		
	}
	
	
	public float getTotalValue(){
		return this.getStocksValue()+this.balance;		
	}
	
	
	public void updateBalance (float amount){
		float currentBalance = this.balance + amount;
		if(currentBalance < 0){
			System.out.println("Please note you canot change balance to negative amount!");
		}else {
			this.balance = currentBalance;
			System.out.println("Balance has been updated to "+ this.balance);
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
	
	public float getBalance() {
		return balance;
	}
	public String getHtmlString(){
		
		String htmlResString = new String();
		htmlResString = htmlResString+"<h1>"+this.gettitle()+"</h1> <br>";
		
		for(int i=0; i<sizeOfPortfolio; i++)
		{
			Stock tempStock = stocks[i];
			if (tempStock != null){
				htmlResString = htmlResString + tempStock.getHtmlDescription()+"<br>";
			}
		}
		htmlResString += "Total Portfolio Value :"+this.getTotalValue()+ "$, <br>" + 
		"Total Stocks Value :"+this.getStocksValue()+"$,<br> "+"Balance :"+this.balance+"$.";
		return htmlResString;	
	}
	
}
