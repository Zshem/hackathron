package com.example.faelapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.faelapp.R;

public class BaseFragment extends Fragment {

	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);

	  }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater.inflate(R.layout.activity_main, null);

		return super.onCreateView(inflater, container, savedInstanceState);
	}



}
