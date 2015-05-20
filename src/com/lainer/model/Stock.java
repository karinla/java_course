package com.lainer.model;
import java.text.*;
import java.util.*;
import com.lainer.model.Portfolio.ALGO_RECOMMENDATION;

/*
 * class that shows stock of Stocks
 */

public class Stock {
	
	
	private String symbol;
	private float ask;
	private float bid;
	private ALGO_RECOMMENDATION recommendation;
	private java.util.Date date;
	
	private int stockQuantity;
	
	private SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");

/*
 *  ctor of stock
 */
	
	public Stock (String newSymbol, float newAsk, float newBid, Date newDate){
		this.symbol = newSymbol;
		this.bid = newBid;
		this.ask = newAsk;
		this.date = newDate;
		this.recommendation = ALGO_RECOMMENDATION.HOLD;
		this.stockQuantity = 0;
		
	}
	
	/*
	 * copy ctor of stock
	 */
	
	public Stock (Stock oldStock)
	{
		
		this(oldStock.getSymbol(),oldStock.getBid(),oldStock.getAsk(),new Date(oldStock.getDate().getTime()));
		this.recommendation = oldStock.getRecommendation();
		this.stockQuantity = oldStock.getStockQuantity();
	}
	
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}
	
		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public float getBid() {
			return bid;
		}

		public void setBid(float bid) {
			this.bid = bid;
		}

		public float getAsk() {
			return ask;
		}

		public void setAsk(float ask) {
			this.ask = ask;
		}

		public java.util.Date getDate() {
			return date;
		}

		public void setDate(java.util.Date date) {
			this.date = date;
		}
		
		public SimpleDateFormat getfd() {
			return fd;
		}

		public void setfd(SimpleDateFormat fd) {
			this.fd = fd;
		}
		
		public int getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}

		public String getHtmlDescription(){
			
			return "<br><b>Stock symbol: </b>"+this.getSymbol()+" <b>ask: </b>"+this.getAsk()+"<b> bid: </b>"+this.getBid()+
					"<b> date: </b>"+fd.format(this.getDate())  ; 
			
			
		}
}