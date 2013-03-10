package com.example.faelapp.fragments;


import java.util.ArrayList;

import com.dm.zbar.android.scanner.ZBarScannerActivity;

import com.example.faelapp.R;
import com.example.faelapp.adapters.CreditCardsAdapter;
import com.example.faelapp.model.CreditCard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class PayFragment extends Fragment {
	

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		

		return inflater.inflate(R.layout.fragment_pay, null);
		
		//Intent intent = new Intent(this, ZBarScannerActivity.class);
		//startActivityForResult(intent, ZBAR_SCANNER_REQUEST);
	}

}
