package com.example.faelapp.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.faelapp.InitData;
import com.example.faelapp.R;
import com.example.faelapp.adapters.CreditCardsAdapter;


public class CreditCardFragment extends ListFragment {

	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		setHasOptionsMenu(true);

		CreditCardsAdapter listAdapter = new CreditCardsAdapter(getActivity(), InitData.creditCards);

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