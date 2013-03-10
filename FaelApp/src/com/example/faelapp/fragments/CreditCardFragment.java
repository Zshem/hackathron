package com.example.faelapp.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.faelapp.NewCardActivity;
import com.example.faelapp.R;
import com.example.faelapp.adapters.CreditCardsAdapter;
import com.example.faelapp.model.CreditCard;


public class CreditCardFragment extends ListFragment {

	private static int NEW_CARD_REQUEST = 1;
	private List<CreditCard> creditCards;
	public static Map<CreditCard.CardType, Bitmap> images;
	private CreditCardsAdapter listAdapter;

	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		images = new HashMap<CreditCard.CardType, Bitmap>();
		images.put(CreditCard.CardType.UNIDENTIFIED_CARD, BitmapFactory.decodeResource(getResources(), R.drawable.card_plus));
		images.put(CreditCard.CardType.DINERS, BitmapFactory.decodeResource(getResources(), R.drawable.card_diners));
		images.put(CreditCard.CardType.VISA, BitmapFactory.decodeResource(getResources(), R.drawable.card_visa));
		images.put(CreditCard.CardType.MAESTRO, BitmapFactory.decodeResource(getResources(), R.drawable.card_maestro));

		creditCards = new ArrayList<CreditCard>();
		creditCards.add(new CreditCard("3698", CreditCard.CardType.MAESTRO, "Fili Udzak", 150, 569));
		creditCards.add(new CreditCard("7918", CreditCard.CardType.DINERS, "Lolo M.", -2, 824));
		creditCards.add(new CreditCard("1697", CreditCard.CardType.VISA, "Maras Pi", 789542, 350));

		setHasOptionsMenu(true);

		listAdapter = new CreditCardsAdapter(getActivity(), creditCards, images);

		//Set the adapter on the ListView holder
		setListAdapter(listAdapter);

		ListView lv = getListView();

		lv.setDividerHeight(0);

	  }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater.inflate(R.layout.layout_cards_list, null);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    if(item.getTitle().equals("Add Card")) {
	    	Intent newCardIntent = new Intent(getActivity(), NewCardActivity.class);
	    	startActivityForResult(newCardIntent, NEW_CARD_REQUEST);
	    	return true;
	    }
	    return false;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // Check which request we're responding to
	    if (requestCode == NEW_CARD_REQUEST) {
	        // Make sure the request was successful
	        if (resultCode == Activity.RESULT_OK) {
	            // The user picked a contact.
	            // The Intent's data Uri identifies which contact was selected.

	        	Bundle bundle = data.getExtras();
	        	String cardAccount = bundle.getString("Account");
	        	String cardHolder = bundle.getString("Holder");
	        	int cardCRC = bundle.getInt("CRC");
	        	CreditCard.CardType type = CreditCard.CardType.values()[bundle.getInt("Type")];

	        	CreditCard newCard = new CreditCard(cardAccount, type, cardHolder, 0, cardCRC);
	        	creditCards.add(newCard);
	        	listAdapter.notifyDataSetChanged();
	        }
	    }
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {

		menu.clear();
		menu.add("Add Card").setIcon(R.drawable.card_plus).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add("Refresh").setIcon(R.drawable.ic_launcher).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		super.onPrepareOptionsMenu(menu);
	}
}