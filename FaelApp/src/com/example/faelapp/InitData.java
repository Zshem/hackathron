package com.example.faelapp;



import java.util.ArrayList;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.faelapp.model.CreditCard;

public class InitData extends Application {

	public static ArrayList<CreditCard> creditCards;
	public static ArrayList<Bitmap> images;

	private static InitData singleton;

	public InitData getInstance() {
		return singleton;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		setupCreditCards();
		setupImages();
		//System.out.println("RAWR");
	}

	private void setupImages() {
		images = new ArrayList<Bitmap>();
		images.add(BitmapFactory.decodeResource(getResources(), R.drawable.card_plus));

	}

	private void setupCreditCards () {
		creditCards = new ArrayList<CreditCard>();
		creditCards.add(new CreditCard(3698, CreditCard.CardType.MASTER, "Fili Udzak", 150, 569));
		creditCards.add(new CreditCard(7918, CreditCard.CardType.DINERS, "Lolo M.", -2, 824));
		creditCards.add(new CreditCard(1697, CreditCard.CardType.VISA, "Maras Pi", 789542, 350));
	}
}