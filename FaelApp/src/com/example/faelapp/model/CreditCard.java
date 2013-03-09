package com.example.faelapp.model;

public class CreditCard {
	
	public enum CardType {
		MASTER,
		VISA,
		DINERS
	};
	
	private int cardNumber;
	private CardType type; 
	private String cardHolder;
	private float balance;
	private int CRC;
	
	public CreditCard(int cardNumber, CardType cardType, String cardHolder, float balance, int CRC) {
		super();
		this.cardNumber = cardNumber;
		this.type = cardType;
		this.cardHolder = cardHolder;
		this.balance = balance;
		this.CRC = CRC;
	}
	
	public CreditCard () { 
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public CardType getCardType() {
		return type;
	}
	public void setCardType(CardType cardType) {
		this.type = cardType;
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
