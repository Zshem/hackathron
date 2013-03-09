package com.example.faelapp.fragments;

import java.util.ArrayList;
import java.util.List;

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
	private ArrayList<Bitmap> images;
	private CreditCardsAdapter listAdapter;

	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		images = new ArrayList<Bitmap>();
		images.add(BitmapFactory.decodeResource(getResources(), R.drawable.card_plus));

		creditCards = new ArrayList<CreditCard>();
		creditCards.add(new CreditCard(3698, CreditCard.CardType.MASTER, "Fili Udzak", 150, 569));
		creditCards.add(new CreditCard(7918, CreditCard.CardType.DINERS, "Lolo M.", -2, 824));
		creditCards.add(new CreditCard(1697, CreditCard.CardType.VISA, "Maras Pi", 789542, 350));

		setHasOptionsMenu(true);

		listAdapter = new CreditCardsAdapter(getActivity(), creditCards);

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

	public void showCardDetails(View view) {

	}

	public void addNewCard(View view) {

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
	        	int cardAccount = bundle.getInt("Account");
	        	String cardHolder = bundle.getString("Holder");
	        	int cardCRC = bundle.getInt("CRC");

	        	CreditCard newCard = new CreditCard(cardAccount, CreditCard.CardType.MASTER, cardHolder, 0, cardCRC);
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