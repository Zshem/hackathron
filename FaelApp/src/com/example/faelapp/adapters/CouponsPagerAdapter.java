package com.example.faelapp.adapters;

import java.util.ArrayList;

import com.example.faelapp.model.Coupon;
import com.viewpagerindicator.IconPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CouponsPagerAdapter extends FragmentStatePagerAdapter implements
		IconPagerAdapter {

	private ArrayList<Coupon> mCoupons;

	public CouponsPagerAdapter(FragmentManager fm, ArrayList<Coupon> coupons) {
		super(fm);
		mCoupons = coupons;
	}

	
	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}



	@Override
	public Fragment getItem(int position) {
		return new PlaceSlideFragment(mCoupons.get(position));
	}

	@Override
	public int getCount() {
		return mCoupons.size();
	}

	@Override
	public int getIconResId(int index) {
		return 0;
	}

}