package com.example.faelapp.adapters;

import com.example.faelapp.fragments.CreditCardFragment;
import com.example.faelapp.fragments.PayFragment;
import com.example.faelapp.fragments.SwipeItemFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SwipeCollectionPagerAdapter extends FragmentStatePagerAdapter  {
	
	String[] swipeNames = { "Pay", "Cards", "Coupons", "Transactions" };
	
//	string[0] =	"Pay";
//	string[1] = "Cards";
//	string[2] = "Cuopons";
//	string[3] = "Transactions";
//	
	
	public SwipeCollectionPagerAdapter(FragmentManager fm) {
	    super(fm);
	}
	
	@Override
	public Fragment getItem(int i) {
		//Fragment fragment = null;
		switch(i) {
		case 0:
			return new PayFragment();
		case 1:
			return new CreditCardFragment();
		default:
			return new SwipeItemFragments();
		}
		
	}
	
	@Override
	public int getCount() {
	    return swipeNames.length;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
	    return swipeNames[position];
	}
	
	

}
