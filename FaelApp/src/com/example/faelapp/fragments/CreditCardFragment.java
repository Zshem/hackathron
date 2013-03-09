package com.example.faelapp.fragments;

import com.example.faelapp.InitData;
import com.example.faelapp.adapters.CreditCardsAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class CreditCardFragment extends ListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	  super.onActivityCreated(savedInstanceState);
	  
	  setHasOptionsMenu(true); 
	
	  CreditCardsAdapter listAdapter = new CreditCardsAdapter(getActivity(), InitData.creditCards);
	
		// Set the adapter on the ListView holder
		setListAdapter(listAdapter);
	
		ListView lv = getListView();
		
		lv.setDividerHeight(0);
	  
	}
	
	private void setListAdapter(CreditCardsAdapter listAdapter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
		menu.clear();
		super.onPrepareOptionsMenu(menu);
	}
}