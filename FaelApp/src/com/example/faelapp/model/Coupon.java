package com.example.faelapp.model;

public class Coupon {
	
	private String store;
	private String discount;
	private int count;
	
	public Coupon(String store, String discount, int count) {
		super();
		this.store = store;
		this.discount = discount;
		this.count = count;
	}
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
