package com.example.faelapp.fragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dm.zbar.android.scanner.ZBarConstants;
import com.dm.zbar.android.scanner.ZBarScannerActivity;
import com.example.faelapp.R;

public class PayFragment extends Fragment {

	private static int ZBAR_SCANNER_REQUEST = 1;
	private AlertDialog dialog;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_pay, null);
		Button scan = (Button) view.findViewById(R.id.button_pay);

		scan.setOnClickListener(new PayOnClickListener(getActivity()));
		return view;
	}

	@Override
	public void onActivityResult(int requestCode, int returnCode, Intent data) {
		if(requestCode == ZBAR_SCANNER_REQUEST && returnCode == Activity.RESULT_OK) {
			String result = data.getStringExtra(ZBarConstants.SCAN_RESULT);

			String[] split = result.split(";");

			View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_view, null);
			TextView store = (TextView)view.findViewById(R.id.dialog_store);
			store.setText(split[0].toString());
			TextView price = (TextView)view.findViewById(R.id.dialog_price);
			price.setText(split[1].toString());

			dialog = new AlertDialog.Builder(getActivity()).setView(view).create();
			dialog.setTitle("Receipt payment");
			dialog.setButton(Dialog.BUTTON_NEGATIVE, "CANCEL PAYMENT", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface in, int which) {
					Toast.makeText(getActivity(), "Payment cancelled", Toast.LENGTH_LONG).show();
				}
			});

			dialog.setButton(Dialog.BUTTON_POSITIVE, "PAY NOW", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface in, int which) {
					Toast.makeText(getActivity(), "Your have paid for this receipt.\nYou are now poor.", Toast.LENGTH_LONG).show();
				}
			});

			dialog.show();
		}
	}

	class PayOnClickListener implements OnClickListener {

		private final Context context;
		PayOnClickListener(Context context) {
			this.context = context;
		}
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(context, ZBarScannerActivity.class);
			startActivityForResult(intent, ZBAR_SCANNER_REQUEST);
		}
	}

}
