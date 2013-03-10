package com.example.faelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.faelapp.model.CreditCard;

public class NewCardActivity extends Activity {

	String mSpinnerItems[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_card);
		// Show the Up button in the action bar.
		setupActionBar();


		mSpinnerItems = new String[CreditCard.CardType.NUMBER_OF_CARD_TYPES.ordinal()];
		mSpinnerItems[CreditCard.CardType.DINERS.ordinal()] = "Diners";
		mSpinnerItems[CreditCard.CardType.VISA.ordinal()] = "Visa";
		mSpinnerItems[CreditCard.CardType.MAESTRO.ordinal()] = "Maestro";

 		Spinner spinner = (Spinner) findViewById(R.id.spinner_new_card_type);

 		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mSpinnerItems);

 		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

 		spinner.setAdapter(adapter);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	public void addNewCard(View view) {
		Bundle bundle = new Bundle();
		EditText editAccount = (EditText) findViewById(R.id.edit_new_card_account);
		EditText editHolder = (EditText) findViewById(R.id.edit_new_card_holder);
		EditText editCRC = (EditText) findViewById(R.id.edit_new_card_CRC);
		Spinner spinnerType = (Spinner) findViewById(R.id.spinner_new_card_type);

		if(editAccount.getText().toString().isEmpty() && editHolder.getText().toString().isEmpty() && editCRC.getText().toString().isEmpty()) {
			return;
		}

		bundle.putString("Holder", editHolder.getText().toString());
		bundle.putString("Account", editAccount.getText().toString());
		bundle.putInt("CRC", Integer.parseInt(editCRC.getText().toString()));
		bundle.putInt("Type", spinnerType.getSelectedItemPosition());
		Intent resultIntent = new Intent(this, MainActivity.class);
		resultIntent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_NEW_TASK);
		resultIntent.putExtras(bundle);
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_card, menu);
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

}
