package com.example.faelapp.model;

public class CreditCard {
	
	private int cardNumber;
	private String cardHolder;
	private float balance;
	private int CRC;
	
	public CreditCard(int cardNumber, String cardHolder, float balance) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.balance = balance;
		this.CRC = CRC;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public float getBalance() {
		return balance;		
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getCRC() {
		return CRC;
	}
	public void setCRC(int CRC) {
		this.CRC = CRC;
	}
}
