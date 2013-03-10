package com.example.faelapp.model;

import java.io.Serializable;

public class CreditCard implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8171843888791933343L;

	public enum CardType {
		MAESTRO,
		VISA,
		DINERS,
		NUMBER_OF_CARD_TYPES,
		UNIDENTIFIED_CARD
	};

	private String cardNumber;
	private CardType type;
	private String cardHolder;
	private float balance;
	private int CRC;

	public CreditCard(String cardNumber, CardType cardType, String cardHolder, float balance, int CRC) {
		super();
		this.cardNumber = cardNumber;
		this.type = cardType;
		this.cardHolder = cardHolder;
		this.balance = balance;
		this.CRC = CRC;
	}

	public CreditCard () {
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
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
