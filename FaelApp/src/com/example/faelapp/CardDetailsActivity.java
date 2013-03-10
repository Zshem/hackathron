package com.example.faelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faelapp.fragments.CreditCardFragment;
import com.example.faelapp.model.CreditCard;

public class CardDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_details);
		// Show the Up button in the action bar.
		setupActionBar();

		Intent intent = getIntent();

		CreditCard card = (CreditCard) intent.getExtras().get("Card");
		ImageView image = (ImageView) findViewById(R.id.card_details_image);
		TextView account = (TextView) findViewById(R.id.card_details_account);
		TextView holder = (TextView) findViewById(R.id.card_details_holder);
		TextView CRC = (TextView) findViewById(R.id.card_details_CRC);
		TextView balance = (TextView) findViewById(R.id.card_details_balance);

		image.setImageBitmap(CreditCardFragment.images.get(card.getCardType()));
		account.setText(card.getCardNumber());
		holder.setText(card.getCardHolder());
		CRC.setText(Integer.toString(card.getCRC()));
		balance.setText(Float.toString(card.getBalance()));
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
<<<<<<< HEAD
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.card_details, menu);
=======
		menu.add("Delete card").setIcon(R.drawable.card_delete).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_ALWAYS);
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.card_details, menu);

>>>>>>> Finished functionality for credit cards.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent parentActivityIntent = new Intent(this, MainActivity.class);
            parentActivityIntent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(parentActivityIntent);
            finish();
            return true;
		}
		return super.onOptionsItemSelected(item);
	}
<<<<<<< HEAD

=======
>>>>>>> Finished functionality for credit cards.
}
