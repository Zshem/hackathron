package com.example.faelapp.adapters;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faelapp.CardDetailsActivity;
import com.example.faelapp.R;
import com.example.faelapp.model.CreditCard;

public class CreditCardsAdapter extends BaseAdapter  {

	private final List<CreditCard> creditCards;
	private final Map<CreditCard.CardType, Bitmap> images;
	private final Context context;

	public CreditCardsAdapter(Context context, List<CreditCard> creditCards, Map<CreditCard.CardType, Bitmap> images)
	{
		this.creditCards = creditCards;
		this.context = context;
		this.images = images;
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

		OnePictureViewHolder onePicHolder;

		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.layout_cards_list, parent, false);
			onePicHolder = new OnePictureViewHolder();

			onePicHolder.image = (ImageView) row.findViewById(R.id.card_image);
			onePicHolder.text = (TextView) row.findViewById(R.id.card_number);
			row.setTag(onePicHolder);

		} else {
			onePicHolder = (OnePictureViewHolder) row.getTag();
		}

		onePicHolder.image.setImageBitmap(images.get(creditCards.get(index).getCardType()));
		onePicHolder.text.setText(creditCards.get(index).getCardNumber());
		onePicHolder.image.setOnClickListener(new CardDetailsOnClickListener(context, creditCards.get(index)));

		return row;
	}

	static class OnePictureViewHolder {
		ImageView image;
		TextView text;
	}

	class CardDetailsOnClickListener implements OnClickListener {

		private final Context context;
		private final CreditCard card;
		CardDetailsOnClickListener(Context context, CreditCard card) {
			this.context = context;
			this.card = card;
		}
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(context, CardDetailsActivity.class);
			intent.putExtra("Card", card);
			context.startActivity(intent);
		}
	}
}
