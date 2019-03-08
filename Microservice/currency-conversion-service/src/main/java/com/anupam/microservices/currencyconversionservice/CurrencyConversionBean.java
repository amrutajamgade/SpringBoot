package com.anupam.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	
		private Long id;
		

		private String from;
		private String to;
		
		private BigDecimal conversionMultiple;
		private BigDecimal quanity;
		private BigDecimal calcualtedAmount;
		
		private int port;
		
		public CurrencyConversionBean() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple,
				BigDecimal quanity, BigDecimal calcualtedAmount, int port) {
			super();
			this.id = id;
			this.from = from;
			this.to = to;
			this.conversionMultiple = conversionMultiple;
			this.quanity = quanity;
			this.calcualtedAmount = calcualtedAmount;
			this.port = port;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		public BigDecimal getConversionMultiple() {
			return conversionMultiple;
		}

		public void setConversionMultiple(BigDecimal conversionMultiple) {
			this.conversionMultiple = conversionMultiple;
		}

		public BigDecimal getQuanity() {
			return quanity;
		}

		public void setQuanity(BigDecimal quanity) {
			this.quanity = quanity;
		}

		public BigDecimal getCalcualtedAmount() {
			return calcualtedAmount;
		}

		public void setCalcualtedAmount(BigDecimal calcualtedAmount) {
			this.calcualtedAmount = calcualtedAmount;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}
		
		
	
}
