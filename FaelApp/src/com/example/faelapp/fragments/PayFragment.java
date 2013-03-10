package com.example.faelapp.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dm.zbar.android.scanner.ZBarConstants;
import com.dm.zbar.android.scanner.ZBarScannerActivity;
import com.example.faelapp.R;

public class PayFragment extends Fragment {

	private static int ZBAR_SCANNER_REQUEST = 1;

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
			Toast.makeText(getActivity(), "Scan result = " + data.getStringExtra(ZBarConstants.SCAN_RESULT), Toast.LENGTH_SHORT).show();
			Toast.makeText(getActivity(), "Scan result type = " + data.getStringExtra(ZBarConstants.SCAN_RESULT_TYPE), Toast.LENGTH_SHORT).show();
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
