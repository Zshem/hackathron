package com.example.faelapp;



import com.example.faelapp.model.CreditCard;

import android.app.Application;

public class InitData extends Application {
	
	public static CreditCard creditCards[];
	
	private static InitData singleton;

	public InitData getInstance() {
		return singleton;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		setupCreditCards();
		//System.out.println("RAWR");
	}
	
	private void setupCreditCards () {
		creditCards = new CreditCard[3];
		creditCards[0] = new CreditCard(3698, CreditCard.CardType.MASTER, "Fili Udzak", 150, 569);
		creditCards[1] = new CreditCard(7918, CreditCard.CardType.DINERS, "Lolo M.", -2, 824);
		creditCards[2] = new CreditCard(1697, CreditCard.CardType.VISA, "Maras Pi", 789542, 350);
		
		
	}
}