package com.anupam.microservices.limitsservice.bean;

public class LimitConfiguration {
	private int maximum;
	private int minium;
	public LimitConfiguration(int maximum, int minium) {
		super();
		this.maximum = maximum;
		this.minium = minium;
	}
	
	
	public LimitConfiguration() {
		super();
		
	}


	public int getMaximum() {
		return maximum;
	}


	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}


	public int getMinium() {
		return minium;
	}


	public void setMinium(int minium) {
		this.minium = minium;
	}


	@Override
	public String toString() {
		return "LimitConfiguration [maximum=" + maximum + ", minium=" + minium + "]";
	}
	
	
}
