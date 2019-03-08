package com.anupam.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.el.lang.ELArithmetic.BigDecimalDelegate;

/**
 * @author ANUPAMBA
 *
 */

@Entity
public class ExchangeValue {
	
	@Id
	private Long id;	
	
	@Column(name="CURRENCY_FROM")
	private String from;
	@Column(name="CURRENCY_TO")
	private String to;
	private BigDecimal conversionMultiple;
	private int port;
	
	
	public ExchangeValue() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
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


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", port=" + port + "]";
	}
	
	
	
	
}
