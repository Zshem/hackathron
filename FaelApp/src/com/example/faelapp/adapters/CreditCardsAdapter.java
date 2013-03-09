package com.example.faelapp.adapters;

import com.example.faelapp.model.CreditCard;
import com.filippudak.fiestatime.model.Film;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CreditCardsAdapter extends BaseAdapter  {
	
	private CreditCard[] creditCards;
	private Context context;
	private Bitmap[] images;
	private int elementPosition;
	
	public CreditCardsAdapter(Context context, CreditCard[] creditCards, Bitmap[] images)
	{
		this.creditCards = creditCards;
		this.context = context;
		this.images = images;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
