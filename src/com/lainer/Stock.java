package com.lainer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	
	
	private String symbol;
	private float ask;
	private float bid;
	private java.util.Date date;
	
	private int recommendation;
	private int stockQuantity;
	
	private static final int BUY = 0;
	private static final int SELL = 1;
	private static final int REMOVE = 2;
	private static final int HOLD = 3;
	
	private SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");


	public Stock (String symbol, float ask, float bid, Date date){
		this.symbol = symbol;
		this.bid = bid;
		this.ask = ask;
		this.date = date;
		this.recommendation = 0;
		this.stockQuantity = 0;
		
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
		
		public int getRecommendation() {
			return recommendation;
		}
		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
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