package com.example.faelapp.adapters;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faelapp.R;
import com.example.faelapp.model.CreditCard;

public class CreditCardsAdapter extends BaseAdapter  {

	private final List<CreditCard> creditCards;
	private final Context context;
	private final Bitmap image;

	public CreditCardsAdapter(Context context, List<CreditCard> creditCards)
	{
		this.creditCards = creditCards;
		this.context = context;
		image = null;
	}

	@Override
	public int getCount() {
		return creditCards.size();
	}

	@Override
	public Object getItem(int index) {
		return creditCards.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {

		View row = convertView;

		int type = getItemViewType(index);

		OnePictureViewHolder onePicHolder;

		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.layout_cards_list, parent, false);
			onePicHolder = new OnePictureViewHolder();

			onePicHolder.image = (ImageView) row.findViewById(R.id.card_image);
		} else {
			onePicHolder = (OnePictureViewHolder) row.getTag();
		}

		return row;
	}

	static class OnePictureViewHolder {
		ImageView image;
		TextView text;
	}

}
