package com.example.faelapp.model;

public class Coupon {
	
	public enum CouponType {
		AVAILABLE,
		OWNED
	};	
	
	private String store;
	private String discount;
	private int count;
	private int imageId;
	private CouponType couponType;
	
	public Coupon(String store, String discount, int count, int imageId, CouponType couponType) {
		super();
		this.store = store;
		this.discount = discount;
		this.count = count;
		this.imageId = imageId;
		this.setCouponType(couponType);
	}
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
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
	public CouponType getCouponType() {
		return couponType;
	}
	public void setCouponType(CouponType couponType) {
		this.couponType = couponType;
	}
}
